package com.example.flash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class rate_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_activity);

        final TextView t1 = (TextView)findViewById(R.id.textView);
        final RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.simpleRatingBar);
        Button b1 = (Button)findViewById(R.id.button4);
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String totalStars = "Total Stars " + simpleRatingBar.getNumStars();
               String rating = "Rating  " + simpleRatingBar.getRating();
               t1.setText("You rated "+rating+" out of "+totalStars);
               t1.setTextColor(Color.parseColor("#0000FF"));

           }
       });
    }
}
