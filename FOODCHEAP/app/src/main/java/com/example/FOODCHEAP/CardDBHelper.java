package com.example.FOODCHEAP;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CardDBHelper extends SQLiteOpenHelper {
    public CardDBHelper(@Nullable Context context, int version) {
        super(context, "CARDINFO.db", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS CARD (ID INTEGER PRIMARY KEY AUTOINCREMENT, CARDNAME TEXT, CARDNUMBER TEXT, VALIDTHRU TEXT, CVC INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CARD");
        onCreate(db);
    }

    public List<card> selectAll() {
        List<card> list = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("card", new String[]{"id","cardname","cardnumber","validthru", "cvc"},null,null,null,null,"id"); // 위에 참조
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String cardname = cursor.getString(1);
            String cardnumber = cursor.getString(2);
            String validthru = cursor.getString(3);
            int cvc = cursor.getInt(4);
            list.add(new card(id, cardname, cardnumber, validthru, cvc));
        }
        return list;
    }

    public long insert(String cardName, String cardNumber, String validThru, int CVC) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cardname", cardName);
        values.put("cardnumber", cardNumber);
        values.put("validthru", validThru);
        values.put("cvc", CVC);

        return db.insert("card", null, values);
    }

    public void delete(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("card", "id = ?", new String[]{String.valueOf(id)});
    }
}