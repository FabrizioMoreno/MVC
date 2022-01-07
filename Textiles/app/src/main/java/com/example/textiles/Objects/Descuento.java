package com.example.textiles.Objects;

public class Descuento {
    private int idDescuento;
    private float porcentaje;

    public Descuento(int idDescuento, float porcentaje) {
        this.idDescuento = idDescuento;
        this.porcentaje = porcentaje;
    }

    public int getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(int idDescuento) {
        this.idDescuento = idDescuento;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return  porcentaje + "%";
    }
}
