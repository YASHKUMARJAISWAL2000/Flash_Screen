package com.example.flash_screen;

import android.content.Context;
import android.util.Patterns;
import android.widget.Toast;

public class ValidateInput {

    Context context;

    ValidateInput(Context context)
    {
        this.context = context;
    }

    boolean checkifemailisvalid(String email)
    {
        if(email.length() == 0)
        {
            Toast.makeText(context,"Email can not ne empty",Toast.LENGTH_LONG).show();
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Toast.makeText(context,"Email is Invalid",Toast.LENGTH_LONG).show();
            return false;
        }
        else
        {
            return true;
        }
    }

    boolean checkidpasswordisvalid(String password)
    {
        if (password.length()<6)
        {
            Toast.makeText(context,"Password can not be less than 6",Toast.LENGTH_LONG).show();
            return  false;
        }
        else
        {
            return true;
        }

    }
}
