/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

import Modelo.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class AccesoBDProveedores extends AccesoBD {
    
   private static final String CLAVE = "clave"; 
   private static final String NOMBRE = "nombre";
   private static final String DIRECCION = "direccion";
   private static final String TELEFONO = "telefono";
   private static final String TABLA_PROVEEDORES = "proveedores";
    
   public ArrayList<Proveedor> obtenerProveedores( ) throws ClassNotFoundException, SQLException{
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );

         consultaBD = COMANDO_SELECT + COMANDO_ALL + COMANDO_FROM + TABLA_PROVEEDORES;
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaBD = sentenciaConsulta.executeQuery( consultaBD );
        
         ArrayList<Proveedor> proveedores= new ArrayList<>( );
         Proveedor proveedor;
        
         while ( resultadoConsultaBD.next( ) ) {
            proveedor = new Proveedor( resultadoConsultaBD.getString(CLAVE ),
                                       resultadoConsultaBD.getString(NOMBRE ),
                                       resultadoConsultaBD.getString(TELEFONO ),
                                       resultadoConsultaBD.getString(DIRECCION ) );

            proveedores.add( proveedor );
         }
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
        
         return proveedores;
    }
   
   public void insertarProveedor( Proveedor proveedor ) throws SQLException, ClassNotFoundException {
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
        
         consultaBD = COMANDO_INSERT + COMANDO_INTO + TABLA_PROVEEDORES + COMANDO_VALUES + "(\"" + proveedor.getClave() + "\", "
                                                          + "\"" + proveedor.getNombre( ) + "\", "
                                                          + "\"" + proveedor.getTelefono( ) + "\", "
                                                          + "\"" + proveedor.getDireccion( ) + "\")";
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
    }
   
   public void eliminarProveedor( String claveProveedor ) throws SQLException, ClassNotFoundException {
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
        
         consultaBD = COMANDO_DELETE + COMANDO_FROM +  TABLA_PROVEEDORES + COMANDO_WHERE  + CLAVE +" = \"" + claveProveedor+ "\"";
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
    }
   
   public Proveedor buscarProveedor( String claveProveedor ) throws SQLException, ClassNotFoundException {
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion();
        
         consultaBD = COMANDO_SELECT + COMANDO_ALL + COMANDO_FROM + TABLA_PROVEEDORES + COMANDO_WHERE + CLAVE + " = \"" + claveProveedor + "\"";
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaBD = sentenciaConsulta.executeQuery(consultaBD);
        
         //Omite el primer elemento del ResultSet el cual es una direccion de memoria
         resultadoConsultaBD.next( );
        
         Proveedor proveedor = new Proveedor( resultadoConsultaBD.getString(CLAVE ),
                                              resultadoConsultaBD.getString(NOMBRE ),
                                              resultadoConsultaBD.getString(TELEFONO ),
                                              resultadoConsultaBD.getString(DIRECCION ) );
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
        
         return proveedor;
    }
    
   public void actualizarProveedor( Proveedor proveedorModificado ) throws SQLException, ClassNotFoundException{
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
        
         consultaBD = COMANDO_UPDATE + TABLA_PROVEEDORES + COMANDO_SET + NOMBRE + " = \"" + proveedorModificado.getNombre( ) + "\","
                                           + TELEFONO + "=\"" + proveedorModificado.getTelefono( )+ "\","
                                           + DIRECCION + "=\"" + proveedorModificado.getDireccion( ) + "\""
                                           + COMANDO_WHERE + CLAVE  +" = \"" + proveedorModificado.getClave( ) + "\"";
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
    }
    
}
