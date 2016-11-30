package com.fgcalarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.LocationManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import static android.app.PendingIntent.FLAG_CANCEL_CURRENT;

public class ProximityIntentReceiver extends BroadcastReceiver {

    private static final int NOTIFICATION_ID = 1000;

    @Override
    public void onReceive(Context context, Intent intent) {

        String key = LocationManager.KEY_PROXIMITY_ENTERING;

        Boolean entering = intent.getBooleanExtra(key, false);

        if (entering) {

            Log.d(getClass().getSimpleName(), "entering");

        }

        else {

            Log.d(getClass().getSimpleName(), "exiting");

        }

        NotificationManager notificationManager =

                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        //PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, null, 0);
        intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, FLAG_CANCEL_CURRENT);

        Notification notification = createNotification();

        notification.contentIntent = pendingIntent;
        String s = "Proximity Alert!";
        notification.tickerText = s;

        /*notification.setLatestEventInfo(context,

                "Proximity Alert!", "You are near your point of interest.", pendingIntent);*/

        //notificationManager.notify(NOTIFICATION_ID, notification);

        displayNotification(context);

    }

    private Notification createNotification() {

        Notification notification = new Notification();

        notification.icon = R.drawable.ic_notifications_black_24dp;

        notification.when = System.currentTimeMillis();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        notification.flags |= Notification.FLAG_SHOW_LIGHTS;

        notification.defaults |= Notification.DEFAULT_VIBRATE;

        notification.defaults |= Notification.DEFAULT_LIGHTS;

        notification.ledARGB = Color.WHITE;

        notification.ledOnMS = 1500;

        notification.ledOffMS = 1500;

        return notification;
    }

    protected void displayNotification(Context context){
        /*Intent i = new Intent(this, NotificationView.class);
        i.putExtra("notificationID", notificationID);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);*/
        //NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        NotificationManager nm = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        int notificationID = 1002;
        CharSequence ticker ="Proximity alert";
        CharSequence contentTitle = "Proximity alert";
        CharSequence contentText = "Proximity alert";
        Notification noti = new NotificationCompat.Builder(context)
                //.setContentIntent(pendingIntent)
                .setTicker(ticker)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                //.addAction(R.drawable.warning, ticker, pendingIntent)
                .setVibrate(new long[] {100, 250, 100, 500})
                .build();
        nm.notify(notificationID, noti);
    }

}