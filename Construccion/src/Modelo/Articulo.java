/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author rodrigopeniche
 */
public class Articulo {
    
     private final String claveArticulo;
     private final String claveProveedor;
     private String descripcion;
     private final DetalleArticulo detalleArticulo;
    
    public Articulo ( String claveArticulo, String claveProveedor, String descripcion, DetalleArticulo detalleArticulo ) {
        this.claveArticulo = claveArticulo;
        this.claveProveedor = claveProveedor;
        this.descripcion = descripcion;
        this.detalleArticulo = detalleArticulo;
    }

    public String getClaveArticulo() {
        return claveArticulo;
    }
    
    public String getClaveProveedor() {
       return claveProveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public DetalleArticulo getDetalleArticulo() {
        return detalleArticulo;
    }

    public void setDescripcion( String descripcion ) {
        this.descripcion = descripcion;
    }
    
}
