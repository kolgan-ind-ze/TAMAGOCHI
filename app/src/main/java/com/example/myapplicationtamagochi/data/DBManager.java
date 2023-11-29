package com.example.myapplicationtamagochi.data;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private Context context;
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public DBManager(Context context) {
        this.context = context;
        dbHelper = new DBHelper(this.context);
    }

    public void openDb() {
        db = dbHelper.getWritableDatabase();
    }

    public void closeDb() {
        db.close();
    }

    public void addRecord(TimeClass time) {
        ContentValues cv = new ContentValues();
        cv.put(DBConst.RECORD_TIME, time.getSeconds());
        db.insert(DBConst.TAMAGOCHI_TABLE_NAME, null, cv);
    }

    @SuppressLint("Range")
    public int compareTime() {
        TimeClass time = new TimeClass();
        Cursor cursor = db.rawQuery("SELECT MAX(" + DBConst.RECORD_TIME + ") FROM " + DBConst.TAMAGOCHI_TABLE_NAME, null);
        cursor.moveToNext();
        int maxSeconds = cursor.getInt(0);
        cursor.close();
        return maxSeconds;
    }

    public boolean checkEmpty() {
        TimeClass time = new TimeClass();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DBConst.TAMAGOCHI_TABLE_NAME, null);
        if (cursor != null) {
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }
}
