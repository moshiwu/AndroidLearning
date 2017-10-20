package com.example.moqiaowen.mydemo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("on create");
        setContentView(R.layout.activity_main);


        // 使用findViewById来获取控件，类似iOS的tag
        findViewById(R.id.btn_main_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("click");

                //不需要传递参数的情况下，就这样启动下一个界面即可
//                startActivity(new Intent(MainActivity.this, AnotherActivity.class));


                //如果需要传值，则需要使用startActivityForResult配合onActivityResult来实现
                TextView tv = (TextView) findViewById(R.id.tv_main_1);
                Intent i = new Intent(MainActivity.this, AnotherActivity.class); //Intent相当于iOS的segue
                i.putExtra("key", tv.getText());
                startActivityForResult(i, 9527);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // requestCode/resultCode 相当于一个校验码
        if (requestCode == 9527 && resultCode == 9527) {
            String value = data.getStringExtra("key");

            System.out.println("返回了：" + value);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("on start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("on pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("on resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("on destory");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("on stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("on restart");
    }
}
