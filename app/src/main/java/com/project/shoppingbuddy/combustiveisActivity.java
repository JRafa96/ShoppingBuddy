package com.project.shoppingbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class combustiveisActivity extends AppCompatActivity {

    private final Handler uiHandler = new Handler();
    private Combustivel combustivel;
    private CombustiveisAdapter combustiveisAdapter;
    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private ArrayList<Combustivel> combustivelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combustiveis);





        recyclerView = findViewById(R.id.recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        combustiveisAdapter = new CombustiveisAdapter (this, combustivelList);
        recyclerView.setAdapter(combustiveisAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        progressDialog = ProgressDialog.show(this, "A carregar","Por favor espere...", true);
        progressDialog.setCancelable(true);


    }
}
