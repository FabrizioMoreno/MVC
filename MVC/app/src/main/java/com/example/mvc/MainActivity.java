package com.example.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvc.Controller.LoginController;
import com.example.mvc.Controller.LoginControllerC;
import com.example.mvc.View.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {
    EditText email, password;
    Button login;

    LoginController loginController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginController = new LoginControllerC(this);

        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);

        login = findViewById(R.id.buttonLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginController.OnLogin(email.getText().toString().trim(),password.getText().toString().trim());
            }
        });
    }

    @Override
    public void LoginSuccess(String message) {
        Toast.makeText(this, message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void LoginError(String message) {
        Toast.makeText(this, message,Toast.LENGTH_LONG).show();
    }
}