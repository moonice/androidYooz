package com.yoozbit.yoozbit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class ForgetPasswordActivity extends AppCompatActivity {

    TextInputEditText Forget_Email_edt;
    Button Forget_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        setupViews();

        Forget_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });


    }

    private void setupViews() {

        Forget_Email_edt=(TextInputEditText)findViewById(R.id.forget_email_edt);
        Forget_btn = (Button) findViewById(R.id.forget_btn);

    }

    boolean isEmpty (TextInputEditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isEmail(TextInputEditText emailText){
        CharSequence email= emailText.getText().toString();
        return (!TextUtils.isEmpty(email)&& Patterns.EMAIL_ADDRESS.matcher(email).matches());
    } //checks the pattern of the email is correct

    private void checkDataEntered(){

        if (isEmpty(Forget_Email_edt)){
            Forget_Email_edt.setError("لطفا ایمیل را وارد نمایید");

        }else if (isEmail(Forget_Email_edt)==false){
            Forget_Email_edt.setError("لطفا یک ایمیل معتبر وارد کنید");
        }
    }

}
