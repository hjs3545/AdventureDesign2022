package com.example.FOODCHEAP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class productDetail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);

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
    }
}
