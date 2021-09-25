package com.example.numad21fa_yongzhengqi;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity implements View.OnTouchListener {
    private TextView pressed;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pressed = findViewById(R.id.textView2);
        Button buttonA = findViewById(R.id.button3);
        Button buttonB = findViewById(R.id.button4);
        Button buttonC = findViewById(R.id.button5);
        Button buttonD = findViewById(R.id.button6);
        Button buttonE = findViewById(R.id.button7);
        Button buttonF = findViewById(R.id.button8);

        buttonA.setOnTouchListener(this);
        buttonB.setOnTouchListener(this);
        buttonC.setOnTouchListener(this);
        buttonD.setOnTouchListener(this);
        buttonE.setOnTouchListener(this);
        buttonF.setOnTouchListener(this);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            switch (view.getId()) {
                case R.id.button3:
                    pressed.setText(R.string.pressedA);
                    break;
                case R.id.button4:
                    pressed.setText(R.string.pressedB);
                    break;
                case R.id.button5:
                    pressed.setText(R.string.pressedC);
                    break;
                case R.id.button6:
                    pressed.setText(R.string.pressedD);
                    break;
                case R.id.button7:
                    pressed.setText(R.string.pressedE);
                    break;
                case R.id.button8:
                    pressed.setText(R.string.pressedF);
                    break;
            }

        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            pressed.setText(R.string.pressed);
        }
        return true;
    }
}