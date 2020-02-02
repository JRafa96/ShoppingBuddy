package com.project.shoppingbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class combustiveisMapsActivity extends AppCompatActivity {

    private GoogleMap map;
    private ArrayList<PostoCombustivel> postoCombustivelsList;
    private ArrayList<PostoCombustivel> postosList;
    private Map<LatLng, String> markers = new HashMap<LatLng,String>();
    SupportMapFragment mapFragment;
    private FusedLocationProviderClient fusedLocationClient;
    LatLng myLatLng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combustiveis_maps);
        mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);

        postoCombustivelsList = combustiveisSingleton.getInstance().getPostoCombustivelsList();
        postosList = combustiveisSingleton.getInstance().getPostosList();
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                1);







        for(int j = 0; j < postoCombustivelsList.size(); j++){
            for (int i = 0; i<postosList.size(); i++){
                if(Objects.equals(postoCombustivelsList.get(j).getPostoId(), postosList.get(i).getPostoId())){
                    Double lat = Double.parseDouble(postosList.get(i).getLatitude());
                    Double lon = Double.parseDouble(postosList.get(i).getLongitude());
                    LatLng latLng = new LatLng(lat,lon);
                    String preco = postoCombustivelsList.get(j).getPreco();
                    markers.put(latLng,preco);
                }
            }
        }

        addMarkers();

    }


    public void addMarkers(){
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);

                    setLocation();


                }


                Iterator it = markers.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    LatLng latLng = (LatLng) pair.getKey();
                    String postoPreço = (String) pair.getValue();
                    Log.d("marker", "latLng = " + latLng + " preco = " + postoPreço);
                    map.addMarker(new MarkerOptions().position(latLng).title(postoPreço)).showInfoWindow();

                    it.remove();
                }



                map.getUiSettings().setZoomControlsEnabled(false);
                map.getUiSettings().setMyLocationButtonEnabled(true);
                map.getUiSettings().setCompassEnabled(true);
                map.getUiSettings().setRotateGesturesEnabled(true);
                map.getUiSettings().setZoomGesturesEnabled(true);





            }


        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }


    public void setLocation(){

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            myLatLng = new LatLng(location.getLatitude(),location.getLongitude());
                            map.animateCamera(CameraUpdateFactory.newLatLngZoom(myLatLng, 15.5f), 4000, null);
                        }else{
                            Log.d("location", "erro getLocation");
                        }
                    }
                });

    }







}
