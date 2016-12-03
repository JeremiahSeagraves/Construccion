/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Proveedores;

import Ventanas.Proveedores.PanelActualizarProveedor;

/**
 *
 * @author juan
 */
public class ControladorPanelActualizarProveedor {
    private static PanelActualizarProveedor panelActualizarProveedor;
    private static ControladorPanelActualizarProveedor controladorPanelActualizarProveedor;
    
    private ControladorPanelActualizarProveedor(){
        
    }
    
    public static ControladorPanelActualizarProveedor obtenerControladorPanelActualizarProveedor(){
        if(controladorPanelActualizarProveedor == null){
            controladorPanelActualizarProveedor = new ControladorPanelActualizarProveedor();
            panelActualizarProveedor = new PanelActualizarProveedor();
        }
        return controladorPanelActualizarProveedor;
    }
    
    
}
