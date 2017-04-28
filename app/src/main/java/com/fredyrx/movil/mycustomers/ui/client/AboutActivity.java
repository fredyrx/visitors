package com.fredyrx.movil.mycustomers.ui.client;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fredyrx.movil.mycustomers.R;
import com.fredyrx.movil.mycustomers.VisitorsApp;
import com.fredyrx.movil.mycustomers.adapter.VisitAdapter;
import com.fredyrx.movil.mycustomers.model.Client;
import com.fredyrx.movil.mycustomers.model.Visit;

import java.util.List;

public class AboutActivity extends AppCompatActivity{

    TextView mTxvBusinesstName;
    TextView mTxvContact;
    TextView mTxvAddress;
    Button btnLocation;
    FloatingActionButton btnRegisterVisit;


    RecyclerView vistitsRecyclerView;

    private Client client;

    private List<Visit> visits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTxvBusinesstName = (TextView) findViewById(R.id.txvBusiness);
        mTxvContact = (TextView) findViewById(R.id.txvContact);
        mTxvAddress = (TextView) findViewById(R.id.txvAddress);
        btnRegisterVisit = (FloatingActionButton) findViewById(R.id.fab);
        btnLocation = (Button) findViewById(R.id.btnLocation);

        Intent intent = getIntent();

        if (intent != null) {
            client = VisitorsApp.getInstance().getClient();
            if (client != null) {

                mTxvBusinesstName.setText(client.name);
                mTxvContact.setText(client.contact);
                mTxvAddress.setText(client.address);

                btnRegisterVisit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent mapIntent = new Intent(AboutActivity.this, VisitActivity.class);
                        VisitorsApp.getInstance().setClient(client);
                        startActivity(mapIntent);
                    }
                });

                btnLocation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent mapIntent = new Intent(AboutActivity.this, MapsActivity.class);
                        VisitorsApp.getInstance().setClient(client);
                        startActivity(mapIntent);
                    }
                });

                // List visits
                vistitsRecyclerView = (RecyclerView) findViewById(R.id.visitsRecyclerView);

                client = VisitorsApp.getInstance().getClient();
                visits = Visit.find(Visit.class,"client = ?", client.getId().toString());
                //visits = Visit.listAll(Visit.class);
                vistitsRecyclerView.setAdapter(new VisitAdapter(visits));
                vistitsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            }
        }

    }

}
