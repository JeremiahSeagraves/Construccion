/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Administradores.AdministradorEmpleados;
import Administradores.AdministradorVentas;
import java.util.ArrayList;
//import java.util.Date;
import java.sql.Date;

/**
 *
 * @author Noe
 */
public class GeneradorReportesVentas {
    private AdministradorVentas administrador;
    
    public GeneradorReportesVentas(){
        administrador = new AdministradorVentas();
    }
    
    public void generarReporteVentasEmpleados(Date fechaInicial, Date fechaFinal){
        
        AdministradorEmpleados empleados = new AdministradorEmpleados();
        int numeroEmpleados = empleados.obtenerDatos().size();
        ArrayList<Venta> ventas = (ArrayList<Venta>) administrador.obtenerDatos();
        Reporte reporteEmpleados = new Reporte("Ventas Empleados");
        String[] encabezados = {"Nombre","Cantidad"};
        
        for(int j = 0; j<numeroEmpleados;j++){
            String nombreEmpleado = empleados.obtenerDatos().get(j).getNombre();
            listaEmpleadoVenta[j][0] = nombreEmpleado ;
        }
        for(Venta venta : ventas){
            for(int i=0;i<listaEmpleadoVenta.length;i++){
                if((venta.getEmpleado().getNombre()).equals(listaEmpleadoVenta[i][0])){
                    
                }
            }
            
        }
    }
}
