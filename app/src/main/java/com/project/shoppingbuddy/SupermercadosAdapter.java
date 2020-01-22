package com.project.shoppingbuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.project.shoppingbuddy.Classes.Supermercado;

import java.util.ArrayList;

public class SupermercadosAdapter extends RecyclerView.Adapter<SupermercadosAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Supermercado> supermercadoArrayList;

    public SupermercadosAdapter(Context ctx, ArrayList<Supermercado> supermercadoArrayList){

        inflater = LayoutInflater.from(ctx);
        this.supermercadoArrayList = supermercadoArrayList;
    }

    @Override
    public SupermercadosAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(SupermercadosAdapter.MyViewHolder holder, int position) {

        holder.nome.setText(supermercadoArrayList.get(position).getName());
        holder.preço.setText(supermercadoArrayList.get(position).getPreço());
    }

    @Override
    public int getItemCount() {
        return supermercadoArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView nome, preço;

        public MyViewHolder(View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.nome);
            preço = itemView.findViewById(R.id.preço);

        }

    }
}