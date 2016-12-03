/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administradores;

import Modelo.Datos.AccesoBDVentas;
import Modelo.Articulo;
import Modelo.CarritoCompras;
import Modelo.Empleado;
import Modelo.Venta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author rodrigopeniche
 */
public class AdministradorVentas implements Administrador {
    
    private final AccesoBDVentas accesoBDVentas;
    private final CarritoCompras carritoCompras;
    private final ArrayList<Articulo> articulosEnCarrito;
 
    
    public AdministradorVentas( ){
        accesoBDVentas = new AccesoBDVentas( );
        carritoCompras = new CarritoCompras();
        articulosEnCarrito = carritoCompras.getArticulosEnCarrito();
    }
    
    public void agregarArticuloACarrito(Articulo articulo){
        boolean articuloEncontrado = false;  
       
        for(int i=0; i< articulosEnCarrito.size(); i++){
            if(articulosEnCarrito.get(i).getClaveArticulo().equals(articulo.getClaveArticulo())){
                articulosEnCarrito.get(i).getDetalleArticulo().setCantidad
                (articulosEnCarrito.get(i).getDetalleArticulo().getCantidad()+1);
                articuloEncontrado = true;
            }
        }
        if(!articuloEncontrado){
            articulo.getDetalleArticulo().setCantidad(1);
            articulosEnCarrito.add(articulo);
        }
    }
    
    public void eliminarArticuloDeCarrito(String claveArticulo){
        for(int i=0; i<articulosEnCarrito.size(); i++){
            if(articulosEnCarrito.get(i).getClaveArticulo().equals(claveArticulo)){
                articulosEnCarrito.remove(i);
            }
        }
    }
    
    public void realizarVenta( String claveCliente ){
        Venta venta = new Venta(articulosEnCarrito);
        
        double monto;
        double ganancia;
        monto = calcularMontoVenta();
        ganancia = obtenerGanancia();
        AdministradorEmpleados administradorEmpleados = new AdministradorEmpleados();
        
        Empleado empleado = (Empleado) administradorEmpleados.buscar(claveCliente);
        
        venta.setMonto(monto);
        venta.setGanancia(ganancia);
        venta.setEmpleado(empleado);
              
        agregar(venta);
        
    }
    
    private double calcularMontoVenta(){
        double monto = 0;
        double precioVentaArticulo;
        int cantidadArticulo;
        
        for(int i = 0 ; i<articulosEnCarrito.size(); i++){
           precioVentaArticulo = articulosEnCarrito.get(i).getDetalleArticulo().getPrecioVenta().getPrecio();
           cantidadArticulo = articulosEnCarrito.get(i).getDetalleArticulo().getCantidad();
           monto += precioVentaArticulo * cantidadArticulo;
        }
        
        return monto;
    }
    
    public double obtenerGanancia(){
        double gananciaTotal = 0;
        double gananciaPorArticulo;
        int cantidadArticulo;
        
        for(int i = 0 ; i<articulosEnCarrito.size(); i++){
           gananciaPorArticulo = articulosEnCarrito.get(i).getDetalleArticulo().getPrecioVenta().getPrecio() 
            - articulosEnCarrito.get(i).getDetalleArticulo().getPrecioCompra().getPrecio();
           
           cantidadArticulo = articulosEnCarrito.get(i).getDetalleArticulo().getCantidad();
           gananciaTotal += gananciaPorArticulo * cantidadArticulo;
        }
        
        return gananciaTotal;
    }
    
    @Override
    public void agregar( Object registro ) {
        try{
            accesoBDVentas.insertarVenta((Venta) registro);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdministradorVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    

    @Override
    public void eliminar( Object registro ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscar( Object registro ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar( Object registro ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object obtenerDatos() {
        ArrayList<Venta> ventas = null;
        try {   
            ventas = accesoBDVentas.obtenerVentas();
            return ventas;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdministradorVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ventas;
    }

    public CarritoCompras getCarritoCompras() {
        return carritoCompras;
    }

    
}
