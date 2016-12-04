/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Ventanas;

import ControladoresGraficos.Paneles.Reportes.ControladorPanelVerReporte;
import Modelo.GeneradorReportesVentas;
import Modelo.Reporte;
import Ventanas.reportes.VentanaReportes;
import javax.swing.JButton;
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
       generadorReportesVentas = new GeneradorReportesVentas();
    }

    public void inicializarVentana() {
        ventanaReportes = VentanaReportes.obtenerVentanaReportes();
        ventanaReportes.setVisible(true);
        ventanaReportes.getCampoCriterio().setEnabled(false);
        ventanaReportes.getBotonGenerar().setVisible(true);
        agregarEventoBotonGenerar();
    }
    

    private void agregarEventoBotonGenerar() {
        
        JButton botonGenerar = ventanaReportes.getBotonGenerar();
        botonGenerar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JComboBox comboBox = ventanaReportes.getComboBoxReportes();
                switch (comboBox.getSelectedItem().toString()) {
                    case "Empleados": {
                        Reporte reporte = generadorReportesVentas.generarReporteVentasEmpleados();
                        controladorPanelVerReporte.desplegarPanelVerReporte(reporte);
                    }
                    break;
                    case "Proveedores": {
                        VentanaReportes.obtenerVentanaReportes().getCampoCriterio().setEnabled(true);
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
        
        ventanaReportes.setBotonGenerar(botonGenerar);

    }

    public ControladorPanelVerReporte getControladorPanelVerReporte() {
        return controladorPanelVerReporte;
    }
}
