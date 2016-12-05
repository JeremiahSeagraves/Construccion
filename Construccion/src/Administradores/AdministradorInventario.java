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
import java.util.logging.Level;
import java.util.logging.Logger;


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
            Logger.getLogger( AdministradorInventario.class.getName( ) ).log( Level.SEVERE, null, ex );
        }
    }

    @Override
    public void eliminar( Object registro ) {
        try {
            accesoBDInventario.eliminarArticulo(( String )registro );
        } 
        catch ( SQLException | ClassNotFoundException ex ) {
            Logger.getLogger( AdministradorInventario.class.getName( ) ).log( Level.SEVERE, null, ex );
        }
    }

    @Override
    public Articulo buscar( Object registro ) {
        Articulo articulo = null;
        
        try {
            articulo = accesoBDInventario.buscarArticulo(( String )registro );
        } 
        catch ( SQLException | ClassNotFoundException ex ) {
            Logger.getLogger( AdministradorInventario.class.getName( ) ).log(Level.SEVERE, null, ex );
        }
        
        return articulo; 
    }

    @Override
    public void actualizar( Object registro ) {
        try {
            accesoBDInventario.actualizarArticulo((Articulo)registro );
        } 
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger( AdministradorInventario.class.getName( ) ).log(Level.SEVERE, null, ex );
        }
    }

    @Override
    public ArrayList<Articulo> obtenerDatos( ) {
        ArrayList<Articulo> inventario=null;
        
        try {
            inventario = accesoBDInventario.obtenerInventario();
        } 
        catch ( ClassNotFoundException | SQLException ex ) {
            Logger.getLogger( AdministradorInventario.class.getName( ) ).log( Level.SEVERE, null, ex );
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

    
}
