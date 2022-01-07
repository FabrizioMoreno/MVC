package com.example.pedidos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{
    private Context context;

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_p,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
/*
        holder.textViewEtapa.setText("Texto"+position);
        holder.textViewFecha.setText("Texto");
        holder.textViewPedido.setText("Texto");
        holder.textViewCliente.setText("Texto");
        holder.textViewRuta.setText("Texto");
        holder.textViewVendedor.setText("Texto");
        holder.textViewElaborado.setText("Texto");
        holder.textViewCantidad.setText("Texto");
        holder.textViewNeto.setText("Texto");
        holder.textViewEnviar.setText("Texto");

 */
        holder.textViewCodigo.setText("Texto"+position);
        holder.textViewProducto.setText("Texto");
        holder.textViewUnidad.setText("Texto");
        holder.textViewDescuento.setText("Texto");
        holder.textViewPrecio.setText("Texto");
        holder.textViewCantidad.setText("Texto");
        holder.textViewImporte.setText("Texto");
        holder.textViewObservacion.setText("Texto");
    holder.cardView.setOnClickListener(view -> {
            Toast.makeText(context, "Escogiste "+ position,Toast.LENGTH_LONG).show();
            });
    }

    @Override
    public int getItemCount() {return 20;}

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
/*
        TextView textViewEtapa, textViewFecha, textViewPedido, textViewCliente, textViewRuta, textViewVendedor,
                textViewElaborado, textViewCantidad, textViewNeto, textViewEnviar;

        CardView cardView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewEtapa  = itemView.findViewById(R.id.textViewEtapaR);
            textViewFecha   = itemView.findViewById(R.id.textViewFechaR);
            textViewPedido  = itemView.findViewById(R.id.textViewNoR);
            textViewCliente = itemView.findViewById(R.id.textViewClienteR);
            textViewRuta    = itemView.findViewById(R.id.textViewRutaR);
            textViewVendedor= itemView.findViewById(R.id.textViewVendedorR);
            textViewElaborado=itemView.findViewById(R.id.textViewElaboradoR);
            textViewCantidad=itemView.findViewById(R.id.textViewCantidadR);
            textViewNeto    =itemView.findViewById(R.id.textViewNetoR);
            textViewEnviar  = itemView.findViewById(R.id.textViewEnviarR);


            cardView       = itemView.findViewById(R.id.cardViewR);
*/
TextView textViewCodigo, textViewProducto, textViewUnidad, textViewDescuento, textViewPrecio, textViewCantidad,
        textViewImporte, textViewObservacion;

        CardView cardView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewCodigo  = itemView.findViewById(R.id.textViewCodigoRP);
            textViewProducto= itemView.findViewById(R.id.textViewProductoRP);
            textViewUnidad  = itemView.findViewById(R.id.textViewUnidadRP);
            textViewDescuento= itemView.findViewById(R.id.textViewDescuentoRP);
            textViewPrecio    = itemView.findViewById(R.id.textViewPrecioRP);
            textViewCantidad=itemView.findViewById(R.id.textViewCantidadRP);
            textViewImporte    =itemView.findViewById(R.id.textViewImporteRP);
            textViewObservacion = itemView.findViewById(R.id.textViewObservacionRP);

            cardView       = itemView.findViewById(R.id.cardViewP);


        }
    }
}
