
 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;


import Administradores.AdministradorEmpleados;
import Administradores.AdministradorInventario;
import Modelo.Articulo;
import Modelo.Empleado;
import java.sql.ResultSet;
import Modelo.Venta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author rodrigopeniche
 */
public class AccesoBDVentas extends AccesoBD {
    
    private static final String CLAVE_VENTA = "claveVenta";
    private static final String CLAVE_ARTICULO = "claveArticulo";
    private static final String MONTO = "monto";
    private static final String GANANCIA = "ganancia";
    private static final String FECHA = "fecha";
    private static final String CLAVE_EMPLEADO = "claveEmpleado";
    private static final String TABLA_VENTAS = "ventas";
    private static final String TABLA_DETALLES_VENTAS ="detalleventa";
    private static final String CANTIDAD_ARTICULO_VENDIDO = "Cantidad";
    
    public ArrayList<Venta> obtenerVentas() throws ClassNotFoundException, SQLException{
        ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
 
         consultaBD =  COMANDO_SELECT + COMANDO_ALL + COMANDO_FROM + TABLA_VENTAS;
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaVentas = sentenciaConsulta.executeQuery( consultaBD );
         
//         resultadoConsultaVentas.next();
         //omite el primer resultado de la consulta de Ventas
         
         ArrayList<Venta> ventas= new ArrayList<>( );
         Venta venta;

         AdministradorEmpleados adminEmpleado = new AdministradorEmpleados();

         String claveVenta;
         double monto;
         double ganancia;
         String fecha;
         String claveEmpleado;
         Empleado empleado;
         
         while ( resultadoConsultaVentas.next()) {
            claveVenta = resultadoConsultaVentas.getString(CLAVE_VENTA);
            monto  = resultadoConsultaVentas.getDouble(MONTO);
            ganancia = resultadoConsultaVentas.getDouble(GANANCIA);
            fecha = resultadoConsultaVentas.getDate(FECHA).toString();
            claveEmpleado = resultadoConsultaVentas.getString(CLAVE_EMPLEADO);
            empleado = (Empleado) adminEmpleado.buscar(claveEmpleado);
            
            venta = new Venta(obtenerDetallesVentas(claveVenta));
            venta.setMonto(monto);
            venta.setGanancia(ganancia);
            venta.setFecha(fecha);
            venta.setEmpleado(empleado);
            
            ventas.add(venta);
        }
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
        
         return ventas;
    }
    
    public ArrayList<Articulo> obtenerDetallesVentas(String claveVenta) throws ClassNotFoundException, SQLException{
        ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
        conexionBD = ManejadorConexionBD.obtenerConexion( );
        ArrayList<Articulo> articulosEnVenta = new ArrayList<>();
        Articulo articulo;
        AdministradorInventario adminInventario = new AdministradorInventario();
        String claveArticulo;
        int cantidadArticulo;
        
        consultaBD =  COMANDO_SELECT + COMANDO_ALL + COMANDO_FROM + TABLA_DETALLES_VENTAS + " where claveventa = '"+claveVenta+"'";
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaDetalleVentas = sentenciaConsulta.executeQuery( consultaBD );
         
//         resultadoConsultaDetalleVentas.next();
//         //omite el primer resultado que es una direccion de memoria.
         
         while(resultadoConsultaDetalleVentas.next()){
             claveArticulo = resultadoConsultaDetalleVentas.getString(CLAVE_ARTICULO);
             cantidadArticulo =resultadoConsultaDetalleVentas.getInt(CANTIDAD_ARTICULO_VENDIDO);
              articulo = adminInventario.buscar(claveArticulo);
              
              articulosEnVenta.add(articulo);
         }
        
        
        ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
        
        return articulosEnVenta;
    }
    public void insertarVenta(Venta venta) throws ClassNotFoundException, SQLException{
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
        
         consultaBD = COMANDO_INSERT + COMANDO_INTO + TABLA_VENTAS + COMANDO_VALUES+ "(\""+ venta.getClave()+ "\","
                                                 + "\"" + venta.getEmpleado().getClave() + "\", "
                                                 + "\"" + venta.getMontoVenta()+ "\", "
                                                 + "\"" + venta.getGanancia() + "\", "
                                                 + "\"" + venta.getFecha() + "\")";
         System.out.println(consultaBD);
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
         
         insertarDetallesVentas(venta);
    }
    
    private void insertarDetallesVentas(Venta venta) throws ClassNotFoundException, SQLException{
        ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
        conexionBD = ManejadorConexionBD.obtenerConexion( );
        
        for(int i = 0; i<venta.getArticulosVendidos().size();i++){
            consultaBD = COMANDO_INSERT + COMANDO_INTO + TABLA_DETALLES_VENTAS + COMANDO_VALUES+ "(\""+ venta.getClave()+ "\","
                                                 + "\"" + venta.getArticulosVendidos().get(i).getClaveArticulo() + "\", "
                                                 + "\"" + venta.getArticulosVendidos().get(i).getDetalleArticulo().getCantidad() + "\")";
            System.out.println(consultaBD);
            sentenciaConsulta = conexionBD.createStatement( );
            sentenciaConsulta.executeUpdate( consultaBD );
        }
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
    }
    
    public int obtenerClaveUlimaVenta() throws ClassNotFoundException, SQLException{
        ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
        conexionBD = ManejadorConexionBD.obtenerConexion( );
        consultaBD = COMANDO_SELECT + "max("+ CLAVE_VENTA + ")" + COMANDO_FROM + TABLA_VENTAS;
        sentenciaConsulta = conexionBD.createStatement();
        ResultSet resultadoConsulta = sentenciaConsulta.executeQuery(consultaBD);
        resultadoConsulta.next();
        
        
        int claveUltimVenta = Integer.parseInt(resultadoConsulta.getString("max(ClaveVenta)"));
        
        return claveUltimVenta;
    }
    
    
//     public Venta buscarVenta( String claveVenta ) throws SQLException, ClassNotFoundException {
//         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
//         conexionBD = ManejadorConexionBD.obtenerConexion();
//        
//         consultaBD = SELECT_STRING + "*" + FROM_STRING + "ventas" + WHERE_STRING + clave + " = \"" + claveVenta + "\"";
//         sentenciaConsulta = conexionBD.createStatement( );
//         ResultSet resultadoConsultaBD = sentenciaConsulta.executeQuery(consultaBD);
//        
//         //Omite el primer elemento del ResultSet el cual es una direccion de memoria
//         resultadoConsultaBD.next( );
//        
//         Venta venta = new Venta( resultadoConsultaBD.getString( clave ),
//                                              resultadoConsultaBD.getString( monto ),
//                                              resultadoConsultaBD.getString( ganancia ),
//                                              resultadoConsultaBD.getString( fecha ) );
//        
//         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
//        
//         return venta;
//    }
//    
}
