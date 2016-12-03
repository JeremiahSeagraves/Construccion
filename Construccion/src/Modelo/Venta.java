/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author rodrigopeniche
 */
public class Venta {
    
    private int clave;
    private final ArrayList<Articulo> articulosVendidos;
    private double montoVenta;
    private double ganancia;
    private String fecha;
    private Empleado empleado;

  
    public Venta(ArrayList<Articulo> articulosVendidos){
        this.articulosVendidos= articulosVendidos;
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
        fecha = formatoFecha.format(fechaActual);
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public ArrayList<Articulo> getArticulosVendidos() {
        return articulosVendidos;
    }
    
    public double getMontoVenta() {
        return montoVenta;
    }

    public int getClave() {
        return clave;
    }


    public void setMontoVenta(double montoVenta) {
        this.montoVenta = montoVenta;
    }


    public double getGanancia() {
        return ganancia;
    }

    public String getFecha() {
        return fecha;
    }
    
    public Empleado getEmpleado() {
        return empleado;
    }
    
    public void setMonto(double monto){
        this.montoVenta= monto;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }
    

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
       
}
