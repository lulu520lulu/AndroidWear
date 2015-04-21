package com.example.liulu.androidwear;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i=new Intent();
        i.setClass(MainActivity.this,MainActivity.class);
        PendingIntent intent = PendingIntent.getActivity(
                MainActivity.this,
                0,
                i,
                PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder wearBuilder = new
                NotificationCompat.Builder(MainActivity.this);
        wearBuilder
                .setContentTitle("wear标题")
                .setContentText("wear内容")
                .setContentIntent(intent) ;
        NotificationCompat.WearableExtender wearableExtender = new
                NotificationCompat.WearableExtender()
                .setBackground(BitmapFactory.
                        decodeResource(getResources(), R.drawable.ic_launcher))
                .addPage(wearBuilder.build())
                .addPage(wearBuilder.build())
                .addPage(wearBuilder.build())
                .addAction(new NotificationCompat.
                        Action(R.drawable.ic_launcher,
                        "ActionButton1",intent))
                .addAction(new NotificationCompat.
                        Action(R.drawable.ic_launcher,
                        "ActionButton2",intent))
                .addAction(new NotificationCompat.
                        Action(R.drawable.ic_launcher,
                        "ActionButton3",intent));
        NotificationCompat.BigTextStyle bigTextStyle =
                new NotificationCompat.BigTextStyle();
        bigTextStyle.setBigContentTitle("大通知")
                .setSummaryText("大通知内容");
        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(MainActivity.this);
        builder.setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("标题")
                .setContentText("内容")
                .setContentIntent(intent)
                .setStyle(bigTextStyle)
                .extend(wearableExtender);


        NotificationManagerCompat managerCompat =
                NotificationManagerCompat.from(MainActivity.this);
        //第一个参数是通知的编号
        managerCompat.notify((int)(Math.random()*100),builder.build());
    }
}
