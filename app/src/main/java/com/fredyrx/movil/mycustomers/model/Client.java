package com.fredyrx.movil.mycustomers.model;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.io.Serializable;

public class Client extends SugarRecord<Client> implements Serializable{

    String name;
    String contact;
    String address;
    int icon;
    Double latitude;
    Double longitude;


    @Ignore
    LocationMarker locationMarker;

    public Client(){
    }

    public Client(String name, String contact, String address, int icon, Double latitude, Double longitude) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.icon = icon;
        this.latitude = latitude;
        this.longitude = longitude;
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
        if (locationMarker == null){
            this.locationMarker = new LocationMarker(latitude, longitude);
        }
        return locationMarker;
    }

    public void setLocationMarker(LocationMarker locationMarker) {
        this.locationMarker = locationMarker;
    }
}
