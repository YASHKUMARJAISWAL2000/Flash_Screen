package com.example.flash_screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.net.Inet4Address;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class clock extends AppCompatActivity {
    int counter=1;
    TimePicker alarmTime;
    TextClock currentTime;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        final String title = "You have to pay a payment";
        Intent intent = getIntent();
        final String message = intent.getStringExtra("message_key");
        alarmTime = findViewById(R.id.timepicker);
        currentTime = findViewById(R.id.curr);
        b1 =findViewById(R.id.button1);
        final Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter =0;
                Toast.makeText(clock.this,"Remainder Set Successfully ",Toast.LENGTH_SHORT).show();
            }
        });

        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (currentTime.getText().toString().equals(AlarmTime())){
                    if(counter ==0) {
                        NotificationManager mNotificationManager =
                                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            NotificationChannel channel = new NotificationChannel("YOUR_CHANNEL_ID",
                                    "YOUR_CHANNEL_NAME",
                                    NotificationManager.IMPORTANCE_DEFAULT);
                            channel.setDescription("YOUR_NOTIFICATION_CHANNEL_DESCRIPTION");
                            mNotificationManager.createNotificationChannel(channel);
                        }
                        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "YOUR_CHANNEL_ID")
                                .setSmallIcon(R.mipmap.ic_launcher) // notification icon
                                .setContentTitle(title) // title for notification
                                .setContentText(message)// message for notification
                                .setAutoCancel(true); // clear notification after click
                        Intent intent = new Intent(getApplicationContext(), payoptions.class);
                        PendingIntent pi = PendingIntent.getActivity(clock.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                        mBuilder.setContentIntent(pi);
                        mNotificationManager.notify(0, mBuilder.build());
                        counter++;
                    }

                }else{

                }
            }
        }, 0, 1000);
    }



    public String AlarmTime(){

        Integer alarmHours = alarmTime.getCurrentHour();
        Integer alarmMinutes = alarmTime.getCurrentMinute();
        String stringAlarmMinutes;

        if (alarmMinutes<10){
            stringAlarmMinutes =  "0";
            stringAlarmMinutes = stringAlarmMinutes.concat(alarmMinutes.toString());
        }else{
            stringAlarmMinutes = alarmMinutes.toString();
        }
        String stringAlarmTime;



        if(alarmHours>12){
            alarmHours -= 12;
            stringAlarmTime = alarmHours.toString().concat(":").concat(stringAlarmMinutes).concat(" PM");
        }else{
            stringAlarmTime = alarmHours.toString().concat(":").concat(stringAlarmMinutes).concat(" AM");
        }
        return stringAlarmTime;
    }
}


