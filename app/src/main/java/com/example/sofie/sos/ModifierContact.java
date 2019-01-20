package com.example.sofie.sos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ModifierContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_contact);

        Intent i= getIntent();
        String id= i.getStringExtra("id");
        Log.e("ID=", id);
        ContactsDB db=new ContactsDB(this);
        db.open();
        Contact contact= new Contact();
        contact= db.getContact(Integer.parseInt(id));

        TextView name=(TextView) findViewById(R.id.name);
        TextView lastname=(TextView) findViewById(R.id.lastname);
        TextView phone=(TextView) findViewById(R.id.phone);

        name.setText(contact.getName());
        lastname.setText(contact.getLastName());
        phone.setText(contact.getPhone());

    }

    public void maj(View v){
        TextView name=(TextView) findViewById(R.id.name);
        TextView lastname=(TextView) findViewById(R.id.lastname);
        TextView phone=(TextView) findViewById(R.id.phone);
        ContactsDB db=new ContactsDB(this);
        db.open();
        Contact contact= new Contact();
        Intent i= getIntent();
        String id= i.getStringExtra("id");
        contact.setID(Integer.parseInt(id));
        contact.setPhone(phone.getText().toString());
        contact.setLastName(lastname.getText().toString());
        contact.setName(name.getText().toString());

        db.updateContact(contact);

        Toast.makeText(this, "Modifié",Toast.LENGTH_LONG).show();
        Intent in = new Intent(this, ContactsActivity.class);
        startActivity(in);



    }
}
