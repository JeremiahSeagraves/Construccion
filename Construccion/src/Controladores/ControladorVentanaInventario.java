/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Administradores.AdministradorInventario;
import Modelo.Articulo;
import Modelo.DetalleArticulo;
import Modelo.Precio;
import Ventanas.Inventario.*;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author rodrigopeniche
 */
public class ControladorVentanaInventario {

    private VentanaInventario ventanaInventario;
    private PanelVerInventario panelVerInventario;
    private PanelAgregarArticulo panelAgregarArticulo;
    private PanelBuscarArticulo panelBuscarArticulo;
    private PanelEliminarArticulo panelEliminarArticulo;
    private PanelActualizarArticulo panelActualizarArticulo;
    
    private ArrayList<Articulo> articulos;

    public ControladorVentanaInventario() {
        ventanaInventario = new VentanaInventario();
        inicializarVentana();
    }

    void desplegarPanelVerInventario() throws SQLException {
        panelVerInventario = ventanaInventario.getPanelVerInventario();
        ventanaInventario.mostrarPanelVerInventario();

        try {
            obtenerArticulosBD();
            llenarTablaArticulos(articulos);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorVentanaInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void desplegarPanelAgregarArticulo() {
        panelAgregarArticulo = ventanaInventario.getPanelAgregarArticulo();
        ventanaInventario.mostrarPanelAgregarArticulo();
        agregarEventoBotonAgregarArticulo();
        agregarEventoBotonCancelarAgregacion();

    }
    
    private void obtenerArticulosBD(){
        AdministradorInventario admin = new AdministradorInventario();
        articulos = admin.obtenerDatos();
    }

    private void llenarTablaArticulos(ArrayList<Articulo> articulos) throws SQLException, ClassNotFoundException {       
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

    private void actualizarTablaArticulos() throws SQLException, ClassNotFoundException {
        borrarContenidoTablaArticulos();
        obtenerArticulosBD();
        llenarTablaArticulos(articulos);
    }
    
    private void borrarContenidoTablaArticulos(){
        panelVerInventario.getContenidoTablaArticulos().setRowCount(0);
    }

    void agregarEventoBotonBuscarArticulo() {
        panelVerInventario = ventanaInventario.getPanelVerInventario();
        JButton botonBuscar = panelVerInventario.getBotonBuscarArticulo();

        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ventanaInventario.mostrarPanelBuscarArticulo();
                agregarEventoBotonBuscar();
                agregarEventoBotonCancelarBusqueda();
            }
        });
        panelVerInventario.setBotonBuscarArticulo(botonBuscar);
    }

    void agregarEventoBotonEliminarArticulo() {
        panelVerInventario = ventanaInventario.getPanelVerInventario();
        JButton botonEliminar = ventanaInventario.getPanelVerInventario().getBotonEliminarArticulo();

        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ventanaInventario.mostrarPanelEliminarArticulo();
                agregarEventoBotonEliminar();
                agregarEventoBotonCancelarEliminacion();
            }
        });
        panelVerInventario.setBotonEliminarArticulo(botonEliminar);
    }

    void agregarEventoBotonActualizarArticulo() {
        panelVerInventario = ventanaInventario.getPanelVerInventario();
        JButton botonActualizar = panelVerInventario.getBotonActualizarArticulo();

        panelVerInventario.getBotonActualizarArticulo().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ventanaInventario.mostrarPanelActualizarArticulo();
                agregarEventoBotonActualizar();
                agregarEventoBotonCancelarActualizacion();
            }
        });
        panelVerInventario.setBotonActualizarArticulo(botonActualizar);
    }

    private void agregarEventoBotonEliminar() {
        panelEliminarArticulo = ventanaInventario.getPanelEliminarArticulo();
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

        try {
            adminInventario.eliminar(claveArticulo);
            actualizarTablaArticulos();
            JOptionPane.showMessageDialog(null, "Artículo eliminado exitosamente");
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar al artículo");
            Logger.getLogger(ControladorVentanaInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarEventoBotonCancelarEliminacion() {
        panelEliminarArticulo = ventanaInventario.getPanelEliminarArticulo();
        JButton botonCancelarEliminacion = panelEliminarArticulo.getBotonCancelar();

        botonCancelarEliminacion.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelEliminarArticulo.setVisible(false);
            }
        });
        panelEliminarArticulo.setBotonCancelar(botonCancelarEliminacion);
    }

    private void agregarEventoBotonAgregarArticulo() {
        panelAgregarArticulo = ventanaInventario.getPanelAgregarArticulo();
        JButton botonAgregar = panelAgregarArticulo.getBotonAgregarArticulo();
        botonAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonAgregarArticulo();
            }
        });
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
            vaciarCamposAgregarArticulo();
        } catch (HeadlessException createException) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar el artículo");
        }
    }

    private void agregarEventoBotonCancelarAgregacion() {
        panelAgregarArticulo = ventanaInventario.getPanelAgregarArticulo();
        JButton botonCancelar = panelAgregarArticulo.getBotonCancelar();

        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAgregarArticulo.setVisible(false);
            }
        });
        panelAgregarArticulo.setBotonCancelar(botonCancelar);
    }

    private void agregarEventoBotonBuscar() {
        panelBuscarArticulo = ventanaInventario.getPanelBuscarArticulo();
        JButton botonBuscar = ventanaInventario.getPanelBuscarArticulo().getBotonBuscar();

        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonBuscarArticulo();
            }
        });
        panelBuscarArticulo.setBotonBuscar(botonBuscar);
    }

    private void accionarBotonBuscarArticulo() {
        panelBuscarArticulo.mostrarCampoTextoCantidad();
        panelBuscarArticulo.mostrarEtiquetaDescripcion();
        panelBuscarArticulo.mostrarCampoTextoCantidad();
        panelBuscarArticulo.mostrarEtiquetaCantidad();
        panelBuscarArticulo.mostrarCampoTextoPrecioCompra();
        panelBuscarArticulo.mostrarEtiquetaPrecioCompra();
        panelBuscarArticulo.mostrarCampoTextoPrecioVenta();
        panelBuscarArticulo.mostrarEtiquetaPrecioVenta();

        String claveArticulo = panelBuscarArticulo.getCampoTextoClave().getText();
        AdministradorInventario admin = new AdministradorInventario();
        Articulo articulo = admin.buscar(claveArticulo);

        panelBuscarArticulo.setCampoTextoDescripcion(articulo.getDescripcion());
        panelBuscarArticulo.setCampoTextoCantidad(String.valueOf(articulo.getDetalleArticulo().getCantidad()));
        panelBuscarArticulo.setCampoTextoPrecioCompra(String.valueOf(articulo.getDetalleArticulo().getPrecioCompra().getPrecio()));
        panelBuscarArticulo.setCampoTextoPrecioVenta(String.valueOf(articulo.getDetalleArticulo().getPrecioVenta().getPrecio()));
    }

    void agregarEventoBotonCancelarBusqueda() {
        panelBuscarArticulo = ventanaInventario.getPanelBuscarArticulo();
        JButton botonCancelar = panelBuscarArticulo.getBotonCancelar();

        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBuscarArticulo.setVisible(false);
            }
        });
        panelBuscarArticulo.setBotonCancelar(botonCancelar);
    }

    void agregarEventoBotonActualizar() {
        panelActualizarArticulo = ventanaInventario.getPanelActualizarArticulo();
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

        try {
            actualizarTablaArticulos();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PanelActualizarArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void agregarEventoBotonCancelarActualizacion() {
        panelActualizarArticulo = ventanaInventario.getPanelActualizarArticulo();
        JButton botonCancelar = panelActualizarArticulo.getBotonCancelar();
        panelActualizarArticulo.getBotonCancelar().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelActualizarArticulo.setVisible(false);
            }
        });
        panelActualizarArticulo.setBotonCancelar(botonCancelar);
    }

    private void vaciarCamposAgregarArticulo() {
        panelAgregarArticulo.getCampoTextoClave().setText(null);
        panelAgregarArticulo.getCampoTextoClaveProveedor().setText(null);
        panelAgregarArticulo.getCampoTextoDescripcion().setText(null);
        panelAgregarArticulo.getCampoTextoCantidad().setText(null);
        panelAgregarArticulo.getCampoTextoPrecioCompra().setText(null);
        panelAgregarArticulo.getCampoTextoPrecioVenta().setText(null);
    }

    public VentanaInventario getVentanaInventario() {
        return ventanaInventario;
    }

    private void inicializarVentana() {
        this.ventanaInventario = new VentanaInventario();
        this.ventanaInventario.setVisible(true);
    }
}
