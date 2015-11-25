package com.example.isaturina.training;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentThree extends Fragment{

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container);
        textView = (TextView)view.findViewById(R.id.textView);

        return view;
    }

    public void setText(String colorValue) {
        if(textView != null){
            textView.setText(colorValue);
        }
    }
}