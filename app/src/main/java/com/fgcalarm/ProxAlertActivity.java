package com.fgcalarm;


import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.*;
import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fgcalarm.model.entities.Station;
import com.fgcalarm.model.persistence.RepositoryManager;
import com.fgcalarm.model.provisioning.ProvisioningManager;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class ProxAlertActivity extends Activity {

    NotificationManager nm;
    private final int notificationID = 1002;

    private static final long MINIMUM_DISTANCECHANGE_FOR_UPDATE = 1; // in Meters
    private static final long MINIMUM_TIME_BETWEEN_UPDATE = 1000; // in Milliseconds

    private static final long POINT_RADIUS = 1000; // in Meters
    private static final long PROX_ALERT_EXPIRATION = -1;

    private static final String POINT_LATITUDE_KEY = "POINT_LATITUDE_KEY";
    private static final String POINT_LONGITUDE_KEY = "POINT_LONGITUDE_KEY";

    private static final String PROX_ALERT_INTENT =

            "com.fgcalarm.ProximityAlert";

    private static final NumberFormat nf = new DecimalFormat("##.########");

    private LocationManager locationManager;

    private EditText latitudeEditText;
    private EditText longitudeEditText;
    private Button findCoordinatesButton;
    private Button savePointButton;

    private Context ctx;

    private final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1005;

    private Button button;

    private PendingIntent proximityIntent;

    private Station station;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_activador);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
            return;
        }
        locationManager.requestLocationUpdates(

                LocationManager.GPS_PROVIDER,

                MINIMUM_TIME_BETWEEN_UPDATE,

                MINIMUM_DISTANCECHANGE_FOR_UPDATE,

                new MyLocationListener()

        );

        String estacio = "";
        Long id = 0L;
        Bundle extras = getIntent().getExtras();
        int pseudo_station_id = 0;
        int linia_id_p = 0;
        Long hola = 0L;
        if (extras != null) {
            id = extras.getLong("station_id");
            estacio = extras.getString("estacio");
            pseudo_station_id = extras.getInt("pseudo_station_id");
            linia_id_p = extras.getInt("linia_id_p");
            hola = extras.getLong("hola");
            //The key argument here must match that used in the other activity
        }
        setContentView(R.layout.activity_activador);

        Log.v("id", String.valueOf(id));

       /* intent_not = new Intent(this, ActivadorActivity.class);
        pendingIntentNot = PendingIntent.getActivity(this, 0, intent_not, PendingIntent.FLAG_UPDATE_CURRENT);*/
        button = (Button) findViewById(R.id.cancel_button);

        RepositoryManager.attatchImplementation(RepositoryManager.ImplementationType.IN_MEMORY);
        ProvisioningManager.provisionModel(ProvisioningManager.ProvisioningStrategy.HARDCODED);

        station = RepositoryManager.getStationRepository().findOne(id);
        Log.v("name", station.getName());
        Double lat = station.getLocation().getLatitude();
        Double lon = station.getLocation().getLongitude();
        Log.v("latitude", String.valueOf(lat));
        Log.v("longitude", String.valueOf(lon));
        //station = RepositoryManager.getLineRepository().findAll().get(linia_id_p).getStations().get(pseudo_station_id);
        //station = RepositoryManager.getLineRepository().findAll().get(linia_id_p).getStations().get(0);


        addProximityAlert(lat, lon);

        displayNotification(this, station.getName());


        /*

        latitudeEditText = (EditText) findViewById(R.id.point_latitude);

        longitudeEditText = (EditText) findViewById(R.id.point_longitude);

        findCoordinatesButton = (Button) findViewById(R.id.find_coordinates_button);

        savePointButton = (Button) findViewById(R.id.save_point_button);

        findCoordinatesButton.setOnClickListener(new OnClickListener() {

            @Override

            public void onClick(View v) {

                populateCoordinatesFromLastKnownLocation();

            }

        });

        savePointButton.setOnClickListener(new OnClickListener() {

            @Override

            public void onClick(View v) {

                saveProximityAlertPoint();

            }

        });*/

        button.setOnClickListener(new OnClickListener() {

            @Override

            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                locationManager.removeProximityAlert(proximityIntent);
                nm.cancel(notificationID);
                finish();
            }

        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void saveProximityAlertPoint() {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
            return;
        }
        Location location =

                locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if (location == null) {

            /*Toast.makeText(this, "No last known location. Aborting...",

                    Toast.LENGTH_LONG).show();*/

            return;

        }

        saveCoordinatesInPreferences((float) location.getLatitude(),

                (float) location.getLongitude());

        addProximityAlert(location.getLatitude(), location.getLongitude());
    }

    private void addProximityAlert(double latitude, double longitude) {

        Intent intent = new Intent(PROX_ALERT_INTENT);

        proximityIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
            return;
        }
        locationManager.addProximityAlert(

                latitude, // the latitude of the central point of the alert region

                longitude, // the longitude of the central point of the alert region

                POINT_RADIUS, // the radius of the central point of the alert region, in meters

                PROX_ALERT_EXPIRATION, // time for this proximity alert, in milliseconds, or -1 to indicate no expiration

                proximityIntent // will be used to generate an Intent to fire when entry to or exit from the alert region is detected

        );

        Intent i = new Intent();

        IntentFilter filter = new IntentFilter(PROX_ALERT_INTENT);

        registerReceiver(new ProximityIntentReceiver(), filter);

    }

    private void populateCoordinatesFromLastKnownLocation() {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
            return;
        }
        Location location =

                locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if (location != null) {

            latitudeEditText.setText(nf.format(location.getLatitude()));

            longitudeEditText.setText(nf.format(location.getLongitude()));

        }
    }

    private void saveCoordinatesInPreferences(float latitude, float longitude) {

        SharedPreferences prefs =

                this.getSharedPreferences(getClass().getSimpleName(),

                        Context.MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = prefs.edit();

        prefsEditor.putFloat(POINT_LATITUDE_KEY, latitude);

        prefsEditor.putFloat(POINT_LONGITUDE_KEY, longitude);

        prefsEditor.commit();
    }

    private Location retrievelocationFromPreferences() {

        SharedPreferences prefs =

                this.getSharedPreferences(getClass().getSimpleName(),

                        Context.MODE_PRIVATE);

        Location location = new Location("POINT_LOCATION");

        location.setLatitude(prefs.getFloat(POINT_LATITUDE_KEY, 0));

        location.setLongitude(prefs.getFloat(POINT_LONGITUDE_KEY, 0));

        return location;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("ProxAlert Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    public class MyLocationListener implements LocationListener {

        public void onLocationChanged(Location location) {

            Location pointLocation = retrievelocationFromPreferences();

            float distance = location.distanceTo(pointLocation);

            /*Toast.makeText(ProxAlertActivity.this,

                    "Distance from Point:" + distance, Toast.LENGTH_LONG).show();*/

        }

        public void onStatusChanged(String s, int i, Bundle b) {

        }

        public void onProviderDisabled(String s) {

        }

        public void onProviderEnabled(String s) {

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    final LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
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

                    Intent intent = new Intent(getApplicationContext(), ProxAlertActivity.class);


                    // permission was granted, yay!

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }

    }

    protected void displayNotification(Context context,String station_s){

        station_s = "Destinació: " + station_s;
        /*Intent i = new Intent(this, NotificationView.class);
        i.putExtra("notificationID", notificationID);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);*/
        //NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        //NotificationManager nm = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        nm = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        //int notificationID = 1002;
        CharSequence ticker = station_s;
        CharSequence contentTitle = station_s;
        CharSequence contentText = station_s;
        Notification noti = new NotificationCompat.Builder(context)
                //.setContentIntent(pendingIntent)
                .setTicker(ticker)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setSmallIcon(R.drawable.ic_stat_alarmico)
                .setOngoing(true)
                //.addAction(R.drawable.warning, ticker, pendingIntent)
                .build();
        nm.notify(notificationID, noti);

    }

}
