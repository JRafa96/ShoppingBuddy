package com.project.shoppingbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.project.shoppingbuddy.helper.SQLiteHandler;
import com.project.shoppingbuddy.helper.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

public class listaComprasGActivity extends AppCompatActivity {
    private static final String TAG = listaComprasGActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private SessionManager session;
    private SQLiteHandler db;
    private Spinner sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_compras_g);

        sp = findViewById(R.id.sp1);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        session = new SessionManager(getApplicationContext());

        db = new SQLiteHandler(getApplicationContext());

        String tag_string_req = "req_lista";

        pDialog.setMessage("A listar ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.GET,
                AppConfig.URL_LISTAS, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                sp.setOnItemSelectedListener(response);
            }
        });
    }
}