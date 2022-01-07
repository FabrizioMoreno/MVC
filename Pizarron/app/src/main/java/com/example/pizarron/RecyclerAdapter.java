package com.example.pizarron;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{
    private ArrayList<Pizarron> arrayListPizarrones;
    public RecyclerAdapter(ArrayList<Pizarron> arrayListPizarrones) {
        this.arrayListPizarrones = arrayListPizarrones;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        holder.textViewID.setText(arrayListPizarrones.get(position).getID()+"");
        holder.textViewTipo.setText(arrayListPizarrones.get(position).getTipo());
        holder.textViewLargo.setText(arrayListPizarrones.get(position).getLargo()+"");
        holder.textViewAncho.setText(arrayListPizarrones.get(position).getAncho()+"");
        holder.textViewColor.setText(arrayListPizarrones.get(position).toStringColor());
/*
        holder.cardView.setOnClickListener(view -> {

        });*/

    }

    @Override
    public int getItemCount() {return arrayListPizarrones.size();}

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView textViewID, textViewTipo, textViewLargo, textViewAncho, textViewColor;
        CardView cardView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID  = itemView.findViewById(R.id.textViewIDRecycler);
            textViewTipo   = itemView.findViewById(R.id.textViewTipoRecycler);
            textViewLargo   = itemView.findViewById(R.id.textViewLargoRecycler);
            textViewAncho   = itemView.findViewById(R.id.textViewAnchoRecycler);
            textViewColor   = itemView.findViewById(R.id.textViewColorRecycler);
            cardView        = itemView.findViewById(R.id.cardView);
        }
    }
}
