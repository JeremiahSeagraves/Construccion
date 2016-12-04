/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Ventanas;

import Administradores.AdministradorEmpleados;
import Ventanas.VentanaPrincipal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
    
    private AdministradorEmpleados adminEmpleados;
    
    private String adminContrasena;
    
    public void inicializarVentanaPrincipal() {
        ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
        
        adminEmpleados = new AdministradorEmpleados();
        adminContrasena = adminEmpleados.getAdminContrasena();
        
        agregarEventoBotonAgregarArticulo();
        agregarEventoBotonVerInventario();
        agregarEventoBotonVerProveedores();
        agregarEventoBotonAgregarProveedor();
        agregarEventoBotonVerVentas();
        agregarEventoBotonRealizarVenta();
        agregarEventoBotonVerEmpleados();
        agregarEventoBotonAgregarEmpleado();
        agregarEventoBotonGenerarReporte();
    }

    private void agregarEventoBotonVerInventario() {
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

   private void agregarEventoBotonGenerarReporte() {
        JMenuItem botonGenerarReporte = ventanaPrincipal.getMenuItemGenerarReporte();
        botonGenerarReporte.addActionListener((java.awt.event.ActionEvent evt) -> {
                inicializarPanelReportes();
        });
        ventanaPrincipal.setMenuItemGenerarReporte(botonGenerarReporte);
    }

    private void agregarEventoBotonAgregarArticulo() {
        JMenuItem botonAgregarArticulo = ventanaPrincipal.getMenuItemAgregarArticulo();
        botonAgregarArticulo.addActionListener((java.awt.event.ActionEvent evt) -> {
            inicializarPanelAgregarArticulo();
        });
        ventanaPrincipal.setMenuItemAgregarArticulo(botonAgregarArticulo);
    }

    private void agregarEventoBotonVerProveedores() {
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

    private void agregarEventoBotonAgregarProveedor() {
        JMenuItem botonAgregarProveedor = ventanaPrincipal.getMenuItemAgregarProveedor();
        botonAgregarProveedor.addActionListener((java.awt.event.ActionEvent evt) -> {
            inicializarPanelAgregarProveedores();
        });
        ventanaPrincipal.setMenuItemAgregarProveedor(botonAgregarProveedor);
    }

    private void agregarEventoBotonVerVentas() {
        JMenuItem botonVerVentas = ventanaPrincipal.getMenuItemVerVentas();
        botonVerVentas.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                inicializarPanelVerVentas();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControladorVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        ventanaPrincipal.setMenuItemVerVentas(botonVerVentas);
    }

    private void agregarEventoBotonRealizarVenta() {
        JMenuItem botonRealizarVenta = ventanaPrincipal.getMenuItemRealizarVenta();
        botonRealizarVenta.addActionListener((java.awt.event.ActionEvent evt) -> {
            inicializarPanelRealizarVenta();
        });
        ventanaPrincipal.setMenuItemRealizarVenta(botonRealizarVenta);
    }

    private void agregarEventoBotonVerEmpleados() {
        
        JMenuItem botonVerEmpleados = ventanaPrincipal.getMenuItemEmpleados();
        botonVerEmpleados.addActionListener((java.awt.event.ActionEvent evt) -> {
            inicializarPanelVerEmpleados();
        });
        ventanaPrincipal.setMenuItemVerEmpleados(botonVerEmpleados);
        
       
    }

    private void agregarEventoBotonAgregarEmpleado() {
        JMenuItem botonAgregarEmpleado = ventanaPrincipal.getMenuItemAgregarEmpleado();
        botonAgregarEmpleado.addActionListener((java.awt.event.ActionEvent evt) -> {
            inicializarPanelAgregarEmpleado();
        });
        ventanaPrincipal.setMenuItemAgregarEmpleado(botonAgregarEmpleado);
    }
    
    private boolean validarContrasenaAdmin(){
        boolean coincidencia_contrasenas = false;
        String input_usuario;
        input_usuario = JOptionPane.showInputDialog("Ingrese la contrasena");
        
        if(input_usuario !=  null){
         if(input_usuario.equals(adminContrasena)){
                coincidencia_contrasenas = true;
           }
        }
   
        return coincidencia_contrasenas;
    }
    
  
    private void inicializarPanelVerInventario() throws SQLException {
        controladorVentanaInventario = new ControladorVentanaInventario();

        controladorVentanaInventario.getControladorPanelInventario().desplegarPanelVerInventario();
        controladorVentanaInventario.getControladorPanelInventario().agregarEventoBotonBuscarArticulo();
        controladorVentanaInventario.getControladorPanelInventario().agregarEventoBotonEliminarArticulo();
        controladorVentanaInventario.getControladorPanelInventario().agregarEventoBotonActualizarArticulo();

    }

     private void inicializarPanelReportes(){
        controladorVentanaReportes = new ControladorVentanaReportes();
        controladorVentanaReportes.getControladorPanelSeleccionarReporte().desplegarPanelSeleccionarReporte();
        controladorVentanaReportes.getControladorPanelSeleccionarReporte().agregarEventoComboBoxReporte();
        controladorVentanaReportes.getControladorPanelSeleccionarReporte().agregarEventoBotonGenerar();

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

    private void inicializarPanelVerVentas() throws ClassNotFoundException, SQLException {
        controladorVentanaVentas = new ControladorVentanaVentas();
        controladorVentanaVentas.getControladorPanelVerVentas().desplegarPanelVerVentas();
    }

    private void inicializarPanelRealizarVenta() {
        controladorVentanaVentas = new ControladorVentanaVentas();
        controladorVentanaVentas.getControladorPanelRealizarVenta().desplegarPanelRealizarVenta();
        controladorVentanaVentas.getControladorPanelRealizarVenta().agregarEventoBotonAgregarAlCarrito();
        controladorVentanaVentas.getControladorPanelRealizarVenta().agregarEventoBotonEliminarDelCarrito();
        controladorVentanaVentas.getControladorPanelRealizarVenta().agregarEventoBotonRealizarVenta();
    }

    private void inicializarPanelVerEmpleados() {
       
        if(validarContrasenaAdmin()){
        controladorVentanaEmpleados = new ControladorVentanaEmpleados();
        controladorVentanaEmpleados.getControladorPanelEmpleados().desplegarPanelVerEmpleados();
        controladorVentanaEmpleados.getControladorPanelEmpleados().agregarEventoBotonBuscarEmpleado();
        controladorVentanaEmpleados.getControladorPanelEmpleados().agregarEventoBotonEliminarEmpleado();
        controladorVentanaEmpleados.getControladorPanelEmpleados().agregarEventoBotonActualizarEmpleado();
        }
        else{
            JOptionPane.showMessageDialog(null, "Contrasena incorrecta");
        }
    }

    private void inicializarPanelAgregarEmpleado() {
        
        if(validarContrasenaAdmin()){
        controladorVentanaEmpleados = new ControladorVentanaEmpleados();
        controladorVentanaEmpleados.getControladorPanelAgregarEmpleado().desplegarPanelAgregarEmpleado();
        }
        else{
            JOptionPane.showMessageDialog(null, "Contrasena incorrecta");
        }
    }

}
