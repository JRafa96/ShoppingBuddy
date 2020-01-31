package com.project.shoppingbuddy;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.shoppingbuddy.Classes.Supermercado;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class combustiveisActivity2 extends AppCompatActivity {

    private final Handler uiHandler = new Handler();
    private Supermercado supermercado;
    //private ArrayAdapter<String> adapter;
    private SupermercadosAdapter supermercadosAdapter;
    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private ArrayList<Supermercado> supermercadosList = new ArrayList<>();

    private class JSHtmlInterface {
        @android.webkit.JavascriptInterface
        public void showHTML(String html) {
            final String htmlContent = html;

            uiHandler.post(
                    new Runnable() {
                        @Override
                        public void run() {
                            Document doc = Jsoup.parse(htmlContent);
                            Elements elements = doc.select("div.name, div.price:nth-of-type(1) div.encoded");
                            supermercadosList.clear();
                            for (Element element : elements) {
                                supermercado = new Supermercado();
                                String[] divName = element.select("div.name").text().split("Actualizado");
                                String name = divName[0];
                                supermercado.setName(name);
                                String price = element.select("div.encoded").text();
                                supermercado.setPreço(price);

                                supermercadosList.add(supermercado);
                            }
                            supermercadosAdapter.notifyDataSetChanged();
                        }
                    }
            );
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combustiveis);

        recyclerView = findViewById(R.id.recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        supermercadosAdapter = new SupermercadosAdapter(this,supermercadosList);
        recyclerView.setAdapter(supermercadosAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        progressDialog = ProgressDialog.show(this, "Loading","Please wait...", true);
        progressDialog.setCancelable(true);

        try {
            final WebView browser = new WebView(this);
            browser.setVisibility(View.INVISIBLE);
            browser.setLayerType(View.LAYER_TYPE_NONE,null);
            browser.getSettings().setJavaScriptEnabled(true);
            browser.getSettings().setBlockNetworkImage(true);
            browser.getSettings().setDomStorageEnabled(false);
            browser.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            browser.getSettings().setLoadsImagesAutomatically(false);
            browser.getSettings().setGeolocationEnabled(false);
            browser.getSettings().setSupportZoom(false);

            browser.addJavascriptInterface(new JSHtmlInterface(), "JSBridge");

            browser.setWebViewClient(
                    new WebViewClient() {

                        @Override
                        public void onPageStarted(WebView view, String url, Bitmap favicon) {
                            progressDialog.show();
                            super.onPageStarted(view, url, favicon);
                        }

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            browser.loadUrl("javascript:window.JSBridge.showHTML('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
                            progressDialog.dismiss();
                        }
                    }
            );

            browser.loadUrl("https://www.maisgasolina.com/combustivel-mais-barato/santarem/santarem/sc95plus/todos/");
            if(getSupportActionBar()!=null) getSupportActionBar().setTitle(browser.getUrl());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
