package com.example.FOODCHEAP;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import org.w3c.dom.Text;

import java.util.List;

public class addCard extends AppCompatActivity {
    CardDBHelper dbHelper;

    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_card);

        dbHelper = new CardDBHelper(this, 1);

        RadioButton home = (RadioButton) findViewById(R.id.addCardToHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), user_page.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        RadioButton shoppingCart = (RadioButton) findViewById(R.id.addCardToShoppingCart);
        shoppingCart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), shopping_cart.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        Button backButton = (Button) findViewById(R.id.backButton2);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), wallet.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });


        EditText CardName = (EditText) findViewById(R.id.CardName);
        EditText CardNumber = (EditText) findViewById(R.id.CardNumber);
        EditText CardDate = (EditText) findViewById(R.id.CardDate);
        EditText CVC = (EditText) findViewById(R.id.CardCVC);

        Button registerCard = (Button) findViewById(R.id.button12);
        registerCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dbHelper.insert(CardName.getText().toString(), CardNumber.getText().toString(), CardDate.getText().toString(), Integer.parseInt(CVC.getText().toString().trim()));
                Intent intent = new Intent(getApplicationContext(), wallet.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                Toast.makeText(getApplicationContext(), "카드 추가됨", Toast.LENGTH_SHORT).show();
            }
        });

        CardName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    CardNumber.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {
                            if (editable.length() > 0) {
                                CardDate.addTextChangedListener(new TextWatcher() {
                                    @Override
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                    }

                                    @Override
                                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                    }

                                    @Override
                                    public void afterTextChanged(Editable editable) {
                                        if (editable.length() > 0) {
                                            CVC.addTextChangedListener(new TextWatcher() {
                                                @Override
                                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void afterTextChanged(Editable editable) {
                                                    if (editable.length() > 0) {
                                                        registerCard.setClickable(true);
                                                        registerCard.setBackgroundResource(R.drawable.registercard_press);
                                                    }
                                                    else {
                                                        registerCard.setClickable(false);
                                                        registerCard.setBackgroundResource(R.drawable.registercard);
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
    }
}
