package com.example.isaturina.training;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isaturina.training.utils.FilesUtil;

import java.io.File;
import java.io.FileOutputStream;

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
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String prev = sharedPref.getString("prev_color", "no_prev");
        File dir = getActivity().getFilesDir();
        String filename = "myfile";
        String string = "Hello world!";
        FileOutputStream outputStream;

        File file = new File(getActivity().getFilesDir(), filename);
        FilesUtil.isExternalStorageReadable();
        FilesUtil.isExternalStorageWritable();
        if(textView != null){
            textView.setText("Now: " + colorValue + ", was: " + prev + ", Internal dir: " + dir.getAbsolutePath());
        }
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("prev_color", colorValue);
        editor.commit();

    }
}