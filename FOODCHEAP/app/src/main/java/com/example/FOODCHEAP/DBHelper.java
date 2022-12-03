package com.example.FOODCHEAP;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, int version) {
        super(context, "product.db", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS PRODUCT (ID INTEGER PRIMARY KEY AUTOINCREMENT, IMAGE INTEGER, NAME TEXT, PRICE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PRODUCT");
        onCreate(db);
    }

    public List<product> selectAll() {
        List<product> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("product", new String[] {"id", "image", "name", "price"}, null, null, null, null, "id");

        while(cursor.moveToNext()) {
            int id = cursor.getInt(0);
            int image = cursor.getInt(1);
            String name = cursor.getString(2);
            int price = cursor.getInt(3);

            list.add(new product(id, image, name, price));
        }

        return list;
    }

    public long insert(int image, String name, int price) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("image", image);
        values.put("name", name);
        values.put("price", price);

        return db.insert("product", null, values);
    }

    public void delete(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("product", "id = ?", new String[]{String.valueOf(id)});
    }
}
