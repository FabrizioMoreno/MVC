package com.example.mvc.Controller;

import com.example.mvc.Model.User;
import com.example.mvc.View.LoginView;

public class LoginControllerC implements  LoginController{

    LoginView loginView;

    public LoginControllerC(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void OnLogin(String email, String password) {
        User user = new User(email,password);
        int logincode = user.esValido();
        if(logincode == 0){
            loginView.LoginError("Introduce un correo");
        }else if(logincode == 1){
            loginView.LoginError("Introduce un correo valido");
        }else if(logincode == 2){
            loginView.LoginError("Introduce una contraseña");
        }else if(logincode == 3){
            loginView.LoginError("La contraseña debe tener mas de 6 caracteres");
        }else{
            loginView.LoginSuccess("Inicio de sesion correcto");
        }
    }
}
