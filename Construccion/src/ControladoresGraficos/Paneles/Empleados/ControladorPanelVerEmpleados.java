/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Empleados;

import Administradores.AdministradorEmpleados;
import Modelo.Empleado;
import Ventanas.Empleados.PanelVerEmpleados;
import Ventanas.Empleados.VentanaEmpleados;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author juan
 */
public class ControladorPanelVerEmpleados {

    private static ControladorPanelVerEmpleados controladorPanelVerEmpleados = null;
    private static PanelVerEmpleados panelVerEmpleados = null;
    private ArrayList<Empleado> empleados;

    private ControladorPanelVerEmpleados() {

    }

    public static ControladorPanelVerEmpleados obtenerControladorPanelVerEmpleados() {
        if (controladorPanelVerEmpleados == null) {
            controladorPanelVerEmpleados = new ControladorPanelVerEmpleados();
            panelVerEmpleados = new PanelVerEmpleados();
        }
        return controladorPanelVerEmpleados;
    }

    public void mostrarPanelVerEmpleados() {
        configurarPanelVerEmpleados();
        panelVerEmpleados.setVisible(true);
        ocultarOtrosPaneles();
    }

    private void ocultarOtrosPaneles() {
        ControladorPanelAgregarEmpleado.obtenerControladorPanelAgregarEmpleado().ocultarPanelAgregarEmpleado();
        ControladorPanelActualizarEmpleado.obtenerControladorPanelActualizarEmpleado().ocultarPanelActualizarEmpleado();
        ControladorPanelBuscarEmpleado.obtenerControladorPanelBuscarEmpleado().ocultarPanelBuscarEmpleado();
        ControladorPanelEliminarEmpleado.obtenerControladorPanelEliminarEmpleado().ocultarPanelEliminarEmpleado();

    }

    public void desplegarPanelVerEmpleados() {
        mostrarPanelVerEmpleados();
        obtenerEmpleadosBD();
        llenarTablaEmpleados(empleados);
    }

    private void obtenerEmpleadosBD() {
        AdministradorEmpleados admin = new AdministradorEmpleados();
        empleados = admin.obtenerDatos();
    }

    private void llenarTablaEmpleados(ArrayList<Empleado> empleados) {
        borrarContenidoTablaEmpleados();
        for (int numEmpleado = 0; numEmpleado < empleados.size(); numEmpleado++) {
            panelVerEmpleados.getContenidoTablaEmpleados().addRow(new Object[]{empleados.get(numEmpleado).getClave(),
                empleados.get(numEmpleado).getNombre(),
                empleados.get(numEmpleado).getTelefono(),
                empleados.get(numEmpleado).getDireccion(),});
        }
    }

    public void agregarEventoBotonBuscarEmpleado() {
        JButton botonBuscar = panelVerEmpleados.getBotonBuscar();

        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ControladorPanelBuscarEmpleado controladorPanelBuscarEmpleado = ControladorPanelBuscarEmpleado.obtenerControladorPanelBuscarEmpleado();
                controladorPanelBuscarEmpleado.mostrarPanelBuscarEmpleado();
                controladorPanelBuscarEmpleado.agregarEventoBotonBuscar();
                controladorPanelBuscarEmpleado.agregarEventoBotonCancelarBusqueda();
            }
        });
        panelVerEmpleados.setBotonBuscar(botonBuscar);
    }

    public void agregarEventoBotonEliminarEmpleado() {
        JButton botonEliminar = panelVerEmpleados.getBotonEliminar();

        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ControladorPanelEliminarEmpleado controladorPanelEliminarEmpleado = ControladorPanelEliminarEmpleado.obtenerControladorPanelEliminarEmpleado();
                controladorPanelEliminarEmpleado.mostrarPanelEliminarEmpleado();
                controladorPanelEliminarEmpleado.agregarEventoBotonEliminar();
                controladorPanelEliminarEmpleado.agregarEventoBotonCancelarEliminacion();
            }
        });
        panelVerEmpleados.setBotonEliminar(botonEliminar);
    }

    public void agregarEventoBotonActualizarEmpleado() {
        JButton botonActualizar = panelVerEmpleados.getBotonActualizar();

        botonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ControladorPanelActualizarEmpleado controladorPanelActualizarEmpleado = ControladorPanelActualizarEmpleado.obtenerControladorPanelActualizarEmpleado();
                controladorPanelActualizarEmpleado.mostrarPanelActualizarEmpleado();
                controladorPanelActualizarEmpleado.agregarEventoBotonActualizar();
                controladorPanelActualizarEmpleado.agregarEventoBotonCancelarActualizacion();
            }
        });
        panelVerEmpleados.setBotonActualizar(botonActualizar);
    }

    public void actualizarTablaEmpleados() {
        borrarContenidoTablaEmpleados();
        obtenerEmpleadosBD();
        llenarTablaEmpleados(empleados);
    }

    private void borrarContenidoTablaEmpleados() {
        panelVerEmpleados.getContenidoTablaEmpleados().setRowCount(0);
    }

    private void configurarPanelVerEmpleados() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaEmpleados.obtenerContenedorVentanaEmpleados());
        VentanaEmpleados.obtenerContenedorVentanaEmpleados().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelVerEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(280, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelVerEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(237, Short.MAX_VALUE))
        );
    }

    public void ocultarPanelVerEmpleados() {
        panelVerEmpleados.setVisible(false);
    }

}
