package com.example.moqiaowen.mydemo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class AnotherActivity extends AppCompatActivity {

    public static final String ACTION = "com.example.moqiaowen.mydemo1.intent.action.AnotherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Button btn = (Button) findViewById(R.id.btn_another_1);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        
        WebView wb = (WebView) findViewById(R.id.wb_1);
        wb.loadData("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<a href=\"appmain2://\">启动app2</a>\n" +
                "</body>\n" +
                "</html>", "text/html", "utf-8");
    }

}
