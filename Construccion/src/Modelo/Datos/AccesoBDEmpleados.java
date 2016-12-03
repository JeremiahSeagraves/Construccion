/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

import static Modelo.Datos.AccesoBD.conexionBD;
import Modelo.Empleado;
import Modelo.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rodrigopeniche
 */
public class AccesoBDEmpleados extends AccesoBD {
    
   private static final String CLAVE = "clave";
   private static final String NOMBRE = "nombre";
   private static final String TELEFONO = "telefono";
   private static final String DIRECCION = "direccion";
   private static final String TABLA_EMPLEADOS = "empleados";
   
   public ArrayList<Empleado> obtenerEmpleados( ) throws ClassNotFoundException, SQLException{
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );

         consultaBD = COMANDO_SELECT + COMANDO_ALL + COMANDO_FROM + TABLA_EMPLEADOS;
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaBD = sentenciaConsulta.executeQuery( consultaBD );
        
         ArrayList<Empleado> empleados= new ArrayList<>( );
         Empleado empleado;
        
         while ( resultadoConsultaBD.next( ) ) {
            empleado = new Empleado( resultadoConsultaBD.getString(CLAVE ),
                                       resultadoConsultaBD.getString(NOMBRE ),
                                       resultadoConsultaBD.getString(TELEFONO ),
                                       resultadoConsultaBD.getString(DIRECCION ) );

            empleados.add( empleado );
         }
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
        
         return empleados;
    }
   
   public void insertarEmpleado( Empleado empleado ) throws SQLException, ClassNotFoundException {
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
        
         consultaBD = COMANDO_INSERT + COMANDO_INTO + TABLA_EMPLEADOS + COMANDO_VALUES + "(\"" + empleado.getClave() + "\", "
                                                          + "\"" + empleado.getNombre( ) + "\", "
                                                          + "\"" + empleado.getTelefono( ) + "\", "
                                                          + "\"" + empleado.getDireccion( ) + "\")";
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
    }
   
   public void eliminarEmpleado( String claveEmpleado ) throws SQLException, ClassNotFoundException {
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
        
         consultaBD = COMANDO_DELETE + COMANDO_FROM +  TABLA_EMPLEADOS + COMANDO_WHERE  + CLAVE +" = \"" + claveEmpleado+ "\"";
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
    }
   
   public Empleado buscarEmpleado( String claveProveedor ) throws SQLException, ClassNotFoundException {
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion();
        
         consultaBD = COMANDO_SELECT + COMANDO_ALL + COMANDO_FROM + TABLA_EMPLEADOS + COMANDO_WHERE + CLAVE + " = \"" + claveProveedor + "\"";
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaBD = sentenciaConsulta.executeQuery(consultaBD);
        
         //Omite el primer elemento del ResultSet el cual es una direccion de memoria
         resultadoConsultaBD.next( );
        
         Empleado empleado = new Empleado( resultadoConsultaBD.getString(CLAVE ),
                                              resultadoConsultaBD.getString(NOMBRE ),
                                              resultadoConsultaBD.getString(TELEFONO ),
                                              resultadoConsultaBD.getString(DIRECCION ) );
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
        
         return empleado;
    }
   
   public void actualizarProveedor( Empleado empleado ) throws SQLException, ClassNotFoundException{
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
        
         consultaBD = COMANDO_UPDATE + TABLA_EMPLEADOS + COMANDO_SET + NOMBRE + " = \"" + empleado.getNombre( ) + "\","
                                           + TELEFONO + "=\"" + empleado.getTelefono( )+ "\","
                                           + DIRECCION + "=\"" + empleado.getDireccion( ) + "\""
                                           + COMANDO_WHERE + CLAVE  +" = \"" + empleado.getClave( ) + "\"";
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
    }
    
}
