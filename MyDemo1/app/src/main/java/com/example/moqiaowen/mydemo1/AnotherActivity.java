package com.example.moqiaowen.mydemo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Intent i = getIntent();
        System.out.println("从前一个view获取到 " + i.getStringExtra("key"));

        Button btn = (Button) findViewById(R.id.btn_another_1);
        final EditText tf = (EditText) findViewById(R.id.editText_another_1);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();

                String value = tf.getText().toString();
                i.putExtra("key", value);

                //设置本Activity的回调
                setResult(9527, i);

                //关掉本Activity
                finish();
            }
        });
    }
}
