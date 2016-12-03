/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author juan
 */
public class DetalleArticulo {
   
    private int cantidad;
    private Precio precioCompra;
    private Precio precioVenta;

    public DetalleArticulo(int cantidad, Precio precioCompra, Precio precioVenta) {
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Precio getPrecioCompra() {
        return precioCompra;
    }

    public Precio getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioCompra(Precio precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setPrecioVenta(Precio precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    
    
}
