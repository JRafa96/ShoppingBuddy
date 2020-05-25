package com.project.shoppingbuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.project.shoppingbuddy.Classes.SupermercadosProdutos;

import java.util.ArrayList;

public class SupermercadosProdutosAdapter extends RecyclerView.Adapter<SupermercadosProdutosAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    public ArrayList<SupermercadosProdutos> supermercadosProdutosList = new ArrayList<>();

    public SupermercadosProdutosAdapter(Context ctx, ArrayList<SupermercadosProdutos> supermercadosProdutosList){

        inflater = LayoutInflater.from(ctx);
        this.supermercadosProdutosList = supermercadosProdutosList;
    }

    @Override
    public SupermercadosProdutosAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.from(parent.getContext()).inflate(R.layout.supermercados_produtos_item, parent, false);
        SupermercadosProdutosAdapter.MyViewHolder holder = new SupermercadosProdutosAdapter.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(SupermercadosProdutosAdapter.MyViewHolder holder, int position) {
        holder.nomeSupermercados.setText(String.valueOf(supermercadosProdutosList.get(position).getNomeSupermercado()));
        holder.price.setText(String.valueOf(supermercadosProdutosList.get(position).getPrice()));
        holder.distancia.setText(String.valueOf(supermercadosProdutosList.get(position).getDistancia()));

    }

    @Override
    public int getItemCount() {
        return supermercadosProdutosList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView nomeSupermercados,price,distancia;

        public MyViewHolder(View itemView) {
            super(itemView);

            nomeSupermercados = itemView.findViewById(R.id.nomeSupermercados);
            price = itemView.findViewById(R.id.price);
            distancia = itemView.findViewById(R.id.distancia);

        }

    }
}
