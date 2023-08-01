package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView TV_LOGIN;
    private EditText ET_Email,ET_Password;
    private Button bt_forgot_password,bt_login,bt_signup;
    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ET_Email=(EditText) findViewById(R.id.et_login_email);
        ET_Password=(EditText) findViewById(R.id.et_password);
        bt_forgot_password=(Button) findViewById(R.id.btn_forgot_password);
        bt_login=(Button) findViewById(R.id.btn_login);
        bt_signup=(Button) findViewById(R.id.btn_login_signup);

        dbHelper=new DBHelper(this);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                String username=ET_Email.getText().toString();
                String password=ET_Password.getText().toString();
                if(TextUtils.isEmpty(username) && TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                }

                //registerUser(username, password);
                Toast.makeText(MainActivity.this,"Login Completed",Toast.LENGTH_SHORT).show();
            }
        });

        bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(a);
               // finish();
            }
        });

        bt_forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Think and Type Again",Toast.LENGTH_SHORT).show();
            }
        });

    }

    /*private void registerUser(String email, String password) {
       User user = new User();
       user.setEmail(email);
       user.setPassword(password);
        Toast.makeText(MainActivity.this,"Successfully Completed",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this, HomeActivity.class);
        i.putExtra("email",email);
        startActivity(i);
        finish();
    }*/


}
