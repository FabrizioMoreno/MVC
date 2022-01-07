package com.example.textiles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.textiles.Objects.Pedido;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>
implements View.OnClickListener{
    private ArrayList<Pedido> arrayListPedidos;
    private Context context;
    private View.OnClickListener listener;
    public RecyclerAdapter(ArrayList<Pedido> arrayListPedidos, Context context) {
        this.arrayListPedidos = arrayListPedidos;
        this.context = context;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);

        view.setOnClickListener(this);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        holder.textViewID.setText(arrayListPedidos.get(position).getIdPedido()+"");
        holder.textViewCliente.setText(arrayListPedidos.get(position).getCliente().getPersona().getNombre()+"");
        holder.textViewVendedor.setText(arrayListPedidos.get(position).getVendedor().getPersona().getNombre()+"");
        holder.textViewProducto.setText(arrayListPedidos.get(position).getProducto().getNombre()+"");
        holder.textViewTotal.setText(arrayListPedidos.get(position).getTotal()+"");
    }

    @Override
    public int getItemCount() {return arrayListPedidos.size();}

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if(listener!= null){
            listener.onClick(view);
        }
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView textViewID, textViewCliente, textViewVendedor, textViewProducto, textViewTotal;
        CardView cardView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID          = itemView.findViewById(R.id.textViewIDRecycler);
            textViewCliente     = itemView.findViewById(R.id.textViewClienteRecycler);
            textViewVendedor    = itemView.findViewById(R.id.textViewVendedorRecycler);
            textViewProducto    = itemView.findViewById(R.id.textViewProductoRecycler);
            textViewTotal       = itemView.findViewById(R.id.textViewTotalRecycler);
            cardView            = itemView.findViewById(R.id.cardView);
        }
    }
}
