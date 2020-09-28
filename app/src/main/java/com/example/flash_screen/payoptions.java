package com.example.flash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class payoptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payoptions);
        final TextView paytm = findViewById(R.id.paytm);
        paytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("net.one97.paytm");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                }
                else {
                    Toast.makeText(payoptions.this, "There is no application available in your android", Toast.LENGTH_LONG).show();
                    String url = "https://paytm.com/";

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            }
        });
        final TextView phonepay = findViewById(R.id.phonepay);
        phonepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.phonepe.app");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                }
                else {
                    Toast.makeText(payoptions.this, "There is no application available in your android", Toast.LENGTH_LONG).show();
                    String url = "https://www.phonepe.com/en/";

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            }
        });
        final TextView gpay = findViewById(R.id.gpay);
        gpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.nbu.paisa.user");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                }
                else {
                    Toast.makeText(payoptions.this, "There is no application available in your android", Toast.LENGTH_LONG).show();

                    String url = "https://pay.google.com";

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            }
        });
        final TextView freecharge = findViewById(R.id.freecharge);
        freecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.freecharge.android");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                }
                else {
                    Toast.makeText(payoptions.this, "There is no application available in your android", Toast.LENGTH_LONG).show();

                    String url = "https://www.freecharge.in/mobile/auth/login?login=true";

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);

                }
            }
        });
        final TextView paypal = findViewById(R.id.paypal);
        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.paypal.android.p2pmobile");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                }
                else {
                    Toast.makeText(payoptions.this, "There is no application available in your android", Toast.LENGTH_LONG).show();

                    String url = "https://www.paypal.com/ca/for-you/account/create-account";

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            }
        });
        final TextView mobikwik = findViewById(R.id.mobikwik);
        mobikwik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.mobikwik_new");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                }
                else {
                    Toast.makeText(payoptions.this, "There is no package available in your android", Toast.LENGTH_LONG).show();


                                String url = "https://wallet.mobikwik.com";

                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);
                            }

            }
        });
    }

}
