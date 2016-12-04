/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Ventanas;

import ControladoresGraficos.Paneles.Empleados.ControladorPanelActualizarEmpleado;
import ControladoresGraficos.Paneles.Empleados.ControladorPanelAgregarEmpleado;
import ControladoresGraficos.Paneles.Empleados.ControladorPanelBuscarEmpleado;
import ControladoresGraficos.Paneles.Empleados.ControladorPanelEliminarEmpleado;
import ControladoresGraficos.Paneles.Empleados.ControladorPanelVerEmpleados;
import Ventanas.Empleados.VentanaEmpleados;



/**
 *
 * @author rodrigopeniche
 */
public class ControladorVentanaEmpleados {
    
   private final ControladorPanelAgregarEmpleado controladorPanelAgregarEmpleado;
    private final ControladorPanelEliminarEmpleado controladorPanelEliminarEmpleado;
    private final ControladorPanelBuscarEmpleado controladorPanelBuscarEmpleado;
    private final ControladorPanelActualizarEmpleado controladorPanelActualizarEmpleado;
    private final ControladorPanelVerEmpleados controladorPanelEmpleados; 
   
   public ControladorVentanaEmpleados(){
       this.controladorPanelActualizarEmpleado = ControladorPanelActualizarEmpleado.obtenerControladorPanelActualizarEmpleado();
       this.controladorPanelAgregarEmpleado = ControladorPanelAgregarEmpleado.obtenerControladorPanelAgregarEmpleado();
       this.controladorPanelBuscarEmpleado = ControladorPanelBuscarEmpleado.obtenerControladorPanelBuscarEmpleado();
       this.controladorPanelEliminarEmpleado = ControladorPanelEliminarEmpleado.obtenerControladorPanelEliminarEmpleado();
       this.controladorPanelEmpleados = ControladorPanelVerEmpleados.obtenerControladorPanelVerEmpleados();
       
       inicializarVentana();
       
   }
    
     private void inicializarVentana() {
       VentanaEmpleados.obtenerVentanaEmpleados().setVisible(true);
    }

    public ControladorPanelAgregarEmpleado getControladorPanelAgregarEmpleado() {
        return controladorPanelAgregarEmpleado;
    }

    public ControladorPanelEliminarEmpleado getControladorPanelEliminarEmpleado() {
        return controladorPanelEliminarEmpleado;
    }

    public ControladorPanelBuscarEmpleado getControladorPanelBuscarEmpleado() {
        return controladorPanelBuscarEmpleado;
    }

    public ControladorPanelActualizarEmpleado getControladorPanelActualizarEmpleado() {
        return controladorPanelActualizarEmpleado;
    }

    public ControladorPanelVerEmpleados getControladorPanelEmpleados() {
        return controladorPanelEmpleados;
    }
     
     
    
}
