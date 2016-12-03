/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Proveedores;

import Administradores.AdministradorProveedores;
import ControladoresGraficos.Ventanas.ControladorVentanaInventario;
import Modelo.Proveedor;
import Ventanas.Proveedores.PanelVerProveedores;
import Ventanas.Proveedores.VentanaProveedores;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author juan
 */
public class ControladorPanelVerProveedores {

    private static PanelVerProveedores panelVerProveedores;
    private static ControladorPanelVerProveedores controladorPanelVerProveedores;
    private ArrayList<Proveedor> proveedores;

    private ControladorPanelVerProveedores() {
        this.proveedores = new ArrayList<Proveedor>();
    }

    public static ControladorPanelVerProveedores obtenerControladorPanelVerProveedores() {
        if (controladorPanelVerProveedores == null) {
            controladorPanelVerProveedores = new ControladorPanelVerProveedores();
            panelVerProveedores = new PanelVerProveedores();
        }
        return controladorPanelVerProveedores;
    }

    public void configurarPanelVerProveedores() {
        mostrarPanelVerProveedores();
        ControladorPanelAgregarProveedor.obtenerControladorPanelAgregarProveedor().ocultarPanelAgregarProveedor();
        ControladorPanelActualizarProveedor.obtenerControladorPanelActualizarProveedor().ocultarPanelActualizarProveedor();
        ControladorPanelBuscarProveedor.obtenerControladorPanelBuscarProveedor().ocultarPanelBuscarProveedor();
        ControladorPanelEliminarProveedor.obtenerControladorPanelEliminarProveedor().ocultarPanelEliminarProveedor();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaProveedores.obtenerContenedorVentanaProveedores());
        VentanaProveedores.obtenerContenedorVentanaProveedores().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelVerProveedores, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(280, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelVerProveedores, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(237, Short.MAX_VALUE))
        );

    }

    public void desplegarPanelVerProveedores() throws SQLException {
        configurarPanelVerProveedores();
        try {
            obtenerProveedoresBD();
            llenarTablaProveedores(proveedores);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorVentanaInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void obtenerProveedoresBD() {
        AdministradorProveedores admin = new AdministradorProveedores();
        proveedores = admin.obtenerDatos();
    }

    private void llenarTablaProveedores(ArrayList<Proveedor> proveedores) throws SQLException, ClassNotFoundException {
        borrarContenidoTablaProveedores();
        for (int numProveedor = 0; numProveedor < proveedores.size(); numProveedor++) {
            panelVerProveedores.getContenidoTablaProveedores().addRow(new Object[]{proveedores.get(numProveedor).getClave(),
                proveedores.get(numProveedor).getNombre(),
                proveedores.get(numProveedor).getTelefono(),
                proveedores.get(numProveedor).getDireccion(),});
        }
    }

    public void actualizarTablaProveedores() throws SQLException, ClassNotFoundException {
        borrarContenidoTablaProveedores();
        obtenerProveedoresBD();
        llenarTablaProveedores(proveedores);
    }

    private void borrarContenidoTablaProveedores() {
        panelVerProveedores.getContenidoTablaProveedores().setRowCount(0);
    }

    public void agregarEventoBotonActualizarProveedor() {
        JButton botonActualizar = panelVerProveedores.getBotonActualizar();

        botonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ControladorPanelActualizarProveedor controladorPanelActualizarProveedor = ControladorPanelActualizarProveedor.obtenerControladorPanelActualizarProveedor();
                controladorPanelActualizarProveedor.configurarPanelActualizarProveedor();
                controladorPanelActualizarProveedor.agregarEventoBotonActualizar();
                controladorPanelActualizarProveedor.agregarEventoBotonCancelarActualizacion();
            }
        });
        panelVerProveedores.setBotonActualizar(botonActualizar);
    }

    public void agregarEventoBotonEliminarProveedor() {
        JButton botonEliminar = panelVerProveedores.getBotonEliminar();

        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ControladorPanelEliminarProveedor controladorPanelEliminarProveedor = ControladorPanelEliminarProveedor.obtenerControladorPanelEliminarProveedor();
                controladorPanelEliminarProveedor.configurarPanelEliminarProveedor();
                controladorPanelEliminarProveedor.agregarEventoBotonEliminar();
                controladorPanelEliminarProveedor.agregarEventoBotonCancelarEliminacion();
            }
        });
        panelVerProveedores.setBotonEliminar(botonEliminar);
    }

    public void agregarEventoBotonBuscarProveedor() {
        JButton botonBuscar = panelVerProveedores.getBotonBuscar();

        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ControladorPanelBuscarProveedor controladorPanelBuscarProveedor = ControladorPanelBuscarProveedor.obtenerControladorPanelBuscarProveedor();
                controladorPanelBuscarProveedor.configurarPanelBuscarProveedor();
                controladorPanelBuscarProveedor.agregarEventoBotonBuscar();
                controladorPanelBuscarProveedor.agregarEventoBotonCancelarBusqueda();
            }
        });
        panelVerProveedores.setBotonBuscar(botonBuscar);
    }
    
    private void mostrarPanelVerProveedores(){
        panelVerProveedores.setVisible(true);
    }
    
    public void ocultarPanelVerProveedores() {
        panelVerProveedores.setVisible(false);
    }
}
