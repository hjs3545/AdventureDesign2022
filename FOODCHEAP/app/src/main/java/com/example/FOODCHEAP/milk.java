package com.example.FOODCHEAP;

import android.os.PersistableBundle;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class milk extends AppCompatActivity {

    ImageButton heart;
    boolean isFill = true;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.milk);

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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState);


    }
}
