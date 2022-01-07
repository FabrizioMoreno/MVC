package com.example.textiles;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.textiles.Objects.Cliente;
import com.example.textiles.Objects.Descuento;
import com.example.textiles.Objects.FormaPago;
import com.example.textiles.Objects.Pedido;
import com.example.textiles.Objects.Persona;
import com.example.textiles.Objects.Producto;
import com.example.textiles.Objects.Vendedor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textViewID;
    Spinner spinnerCliente, spinnerVendedor, spinnerPago, spinnerProducto, spinnerDescuento;
    EditText editTextPrecio, editTextCantidad, editTextSubtotal, editTextTotal;
    Button buttonNuevo, buttonRealizar, buttonPedidos;

    ArrayList<Persona> arrayListPersona = new ArrayList<>();
    ArrayList<Cliente> arrayListCliente = new ArrayList<>();
    ArrayList<Vendedor> arrayListVendedor = new ArrayList<>();
    ArrayList<Producto> arrayListProducto = new ArrayList<>();
    ArrayList<FormaPago> arrayListPago = new ArrayList<>();
    ArrayList<Descuento> arrayListDescuento = new ArrayList<>();
    ArrayList<Pedido> arrayListPedido = new ArrayList<>();

    ArrayAdapter<Cliente> arrayAdapterCliente;
    ArrayAdapter<Vendedor> arrayAdapterVendedor;
    ArrayAdapter<Producto> arrayAdapterProducto;
    ArrayAdapter<FormaPago> arrayAdapterPago;
    ArrayAdapter<Descuento> arrayAdapterDescuento;

    int ID;
    Boolean editar = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewID      = findViewById(R.id.textViewID);

        spinnerCliente  = findViewById(R.id.spinnerCliente);
        spinnerVendedor = findViewById(R.id.spinnerVendedor);
        spinnerPago     = findViewById(R.id.spinnerPago);
        spinnerProducto = findViewById(R.id.spinnerProducto);
        spinnerDescuento= findViewById(R.id.spinnerDescuento);

        editTextPrecio  = findViewById(R.id.editTextPrecio);
        editTextCantidad= findViewById(R.id.editTextCantidad);
        editTextSubtotal= findViewById(R.id.editTextSubtotal);
        editTextTotal   = findViewById(R.id.editTextTotal);

        buttonNuevo     = findViewById(R.id.buttonNuevo);
        buttonRealizar  = findViewById(R.id.buttonRealizar);
        buttonPedidos   = findViewById(R.id.buttonVer);


        leer();

        arrayAdapterCliente = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,
                arrayListCliente);
        spinnerCliente.setAdapter(arrayAdapterCliente);

        arrayAdapterVendedor = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,
                arrayListVendedor);
        spinnerVendedor.setAdapter(arrayAdapterVendedor);

        arrayAdapterPago = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,
                arrayListPago);
        spinnerPago.setAdapter(arrayAdapterPago);

        arrayAdapterProducto = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,
                arrayListProducto);
        spinnerProducto.setAdapter(arrayAdapterProducto);

        arrayAdapterDescuento = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,
                arrayListDescuento);
        spinnerDescuento.setAdapter(arrayAdapterDescuento);

        if(ID == 0){
            ID = 1;
            textViewID.setText("ID pedido :"+ ID);
        }else{
            ID ++;
            textViewID.setText("ID pedido :"+ ID);
        }

        spinnerProducto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editTextPrecio.setText(arrayListProducto.get(spinnerProducto.getSelectedItemPosition()).getPrecio()+"");
                calcularSubtotal();
                calcularTotal();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerDescuento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                calcularTotal();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        editTextCantidad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                calcularSubtotal();
                calcularTotal();
            }
        });


        buttonNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_layout_nuevo,null);
                builder.setView(view1);

                AlertDialog dialog = builder.create();
                dialog.setCancelable(false);
                dialog.show();

                TextView textViewIDDescuento;
                EditText editTextDescuento;
                Button buttonAceptar, buttonCancelar;
                int IDDescuento = arrayListDescuento.get(arrayListDescuento.size()-1).getIdDescuento()+1;

                textViewIDDescuento  = view1.findViewById(R.id.textViewIDDescuento);
                editTextDescuento    = view1.findViewById(R.id.editTextDescuento);
                buttonAceptar        = view1.findViewById(R.id.buttonAceptar);
                buttonCancelar       = view1.findViewById(R.id.buttonCancelar);

                textViewIDDescuento.setText("ID : "+ IDDescuento);

                buttonCancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();

                    }
                });
                buttonAceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(editTextDescuento.getText().toString().isEmpty() == false){
                            arrayListDescuento.add(new Descuento(IDDescuento,
                                    Float.parseFloat(editTextDescuento.getText().toString())));
                            escribirDescuento();
                            arrayAdapterDescuento.notifyDataSetChanged();
                            dialog.cancel();
                        }else{
                            Toast.makeText(getApplicationContext(), "Completa el campo para continuar",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });


            }
        });
        buttonRealizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pedido pedido;
                if(editTextCantidad.getText().toString().isEmpty()==false){
                    pedido = new Pedido(ID,Float.parseFloat(editTextCantidad.getText().toString()),
                            Float.parseFloat(editTextSubtotal.getText().toString()),
                            Float.parseFloat(editTextTotal.getText().toString()),
                            arrayListCliente.get(spinnerCliente.getSelectedItemPosition()),
                            arrayListVendedor.get(spinnerVendedor.getSelectedItemPosition()),
                            arrayListProducto.get(spinnerProducto.getSelectedItemPosition()),
                            arrayListDescuento.get(spinnerDescuento.getSelectedItemPosition()),
                            arrayListPago.get(spinnerPago.getSelectedItemPosition()));
                    if(editar == false){
                        ID++;
                        arrayListPedido.add(pedido);
                        escribirPedido();
                    }else{
                        editarPedido(pedido);
                        editar = false;
                    }
                    vaciar();
                }else{
                    Toast.makeText(getApplicationContext(), "Completa todos los campos para continuar",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
        buttonPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_layout_pedidos,null);
                builder.setView(view1);

                AlertDialog dialog1 = builder.create();
                dialog1.show();

                RecyclerView recyclerView;
                RecyclerAdapter recyclerAdapter;
                recyclerView    = view1.findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerAdapter = new RecyclerAdapter(arrayListPedido, MainActivity.this);
                recyclerAdapter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Pedido pedidoSelected = arrayListPedido.get(recyclerView.getChildAdapterPosition(view));

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        View view2 = getLayoutInflater().inflate(R.layout.dialog_layout_seleccionar,null);
                        builder.setView(view2);

                        AlertDialog dialog2 = builder.create();
                        dialog2.setCancelable(false);
                        dialog2.show();

                        TextView textViewPedidoD, textViewClienteD, textViewVendedorD, textViewProductoD, textViewTotalD;
                        Button buttonEliminar, buttonCerrar, buttonEditar;

                        textViewPedidoD  = view2.findViewById(R.id.textViewPedido);
                        textViewClienteD = view2.findViewById(R.id.textViewClienteD);
                        textViewVendedorD= view2.findViewById(R.id.textViewVendedorD);
                        textViewProductoD= view2.findViewById(R.id.textViewProductoD);
                        textViewTotalD   = view2.findViewById(R.id.textViewTotalD);

                        buttonEliminar   = view2.findViewById(R.id.buttonEliminarSeleccionar);
                        buttonCerrar     = view2.findViewById(R.id.buttonCerrarSeleccionar);
                        buttonEditar     = view2.findViewById(R.id.buttonEditarSeleccionar);

                        textViewPedidoD.setText("Pedido :"+pedidoSelected.getIdPedido());
                        textViewClienteD.setText(pedidoSelected.getCliente().getPersona().getNombre());
                        textViewVendedorD.setText(pedidoSelected.getVendedor().getPersona().getNombre());
                        textViewProductoD.setText(pedidoSelected.getProducto().getNombre());
                        textViewTotalD.setText(pedidoSelected.getTotal()+"");

                        buttonEliminar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                eliminarPedido(pedidoSelected.getIdPedido());
                                actualizarPedido();
                                dialog2.cancel();
                                dialog1.cancel();
                            }
                        });
                        buttonCerrar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog2.cancel();
                            }
                        });
                        buttonEditar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                textViewID.setText("ID pedido :"+ pedidoSelected.getIdPedido());
                                editar = true;
                                buttonRealizar.setText("Editar Pedido");
                                spinnerCliente.setSelection(pedidoSelected.getCliente().getIdCliente()-1);
                                spinnerVendedor.setSelection(pedidoSelected.getVendedor().getIdVendedor()-1);
                                spinnerPago.setSelection(pedidoSelected.getFormaPago().getIdPago()-1);
                                spinnerProducto.setSelection(pedidoSelected.getProducto().getIdProducto()-1);
                                editTextCantidad.setText(pedidoSelected.getCantidad()+"");
                                spinnerDescuento.setSelection(pedidoSelected.getDescuento().getIdDescuento()-1);

                                dialog2.cancel();
                                dialog1.cancel();
                            }
                        });
                    }
                });
                recyclerView.setAdapter(recyclerAdapter);


            }
        });
    }
    public void leer(){
        ConexionController co = new ConexionController(getApplicationContext());

        arrayListPersona = Controller.getPersonas(co.getConnection());

        ArrayList<String> clientes = Controller.getClientes(co.getConnection());
        for (int i = 0; i < clientes.size(); i++){
            String [] c = clientes.get(i).split(",");
            arrayListCliente.add(new Cliente(getPersona(Integer.parseInt(c[0])),Integer.parseInt(c[1]),c[2]));
        }
        ArrayList<String> vendedor = Controller.getVendedor(co.getConnection());
        for (int i = 0; i < vendedor.size(); i++){
            String [] v = vendedor.get(i).split(",");
            arrayListVendedor.add(new Vendedor(getPersona(Integer.parseInt(v[0])),Integer.parseInt(v[1])
                    ,Integer.parseInt(v[2])));
        }

        arrayListPago = Controller.getPagos(co.getConnection());

        arrayListProducto = Controller.getProducto(co.getConnection());

        arrayListDescuento = Controller.getDescuento(co.getConnection());

        if(Controller.getIDpedido(co.getConnection()) != null){
            ID = Integer.parseInt(Controller.getIDpedido(co.getConnection()));
            ArrayList<String> pedidos = Controller.getPedidos(co.getConnection());
            for (int i = 0; i < pedidos.size(); i++){
                String [] ped = pedidos.get(i).split(",");
                arrayListPedido.add(new Pedido(Integer.parseInt(ped[0]),Float.parseFloat(ped[1]),
                        Float.parseFloat(ped[2]),Float.parseFloat(ped[3]),getCliente(Integer.parseInt(ped[4])),
                        getVendedor(Integer.parseInt(ped[5])),getProducto(Integer.parseInt(ped[6])),
                        getDescuento(Integer.parseInt(ped[7])),getPago(Integer.parseInt(ped[8]))));
            }
        }

    }
    public void vaciar(){
        textViewID.setText("ID pedido :"+ ID);
        buttonRealizar.setText("Realizar pedido");
        spinnerCliente.setSelection(0);
        spinnerVendedor.setSelection(0);
        spinnerPago.setSelection(0);
        spinnerProducto.setSelection(0);
        editTextCantidad.setText(null);
        spinnerDescuento.setSelection(0);
    }

    public Persona getPersona(int x){
        for (int i = 0; i < arrayListPersona.size(); i++){
            if(arrayListPersona.get(i).getID() == x){
                return arrayListPersona.get(i);
            }
        }
        return null;
    }
    public Cliente getCliente(int x){
        for (int i = 0; i < arrayListCliente.size(); i++){
            if(arrayListCliente.get(i).getIdCliente() == x){
                return arrayListCliente.get(i);
            }
        }
        return null;
    }
    public Vendedor getVendedor(int x){
        for (int i = 0; i < arrayListVendedor.size(); i++){
            if(arrayListVendedor.get(i).getIdVendedor() == x){
                return arrayListVendedor.get(i);
            }
        }
        return null;
    }
    public Producto getProducto(int x){
        for (int i = 0; i < arrayListProducto.size(); i++){
            if(arrayListProducto.get(i).getIdProducto() == x){
                return arrayListProducto.get(i);
            }
        }
        return null;
    }
    public Descuento getDescuento(int x){
        for (int i = 0; i < arrayListDescuento.size(); i++){
            if(arrayListDescuento.get(i).getIdDescuento() == x){
                return arrayListDescuento.get(i);
            }
        }
        return null;
    }
    public FormaPago getPago(int x){
        for (int i = 0; i < arrayListPago.size(); i++){
            if(arrayListPago.get(i).getIdPago() == x){
                return arrayListPago.get(i);
            }
        }
        return null;
    }

    public void calcularSubtotal(){
        if(editTextCantidad.getText().toString().isEmpty() == false){
            editTextSubtotal.setText((Float.parseFloat(editTextPrecio.getText().toString())*
                    Float.parseFloat(editTextCantidad.getText().toString()))+"");
        }else{
            editTextSubtotal.setText(null);
        }
    }
    public void calcularTotal(){
        if(editTextSubtotal.getText().toString().isEmpty() == false){
            float subtotal = Float.parseFloat(editTextSubtotal.getText().toString());
            float descuento = arrayListDescuento.get(spinnerDescuento.getSelectedItemPosition()).getPorcentaje();
            editTextTotal.setText(subtotal-((subtotal/100)*descuento)+"");
        }else{
            editTextTotal.setText(null);
        }
    }
    public void escribirDescuento(){
        ConexionController co = new ConexionController(getApplicationContext());

        Controller.setDescuento(co.getConnection(), arrayListDescuento.get(arrayListDescuento.size()-1));

        Toast.makeText(getApplicationContext(), "Se añadio exitosamente", Toast.LENGTH_LONG).show();
    }
    public void escribirPedido(){
        ConexionController co = new ConexionController(getApplicationContext());


        Controller.setPedido(co.getConnection(), arrayListPedido.get(arrayListPedido.size()-1));

        Toast.makeText(getApplicationContext(), "Se añadio exitosamente", Toast.LENGTH_LONG).show();
    }
    public  void actualizarPedido(){
        ConexionController co = new ConexionController(getApplicationContext());

        ArrayList<String> pedidos = Controller.getPedidos(co.getConnection());
        ArrayList<Pedido> arrayList = new ArrayList<Pedido>();
        for (int i = 0; i < pedidos.size(); i++){
            String [] ped = pedidos.get(i).split(",");
            arrayList.add(new Pedido(Integer.parseInt(ped[0]),Float.parseFloat(ped[1]),
                    Float.parseFloat(ped[2]),Float.parseFloat(ped[3]),getCliente(Integer.parseInt(ped[4])),
                    getVendedor(Integer.parseInt(ped[5])),getProducto(Integer.parseInt(ped[6])),
                    getDescuento(Integer.parseInt(ped[7])),getPago(Integer.parseInt(ped[8]))));
        }
        arrayListPedido = arrayList;
    }
    public void eliminarPedido(int i){
        ConexionController co = new ConexionController(getApplicationContext());

        Controller.deletePedido(co.getConnection(), i);

        Toast.makeText(getApplicationContext(), "Se elimino exitosamente", Toast.LENGTH_LONG).show();
    }
    public void editarPedido(Pedido pedido){
        ConexionController co = new ConexionController(getApplicationContext());

        Controller.updatePedido(co.getConnection(), pedido);

        Toast.makeText(getApplicationContext(), "Se edito exitosamente", Toast.LENGTH_LONG).show();
        actualizarPedido();
    }
}