package com.example.carl.fragmentdemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.carl.fragmentdemo2.Fragment.BlankFragment;

public class MainActivity extends AppCompatActivity {
    // 用来标志当前Fragment
    private int tag = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log("Activity onCreate.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        log("Activity onStart.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("Activity onResume.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("Activity onPause.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        log("Activity onStop.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("Activity onDestroy.");
    }

    public void replaceFragment(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BlankFragment blankFragment = new BlankFragment();
        Bundle bundle = new Bundle();
        String param = String.valueOf(tag++);
        bundle.putString("Key", param);
        blankFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragment_content, blankFragment, param);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void addFragment(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BlankFragment blankFragment = new BlankFragment();
        Bundle bundle = new Bundle();
        String param = String.valueOf(tag++);
        bundle.putString("Key", param);
        blankFragment.setArguments(bundle);
        // 在添加新的Fragment之前需要先隐藏前一个Fragment，否则会造成前后层叠
        if (fragmentManager.findFragmentByTag(String.valueOf(tag - 2)) != null) {
            fragmentTransaction.hide(fragmentManager.findFragmentByTag(String.valueOf(tag - 2)));
        }
        fragmentTransaction.add(R.id.fragment_content, blankFragment, param);
        fragmentTransaction.addToBackStack(null);//点击back时会一个个退掉之前添加的fragment
        fragmentTransaction.commit();
    }

    public void removeFragment(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
        tag--;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        tag--;
    }
    private void log(String str){
        Log.i("chen",str);
    }
}
