/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Empleados;

import Administradores.AdministradorEmpleados;
import Modelo.Empleado;
import Ventanas.Empleados.PanelActualizarEmpleado;
import Ventanas.Empleados.VentanaEmpleados;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class ControladorPanelActualizarEmpleado {

    private static PanelActualizarEmpleado panelActualizarEmpleado = null;
    private static ControladorPanelActualizarEmpleado controladorPanelActualizarEmpleado = null;

    private ControladorPanelActualizarEmpleado() {

    }

    public static ControladorPanelActualizarEmpleado obtenerControladorPanelActualizarEmpleado() {
        if (controladorPanelActualizarEmpleado == null) {
            controladorPanelActualizarEmpleado = new ControladorPanelActualizarEmpleado();
            panelActualizarEmpleado = new PanelActualizarEmpleado();
        }
        return controladorPanelActualizarEmpleado;
    }

    public void configurarPanelActualizarEmpleado() {
        mostrarPanelActualizarProveedor();
        ControladorPanelAgregarEmpleado.obtenerControladorPanelAgregarEmpleado().ocultarPanelAgregarEmpleado();
        ControladorPanelBuscarEmpleado.obtenerControladorPanelBuscarEmpleado().ocultarPanelBuscarEmpleado();
        ControladorPanelEliminarEmpleado.obtenerControladorPanelEliminarEmpleado().ocultarPanelEliminarEmpleado();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaEmpleados.obtenerContenedorVentanaEmpleados());
        VentanaEmpleados.obtenerContenedorVentanaEmpleados().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap(456, Short.MAX_VALUE)
                        .addComponent(panelActualizarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelActualizarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 202, Short.MAX_VALUE))
        );
    }

    public void agregarEventoBotonActualizar() {
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
        ControladorPanelVerEmpleados controladorPanelEmpleados = ControladorPanelVerEmpleados.obtenerControladorPanelVerEmpleados();

        controladorPanelEmpleados.actualizarTablaEmpleados();
    }

    public void agregarEventoBotonCancelarActualizacion() {
        JButton botonCancelar = panelActualizarEmpleado.getBotonCancelar();
        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonCancelarActualizacion();
            }
        });
        panelActualizarEmpleado.setBotonCancelar(botonCancelar);
    }

    private void accionarBotonCancelarActualizacion() {
        panelActualizarEmpleado.setVisible(false);
        panelActualizarEmpleado.vaciarCamposActualizarEmpleado();
    }

    private void mostrarPanelActualizarProveedor() {
        panelActualizarEmpleado.setVisible(true);
    }

    public void ocultarPanelActualizarEmpleado() {
        panelActualizarEmpleado.setVisible(false);
        panelActualizarEmpleado.vaciarCamposActualizarEmpleado();
    }
}
