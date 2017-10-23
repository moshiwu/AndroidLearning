package com.example.moqiaowen.mydemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstEntranceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("on create");
        setContentView(R.layout.activity_first);


        final TextView tv = (TextView) findViewById(R.id.textView1);
        final CustomApplication context = (CustomApplication) getApplicationContext();
        final EditText et = (EditText) findViewById(R.id.editText1);


        tv.setText("从context获取到" + context.getSaveString());
        System.out.println("从context获取到" + context.getSaveString());

        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("click");
                String value = et.getText().toString();
                System.out.println(value);
                context.setSaveString(et.getText().toString());
            }
        });

        //一点理解：这个demo有两个入口Activity，入口关掉的时候application并不一定会消失，还驻留在内存当中，所以当关闭某个入口的时候还能访问application里面的数据
    }



}
