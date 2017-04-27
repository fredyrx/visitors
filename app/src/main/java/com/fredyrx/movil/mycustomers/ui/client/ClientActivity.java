package com.fredyrx.movil.mycustomers.ui.client;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.fredyrx.movil.mycustomers.R;
import com.fredyrx.movil.mycustomers.VisitorsApp;
import com.fredyrx.movil.mycustomers.adapter.ClientAdapter;
import com.fredyrx.movil.mycustomers.data.dummy.ClientContent;
import com.fredyrx.movil.mycustomers.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientActivity extends AppCompatActivity implements ClientAdapter.OnClientItemListener {

    RecyclerView rcvClients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rcvClients = (RecyclerView) findViewById(R.id.list);

        List<Client> clients = new ArrayList<>();

        ClientContent.createBasaClients();
        clients = Client.listAll(Client.class);
        rcvClients.setAdapter(new ClientAdapter(clients, this));
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_client, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSelectedClient(Client client) {
        Intent intent = new Intent(this, AboutActivity.class);
        VisitorsApp.getInstance().setClient(client);
        //intent.putExtra("client", client);
        startActivity(intent);
    }
}
