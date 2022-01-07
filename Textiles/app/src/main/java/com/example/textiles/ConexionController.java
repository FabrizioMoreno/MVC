package com.example.textiles;

import android.content.Context;
import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionController {
    Context contexto;
    public ConexionController(Context contexto){
        this.contexto = contexto;
    }
    public Connection getConnection() {
        Connection conexion = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://189.162.118.73;databaseName" +
                    "=Textiles;user=Textiles;password=123;");
        }catch (Exception e) {
            Toast.makeText(contexto, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return conexion;
    }

}
