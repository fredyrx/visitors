package com.fredyrx.movil.mycustomers.ui.client;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.fredyrx.movil.mycustomers.R;
import com.fredyrx.movil.mycustomers.model.Client;

public class AboutActivity extends AppCompatActivity {

    TextView mTxvBusinesstName;
    TextView mTxvContact;
    TextView mTxvAddress;
    FloatingActionButton btnMap;

    private Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTxvBusinesstName = (TextView) findViewById(R.id.txvBusiness);
        mTxvContact = (TextView) findViewById(R.id.txvContact);
        mTxvAddress = (TextView) findViewById(R.id.txvAddress);
        btnMap = (FloatingActionButton) findViewById(R.id.fab);

        Intent intent = getIntent();

        if (intent != null) {
            client = (Client) intent.getSerializableExtra("client");

            if (client != null) {

                mTxvBusinesstName.setText(client.getName());
                mTxvContact.setText(client.getContact());
                mTxvAddress.setText(client.getAddress());

                btnMap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent mapIntent = new Intent(AboutActivity.this, MapsActivity.class);
                        mapIntent.putExtra("client", client);
                        startActivity(mapIntent);
                    }
                });
            }
        }

    }

}
