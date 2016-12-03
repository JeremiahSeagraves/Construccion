/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Noe
 */
public class Reporte {
    private String encabezado;
    private Date fechaCreacion;
    private TablaReporte tablaDatos;

    public Reporte(String encabezado) {
        this.encabezado = encabezado;
        this.tablaDatos = tablaDatos;
        this.fechaCreacion = new Date();
    }

  

    
    
    /**
     * @return the encabezado
     */
    public String getEncabezado() {
        return encabezado;
    }

    

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

   

    /**
     * @return the tablaDatos
     */
    public TablaReporte getTablaDatos() {
        return tablaDatos;
    }

    
    
    
}
