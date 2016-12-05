/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Reportes;

import Modelo.GeneradorReportesVentas;
import Modelo.Reporte;
import Ventanas.reportes.PanelSeleccionarReporte;
import Ventanas.reportes.VentanaReportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Noe
 */
public class ControladorPanelSeleccionarReporte {

    private static PanelSeleccionarReporte panelSeleccionarReporte;
    private static ControladorPanelSeleccionarReporte controladorPanelSeleccionarReporte = null;
    private final int itemProveedor = 1;

    private ControladorPanelSeleccionarReporte() {

    }

    public static ControladorPanelSeleccionarReporte obtenerControladorPanelSeleccionarReporte() {
        if (controladorPanelSeleccionarReporte == null) {
            controladorPanelSeleccionarReporte = new ControladorPanelSeleccionarReporte();
            panelSeleccionarReporte = new PanelSeleccionarReporte();
        }
        return controladorPanelSeleccionarReporte;
    }

    public void configurarPanelSeleccionarReporte() {
        mostrarPanelSeleccionarReporte();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaReportes.obtenerContenedorVentanaReportes());
        VentanaReportes.obtenerContenedorVentanaReportes().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelSeleccionarReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelSeleccionarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(189, Short.MAX_VALUE))
        );
    }

    public void desplegarPanelSeleccionarReporte() {
        configurarPanelSeleccionarReporte();
        panelSeleccionarReporte.getBotonGenerarReporte().setVisible(true);
    }

//    public void agregarEventoComboBoxReporte() {
//        JComboBox comboBoxReporte = panelSeleccionarReporte.getComboBoxReporte();
//
//        comboBoxReporte.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int numeroItemSeleccionado = comboBoxReporte.getSelectedIndex();
//                if (numeroItemSeleccionado == itemProveedor) {
//                    mostrarCampoCriterio();
//                    return;
//                } else {
//                    ocultarCampoCriterio();
//                }
//            }
//        });
//        panelSeleccionarReporte.setComboBoxReporte(comboBoxReporte);
//    }

    public void agregarEventoBotonGenerar() {
        JButton botonGenerar = panelSeleccionarReporte.getBotonGenerarReporte();

        botonGenerar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonGenerarReporte();
                
            }
        });
        panelSeleccionarReporte.setBotonGenerarReporte(botonGenerar);
    }

    private void accionarBotonGenerarReporte() {
        GeneradorReportesVentas generadorReportesVentas = new GeneradorReportesVentas();
        ControladorPanelVerReporte controladorPanelVerReporte = ControladorPanelVerReporte.obtenerControladorPanelVerReporte();
        JComboBox comboBox = panelSeleccionarReporte.getComboBoxReporte();
        switch (comboBox.getSelectedItem().toString()) {
            case "Empleados": {
                Reporte reporte = generadorReportesVentas.generarReporteVentasEmpleados();
                controladorPanelVerReporte.desplegarPanelVerReporte(reporte);
            }
            break;
            case "Proveedor": {   
                String criterio = mostrarVentanaEntradaDatos();
                Reporte reporte = generadorReportesVentas.generarReporteProveedor(criterio);
                controladorPanelVerReporte.desplegarPanelVerReporte(reporte);
            }
            break;
            case "Ventas": {
                Reporte reporte = generadorReportesVentas.generarReporteVentas();
                controladorPanelVerReporte.desplegarPanelVerReporte(reporte);
            }
            break;
            case "Articulos Vendidos": {
                Reporte reporte = generadorReportesVentas.generarReporteArticulosVendidos();
                controladorPanelVerReporte.desplegarPanelVerReporte(reporte);
            }
            break;
        }

    }

    private String mostrarVentanaEntradaDatos(){
        String nombreProveedor = null;
        nombreProveedor   = JOptionPane.showInputDialog("Ingresa el nombre del proveedor, para generar el reporte");
        return nombreProveedor;
    }
    public PanelSeleccionarReporte getPanelSeleccionarReporte() {
        return panelSeleccionarReporte;
    }

    private void mostrarPanelSeleccionarReporte() {
        panelSeleccionarReporte.setVisible(true);
    }

    private void ocultarPanelSeleccionarReporte() {
        panelSeleccionarReporte.setVisible(false);
    }
  

}
