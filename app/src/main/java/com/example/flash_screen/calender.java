package com.example.flash_screen;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.app.NotificationCompat;

        import android.app.NotificationChannel;
        import android.app.NotificationManager;
        import android.app.PendingIntent;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AutoCompleteTextView;
        import android.widget.Button;
        import android.widget.CalendarView;
        import android.widget.EditText;

        import java.io.File;
        import java.io.FileOutputStream;
        import java.io.FileWriter;
        import java.net.Inet4Address;
        import java.util.ArrayList;
        import java.util.List;

        import static java.lang.System.out;

public class calender extends AppCompatActivity {
    private int currentYear = 0;
    private int currentMonth = 0;
    private int currentDay = 0;

    private int Index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        final EditText textInput = findViewById(R.id.textInput);

        final CalendarView calenderview = findViewById(R.id.calendarView);


        final String[] message = new String[1];
        final List<String> calenderStrings = new ArrayList<>();

        final int numberofDays = 5000;
        final int[] days = new int[numberofDays];
        final int[] months = new int[numberofDays];
        final int[] years = new int[numberofDays];
        final View daycontent = findViewById(R.id.daycontent);

        calenderview.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                currentYear = year;
                currentMonth = month;
                currentDay = dayOfMonth;
                if (daycontent.getVisibility() == View.GONE) {
                    daycontent.setVisibility(View.VISIBLE);
                }
                for (int h = 0; h < Index; h++) {
                    if (years[h] == currentYear) {
                        for (int i = 0; i < Index; i++) {
                            if (days[i] == currentDay) {
                                for (int j = 0; j < Index; j++) {
                                    if (months[j] == currentMonth && days[j] == currentDay && years[j] == currentYear) {
                                        textInput.setText(calenderStrings.get(j));
                                         message[0] = calenderStrings.get(j);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
                textInput.setText("");
            }


        });
        final Button saveText = findViewById(R.id.savetextbutton);
        saveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                days[Index] = currentDay;
                months[Index] = currentMonth;
                years[Index] = currentYear;
                calenderStrings.add(Index, textInput.getText().toString());
                textInput.setText("");
                Index++;

                String str = message[0];

                // Create the Intent object of this class Context() to Second_activity class
                Intent intent = new Intent(getApplicationContext(), clock.class);

                // now by putExtra method put the value in key, value pair
                // key is message_key by this key we will receive the value, and put the string

                intent.putExtra("message_key", str);

                // start the Intent
                startActivity(intent);

            }
        });
        final Button todayButton = findViewById(R.id.todayButton);

        todayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calenderview.setDate(calenderview.getDate());
            }
        });
    }
}

