package com.msw.databaseprovider;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper manager = new DatabaseHelper(this, "database.db", null, 1);


        SQLiteDatabase db = manager.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.clear();
        values.put("name", "Book 1");
        values.put("author", "Dan Brown");
        values.put("pages", 400);
        values.put("price", 16.96);
        db.insert("Book", null, values);

        values.clear();
        values.put("name", "Book 2");
        values.put("author", "Me");
        values.put("pages", 800);
        values.put("price", 99.99);
        db.insert("Book", null, values);

    }
}
