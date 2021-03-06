package com.example.numad21fa_yongzhengqi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button linkButton;
    private Button locator;
    private Button atYourService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        linkButton = findViewById(R.id.button9);
        linkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

        locator = findViewById(R.id.button10);
        locator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLocator();
            }
        });

        atYourService = findViewById(R.id.button11);
        atYourService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAtYourService();
            }
        });
    }

    public void displayToast(View v) {
        Toast.makeText(MainActivity.this, "Yongzheng Qi, qi.yo@northeastern.edu", Toast.LENGTH_LONG).show();
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    public void openActivity3() {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }

    public void openLocator() {
        Intent intent = new Intent(this, Locator.class);
        startActivity(intent);
    }

    public void openAtYourService() {
        Intent intent = new Intent(this, AtYourServiceActivity.class);
        startActivity(intent);
    }
}