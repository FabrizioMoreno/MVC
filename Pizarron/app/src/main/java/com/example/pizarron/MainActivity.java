package com.example.pizarron;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textViewID;
    private Spinner spinnerTipo, spinnerColor;
    private EditText editTextLargo, editTextAncho, editTextArea, editTextID;
    private Button buttonGuardar, buttonBuscarID, buttonVerTotal;
    private ArrayAdapter arrayAdapter;

    private int ID,count;
    private ArrayList<Pizarron> arrayListPizarrones = new ArrayList<>();
    private Boolean finded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewID      = findViewById(R.id.textViewID);

        spinnerTipo     = findViewById(R.id.spinnerTipo);
        spinnerColor    = findViewById(R.id.spinnerColor);

        editTextArea    = findViewById(R.id.editTextNumberDecimalArea);
        editTextLargo   = findViewById(R.id.editTextNumberLargo);
        editTextAncho   = findViewById(R.id.editTextNumberAncho);
        editTextID      = findViewById(R.id.editTextID);

        buttonGuardar   = findViewById(R.id.buttonGuardar);
        buttonBuscarID  = findViewById(R.id.buttonBuscarID);
        buttonVerTotal  = findViewById(R.id.buttonVerTotal);

        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.Tipo,
                android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipo.setAdapter(arrayAdapter);
        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.Colores,
                android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerColor.setAdapter(arrayAdapter);
        ID = 1;
        textViewID.setText("ID:"+ ID);
        setChangedListeners();

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextAncho.getText().toString().isEmpty()|| editTextLargo.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Completa todos los campos para guardar",
                            Toast.LENGTH_SHORT).show();
                }else{
                    finded = false;
                    for (int i = 0; i < arrayListPizarrones.size(); i++) {
                        if (ID == arrayListPizarrones.get(i).getID()) {
                            finded=true;
                            count = i;
                            break;
                        }
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    View view1 = getLayoutInflater().inflate(R.layout.dialog_layout_guardar,null);
                    builder.setView(view1);

                    AlertDialog dialog = builder.create();
                    dialog.setCancelable(false);
                    dialog.show();
                    TextView textViewIDDialog2, textViewTipoDialog2,textViewAnchoDialog2,textViewLargoDialog2
                            , textViewColorDialog2, textViewAreaDialog2;
                    Button buttonCancelar, buttonEditar,buttonAceptar;
                    textViewIDDialog2       = view1.findViewById(R.id.textViewIDDialog2);
                    textViewTipoDialog2     = view1.findViewById(R.id.textViewTipoDialog2);
                    textViewLargoDialog2    = view1.findViewById(R.id.textViewLargoDialog2);
                    textViewAnchoDialog2    = view1.findViewById(R.id.textViewAnchoDialog2);
                    textViewColorDialog2    = view1.findViewById(R.id.textViewColorDialog2);
                    textViewAreaDialog2     = view1.findViewById(R.id.textViewAreaDialog2);
                    buttonCancelar          = view1.findViewById(R.id.buttonCancelar);
                    buttonEditar            = view1.findViewById(R.id.buttonEditar);
                    buttonAceptar           = view1.findViewById(R.id.buttonAceptar);

                    textViewIDDialog2.setText(""+ID); textViewTipoDialog2.setText(spinnerTipo.getSelectedItem().toString());
                    textViewLargoDialog2.setText(editTextLargo.getText().toString());
                    textViewAnchoDialog2.setText(editTextAncho.getText().toString());
                    textViewColorDialog2.setText(spinnerColor.getSelectedItem().toString());
                    textViewAreaDialog2.setText(editTextArea.getText().toString());

                    buttonCancelar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            vaciar();
                            dialog.hide();
                        }
                    });
                    buttonEditar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.hide();
                        }
                    });
                    buttonAceptar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(finded==true){
                                arrayListPizarrones.get(count).setID(ID);
                                arrayListPizarrones.get(count).setTipo(spinnerTipo.getSelectedItem().toString());
                                arrayListPizarrones.get(count).setAncho(Float.parseFloat(editTextAncho.getText().toString()));
                                arrayListPizarrones.get(count).setLargo(Float.parseFloat(editTextLargo.getText().toString()));
                                arrayListPizarrones.get(count).setColor(spinnerColor.getSelectedItemPosition());
                            }else{
                                arrayListPizarrones.add(new Pizarron(ID, spinnerTipo.getSelectedItem().toString(),
                                        Float.parseFloat(editTextAncho.getText().toString()),
                                        Float.parseFloat(editTextLargo.getText().toString()),
                                        spinnerColor.getSelectedItemPosition()));
                            }
                            Toast.makeText(getApplicationContext(),"Se guardo correctamente",Toast.LENGTH_SHORT).show();
                            vaciar();
                            dialog.hide();
                            siguienteID();
                            textViewID.setText("ID:"+ID);
                        }
                    });
                }

            }
        });
        buttonBuscarID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextID.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ingresa un ID para buscarlo", Toast.LENGTH_SHORT).show();
                }else{
                    finded = false;
                    for (int i = 0; i < arrayListPizarrones.size(); i++) {
                        if (editTextID.getText().toString().equals(arrayListPizarrones.get(i).getID()+"")) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            View view1 = getLayoutInflater().inflate(R.layout.dialog_layout_buscar,null);
                            builder.setView(view1);

                            AlertDialog dialog = builder.create();
                            dialog.setCancelable(false);
                            dialog.show();

                            TextView textViewIDDialog2Buscar, textViewTipoDialog2,textViewAnchoDialog2,textViewLargoDialog2
                                    , textViewColorDialog2, textViewAreaDialog2;
                            Button buttonEliminar, buttonEditar,buttonCerrar;
                            textViewIDDialog2Buscar = view1.findViewById(R.id.textViewIDDialog2Buscar);
                            textViewTipoDialog2     = view1.findViewById(R.id.textViewTipoDialog2Buscar);
                            textViewLargoDialog2    = view1.findViewById(R.id.textViewLargoDialog2Buscar);
                            textViewAnchoDialog2    = view1.findViewById(R.id.textViewAnchoDialog2Buscar);
                            textViewColorDialog2    = view1.findViewById(R.id.textViewColorDialog2Buscar);
                            textViewAreaDialog2     = view1.findViewById(R.id.textViewAreaDialog2Buscar);
                            buttonEliminar          = view1.findViewById(R.id.buttonEliminarBuscar);
                            buttonEditar            = view1.findViewById(R.id.buttonEditarBuscar);
                            buttonCerrar            = view1.findViewById(R.id.buttonCerrarBuscar);

                            textViewIDDialog2Buscar.setText(arrayListPizarrones.get(i).getID()+"");
                            textViewTipoDialog2.setText(arrayListPizarrones.get(i).getTipo());
                            textViewLargoDialog2.setText(arrayListPizarrones.get(i).getLargo()+"");
                            textViewAnchoDialog2.setText(arrayListPizarrones.get(i).getAncho()+"");
                            textViewColorDialog2.setText(arrayListPizarrones.get(i).toStringColor());
                            textViewAreaDialog2.setText(""+(arrayListPizarrones.get(i).getAncho()*
                                    arrayListPizarrones.get(i).getLargo()));
                            finded = true;
                            count = i;
                            buttonEliminar.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    arrayListPizarrones.remove(count);
                                    dialog.hide();
                                    Toast.makeText(getApplicationContext(), "Se elimino el registro",Toast.LENGTH_SHORT).show();
                                    vaciar();
                                }
                            });
                            buttonEditar.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    ID = arrayListPizarrones.get(count).getID();
                                    textViewID.setText("ID:"+ID);
                                    spinnerTipo.setSelection(arrayListPizarrones.get(count).toIntTipo());
                                    editTextLargo.setText(arrayListPizarrones.get(count).getLargo()+"");
                                    editTextAncho.setText(arrayListPizarrones.get(count).getAncho()+"");
                                    spinnerColor.setSelection(arrayListPizarrones.get(count).getColor());
                                    dialog.hide();
                                    editTextID.setText("");
                                }
                            });
                            buttonCerrar.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog.hide();
                                    vaciar();
                                }
                            });
                            break;
                        }
                    }
                    if(finded==false){
                        Toast.makeText(getApplicationContext(),"No se encontro el ID",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        buttonVerTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_layout_total,null);
                builder.setView(view1);

                AlertDialog dialog = builder.create();
                dialog.show();
                RecyclerView recyclerView;
                RecyclerAdapter recyclerAdapter;
                recyclerView    = view1.findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerAdapter = new RecyclerAdapter(arrayListPizarrones);
                recyclerView.setAdapter(recyclerAdapter);

            }
        });

    }
    public void setChangedListeners(){
        editTextAncho.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editTextLargo.getText().toString().isEmpty() == false &&
                        editTextAncho.getText().toString().isEmpty() == false){
                    float l = Float.parseFloat(editTextLargo.getText().toString());
                    float a = Float.parseFloat(editTextAncho.getText().toString());
                    editTextArea.setText(Float.toString(l*a) );
                }else{
                    editTextArea.setText(null);
                }
            }
        });
        editTextLargo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editTextLargo.getText().toString().isEmpty() == false &&
                        editTextAncho.getText().toString().isEmpty() == false){
                    float l = Float.parseFloat(editTextLargo.getText().toString());
                    float a = Float.parseFloat(editTextAncho.getText().toString());
                    editTextArea.setText(Float.toString(l*a) );
                }else{
                    editTextArea.setText(null);
                }
            }
        });
    }
    public void vaciar(){
        editTextLargo.setText("");
        editTextAncho.setText("");
        spinnerTipo.setSelection(0);
        spinnerColor.setSelection(0);
        editTextID.setText("");
    }
    public void siguienteID(){
        ID = arrayListPizarrones.get(arrayListPizarrones.size()-1).getID()+1;
    }
}































