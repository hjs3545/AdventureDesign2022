package com.example.FOODCHEAP;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class shop_information extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_information);

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), user_page.class);
                startActivity(intent);
            }
        });

        /* TextView milk_text = (TextView) findViewById(R.id.textView29);
        milk_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), milk.class);
                startActivity(intent);
            }
        }); */

        //스크롤 뷰 우유의 상세 정보 눌렀을때 우유 화면으로 넘어가는 부분
        //우유화면으로 넘어가서 뒤로가기 버튼을 누르면 유저화면으로 넘어가서 아직 구현 X
    }
}
