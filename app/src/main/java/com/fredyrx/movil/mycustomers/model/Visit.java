package com.fredyrx.movil.mycustomers.model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by sistemas on 26/04/2017.
 */

public class Visit extends SugarRecord<Visit>{

    Date visitDate;
    int duration;
    Client client;

    public Visit(){}

    public Visit(Date VisitDate, int duration, Client client){
        this.visitDate = visitDate;
        this.duration = duration;
        this.client = client;
    }
}
