package com.example.numad21fa_yongzhengqi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayToast(View v) {
        Toast.makeText(MainActivity.this, "Yongzheng Qi, qi.yo@northeastern.edu", Toast.LENGTH_LONG).show();
    }
}