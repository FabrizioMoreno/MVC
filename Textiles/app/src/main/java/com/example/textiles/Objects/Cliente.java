package com.example.textiles.Objects;

public class Cliente extends Persona {
    private int idCliente;
    private String nombreEmpresa;
    private Persona persona;

    public Cliente(Persona persona,int idCliente, String nombreEmpresa) {
        this.persona = persona;
        this.idCliente = idCliente;
        this.nombreEmpresa = nombreEmpresa;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @Override
    public String toString() {
        return getPersona().getNombre();
    }
}
