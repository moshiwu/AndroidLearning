package com.example.moqiaowen.mydemo6;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("on create");
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();


        switch (v.getId()) {
            case R.id.button1:
                //add纯粹只是在container上面叠加新的fragment
                transaction.addToBackStack(null);
                transaction.add(R.id.fragment_container, new MyFragment1());  //fragment需要一个容器

                break;

            case R.id.button2:
                if (manager.findFragmentByTag(MyFragment2.TAG) == null) {
                    transaction.addToBackStack(null);
                    transaction.add(R.id.fragment_container, new MyFragment2(), MyFragment2.TAG); //Tag可以配合findFragmentByTag来查找fragment
                }
                break;


            case R.id.button3:
                //replace会把container里面当前显示的所有fragment都移除掉，
                transaction.addToBackStack(null);
                transaction.replace(R.id.fragment_container, new MyFragment3());
                break;


            case R.id.button4:
                manager.popBackStack();
                System.out.println(manager.findFragmentByTag(MyFragment1.TAG));

                break;


        }

        transaction.commit();
    }

}
