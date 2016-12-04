/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Empleados;

import Administradores.AdministradorEmpleados;
import Modelo.Empleado;
import Ventanas.Empleados.PanelAgregarEmpleado;
import Ventanas.Empleados.VentanaEmpleados;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class ControladorPanelAgregarEmpleado {

    private static PanelAgregarEmpleado panelAgregarEmpleado = null;
    private static ControladorPanelAgregarEmpleado controladorPanelAgregarEmpleado = null;

    private ControladorPanelAgregarEmpleado() {

    }

    public static ControladorPanelAgregarEmpleado obtenerControladorPanelAgregarEmpleado() {
        if (controladorPanelAgregarEmpleado == null) {
            controladorPanelAgregarEmpleado = new ControladorPanelAgregarEmpleado();
            panelAgregarEmpleado = new PanelAgregarEmpleado();
        }
        return controladorPanelAgregarEmpleado;
    }

    public void configurarPanelAgregarEmpleado() {
        mostrarPanelAgregarEmpleado();
        ControladorPanelActualizarEmpleado.obtenerControladorPanelActualizarEmpleado().ocultarPanelActualizarEmpleado();
        ControladorPanelBuscarEmpleado.obtenerControladorPanelBuscarEmpleado().ocultarPanelBuscarEmpleado();
        ControladorPanelEliminarEmpleado.obtenerControladorPanelEliminarEmpleado().ocultarPanelEliminarEmpleado();
        ControladorPanelVerEmpleados.obtenerControladorPanelVerEmpleados().ocultarPanelVerEmpleados();
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaEmpleados.obtenerContenedorVentanaEmpleados());
        VentanaEmpleados.obtenerContenedorVentanaEmpleados().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelAgregarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 492, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelAgregarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 208, Short.MAX_VALUE))
        );
    }

    public void desplegarPanelAgregarEmpleado() {
        configurarPanelAgregarEmpleado();
        agregarEventoBotonAgregarEmpleado();
        agregarEventoBotonCancelarAgregacion();

    }

    private void agregarEventoBotonAgregarEmpleado() {
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
            panelAgregarEmpleado.vaciarCamposAgregarEmpleado();
        } catch (HeadlessException createException) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar el empleado");
        }
    }

    private void agregarEventoBotonCancelarAgregacion() {
        JButton botonCancelar = panelAgregarEmpleado.getBotonCancelar();

        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonCancelarAgregacion();
            }
        });
        panelAgregarEmpleado.setBotonCancelar(botonCancelar);
    }

    private void accionarBotonCancelarAgregacion() {
        panelAgregarEmpleado.setVisible(false);
        panelAgregarEmpleado.vaciarCamposAgregarEmpleado();
    }

    private void mostrarPanelAgregarEmpleado() {
        panelAgregarEmpleado.setVisible(true);
    }

    public void ocultarPanelAgregarEmpleado() {
        panelAgregarEmpleado.setVisible(false);
        panelAgregarEmpleado.vaciarCamposAgregarEmpleado();
    }
}
