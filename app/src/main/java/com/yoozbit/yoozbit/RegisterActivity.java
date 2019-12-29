package com.yoozbit.yoozbit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText name,email,mobile,pass,pass2,code;
    Button register_btn;
    CheckBox rules_checkbox;
     boolean CheckData;
     private final String main_url = "https://yoozbit.com/apiAndroid/index.php?apiKey=lkevhfsvjk34g934hSDFSDFsd3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        setupViews();


        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new JSONTask().execute(main_url);


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
        rules_checkbox=(CheckBox)findViewById(R.id.rules_chechbox);
        register_btn=(Button)findViewById(R.id.register_btn);
    }//casting



    boolean isEmail(TextInputEditText emailText){
        CharSequence email= emailText.getText().toString();
        return (!TextUtils.isEmpty(email)&&Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }//checks validity of email so it's field is not empty and matches a valid email address's pattern

    boolean isEmpty(TextInputEditText text){
        CharSequence str=text.getText().toString();
        return TextUtils.isEmpty(str);
    }//checks the fields not empty

    private boolean checkDataRegister(){
        if (isEmpty(name)) {
            name.setError("لطفا نام کاربری را وارد نمایید");
            return false;
        }else if (name.length()<6){
            name.setError("نام کاربری باید حداقل 6 حرف باشد");
            return false;
        }

        if (isEmail(email)==false){
            email.setError("لطفا یک ایمیل معتبر وارد کنید");
            return false;
        }

        if (isEmpty(mobile)){
            mobile.setError("لطفا شماره موبایل را وارد نمایید");
            return false;
        }else if (mobile.length()<11){
            mobile.setError("شماره موبایل وارد شده نادرست است");
            return false;
        }

        if (isEmpty(pass)){
            pass.setError("لطفا کلمه عبور را وارد نمایید");
            return false;
        }else if (pass.length()<8){
            pass.setError("کلمه عبور باید حداقل 8 حرف باشد");
            return false;
        }

      /*  if (isEmpty(pass2)){
            pass2.setError("کلمه عبور را تکرار کنید");
            return false;
        }else if (pass != pass2){
            pass2.setError("کلمه عبور را عینا تکرار کنید");
            return false;
        }*/

        if (!rules_checkbox.isChecked()){
            Toast.makeText(this,"لطفا قوانین و شرایط را مطالعه کرده و بپذیرید",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }


    /*public void setCode(){
        code.getText().toString();
    }*/


    public class JSONTask extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection=null;
            BufferedReader reader=null;
            StringBuilder stringBuilder = new StringBuilder();

            try {
                URL url = new URL(params[0]);
                connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("GET");
                InputStream stream = connection.getInputStream();
                connection.connect();


                reader = new BufferedReader(new InputStreamReader(stream));


                String line = "";
                while ((line=reader.readLine()) != null){
                    stringBuilder.append(line);
                }
                return stringBuilder.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (connection != null){
                    connection.disconnect();
                }

                if (reader != null){
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return stringBuilder.toString();
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
        }
    }




}

