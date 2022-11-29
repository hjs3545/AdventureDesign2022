package com.example.FOODCHEAP;

import android.content.Intent;
import android.graphics.Paint;
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
    public List<product> ProductList;
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
            }
        });
    }

    private void AddData() {
        ProductList = new ArrayList<>();

        ProductList.add(new product("쿠키네 식료품", R.drawable.seoul_milk, "3,200원", "2,200원", "-31%", "서울우유 1.8L", "체세포수 1등급, 세균수 1A", "~12/10", 10));
        ProductList.add(new product("쿠키네 식료품", R.drawable.shred_cheese,  "6,900원", "5,000원", "-28%", "슈레드 모짜렐라 300g", "진한 풍미와 쫄깃한 식감", "~12/23", 7));
        ProductList.add(new product("쿠키네 식료품", R.drawable.butter, "6,100원", "4,500원", "-27%", "가염 버터 240g", "신선한 국산 원유로 만든 국산 유크림 100%의 고품격 버터", "~1/3", 14));
        ProductList.add(new product("쿠키네 식료품", R.drawable.yogurt,  "2,980원", "2,000원", "-33%", "빙그레 요플레 85g x 4", "2000억 프로바이오틱스", "~12/12", 4));
        //ProductList.add(new product("쿠키네 식료품", R.drawable.bananamilk, "9,800원", "7,350원", "-25%", "빙그레 바나나맛 우유 8개입", "기분 좋은 달콤함과 단지 모양의 용기", "~12/5", 12));

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

                startActivity(intent);
            }
        });
    }
}
