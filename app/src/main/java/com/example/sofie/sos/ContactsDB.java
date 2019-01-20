package com.example.sofie.sos;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ContactsDB {

    Context context;
    String [] columns={DBHelper.ID,DBHelper.NAME,DBHelper.LAST_NAME,DBHelper.PHONE};
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public ContactsDB(Context context){
        this.context= context;
        dbHelper= new DBHelper(context,"contacts",null,1);
    }

    public void open(){
        db= dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }


    public long insertContact(Contact c){
        ContentValues values = new ContentValues();


        values.put("NAME", c.getName());
        values.put("LAST_NAME", c.getLastName());
        values.put("PHONE", c.getPhone());
        return db.insert("CONTACTS",null,values);
    }

    public long updateContact(Contact c){
        ContentValues values = new ContentValues();
        values.put("ID", c.getID());
        values.put("NAME", c.getName());
        values.put("LAST_NAME", c.getLastName());
        values.put("PHONE", c.getPhone());
        return db.update("CONTACTS",values,"ID ="+c.getID(), null);
    }

    public Contact getContact(int id){
        Cursor c= db.query("CONTACTS", columns,"ID =" + id,null,null,null,null);
        return cursorToContact(c);
    }

    public ArrayList<Contact> getAll(){
        ArrayList<Contact> l=new ArrayList<Contact>();
        Cursor c= db.rawQuery("Select id, name, LAST_NAME, phone from contacts",null);
        if (c.getCount() == 0)
            return null;
        c.moveToFirst();
        do {
            Contact contact=new Contact();
            contact.setID(c.getInt(0));
            contact.setName(c.getString(1));
            contact.setLastName(c.getString(2));
            contact.setPhone(c.getString(3));
            l.add(contact);
        } while (c.moveToNext());
        return l;
    }

    private Contact cursorToContact(Cursor c) {
        if (c.getCount() == 0)
            return null;
        c.moveToFirst();
        Contact contact=new Contact();
        contact.setID(c.getInt(0));
        contact.setName(c.getString(1));
        contact.setLastName(c.getString(2));
        contact.setPhone(c.getString(3));
        return contact;
    }
}
