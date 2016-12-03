/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Ventanas;

import Ventanas.VentanaPrincipal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;

/**
 *
 * @author rodrigopeniche
 */
public class ControladorVentanaPrincipal {

    private VentanaPrincipal ventanaPrincipal;
    private ControladorVentanaInventario controladorVentanaInventario;
    private ControladorVentanaProveedores controladorVentanaProveedores;
    private ControladorVentanaVentas controladorVentanaVentas;
    private ControladorVentanaEmpleados controladorVentanaEmpleados;
    private ControladorVentanaReportes controladorVentanaReportes;
    
    public void inicializarVentanaPrincipal() {
        ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
        agregarEventoBotonAgregarArticulo();
        agregarEventoBotonVerInventario();
        agregarEventoBotonVerProveedores();
        agregarEventoBotonAgregarProveedor();
        agregarEventoBotonVerVentas();
        agregarEventoBotonRealizarVenta();
        agregarEventoBotonVerEmpleados();
        agregarEventoBotonAgregarEmpleado( );
        agregarEventoBotonGenerarReporte();
    }

    public void agregarEventoBotonVerInventario() {
        JMenuItem botonVerInventario = ventanaPrincipal.getMenuItemVerInventario();
        botonVerInventario.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                inicializarPanelVerInventario();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        ventanaPrincipal.setMenuItemVerInventario(botonVerInventario);
    }
    
    public void agregarEventoBotonGenerarReporte() {
        JMenuItem botonGenerarReporte = ventanaPrincipal.getMenuItemGenerarReporte();
        botonGenerarReporte.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                inicializarPanelReportes();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        ventanaPrincipal.setMenuItemGenerarReporte(botonGenerarReporte);
    }

    public void agregarEventoBotonAgregarArticulo() {
        JMenuItem botonAgregarArticulo = ventanaPrincipal.getMenuItemAgregarArticulo();
        botonAgregarArticulo.addActionListener((java.awt.event.ActionEvent evt) -> {
            inicializarPanelAgregarArticulo();
        });
        ventanaPrincipal.setMenuItemAgregarArticulo(botonAgregarArticulo);
    }

    public void agregarEventoBotonVerProveedores() {
        JMenuItem botonVerProveedores = ventanaPrincipal.getMenuItemVerProveedores();
        botonVerProveedores.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                inicializarPanelVerProveedores();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        ventanaPrincipal.setMenuItemVerProveedores(botonVerProveedores);
    }

    public void agregarEventoBotonAgregarProveedor() {
        JMenuItem botonAgregarProveedor = ventanaPrincipal.getMenuItemAgregarProveedor();
        botonAgregarProveedor.addActionListener((java.awt.event.ActionEvent evt) -> {
            inicializarPanelAgregarProveedores();
        });
        ventanaPrincipal.setMenuItemAgregarProveedor(botonAgregarProveedor);
    }

    public void agregarEventoBotonVerVentas( ){
        JMenuItem botonVerVentas = ventanaPrincipal.getMenuItemVerVentas();
        botonVerVentas.addActionListener( ( java.awt.event.ActionEvent evt ) -> {
            try {
                inicializarPanelVerVentas();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControladorVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        ventanaPrincipal.setMenuItemVerVentas(botonVerVentas);
    }
    
    public void agregarEventoBotonRealizarVenta( ){
        JMenuItem botonRealizarVenta = ventanaPrincipal.getMenuItemRealizarVenta();
        botonRealizarVenta.addActionListener( ( java.awt.event.ActionEvent evt ) -> {
            inicializarPanelRealizarVenta();
        });
        ventanaPrincipal.setMenuItemRealizarVenta(botonRealizarVenta);
    }
    
    public void agregarEventoBotonVerEmpleados( ){
        JMenuItem botonVerEmpleados = ventanaPrincipal.getMenuItemEmpleados();
        botonVerEmpleados.addActionListener( ( java.awt.event.ActionEvent evt ) -> {
            inicializarPanelVerEmpleados();
        });
        ventanaPrincipal.setMenuItemVerEmpleados(botonVerEmpleados);
    }
    
    public void agregarEventoBotonAgregarEmpleado( ){
        JMenuItem botonAgregarEmpleado = ventanaPrincipal.getMenuItemAgregarEmpleado();
        botonAgregarEmpleado.addActionListener( ( java.awt.event.ActionEvent evt ) -> {
            inicializarPanelAgregarEmpleado();
        });
        ventanaPrincipal.setMenuItemAgregarEmpleado(botonAgregarEmpleado);
    }
    
  
    

    private void inicializarPanelVerInventario() throws SQLException {
        controladorVentanaInventario = new ControladorVentanaInventario();

        controladorVentanaInventario.getControladorPanelInventario().desplegarPanelVerInventario();
        controladorVentanaInventario.getControladorPanelInventario().agregarEventoBotonBuscarArticulo();
        controladorVentanaInventario.getControladorPanelInventario().agregarEventoBotonEliminarArticulo();
        controladorVentanaInventario.getControladorPanelInventario().agregarEventoBotonActualizarArticulo();

    }
    
    private void inicializarPanelReportes() throws SQLException {
        controladorVentanaReportes = new ControladorVentanaReportes();

    }
    
    private void inicializarPanelReportes() throws SQLException {
        controladorVentanaReportes = new ControladorVentanaReportes();
    }

    private void inicializarPanelAgregarArticulo() {
        controladorVentanaInventario = new ControladorVentanaInventario();
        controladorVentanaInventario.getControladorPanelAgregarArticulo().desplegarPanelAgregarArticulo();
    }

    private void inicializarPanelVerProveedores() throws SQLException {
        controladorVentanaProveedores = new ControladorVentanaProveedores();

        controladorVentanaProveedores.getControladorPanelProveedor().desplegarPanelVerProveedores();
        controladorVentanaProveedores.getControladorPanelProveedor().agregarEventoBotonBuscarProveedor();
        controladorVentanaProveedores.getControladorPanelProveedor().agregarEventoBotonEliminarProveedor();
        controladorVentanaProveedores.getControladorPanelProveedor().agregarEventoBotonActualizarProveedor();
    }

    private void inicializarPanelAgregarProveedores() {
        controladorVentanaProveedores = new ControladorVentanaProveedores();
        controladorVentanaProveedores.getControladorPanelAgregarProveedor().desplegarPanelAgregarProveedor();
    }

     private void inicializarPanelVerVentas( ) throws ClassNotFoundException, SQLException{
        controladorVentanaVentas = new ControladorVentanaVentas();
        controladorVentanaVentas.desplegarPanelVerVentas();
     }
     
     private void inicializarPanelRealizarVenta( ){
        controladorVentanaVentas = new ControladorVentanaVentas();
        controladorVentanaVentas.desplegarPanelRealizarVenta();
        controladorVentanaVentas.agregarEventoBotonAgregarAlCarrito();
        controladorVentanaVentas.agregarEventoBotonEliminarDelCarrito();
        controladorVentanaVentas.agregarEventoBotonRealizarVenta();
     }
     
     public void inicializarPanelVerEmpleados(){
         controladorVentanaEmpleados = new ControladorVentanaEmpleados();
         controladorVentanaEmpleados.desplegarPanelVerEmpleados();
         controladorVentanaEmpleados.agregarEventoBotonActualizarEmpleado();
         controladorVentanaEmpleados.agregarEventoBotonBuscarEmpleado();
         controladorVentanaEmpleados.agregarEventoBotonEliminarEmpleado();
     }
     
     public void inicializarPanelAgregarEmpleado(){
         controladorVentanaEmpleados = new ControladorVentanaEmpleados();
         controladorVentanaEmpleados.desplegarPanelAgregarEmpleado();
     }
     
}
