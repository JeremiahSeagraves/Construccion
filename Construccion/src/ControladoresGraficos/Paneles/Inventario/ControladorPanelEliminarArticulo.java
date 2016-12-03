/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Inventario;

import Administradores.AdministradorInventario;
import ControladoresGraficos.Ventanas.ControladorVentanaInventario;
import Ventanas.Inventario.PanelEliminarArticulo;
import Ventanas.Inventario.VentanaInventario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class ControladorPanelEliminarArticulo {

    private static PanelEliminarArticulo panelEliminarArticulo;
    private static ControladorPanelEliminarArticulo controladorPanelEliminarArticulo = null;

    private ControladorPanelEliminarArticulo() {
        
    }

    public static ControladorPanelEliminarArticulo obtenerControladorPanelEliminarArticulo() {
        if (controladorPanelEliminarArticulo == null) {
            controladorPanelEliminarArticulo = new ControladorPanelEliminarArticulo();
            panelEliminarArticulo = new PanelEliminarArticulo();
        }
        return controladorPanelEliminarArticulo;
    }

    public void configurarPanel() {
        mostrarPanelEliminarArticulo();
        ControladorPanelAgregarArticulo.obtenerControladorPanelAgregaArticulo().ocultarPanelAgregarArticulo();
        ControladorPanelActualizarArticulo.obtenerControladorPanelActualizarArticulo().ocultarPanelActualizarArticulo();
        ControladorPanelBuscarArticulo.obtenerControladorPanelBuscarArticulo().ocultarPanelBuscarArticulo();
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaInventario.obtenerContenedorVentanaInventario());
        VentanaInventario.obtenerContenedorVentanaInventario().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(panelEliminarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(282, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(342, Short.MAX_VALUE)
                        .addComponent(panelEliminarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
        );
    }

    public void agregarEventoBotonEliminar() {
        JButton botonEliminar = panelEliminarArticulo.getBotonEliminar();

        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonEliminarArticulo();
            }
        });
        panelEliminarArticulo.setBotonEliminar(botonEliminar);
    }

    private void accionarBotonEliminarArticulo() {
        AdministradorInventario adminInventario = new AdministradorInventario();
        String claveArticulo = panelEliminarArticulo.getCampoTextoClave().getText();
        ControladorPanelVerInventario controladorPanelInventario = ControladorPanelVerInventario.obtenerControladorPanelInventario();
        try {
            adminInventario.eliminar(claveArticulo);
            controladorPanelInventario.actualizarTablaArticulos();
            JOptionPane.showMessageDialog(null, "Artículo eliminado exitosamente");
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar al artículo");
            Logger.getLogger(ControladorVentanaInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    public void agregarEventoBotonCancelarEliminacion() {
        JButton botonCancelarEliminacion = panelEliminarArticulo.getBotonCancelar();

        botonCancelarEliminacion.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonCancelarEliminacion();
            }
        });
        panelEliminarArticulo.setBotonCancelar(botonCancelarEliminacion);
    }
    
    private void accionarBotonCancelarEliminacion(){
        panelEliminarArticulo.setVisible(false);
        panelEliminarArticulo.vaciarCamposPanelEliminarArticulo();
    }
    
    public void mostrarPanelEliminarArticulo(){
        panelEliminarArticulo.setVisible(true);
    }
    
    public void ocultarPanelEliminarArticulo(){
        panelEliminarArticulo.setVisible(false);
        panelEliminarArticulo.vaciarCamposPanelEliminarArticulo();
    }
    
    

}
