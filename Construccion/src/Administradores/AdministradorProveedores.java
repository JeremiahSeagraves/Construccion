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
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, "Error al agregar el proveedor");
        }
    }

    @Override
    public void eliminar( Object registro ) {
        try {
            accesoBDProveedores.eliminarProveedor(( String )registro );
        } 
        catch ( SQLException | ClassNotFoundException ex ) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor");
        }
    }

    @Override
    public Proveedor buscar( Object registro ) {
        Proveedor proveedor = null;
        
        try {
            proveedor = accesoBDProveedores.buscarProveedor(( String )registro );
        } 
        catch ( SQLException | ClassNotFoundException ex ) {
            JOptionPane.showMessageDialog(null, "Error al buscar el proveedor");
        }
        
        return proveedor;
    }

    @Override
    public void actualizar( Object registro ) {
        try {
            accesoBDProveedores.actualizarProveedor(( Proveedor )registro );
        } 
        catch ( SQLException | ClassNotFoundException ex ) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el proveedor");
        }
    }

    @Override
    public ArrayList<Proveedor> obtenerDatos( ) {
        ArrayList<Proveedor> proveedores=null;
                
        try {
            proveedores = accesoBDProveedores.obtenerProveedores( );
        }
        catch ( ClassNotFoundException | SQLException ex ) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos de los proveedores.");
        }
        
        return proveedores;
    }

    
}
