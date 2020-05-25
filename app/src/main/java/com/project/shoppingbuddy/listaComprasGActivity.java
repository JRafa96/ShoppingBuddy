package com.project.shoppingbuddy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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
import java.util.List;
import java.util.Map;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.shoppingbuddy.Classes.Lista;
import com.project.shoppingbuddy.Classes.ListaProdutos;

import static com.project.shoppingbuddy.AppConfig.URL_LISTAS_PRODUTOS;

public class listaComprasGActivity extends AppCompatActivity {
    Button btnAdicionar, btnAddLista;
    EditText quantidades;
    //spinner
    ArrayList<String> listItem = new ArrayList<String>();
    Spinner sp;

    //the recyclerview
    ArrayList<ListaProdutos> listaprodutosList = new ArrayList<>();
    RecyclerView recyclerView;
    ListaProdutosAdapter adapter;
    String id_lista;
    JSONArray jsonArrayProdutos;
    List<String> produtosList ;
    private RequestQueue requestQueue;
    JSONArray produtosEscolhidos = new JSONArray();

    //SharedPrefence
    String info;

    //getData
    JSONArray jsonResponse;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_compras_g);
        quantidades = findViewById(R.id.edQuantidade);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnAddLista = findViewById(R.id.btnAddLista);
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

        requestQueue = Volley.newRequestQueue(getApplicationContext());


        getdata();


        StringRequest request = new StringRequest(Request.Method.POST, AppConfig.URL_OBTER_PRODUTOS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Log.d("joao",response);
                    jsonArrayProdutos = new JSONArray(response);
                    produtosList = new ArrayList<>();
                    for (int i=0 ; i < jsonArrayProdutos.length() ; i++){
                        JSONObject jsonObject = jsonArrayProdutos.getJSONObject(i);
                        produtosList.add(jsonObject.getString("nome"));
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.simple_dropdown_item_1line, produtosList);
                    AutoCompleteTextView textView = findViewById(R.id.autoProdutos);
                    textView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("erro",error.getMessage());
            }
        });

        requestQueue.add(request);

        ((AutoCompleteTextView)findViewById(R.id.autoProdutos)).setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
                String selection = (String) parent.getItemAtPosition(position);
                int pos = -1;

                for (int i = 0; i < produtosList.size(); i++) {
                    if (produtosList.get(i).equals(selection)) {
                        pos = i;
                        break;
                    }
                }
                System.out.println("Position " + pos); //check it now in Logcat
                try {
                    String idProdutos = ((JSONObject) jsonArrayProdutos.get(pos)).getString("id");
                    String name = ((JSONObject) jsonArrayProdutos.get(pos)).getString("nome");

                    JSONObject products = new JSONObject();

                    products.put("id_products",idProdutos);
                    products.put("nome",name);
                    products.put("quantidades",1);

                    produtosEscolhidos.put(products);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("quantidades",quantidades.toString());
                try {
                    if (produtosEscolhidos.length() > 0) {
                        JSONObject quantidadesAtualizadas = produtosEscolhidos.getJSONObject(produtosEscolhidos.length() - 1);
                        quantidadesAtualizadas.remove("quantidades");
                        quantidadesAtualizadas.put("quantidades", quantidades.getText().toString());
                    }

                    adapter.atualizarLista(produtosEscolhidos);
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        });

        btnAddLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, AppConfig.URL_CREATE_LISTA_PROD, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.println(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();

                        parameters.put("lista_produtos", produtosEscolhidos.toString());
                        parameters.put("id_lista", id_lista);

                        return parameters;
                    }
                };
                requestQueue.add(request);
            }

        });

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Setting the values to textviews for a selected item

                try {
                    JSONObject j = jsonResponse.getJSONObject(position);
                    String jsString = j.toString();
                    jsString=jsString.replace("\\t","");

                    j=new JSONObject(jsString);

                    Log.d("Aqui_jO",(j.toString()));
                    id_lista = j.getString("id_lista");

                    Log.d("Aqui_lista",(id_lista));

                } catch (JSONException e) {
                    Log.d("Aqui_erro",e.getMessage());
                }


                StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.URL_LISTAS_PRODUTOS,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    Log.d("Aqui3",response);

                                    //converting the string to json array object
                                    JSONArray array = new JSONArray(response);
                                    Log.d("Aqui4",String.valueOf(array.length()));

                                   listaprodutosList = new ArrayList<>();
                                    //traversing through all the object
                                    for (int i = 0; i < array.length(); i++) {

                                        //getting product object from json array
                                        JSONObject listaproduct = array.getJSONObject(i);

                                        //adding the product to product list
                                        listaprodutosList.add(new ListaProdutos(
                                            listaproduct.getInt("id_product"),
                                            listaproduct.getString("nome"),
                                            listaproduct.getInt("quantidade")
                                    ));
                                }

                                    Log.d("Aqui",String.valueOf(listaprodutosList.size()));

                                    adapter.listaprodutosList=listaprodutosList;
                                    adapter.notifyDataSetChanged();
                                } catch (JSONException e) {
                                    Log.d("Aqui_error",e.getMessage());
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        })
                {
                    @Override
                    protected Map<String, String> getParams () {

                    Map<String, String> params = new HashMap<String, String>();
                    params.put("id_lista",id_lista);
                    return params;
                }} ;

                //adding our stringrequest to queue
                Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

        private void getdata() {
            recyclerView = findViewById(R.id.recycler);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            //initializing the productlist
            listaprodutosList = new ArrayList<>();

            //creating adapter object and setting it to recyclerview
            adapter = new ListaProdutosAdapter(getApplicationContext(), listaprodutosList);
            recyclerView.setAdapter(adapter);


            Log.d("Aqui2","123");
            String tag_string_req = "req_register";

            StringRequest strReq = new StringRequest(Request.Method.POST,
                    AppConfig.URL_LISTAS, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    Log.d("Aqui2",response);
                    try {
                        jsonResponse = new JSONArray(response);
                        empdetails(jsonResponse);
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
}

        private void empdetails(JSONArray jsonResponse) {
            for (int i = 0; i < jsonResponse.length(); i++) {
                try {
                    JSONObject json = jsonResponse.getJSONObject(i);
                    listItem.add(json.getString("nome_lista"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            // arrayList.add(0,"Select Employee");
            sp.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, listItem ));
        }

    public void criarLista(View view) {
        Intent in = new Intent(getApplicationContext(),ListaComprasActivity.class);
        startActivity(in);
    }

    public void comparacoes(View view) {
        Intent in = new Intent(getApplicationContext(),ComparacoesActivity.class);
        startActivity(in);
    }
}



