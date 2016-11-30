package com.fgcalarm;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fgcalarm.model.entities.Station;
import com.fgcalarm.model.persistence.RepositoryManager;
import com.fgcalarm.model.provisioning.ProvisioningManager;
import com.vstechlab.easyfonts.EasyFonts;

import static android.app.PendingIntent.FLAG_CANCEL_CURRENT;

public class ActivadorActivity extends AppCompatActivity {

    private Station station;

    private Intent intent_not;
    private PendingIntent pendingIntentNot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        String estacio = "";
        Long id = 0L;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getLong("station_id");
            estacio = extras.getString("estacio");
            //The key argument here must match that used in the other activity
        }
        setContentView(R.layout.activity_activador);

       /* intent_not = new Intent(this, ActivadorActivity.class);
        pendingIntentNot = PendingIntent.getActivity(this, 0, intent_not, PendingIntent.FLAG_UPDATE_CURRENT);*/

        RepositoryManager.attatchImplementation(RepositoryManager.ImplementationType.IN_MEMORY);
        ProvisioningManager.provisionModel(ProvisioningManager.ProvisioningStrategy.HARDCODED);

        station = RepositoryManager.getStationRepository().findOne(id);

        double latitud = station.getLocation().getLatitude();
        double longitud = station.getLocation().getLongitude();
        float radius = 50;
        long expiration = 7200000;
        Intent intent = new Intent(this, VibrateService.class);
        final PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, FLAG_CANCEL_CURRENT);
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
        //displayNotification();


        final LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.addProximityAlert(latitud, longitud, radius, expiration, pendingIntent);


        Button button = (Button) findViewById(R.id.cancel_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                locationManager.removeProximityAlert(pendingIntent);
            }
        });


        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.fgcalarmlogo)
                        .setContentTitle(station.getName())
                        .setContentText(station.getName())
                        .setContentIntent(pendingIntentNot);


                     // Sets an ID for the notification
                     int mNotificationId = 001;
                     // Gets an instance of the NotificationManager service
                     NotificationManager mNotifyMgr =
                             (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                     // Builds the notification and issues it.
                     mNotifyMgr.notify(mNotificationId, mBuilder.build());

        //displayNotification();



    }








    protected void displayNotification(){
        /*Intent i = new Intent(this, NotificationView.class);
        i.putExtra("notificationID", notificationID);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);*/
        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        CharSequence ticker ="a eliminar";
        CharSequence contentTitle = "Expressió invàlida";
        CharSequence contentText = "Expressió invàlida, no es pot calcular";
        Notification noti = new NotificationCompat.Builder(this)
                //.setContentIntent(pendingIntent)
                .setTicker(ticker)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setSmallIcon(R.drawable.fgcalarmlogo)
                //.addAction(R.drawable.warning, ticker, pendingIntent)
                //.setVibrate(new long[] {100, 250, 100, 500})
                .build();
        nm.notify(001, noti);
    }














}
