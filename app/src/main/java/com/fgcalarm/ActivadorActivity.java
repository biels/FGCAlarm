package com.fgcalarm;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;

import static android.app.PendingIntent.FLAG_CANCEL_CURRENT;

public class ActivadorActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        String estacio = "";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            estacio = extras.getString("estacio");
            //The key argument here must match that used in the other activity
        }
        setContentView(R.layout.activity_activador);

        double latitud = read_latitude(estacio);
        double longitud = read_longitude(estacio);
        float radius = 30;
        long expiration = -1;
        Intent intent = new Intent(this, VibrateService.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, FLAG_CANCEL_CURRENT);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.addProximityAlert(latitud, longitud, radius, expiration, pendingIntent);
    }

    // FROM DB
    private int read_latitude(String estacio) {
        return 0; // TODO
    }

    private int read_longitude(String estacio) {
        return 0; // TODO
    }
}
