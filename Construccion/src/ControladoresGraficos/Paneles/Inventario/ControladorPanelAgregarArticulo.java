/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Inventario;

import Administradores.AdministradorInventario;
import Modelo.Articulo;
import Modelo.DetalleArticulo;
import Modelo.Precio;
import Ventanas.Inventario.PanelAgregarArticulo;
import Ventanas.Inventario.VentanaInventario;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class ControladorPanelAgregarArticulo {

    private static ControladorPanelAgregarArticulo controladorPanelAgregarArticulo = null;
    private static PanelAgregarArticulo panelAgregarArticulo = null;

    private ControladorPanelAgregarArticulo() {
        
    }

    public static ControladorPanelAgregarArticulo obtenerControladorPanelAgregaArticulo() {
        if (controladorPanelAgregarArticulo == null) {
            controladorPanelAgregarArticulo = new ControladorPanelAgregarArticulo();
            panelAgregarArticulo = new PanelAgregarArticulo();
        }
        return controladorPanelAgregarArticulo;
    }

    public void configurarPanelAgregarArticulo() {
        mostrarPanelAgregarArticulo();
        ControladorPanelBuscarArticulo.obtenerControladorPanelBuscarArticulo().ocultarPanelBuscarArticulo();
        ControladorPanelActualizarArticulo.obtenerControladorPanelActualizarArticulo().ocultarPanelActualizarArticulo();
        ControladorPanelEliminarArticulo.obtenerControladorPanelEliminarArticulo().ocultarPanelEliminarArticulo();
        ControladorPanelInventario.obtenerControladorPanelInventario().ocultarPanelInventario();
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaInventario.obtenerContenedorVentanaInventario());
        VentanaInventario.obtenerContenedorVentanaInventario().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelAgregarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 492, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelAgregarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 208, Short.MAX_VALUE))
        );
    }

    public void desplegarPanelAgregarArticulo() {
        configurarPanelAgregarArticulo();
        agregarEventoBotonAgregarArticulo();
        agregarEventoBotonCancelarAgregacion();
    }

    private void agregarEventoBotonAgregarArticulo() {
        JButton botonAgregar = panelAgregarArticulo.getBotonAgregarArticulo();
        botonAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonAgregarArticulo();
            }
        });
    }

    private void agregarEventoBotonCancelarAgregacion() {
        JButton botonCancelar = panelAgregarArticulo.getBotonCancelar();

        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
            }
        });
        panelAgregarArticulo.setBotonCancelar(botonCancelar);
    }
    
    private void accionarBotonCancelarAgregacion(){
    panelAgregarArticulo.setVisible(false);
    panelAgregarArticulo.vaciarCamposAgregarArticulo();
    }

    private void accionarBotonAgregarArticulo() {

        String claveArticulo = panelAgregarArticulo.getCampoTextoClave().getText();
        String claveProveedor = panelAgregarArticulo.getCampoTextoClaveProveedor().getText();
        String descripcion = panelAgregarArticulo.getCampoTextoDescripcion().getText();
        String cantidad = panelAgregarArticulo.getCampoTextoCantidad().getText();
        String precioCompra = panelAgregarArticulo.getCampoTextoPrecioCompra().getText();
        String precioVenta = panelAgregarArticulo.getCampoTextoPrecioVenta().getText();

        AdministradorInventario admin = new AdministradorInventario();

        Articulo articulo = new Articulo(claveArticulo, claveProveedor, descripcion,
                new DetalleArticulo(Integer.parseInt(cantidad),
                        new Precio(Double.parseDouble(precioCompra)),
                        new Precio(Double.parseDouble(precioVenta))));

        try {
            admin.agregar(articulo);
            JOptionPane.showMessageDialog(null, "El artículo se ha agregado exitosamente");
            panelAgregarArticulo.vaciarCamposAgregarArticulo();
        } catch (HeadlessException createException) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar el artículo");
        }
    }

    public void mostrarPanelAgregarArticulo(){
        panelAgregarArticulo.setVisible(true);
    }
    
    public void ocultarPanelAgregarArticulo() {
        panelAgregarArticulo.setVisible(false);
        panelAgregarArticulo.vaciarCamposAgregarArticulo();
    }

    public PanelAgregarArticulo getPanelAgregarArticulo() {
        return panelAgregarArticulo;
    }
    

}
