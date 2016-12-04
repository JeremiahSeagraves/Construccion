/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Ventanas;

import ControladoresGraficos.Paneles.Reportes.ControladorPanelSeleccionarReporte;
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

  
    private final ControladorPanelVerReporte controladorPanelVerReporte;
    private final ControladorPanelSeleccionarReporte controladorPanelSeleccionarReporte;

    public ControladorVentanaReportes() {
        
        controladorPanelSeleccionarReporte = ControladorPanelSeleccionarReporte.obtenerControladorPanelSeleccionarReporte();
        controladorPanelVerReporte = ControladorPanelVerReporte.obtenerControladorPanelVerReporte();
         inicializarVentana();
    }

    private void inicializarVentana() {
        VentanaReportes.obtenerVentanaReportes().setVisible(true);
        
    }
    
    public ControladorPanelSeleccionarReporte getControladorPanelSeleccionarReporte() {
        return controladorPanelSeleccionarReporte;
    }
   
    public ControladorPanelVerReporte getControladorPanelVerReporte() {
        return controladorPanelVerReporte;
    }
}
