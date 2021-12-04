package com.example.rpgdice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private View decorView;
    private ViewPager mViewPager;
    private SensorManager mSensorManager;
    private float mAccel;
    private float mAccelCurrent;
    private float mAccelLast;
    TextView diceAmountTextView;
    TextView modifierTextView;


    List<Integer> rolls;
    public static int diceSides = 20;
    public static int diceAmount = 1;
    int modifier = 0;

    private Random rand = new Random();
    int num;
    String numArr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decorView = getWindow().getDecorView();
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new DiceFragment(), "dice");
        vpAdapter.addFragment(new HistoryFragment(), "history");
        viewPager.setAdapter(vpAdapter);
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {


            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());
            }
        });
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Objects.requireNonNull(mSensorManager).registerListener(DiceFragment.mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
        mAccel = 10f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;


    }




    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(hideSystemBars());
            mSensorManager.registerListener(DiceFragment.mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (hasFocus == false){
            mSensorManager.unregisterListener(DiceFragment.mSensorListener);
        }
    }

    private int hideSystemBars() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }


    public void Roll4(View view)
    {
        diceSides = 4;
        diceAmount = DiceFragment.getDiceAmt();
        DiceFragment.Roll(diceSides,diceAmount);
    }
    public void Roll6(View view)
    {
        diceSides = 6;
        diceAmount = DiceFragment.getDiceAmt();
        DiceFragment.Roll(diceSides,diceAmount);
    }
    public void Roll8(View view)
    {
        diceSides = 8;
        diceAmount = DiceFragment.getDiceAmt();
        DiceFragment.Roll(diceSides,diceAmount);
    }
    public void Roll10(View view)
    {
        diceSides = 10;
        diceAmount = DiceFragment.getDiceAmt();
        DiceFragment.Roll(diceSides,diceAmount);
    }
    public void Roll12(View view)
    {
        diceSides = 12;
        diceAmount = DiceFragment.getDiceAmt();
        DiceFragment.Roll(diceSides,diceAmount);
    }
    public void Roll20(View view)
    {
        diceSides = 20;
        diceAmount = DiceFragment.getDiceAmt();
        DiceFragment.Roll(diceSides,diceAmount);
    }
    public void Roll100(View view)
    {
        diceSides = 100;
        diceAmount = DiceFragment.getDiceAmt();
        DiceFragment.Roll(diceSides,diceAmount);


    }
    public void decAmt(View v) {
        if(diceAmount > 1) {
            diceAmount = --diceAmount;
            DiceFragment.setDiceAmt(diceAmount);
        }
        diceAmountTextView.setText(String.valueOf(diceAmount + "d"));
    }
    public void incAmt(View v) {
        if(diceAmount < 100) {
            diceAmount = ++diceAmount;
            DiceFragment.setDiceAmt(diceAmount);
        }
        diceAmountTextView.setText(String.valueOf(diceAmount + "d"));
    }
    public void decMod(View v) {
        if(modifier > -100)
            modifier = --modifier;

        if(modifier >= 0)
            modifierTextView.setText(String.valueOf("+" + modifier));
        else
            modifierTextView.setText(String.valueOf(modifier));
    }
    public void incMod(View v) {
        if(modifier < 100)
            modifier = ++modifier;

        if(modifier >= 0)
            modifierTextView.setText(String.valueOf("+" + modifier));
        else
            modifierTextView.setText(String.valueOf(modifier));
    }

}