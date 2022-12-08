package com.example.FOODCHEAP;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class wallet extends AppCompatActivity {
    CardDBHelper dbHelper;
    SQLiteDatabase database;
    List<card> CardList;
    RecyclerView recyclerView;
    cardAdapter adapter;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallet);

        dbHelper = new CardDBHelper(this, 1);
        CardList = dbHelper.selectAll();
        recyclerView = (RecyclerView) findViewById(R.id.CardRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new cardAdapter(CardList, dbHelper);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new cardAdapter.OnItemClickEventListener() {
            @Override
            public void onItemClick(View v, int position) {
                final card c = CardList.get(position);

                Intent intent = new Intent(getApplicationContext(), CardDetail.class);
                intent.putExtra("CardName", c.getCardName());
                intent.putExtra("CardNumber", c.getCardNumber());
                intent.putExtra("ValidThru", c.getValidThru());
                intent.putExtra("CVC", c.getCVC());
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.slow_left_out);
            }
        });

        TextView emptyText = (TextView) findViewById(R.id.EmptyText);
        if (adapter.getItemCount() == 0) {
            emptyText.setText("등록된 카드가 없습니다.");
        }
        else {
            emptyText.setText("");
        }

        RadioButton home = (RadioButton) findViewById(R.id.walletToHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), user_page.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        RadioButton shoppingCart = (RadioButton) findViewById(R.id.walletToShoppingCart);
        shoppingCart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), shopping_cart.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        RadioButton myPage = (RadioButton) findViewById(R.id.walletToMyPage);
        myPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), my_page_customer.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        Button addCard = (Button) findViewById(R.id.button6);
        addCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), addCard.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.slow_left_out);
            }
        });

        Button clearCards = (Button) findViewById(R.id.deleteAllCards);
        clearCards.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                database = dbHelper.getWritableDatabase();
                dbHelper.onUpgrade(database, 1, 2);
                adapter.notifyDataSetChanged();
                finish();
                Intent intent = new Intent(getApplicationContext(), wallet.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                Toast.makeText(getApplicationContext(), "카드 초기화됨", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
