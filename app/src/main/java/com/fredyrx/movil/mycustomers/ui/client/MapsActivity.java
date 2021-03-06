package com.fredyrx.movil.mycustomers.ui.client;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.fredyrx.movil.mycustomers.R;
import com.fredyrx.movil.mycustomers.VisitorsApp;
import com.fredyrx.movil.mycustomers.model.Client;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        Intent intent = getIntent();

        if (intent != null) {
            //client = (Client) intent.getSerializableExtra("client");
            client = VisitorsApp.getInstance().getClient();
        }

        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng location = new LatLng(client.locationMarker.latitude, client.locationMarker.longitude);
        mMap.addMarker(new MarkerOptions().position(location)
                .title(client.name)
                .snippet(client.address)
        ).showInfoWindow();

        CameraPosition cameraPosition = CameraPosition.builder()
                .target(location)
                .zoom(17)
                .bearing(90)
                .build();
        // Animate the change in camera view over 2 seconds
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
