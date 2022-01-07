package com.example.textiles;

import android.widget.Toast;

import com.example.textiles.Objects.Cliente;
import com.example.textiles.Objects.Descuento;
import com.example.textiles.Objects.FormaPago;
import com.example.textiles.Objects.Pedido;
import com.example.textiles.Objects.Persona;
import com.example.textiles.Objects.Producto;
import com.example.textiles.Objects.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class Controller {
    public static ArrayList<Persona> getPersonas(Connection conexion){
        ArrayList<Persona> arrayListPersona = new ArrayList<>();
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement("Exec P_Persona_SELECT");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            while (rs.next()){
                Object [] fila = new Object[columnas];
                for(int i = 0; i<columnas; i++){
                    fila[i] = rs.getObject(i+1);
                }
                arrayListPersona.add(new Persona(Integer.parseInt(fila[0].toString()),
                        fila[1].toString(),fila[2].toString()));
            }
        }
        catch (Exception e) { }
        return arrayListPersona;
    }
    public static ArrayList<String> getClientes(Connection conexion){
        ArrayList<String> arrayListCliente = new ArrayList<>();
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement("Exec P_Cliente_SELECT");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            while (rs.next()){
                Object [] fila = new Object[columnas];
                for(int i = 0; i<columnas; i++){
                    fila[i] = rs.getObject(i+1);
                }
                arrayListCliente.add(fila[2]+","+fila[0]+","+fila[1]);
            }
        }
        catch (Exception e) { }
        return arrayListCliente;
    }
    public static ArrayList<String> getVendedor(Connection conexion){
        ArrayList<String> arrayListVendedor = new ArrayList<>();
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement("Exec P_Vendedor_SELECT");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            while (rs.next()){
                Object [] fila = new Object[columnas];
                for(int i = 0; i<columnas; i++){
                    fila[i] = rs.getObject(i+1);
                }
                arrayListVendedor.add(fila[2]+","+fila[0]+","+fila[1]);
            }
        }
        catch (Exception e) { }
        return arrayListVendedor;
    }
    public static ArrayList<FormaPago> getPagos(Connection conexion){

        ArrayList<FormaPago> arrayListPago = new ArrayList<>();
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement("Exec P_Pago_SELECT");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            while (rs.next()){
                Object [] fila = new Object[columnas];
                for(int i = 0; i<columnas; i++){
                    fila[i] = rs.getObject(i+1);
                }
                arrayListPago.add(new FormaPago(Integer.parseInt(fila[0].toString()),
                        fila[1].toString()));
            }
        }
        catch (Exception e) { }
        return arrayListPago;
    }
    public static ArrayList<Producto> getProducto(Connection conexion){
        ArrayList<Producto> arrayListProducto = new ArrayList<>();
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement("Exec P_Producto_SELECT");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            while (rs.next()){
                Object [] fila = new Object[columnas];
                for(int i = 0; i<columnas; i++){
                    fila[i] = rs.getObject(i+1);
                }
                arrayListProducto.add(new Producto(Integer.parseInt(fila[0].toString()),
                        fila[1].toString(), Float.parseFloat(fila[2].toString()),Float.parseFloat(fila[3].toString())));
            }
        }
        catch (Exception e) { }
        return arrayListProducto;
    }
    public static ArrayList<Descuento> getDescuento(Connection conexion){

        ArrayList<Descuento> arrayListDescuento = new ArrayList<>();
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement("Exec P_Descuento_SELECT");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            while (rs.next()){
                Object [] fila = new Object[columnas];
                for(int i = 0; i<columnas; i++){
                    fila[i] = rs.getObject(i+1);
                }
                arrayListDescuento.add(new Descuento(Integer.parseInt(fila[0].toString()),
                        Float.parseFloat(fila[1].toString())));
            }
        }
        catch (Exception e) { }
        return arrayListDescuento;
    }

    public static ArrayList<String> getPedidos(Connection conexion){
        ArrayList<String> arrayListPedidos = new ArrayList<>();
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement("Exec P_Pedidos_SELECT");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            while (rs.next()){
                Object [] fila = new Object[columnas];
                for(int i = 0; i<columnas; i++){
                    fila[i] = rs.getObject(i+1);
                }
                arrayListPedidos.add(fila[0]+","+fila[1]+","+fila[2]+","+fila[3]+","+fila[4]+","+fila[5]
                        +","+fila[6]+","+fila[7]+","+fila[8]);
            }
        }
        catch (Exception e) { }
        return arrayListPedidos;
    }

    public static String getIDpedido(Connection conexion){
        String  Id= null;
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement("Exec P_PedidoID_SELECT");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                if(fila[0]!= null)
                    Id = fila[0] + "";
            }
        }
        catch (Exception e) { }
        return Id;
    }

    public static void setDescuento(Connection conexion, Descuento descuento){
        try {
            conexion.prepareStatement("Exec P_Descuento_INSERT @porcentaje = "+
                    descuento.getPorcentaje()).executeQuery();
        }
        catch (Exception e) { }
    }
    public static void setPedido(Connection conexion, Pedido Pedido){
        try {
            conexion.prepareStatement("Exec P_Pedido_INSERT @cantidad = "+ Pedido.getCantidad() +", " +
                    "@subtotal = "+ Pedido.getSubTotal() +", @total = "+ Pedido.getTotal() +
                    ", @id_cliente = "+ Pedido.getCliente().getIdCliente() +", @id_vendedor = "+ Pedido.getVendedor().getIdVendedor() +
                    ", @id_producto = "+ Pedido.getProducto().getIdProducto() +", @id_descuento = "+ Pedido.getDescuento().getIdDescuento() +
                    ", @id_pago = "+ Pedido.getFormaPago().getIdPago()).executeQuery();
        }
        catch (Exception e) { }
    }
    public static void deletePedido(Connection conexion, int i){
        try {
            conexion.prepareStatement("Exec P_Pedidos_DELETE @Id = "+i).executeQuery();
        }
        catch (Exception e) { }
    }
    public static void updatePedido(Connection conexion, Pedido pedido){
        try {
            conexion.prepareStatement("Exec P_Pedido_UPDATE @Id = " + 1 +
                    ", @cantidad = " + pedido.getCantidad() +
                    ", @subtotal = " + pedido.getSubTotal() +
                    ", @total = " + pedido.getTotal() +
                    ", @id_cliente = " + pedido.getCliente().getIdCliente() +
                    ", @id_vendedor = " + pedido.getVendedor().getIdVendedor() +
                    ", @id_producto = " + pedido.getProducto().getIdProducto() +
                    ", @id_descuento = " + pedido.getDescuento().getIdDescuento() +
                    ", @id_pago = "+ pedido.getFormaPago().getIdPago()).executeQuery();
        }
        catch (Exception e) { }
    }
}
