package com.example.FOODCHEAP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class explain1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explain1);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), explain2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.slow_left_out);
            }

        });

        TextView skip = (TextView) findViewById(R.id.textView3);
        skip.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), login.class);
               startActivity(intent);
               overridePendingTransition(0, 0);
           }
        });
    }

}