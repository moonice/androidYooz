package com.yoozbit.yoozbit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText name,email,mobile,pass,pass2,code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setupViews();
    }

    private void setupViews() {

        name = (TextInputEditText) findViewById(R.id.register_username);
        email = (TextInputEditText) findViewById(R.id.register_email);
        mobile = (TextInputEditText) findViewById(R.id.register_phone);
        pass = (TextInputEditText) findViewById(R.id.register_pass);
        pass2 = (TextInputEditText) findViewById(R.id.register_pass2);
    }




    public void setName(){

        name.getText().toString();
        if (name == null) {
            Toast.makeText(getApplicationContext(), "لطفا نام کاربری را وارد نمایید", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void setEmail(){

        email.getText().toString();
        return;
    }

    public void setMobile() {
        mobile.getText().toString();
        if (mobile == null || mobile.length() < 11) {
            Toast.makeText(getApplicationContext(), "شماره موبایل وارد شده نادرست است", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void setPass() {
        pass.getText().toString();
        if (pass == null) {
            Toast.makeText(getApplicationContext(), "لطفا کلمه عبور را وارد نمایید", Toast.LENGTH_SHORT).show();
            return;
        } else if (pass.length() < 5) {
            Toast.makeText(getApplicationContext(), "کلمه عبور باید حداقل 5 حرف باشد", Toast.LENGTH_SHORT).show();
        }
        return;
    }

    public void setPass2() {
        pass2.getText().toString();
        if (pass2 == null) {
            Toast.makeText(getApplicationContext(), "کلمه عبور را تکرار کنید", Toast.LENGTH_SHORT).show();
            return;
        } else if (pass2 != pass) {
            Toast.makeText(getApplicationContext(), "کلمه عبور را عینا تکرار کنید", Toast.LENGTH_SHORT).show();
            return;
        }

    }


    }

