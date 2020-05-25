package com.project.shoppingbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;
import com.project.shoppingbuddy.Classes.ListaProdutos;
import com.project.shoppingbuddy.Classes.SupermercadosProdutos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ComparacoesActivity extends AppCompatActivity {
    ArrayList<SupermercadosProdutos> supermercadosProdutosList = new ArrayList<>();
    RecyclerView recyclerView;
    SupermercadosProdutosAdapter adapter;
    String id_lista = "22";
    public static String parsedDistance;
    public static String response;
    private FusedLocationProviderClient fusedLocationClient;
    LatLng myLatLng;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparacoes);

        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        supermercadosProdutosList = new ArrayList<>();

        //creating adapter object and setting it to recyclerview
        adapter = new SupermercadosProdutosAdapter(getApplicationContext(), supermercadosProdutosList);
        recyclerView.setAdapter(adapter);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        setLocation();
        loadProducts();
    }

    private void loadProducts() {
        try{
            Log.d("aqui_init", "ok" );
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.URL_SUPERMERCADOS_PRODUTOS1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.d("Aqui_response", response);

                            //converting the string to json array object
                            JSONObject array = new JSONObject(response);
                            Log.d("Aqui", String.valueOf(array.length()));

                            //traversing through all the object
                            String str = array.getString("distancia");
                            String latitude = str.substring(0,9);
                             String longitude = str.substring(10,19);

                            //adding the product to product list
                            supermercadosProdutosList.add(new SupermercadosProdutos(
                                    array.getString("id_Supermercados"),
                                    array.getDouble("price"),
                                    getDistance(myLatLng.latitude,myLatLng.longitude,Double.parseDouble(latitude),Double.parseDouble(longitude))));

                            System.out.println(latitude);
                            System.out.println(longitude);


                            String str1 = array.getString("distancia1");
                            String latitude1 = str1.substring(0,9);
                            String longitude1 = str1.substring(10,19);

                            supermercadosProdutosList.add(new SupermercadosProdutos(
                                    array.getString("id_Supermercados1"),
                                    array.getDouble("price1"),
                                    getDistance(myLatLng.latitude,myLatLng.longitude,Double.parseDouble(latitude1),Double.parseDouble(longitude1))));


                            String str2 = array.getString("distancia2");
                            String latitude2 = str2.substring(0,9);
                            String longitude2 = str2.substring(10,19);
                            supermercadosProdutosList.add(new SupermercadosProdutos(
                                    array.getString("id_Supermercados2"),
                                    array.getDouble("price2"),
                                    getDistance(myLatLng.latitude,myLatLng.longitude,Double.parseDouble(latitude2),Double.parseDouble(longitude2))));


                            String str3 = array.getString("distancia3");
                            String latitude3 = str3.substring(0,9);
                            String longitude3 = str3.substring(10,19);
                            supermercadosProdutosList.add(new SupermercadosProdutos(
                                    array.getString("id_Supermercados3"),
                                    array.getDouble("price3"),
                                    getDistance(myLatLng.latitude,myLatLng.longitude,Double.parseDouble(latitude3),Double.parseDouble(longitude3))));

                            String str4 = array.getString("distancia3");
                            String latitude4 = str3.substring(0,9);
                            String longitude4 = str3.substring(10,19);
                            supermercadosProdutosList.add(new SupermercadosProdutos(
                                    array.getString("id_Supermercados4"),
                                    array.getDouble("price4"),
                                    getDistance(myLatLng.latitude,myLatLng.longitude,Double.parseDouble(latitude4),Double.parseDouble(longitude4))));

                            Log.d("Aqui", supermercadosProdutosList.toString());

                            adapter.supermercadosProdutosList = supermercadosProdutosList;
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            Log.d("Aqui_error", e.getMessage());


                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                 Map<String, String> params = new HashMap<String, String>();
                params.put("id_lista", id_lista);
                return params;
            }

        };

        //adding our stringrequest to queue
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
    } catch(Exception exception){
            Log.d("aqui_erro", exception.getMessage());
        }
    }

    public void comparacoes(View view) {
        Intent in = new Intent(getApplicationContext(), GoogleMaps.class);
        startActivity(in);
    }

    public String getDistance(final double lat1, final double lon1, final double lat2, final double lon2){

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    URL url = new URL("http://maps.googleapis.com/maps/api/directions/json?origin=" + lat1 + "," + lon1 + "&destination=" + lat2 + "," + lon2 + "&sensor=false&units=metric&mode=driving");
                    final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    InputStream in = new BufferedInputStream(conn.getInputStream());
                    response = org.apache.commons.io.IOUtils.toString(in, "UTF-8");

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("routes");
                    JSONObject routes = jsonArray.getJSONObject(0);
                    JSONArray legs = routes.getJSONArray("legs");
                    JSONObject steps = legs.getJSONObject(0);
                    JSONObject distance = steps.getJSONObject("distance");
                    parsedDistance=distance.getString("text");

                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Toast.makeText(getApplicationContext(),
                "Distancia = " + parsedDistance, Toast.LENGTH_LONG)
                .show();
        return parsedDistance;
    }

    public void setLocation(){

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            myLatLng = new LatLng(location.getLatitude(),location.getLongitude());

                        }else{
                            Log.d("location", "erro getLocation");
                        }
                    }
                });

    }
}
