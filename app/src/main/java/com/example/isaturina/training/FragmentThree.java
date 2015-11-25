package com.example.isaturina.training;

import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isaturina.training.db.FeedReaderContract;
import com.example.isaturina.training.db.FeedReaderDbHelper;
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

        FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(getContext());
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID, colorValue);
//        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, "1");
//        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, "2");

// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FeedReaderContract.FeedEntry.TABLE_NAME,
                FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID,
                values);

        File dir = getActivity().getFilesDir();
        String filename = "myfile";
        String string = "Hello world!";
        FileOutputStream outputStream;

        File file = new File(getActivity().getFilesDir(), filename);
        FilesUtil.isExternalStorageReadable();
        FilesUtil.isExternalStorageWritable();


        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String prev = sharedPref.getString("prev_color", "no_prev");
        if (textView != null) {
            textView.setText("Now: " + colorValue + ", was: " + prev + ", Internal dir: " + dir.getAbsolutePath());
        }
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("prev_color", colorValue);
        editor.commit();

    }
}