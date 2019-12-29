package com.yoozbit.yoozbit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText username,password;
    Button Login_btn;
    boolean DataLogin=checkDataLogin();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupViews();
        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (DataLogin==true){
                    Toast.makeText(LoginActivity.this,"اطلاعات وارد شده صحیح است",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this,"اطلاعات وارد شده صحیح نیست",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void setupViews() {
        username=(TextInputEditText)findViewById(R.id.Login_username);
        password=(TextInputEditText)findViewById(R.id.Login_pass);
        Login_btn=(Button)findViewById(R.id.Login_btn);
    }

    boolean isEmpty (TextInputEditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    private boolean checkDataLogin(){
        if (isEmpty(username)){
            username.setError("لطفا نام کاربری را وارد نمایید");
        }else if (username.length()<6){
            username.setError("نام کاربری حداقل 6 حرف است");
            return false;
        }

        if (isEmpty(password)){
            password.setError("لطفا کلمه عبور را وارد نمایید");
        }else if (password.length()<8){
            password.setError("کلمه عبور حداقل 8 حرف است");
            return false;
        }
        return true;
    }

}
