/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Proveedores;

import Administradores.AdministradorProveedores;
import Modelo.Proveedor;
import Ventanas.Proveedores.PanelActualizarProveedor;
import Ventanas.Proveedores.VentanaProveedores;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class ControladorPanelActualizarProveedor {

    private static PanelActualizarProveedor panelActualizarProveedor;
    private static ControladorPanelActualizarProveedor controladorPanelActualizarProveedor;

    private ControladorPanelActualizarProveedor() {

    }

    public static ControladorPanelActualizarProveedor obtenerControladorPanelActualizarProveedor() {
        if (controladorPanelActualizarProveedor == null) {
            controladorPanelActualizarProveedor = new ControladorPanelActualizarProveedor();
            panelActualizarProveedor = new PanelActualizarProveedor();
        }
        return controladorPanelActualizarProveedor;
    }
    
        public void configurarPanelActualizarProveedor( ){
        panelActualizarProveedor.setVisible(true);
         mostrarPanelActualizarProveedor();
        ControladorPanelAgregarProveedor.obtenerControladorPanelAgregarProveedor().ocultarPanelAgregarProveedor();
        ControladorPanelBuscarProveedor.obtenerControladorPanelBuscarProveedor().ocultarPanelBuscarProveedor();
        ControladorPanelEliminarProveedor.obtenerControladorPanelEliminarProveedor().ocultarPanelEliminarProveedor();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaProveedores.obtenerContenedorVentanaProveedores());
        VentanaProveedores.obtenerContenedorVentanaProveedores().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(456, Short.MAX_VALUE)
                .addComponent(panelActualizarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelActualizarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 202, Short.MAX_VALUE))
        ); 
     }

    public void agregarEventoBotonActualizar() {
        JButton botonActualizar = panelActualizarProveedor.getBotonGuardarCambios();
        botonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonActualizarProveedor();
            }
        });
    }

    private void accionarBotonActualizarProveedor() {

        String claveProveedor = panelActualizarProveedor.getCampoTextoClave().getText();
        String nuevoNombre = panelActualizarProveedor.getCampoTextoNombre().getText();
        String nuevoTel = panelActualizarProveedor.getCampoTextoTel().getText();
        String nuevaDireccion = panelActualizarProveedor.getCampoTextoDireccion().getText();

        Proveedor proveedor;
        proveedor = new Proveedor(claveProveedor, nuevoNombre, nuevoTel, nuevaDireccion);

        AdministradorProveedores adminProveedores = new AdministradorProveedores();

        try {
            adminProveedores.actualizar(proveedor);
            JOptionPane.showMessageDialog(null, "El proveedor ha sido actualizado exitosamente");
        } catch (HeadlessException updateException) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el proveedor");
        }
        
        ControladorPanelVerProveedores controladorPanelVerProveedores = ControladorPanelVerProveedores.obtenerControladorPanelVerProveedores();
        try {
            controladorPanelVerProveedores.actualizarTablaProveedores();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PanelActualizarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        panelActualizarProveedor.vaciarCamposActualizarProveedor();
    }

    public void agregarEventoBotonCancelarActualizacion() {
        JButton botonCancelar = panelActualizarProveedor.getBotonCancelar();
        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelActualizarProveedor.setVisible(false);
            }
        });
        panelActualizarProveedor.setBotonCancelar(botonCancelar);
    }
    
        public void mostrarPanelActualizarProveedor() {
        panelActualizarProveedor.setVisible(true);
    }

    public void ocultarPanelActualizarProveedor() {
        panelActualizarProveedor.setVisible(false);
        panelActualizarProveedor.vaciarCamposActualizarProveedor();
    }
}
