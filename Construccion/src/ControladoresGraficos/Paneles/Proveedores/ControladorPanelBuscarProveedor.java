/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Proveedores;

import Ventanas.Proveedores.PanelBuscarProveedor;

/**
 *
 * @author juan
 */
public class ControladorPanelBuscarProveedor {
    private static PanelBuscarProveedor panelBuscarProveedor;
    private static ControladorPanelBuscarProveedor controladorPanelBuscarProveedor;
    
    private ControladorPanelBuscarProveedor(){
        
    }
    
    public static ControladorPanelBuscarProveedor obtenerControladorPanelBuscarProveedor(){
        if(controladorPanelBuscarProveedor == null){
            controladorPanelBuscarProveedor = new ControladorPanelBuscarProveedor();
            panelBuscarProveedor = new PanelBuscarProveedor();
        }
        return controladorPanelBuscarProveedor;
    }
}
