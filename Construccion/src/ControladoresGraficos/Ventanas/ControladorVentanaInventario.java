/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Ventanas;

import ControladoresGraficos.Paneles.Inventario.ControladorPanelActualizarArticulo;
import ControladoresGraficos.Paneles.Inventario.ControladorPanelAgregarArticulo;
import ControladoresGraficos.Paneles.Inventario.ControladorPanelBuscarArticulo;
import ControladoresGraficos.Paneles.Inventario.ControladorPanelEliminarArticulo;
import ControladoresGraficos.Paneles.Inventario.ControladorPanelVerInventario;
import Ventanas.Inventario.VentanaInventario;

/**
 *
 * @author rodrigopeniche
 */
public class ControladorVentanaInventario {
    private final ControladorPanelAgregarArticulo controladorPanelAgregarArticulo;
    private final ControladorPanelEliminarArticulo controladorPanelEliminarArticulo;
    private final ControladorPanelBuscarArticulo controladorPanelBuscarArticulo;
    private final ControladorPanelActualizarArticulo controladorPanelActualizarArticulo;
    private final ControladorPanelVerInventario controladorPanelInventario; 
    
    public ControladorVentanaInventario() {
        this.controladorPanelAgregarArticulo = ControladorPanelAgregarArticulo.obtenerControladorPanelAgregaArticulo();
        this.controladorPanelEliminarArticulo = ControladorPanelEliminarArticulo.obtenerControladorPanelEliminarArticulo();
        this.controladorPanelBuscarArticulo = ControladorPanelBuscarArticulo.obtenerControladorPanelBuscarArticulo();
        this.controladorPanelActualizarArticulo = ControladorPanelActualizarArticulo.obtenerControladorPanelActualizarArticulo();
        this.controladorPanelInventario = ControladorPanelVerInventario.obtenerControladorPanelInventario();
        
        inicializarVentana();
    }
    
    private void inicializarVentana() {
        VentanaInventario.obtenerVentanaInventario().setVisible(true);
    }

    public ControladorPanelAgregarArticulo getControladorPanelAgregarArticulo() {
        return controladorPanelAgregarArticulo;
    }

    public ControladorPanelEliminarArticulo getControladorPanelEliminarArticulo() {
        return controladorPanelEliminarArticulo;
    }

    public ControladorPanelBuscarArticulo getControladorPanelBuscarArticulo() {
        return controladorPanelBuscarArticulo;
    }

    public ControladorPanelActualizarArticulo getControladorPanelActualizarArticulo() {
        return controladorPanelActualizarArticulo;
    }

    public ControladorPanelVerInventario getControladorPanelInventario() {
        return controladorPanelInventario;
    }
    
    
}
