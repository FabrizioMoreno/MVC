package com.example.pizarron;

public class Pizarron {
    private int ID;
    private String tipo;
    private float ancho, largo;
    private int color;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getLargo() {
        return largo;
    }

    public void setLargo(float largo) {
        this.largo = largo;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Pizarron(int ID, String tipo, float ancho, float largo, int color) {
        this.ID     = ID;
        this.tipo   = tipo;
        this.ancho  = ancho;
        this.largo  = largo;
        this.color  = color;
    }

    public String toStringColor(){
        switch(color){
            case 0:
                return "Blanco";
            case 1:
                return "Verde";
            case 2:
                 return "Negro";
            case 3:
                return "Gris";
        }
        return null;
    }

    public int toIntTipo(){
        switch(tipo){
            case "Digital":
                return 0;
            case "Para gis":
                return 1;
            case "Para plumon":
                return 2;
        }
        return 0;
    }
}
