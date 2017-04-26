package com.fredyrx.movil.mycustomers.model;

import java.io.Serializable;

public class LocationMarker implements Serializable {

    private double latitude;
    private double longitude;

    public LocationMarker(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
