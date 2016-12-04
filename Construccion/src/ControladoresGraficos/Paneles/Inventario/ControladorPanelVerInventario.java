/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Inventario;

import Administradores.AdministradorInventario;
import Modelo.Articulo;
import Ventanas.Inventario.PanelVerInventario;
import Ventanas.Inventario.VentanaInventario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author juan
 */
public class ControladorPanelVerInventario {

    private static ControladorPanelVerInventario controladorPanelInventario = null;
    private static PanelVerInventario panelVerInventario;
    private ArrayList<Articulo> articulos;

    private ControladorPanelVerInventario() {
        this.articulos = new ArrayList<Articulo>();
    }

    public static ControladorPanelVerInventario obtenerControladorPanelInventario() {
        if (controladorPanelInventario == null) {
            controladorPanelInventario = new ControladorPanelVerInventario();
            panelVerInventario = new PanelVerInventario();
        }
        return controladorPanelInventario;
    }

    public void configurarPanelInventario() {
        mostrarPanelInventario();
        ControladorPanelAgregarArticulo.obtenerControladorPanelAgregaArticulo().ocultarPanelAgregarArticulo();
        ControladorPanelActualizarArticulo.obtenerControladorPanelActualizarArticulo().ocultarPanelActualizarArticulo();
        ControladorPanelBuscarArticulo.obtenerControladorPanelBuscarArticulo().ocultarPanelBuscarArticulo();
        ControladorPanelEliminarArticulo.obtenerControladorPanelEliminarArticulo().ocultarPanelEliminarArticulo();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaInventario.obtenerContenedorVentanaInventario());
        VentanaInventario.obtenerContenedorVentanaInventario().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelVerInventario, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(280, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelVerInventario, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(237, Short.MAX_VALUE))
        );

    }

    public void desplegarPanelVerInventario() throws SQLException {
        configurarPanelInventario();
        try {
            obtenerArticulosBD();
            llenarTablaArticulos(articulos);
        } catch (ClassNotFoundException ex) {
       
        }
    }

    private void obtenerArticulosBD() {
        AdministradorInventario admin = new AdministradorInventario();
        articulos = admin.obtenerDatos();
    }

    private void llenarTablaArticulos(ArrayList<Articulo> articulos) throws SQLException, ClassNotFoundException {
        borrarContenidoTablaArticulos();
        for (int numArticulo = 0; numArticulo < articulos.size(); numArticulo++) {
            panelVerInventario.getContenidoTablaArticulos().addRow(new Object[]{articulos.get(numArticulo).getClaveArticulo(),
                articulos.get(numArticulo).getClaveProveedor(),
                articulos.get(numArticulo).getDescripcion(),
                articulos.get(numArticulo).getDetalleArticulo().getCantidad(),
                articulos.get(numArticulo).getDetalleArticulo().getPrecioCompra().getPrecio(),
                articulos.get(numArticulo).getDetalleArticulo().getPrecioVenta().getPrecio()
            });
        }
    }

    public void agregarEventoBotonBuscarArticulo() {
        JButton botonBuscar = panelVerInventario.getBotonBuscarArticulo();
        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ControladorPanelBuscarArticulo controladorPanelBuscarArticulo = new ControladorPanelBuscarArticulo();
                controladorPanelBuscarArticulo.configurarPanelBuscarArticulo();
                controladorPanelBuscarArticulo.agregarEventoBotonBuscar();
                controladorPanelBuscarArticulo.agregarEventoBotonCancelarBusqueda();
            }
        });
        controladorPanelInventario.getPanelVerInventario().setBotonBuscarArticulo(botonBuscar);
    }

    public void agregarEventoBotonEliminarArticulo() {

        JButton botonEliminar = panelVerInventario.getBotonEliminarArticulo();
        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ControladorPanelEliminarArticulo controaldorPanelEliminarArticulo = ControladorPanelEliminarArticulo.obtenerControladorPanelEliminarArticulo();
                controaldorPanelEliminarArticulo.configurarPanel();
                controaldorPanelEliminarArticulo.agregarEventoBotonEliminar();
                controaldorPanelEliminarArticulo.agregarEventoBotonCancelarEliminacion();
            }
        });
        panelVerInventario.setBotonEliminarArticulo(botonEliminar);
    }

    public void agregarEventoBotonActualizarArticulo() {
        JButton botonActualizar = panelVerInventario.getBotonActualizarArticulo();
        panelVerInventario.getBotonActualizarArticulo().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ControladorPanelActualizarArticulo controladorPanelActualizarArticulo = ControladorPanelActualizarArticulo.obtenerControladorPanelActualizarArticulo();
                controladorPanelActualizarArticulo.configurarPanelActualizarArticulo();
                controladorPanelActualizarArticulo.agregarEventoBotonActualizar();
                controladorPanelActualizarArticulo.agregarEventoBotonCancelarActualizacion();
            }
        });
        panelVerInventario.setBotonActualizarArticulo(botonActualizar);
    }

    public void actualizarTablaArticulos() throws SQLException, ClassNotFoundException {
        obtenerArticulosBD();
        llenarTablaArticulos(articulos);
    }

    private void borrarContenidoTablaArticulos() {
        panelVerInventario.getContenidoTablaArticulos().setRowCount(0);
    }

    public PanelVerInventario getPanelVerInventario() {
        return panelVerInventario;
    }

    public void mostrarPanelInventario() {
        panelVerInventario.setVisible(true);
    }

    public void ocultarPanelInventario() {
        panelVerInventario.setVisible(false);
    }

}
