package com.example.mvc.Model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class User implements  UserModel{
    private String email, password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String email() {
        return email;
    }

    @Override
    public String contraseña() {
        return password;
    }

    @Override
    public int esValido() {
        if(TextUtils.isEmpty(email())){
            return 0;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email()).matches()){
            return 1;
        }else if(TextUtils.isEmpty(contraseña())){
            return 2;
        }else if(contraseña().length()<=5){
            return 3;
        }else{
            return -1;
        }

    }
}
