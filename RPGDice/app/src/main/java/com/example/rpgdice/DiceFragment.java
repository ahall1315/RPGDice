package com.example.rpgdice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    TextView diceAmountTextView;
    TextView modifierTextView;
    TextView resultsTextView;

    int buttonRand = 0;
    int diceSides = 0;
    int diceAmount = 1;
    int total = 0;
    int modifier = 0;

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
        diceAmountTextView = view.findViewById(R.id.diceAmountTextView);
        modifierTextView = view.findViewById(R.id.modifierTextView);
        resultsTextView = view.findViewById(R.id.resultsTextView);

        ArrayList<Integer> diceList = new ArrayList<>();
        Random rand = new Random();

        //Setting OnClickListeners for each of the  buttons
        //region d4ImageButton
        d4ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            diceSides = 4;
            diceList.clear();
            total = 0;

            //Roll each dice
            for (int i = 0; i < diceAmount; i++){
                buttonRand = rand.nextInt(diceSides)+ 1;
                diceList.add(buttonRand);
            }

            //Sum each dice
            for (int i = 0; i < diceAmount; i++){
                resultsTextView.setText(String.valueOf(total));
                total = total + diceList.get(i);
            }

                //Add the modifier
                total = total + modifier;

                resultsTextView.setText(String.valueOf(total));
            }
        });
        //endregion

        //region d6ImageButton
        d6ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceSides = 6;
                diceList.clear();
                total = 0;

                //Roll each dice
                for (int i = 0; i < diceAmount; i++){
                    buttonRand = rand.nextInt(diceSides)+ 1;
                    diceList.add(buttonRand);
                }

                //Sum each dice
                for (int i = 0; i < diceAmount; i++){
                    resultsTextView.setText(String.valueOf(total));
                    total = total + diceList.get(i);
                }

                //Add the modifier
                total = total + modifier;

                resultsTextView.setText(String.valueOf(total));
            }
        });
        //endregion

        //region d8ImageButton
        d8ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceSides = 8;
                diceList.clear();
                total = 0;

                //Roll each dice
                for (int i = 0; i < diceAmount; i++){
                    buttonRand = rand.nextInt(diceSides)+ 1;
                    diceList.add(buttonRand);
                }

                //Sum each dice
                for (int i = 0; i < diceAmount; i++){
                    resultsTextView.setText(String.valueOf(total));
                    total = total + diceList.get(i);
                }

                //Add the modifier
                total = total + modifier;

                resultsTextView.setText(String.valueOf(total));
            }
        });
        //endregion

        //region d10ImageButton
        d10ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceSides = 10;
                diceList.clear();
                total = 0;

                //Roll each dice
                for (int i = 0; i < diceAmount; i++){
                    buttonRand = rand.nextInt(diceSides)+ 1;
                    diceList.add(buttonRand);
                }

                //Sum each dice
                for (int i = 0; i < diceAmount; i++){
                    resultsTextView.setText(String.valueOf(total));
                    total = total + diceList.get(i);
                }

                //Add the modifier
                total = total + modifier;

                resultsTextView.setText(String.valueOf(total));
            }
        });
        //endregion

        //region d12ImageButton
        d12ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceSides = 12;
                diceList.clear();
                total = 0;

                //Roll each dice
                for (int i = 0; i < diceAmount; i++){
                    buttonRand = rand.nextInt(diceSides)+ 1;
                    diceList.add(buttonRand);
                }

                //Sum each dice
                for (int i = 0; i < diceAmount; i++){
                    resultsTextView.setText(String.valueOf(total));
                    total = total + diceList.get(i);
                }

                //Add the modifier
                total = total + modifier;

                resultsTextView.setText(String.valueOf(total));
            }
        });
        //endregion

        //region d20ImageButton
        d20ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceSides = 20;
                diceList.clear();
                total = 0;

                //Roll each dice
                for (int i = 0; i < diceAmount; i++){
                    buttonRand = rand.nextInt(diceSides)+ 1;
                    diceList.add(buttonRand);
                }

                //Sum each dice
                for (int i = 0; i < diceAmount; i++){
                    resultsTextView.setText(String.valueOf(total));
                    total = total + diceList.get(i);
                }

                //Add the modifier
                total = total + modifier;

                resultsTextView.setText(String.valueOf(total));
            }
        });
        //endregion

        //region d100ImageButton
        d100ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceSides = 100;
                diceList.clear();
                total = 0;

                //Roll each dice
                for (int i = 0; i < diceAmount; i++){
                    buttonRand = rand.nextInt(diceSides)+ 1;
                    diceList.add(buttonRand);
                }

                //Sum each dice
                for (int i = 0; i < diceAmount; i++){
                    resultsTextView.setText(String.valueOf(total));
                    total = total + diceList.get(i);
                }

                //Add the modifier
                total = total + modifier;

                resultsTextView.setText(String.valueOf(total));
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
}
