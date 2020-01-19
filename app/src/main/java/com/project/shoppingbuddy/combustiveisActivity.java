package com.project.shoppingbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.ArrayList;

public class combustiveisActivity extends AppCompatActivity {

    private final Handler uiHandler = new Handler();
    private Combustivel combustivel;
    private PostoCombustivel postoCombustivel;
    private CombustiveisAdapter combustiveisAdapter;
    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private ArrayList<Combustivel> combustivelList = new ArrayList<>();
    private Spinner spinner;
    private static final String[] paths = {"Gasoleo Plus", "Gasoleo Simples", "Gasolina 95 Plus", "Gasolina 95 Simples" , "Gasolina 98 Plus" , "Gasolina 98 Simples" , "GPL Auto"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combustiveis);
        final RequestQueue queue = Volley.newRequestQueue(this);

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

                Toast.makeText(getApplicationContext(), "Clicou no " + paths[position], Toast.LENGTH_LONG).show();

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, AppConfig.URL_COMBUSTIVEIS + "?tipo=" + URLEncoder.encode(paths[position]),
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("resposta", "chegou a resposta" + response);
                                try {

                                    JSONArray jArray = new JSONArray(response);

                                    for (int i=0; i < jArray.length(); i++)
                                    {
                                        try {
                                            JSONObject row = jArray.getJSONObject(i);
                                            // Pulling items from the array
                                            String postoId = row.getString("postoId");
                                            String preco = row.getString("preco");
                                            String distancia = "2Km";

                                            combustivel = new Combustivel(postoId,preco,distancia);
                                            combustivelList.add(combustivel);

                                        } catch (JSONException e) {
                                            Log.e("jsonPosto", "Não conseguiu dar parse no JSON: \"" + e + "\"");
                                        }
                                    }

                                    combustiveisAdapter.notifyDataSetChanged();



                                    Log.d("jsonObj", "Parse no json");

                                } catch (Throwable t) {
                                    Log.e("jsonObj", "Não conseguiu dar parse no JSON: \"" + response + "\"");
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("resposta", "erro na resposta" + error);
                    }
                });

                queue.add(stringRequest);
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
}
