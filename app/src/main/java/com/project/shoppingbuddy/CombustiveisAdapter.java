package com.project.shoppingbuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CombustiveisAdapter extends RecyclerView.Adapter<CombustiveisAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Combustivel> combustivelList;

    public CombustiveisAdapter(Context ctx, ArrayList<Combustivel> combustivelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.combustivelList = combustivelArrayList;
    }

    @Override
    public CombustiveisAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.from(parent.getContext()).inflate(R.layout.combustiveis_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(CombustiveisAdapter.MyViewHolder holder, int position) {

        holder.tipo.setText(combustivelList.get(position).getNome());
        holder.preço.setText(combustivelList.get(position).getPreço());
    }

    @Override
    public int getItemCount() {
        return combustivelList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tipo, preço, distancia;

        public MyViewHolder(View itemView) {
            super(itemView);

            tipo = itemView.findViewById(R.id.posto);
            preço = itemView.findViewById(R.id.preço);
            distancia = itemView.findViewById(R.id.distancia);

        }

    }
}