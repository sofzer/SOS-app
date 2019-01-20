package com.example.sofie.sos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contcat);

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

    public void call(View v){
        TextView phone=(TextView) findViewById(R.id.phone);
        String number= phone.getText().toString();

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" +number));
        startActivity(intent);
    }

    public void modifier(View v){
        Intent i= getIntent();
        String id= i.getStringExtra("id");

        Intent intent=new Intent(this, ModifierContact.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}
