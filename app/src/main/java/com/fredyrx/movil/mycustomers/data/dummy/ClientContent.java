package com.fredyrx.movil.mycustomers.data.dummy;

import android.util.Log;

import com.fredyrx.movil.mycustomers.R;
import com.fredyrx.movil.mycustomers.model.Client;
import com.fredyrx.movil.mycustomers.model.LocationMarker;

import java.util.ArrayList;
import java.util.List;

public class ClientContent {

    public static final List<Client> ITEMS = new ArrayList<Client>();

    static {

        addItem(new Client(
                "Boticas y Salud S.A.C",
                "746-5248", "Jirón Alfredo Rosenblat 145",
                R.drawable.ic_client,
                new LocationMarker(-12.112596, -76.972134)
        ));
        addItem(new Client("Peru Seguro",
                "344-4343",
                "Av. Alfredo Benavides 5299",
                R.drawable.ic_client,
                new LocationMarker(-12.129534, -76.981935)
        ));
        addItem(new Client(
                "Deco S.A.C",
                "345-4743",
                "Av. San Juan 1150",
                R.drawable.ic_client,
                new LocationMarker(-12.154892, -76.972165)
        ));
        addItem(new Client(
                "Vican",
                "746-1487",
                "Av. San Luis 1485",
                R.drawable.ic_client,
                new LocationMarker(-12.084839, -76.996016)
        ));
        addItem(new Client(
                "Sherfarma",
                "746-2598",
                "Av.Javier Prado este 6900",
                R.drawable.ic_client,
                new LocationMarker(-12.062303, -76.942320)
        ));
        addItem(new Client(
                "NES S.A.C",
                "746-4684",
                "Av. aviación 3590",
                R.drawable.ic_client,
                new LocationMarker(-12.103760, -77.001371)
        ));

    }

    private static void addItem(Client item) {
        ITEMS.add(item);
    }

    public static void createBasaClients(){
        try{
            if (Client.count(Client.class,"",null) == 0){
                for (Client c: ClientContent.ITEMS) {
                    LocationMarker l = c.getLocationMarker();
                    l.save();
                    c.setLocationMarker(l);
                    c.save();
                }
            }
        }catch (Exception ex){
            Log.d("VISITORS",ex.getMessage());
        }
    }

}
