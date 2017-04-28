package com.fredyrx.movil.mycustomers.model;

import com.orm.SugarRecord;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sistemas on 26/04/2017.
 */

public class Visit extends SugarRecord{

    Date visitDate;
    int duration;
    Client client;
    String reason;

    public Visit(){}


    public Visit(Client client, Date visitDate){
        this.visitDate = visitDate;
        this.client = client;
    }

    public Visit(Date VisitDate, int duration, Client client){
        this.visitDate = visitDate;
        this.duration = duration;
        this.client = client;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String  getDecoraterDate(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return df.format(visitDate);
    }
}
