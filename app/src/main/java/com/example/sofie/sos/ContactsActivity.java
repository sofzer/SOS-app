package com.example.sofie.sos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        ContactsDB db=new ContactsDB(this);
        db.open();
        ArrayList<Contact> l= db.getAll();
        ListView list=(ListView) findViewById(R.id.list);
        ContactAdapter adapter;
        adapter = new ContactAdapter(this, l);
        list.setAdapter(adapter);



    }
}
