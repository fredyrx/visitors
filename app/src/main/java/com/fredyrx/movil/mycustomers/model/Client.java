package com.fredyrx.movil.mycustomers.model;

import java.io.Serializable;

public class Client implements Serializable{

    private String name;
    private String contact;
    private String address;
    private int icon;
    private LocationMarker locationMarker;

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
