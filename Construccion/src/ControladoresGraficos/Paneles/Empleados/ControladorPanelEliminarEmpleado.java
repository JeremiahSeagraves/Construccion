/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Empleados;

import Administradores.AdministradorEmpleados;
import Ventanas.Empleados.PanelEliminarEmpleado;
import Ventanas.Empleados.VentanaEmpleados;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class ControladorPanelEliminarEmpleado {

    private static ControladorPanelEliminarEmpleado controladorPanelEliminarEmpleado = null;
    private static PanelEliminarEmpleado panelEliminarEmpleado = null;

    private ControladorPanelEliminarEmpleado() {

    }

    public static ControladorPanelEliminarEmpleado obtenerControladorPanelEliminarEmpleado() {
        if (controladorPanelEliminarEmpleado == null) {
            controladorPanelEliminarEmpleado = new ControladorPanelEliminarEmpleado();
            panelEliminarEmpleado = new PanelEliminarEmpleado();
        }
        return controladorPanelEliminarEmpleado;
    }

    public void mostrarPanelEliminarEmpleado() {
        configurarPanelEliminarEmpleado();
        panelEliminarEmpleado.setVisible(true);
        ocultarOtrosPaneles();
    }

    private void ocultarOtrosPaneles() {
        ControladorPanelActualizarEmpleado.obtenerControladorPanelActualizarEmpleado().ocultarPanelActualizarEmpleado();
        ControladorPanelAgregarEmpleado.obtenerControladorPanelAgregarEmpleado().ocultarPanelAgregarEmpleado();
        ControladorPanelBuscarEmpleado.obtenerControladorPanelBuscarEmpleado().ocultarPanelBuscarEmpleado();

    }

    public void agregarEventoBotonEliminar() {
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
        ControladorPanelVerEmpleados controladorPanelEmpleados = ControladorPanelVerEmpleados.obtenerControladorPanelVerEmpleados();
        controladorPanelEmpleados.actualizarTablaEmpleados();

        JOptionPane.showMessageDialog(null, "Empleado eliminado exitosamente");
    }

    public void agregarEventoBotonCancelarEliminacion() {
        JButton botonCancelarEliminacion = panelEliminarEmpleado.getBotonCancelar();

        botonCancelarEliminacion.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonCancelarEliminacion();
            }
        });
        panelEliminarEmpleado.setBotonCancelar(botonCancelarEliminacion);
    }

    private void accionarBotonCancelarEliminacion() {
        panelEliminarEmpleado.setVisible(false);
        panelEliminarEmpleado.vaciarCamposPanelEliminarEmpleado();
    }

    private void configurarPanelEliminarEmpleado() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaEmpleados.obtenerContenedorVentanaEmpleados());
        VentanaEmpleados.obtenerContenedorVentanaEmpleados().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(panelEliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(282, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(342, Short.MAX_VALUE)
                        .addComponent(panelEliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
        );
    }

    public void ocultarPanelEliminarEmpleado() {
        panelEliminarEmpleado.setVisible(false);
        panelEliminarEmpleado.vaciarCamposPanelEliminarEmpleado();
    }

}
