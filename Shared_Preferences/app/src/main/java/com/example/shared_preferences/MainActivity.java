package com.example.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextMultiline;
    Button counter;
    CheckBox remember;
    int count;
    String name;
    String message;
    boolean isChecked;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextTextPersonName);
        editTextMultiline = findViewById(R.id.editTextTextMultiLine);
        counter = findViewById(R.id.button);
        remember = findViewById(R.id.checkBox);
        count = 0;
        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                counter.setText(""+count);
            }
        });
        retrieveData();
    }

    @Override
    protected void onPause() {
        saveData();
        super.onPause();
    }
    public void saveData(){
        sharedPreferences = getSharedPreferences("SaveData", Context.MODE_PRIVATE);
        name = editTextName.getText().toString();
        message = editTextMultiline.getText().toString();
        if(remember.isChecked()){
            isChecked = true;
        }else{
            isChecked = false;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key name", name);
        editor.putString("key message",message);
        editor.putInt("key count",count);
        editor.putBoolean("key isChecked",isChecked);
        editor.commit();
        Toast.makeText(getApplicationContext(),"Se guardo", Toast.LENGTH_SHORT).show();
    }
    public void retrieveData(){
        sharedPreferences = getSharedPreferences("SaveData", MODE_PRIVATE);
        name = sharedPreferences.getString("key name",null);
        message = sharedPreferences.getString("key message",null);
        count = sharedPreferences.getInt("key count", 0);
        isChecked = sharedPreferences.getBoolean("key isChecked",false);

        editTextName .setText(name);
        editTextMultiline.setText(message);
        counter.setText(count+"");

        remember.setChecked(isChecked);


    }
}