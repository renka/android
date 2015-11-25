package com.example.isaturina.training;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentTwo extends Fragment{

    private ImageView imgView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creates and returns the view hierarchy associated with the fragment.
        View view = inflater.inflate(R.layout.fragment_two, container);
        imgView = (ImageView)view.findViewById(R.id.imageView);

        return view;
    }

    public void setImageViewBackground(int colorValue) {
        if(imgView != null){
            imgView.setBackgroundColor(colorValue);
        }
    }
}