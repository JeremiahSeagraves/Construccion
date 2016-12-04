/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Ventanas;

import ControladoresGraficos.Paneles.Ventas.ControladorPanelRelizarVenta;
import ControladoresGraficos.Paneles.Ventas.ControladorPanelVerVentas;
import Ventanas.Ventas.VentanaVentas;

/**
 *
 * @author rodrigopeniche
 */
public class ControladorVentanaVentas {

    private final ControladorPanelRelizarVenta controladorPanelRealizarVenta;
    private final ControladorPanelVerVentas controladorPanelVerVentas;

    public ControladorVentanaVentas() {
        this.controladorPanelRealizarVenta = ControladorPanelRelizarVenta.obtenerControladorPanelRealizarVenta();
        this.controladorPanelVerVentas = ControladorPanelVerVentas.obtenerControladorPanerVerVentas();
        inicializarVentana();

    }

    private void inicializarVentana() {
        VentanaVentas.obteneVentanaVentas().setVisible(true);
    }

    public ControladorPanelRelizarVenta getControladorPanelRealizarVenta() {
        return controladorPanelRealizarVenta;
    }

    public ControladorPanelVerVentas getControladorPanelVerVentas() {
        return controladorPanelVerVentas;
    }

}
