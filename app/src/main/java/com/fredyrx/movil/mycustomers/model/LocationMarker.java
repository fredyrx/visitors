package com.fredyrx.movil.mycustomers.model;

import com.orm.SugarRecord;

public class LocationMarker extends SugarRecord {

    public Double latitude;
    public Double longitude;

    public LocationMarker() {
    }

    public LocationMarker(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
