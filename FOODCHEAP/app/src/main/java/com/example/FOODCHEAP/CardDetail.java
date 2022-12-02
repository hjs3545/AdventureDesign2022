package com.example.FOODCHEAP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CardDetail extends AppCompatActivity {
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_detail);

        Intent intent = getIntent();

        TextView cardname = (TextView) findViewById(R.id.textViewCardName);
        TextView cardnumber = (TextView) findViewById(R.id.textViewCardNumber);
        TextView validthru = (TextView) findViewById(R.id.textViewValidThru);
        TextView cvc = (TextView) findViewById(R.id.textViewCVC);

        cardname.setText(intent.getExtras().getString("CardName"));
        cardnumber.setText(intent.getExtras().getString("CardNumber"));
        validthru.setText(intent.getExtras().getString("ValidThru"));
        cvc.setText(Integer.toString(intent.getExtras().getInt("CVC")));

        Button backButton = (Button) findViewById(R.id.backButton5);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent INTENT = new Intent(getApplicationContext(), wallet.class);
                startActivity(INTENT);
            }
        });
    }
}
