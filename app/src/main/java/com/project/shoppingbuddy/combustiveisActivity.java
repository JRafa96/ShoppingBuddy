package com.project.shoppingbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class combustiveisActivity extends AppCompatActivity {

    private Button btnProcurar;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combustiveis);

        btnProcurar = findViewById(R.id.btnGetCombustiveis);
        result = findViewById(R.id.result);


        btnProcurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContent();
            }
        });
    }


    public void getContent(){


        new Thread(new Runnable() {
            @Override
            public void run() {

                final StringBuilder builder = new StringBuilder();

                try {
                    Document doc = Jsoup.connect("https://www.maisgasolina.com/combustivel-mais-barato/santarem/santarem/sc95/todos/").get();

                    //Lista dos postos class=box id=stationList
                    Elements lista = doc.select("#stationList");

                    //Selecionar o div de cada posto
                    Elements links = lista.select("a[href]");

                    //Elements test = doc.select("a:nth-of-type(1) .price > div.encoded");

                    //Iterar postos e extrair so o nome
                    for (Element link : links){
                        String[] divName = link.select("div.name").text().split("Actualizado");
                        String name = divName[0];

                        //Elements divPrices = link.select("a:nth-of-type(1) .price > div.encoded");

                        String preço = "";


                        builder.append("Posto: " + name + "\t Preço: " + preço).append("\n");
                    }



                }catch (IOException e){
                    builder.append("Erro: ").append(e.getMessage()).append("\n");
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText(builder.toString());
                    }
                });

            }
        }).start();


    }

}
