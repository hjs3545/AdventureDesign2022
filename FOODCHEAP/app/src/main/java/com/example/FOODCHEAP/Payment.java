package com.example.FOODCHEAP;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Payment extends AppCompatActivity {
    DBHelper dbHelper;
    SQLiteDatabase database;

    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

        DecimalFormat decFormat = new DecimalFormat("###,###");
        Intent intent = getIntent();
        int TotalPrice = intent.getExtras().getInt("TotalPrice");

        dbHelper = new DBHelper(this, 1);

        TextView totalPrice = (TextView) findViewById(R.id.TotalPrice2);
        totalPrice.setText(decFormat.format(TotalPrice) + "원");

        Button backButton = (Button) findViewById(R.id.backButton3);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), shopping_cart.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in, R.anim.slow_right_out);
            }
        });

        Button PayButton = (Button) findViewById(R.id.payButton);
        PayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                database = dbHelper.getWritableDatabase();
                dbHelper.onUpgrade(database,1, 2);
                Intent intent = new Intent(getApplicationContext(), CompletePayment.class);
                intent.putExtra("TotalPrice", TotalPrice);
                startActivity(intent);
                overridePendingTransition(R.anim.none, R.anim.none);
            }
        });
    }
}
