package com.example.sofie.sos;

public class Contact {
     int ID;
     String Name;
     String LastName;
     String Phone;

    public Contact() {
    }

    public  int getID() {
        return ID;
    }

    public  void setID(int ID) {
        this.ID = ID;
    }

    public  String getName() {
        return Name;
    }

    public  void setName(String name) {
        Name = name;
    }

    public  String getLastName() {
        return LastName;
    }

    public  void setLastName(String lastName) {
        LastName = lastName;
    }

    public  String getPhone() {
        return Phone;
    }

    public  void setPhone(String phone) {
        Phone = phone;
    }
}
