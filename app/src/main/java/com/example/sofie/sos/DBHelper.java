package com.example.sofie.sos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    static String TABLE="CONTACTS";
    static String ID="ID";
    static String NAME="NAME";
    static String LAST_NAME="LAST_NAME";
    static String PHONE="PHONE";
    static String CREATE_DB="create  table "+TABLE+" (ID  INTEGER PRIMARY KEY AUTOINCREMENT ,"+NAME+" TEXT NOT NULL ,"+
            LAST_NAME+" TEXT NOT NULL ,"+PHONE+" TEXT NOT NULL );";

    public DBHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
