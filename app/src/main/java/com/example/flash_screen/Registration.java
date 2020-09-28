package com.example.flash_screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registration extends AppCompatActivity {

    FirebaseAuth mAuth;

    EditText email;
    EditText pass1;
    EditText passagain;
    EditText number;
    Button Signup;
    ValidateInput validateInput;
    String Email, password1, passswordagain;
    TextView termsandconditions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        number = findViewById(R.id.editText5);
        email = findViewById(R.id.email1);
        pass1 = findViewById(R.id.pass1);
        passagain = findViewById(R.id.pass2);
        Signup = findViewById(R.id.button2);
        validateInput = new ValidateInput(this);

        termsandconditions =findViewById(R.id.textView8);
       termsandconditions.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(Registration.this,ThirdActivity.class);
               startActivity(i);
           }
       });


        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSignupBtnclick();
            }
        });
        mAuth = FirebaseAuth.getInstance();
    }

    private void handleSignupBtnclick() {
        Email = email.getText().toString();
        password1 = pass1.getText().toString();
        passswordagain = passagain.getText().toString();
        Toast.makeText(Registration.this, "Please wait Signup on Progress" , Toast.LENGTH_LONG).show();
        if (password1.equals(passswordagain)) {
            if (validateInput.checkifemailisvalid(Email) && validateInput.checkidpasswordisvalid(password1)) {

                mAuth.createUserWithEmailAndPassword(Email, password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Registration.this, "Sign up Successfully " + user.getEmail(), Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Registration.this, "Sign up Unsuccessfully " + task.getException(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            } else {
                Toast.makeText(getApplicationContext(), "Password cannot be less than 6 character or Enter correct Email ID ", Toast.LENGTH_LONG).show();
            }
        }
         else {
            Toast.makeText(getApplicationContext(), "Password do not match ", Toast.LENGTH_LONG).show();
            }
        }
    }
/*TextView TP =(TextView)findViewById(R.id.textView8);
        TP.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Registration.this, ThirdActivity.class);
                startActivity(intent1);
            }
        });*/


