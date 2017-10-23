package com.example.moqiaowen.mydemo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondEntranceActivity extends AppCompatActivity {

    public static final String ACTION = "com.example.moqiaowen.mydemo1.intent.action.SecondEntranceActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        final TextView tv = (TextView) findViewById(R.id.textView2);
        final CustomApplication context = (CustomApplication) getApplicationContext();
        final EditText et = (EditText) findViewById(R.id.editText2);


        tv.setText("从context获取到" + context.getSaveString());
        System.out.println("从context获取到" + context.getSaveString());

        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("click");
                String value = et.getText().toString();
                System.out.println(value);
                context.setSaveString(et.getText().toString());
            }
        });
    }

}
