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
import Ventanas.Inventario.PanelActualizarArticulo;
import Ventanas.Inventario.VentanaInventario;
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
public class ControladorPanelActualizarArticulo {
    
    private static ControladorPanelActualizarArticulo controladorPanelActualizarArticulo = null;
    private static PanelActualizarArticulo panelActualizarArticulo = null;
    
    public ControladorPanelActualizarArticulo(){
        
    }
    
    public static ControladorPanelActualizarArticulo obtenerControladorPanelActualizarArticulo(){
        if(controladorPanelActualizarArticulo == null){
            controladorPanelActualizarArticulo = new ControladorPanelActualizarArticulo();
            panelActualizarArticulo = new PanelActualizarArticulo();
        }
        return controladorPanelActualizarArticulo;
    }
    
        public void configurarPanelActualizarArticulo(  ){
            mostrarPanelActualizarArticulo();
        ControladorPanelAgregarArticulo.obtenerControladorPanelAgregaArticulo().ocultarPanelAgregarArticulo();
        ControladorPanelBuscarArticulo.obtenerControladorPanelBuscarArticulo().ocultarPanelBuscarArticulo();
        ControladorPanelEliminarArticulo.obtenerControladorPanelEliminarArticulo().ocultarPanelEliminarArticulo();
        
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaInventario.obtenerContenedorVentanaInventario());
        VentanaInventario.obtenerContenedorVentanaInventario().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(456, Short.MAX_VALUE)
                .addComponent(panelActualizarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelActualizarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 202, Short.MAX_VALUE))
        );
     }

    void agregarEventoBotonActualizar() {
        JButton botonActualizar = panelActualizarArticulo.getBotonGuardarCambios();
        botonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonActualizarArticulo();
            }
        });
    }

    private void accionarBotonActualizarArticulo() {
        String claveArticulo = panelActualizarArticulo.getCampoTextoClave().getText();
        String nuevaClaveProveedor = panelActualizarArticulo.getCampoTextoClaveProveedor().getText();
        String nuevaDescripcion = panelActualizarArticulo.getCampoTextoDescripcion().getText();
        String nuevaCantidad = panelActualizarArticulo.getCampoTextoCantidad().getText();
        String nuevoPrecioCompra = panelActualizarArticulo.getCampoTextoPrecioCompra().getText();
        String nuevoPrecioVenta = panelActualizarArticulo.getCampoTextoPrecioVenta().getText();

        Articulo articulo;
        articulo = new Articulo(claveArticulo, nuevaClaveProveedor, nuevaDescripcion,
                new DetalleArticulo(Integer.parseInt(nuevaCantidad),
                        new Precio(Double.parseDouble(nuevoPrecioCompra)),
                        new Precio(Double.parseDouble(nuevoPrecioVenta))));

        AdministradorInventario admin = new AdministradorInventario();
        try {
            admin.actualizar(articulo);
            JOptionPane.showMessageDialog(null, "El artículo ha sido actualizado exitosamente");
        } catch (HeadlessException updateException) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el artículo");
        }

        ControladorPanelInventario controladorPanelInventario = ControladorPanelInventario.obtenerControladorPanelInventario();
        try {
            controladorPanelInventario.actualizarTablaArticulos();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PanelActualizarArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        panelActualizarArticulo.vaciarCamposActualizarArticulo();
    }

    void agregarEventoBotonCancelarActualizacion() {
        JButton botonCancelar = panelActualizarArticulo.getBotonCancelar();
        panelActualizarArticulo.getBotonCancelar().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonCancelarActualizacion();
            }
        });
        panelActualizarArticulo.setBotonCancelar(botonCancelar);
    }
    
    private void accionarBotonCancelarActualizacion(){
        panelActualizarArticulo.setVisible(false);
        panelActualizarArticulo.vaciarCamposActualizarArticulo();
    }
    
    public void mostrarPanelActualizarArticulo(){
        panelActualizarArticulo.setVisible(true);
    }
    
    public void ocultarPanelActualizarArticulo(){
        panelActualizarArticulo.setVisible(false);
        panelActualizarArticulo.vaciarCamposActualizarArticulo();
    }
    
    
    
}
