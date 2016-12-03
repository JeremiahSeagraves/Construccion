/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administradores;

import Modelo.Datos.AccesoBDProveedores;
import Modelo.Proveedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
public class AdministradorProveedores implements Administrador{

   private final AccesoBDProveedores accesoBDProveedores;
    
    public AdministradorProveedores( ){
      accesoBDProveedores = new AccesoBDProveedores();
    }

    @Override
    public void agregar( Object registro ) {
        try {
            accesoBDProveedores.insertarProveedor(( Proveedor )registro );
        } 
        catch ( SQLException | ClassNotFoundException ex ) {
            Logger.getLogger( AdministradorInventario.class.getName( ) ).log(Level.SEVERE, null, ex );
        }
    }

    @Override
    public void eliminar( Object registro ) {
        try {
            accesoBDProveedores.eliminarProveedor(( String )registro );
        } 
        catch ( SQLException | ClassNotFoundException ex ) {
            Logger.getLogger( AdministradorInventario.class.getName( ) ).log( Level.SEVERE, null, ex );
        }
    }

    @Override
    public Proveedor buscar( Object registro ) {
        Proveedor proveedor = null;
        
        try {
            proveedor = accesoBDProveedores.buscarProveedor(( String )registro );
        } 
        catch ( SQLException | ClassNotFoundException ex ) {
            Logger.getLogger( AdministradorInventario.class.getName( ) ).log(Level.SEVERE, null, ex );
        }
        
        return proveedor;
    }

    @Override
    public void actualizar( Object registro ) {
        try {
            accesoBDProveedores.actualizarProveedor(( Proveedor )registro );
        } 
        catch ( SQLException | ClassNotFoundException ex ) {
            Logger.getLogger( AdministradorInventario.class.getName( ) ).log( Level.SEVERE, null, ex );
        }
    }

    @Override
    public ArrayList<Proveedor> obtenerDatos( ) {
        ArrayList<Proveedor> proveedores=null;
                
        try {
            proveedores = accesoBDProveedores.obtenerProveedores( );
        }
        catch ( ClassNotFoundException | SQLException ex ) {
            Logger.getLogger( AdministradorInventario.class.getName( ) ).log( Level.SEVERE, null, ex );
        }
        
        return proveedores;
    }

    
}
