package com.example.cms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.cms.Models.OrdersModel;

import java.util.ArrayList;

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
    public ArrayList<OrdersModel> getOrders()
    {
        ArrayList<OrdersModel> orders = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select id, foodname, image, price from orders", null);
        if (cursor.moveToFirst())
        {
            while (cursor.moveToNext())
            {
                OrdersModel model = new OrdersModel();
                model.setOrder_num(cursor.getInt(0)+"");
                model.setSold_item_name(cursor.getString(1));
                model.setOrderimage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3)+"");
                orders.add(model);
            }
        }
        cursor.close();
        db.close();
        return orders;
    }
}
