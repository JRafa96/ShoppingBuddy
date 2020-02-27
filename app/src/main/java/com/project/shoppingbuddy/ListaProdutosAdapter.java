package com.project.shoppingbuddy;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.project.shoppingbuddy.Classes.ListaProdutos;

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

        View view = inflater.from(parent.getContext()).inflate(R.layout.produtos_item, parent, false);
        ListaProdutosAdapter.MyViewHolder holder = new ListaProdutosAdapter.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ListaProdutosAdapter.MyViewHolder holder, int position) {
        holder.id_products.setText(String.valueOf(listaprodutosList.get(position).getId_products()));
        holder.nome_product.setText(String.valueOf(listaprodutosList.get(position).getNome()));
        holder.price.setText(String.valueOf(listaprodutosList.get(position).getPrice()));

    }

    @Override
    public int getItemCount() {
        return listaprodutosList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView id_products,price,nome_product;

        public MyViewHolder(View itemView) {
            super(itemView);

            id_products = itemView.findViewById(R.id.id_products);
            nome_product = itemView.findViewById(R.id.nome_product);
            price = itemView.findViewById(R.id.price);

        }

    }
}
