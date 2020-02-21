package com.project.shoppingbuddy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.shoppingbuddy.Classes.Lista;
import com.project.shoppingbuddy.Classes.ListaProdutos;

import static com.project.shoppingbuddy.AppConfig.URL_LISTAS_PRODUTOS;

public class listaComprasGActivity extends AppCompatActivity {

    ArrayList<String> listItem = new ArrayList<String>();
    Spinner sp;

    RecyclerView recyclerView;
    ListaProdutosAdapter adapter1;
    ArrayList<ListaProdutos> listaprodutosList;

    String info;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_compras_g);

        //RecycleView
        //listaprodutosList = new ArrayList<>();

       // recyclerView = findViewById(R.id.recycler);
       // recyclerView.setHasFixedSize(true);
      //  recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Log.d("Aqui","Aqui");
        //SharedPreferences
        SharedPreferences sPref = this.getSharedPreferences("User",MODE_PRIVATE);
        info = sPref.getString("id","");

        Log.d("Aqui",info);

        //Spinner
        sp = (Spinner) findViewById(R.id.spLista);
        listItem = new ArrayList<String>();
        getdata();
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Setting the values to textviews for a selected item
                ;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
    }

        private void getdata() {
            Log.d("Aqui2","123");
            String tag_string_req = "req_register";

            StringRequest strReq = new StringRequest(Request.Method.POST,
                    AppConfig.URL_LISTAS, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    Log.d("Aqui2",response);
                    JSONArray j = null;
                    try {
                        j = new JSONArray(response);
                        empdetails(j);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("Aqui", "Registration Error: " + error.getMessage());

                }
            }) {

                @Override
                protected Map<String, String> getParams() {

                    Map<String, String> params = new HashMap<String, String>();
                    params.put("id", info);


                    return params;
                }

            };


            AppController.getInstance().addToRequestQueue(strReq, tag_string_req);







          /*  StringRequest stringRequest = new StringRequest("http://192.168.70.31/php/android_listas_api/getLista.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("Aqui2",response);
                            JSONArray j = null;
                            try {
                                j = new JSONArray(response);
                                empdetails(j);
                            } catch (JSONException e) {
                                e.printStackTrace();
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
                        params.put("id", info);

                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        */}

        private void empdetails(JSONArray j) {
            for (int i = 0; i < j.length(); i++) {
                try {
                    JSONObject json = j.getJSONObject(i);
                    listItem.add(json.getString("nome_lista"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            // arrayList.add(0,"Select Employee");
            sp.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, listItem ));
        }
       }



