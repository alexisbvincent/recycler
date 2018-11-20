package com.example.alexisvincent.recycler;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

public class MyNotificationService extends Service {
    final int NOTIFICATION_ID = 16;
    final String Class_ID = "888";
    public MyNotificationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        displayNotification("Recycle Notification", "Plastic");
        stopSelf(); // Beendet den Service nach dem Ausführen des Codes (nachträglich ergänzt)
        return super.onStartCommand(intent, flags, startId);
    }
    private void displayNotification(String title, String text){

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, Class_ID)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(R.drawable.plastic)
                //.setLargeIcon(BitmapFactory.decodeResource(R.drawable.xyz))
                .setColor(getResources().getColor(R.color.colorAccent))
                .setVibrate(new long[]{0, 300, 300, 300})
                //.setSound()
                .setLights(Color.WHITE, 1000, 5000)
                //.setWhen(System.currentTimeMillis())
                .setContentIntent(notificationPendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(text));

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification.build());
    }

}
