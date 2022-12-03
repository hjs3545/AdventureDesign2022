package com.example.FOODCHEAP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class CompletePayment extends AppCompatActivity {
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complete_payment);

        DecimalFormat decFormat = new DecimalFormat("###,###");

        Intent intent = getIntent();
        int TotalPrice = intent.getExtras().getInt("TotalPrice");

        TextView totalPrice = (TextView) findViewById(R.id.TotalPrice3);
        totalPrice.setText(decFormat.format(TotalPrice) + "원");

        Button Confirm = (Button) findViewById(R.id.confirmButton);
        Confirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), user_page.class);
                startActivity(intent);
            }
        });
    }
}
