package com.example.pedidos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_pedido);
/*
        recyclerView = findViewById(R.id.recyclerViewRP);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        recyclerAdapter = new RecyclerAdapter( MainActivity.this);
        recyclerView.setAdapter(recyclerAdapter);
*/
    }
}