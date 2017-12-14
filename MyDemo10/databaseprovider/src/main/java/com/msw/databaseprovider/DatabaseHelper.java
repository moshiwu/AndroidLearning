package com.msw.databaseprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by moqiaowen on 2017/12/1.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_BOOK = "create table Book (id integer primary key autoincrement, author text, price real, pages integer, name text)";
    public static final String CREATE_CATEGORY = "create table Category (id integer primary key autoincrement, category_name text, category_code integer)";

    public static final String DROP_BOOK = "drop table if exists Book";
    public static final String DROP_CATEGORY = "drop table if exists Category";
    private Context mContext;

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }


    // onCreate只在db文件没创建的时候运行
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
//        Toast.makeText(mContext, "create database success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_BOOK);
        db.execSQL(DROP_CATEGORY);

        onCreate(db);
    }
}
