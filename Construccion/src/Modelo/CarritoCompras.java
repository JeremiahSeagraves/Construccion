/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author rodrigopeniche
 */
public class CarritoCompras {
    
    private final ArrayList<Articulo> articulosEnCarrito;

    public CarritoCompras() {
        this.articulosEnCarrito = new ArrayList<>();
    }
     
    public ArrayList<Articulo> getArticulosEnCarrito() {
        return articulosEnCarrito;
    }
    
}
