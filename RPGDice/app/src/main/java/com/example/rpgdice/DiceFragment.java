package com.example.rpgdice;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.ToggleButton;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class DiceFragment extends Fragment {

    //Declare all view variables
    ImageButton d4ImageButton;
    ImageButton d6ImageButton;
    ImageButton d8ImageButton;
    ImageButton d10ImageButton;
    ImageButton d12ImageButton;
    ImageButton d20ImageButton;
    ImageButton d100ImageButton;
    Button buttonDiceDecrement;
    Button buttonDiceIncrement;
    Button buttonModifierDecrement;
    Button buttonModifierIncrement;
    ToggleButton shakeToggle;
    TextView diceAmountTextView;
    TextView modifierTextView;
    static TextView resultsTextView;

    int buttonRand = 0;
    static int diceSides = 20;
    static int diceAmount = 1;
    int total = 0;
    static int modifier = 0;
    private static String arr;
    static int tot;
    static boolean shakeFlag = false;


    List<Integer> rolls;

    private SensorManager mSensorManager;
    private static float mAccel;
    private static float mAccelCurrent;
    private static float mAccelLast;
    private View decorView;
    private static Random rand = new Random();
    private static int num;
    private static String numArr = "";






    public DiceFragment(){


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dice, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //Initialize all view variables
        d4ImageButton = view.findViewById(R.id.d4ImageButton);
        d6ImageButton = view.findViewById(R.id.d6ImageButton);
        d8ImageButton = view.findViewById(R.id.d8ImageButton);
        d10ImageButton = view.findViewById(R.id.d10ImageButton);
        d12ImageButton = view.findViewById(R.id.d12ImageButton);
        d20ImageButton = view.findViewById(R.id.d20ImageButton);
        d100ImageButton = view.findViewById(R.id.d100ImageButton);
        buttonDiceDecrement = view.findViewById(R.id.diceDecrementButton);
        buttonDiceIncrement = view.findViewById(R.id.diceIncrementButton);
        buttonModifierDecrement = view.findViewById(R.id.modifierDecrementButton);
        buttonModifierIncrement = view.findViewById(R.id.modifierIncrementButton);
        shakeToggle = view.findViewById(R.id.shakeToggleButton);
        diceAmountTextView = view.findViewById(R.id.diceAmountTextView);
        modifierTextView = view.findViewById(R.id.modifierTextView);
        resultsTextView = view.findViewById(R.id.resultsTextView);
        numArr = "";
        List<Integer> diceList = new ArrayList<>();
        Random rand = new Random();


        //region Shake Toggle Button
        shakeToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    shakeFlag = true;
                } else {
                    shakeFlag = false;
                }
            }
        });
        //endregion

        //region Dice Decrement Button
        buttonDiceDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(diceAmount > 1)
                    diceAmount = --diceAmount;
                diceAmountTextView.setText(String.valueOf(diceAmount + "d"));
            }
        });

        buttonDiceDecrement.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                diceAmount = 1;
                diceAmountTextView.setText(String.valueOf(diceAmount + "d"));
                return true;
            }
        });
        //endregion

        //region Dice Increment Button
        buttonDiceIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(diceAmount < 100)
                    diceAmount = ++diceAmount;
                diceAmountTextView.setText(String.valueOf(diceAmount + "d"));
            }
        });

        buttonDiceIncrement.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                diceAmount = 100;
                diceAmountTextView.setText(String.valueOf(diceAmount + "d"));
                return true;
            }
        });
        //endregion

        //region Modifier Decrement Button
        buttonModifierDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(modifier > -100)
                    modifier = --modifier;

                if(modifier >= 0)
                    modifierTextView.setText(String.valueOf("+" + modifier));
                else
                    modifierTextView.setText(String.valueOf(modifier));
            }
        });

        buttonModifierDecrement.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(modifier > 0)
                    modifier = 0;
                else
                    modifier = -100;

                if(modifier >= 0)
                    modifierTextView.setText(String.valueOf("+" + modifier));
                else
                    modifierTextView.setText(String.valueOf(modifier));
                return true;
            }
        });
        //endregion

        //region Modifier Increment Button
        buttonModifierIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(modifier < 100)
                    modifier = ++modifier;

                if(modifier >= 0)
                    modifierTextView.setText(String.valueOf("+" + modifier));
                else
                    modifierTextView.setText(String.valueOf(modifier));
            }
        });

        buttonModifierIncrement.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(modifier < 0)
                    modifier = 0;
                else
                    modifier = 100;

                modifierTextView.setText(String.valueOf("+" + modifier));
                return true;
            }
        });

        //endregion
    }

    public static String getArr(){
        return numArr;
    }
    public static int getDiceAmt(){
        return diceAmount;
    }
    public static void setDiceAmt(int amt){
        diceAmount = amt;
    }
    public static int Roll(int sides, int diceAmt) {


        tot = 0;
        for (int j = 0; j<diceAmt;j++)
        {
            num = rand.nextInt(sides)+1;

            tot += num;
            if (j == diceAmt - 1)
                numArr += Integer.toString(num);
            else
                numArr += Integer.toString(num)+", ";

            //resultsTextView.s
        }
        tot = tot+modifier;
        resultsTextView.setText(String.valueOf(tot));
        HistoryFragment.setHistory(numArr, diceAmt, sides, tot, modifier);
        numArr = "";

        return num;
    }


    public static final SensorEventListener mSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = mAccelCurrent - mAccelLast;
            mAccel = mAccel * 0.9f + delta;
            if (mAccel > 10 && shakeFlag)
            {
                Roll(MainActivity.diceSides, diceAmount);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy)
        {
        }
    };
}