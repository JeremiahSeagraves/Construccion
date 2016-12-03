/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Inventario;

import Administradores.AdministradorInventario;
import Modelo.Articulo;
import Ventanas.Inventario.PanelBuscarArticulo;
import Ventanas.Inventario.VentanaInventario;
import javax.swing.JButton;

/**
 *
 * @author juan
 */
public class ControladorPanelBuscarArticulo {

    private static ControladorPanelBuscarArticulo controladorPanelBuscarArticulo = null;
    private static PanelBuscarArticulo panelBuscarArticulo = null;

    public ControladorPanelBuscarArticulo() {

    }

    public static ControladorPanelBuscarArticulo obtenerControladorPanelBuscarArticulo() {
        if (controladorPanelBuscarArticulo == null) {
            controladorPanelBuscarArticulo = new ControladorPanelBuscarArticulo();
            panelBuscarArticulo = new PanelBuscarArticulo();
        }
        return controladorPanelBuscarArticulo;
    }

    public void configurarPanelBuscarArticulo() {
        mostrarPanelBuscarArticulo();
        ControladorPanelAgregarArticulo.obtenerControladorPanelAgregaArticulo().ocultarPanelAgregarArticulo();
        ControladorPanelActualizarArticulo.obtenerControladorPanelActualizarArticulo().ocultarPanelActualizarArticulo();
        ControladorPanelEliminarArticulo.obtenerControladorPanelEliminarArticulo().ocultarPanelEliminarArticulo();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaInventario.obtenerContenedorVentanaInventario());
        VentanaInventario.obtenerContenedorVentanaInventario().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(566, Short.MAX_VALUE)
                        .addComponent(panelBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(panelBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(180, Short.MAX_VALUE))
        );
    }

    public void agregarEventoBotonBuscar() {
        JButton botonBuscar = panelBuscarArticulo.getBotonBuscar();

        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonBuscarArticulo();
            }
        });
        panelBuscarArticulo.setBotonBuscar(botonBuscar);
    }

    void agregarEventoBotonCancelarBusqueda() {
        JButton botonCancelar = panelBuscarArticulo.getBotonCancelar();

        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
             accionarBotonCancelarBusqueda();
            }
        });
        panelBuscarArticulo.setBotonCancelar(botonCancelar);
    }

    private void accionarBotonCancelarBusqueda(){
        panelBuscarArticulo.setVisible(false);
        panelBuscarArticulo.vaciarCamposPanelBuscarArticulo();
        panelBuscarArticulo.ocultarCamposPanelBuscarArticulo();
    }
    
    private void accionarBotonBuscarArticulo() {
        panelBuscarArticulo.mostrarCamposPanelBuscarArticulo();

        String claveArticulo = panelBuscarArticulo.getCampoTextoClave().getText();
        AdministradorInventario admin = new AdministradorInventario();
        Articulo articulo = admin.buscar(claveArticulo);

        panelBuscarArticulo.setCampoTextoDescripcion(articulo.getDescripcion());
        panelBuscarArticulo.setCampoTextoCantidad(String.valueOf(articulo.getDetalleArticulo().getCantidad()));
        panelBuscarArticulo.setCampoTextoPrecioCompra(String.valueOf(articulo.getDetalleArticulo().getPrecioCompra().getPrecio()));
        panelBuscarArticulo.setCampoTextoPrecioVenta(String.valueOf(articulo.getDetalleArticulo().getPrecioVenta().getPrecio()));
    }

    public void mostrarPanelBuscarArticulo() {
        panelBuscarArticulo.setVisible(true);
    }

    public void ocultarPanelBuscarArticulo() {
        panelBuscarArticulo.setVisible(false);
        panelBuscarArticulo.vaciarCamposPanelBuscarArticulo();
        panelBuscarArticulo.ocultarCamposPanelBuscarArticulo();
    }

 
}
