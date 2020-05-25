package com.project.shoppingbuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.project.shoppingbuddy.Classes.Lista;
import com.project.shoppingbuddy.Classes.ListaProdutos;
import com.project.shoppingbuddy.Classes.Produtos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListaAdapter  extends RecyclerView.Adapter<ListaAdapter.MyViewHolder>  {
    private LayoutInflater inflater;
    public ArrayList<Produtos> listaList = new ArrayList<>();

    public ListaAdapter(Context ctx, ArrayList<Produtos> listaArrayList){

        inflater = LayoutInflater.from(ctx);
        this.listaList = listaArrayList;
    }

    @Override
    public ListaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.from(parent.getContext()).inflate(R.layout.lista_item, parent, false);
        ListaAdapter.MyViewHolder holder = new ListaAdapter.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ListaAdapter.MyViewHolder holder, int position) {
    //    holder.id_products.setText(String.valueOf(listaList.get(position).getId()));
        holder.nome.setText(String.valueOf(listaList.get(position).getName()));
        holder.quantidade.setText(String.valueOf(listaList.get(position).getQuantidade()));



    }

    @Override
    public int getItemCount() {
        return listaList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView id_products,quantidade,nome;

        public MyViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.edProdutos);
            quantidade = itemView.findViewById(R.id.edQuantidade);


        }

    }

    public void atualizarLista(JSONArray jsonArray){
        ArrayList<Produtos> produtos = new ArrayList<>();
        for (int i=0 ; i < jsonArray.length() ;i++){
            JSONObject listProd = null;
            try {
                listProd = jsonArray.getJSONObject(i);
                Produtos produto = new Produtos();
                produto.setId(listProd.getInt("id_products"));
                produto.setName(listProd.getString("nome"));
                produto.setQuantidade(listProd.getInt("quantidades"));

                produtos.add(produto);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        listaList = produtos;
    }
}
