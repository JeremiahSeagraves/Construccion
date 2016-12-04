/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Proveedores;

import Administradores.AdministradorProveedores;
import Modelo.Proveedor;
import Ventanas.Proveedores.PanelAgregarProveedor;
import Ventanas.Proveedores.VentanaProveedores;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class ControladorPanelAgregarProveedor {

    private static PanelAgregarProveedor panelAgregarProveedor;
    private static ControladorPanelAgregarProveedor controladorPanelAgregarProveedor;

    private ControladorPanelAgregarProveedor() {

    }

    public static ControladorPanelAgregarProveedor obtenerControladorPanelAgregarProveedor() {
        if (controladorPanelAgregarProveedor == null) {
            controladorPanelAgregarProveedor = new ControladorPanelAgregarProveedor();
            panelAgregarProveedor = new PanelAgregarProveedor();
        }
        return controladorPanelAgregarProveedor;
    }

    public void mostrarPanelAgregarProveedor() {
        configurarPanelAgregarProveedor();
        panelAgregarProveedor.setVisible(true);
        ocultarOtrosPaneles();
    }

    private void ocultarOtrosPaneles() {
        ControladorPanelBuscarProveedor.obtenerControladorPanelBuscarProveedor().ocultarPanelBuscarProveedor();
        ControladorPanelActualizarProveedor.obtenerControladorPanelActualizarProveedor().ocultarPanelActualizarProveedor();
        ControladorPanelEliminarProveedor.obtenerControladorPanelEliminarProveedor().ocultarPanelEliminarProveedor();
        ControladorPanelVerProveedores.obtenerControladorPanelVerProveedores().ocultarPanelVerProveedores();

    }

    public void desplegarPanelAgregarProveedor() {
        mostrarPanelAgregarProveedor();
        agregarEventoBotonAgregarProveedor();
        agregarEventoBotonCancelarAgregacion();
    }

    private void agregarEventoBotonAgregarProveedor() {
        JButton botonAgregar = panelAgregarProveedor.getBotonAgregar();
        botonAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonAgregarProveedor();
            }
        });
        panelAgregarProveedor.setBotonAgregar(botonAgregar);
    }

    private void accionarBotonAgregarProveedor() {
        String claveProveedor = panelAgregarProveedor.getCampoTextoClave().getText();
        String nombre = panelAgregarProveedor.getCampoTextoNombre().getText();
        String telefono = panelAgregarProveedor.getCampoTextoTel().getText();
        String direccion = panelAgregarProveedor.getCampoTextoDireccion().getText();

        AdministradorProveedores adminProveedores = new AdministradorProveedores();

        Proveedor proveedor = new Proveedor(claveProveedor, nombre, telefono, direccion);

        try {
            adminProveedores.agregar(proveedor);
            JOptionPane.showMessageDialog(null, "El proveedor se ha agregado exitosamente");
            panelAgregarProveedor.vaciarCamposAgregarProveedor();
        } catch (HeadlessException createException) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar el proveedor");
        }

        panelAgregarProveedor.vaciarCamposAgregarProveedor();
    }

    private void agregarEventoBotonCancelarAgregacion() {
        JButton botonCancelar = panelAgregarProveedor.getBotonCancelar();

        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonCancelarAgregacion();
            }
        });
        panelAgregarProveedor.setBotonCancelar(botonCancelar);
    }

    private void accionarBotonCancelarAgregacion() {
        panelAgregarProveedor.setVisible(false);
        panelAgregarProveedor.vaciarCamposAgregarProveedor();
    }

    private void configurarPanelAgregarProveedor() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaProveedores.obtenerContenedorVentanaProveedores());
        VentanaProveedores.obtenerContenedorVentanaProveedores().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelAgregarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 492, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelAgregarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 208, Short.MAX_VALUE))
        );
    }

    public void ocultarPanelAgregarProveedor() {
        panelAgregarProveedor.setVisible(false);
        panelAgregarProveedor.vaciarCamposAgregarProveedor();
    }

    public PanelAgregarProveedor getPanelAgregarProveedor() {
        return panelAgregarProveedor;
    }
}
