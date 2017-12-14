package com.example.moqiaowen.mydemo9;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText_local;
    private EditText editText_sharePreferences;

    private MySQLiteManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //方式一：文件存储
        editText_local = (EditText) findViewById(R.id.editText1);
        String inputText1 = loadWithFile();
        if (!TextUtils.isEmpty(inputText1)) {
            editText_local.setText(inputText1);
            editText_local.setSelection(inputText1.length());
        } else {
            editText_local.setText("please enter something");
        }


        //方式二：SharedPreferences存储
        String inputText2 = loadWithSharedPreferences("key_1", "");

        editText_sharePreferences = (EditText) findViewById(R.id.editText2);

        if (!TextUtils.isEmpty(inputText2)) {
            editText_sharePreferences.setText(inputText2);
            editText_sharePreferences.setSelection(inputText2.length());
        } else {
            editText_sharePreferences.setText("please enter somthing again");
        }

        //方式三：LitePal 初始化和创建数据库
        LitePal.initialize(this);
        LitePal.getDatabase();

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);

        manager = new MySQLiteManager(this, "database.db", null, 2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        saveWithFile(editText_local.getText().toString());

        saveWithSharedPreferences("key_1", editText_sharePreferences.getText().toString());
    }

    protected void saveWithSharedPreferences(String key, String value) {
        SharedPreferences sharedPreferences = this.getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(key, value);
        editor.apply();
    }

    protected String loadWithSharedPreferences(String key, String defaultValue) {
        SharedPreferences sharedPreferences = this.getSharedPreferences("data", Context.MODE_PRIVATE);
        String value = sharedPreferences.getString(key, defaultValue);

        return value;

    }

    protected String loadWithFile() {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();

        try {
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return content.toString();
    }

    protected void saveWithFile(String inputText) {
        FileOutputStream out = null;
        BufferedWriter writer = null;


        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View v) {


        if (manager == null) {
            createDatabase();
        }

        SQLiteDatabase db = manager.getWritableDatabase();
        ContentValues values = new ContentValues();


        switch (v.getId()) {

            // SQLiteOpenHelper方式创建数据库文件
            case R.id.button1:
                createDatabase();
                break;

            // SQLiteOpenHelper 插入数据
            case R.id.button2:
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
                break;

            // SQLiteOpenHelper 更新数据
            case R.id.button3:
                values.put("price", 11.11);
                db.update("Book", values, "name = ?", new String[]{"Book 1"});
                Toast.makeText(this, "update values", Toast.LENGTH_SHORT).show();
                break;

            // SQLiteOpenHelper 删除数据
            case R.id.button4:
                db.delete("Book", "price > ?", new String[]{"1.0"});
                Toast.makeText(this, "delete values", Toast.LENGTH_SHORT).show();
                break;

            // SQLiteOpenHelper 删除表
            case R.id.button5:
                Cursor cursor = db.query("Book", null, "author = ?", new String[]{"Me"}, null, null, null);

                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String price = cursor.getString(cursor.getColumnIndex("price"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));

                        Log.d("MainActivity", "----------------------");
                        Log.d("MainActivity", "book name is " + name);
                        Log.d("MainActivity", "book author is " + author);
                        Log.d("MainActivity", "book pages is " + pages);
                        Log.d("MainActivity", "book price is " + price);
                    } while (cursor.moveToNext());
                }

                cursor.close();

                break;


            // LitePal 增加数据
            case R.id.button6:
                Book book = new Book();
                book.setPages(333);
                book.setName("Book created by LitePal");
                book.setPrice(Math.floor(new Random().nextDouble() * 1000));
                book.setAuthor("古愿狼");
//                book.setToDefault("author");   //如果要设置默认值，需要使用这个方法
                book.save();

                break;

            // LitePal 更新数据
            case R.id.button7:
                book = new Book();
                book.setPrice(9527.00);
                book.updateAll("price < 1000");
                break;

            // LitePal 删除数据
            case R.id.button8:
                DataSupport.deleteAll(Book.class, "price < 999999.00");

                break;

            // LitePal 查询数据
            case R.id.button9:

                List<Book> list = DataSupport
                        .select("name", "author", "price")
                        .where("price < 999")
                        .limit(3)
                        .offset(1) //  limit(3)查询到的是前 3 条数据，这里我们再加上 offset(1)进行一个位置的偏移， 就能实现查询第 2 条、第 3 条、第 4 条数据的功能
                        .order("price desc")
                        .find(Book.class);

                // 查询所有
                //List<Book> list = DataSupport.findAll(Book.class);


                for (Book innerBook : list) {
                    Log.d("MainActivity", "----------------------");
                    Log.d("MainActivity", "book name is " + innerBook.getName());
                    Log.d("MainActivity", "book author is " + innerBook.getAuthor());
                    Log.d("MainActivity", "book pages is " + innerBook.getPages());
                    Log.d("MainActivity", "book price is " + innerBook.getPrice());
                }
                break;
        }


    }


    protected void createDatabase() {
        manager.getWritableDatabase();
    }
}
