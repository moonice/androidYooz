package com.yoozbit.yoozbit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText name,email,mobile,pass,pass2,code;
    Button register_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setupViews();
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataRegister();
            }
        });
    }

    private void setupViews() {

        name = (TextInputEditText) findViewById(R.id.register_username);
        email = (TextInputEditText) findViewById(R.id.register_email);
        mobile = (TextInputEditText) findViewById(R.id.register_phone);
        pass = (TextInputEditText) findViewById(R.id.register_pass);
        pass2 = (TextInputEditText) findViewById(R.id.register_pass2);
        code = (TextInputEditText)findViewById(R.id.register_code);
        register_btn=(Button)findViewById(R.id.register_btn);
    }//casting



    boolean isEmail(TextInputEditText emailText){
        CharSequence email= emailText.getText().toString();
        return (!TextUtils.isEmpty(email)&&Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(TextInputEditText text){
        CharSequence str=text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    private void checkDataRegister(){
        if (isEmpty(name)) {
            name.setError("لطفا نام کاربری را وارد نمایید");
        }else if (name.length()<6){
            name.setError("نام کاربری باید حداقل 6 حرف باشد");
        }

        if (isEmail(email)==false){
            email.setError("لطفا یک ایمیل معتبر وارد کنید");
        }

        if (isEmpty(mobile)){
            mobile.setError("لطفا شماره موبایل را وارد نمایید");
        }else if (mobile.length()<11){
            mobile.setError("شماره موبایل وارد شده نادرست است");
        }

        if (isEmpty(pass)){
            pass.setError("لطفا کلمه عبور را وارد نمایید");
        }else if (pass.length()<8){
            pass.setError("کلمه عبور باید حداقل 8 حرف باشد");
        }

        if (isEmpty(pass2)){
            pass2.setError("کلمه عبور را تکرار کنید");
        }else if (pass2!=pass){
            pass2.setError("کلمه عبور را عینا تکرار کنید");
        }

    }

    public void setCode(){
        code.getText().toString();
    }


    }

