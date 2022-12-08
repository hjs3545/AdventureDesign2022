package com.example.FOODCHEAP;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class shopping_cart extends AppCompatActivity {
    DBHelper dbHelper;
    SQLiteDatabase database;
    List<product> ProductList;
    RecyclerView recyclerView;
    cart_productAdapter adapter;

    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart);

        DecimalFormat decFormat = new DecimalFormat("###,###");

        dbHelper = new DBHelper(this, 1);
        ProductList = dbHelper.selectAll();
        recyclerView = (RecyclerView) findViewById(R.id.productList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new cart_productAdapter(ProductList, dbHelper);
        recyclerView.setAdapter(adapter);

        TextView productCount = (TextView) findViewById(R.id.ProductCount);
        productCount.setText(adapter.getItemCount() + "개의 항목");

        TextView totalPrice = (TextView) findViewById(R.id.totalPrice);
        totalPrice.setText(decFormat.format(adapter.getTotalPrice()) + "원");

        TextView shopName = (TextView) findViewById(R.id.shoppingCartShopName);
        TextView emptyText = (TextView) findViewById(R.id.EmptyText);
        if (adapter.getItemCount() == 0) {
            shopName.setText("");
            emptyText.setText("상품이 담겨있지 않습니다.");
        }
        else {
            shopName.setText("쿠키네 식료품");
            emptyText.setText("");
        }

        Button clearShoppingCart = (Button) findViewById(R.id.button13);
        clearShoppingCart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                database = dbHelper.getWritableDatabase();
                dbHelper.onUpgrade(database, 1, 2);
                adapter.notifyDataSetChanged();
                finish();
                Intent intent = new Intent(getApplicationContext(), shopping_cart.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                Toast.makeText(getApplicationContext(), "장바구니를 비웠습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        Button BuyNow = (Button) findViewById(R.id.BuyNow);
        if (adapter.getItemCount() != 0) {
            BuyNow.setClickable(true);
            BuyNow.setBackgroundResource(R.drawable.buy_now);
            BuyNow.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), Payment.class);
                    intent.putExtra("TotalPrice", adapter.getTotalPrice());
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_in, R.anim.slow_left_out);
                }
            });
        }
        else {
            BuyNow.setClickable(false);
            BuyNow.setBackgroundResource(R.drawable.buy_now_gray);
        }

        RadioButton home = (RadioButton) findViewById(R.id.shoppingCartToHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), user_page.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        RadioButton wallet = (RadioButton) findViewById(R.id.shoppingCartToWallet);
        wallet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), wallet.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        RadioButton myPage = (RadioButton) findViewById(R.id.shoppingCartToMyPage);
        myPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), my_page_customer.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }
}
