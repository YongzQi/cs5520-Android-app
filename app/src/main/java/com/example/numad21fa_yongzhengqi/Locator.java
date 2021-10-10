package com.example.numad21fa_yongzhengqi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Locator extends AppCompatActivity {

    private LocationManager locationManager;
    boolean isGPSEnabled;
    private final long MIN_TIME_BW_UPDATES = 0;
    private final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locator);
    }

    public void getLocation(View view) {
        try {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            if (!isGPSEnabled) {
                Snackbar.make(view, "GPS is not enabled.", Snackbar.LENGTH_LONG).show();
            } else {
                TextView textView = findViewById(R.id.textView);
                if (ActivityCompat.checkSelfPermission(Locator.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    textView.setText(R.string.permission_denied);
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                } else if (ActivityCompat.checkSelfPermission(Locator.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    textView.setText(R.string.permission_denied);
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
                } else {
                    textView = findViewById(R.id.textView);
                    if (locationManager != null) {
                        Location GPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        if (GPS != null) {
                            String GPSString = GPS.getLatitude() + " , " + GPS.getLongitude();
                            textView.setText(GPSString);
                        }
                        Location networkLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (networkLocation != null) {
                            String networkString = networkLocation.getLatitude() + " , " + networkLocation.getLongitude();
                            textView.setText(networkString);
                        }
                        Location passiveLocation = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
                        if (passiveLocation != null) {
                            String passiveString = passiveLocation.getLatitude() + " , " + passiveLocation.getLongitude();
                            textView.setText(passiveString);
                        } else {
                            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, v -> {
                            });
                            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, v -> {
                            });
                        }
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}