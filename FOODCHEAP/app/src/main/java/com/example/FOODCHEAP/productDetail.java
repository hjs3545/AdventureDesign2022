package com.example.FOODCHEAP;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class productDetail extends AppCompatActivity {
    public cart_productAdapter ADAPTER;
    public List<product> ProductList;
    DBHelper dbHelper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);

        dbHelper = new DBHelper(this, 1);

        Intent intent = getIntent();
        String ShopName = intent.getExtras().getString("ShopName");
        int ImageID = intent.getExtras().getInt("ImageID");
        String Price1 = intent.getExtras().getString("Price1");
        String Price2 = intent.getExtras().getString("Price2");
        String DiscountRate = intent.getExtras().getString("DiscountRate");
        String ProductName = intent.getExtras().getString("ProductName");
        String Explain = intent.getExtras().getString("Explain");
        String Date = intent.getExtras().getString("Date");
        int Stock = intent.getExtras().getInt("Stock");
        String Case = intent.getExtras().getString("Case");

        TextView shopName = (TextView) findViewById(R.id.textViewShopName);
        ImageView image = (ImageView) findViewById(R.id.productImageView);
        TextView price1 = (TextView) findViewById(R.id.textViewProductPrice1);
        TextView price2 = (TextView) findViewById(R.id.textViewProductPrice2);
        TextView discountRate = (TextView) findViewById(R.id.textViewDiscountRate);
        TextView productName = (TextView) findViewById(R.id.textViewProductName);
        TextView explain = (TextView) findViewById(R.id.textViewProductExplain);
        TextView date = (TextView) findViewById(R.id.textViewDate);
        TextView stock = (TextView) findViewById(R.id.textViewNumber);

        shopName.setText(ShopName);
        image.setImageResource(ImageID);
        price1.setText(Price1);
        price2.setText(Price2);
        discountRate.setText(DiscountRate);
        productName.setText(ProductName);
        explain.setText(Explain);
        date.setText(Date);
        stock.setText(Integer.toString(Stock));

        Button addToCartButton = (Button) findViewById(R.id.addButton);
        Button buyButton = (Button) findViewById(R.id.buyButton);
        Button backButton = (Button) findViewById(R.id.backButton);

        if (Case.equals("UserPage")) {
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), user_page.class);
                    startActivity(intent);
                }
            });
        }
        else if (Case.equals("ShopInformation")) {
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), shop_information.class);
                    startActivity(intent);
                }
            });
        }

        Button AddButton = (Button) findViewById(R.id.addButton);
        AddButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                database = dbHelper.getWritableDatabase();
                dbHelper.insert(ImageID, ProductName, Price2);
                Toast.makeText(getApplicationContext(), "장바구니에 추가됨", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
