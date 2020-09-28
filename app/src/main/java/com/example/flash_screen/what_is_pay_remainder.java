package com.example.flash_screen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class what_is_pay_remainder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_is_pay_remainder);
        final TextView Q1 = findViewById(R.id.question1textview);
        final TextView Q2 = findViewById(R.id.question2textview);
        final TextView Q3 = findViewById(R.id.question3textview);
        final EditText queryquesn = findViewById(R.id.insertionedittext);
        Button b1 =findViewById(R.id.query_button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = (String) queryquesn.getText().toString();
                if (Q1.getText().toString().isEmpty()) {

                    if (query.contains("what") || query.contains("What")) {

                        Q1.setText("Pay Remainder is a application which help you to remaind payment you save and provide payment app gateway");
                    }
                    if (query.contains("How") || query.contains("How")) {
                        queryquesn.setText("You can save work to do on date of calender and to remind task in task remainder and go through payment link gateway");
                    }
                    else
                    {
                        Toast.makeText(what_is_pay_remainder.this,"Please enter a valid Query",Toast.LENGTH_SHORT).show();
                    }
                } else if (Q2.getText().toString().isEmpty()) {

                    if (query.contains("How") || query.contains("How")) {
                        Q2.setText("You can save work to do on date of calender and to remind task in task remainder and go through payment link gateway");
                    }
                    if (query.contains("what") || query.contains("What")) {
                        Q3.setText("Pay Remainder is a application which help you to remaind payment you save and provide payment app gateway");
                    }
                    else
                    {
                        Toast.makeText(what_is_pay_remainder.this,"Please enter a valid Query",Toast.LENGTH_SHORT).show();
                    }
                } else {


                    if (query.contains("How") || query.contains("How")) {
                        queryquesn.setText("You can save work to do on date of calender and to remind task in task remainder and go through payment link gateway");
                    }
                    if (query.contains("what") || query.contains("What")) {
                        queryquesn.setText("Pay Remainder is a application which help you to remaind payment you save and provide payment app gateway");
                    }
                    else
                    {
                        Toast.makeText(what_is_pay_remainder.this,"Please enter a valid Query",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
