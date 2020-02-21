package com.project.shoppingbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.project.shoppingbuddy.Classes.ListaProdutos;
import com.project.shoppingbuddy.Classes.Produtos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.project.shoppingbuddy.AppConfig.URL_LISTAS_PRODUTOS;


public class ListaComprasActivity extends AppCompatActivity {
    ArrayList<Produtos> produtosList;

    RecyclerView recyclerView;
    ProdutosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_compras);

        //RecycleView
        produtosList = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadListaProdutos();


    }

    private void loadListaProdutos(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_LISTAS_PRODUTOS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray products = new JSONArray(response);

                    for(int i=0; i<products.length();i++){
                        JSONObject productsObject = products.getJSONObject(i);
                        int id = productsObject.getInt("id");
                        String name = productsObject.getString("name");


                        Produtos produtos = new Produtos(id,name);
                        produtosList.add(produtos);
                    }
                    adapter = new ProdutosAdapter(getApplicationContext(),produtosList);
                    recyclerView.setAdapter(adapter);

                }catch (JSONException e) {

                }
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ListaComprasActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }

}
