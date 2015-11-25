package com.example.isaturina.training;

import android.app.ListFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentOne extends ListFragment{

    int colors[] = new int[]{Color.RED, Color.DKGRAY, Color.BLUE, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.YELLOW};
    String color_name[] = new String[]{"RED", "DKGRAY", "BLUE", "GREEN", "CYAN", "MAGENTA", "YELLOW"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creates and returns the view hierarchy associated with the fragment.
        View view = inflater.inflate(R.layout.fragment_one, container);
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, color_name);
        setListAdapter(adapter);
        return view; //make sure to modify this line from super to inflated view
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        FragmentTwo fragmentTwo = (FragmentTwo)getFragmentManager().findFragmentById(R.id.fragment_two);
        if (fragmentTwo != null) {
            fragmentTwo.setImageViewBackground(colors[position]);
        }

        FragmentThree fragmentThree = (FragmentThree)getFragmentManager().findFragmentById(R.id.fragment_three);
        if (fragmentThree != null) {
            fragmentThree.setText(String.valueOf(colors[position]));
        }


        super.onListItemClick(l, v, position, id);
    }

}