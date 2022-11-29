package com.example.FOODCHEAP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class shred_cheese_detail extends AppCompatActivity {

    ImageButton heart;
    boolean isFill = true;

    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shred_cheese_detail);

        ImageButton back = findViewById(R.id.buttonback);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), shop_information.class);
                startActivity(intent);
            }
        });

        heart = findViewById(R.id.heart);
        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFill==true){
                    heart.setImageResource(R.drawable.fill_heart);
                    isFill=false;
                }
                else{
                    heart.setImageResource(R.drawable.heart);
                    isFill=true;
                }

            }
        });

        if(savedInstanceState != null)
        {
            isFill = savedInstanceState.getBoolean("true");
        }

    }
}
