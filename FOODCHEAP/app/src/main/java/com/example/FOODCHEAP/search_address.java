package com.example.FOODCHEAP;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

public class search_address extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    SupportMapFragment mapFragment;
    GoogleMap map;
    Button back, search;
    Button next;
    EditText editText, det_adr;
    TextView address;
    String addressline;

    MarkerOptions myMarker;

    public static class savelocation{
        public static String addressl = "";
        public static String detadr = "";
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_address);

        editText = findViewById(R.id.editText);
        det_adr = findViewById(R.id.editText2);
        search = findViewById(R.id.search);
        back = findViewById(R.id.backButton);
        next = findViewById(R.id.button1);
        address = findViewById(R.id.address);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), user_page.class);
                startActivity(intent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), check_address.class);
                startActivity(intent);
                savelocation.detadr = det_adr.getText().toString();
            }
        });

        //지도 프래그먼트 설정
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.d(TAG, "onMapReady: ");
                map = googleMap;
                search.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (editText.getText().toString().length() > 0) {
                            Location location = getLocationFromAddress(getApplicationContext(), editText.getText().toString());

                            showCurrentLocation(location);

                            address.setText(addressline);
                        }
                    }
                });
            }
        });
        MapsInitializer.initialize(this);

    }

    private Location getLocationFromAddress(Context context, String address) {
        Geocoder geocoder = new Geocoder(context, Locale.KOREA);
        List<Address> addresses;
        Location resLocation = new Location("");
        try {
            addresses = geocoder.getFromLocationName(address, 5);
            if ((addresses == null) || (addresses.size() == 0)) {
                return null;
            }
            Address addressLoc = addresses.get(0);

            resLocation.setLatitude(addressLoc.getLatitude());
            resLocation.setLongitude(addressLoc.getLongitude());

            addressline = addressLoc.getAddressLine(0);
            savelocation.addressl = addressLoc.getAddressLine(0);

            Log.i("addressinfo","address:"+addressLoc.getAddressLine(0));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resLocation;
    }

    private void requestMyLocation() {
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try {
            long minTime = 1000;    //갱신 시간
            float minDistance = 0;  //갱신에 필요한 최소 거리

            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    showMyMarker(location);
                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }
            });
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    private void showCurrentLocation(Location location) {
        LatLng curPoint = new LatLng(location.getLatitude(), location.getLongitude());

        //화면 확대, 숫자가 클수록 확대
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 17));

        //마커 찍기
        Location targetLocation = new Location("");
        targetLocation.setLatitude(location.getLatitude());
        targetLocation.setLongitude(location.getLongitude());
        showMyMarker(targetLocation);
    }


    private void showMyMarker(Location location) {
        myMarker = new MarkerOptions();
        if (myMarker == null) {
            myMarker.position(new LatLng(location.getLatitude(), location.getLongitude()));
            myMarker.title("◎ 배달 주소\n");
            myMarker.snippet(addressline);
            map.addMarker(myMarker);
        }else{
            map.clear();
            myMarker.position(new LatLng(location.getLatitude(), location.getLongitude()));
            myMarker.title("◎ 배달 주소\n");
            myMarker.snippet(addressline);
            map.addMarker(myMarker);
        }
    }
}