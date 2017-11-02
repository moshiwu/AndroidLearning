package com.example.moqiaowen.mydemo6;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MyFragment3 extends Fragment {

    public static final String TAG = "MyFragment3.tag";


    public MyFragment3() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println("MyFragment 3 onAttach");
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("MyFragment 3 onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("MyFragment 3 onCreateView");
        return inflater.inflate(R.layout.my_fragment3, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("MyFragment 3 onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("MyFragment 3 onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("MyFragment 3 onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("MyFragment 3 onStop");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("MyFragment 3 onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("MyFragment 3 onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("MyFragment 3 onDetach");
    }

}
