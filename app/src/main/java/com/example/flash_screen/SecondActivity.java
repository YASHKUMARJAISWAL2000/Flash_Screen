package com.example.flash_screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mail;
    EditText password1;
    TextView btnsignup;
    Button signin;
    ValidateInput validateInput;
    String email;
    String pass;
    TextView forgotpass;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        validateInput = new ValidateInput(this);

        mail = findViewById(R.id.editText);
        password1 = findViewById(R.id.editText2);
        btnsignup = findViewById(R.id.textView2);
        signin = findViewById(R.id.button);
        forgotpass = findViewById(R.id.textView);
        TextView termcond = findViewById(R.id.textView4);
        signin.setOnClickListener(this);
        btnsignup.setOnClickListener(this);
        termcond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(i);
            }
        });
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this,Update_Password.class);
                startActivity(i);
            }
        });

    mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
            switch (id)
            {
                case R.id.button:
                    handleLoginBtnclick();
                    break;
                case R.id.textView2:
                    handleSignupBtnclick();
                    break;
            }
    }

    private void handleSignupBtnclick() {
            Intent i = new Intent(this,Registration.class);
            startActivity(i);
    }

    private void handleLoginBtnclick() {
        email = mail.getText().toString();
        pass = password1.getText().toString();
        if(validateInput.checkidpasswordisvalid(pass) && validateInput.checkifemailisvalid(email))
        {


            mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(SecondActivity.this,"Login in "+email,Toast.LENGTH_LONG).show();
                        Intent i = new Intent(SecondActivity.this,mainpage.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(SecondActivity.this,"Error Occurred"+task.getException(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }


}















