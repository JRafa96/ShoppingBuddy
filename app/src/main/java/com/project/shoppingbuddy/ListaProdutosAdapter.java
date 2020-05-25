package com.project.shoppingbuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.project.shoppingbuddy.Classes.ListaProdutos;
import com.project.shoppingbuddy.Classes.Produtos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListaProdutosAdapter extends RecyclerView.Adapter<ListaProdutosAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    public ArrayList<ListaProdutos> listaprodutosList = new ArrayList<>();

    public ListaProdutosAdapter(Context ctx, ArrayList<ListaProdutos> listaprodutosArrayList){

        inflater = LayoutInflater.from(ctx);
        this.listaprodutosList = listaprodutosArrayList;
    }

    @Override
    public ListaProdutosAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.from(parent.getContext()).inflate(R.layout.lista_produtos_item, parent, false);
        ListaProdutosAdapter.MyViewHolder holder = new ListaProdutosAdapter.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ListaProdutosAdapter.MyViewHolder holder, int position) {
        holder.id_products.setText(String.valueOf(listaprodutosList.get(position).getId_products()));
        holder.nome_product.setText(String.valueOf(listaprodutosList.get(position).getNome()));
        holder.quantidade.setText(String.valueOf(listaprodutosList.get(position).getQuantidade()));



    }

    @Override
    public int getItemCount() {
        return listaprodutosList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView id_products,quantidade,nome_product;

        public MyViewHolder(View itemView) {
            super(itemView);

            id_products = itemView.findViewById(R.id.id_products);
            nome_product = itemView.findViewById(R.id.nome_product);
            quantidade = itemView.findViewById(R.id.quantidade);
        }
    }

    public void atualizarLista(JSONArray jsonArray){
        ArrayList<ListaProdutos> produtos = new ArrayList<>();
        for (int i=0 ; i < jsonArray.length() ;i++){
            JSONObject listProd = null;
            try {
                listProd = jsonArray.getJSONObject(i);
                ListaProdutos produto = new ListaProdutos();
                produto.setId_products(listProd.getInt("id_products"));
                produto.setNome(listProd.getString("nome"));
                produto.setQuantidade(listProd.getInt("quantidades"));

                produtos.add(produto);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        listaprodutosList = produtos;
    }

}
