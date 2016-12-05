/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administradores;

import Modelo.Datos.AccesoBDInventario;
import Modelo.Articulo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author rodrigopeniche
 */
public class AdministradorInventario implements Administrador{
    
    private final AccesoBDInventario accesoBDInventario;
    
    
    public AdministradorInventario( ){
      accesoBDInventario = new AccesoBDInventario();
    }

    @Override
    public void agregar( Object registro ) {
        try {
            accesoBDInventario.insertarArticulo(( Articulo )registro );
        } 
        catch ( SQLException | ClassNotFoundException ex ) {
            JOptionPane.showMessageDialog(null, "Error al agregar el artículo");
        }
    }

    @Override
    public void eliminar( Object registro ) {
        try {
            accesoBDInventario.eliminarArticulo(( String )registro );
        } 
        catch ( SQLException | ClassNotFoundException ex ) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el artículo");
        }
    }

    @Override
    public Articulo buscar( Object registro ) {
        Articulo articulo = null;
        
        try {
            articulo = accesoBDInventario.buscarArticulo(( String )registro );
        } 
        catch ( SQLException | ClassNotFoundException ex ) {
            JOptionPane.showMessageDialog(null, "Error al buscar el artículo");
        }
        
        return articulo; 
    }

    @Override
    public void actualizar( Object registro ) {
        try {
            accesoBDInventario.actualizarArticulo((Articulo)registro );
        } 
        catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el empleado");
        }
    }

    @Override
    public ArrayList<Articulo> obtenerDatos( ) {
        ArrayList<Articulo> inventario=null;
        
        try {
            inventario = accesoBDInventario.obtenerInventario();
        } 
        catch ( ClassNotFoundException | SQLException ex ) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos de los artículos");
        }
        
        return inventario;
    }
    
    public void actualizarCantidadArticulos(ArrayList<Articulo> articulosVendidos) throws SQLException, ClassNotFoundException{
        Articulo articuloVendido;
        Articulo articuloEnInventario;

        for(int i = 0; i<articulosVendidos.size(); i++){
            articuloVendido = articulosVendidos.get(i);
            articuloEnInventario = accesoBDInventario.buscarArticulo(articulosVendidos.get(i).getClaveArticulo());
            accesoBDInventario.decrementarCantidadArticulos(articuloVendido, articuloEnInventario);
        }
    }
    
     public boolean validarExistenciaEnInventario(ArrayList<Articulo> articulosVendidos) throws SQLException, ClassNotFoundException {
        boolean existenciaTodosLosArticulos = true;
        Articulo articulo;
        int cantidadActualArticulo;
        
        for(int i = 0; i< articulosVendidos.size(); i++){
            articulo = accesoBDInventario.buscarArticulo(articulosVendidos.get(i).getClaveArticulo());
            cantidadActualArticulo = articulo.getDetalleArticulo().getCantidad();
            
            if(cantidadActualArticulo == 0){
                existenciaTodosLosArticulos = false;
            }
        }
        
        return existenciaTodosLosArticulos;
    }

    
}
