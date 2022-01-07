package com.example.textiles.Objects;

public class Pedido {
    private int idPedido;
    private float cantidad, subTotal, total;
    private Cliente cliente;
    private Vendedor vendedor;
    private Producto producto;
    private Descuento descuento;
    private FormaPago formaPago;

    public Pedido(int idPedido, float cantidad, float subTotal, float total, Cliente cliente,
                  Vendedor vendedor, Producto producto, Descuento descuento, FormaPago formaPago) {
        this.idPedido = idPedido;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.total = total;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.producto = producto;
        this.descuento = descuento;
        this.formaPago = formaPago;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
}
