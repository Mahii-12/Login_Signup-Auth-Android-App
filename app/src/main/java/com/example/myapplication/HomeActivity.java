package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends Activity {
    private TextView TV_username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        TV_username=(TextView) findViewById(R.id.idTVUserName);

        String mail = getIntent().getStringExtra("email");
        TV_username.setText(mail);

    }

}
