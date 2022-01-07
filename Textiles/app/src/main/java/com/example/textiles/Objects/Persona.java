package com.example.textiles.Objects;

public class Persona {
    private int idPersona;
    private String nombre;
    private String Direccion;

    public Persona(int idPersona, String nombre, String direccion) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        Direccion = direccion;
    }

    public Persona() {
    }

    public int getID() {return idPersona;}

    public void setID(int idPersona) {this.idPersona = idPersona;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDireccion() {return Direccion;}

    public void setDireccion(String direccion) {Direccion = direccion;}

    @Override
    public String toString() {
        return "idPersona=" + idPersona +
                ", nombre='" + nombre +
                ", Direccion='" + Direccion;
    }
}
