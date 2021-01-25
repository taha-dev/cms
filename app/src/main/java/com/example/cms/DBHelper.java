//package com.example.cms;
//
//import android.content.ContentValues;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.content.Context;
//
//public abstract class DBHelper extends SQLiteOpenHelper {
//    public static final String DATABASE_NAME = "Canteen.db";
//    public static final String STUDENTS_TABLE_NAME = "students";
//    public static final String STUDENTS_COLUMN_ID = "id";
//    public static final String STUDENTS_COLUMN_NAME = "name";
//    public static final String STUDENTS_COLUMN_EMAIL = "email";
//    public static final String STUDENTS_COLUMN_PASSWORD= "password";
//    public static final String STUDENTS_COLUMN_BALANCE = "balance";
//
//    public DBHelper(Context context){
//        super(context, DATABASE_NAME, null, 1);
//    }
//    public void onCreate(SQLiteDatabase db)
//    {
//        String CREATE_STUDENTS_TABLE = "CREATE TABLE "+ STUDENTS_TABLE_NAME + "("+STUDENTS_COLUMN_ID+" text primary key,"+ STUDENTS_COLUMN_NAME +" text,"+STUDENTS_COLUMN_EMAIL+" text,"+ STUDENTS_COLUMN_PASSWORD+" text,"+STUDENTS_COLUMN_BALANCE+" real)";
//        db.execSQL(CREATE_STUDENTS_TABLE);
//    }
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
//    {
//        db.execSQL("DROP TABLE IF EXISTS " + STUDENTS_TABLE_NAME);
//        onCreate(db);
//    }
//    public boolean insertStudent (String id, String name, String email, String password,float balance) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("id", id);
//        contentValues.put("name", name);
//        contentValues.put("email", email);
//        contentValues.put("street", password);
//        contentValues.put("place", balance);
//        db.insert("contacts", null, contentValues);
//        return true;
//    }
//    public Student getStudent(String id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor res =  db.rawQuery( "select * from"+ STUDENTS_TABLE_NAME + "where id="+id+"", null );
//        if (res != null)
//        {
//            res.moveToFirst();
//        }
//
//        Student std = new Student(res.getString(res.getColumnIndex(STUDENTS_COLUMN_ID)),res.getString(res.getColumnIndex(STUDENTS_COLUMN_NAME)), res.getString(res.getColumnIndex(STUDENTS_COLUMN_EMAIL)), res.getString(res.getColumnIndex(STUDENTS_COLUMN_PASSWORD)), res.getFloat(res.getColumnIndex(STUDENTS_COLUMN_BALANCE)));
//
//        return std;
//    }
//}
