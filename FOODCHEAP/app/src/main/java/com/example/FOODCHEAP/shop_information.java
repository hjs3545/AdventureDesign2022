package com.example.FOODCHEAP;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class shop_information extends AppCompatActivity {
    public ArrayList<product> ProductList;
    public RecyclerView recyclerView;
    public productAdapter ADAPTER;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_information);

        AddData();

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewCatalog);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        recyclerView.setAdapter(ADAPTER);

        Button back = (Button) findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), user_page.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in, R.anim.slow_right_out);
            }
        });

        RadioButton r1 = (RadioButton) findViewById(R.id.dailyProduct);
        RadioButton r2 = (RadioButton) findViewById(R.id.fruit);
        RadioButton r3 = (RadioButton) findViewById(R.id.vegetable);
        RadioButton r4 = (RadioButton) findViewById(R.id.frozen);
        RadioButton r5 = (RadioButton) findViewById(R.id.meat);

        r1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                r1.setTextSize(20);
                r1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                r2.setTextSize(15);
                r2.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                r3.setTextSize(15);
                r3.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                r4.setTextSize(15);
                r4.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                r5.setTextSize(15);
                r5.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                r1.setTextSize(15);
                r1.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                r2.setTextSize(20);
                r2.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                r3.setTextSize(15);
                r3.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                r4.setTextSize(15);
                r4.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                r5.setTextSize(15);
                r5.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            }
        });

        r3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                r1.setTextSize(15);
                r1.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                r2.setTextSize(15);
                r2.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                r3.setTextSize(20);
                r3.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                r4.setTextSize(15);
                r4.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                r5.setTextSize(15);
                r5.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            }
        });

        r4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                r1.setTextSize(15);
                r1.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                r2.setTextSize(15);
                r2.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                r3.setTextSize(15);
                r3.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                r4.setTextSize(20);
                r4.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                r5.setTextSize(15);
                r5.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            }
        });

        r5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                r1.setTextSize(15);
                r1.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                r2.setTextSize(15);
                r2.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                r3.setTextSize(15);
                r3.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                r4.setTextSize(15);
                r4.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                r5.setTextSize(20);
                r5.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            }
        });
    }

    private void AddData() {
        ProductList = new ArrayList<>();

        ProductList.add(new product("????????? ?????????", R.drawable.seoul_milk, 3200, 2200, "-31%", "???????????? 1.8L", "???????????? 1??????, ????????? 1A", "~12/10", 10));
        ProductList.add(new product("????????? ?????????", R.drawable.shred_cheese,  6900, 5000, "-28%", "????????? ???????????? 300g", "?????? ????????? ????????? ??????", "~12/23", 7));
        ProductList.add(new product("????????? ?????????", R.drawable.butter, 6100, 4500, "-27%", "?????? ?????? 240g", "????????? ?????? ????????? ?????? ?????? ????????? 100%??? ????????? ??????", "~1/3", 14));
        ProductList.add(new product("????????? ?????????", R.drawable.yogurt,  2980, 2000, "-33%", "????????? ????????? 85g x 4", "2000??? ?????????????????????", "~12/12", 4));
        ProductList.add(new product("????????? ?????????", R.drawable.bananamilk, 9800, 7350, "-25%", "????????? ???????????? ?????? 8??????", "?????? ?????? ???????????? ?????? ????????? ??????", "~12/5", 12));

        ADAPTER = new productAdapter(ProductList);
        ADAPTER.setOnItemClickListener(new productAdapter.OnItemClickEventListener() {
            @Override
            public void onItemClick(View v, int position) {
                final product p = ProductList.get(position);

                Intent intent = new Intent(getApplicationContext(), productDetail.class);
                intent.putExtra("ShopName", p.getShopName());
                intent.putExtra("ImageID", p.getImageID());
                intent.putExtra("Price1", p.getPrice1());
                intent.putExtra("Price2", p.getPrice2());
                intent.putExtra("DiscountRate", p.getDiscountRate());
                intent.putExtra("ProductName", p.getName());
                intent.putExtra("Explain", p.getExplain());
                intent.putExtra("Date", p.getDate());
                intent.putExtra("Stock", p.getStock());
                intent.putExtra("Case", "ShopInformation");

                startActivity(intent);
            }
        });
    }
}
