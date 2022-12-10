package com.example.FOODCHEAP;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class check_address extends AppCompatActivity {

    TextView address, address2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_address);

        Button back = findViewById(R.id.backButton);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), search_address.class);
                startActivity(intent);
            }
        });

        Button next = findViewById(R.id.button1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), user_page.class);
                startActivity(intent);
            }
        });

        address = findViewById(R.id.textView8);
        address2 = findViewById(R.id.textView);

        address.setText(search_address.savelocation.addressl);
        address2.setText(search_address.savelocation.detadr);
    }
}
