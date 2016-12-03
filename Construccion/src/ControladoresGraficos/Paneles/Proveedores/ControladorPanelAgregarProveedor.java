/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Proveedores;

import Ventanas.Proveedores.PanelAgregarProveedor;

/**
 *
 * @author juan
 */
public class ControladorPanelAgregarProveedor {
    private static PanelAgregarProveedor panelAgregarProveedor;
    private static ControladorPanelAgregarProveedor controladorPanelAgregarProveedor;
    
    private ControladorPanelAgregarProveedor(){
        
    }
    
    public static ControladorPanelAgregarProveedor obtenerControladorPanelAgregarProveedor(){
        if(controladorPanelAgregarProveedor == null){
            controladorPanelAgregarProveedor = new ControladorPanelAgregarProveedor();
            panelAgregarProveedor = new PanelAgregarProveedor();
        }
        return controladorPanelAgregarProveedor;
    }
}
