package com.example.textiles.Objects;

import com.example.textiles.Objects.Persona;

public class Vendedor extends Persona {
    private int idVendedor;
    private int ventasTotales;
    private Persona persona;

    public Vendedor(Persona persona, int idVendedor, int ventasTotales) {
        this.persona = persona;
        this.idVendedor = idVendedor;
        this.ventasTotales = ventasTotales;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getVentasTotales() { return ventasTotales;}

    public void setVentasTotales(int ventasTotales) {
        this.ventasTotales = ventasTotales;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return  getPersona().getNombre() +
                " con " + ventasTotales + " ventas totales";
    }
}
