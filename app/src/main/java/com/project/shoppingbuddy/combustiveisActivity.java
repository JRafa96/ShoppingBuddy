package com.project.shoppingbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;
import com.project.shoppingbuddy.helper.CombustivelComp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


public class combustiveisActivity extends AppCompatActivity {

    private final Handler uiHandler = new Handler();
    private Combustivel combustivel;
    private CombustiveisAdapter combustiveisAdapter;
    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private ArrayList<Combustivel> combustivelList = new ArrayList<>();
    private Spinner spinner;
    private static final String[] paths = {"Gasoleo Plus", "Gasoleo Simples", "Gasolina 95 Plus", "Gasolina 95 Simples" , "Gasolina 98 Plus" , "Gasolina 98 Simples" , "GPL Auto"};
    public static String parsedDistance;
    public static String response;
    private Button btn_Maps;
    private ArrayList<PostoCombustivel> postosList;
    private ArrayList<PostoCombustivel> postoCombustivelsList = new ArrayList<>();
    private FusedLocationProviderClient fusedLocationClient;
    LatLng myLatLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combustiveis);
        btn_Maps = findViewById(R.id.btn_Maps);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        setLocation();
        setPostos();


        btn_Maps.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),
                        combustiveisMapsActivity.class);
                startActivity(i);
            }

        });

        recyclerView = findViewById(R.id.recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        combustiveisAdapter = new CombustiveisAdapter (this, combustivelList);
        recyclerView.setAdapter(combustiveisAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        spinner = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

                combustivelList.clear();

                updatePrices(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }

        });






        /*progressDialog = ProgressDialog.show(this, "A carregar","Por favor espere...", true);
        progressDialog.setCancelable(true);*/


    }


    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
    }

    public String convertPostoId(String postoId){
        switch (postoId){
            case "1": return "Galp - Pernes";
            case "2": return "Galp Santarém";
            case "3": return "Galp - J.M.Cordeiro, Lda - N/S";
            case "4": return "Galp - J.M.Cordeiro, Lda - S/N";
            case "5": return "BP - A1 Santarém S/N";
            case "6": return "BP - A1 Santarém N/S";
            case "7": return "Prio - Alcanhões";
            case "8": return "BP - Pé da Pedreira";
            case "9": return "Repsol - Pernes";
            case "10": return "BP - Santarém";
            case "11": return "Repsol - S. Pedro - Santarém";
            case "12": return "Repsol - Santarém";
            case "13": return "Pingo Doce - Santarém";
            case "14": return "E.Leclerc - Santarém";
            case "15": return "Gasprocar - Santarém";
            default: return "Inválido";
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(),
                MainActivity.class);
        startActivity(i);
        finish();
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
                    JSONArray array = jsonObject.getJSONArray("routes");
                    JSONObject routes = array.getJSONObject(0);
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

    public void updatePrices(int position){
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, AppConfig.URL_COMBUSTIVEIS + "?tipo=" + URLEncoder.encode(paths[position]),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("resposta", "chegou a resposta" + response);
                        try {

                            JSONArray jArray = new JSONArray(response);

                            postoCombustivelsList.clear();

                            postosList = combustiveisSingleton.getInstance().getPostosList();


                            for (int i=0; i < jArray.length(); i++)
                            {
                                try {
                                    JSONObject row = jArray.getJSONObject(i);
                                    // Pulling items from the array
                                    String postoId = row.getString("postoId");
                                    String postoNome = convertPostoId(postoId);
                                    String preco = row.getString("preco");
                                    String distancia = "3Km";

                                    PostoCombustivel postoCombustivel = new PostoCombustivel();
                                    postoCombustivel.setPostoId(postoId);
                                    postoCombustivel.setPreco(preco);
                                    postoCombustivel.setNome(postoNome);
                                    for (int j = 0; j< postosList.size(); j++){
                                        if(Objects.equals(postoId, postosList.get(j).getPostoId())){
                                            Location locationA = new Location("A");
                                            locationA.setLatitude(Double.parseDouble(postosList.get(j).getLatitude()));
                                            locationA.setLongitude(Double.parseDouble(postosList.get(j).getLongitude()));
                                            Log.d("locationA", locationA.toString());

                                            Log.d("myLocation", myLatLng.toString());

                                            Location locationB = new Location("B");
                                            locationB.setLatitude(myLatLng.latitude);
                                            locationB.setLongitude(myLatLng.longitude);
                                            Log.d("locationB", locationB.toString());
                                            distancia = Double.toString(Math.round((locationA.distanceTo(locationB)/1000) * 10.0) / 10.0) + "Km";
                                            Log.d("distancia", distancia);

                                        }
                                    }
                                    postoCombustivelsList.add(postoCombustivel);




                                    Log.d("locationDist", myLatLng.toString());



                                    combustivel = new Combustivel(postoNome,preco,distancia);
                                    combustivelList.add(combustivel);

                                } catch (JSONException e) {
                                    Log.e("jsonPosto", "Erro no array 247: \"" + e + "\"");
                                }
                            }

                            Collections.sort(combustivelList, new CombustivelComp());
                            combustiveisSingleton.getInstance().setPostoCombustivelsList(postoCombustivelsList);

                            combustiveisAdapter.notifyDataSetChanged();



                            Log.d("jsonObj", "Parse no json 255");

                        } catch (Throwable t) {
                            Log.e("jsonObj", "Não conseguiu dar parse no JSON: 258 \"" + t + "\"");
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("resposta", "erro na resposta 265" + error);
            }
        });

        queue.add(stringRequest);

    }

    private void setPostos(){
        RequestQueue queue = Volley.newRequestQueue(this);


        StringRequest stringRequest = new StringRequest(Request.Method.GET, AppConfig.URL_COMBUSTIVEIS + "?postos",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            Log.d("response", response);

                            JSONArray jArray = new JSONArray(response);
                            ArrayList<PostoCombustivel> tempArray = new ArrayList<>();

                            for (int i=0; i < jArray.length(); i++)
                            {
                                try {
                                    JSONObject row = jArray.getJSONObject(i);
                                    // Pulling items from the array
                                    String postoId = row.getString("id");
                                    String lat =  row.getString("latitude");
                                    String lon =  row.getString("longitude");
                                    String nome = row.getString("nome");


                                    PostoCombustivel tempPC = new PostoCombustivel();
                                    tempPC.setNome(nome);
                                    tempPC.setPostoId(postoId);
                                    tempPC.setLatitude(lat);
                                    tempPC.setLongitude(lon);

                                    tempArray.add(tempPC);

                                    combustiveisSingleton.getInstance().setPostosList(tempArray);




                                } catch (JSONException e) {
                                    Log.e("jsonPosto", "Erro no array: \"" + e + "\"");
                                }
                            }

                            Log.d("jsonObj", "Parse no json dos postos");
                        } catch (Throwable t) {
                            Log.e("jsonObj", "Não conseguiu dar parse no JSON dos postos: \"" + t + "\"");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("response", "Erro response");
            }
        });


        queue.add(stringRequest);
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
