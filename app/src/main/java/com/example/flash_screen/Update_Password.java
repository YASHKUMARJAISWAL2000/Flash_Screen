package com.example.flash_screen;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_Password extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    EditText password1;
    EditText password2;
    Button button;
    EditText email123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__password);

        final FirebaseAuth firebaseAuth;
        ValidateInput validateInput;
        password1 = findViewById(R.id.pass1);
        password2 = findViewById(R.id.pass2);
        email123 = findViewById(R.id.email1);
        button = findViewById(R.id.button2);
        firebaseAuth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.sendPasswordResetEmail(email123.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Update_Password.this, " Password send to your mail ", Toast.LENGTH_LONG).show();

                        }
                        else {
                            Toast.makeText(Update_Password.this, "Error Occurred "+task.getException(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });


    }
}



