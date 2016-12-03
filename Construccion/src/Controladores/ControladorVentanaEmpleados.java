/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Administradores.AdministradorEmpleados;
import Modelo.Empleado;
import Ventanas.Empleados.*;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 *
 * @author rodrigopeniche
 */
public class ControladorVentanaEmpleados {
    
    private VentanaEmpleados ventanaEmpleados;
    private PanelVerEmpleados panelVerEmpleados;
    private PanelAgregarEmpleado panelAgregarEmpleado;
    private PanelBuscarEmpleado panelBuscarEmpleado;
    private PanelActualizarEmpleado panelActualizarEmpleado;
    private PanelEliminarEmpleado panelEliminarEmpleado;
    
   private ArrayList<Empleado> empleados;
   
   public ControladorVentanaEmpleados(){
       ventanaEmpleados = new VentanaEmpleados();
       inicializarVentana();
       
   }
   
    void desplegarPanelVerEmpleados() {
        panelVerEmpleados = ventanaEmpleados.getPanelVerEmpleados();
        ventanaEmpleados.mostrarPanelVerEmpleados();
        obtenerEmpleadosBD();
        llenarTablaEmpleados(empleados);
    }
    
     void desplegarPanelAgregarEmpleado() {
        panelAgregarEmpleado = ventanaEmpleados.getPanelAgregarEmpleado();
        ventanaEmpleados.mostrarPanelAgregarEmpleado();
        agregarEventoBotonAgregarEmpleado();
        agregarEventoBotonCancelarAgregacion();

    }
   
    private void obtenerEmpleadosBD() {
       AdministradorEmpleados admin = new AdministradorEmpleados();
       empleados = admin.obtenerDatos();
    }

    private void llenarTablaEmpleados(ArrayList<Empleado> empleados) {
        for (int numEmpleado = 0; numEmpleado < empleados.size(); numEmpleado++) {
            panelVerEmpleados.getContenidoTablaEmpleados().addRow(new Object[]{empleados.get(numEmpleado).getClave(),
                empleados.get(numEmpleado).getNombre(),
                empleados.get(numEmpleado).getTelefono(),
                empleados.get(numEmpleado).getDireccion(),});
        }
    }
    
    private void actualizarTablaEmpleados(){
        borrarContenidoTablaEmpleados();
        obtenerEmpleadosBD();
        llenarTablaEmpleados(empleados);
    }
    
    private void borrarContenidoTablaEmpleados(){
        panelVerEmpleados.getContenidoTablaEmpleados().setRowCount(0);
    }
    
    void agregarEventoBotonBuscarEmpleado() {
        panelVerEmpleados = ventanaEmpleados.getPanelVerEmpleados();
        JButton botonBuscar = panelVerEmpleados.getBotonBuscar();

        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ventanaEmpleados.mostrarPanelBuscarEmpleado();
                agregarEventoBotonBuscar();
                agregarEventoBotonCancelarBusqueda();
            }
        });
        panelVerEmpleados.setBotonBuscar(botonBuscar);
    }
    
     void agregarEventoBotonEliminarEmpleado() {
        panelVerEmpleados = ventanaEmpleados.getPanelVerEmpleados();
        JButton botonEliminar = panelVerEmpleados.getBotonEliminar();

        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ventanaEmpleados.mostrarPanelEliminarEmpleado();
                agregarEventoBotonEliminar();
                agregarEventoBotonCancelarEliminacion();
            }
        });
        panelVerEmpleados.setBotonEliminar(botonEliminar);
    }
     
    void agregarEventoBotonActualizarEmpleado() {
        panelVerEmpleados = ventanaEmpleados.getPanelVerEmpleados();
        JButton botonActualizar = panelVerEmpleados.getBotonActualizar();

        botonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ventanaEmpleados.mostrarPanelActualizarEmpleado();
                agregarEventoBotonActualizar();
                agregarEventoBotonCancelarActualizacion();
            }
        });
        panelVerEmpleados.setBotonActualizar(botonActualizar);
    }
    
    private void agregarEventoBotonEliminar() {
        panelEliminarEmpleado = ventanaEmpleados.getPanelEliminarEmpleados();
        JButton botonEliminar = panelEliminarEmpleado.getBotonEliminar();

        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonEliminarEmpleado();
            }
        });
        panelEliminarEmpleado.setBotonEliminar(botonEliminar);
    }
    
    private void accionarBotonEliminarEmpleado() {
        AdministradorEmpleados adminEmpleados = new AdministradorEmpleados();
        String claveEmpleado = panelEliminarEmpleado.getCampoTextoClave().getText();

        adminEmpleados.eliminar(claveEmpleado);
        actualizarTablaEmpleados();
        JOptionPane.showMessageDialog(null, "Empleado eliminado exitosamente");
    }
    
    private void agregarEventoBotonCancelarEliminacion() {
        panelEliminarEmpleado = ventanaEmpleados.getPanelEliminarEmpleados();
        JButton botonCancelarEliminacion = panelEliminarEmpleado.getBotonCancelar();

        botonCancelarEliminacion.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelEliminarEmpleado.setVisible(false);
            }
        });
        panelEliminarEmpleado.setBotonCancelar(botonCancelarEliminacion);
    }
    
    

    private void agregarEventoBotonAgregarEmpleado() {
        panelAgregarEmpleado = ventanaEmpleados.getPanelAgregarEmpleado();
        JButton botonAgregar = panelAgregarEmpleado.getBotonAgregar();
        
        botonAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonAgregarEmpleado();
            }
        });
    }
    
    private void accionarBotonAgregarEmpleado() {
        String claveEmpleado = panelAgregarEmpleado.getCampoTextoClave().getText();
        String nombre = panelAgregarEmpleado.getCampoTextoNombre().getText();
        String telefono = panelAgregarEmpleado.getCampoTextoTel().getText();
        String direccion = panelAgregarEmpleado.getCampoTextoDireccion().getText();

        AdministradorEmpleados adminEmpleados = new AdministradorEmpleados();

        Empleado empleado = new Empleado(claveEmpleado, nombre, telefono, direccion);

        try {
            adminEmpleados.agregar(empleado);
            JOptionPane.showMessageDialog(null, "El empleado se ha agregado exitosamente");
            vaciarCamposAgregarEmpleado();
        } catch (HeadlessException createException) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar el empleado");
        }
    }
    
    

    private void agregarEventoBotonCancelarAgregacion() {
        panelAgregarEmpleado = ventanaEmpleados.getPanelAgregarEmpleado();
        JButton botonCancelar = panelAgregarEmpleado.getBotonCancelar();

        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAgregarEmpleado.setVisible(false);
            }
        });
        panelAgregarEmpleado.setBotonCancelar(botonCancelar);
    }
    
    private void agregarEventoBotonBuscar() {
        panelBuscarEmpleado = ventanaEmpleados.getPanelBuscarEmpleado();
        JButton botonBuscar = panelBuscarEmpleado.getBotonBuscar();

        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonBuscarProveedor();
            }
        });
        panelBuscarEmpleado.setBotonBuscar(botonBuscar);
    }
    
    private void accionarBotonBuscarProveedor() {
        panelBuscarEmpleado.mostrarCampoTextoNombre();
        panelBuscarEmpleado.mostrarCampoTextoTel();
        panelBuscarEmpleado.mostrarCampoTextoDireccion();
        panelBuscarEmpleado.mostrarEtiquetaNombre();
        panelBuscarEmpleado.mostrarEtiquetaTel();
        panelBuscarEmpleado.mostrarEtiquetaDireccion();

        String claveEmpleado = panelBuscarEmpleado.getCampoTextoClave().getText();
        AdministradorEmpleados adminEmpleados = new AdministradorEmpleados();
        Empleado empleado = (Empleado) adminEmpleados.buscar(claveEmpleado);

        panelBuscarEmpleado.setCampoTextoNombre(empleado.getNombre());
        panelBuscarEmpleado.setCampoTextoTel(empleado.getTelefono());
        panelBuscarEmpleado.setCampoTextoDireccion(empleado.getDireccion());
    }
    
    private void agregarEventoBotonCancelarBusqueda() {
        panelBuscarEmpleado = ventanaEmpleados.getPanelBuscarEmpleado();
        JButton botonCancelar = panelBuscarEmpleado.getBotonCancelar();

        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBuscarEmpleado.setVisible(false);
            }
        });
        panelBuscarEmpleado.setBotonCancelar(botonCancelar);
    }
    
    private void agregarEventoBotonActualizar() {
        panelActualizarEmpleado = ventanaEmpleados.getPanelActualizarEmpleado();
        JButton botonActualizar = panelActualizarEmpleado.getBotonGuardarCambios();
        botonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonActualizarEmpleado();
            }
        });
        panelActualizarEmpleado.setBotonGuardarCambios(botonActualizar);
    }
    
    private void accionarBotonActualizarEmpleado() {

        String claveEmpleado = panelActualizarEmpleado.getCampoTextoClave().getText();
        String nuevoNombre = panelActualizarEmpleado.getCampoTextoNombre().getText();
        String nuevoTel = panelActualizarEmpleado.getCampoTextoTel().getText();
        String nuevaDireccion = panelActualizarEmpleado.getCampoTextoDireccion().getText();

        Empleado empleado;
        empleado = new Empleado(claveEmpleado, nuevoNombre, nuevoTel, nuevaDireccion);

        AdministradorEmpleados adminEmpleados = new AdministradorEmpleados();

        try {
            adminEmpleados.actualizar(empleado);
            JOptionPane.showMessageDialog(null, "El empleado ha sido actualizado exitosamente");
        } catch (HeadlessException updateException) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el empleado");
        }

        actualizarTablaEmpleados();
    }
    
    private void agregarEventoBotonCancelarActualizacion() {
        panelActualizarEmpleado = ventanaEmpleados.getPanelActualizarEmpleado();
        JButton botonCancelar = panelActualizarEmpleado.getBotonCancelar();
        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelActualizarEmpleado.setVisible(false);
            }
        });
        panelActualizarEmpleado.setBotonCancelar(botonCancelar);
    }
    
    private void vaciarCamposAgregarEmpleado() {
        panelAgregarEmpleado.getCampoTextoClave().setText(null);
        panelAgregarEmpleado.getCampoTextoNombre().setText(null);
        panelAgregarEmpleado.getCampoTextoTel().setText(null);
        panelAgregarEmpleado.getCampoTextoDireccion().setText(null);
    }

    public VentanaEmpleados getVentanaEmpleados() {
        return ventanaEmpleados;
    }
   
    
     private void inicializarVentana() {
       this.ventanaEmpleados = new VentanaEmpleados();
       this.ventanaEmpleados.setVisible(true);
    }
    
}
