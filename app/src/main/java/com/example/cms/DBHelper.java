package com.example.cms;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "cms.db";
    final static int DBVERSION = 1;
    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table orders " +
                "(id integer primary key autoincrement," +
                "name text," +
                "phone text," +
                "price int," +
                "image int," +
                "qty int," +
                "description text," +
                "foodname text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS orders");
        onCreate(sqLiteDatabase);
    }

    public boolean insertOrder(String name, String phone, String foodname, String desc, int price, int img, int qty)
    {
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", img);
        values.put("qty", qty);
        values.put("description", desc);
        values.put("foodname", foodname);
        long id = db.insert("orders", null, values);
        if (id <= 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
