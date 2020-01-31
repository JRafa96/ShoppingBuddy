package com.project.shoppingbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class combustiveisMapsActivity extends AppCompatActivity {

    private GoogleMap map;
    private ArrayList<PostoCombustivel> postoCombustivelsList;
    private Map<LatLng, String> markers = new HashMap<LatLng,String>();
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combustiveis_maps);
        mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);

        postoCombustivelsList = combustiveisSingleton.getInstance().getPostoCombustivelsList();


        RequestQueue queue = Volley.newRequestQueue(this);


        StringRequest stringRequest = new StringRequest(Request.Method.GET, AppConfig.URL_COMBUSTIVEIS + "?postos",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            Log.d("response", response);

                            JSONArray jArray = new JSONArray(response);

                            for (int i=0; i < jArray.length(); i++)
                            {
                                try {
                                    JSONObject row = jArray.getJSONObject(i);
                                    // Pulling items from the array
                                    String postoId = row.getString("id");
                                    Double lat =  Double.parseDouble(row.getString("latitude"));
                                    Double lon =  Double.parseDouble(row.getString("longitude"));
                                    String preco;
                                    LatLng latLng;

                                    Log.d("response postoId", postoId);

                                    for (int j = 0; j < postoCombustivelsList.size(); j++){

                                        Log.d("response postoId", postoCombustivelsList.get(j).getPostoId());

                                        if(postoCombustivelsList.get(j).getPostoId() == postoId){
                                            preco = row.getString(postoCombustivelsList.get(j).getPreco());
                                            latLng = new LatLng(lat,lon);
                                            markers.put(latLng,postoCombustivelsList.get(j).getNome());

                                            Log.d("marker", "lat = " + latLng + " posto = " + postoCombustivelsList.get(j).getNome());
                                        }else{
                                            Log.d("elseResponse", postoCombustivelsList.get(j).getPostoId());
                                        }
                                    }
                                } catch (JSONException e) {
                                    Log.e("jsonPosto", "Erro no array: \"" + e + "\"");
                                }
                            }
                            addMarkers();
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


    public void addMarkers(){
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;

                Iterator it = markers.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    LatLng latLng = (LatLng) pair.getKey();
                    String postoNome = (String) pair.getValue();
                    Log.d("marker", "lat = " + latLng + " posto = " + postoNome);
                    map.addMarker(new MarkerOptions().position(latLng).title(postoNome));
                    it.remove();
                }

            }
        });
    }
}
