package com.example.FOODCHEAP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class my_page_customer extends AppCompatActivity {
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_page_customer);

        RadioButton home = (RadioButton) findViewById(R.id.myPageToHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), user_page.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        RadioButton shoppingCart = (RadioButton) findViewById(R.id.myPageToShoppingCart);
        shoppingCart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), shopping_cart.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        RadioButton myPage = (RadioButton) findViewById(R.id.myPageToWallet);
        myPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), wallet.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }
}
