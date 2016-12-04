/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juan
 */
public class ManejadorConexionBD {
    
    private static final String DB_HOST_URL = "jdbc:mysql://localhost:3306/";
    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "";
    private static ManejadorConexionBD instanciaManejadorConexion = null;
    private static Connection conexion;
    
    private ManejadorConexionBD(){
        
    }
    
    private static void generarInstancia( ){
        instanciaManejadorConexion = new ManejadorConexionBD( );
    }
    
    public static ManejadorConexionBD obtenerInstancia( ){
        if( instanciaManejadorConexion == null ){
             generarInstancia( );
        }
        
        return instanciaManejadorConexion;
    }

    public void conectarConBD ( ) throws ClassNotFoundException, SQLException {
        Class.forName(CONTROLADOR );
        conexion=DriverManager.getConnection(DB_HOST_URL + "elcaballodehierro", USUARIO, CONTRASENIA );
    }

    public void desconectarConBD( ) throws SQLException {
        conexion.close( );
    }

    public static Connection obtenerConexion( ) {
        return conexion;
    }
    
    
    
}
