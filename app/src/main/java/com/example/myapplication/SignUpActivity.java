package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private TextView TV_signup;
    private EditText ET_password,ET_email,ET_Phone;
    private Button bt_request_otp,bt_submit_otp,bt_register,bt_goto_login;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ET_email=(EditText) findViewById(R.id.et_sign_email);
        ET_Phone=(EditText) findViewById(R.id.et_phone);
        ET_password=(EditText) findViewById(R.id.et_sign_password);
        bt_request_otp=(Button) findViewById(R.id.btn_request_otp);
        bt_submit_otp=(Button) findViewById(R.id.btn_submit_otp);
        bt_register=(Button) findViewById(R.id.btn_register);
        bt_goto_login=(Button) findViewById(R.id.btn_goto_login);

        dbHelper=new DBHelper(this);

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbHelper.getReadableDatabase();
                SQLiteDatabase db1=dbHelper.getWritableDatabase();
                Cursor c = db.rawQuery("SELECT * FROM Siginin WHERE emails='"
                                    + ET_email.getText().toString().trim() + "'" +
                                    "AND passwords='"+ET_password.getText().toString().trim()+"'"
                            , null);

                        String loginemail = c.getString(1);
                        String loginPhone = c.getString(2);
                        String loginPassword = c.getString(3);
                         registerUser(loginemail, loginPassword);
                        /*Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                        intent.putExtra("key_name",loginemail);
                        startActivity(intent);
                        clearText();
                        finish();*/
                }


        });

        bt_goto_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        bt_request_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUpActivity.this, "Reached Firebase free Limit, So not Provided", Toast.LENGTH_SHORT).show();
            }
        });

        bt_submit_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUpActivity.this,"Authentication using firebase reached",Toast.LENGTH_SHORT).show();
            }
        });



    }

   /* public void showMessage(String title,String message)
    {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }*/

    public void clearText()
    {
        ET_email.setText("");
        ET_Phone.setText("");
        ET_Phone.setText("");
    }
    private void registerUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        Toast.makeText(SignUpActivity.this, "Successfully Completed", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(SignUpActivity.this, HomeActivity.class);
        i.putExtra("email", email);
        startActivity(i);
        finish();
    }
}

