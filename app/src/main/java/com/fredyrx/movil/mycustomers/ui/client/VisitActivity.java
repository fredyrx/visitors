package com.fredyrx.movil.mycustomers.ui.client;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.fredyrx.movil.mycustomers.R;
import com.fredyrx.movil.mycustomers.VisitorsApp;
import com.fredyrx.movil.mycustomers.model.Client;
import com.fredyrx.movil.mycustomers.model.Visit;

import java.util.Date;

public class VisitActivity extends AppCompatActivity {

    TextInputEditText clientTextInput;
    TextInputEditText dateTextInput;
    TextInputEditText durationTextInput;
    TextInputEditText reasonTextInput;

    Client client;
    Visit visit;
    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        client = VisitorsApp.getInstance().getClient();
        date = new Date();

        visit = new Visit(client,date);

        clientTextInput = (TextInputEditText) findViewById(R.id.name_txt);
        dateTextInput = (TextInputEditText) findViewById(R.id.date_txt);
        durationTextInput = (TextInputEditText) findViewById(R.id.duration_txt);
        reasonTextInput = (TextInputEditText) findViewById(R.id.reason_txt);

        clientTextInput.setText(client.getName().toString());
        dateTextInput.setText(date.toString());



        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visit.setDuration( Integer.parseInt(durationTextInput.getText().toString()) );
                visit.setReason( reasonTextInput.getText().toString() );
                try{
                    visit.save();
                }catch (Exception e){
                    Log.d("SAVE:", e.getMessage());
                }
                Intent intent = new Intent(VisitActivity.this, AboutActivity.class);
                intent.setAction("regitered");
                startActivity(intent);
            }
        });
    }

}
