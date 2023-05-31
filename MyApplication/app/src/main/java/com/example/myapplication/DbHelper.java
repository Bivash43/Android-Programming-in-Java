package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private Context context;
    static final String DB_NAME ="MyDb.db";
    static final int DB_VERSION = 1;

    static final String DB_TABLE ="USERS";
    static final String USER_ID ="ID";
    static final String USER_NAME ="user_name";
    static final String USER_PASSWORD ="user_password";

    private static final String DB_QUERY_CREATE = "CREATE TABLE " + DB_TABLE + " (" + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_NAME + " TEXT, " + USER_PASSWORD + " TEXT)";

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null , DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DB_QUERY_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DB_TABLE);
    }

    void insertData(String user , String pass){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_NAME,user);
        contentValues.put(USER_PASSWORD,pass);
        long response = database.insert(DB_TABLE, null, contentValues);

        if (response == -1){
            Toast.makeText(context, "Unable To Store Data", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Successfully Inserted", Toast.LENGTH_SHORT).show();
        }
    }

}
