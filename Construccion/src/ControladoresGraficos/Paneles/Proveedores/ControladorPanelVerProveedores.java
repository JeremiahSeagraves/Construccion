/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Proveedores;

import Ventanas.Proveedores.PanelVerProveedores;

/**
 *
 * @author juan
 */
public class ControladorPanelVerProveedores {
    private static PanelVerProveedores panelVerProveedores;
    private static ControladorPanelVerProveedores controladorPanelVerProveedores;
    
    ControladorPanelVerProveedores(){
        
    }
    
    public static ControladorPanelVerProveedores obtenerControladorPanelVerProveedores(){
        if(controladorPanelVerProveedores == null){
            controladorPanelVerProveedores = new ControladorPanelVerProveedores();
            panelVerProveedores = new PanelVerProveedores();
        }
        return controladorPanelVerProveedores;
    }
}
