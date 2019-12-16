package com.project.shoppingbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMaps extends AppCompatActivity {

    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);

        SupportMapFragment mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;

                //Ponto
                LatLng latLng= new LatLng(28.61,77.20);
                Marker mrk = map.addMarker(new MarkerOptions().position(latLng).title("Anjos"));
                mrk.showInfoWindow();
                map.moveCamera(CameraUpdateFactory.newLatLng((latLng)));
                map.animateCamera((CameraUpdateFactory.newLatLngZoom(latLng,15f)));

            }
        });
    }
}
