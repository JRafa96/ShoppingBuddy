package com.project.shoppingbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpResponse;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.project.shoppingbuddy.Classes.Lista;
import com.project.shoppingbuddy.Classes.ListaProdutos;
import com.project.shoppingbuddy.Classes.Produtos;

import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.project.shoppingbuddy.AppConfig.URL_LISTAS_PRODUTOS;


public class ListaComprasActivity extends AppCompatActivity {
    private EditText nome_lista, produtos, quantidades;
    Button insert, show, procurar, btnAdicionar, btnAddLista;
    RecyclerView recyclerView;
    List<String> produtosList ;
    JSONArray jsonArrayProdutos;
    private RequestQueue requestQueue;
    String info;

    ListaAdapter listaAdapter;
    ArrayList<Produtos> listaList = new ArrayList<>();


    JSONArray produtosEscolhidos = new JSONArray();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);
        nome_lista = (EditText) findViewById(R.id.edNome_lista);
        quantidades = (EditText) findViewById(R.id.edQuantidade);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnAddLista = findViewById(R.id.btnAddLista);

        SharedPreferences sPref = this.getSharedPreferences("User",MODE_PRIVATE);
        info = sPref.getString("id","");

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        listaList = new ArrayList<>();

        listaAdapter = new ListaAdapter(getApplicationContext(),new ArrayList<Produtos>());
        //creating adapter object and setting it to recyclerview
        recyclerView.setAdapter(listaAdapter);


        requestQueue = Volley.newRequestQueue(getApplicationContext());

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

                    listaAdapter.atualizarLista(produtosEscolhidos);
                    listaAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        });

        btnAddLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, AppConfig.URL_CREATE_LISTA, new Response.Listener<String>() {
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
                        parameters.put("id_user", info);
                        parameters.put("nome_lista", nome_lista.getText().toString());

                        return parameters;
                    }
                };
                requestQueue.add(request);
            }

        });


}
    }