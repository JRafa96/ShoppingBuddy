package com.project.shoppingbuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.project.shoppingbuddy.Classes.ListaProdutos;

import java.util.ArrayList;

public class ListaProdutosAdapter extends RecyclerView.Adapter<ListaProdutosAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<ListaProdutos> listaprodutosList;

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

        holder.id_listasproduct.setText(listaprodutosList.get(position).getId_listaProdutos());
        holder.id_lista.setText(listaprodutosList.get(position).getId_lista());
        holder.id_products.setText(listaprodutosList.get(position).getId_products());
        holder.price.setText(listaprodutosList.get(position).getId_lista());

    }

    @Override
    public int getItemCount() {
        return listaprodutosList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView id_listasproduct, id_lista,id_products,price;

        public MyViewHolder(View itemView) {
            super(itemView);

            id_listasproduct = itemView.findViewById(R.id.id);
            id_lista = itemView.findViewById(R.id.name);
            id_products = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.name);

        }

    }
}
