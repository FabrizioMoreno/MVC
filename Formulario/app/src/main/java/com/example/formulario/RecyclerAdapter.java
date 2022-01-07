package com.example.formulario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{
    private ArrayList<String> arrayListnombre;
    private ArrayList<String> arrayListFecha;
    private ArrayList<String> arrayListEmail;
    private EditText editTextNombre, editTextFecha, editTextEmail;
    private Context context;
    public int contador;

    public RecyclerAdapter(ArrayList<String> arrayListnombre, ArrayList<String> arrayListFecha,
                           ArrayList<String> arrayListEmail, EditText editTextNombre,
                           EditText editTextFecha, EditText editTextEmail, Context context,int count) {
        this.arrayListnombre = arrayListnombre;
        this.arrayListFecha = arrayListFecha;
        this.arrayListEmail = arrayListEmail;
        this.editTextNombre = editTextNombre;
        this.editTextFecha = editTextFecha;
        this.editTextEmail = editTextEmail;
        this.context = context;
        this.contador = count;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        holder.textViewNombre.setText(arrayListnombre.get(position));
        holder.textViewFecha.setText(arrayListFecha.get(position));
        holder.textViewEmail.setText(arrayListEmail.get(position));
        holder.cardView.setOnClickListener(view -> {
            Toast.makeText(context, "Escogiste "+ arrayListnombre.get(position),Toast.LENGTH_LONG).show();
            editTextNombre.setText(arrayListnombre.get(position));
            editTextFecha.setText(arrayListFecha.get(position));
            editTextEmail.setText(arrayListEmail.get(position));
            contador = holder.getAdapterPosition();
        });

    }

    @Override
    public int getItemCount() {return arrayListnombre.size();}

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView textViewNombre, textViewFecha, textViewEmail;
        CardView cardView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNombre  = itemView.findViewById(R.id.textViewNombreRecycler);
            textViewFecha   = itemView.findViewById(R.id.textViewFechaRecycler);
            textViewEmail   = itemView.findViewById(R.id.textViewEmailRecycler);

            cardView        = itemView.findViewById(R.id.cardView);
        }
    }
}
