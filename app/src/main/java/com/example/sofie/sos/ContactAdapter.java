package com.example.sofie.sos;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contact> {
    Context context;
    ArrayList<Contact> contacts=new ArrayList<Contact>();
    public ContactAdapter( Context context, ArrayList<Contact> list) {
        super(context, 0,list);
        this.context=context;
        contacts=list;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View listItem = convertView;

        if(listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.item_contact,parent,false);

        Contact contact = contacts.get(position);
        final int id=contact.getID();

        TextView name = (TextView) listItem.findViewById(R.id.name);
        name.setText(contact.getName());


        TextView release = (TextView) listItem.findViewById(R.id.lastname);
        release.setText(contact.getLastName());

        final View finalListItem = listItem;
        listItem.setOnClickListener(
                new AdapterView.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(finalListItem.getContext(), ContactActivity.class);
                        i.putExtra("id", String.valueOf(id));
                        context.startActivity(i);
                    }
                }
        );
        return listItem;
    }


    public int getId(int position) {
        return contacts.get(position).getID();

    }
}
