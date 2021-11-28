package com.example.rpgdice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

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

    int diceSides = 0;
    int diceAmount = 1;
    int modifier = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize all view variables
        d4ImageButton = findViewById(R.id.d4ImageButton);
        d6ImageButton = findViewById(R.id.d6ImageButton);
        d8ImageButton = findViewById(R.id.d8ImageButton);
        d10ImageButton = findViewById(R.id.d10ImageButton);
        d12ImageButton = findViewById(R.id.d12ImageButton);
        d20ImageButton = findViewById(R.id.d20ImageButton);
        d100ImageButton = findViewById(R.id.d100ImageButton);
        buttonDiceDecrement = findViewById(R.id.diceDecrementButton);
        buttonDiceIncrement = findViewById(R.id.diceIncrementButton);
        buttonModifierDecrement = findViewById(R.id.modifierDecrementButton);
        buttonModifierIncrement = findViewById(R.id.modifierIncrementButton);
        diceAmountTextView = findViewById(R.id.diceAmountTextView);
        modifierTextView = findViewById(R.id.modifierTextView);
        resultsTextView = findViewById(R.id.resultsTextView);


        Random rand = new Random();

        //Setting OnClickListeners for each of the  buttons
        //region d4ImageButton
        d4ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            diceSides = 4;

            int buttonRand = rand.nextInt(diceAmount * diceSides) + modifier + 1;
            resultsTextView.setText(String.valueOf(buttonRand));
            }
        });
        //endregion

        //region d6ImageButton
        d6ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceSides = 6;

                int buttonRand = rand.nextInt(diceAmount * diceSides) + modifier + 1;
                resultsTextView.setText(String.valueOf(buttonRand));
            }
        });
        //endregion

        //region d8ImageButton
        d8ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceSides = 8;

                int buttonRand = rand.nextInt(diceAmount * diceSides) + modifier + 1;
                resultsTextView.setText(String.valueOf(buttonRand));
            }
        });
        //endregion

        //region d10ImageButton
        d10ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceSides = 10;

                int buttonRand = rand.nextInt(diceAmount * diceSides) + modifier + 1;
                resultsTextView.setText(String.valueOf(buttonRand));
            }
        });
        //endregion

        //region d12ImageButton
        d12ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceSides = 12;

                int buttonRand = rand.nextInt(diceAmount * diceSides) + modifier + 1;
                resultsTextView.setText(String.valueOf(buttonRand));
            }
        });
        //endregion

        //region d20ImageButton
        d20ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceSides = 20;

                int buttonRand = rand.nextInt(diceAmount * diceSides) + modifier + 1;
                resultsTextView.setText(String.valueOf(buttonRand));
            }
        });
        //endregion

        //region d100ImageButton
        d100ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceSides = 100;

                int buttonRand = rand.nextInt(diceAmount * diceSides) + modifier + 1;
                resultsTextView.setText(String.valueOf(buttonRand));
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