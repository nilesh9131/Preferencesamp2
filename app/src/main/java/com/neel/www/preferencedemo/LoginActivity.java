package com.neel.www.preferencedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Nilesh Shinde on 07-06-2016.
 */
public class LoginActivity extends AppCompatActivity
{
     private EditText  edtusername,edtpassword;
    private Button loginbtn;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_main);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        showUserSettings();

    }

    private void showUserSettings() {

         edtusername = (EditText) findViewById(R.id.editText);
         edtpassword = (EditText) findViewById(R.id.editText2);
          loginbtn=(Button)findViewById(R.id.buttonlogin);



        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtusername.getText().toString().length()>0 && edtpassword.getText().toString().length()>0) {
                    String edtuser = edtusername.getText().toString();
                    String edtpass = edtpassword.getText().toString();
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("User", edtuser);
                    editor.putString("Pass", edtpass);
                    editor.commit();
                    Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_LONG).show();

                    Intent loginintent=new Intent(LoginActivity.this,MainActivity.class);
                    loginintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(loginintent);

                }else{
                    Toast.makeText(LoginActivity.this, "Please Enter User and Pass ", Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}
