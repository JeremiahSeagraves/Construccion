/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Ventanas;

import ControladoresGraficos.Paneles.Proveedores.ControladorPanelActualizarProveedor;
import ControladoresGraficos.Paneles.Proveedores.ControladorPanelAgregarProveedor;
import ControladoresGraficos.Paneles.Proveedores.ControladorPanelBuscarProveedor;
import ControladoresGraficos.Paneles.Proveedores.ControladorPanelEliminarProveedor;
import ControladoresGraficos.Paneles.Proveedores.ControladorPanelVerProveedores;
import Ventanas.Proveedores.VentanaProveedores;

/**
 *
 * @author rodrigopeniche
 */
public class ControladorVentanaProveedores {

    private final ControladorPanelAgregarProveedor controladorPanelAgregarProveedor;
    private final ControladorPanelEliminarProveedor controladorPanelEliminarProveedor;
    private final ControladorPanelBuscarProveedor controladorPanelBuscarProveedor;
    private final ControladorPanelActualizarProveedor controladorPanelActualizarProveedor;
    private final ControladorPanelVerProveedores controladorPanelProveedor;

    public ControladorVentanaProveedores() {
        this.controladorPanelActualizarProveedor = ControladorPanelActualizarProveedor.obtenerControladorPanelActualizarProveedor();
        this.controladorPanelAgregarProveedor = ControladorPanelAgregarProveedor.obtenerControladorPanelAgregarProveedor();
        this.controladorPanelBuscarProveedor = ControladorPanelBuscarProveedor.obtenerControladorPanelBuscarProveedor();
        this.controladorPanelEliminarProveedor = ControladorPanelEliminarProveedor.obtenerControladorPanelEliminarProveedor();
        this.controladorPanelProveedor = ControladorPanelVerProveedores.obtenerControladorPanelVerProveedores();
        inicializarVentana();
    }

    private void inicializarVentana() {
        VentanaProveedores.obtenerVentanaProveedores().setVisible(true);
    }

    public ControladorPanelAgregarProveedor getControladorPanelAgregarProveedor() {
        return controladorPanelAgregarProveedor;
    }

    public ControladorPanelEliminarProveedor getControladorPanelEliminarProveedor() {
        return controladorPanelEliminarProveedor;
    }

    public ControladorPanelBuscarProveedor getControladorPanelBuscarProveedor() {
        return controladorPanelBuscarProveedor;
    }

    public ControladorPanelActualizarProveedor getControladorPanelActualizarProveedor() {
        return controladorPanelActualizarProveedor;
    }

    public ControladorPanelVerProveedores getControladorPanelProveedor() {
        return controladorPanelProveedor;
    }
}
