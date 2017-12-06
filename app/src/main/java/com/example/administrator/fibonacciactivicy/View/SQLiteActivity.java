package com.example.administrator.fibonacciactivicy.View;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017-12-05.
 */

public class SQLiteActivity extends SQLiteOpenHelper{
    public SQLiteActivity(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Create table and column
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE JinDataBase(" + "number INTEGER," + "result INTEGER" + ");");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    public void insert(String insert) {
        SQLiteDatabase sqLiteActivity = getWritableDatabase();
        sqLiteActivity.execSQL(insert);
        sqLiteActivity.close();
    }

    /**
     * DataBase Data Output
     * @return
     */
    public String DBdata() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String dbdata = "";

        Cursor cursor = sqLiteDatabase.rawQuery("select * from JinDataBase", null);
        while (cursor.moveToNext()) {
            dbdata += cursor.getInt(0)
                    + ","
                    + cursor.getInt(1)
                    + "\n";
        }
        return dbdata;
    }
}
