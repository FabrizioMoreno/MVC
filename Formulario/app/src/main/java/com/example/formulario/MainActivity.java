package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;

    private EditText editTextNombre, editTextFecha, editTextEmail;
    private Button buttonEliminar, buttonVaciar, buttonAgregar;
    private ImageButton imageButton;

    private ArrayList<String> arrayListnombre = new ArrayList<>();
    private ArrayList<String> arrayListFecha = new ArrayList<>();
    private ArrayList<String> arrayListEmail = new ArrayList<>();

    int count = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextFecha = findViewById(R.id.editTextFecha);
        editTextEmail = findViewById(R.id.editTextEmail);

        buttonVaciar = findViewById(R.id.buttonVaciar);
        buttonEliminar = findViewById(R.id.buttonEliminar);
        buttonAgregar = findViewById(R.id.buttonAgregar);
        imageButton = findViewById(R.id.imageButtonCalendario);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int año = calendar.get(Calendar.YEAR);
                int mes = calendar.get(Calendar.MONTH);
                int dia = calendar.get(Calendar.DATE);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int año, int mes, int dia) {
                        editTextFecha.setText(dia+"/"+(mes+1)+"/"+año);
                    }
                }, año, mes, dia);
                datePickerDialog.show();
            }
        });

        buttonVaciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vaciar();
            }
        });
        buttonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < arrayListnombre.size(); i++) {
                    if (arrayListnombre.get(i).equals(editTextNombre.getText().toString()) &&
                            arrayListFecha.get(i).equals(editTextFecha.getText().toString()) &&
                            arrayListEmail.get(i).equals(editTextEmail.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Se elimino a " + arrayListnombre.get(i), Toast.LENGTH_LONG).show();
                        arrayListnombre.remove(i);
                        arrayListEmail.remove(i);
                        arrayListFecha.remove(i);
                        break;
                    }
                }
                recyclerAdapter.notifyDataSetChanged();
                vaciar();
            }
        });
        buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextNombre.getText().toString().equals("") || editTextFecha.getText().toString().equals("") ||
                        editTextEmail.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Rellena todos los campos", Toast.LENGTH_LONG).show();
                } else {
                    arrayListnombre.add(editTextNombre.getText().toString());
                    arrayListFecha.add(editTextFecha.getText().toString());
                    arrayListEmail.add(editTextEmail.getText().toString());
                    vaciar();
                    //recyclerAdapter.notifyDataSetChanged();
                    recyclerAdapter = new RecyclerAdapter(arrayListnombre, arrayListFecha, arrayListEmail, editTextNombre,
                            editTextFecha, editTextEmail, MainActivity.this, count);
                    recyclerView.setAdapter(recyclerAdapter);
                }

            }
        });
        recyclerAdapter = new RecyclerAdapter(arrayListnombre, arrayListFecha, arrayListEmail, editTextNombre,
                editTextFecha, editTextEmail, MainActivity.this,count);
        recyclerView.setAdapter(recyclerAdapter);
    }
    public void vaciar(){
        editTextNombre.setText("");
        editTextFecha.setText("");
        editTextEmail.setText("");
    }
}
