package com.example.rpgdice;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    static ArrayAdapter<String> arrayAdapter;
    ListView listView;
    private static ArrayList<String> displayList = new ArrayList<>();

    public HistoryFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_history, container, false);


    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.listview);

        arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, displayList);

        listView.setAdapter(arrayAdapter);
    }

    public static void setHistory(String arr, int diceAmt, int sides, int tot, int modifier ){
        String display;
        if (modifier == 0){
            display = "[" + String.valueOf(tot) + "] " + String.valueOf(diceAmt) + "d" + String.valueOf(sides) + ": " + arr;
        }else
        if (modifier > 0){
            display = "[" + String.valueOf(tot) + "] " + String.valueOf(diceAmt) + "d" + String.valueOf(sides) + "+" + String.valueOf(modifier) + ": " + arr;
        }else{
            display = "[" + String.valueOf(tot) + "] " + String.valueOf(diceAmt) + "d" + String.valueOf(sides) + String.valueOf(modifier) + ": " + arr;
        }
        arrayAdapter.insert(display, 0);
        arrayAdapter.notifyDataSetChanged();
    }

}