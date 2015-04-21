package com.example.liulu.androidwear.Activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liulu.androidwear.R;


public class C_FeiLeiFragment extends Fragment {


    public C_FeiLeiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.listview_layout, container, false);
        return v;
    }


}
