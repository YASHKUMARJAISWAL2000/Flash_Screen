package com.example.flash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class mainpage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);


        final TextView cal = (TextView) findViewById(R.id.textView11);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainpage1 = new Intent(mainpage.this, calender.class);
                startActivity(mainpage1);
            }
        });

        final TextView linkage = findViewById(R.id.textView123);
        linkage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = new Intent(mainpage.this, payoptions.class);
                startActivity(launchIntent);

            }
        });
        final TextView todo = findViewById(R.id.todo);
        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = new Intent(mainpage.this, todolist.class);
                startActivity(launchIntent);


            }
        });
        final TextView share = (TextView) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String sharbody = "Try this new application for your comfort. Developer: Yash Kumar Jaiswal.Click on this link https://drive.google.com/file/d/1iOLcqXZAOTZeff96k6GBCSxGKQ58Tz3u/view?usp=sharing";
                String Sharesub = "This is the new application form your comfort   ";
                myIntent.putExtra(Intent.EXTRA_TEXT, sharbody);
                myIntent.putExtra(Intent.EXTRA_SUBJECT, Sharesub);
                startActivity(Intent.createChooser(myIntent, "Share Using"));
            }

        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu );

        return super.onCreateOptionsMenu(menu);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item1:
                Toast.makeText(mainpage.this," You select share ",Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String sharbody = "Try this new application for your comfort. Developer: Yash Kumar Jaiswal.Click on this link https://drive.google.com/file/d/1bDNTqsvENguFNxPs6eYID5mKvPqcgD_Z/view?usp=sharing";
                String Sharesub = "This is the new application just for your comfort  ";
                myIntent.putExtra(Intent.EXTRA_TEXT, sharbody);
                myIntent.putExtra(Intent.EXTRA_SUBJECT, Sharesub);
                startActivity(Intent.createChooser(myIntent, "Share Using"));
                return  true;

            case R.id.item2:
            Toast.makeText(mainpage.this," You Select RATE US ",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(mainpage.this,rate_activity.class);
                startActivity(i);
            return  true;
            case R.id.item3:
                Toast.makeText(mainpage.this," You Select What is Pay Remainder ",Toast.LENGTH_SHORT).show();
                Intent j = new Intent(mainpage.this, what_is_pay_remainder.class);
                startActivity(j);
                return true;

            case R.id.item4:
                Toast.makeText(mainpage.this," You Select Terms and Conditions* ",Toast.LENGTH_SHORT).show();
                Intent k = new Intent(mainpage.this, ThirdActivity.class);
                startActivity(k);
                return true;



            case R.id.item5:
                finish();
                System.exit(0);
                return  true;

    }
        return super.onOptionsItemSelected(item);
    }

}