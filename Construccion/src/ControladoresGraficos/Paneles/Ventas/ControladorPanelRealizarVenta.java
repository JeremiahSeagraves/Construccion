/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Ventas;

import Administradores.AdministradorInventario;
import Administradores.AdministradorVentas;
import ControladoresGraficos.Ventanas.ControladorVentanaVentas;
import Modelo.Articulo;
import Modelo.CarritoCompras;
import Ventanas.Ventas.PanelRealizarVenta;
import Ventanas.Ventas.VentanaVentas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class ControladorPanelRealizarVenta {
    private static ControladorPanelRealizarVenta controladorPanelRelizarVenta = null;
    private static PanelRealizarVenta panelRealizarVenta = null;
        private final CarritoCompras carritoCompras;
        private final AdministradorVentas adminVentas;
        private final AdministradorInventario adminInventario;
    
    private ControladorPanelRealizarVenta(){
        adminVentas = new AdministradorVentas();
        carritoCompras = adminVentas.getCarritoCompras();
        adminInventario = new AdministradorInventario();
        
    }
    
    public static ControladorPanelRealizarVenta obtenerControladorPanelRealizarVenta(){
        if(controladorPanelRelizarVenta == null){
            controladorPanelRelizarVenta = new ControladorPanelRealizarVenta();
            panelRealizarVenta = new PanelRealizarVenta();
        }
        return controladorPanelRelizarVenta;
    }
    
     private void mostrarPanelRealizarVenta(){
         ocultarOtrosPaneles();
         configurarPanelRealizarVenta();
         panelRealizarVenta.setVisible(true);
    }
     
     private void ocultarOtrosPaneles(){
         ControladorPanelVerVentas.obtenerControladorPanerVerVentas().ocultarPanelVerVentas();
     }
     
     public void agregarEventoBotonAgregarAlCarrito() {
        JButton botonAgregar = panelRealizarVenta.getBotonAgregarCarrito();

        botonAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    accionarEventoBotonAgregarAlCarrito();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorVentanaVentas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorVentanaVentas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        panelRealizarVenta.setBotonAgregarCarrito(botonAgregar);
    }
     
         private void accionarEventoBotonAgregarAlCarrito() throws SQLException, ClassNotFoundException{
        String claveArticulo;
        Articulo articulo;
        
        AdministradorInventario adminInventario = new AdministradorInventario();
               
        claveArticulo = JOptionPane.showInputDialog("Ingrese la clave del articulo");
        articulo = adminInventario.buscar(claveArticulo);
        adminVentas.agregarArticuloACarrito(articulo);
        actualizarTablaCarrito();
        
    }
         
          private void actualizarTablaCarrito() throws SQLException, ClassNotFoundException{
        borrarContenidoTablaCarrito();
        llenarTablaCarrito(carritoCompras);
    }
          
          
    private void borrarContenidoTablaCarrito(){
        panelRealizarVenta.getContenidoTablaCarrito().setRowCount(0);
    }
    
    
    private void llenarTablaCarrito(CarritoCompras carritoCompras) throws SQLException, ClassNotFoundException {
        ArrayList<Articulo> articulos = carritoCompras.getArticulosEnCarrito();
        
        for (int numArticulo = 0; numArticulo < articulos.size(); numArticulo++) {
            panelRealizarVenta.getContenidoTablaCarrito().addRow(new Object[]{articulos.get(numArticulo).getClaveArticulo(),
                articulos.get(numArticulo).getClaveProveedor(),
                articulos.get(numArticulo).getDescripcion(),
                articulos.get(numArticulo).getDetalleArticulo().getCantidad(),
                articulos.get(numArticulo).getDetalleArticulo().getPrecioCompra().getPrecio(),
                articulos.get(numArticulo).getDetalleArticulo().getPrecioVenta().getPrecio()
            });
        }
    }
    
    
    public void agregarEventoBotonEliminarDelCarrito(){
        JButton botonEliminar = panelRealizarVenta.getBotonEliminarDelCarrito();
        
        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {    
                    accionarEventoBotonEliminarDelCarrito();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorVentanaVentas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorVentanaVentas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        panelRealizarVenta.setBotonEliminarCarrito(botonEliminar);
    }
    
    
    private void accionarEventoBotonEliminarDelCarrito() throws SQLException, ClassNotFoundException{
        String claveArticulo;

        claveArticulo = JOptionPane.showInputDialog("Ingrese la clave del articulo");
        adminVentas.eliminarArticuloDeCarrito(claveArticulo);
        actualizarTablaCarrito();
    }
    
    public void agregarEventoBotonRealizarVenta(){
        JButton botonRealizarVenta = panelRealizarVenta.getBotonRealizarVenta();
        
        botonRealizarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    accionarBotonEventoRealizarVenta();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorPanelRealizarVenta.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorPanelRealizarVenta.class.getName()).log(Level.SEVERE, null, ex);
                }
 
            }
        });
        panelRealizarVenta.setBotonRealizarVenta(botonRealizarVenta);
    }
    
    
    private void accionarBotonEventoRealizarVenta() throws ClassNotFoundException, SQLException{
        String claveEmpleado;
        String montoVenta = String.valueOf(adminVentas.calcularMontoVenta());
        ArrayList<Articulo> articulosVendidos = carritoCompras.getArticulosEnCarrito();
        
        JOptionPane.showMessageDialog(null, "Monto total de la venta: $" + montoVenta);
        claveEmpleado = JOptionPane.showInputDialog("Ingrese la clave del empleado");
                adminVentas.realizarVenta(claveEmpleado);
                adminInventario.actualizarCantidadArticulos(articulosVendidos);
                
                JOptionPane.showMessageDialog(null, "Venta exitosa");
                borrarContenidoTablaCarrito(); 
        
    }
    
    public void desplegarPanelRealizarVenta(){
        mostrarPanelRealizarVenta();
    }
    
    private void configurarPanelRealizarVenta(){
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( VentanaVentas.obtenerContenedorVentanaVentas() );
        VentanaVentas.obtenerContenedorVentanaVentas().setLayout( layout );
        layout.setHorizontalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( layout.createSequentialGroup( )
                .addComponent( panelRealizarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 280, Short.MAX_VALUE) )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( layout.createSequentialGroup( )
                .addComponent( panelRealizarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 237, Short.MAX_VALUE) )
        );
    }
    
    public void ocultarPanelRealizarVenta(){
        panelRealizarVenta.setVisible(false);
    }
}
