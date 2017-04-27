package com.fredyrx.movil.mycustomers.model;

import com.orm.SugarRecord;

public class Client extends SugarRecord{

    public String name;
    public String contact;
    public String address;
    public int icon;
    public LocationMarker locationMarker;

    public Client(){
    }


    public Client(String name, String contact, String address, int icon) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.icon = icon;
    }

    public Client(String name, String contact, String address, int icon, LocationMarker locationMarker) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.icon = icon;
        this.locationMarker = locationMarker;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public LocationMarker getLocationMarker() {
        return locationMarker;
    }

    public void setLocationMarker(LocationMarker locationMarker) {
        this.locationMarker = locationMarker;
    }
}
