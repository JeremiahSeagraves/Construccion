/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Proveedores;

import Administradores.AdministradorProveedores;
import Modelo.Proveedor;
import Ventanas.Proveedores.PanelBuscarProveedor;
import Ventanas.Proveedores.VentanaProveedores;
import javax.swing.JButton;

/**
 *
 * @author juan
 */
public class ControladorPanelBuscarProveedor {

    private static PanelBuscarProveedor panelBuscarProveedor;
    private static ControladorPanelBuscarProveedor controladorPanelBuscarProveedor;

    private ControladorPanelBuscarProveedor() {

    }

    public static ControladorPanelBuscarProveedor obtenerControladorPanelBuscarProveedor() {
        if (controladorPanelBuscarProveedor == null) {
            controladorPanelBuscarProveedor = new ControladorPanelBuscarProveedor();
            panelBuscarProveedor = new PanelBuscarProveedor();
        }
        return controladorPanelBuscarProveedor;
    }

    public void mostrarPanelBuscarProveedor() {
        configurarPanelBuscarProveedor();
        panelBuscarProveedor.setVisible(true);
        ocultarOtrosPaneles();
    }

    private void ocultarOtrosPaneles() {
        ControladorPanelAgregarProveedor.obtenerControladorPanelAgregarProveedor().ocultarPanelAgregarProveedor();
        ControladorPanelActualizarProveedor.obtenerControladorPanelActualizarProveedor().ocultarPanelActualizarProveedor();
        ControladorPanelEliminarProveedor.obtenerControladorPanelEliminarProveedor().ocultarPanelEliminarProveedor();

    }

    public void agregarEventoBotonBuscar() {
        JButton botonBuscar = panelBuscarProveedor.getBotonBuscar();

        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonBuscarProveedor();
            }
        });
        panelBuscarProveedor.setBotonBuscar(botonBuscar);
    }

    private void accionarBotonBuscarProveedor() {
        panelBuscarProveedor.mostrarCampoTextoNombre();
        panelBuscarProveedor.mostrarCampoTextoTel();
        panelBuscarProveedor.mostrarCampoTextoDireccion();
        panelBuscarProveedor.mostrarEtiquetaNombre();
        panelBuscarProveedor.mostrarEtiquetaTel();
        panelBuscarProveedor.mostrarEtiquetaDireccion();

        String claveProveedor = panelBuscarProveedor.getCampoTextoClave().getText();
        AdministradorProveedores adminProveedores = new AdministradorProveedores();
        Proveedor proveedor = adminProveedores.buscar(claveProveedor);

        panelBuscarProveedor.setCampoTextoNombre(proveedor.getNombre());
        panelBuscarProveedor.setCampoTextoTel(proveedor.getTelefono());
        panelBuscarProveedor.setCampoTextoDireccion(proveedor.getDireccion());
    }

    public void agregarEventoBotonCancelarBusqueda() {
        JButton botonCancelar = panelBuscarProveedor.getBotonCancelar();

        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonCancelarBusqueda();
            }
        });
        panelBuscarProveedor.setBotonCancelar(botonCancelar);
    }

    private void accionarBotonCancelarBusqueda() {
        panelBuscarProveedor.setVisible(false);
        panelBuscarProveedor.vaciarCamposPanelBuscarProveedor();
        panelBuscarProveedor.ocultarCamposPanelBuscarProveedor();
    }

    private void configurarPanelBuscarProveedor() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaProveedores.obtenerContenedorVentanaProveedores());
        VentanaProveedores.obtenerContenedorVentanaProveedores().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(566, Short.MAX_VALUE)
                        .addComponent(panelBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(panelBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(180, Short.MAX_VALUE))
        );
    }

    public void ocultarPanelBuscarProveedor() {
        panelBuscarProveedor.setVisible(false);
        panelBuscarProveedor.vaciarCamposPanelBuscarProveedor();
        panelBuscarProveedor.ocultarCamposPanelBuscarProveedor();
    }
}
