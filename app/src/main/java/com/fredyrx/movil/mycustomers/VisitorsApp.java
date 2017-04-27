package com.fredyrx.movil.mycustomers;

import android.app.Application;

import com.fredyrx.movil.mycustomers.model.Client;
import com.orm.SugarApp;
import com.orm.SugarDb;

/**
 * Created by Fredy Ramos on 27/04/2017.
 */

public class VisitorsApp extends SugarApp {

    private static VisitorsApp instance;

    Client client;

    @Override
    public void onCreate() {
        super.onCreate();

        //SugarContext.init(getApplicationContext());
        instance = this;
    }

    public static VisitorsApp getInstance(){
        return instance;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public Client getClient(){
        return client;
    }


}
