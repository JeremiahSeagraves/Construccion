/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Empleados;

import Administradores.AdministradorEmpleados;
import Modelo.Empleado;
import Ventanas.Empleados.PanelBuscarEmpleado;
import Ventanas.Empleados.VentanaEmpleados;
import javax.swing.JButton;

/**
 *
 * @author juan
 */
public class ControladorPanelBuscarEmpleado {

    private static ControladorPanelBuscarEmpleado controladorPanelBuscarEmpleado = null;
    private static PanelBuscarEmpleado panelBuscarEmpleado = null;

    private ControladorPanelBuscarEmpleado() {

    }

    public static ControladorPanelBuscarEmpleado obtenerControladorPanelBuscarEmpleado() {
        if (controladorPanelBuscarEmpleado == null) {
            controladorPanelBuscarEmpleado = new ControladorPanelBuscarEmpleado();
            panelBuscarEmpleado = new PanelBuscarEmpleado();
        }
        return controladorPanelBuscarEmpleado;
    }

    public void mostrarPanelBuscarEmpleado() {
        configurarPanelBuscarEmpleado();
        panelBuscarEmpleado.setVisible(true);
        ocultarOtrosPaneles();
    }
    
    private void ocultarOtrosPaneles(){
        ControladorPanelActualizarEmpleado.obtenerControladorPanelActualizarEmpleado().ocultarPanelActualizarEmpleado();
        ControladorPanelAgregarEmpleado.obtenerControladorPanelAgregarEmpleado().ocultarPanelAgregarEmpleado();
        ControladorPanelEliminarEmpleado.obtenerControladorPanelEliminarEmpleado().ocultarPanelEliminarEmpleado();

    }

    public void ocultarPanelBuscarEmpleado() {
        panelBuscarEmpleado.setVisible(false);
        panelBuscarEmpleado.vaciarCamposPanelBuscarEmpleado();
        panelBuscarEmpleado.ocultarCamposPanelBuscarEmpleado();
    }

    public void agregarEventoBotonBuscar() {
        JButton botonBuscar = panelBuscarEmpleado.getBotonBuscar();

        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonBuscarEmpleado();
            }
        });
        panelBuscarEmpleado.setBotonBuscar(botonBuscar);
    }

    private void accionarBotonBuscarEmpleado() {
        panelBuscarEmpleado.mostrarCamposPanelBuscarEmpleado();

        String claveEmpleado = panelBuscarEmpleado.getCampoTextoClave().getText();
        AdministradorEmpleados adminEmpleados = new AdministradorEmpleados();
        Empleado empleado = (Empleado) adminEmpleados.buscar(claveEmpleado);

        try{
        panelBuscarEmpleado.setCampoTextoNombre(empleado.getNombre());
        panelBuscarEmpleado.setCampoTextoTel(empleado.getTelefono());
        panelBuscarEmpleado.setCampoTextoDireccion(empleado.getDireccion());
        }catch(NullPointerException e){
            
        }
    }

    public void agregarEventoBotonCancelarBusqueda() {
        JButton botonCancelar = panelBuscarEmpleado.getBotonCancelar();

        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonCancelarBusqueda();
            }
        });
        panelBuscarEmpleado.setBotonCancelar(botonCancelar);
    }

    private void accionarBotonCancelarBusqueda() {
        panelBuscarEmpleado.setVisible(false);
        panelBuscarEmpleado.vaciarCamposPanelBuscarEmpleado();
        panelBuscarEmpleado.ocultarCamposPanelBuscarEmpleado();
    }

    private void configurarPanelBuscarEmpleado() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaEmpleados.obtenerContenedorVentanaEmpleados());
        VentanaEmpleados.obtenerContenedorVentanaEmpleados().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(566, Short.MAX_VALUE)
                        .addComponent(panelBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(panelBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(180, Short.MAX_VALUE))
        );
    }
}
