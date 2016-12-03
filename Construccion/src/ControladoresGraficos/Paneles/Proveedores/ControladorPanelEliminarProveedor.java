/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Proveedores;

import Ventanas.Proveedores.PanelEliminarProveedor;

/**
 *
 * @author juan
 */
public class ControladorPanelEliminarProveedor {
    private static PanelEliminarProveedor panelEliminarProveedor;
    private static ControladorPanelEliminarProveedor controladorPanelEliminarProveedor;
    
    private ControladorPanelEliminarProveedor(){
        
    }
    
    public static ControladorPanelEliminarProveedor obtenerControladorPanelEliminarProveedor(){
        if(controladorPanelEliminarProveedor == null){
            controladorPanelEliminarProveedor = new ControladorPanelEliminarProveedor();
            panelEliminarProveedor = new PanelEliminarProveedor();
        }
        return controladorPanelEliminarProveedor;
    }
}
