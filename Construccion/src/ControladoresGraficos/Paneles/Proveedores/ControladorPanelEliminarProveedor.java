/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Proveedores;

import Administradores.AdministradorProveedores;
import ControladoresGraficos.Ventanas.ControladorVentanaInventario;
import Ventanas.Proveedores.PanelEliminarProveedor;
import Ventanas.Proveedores.VentanaProveedores;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class ControladorPanelEliminarProveedor {

    private static PanelEliminarProveedor panelEliminarProveedor;
    private static ControladorPanelEliminarProveedor controladorPanelEliminarProveedor;

    private ControladorPanelEliminarProveedor() {

    }

    public static ControladorPanelEliminarProveedor obtenerControladorPanelEliminarProveedor() {
        if (controladorPanelEliminarProveedor == null) {
            controladorPanelEliminarProveedor = new ControladorPanelEliminarProveedor();
            panelEliminarProveedor = new PanelEliminarProveedor();
        }
        return controladorPanelEliminarProveedor;
    }

    public void mostrarPanelEliminarProveedor() {
        configurarPanelEliminarProveedor();
        panelEliminarProveedor.setVisible(true);
        ocultarOtrosPaneles();
    }

    private void ocultarOtrosPaneles() {
        ControladorPanelAgregarProveedor.obtenerControladorPanelAgregarProveedor().ocultarPanelAgregarProveedor();
        ControladorPanelActualizarProveedor.obtenerControladorPanelActualizarProveedor().ocultarPanelActualizarProveedor();
        ControladorPanelBuscarProveedor.obtenerControladorPanelBuscarProveedor().ocultarPanelBuscarProveedor();

    }

    void agregarEventoBotonEliminar() {
        JButton botonEliminar = panelEliminarProveedor.getBotonEliminar();

        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonEliminarProveedor();
            }
        });
        panelEliminarProveedor.setBotonEliminar(botonEliminar);
    }

    private void accionarBotonEliminarProveedor() {
        AdministradorProveedores adminProveedores = new AdministradorProveedores();
        String claveProveedor = panelEliminarProveedor.getCampoTextoClave().getText();

        ControladorPanelVerProveedores controladorPanelVerProveedores = ControladorPanelVerProveedores.obtenerControladorPanelVerProveedores();
        try {
            adminProveedores.eliminar(claveProveedor);
            controladorPanelVerProveedores.actualizarTablaProveedores();
            JOptionPane.showMessageDialog(null, "Proveedor eliminado exitosamente");
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar el proveedor");
            Logger.getLogger(ControladorVentanaInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarEventoBotonCancelarEliminacion() {
        JButton botonCancelarEliminacion = panelEliminarProveedor.getBotonCancelar();

        botonCancelarEliminacion.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelEliminarProveedor.setVisible(false);
            }
        });
        panelEliminarProveedor.setBotonCancelar(botonCancelarEliminacion);
    }

    private void configurarPanelEliminarProveedor() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaProveedores.obtenerContenedorVentanaProveedores());
        VentanaProveedores.obtenerContenedorVentanaProveedores().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(panelEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(282, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(342, Short.MAX_VALUE)
                        .addComponent(panelEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
        );
    }

    public void ocultarPanelEliminarProveedor() {
        panelEliminarProveedor.setVisible(false);
        panelEliminarProveedor.vaciarCamposPanelEliminarProveedor();
    }
}
