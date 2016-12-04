/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Ventanas;


import Administradores.AdministradorInventario;
import Administradores.AdministradorVentas;
import Modelo.Articulo;
import Modelo.CarritoCompras;
import Modelo.Venta;
import Ventanas.Ventas.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author rodrigopeniche
 */
public class ControladorVentanaVentas {
    
    private VentanaVentas ventanaVentas;
    private PanelRealizarVenta panelRealizarVenta;
    private PanelVerVentas panelVerVentas;
    private final AdministradorVentas adminVentas;
    private final CarritoCompras carritoCompras;
    
    private ArrayList<Venta> ventas;
    
    public ControladorVentanaVentas(){
        ventanaVentas = new VentanaVentas();
        inicializarVentana();
        adminVentas = new AdministradorVentas();
        carritoCompras = adminVentas.getCarritoCompras();
    }
    
    void desplegarPanelRealizarVenta(){
        panelRealizarVenta = ventanaVentas.getPanelRealizarVenta();
        ventanaVentas.mostrarPanelRealizarVenta();
    }
    
    void desplegarPanelVerVentas() throws ClassNotFoundException, SQLException{
        panelVerVentas = ventanaVentas.getPanelVerVentas();
        ventanaVentas.mostrarPenalVerVentas();
        obtenerVentasBD();
        llenarTablaVentas(ventas);
    }
    
    void agregarEventoBotonAgregarAlCarrito() {
        panelRealizarVenta = ventanaVentas.getPanelRealizarVenta();
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
    
    private void llenarTablaVentas(ArrayList<Venta> ventas) throws ClassNotFoundException, SQLException{
//        int articulosVendidos = adminVentas.obtenerTotalArticulosVendidos();
//        
//        for(int i = 0; i<articulosVendidos; i++){
//            panelVerVentas.getContenidoTablaVentas().addRow(new Object[]{ventas.get(i).getClave(),
//                                                            ventas.get(i)});
//        }
    }
    
    private void obtenerVentasBD(){
        ventas = (ArrayList<Venta>) adminVentas.obtenerDatos();
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
    
    private void actualizarTablaCarrito() throws SQLException, ClassNotFoundException{
        borrarContenidoTablaCarrito();
        llenarTablaCarrito(carritoCompras);
    }
    
    private void borrarContenidoTablaCarrito(){
        panelRealizarVenta.getContenidoTablaCarrito().setRowCount(0);
    }
    
    void agregarEventoBotonEliminarDelCarrito(){
        panelRealizarVenta = ventanaVentas.getPanelRealizarVenta();
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
    
    void agregarEventoBotonRealizarVenta(){
        panelRealizarVenta = ventanaVentas.getPanelRealizarVenta();
        JButton botonRealizarVenta = panelRealizarVenta.getBotonRealizarVenta();
        
        botonRealizarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonEventoRealizarVenta();
 
            }
        });
        panelRealizarVenta.setBotonRealizarVenta(botonRealizarVenta);
    }
    
    private void accionarBotonEventoRealizarVenta(){
        String claveEmpleado;
        String montoVenta = String.valueOf(adminVentas.calcularMontoVenta());
        
        JOptionPane.showMessageDialog(ventanaVentas, "Total de venta: $" + montoVenta);
        claveEmpleado = JOptionPane.showInputDialog("Ingrese la clave del empleado");

       
        
        try {
            adminVentas.realizarVenta( claveEmpleado );
            JOptionPane.showMessageDialog(null, "Venta exitosa");
            borrarContenidoTablaCarrito();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorVentanaVentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVentanaVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    private void inicializarVentana() {
        this.ventanaVentas = new VentanaVentas();
        this.ventanaVentas.setVisible(true);
    }
    
}
