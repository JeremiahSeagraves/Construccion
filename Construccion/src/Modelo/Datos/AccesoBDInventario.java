 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

import Modelo.Articulo;
import Modelo.DetalleArticulo;
import Modelo.Precio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author juan
 */

public class AccesoBDInventario extends AccesoBD {
    
    private static final String CLAVE = "claveArticulo";
    private static final String CLAVE_PROVEEDOR = "claveProveedor";
    private static final String DESCRIPCION = "descripcion";
    private static final String CANTIDAD = "cantidad";
    private static final String PRECIO_COMPRA = "preciocompra";
    private static final String PRECIO_VENTA = "precioventa";
    private static final String TABLA_ARTICULOS = "articulo";
    private static final String TABLA_DETALLES_ARTICULOS = "detallearticulo";
    
    public ArrayList<Articulo> obtenerInventario( ) throws ClassNotFoundException, SQLException{
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
 
         consultaBD =  COMANDO_SELECT + COMANDO_ALL + COMANDO_FROM + TABLA_ARTICULOS;
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaArticulos = sentenciaConsulta.executeQuery( consultaBD );
         
         consultaBD =  COMANDO_SELECT + COMANDO_ALL + COMANDO_FROM + TABLA_DETALLES_ARTICULOS;
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaDetalleArticulos = sentenciaConsulta.executeQuery( consultaBD );
         
         ArrayList<Articulo> articulos= new ArrayList<>( );
         Articulo articulo;
        
         while ( resultadoConsultaArticulos.next() && resultadoConsultaDetalleArticulos.next()) {
            articulo = new Articulo( resultadoConsultaArticulos.getString(CLAVE ),
                                     resultadoConsultaArticulos.getString(CLAVE_PROVEEDOR ),
                                     resultadoConsultaArticulos.getString(DESCRIPCION ),
                                     new DetalleArticulo(resultadoConsultaDetalleArticulos.getInt(CANTIDAD),
                                     new Precio(resultadoConsultaDetalleArticulos.getDouble(PRECIO_COMPRA)),
                                     new Precio(resultadoConsultaDetalleArticulos.getDouble(PRECIO_VENTA))));
            
            articulos.add(articulo);
        }
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
        
         return articulos;
    }
   
   public void insertarArticulo( Articulo articulo ) throws SQLException, ClassNotFoundException {
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
        
         consultaBD = COMANDO_INSERT + COMANDO_INTO + TABLA_ARTICULOS + COMANDO_VALUES
                        +"(\"" + articulo.getClaveArticulo()+ "\", "
                        + "\"" + articulo.getClaveProveedor( ) + "\", "
                        + "\"" + articulo.getDescripcion( ) +"\")";
         
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
        
         insertarDetalleArticulo(articulo);
         
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
    }
   
   private void insertarDetalleArticulo (Articulo articulo ) throws SQLException{
        consultaBD = COMANDO_INSERT + COMANDO_INTO + TABLA_DETALLES_ARTICULOS + COMANDO_VALUES 
                        + "(\""+ articulo.getClaveArticulo() + "\","
                        + "\"" + articulo.getDetalleArticulo().getCantidad() + "\","
                        + "\"" + articulo.getDetalleArticulo().getPrecioCompra().getPrecio()+ "\","
                        + "\"" + articulo.getDetalleArticulo().getPrecioVenta().getPrecio() + "\")";
        
            sentenciaConsulta = conexionBD.createStatement( );
            sentenciaConsulta.executeUpdate( consultaBD );
   }
   
    public void eliminarArticulo( String claveArticulo ) throws SQLException, ClassNotFoundException {
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
        
         consultaBD = COMANDO_DELETE + COMANDO_FROM + TABLA_ARTICULOS + COMANDO_WHERE + CLAVE + " = \"" + claveArticulo + "\"";
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
    }
   
    public Articulo buscarArticulo( String claveArticulo ) throws SQLException, ClassNotFoundException {
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
        
         consultaBD = COMANDO_SELECT + COMANDO_ALL + COMANDO_FROM + TABLA_ARTICULOS + COMANDO_WHERE + CLAVE + "= \"" + claveArticulo + "\"";
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaArticulos = sentenciaConsulta.executeQuery( consultaBD );
         
         //Omite el primero elemento del ResultSet el cual es una dirección de memoria
         resultadoConsultaArticulos.next( );
         
         consultaBD =  COMANDO_SELECT + COMANDO_ALL + COMANDO_FROM + TABLA_DETALLES_ARTICULOS + COMANDO_WHERE + CLAVE + "= \"" +
                 claveArticulo + "\"";
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaDetalleArticulos = sentenciaConsulta.executeQuery( consultaBD );
        
         //Omite el primero elemento del ResultSet el cual es una dirección de memoria
         resultadoConsultaDetalleArticulos.next();
         
         Articulo articulo = new Articulo( resultadoConsultaArticulos.getString(CLAVE ),
                                     resultadoConsultaArticulos.getString(CLAVE_PROVEEDOR ),
                                     resultadoConsultaArticulos.getString(DESCRIPCION ),
                                     new DetalleArticulo(resultadoConsultaDetalleArticulos.getInt(CANTIDAD),
                                     new Precio(resultadoConsultaDetalleArticulos.getDouble(PRECIO_COMPRA)),
                                     new Precio(resultadoConsultaDetalleArticulos.getDouble(PRECIO_VENTA))));
        
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
        
         return articulo;
    }
    
    public void actualizarArticulo( Articulo articuloModificado ) throws SQLException, ClassNotFoundException{
         ManejadorConexionBD.obtenerInstancia( ).conectarConBD( );
         conexionBD = ManejadorConexionBD.obtenerConexion( );
        
         consultaBD = COMANDO_UPDATE + TABLA_ARTICULOS + COMANDO_SET + " " + CLAVE_PROVEEDOR + " = \""
                 + articuloModificado.getClaveProveedor( ) + "\", "
                 + DESCRIPCION + " = \"" + articuloModificado.getDescripcion( ) + "\" "
                 + COMANDO_WHERE + " " + CLAVE + " = \"" + articuloModificado.getClaveArticulo( ) + "\"";
         
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
         
         consultaBD = COMANDO_UPDATE + TABLA_DETALLES_ARTICULOS + COMANDO_SET + " "
                 + CANTIDAD + " = " + articuloModificado.getDetalleArticulo().getCantidad( )+ ", "
                 + PRECIO_COMPRA + " = " + articuloModificado.getDetalleArticulo().getPrecioCompra().getPrecio() + ", "
                 + PRECIO_VENTA + " = " + articuloModificado.getDetalleArticulo().getPrecioVenta().getPrecio() + " "
                 + COMANDO_WHERE + " " + CLAVE + " = \"" + articuloModificado.getClaveArticulo( ) + "\"";
        
        sentenciaConsulta = conexionBD.createStatement( );
        sentenciaConsulta.executeUpdate( consultaBD );
         
         ManejadorConexionBD.obtenerInstancia( ).desconectarConBD( );
       
    }

}
