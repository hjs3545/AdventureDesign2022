package com.example.FOODCHEAP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class tofu_detail extends AppCompatActivity {

    ImageButton heart;
    boolean isFill = true;

    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tofu_detail);

        ImageButton back = findViewById(R.id.buttonback);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), user_page.class);
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
