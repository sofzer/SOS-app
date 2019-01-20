package com.example.sofie.sos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
    }

    public void add(View v){
        ContactsDB db=new ContactsDB(this);
        String name=((EditText) findViewById(R.id.name)).getText().toString();
        String lastname=((EditText) findViewById(R.id.lastname)).getText().toString();
        String phone=((EditText) findViewById(R.id.phone)).getText().toString();
        String note=((EditText) findViewById(R.id.note)).getText().toString();
        Contact contact=new Contact();
        contact.setName(name);
        contact.setLastName(lastname);
        contact.setPhone(phone);
        db.open();
        db.insertContact(contact);
        Toast.makeText(this, " Contact Ajouté",Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, ContactsActivity.class);
        startActivity(i);

    }
}
