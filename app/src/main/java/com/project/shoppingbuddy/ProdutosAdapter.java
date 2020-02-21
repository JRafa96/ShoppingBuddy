package com.project.shoppingbuddy;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.project.shoppingbuddy.Classes.Produtos;

import java.util.ArrayList;

public class ProdutosAdapter extends RecyclerView.Adapter<ProdutosAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<Produtos> produtosList;

    public ProdutosAdapter(Context ctx, ArrayList<Produtos> produtosArrayList){

        inflater = LayoutInflater.from(ctx);
        this.produtosList = produtosArrayList;
    }

    @Override
    public ProdutosAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.from(parent.getContext()).inflate(R.layout.produtos_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ProdutosAdapter.MyViewHolder holder, int position) {

        holder.id.setText(produtosList.get(position).getId());
        holder.name.setText(produtosList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return produtosList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView id, name;

        public MyViewHolder(View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);

        }

    }
}
