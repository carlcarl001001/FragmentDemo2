package com.example.carl.fragmentdemo2.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import com.example.carl.fragmentdemo2.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BlankFragment extends Fragment {
    private String mParam;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        log("Fragment onCreate");
        if (getArguments() != null) {
            mParam = getArguments().getString("Key");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        log("Fragment onAttach");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(mParam);
        log("Fragment onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        log("Fragment onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        log("Fragment onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        log("Fragment onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        log("Fragment onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        log("Fragment onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        log("Fragment onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        log("Fragment onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        log("Fragment onDetach");
        super.onDetach();
    }

    private void log(String str){
        Log.i("chen",str);
    }

}
