package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private final static String DB_Name="SignIn_Database";
    private final static int DB_Version=1;
    private final String ID_COL="ID";
    private final String table_name="Signin";
    private final String Email_COL="Emails";
    private final String Password_COL="Passwords";
    private final String Phone_COL="Phones";

    private User user;

    public DBHelper(Context context) {

        super(context, DB_Name, null, DB_Version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
           String query="CREATE TABLE " + table_name + "("
                   +ID_COL + "INTEGER Primary Key AutoIncrement,"
                   +Email_COL + "TEXT,"
                   +Password_COL + "TEXT,"
                   +Phone_COL + "TEXT)";

           db.execSQL(query);
    }

    public void addNewUser(String email,String Password,String Phone) {

        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(Email_COL,email);
        values.put(Password_COL,Password);
        values.put(Phone_COL,Phone);

        db.insert(table_name,null,values);

        db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(db);
    }


}
