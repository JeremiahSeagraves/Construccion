/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Ventanas;

import ControladoresPaneles.ControladorPanelVerReporte;
import Modelo.GeneradorReportesVentas;
import Modelo.Reporte;
import Ventanas.reportes.VentanaReportes;
import javax.swing.JComboBox;

/**
 *
 * @author Noe
 */
public class ControladorVentanaReportes {

    private VentanaReportes ventanaReportes;
    private GeneradorReportesVentas generadorReportesVentas;
    private ControladorPanelVerReporte controladorPanelVerReporte;

    public ControladorVentanaReportes() {
        controladorPanelVerReporte = ControladorPanelVerReporte.obtenerControladorPanelVerReporte();
        inicializarVentana();
    }

    private void inicializarVentana() {
        VentanaReportes.obtenerVentanaReportes().setVisible(true);
        VentanaReportes.obtenerVentanaReportes().getCampoCriterio().setEnabled(false);
        agregarEventoComboBox();
    }

    public void agregarEventoComboBox() {
        JComboBox comboBox = ventanaReportes.getComboBoxReportes();
        comboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                switch (comboBox.getSelectedItem().toString()) {
                    case "Empleados": {
                        Reporte reporte = generadorReportesVentas.generarReporteVentasEmpleados();
                        controladorPanelVerReporte.desplegarPanelVerReporte(reporte);
                    }
                    break;
                    case "Proveedores": {
                        VentanaReportes.obtenerVentanaReportes().getCampoCriterio().setEnabled(false);
                        String criterio = VentanaReportes.obtenerVentanaReportes().getCampoCriterio().getText();
                        Reporte reporte = generadorReportesVentas.generarReporteProveedor(criterio);
                        controladorPanelVerReporte.obtenerControladorPanelVerReporte().desplegarPanelVerReporte(reporte);
                    }
                    break;
                    case "Ventas": {
                        Reporte reporte = generadorReportesVentas.generarReporteVentas();
                        controladorPanelVerReporte.obtenerControladorPanelVerReporte().desplegarPanelVerReporte(reporte);
                    }
                    break;
                    case "Articulos Vendidos": {
                        Reporte reporte = generadorReportesVentas.generarReporteArticulosVendidos();
                        controladorPanelVerReporte.obtenerControladorPanelVerReporte().desplegarPanelVerReporte(reporte);
                    }
                    break;
                }

            }
        });

    }
}
