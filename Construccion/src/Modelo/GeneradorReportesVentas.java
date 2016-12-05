/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Administradores.AdministradorEmpleados;
import Administradores.AdministradorProveedores;
import Administradores.AdministradorVentas;
import java.util.ArrayList;
//import java.util.Date;
import java.sql.Date;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Noe
 */
public class GeneradorReportesVentas {

    private AdministradorVentas administrador;

    public GeneradorReportesVentas() {
        administrador = new AdministradorVentas();
    }

    public Reporte generarReporteVentasEmpleados() {

        AdministradorEmpleados empleados = new AdministradorEmpleados();
        int numeroEmpleados = empleados.obtenerDatos().size();
        ArrayList<Venta> ventas = (ArrayList<Venta>) administrador.obtenerDatos();
        System.out.println(ventas.size());
//        String fechaInicialString = cambiarDate();
        Reporte reporteEmpleados = new Reporte("Reporte Ventas Empleados");
        String[] encabezados = {"Nombre", "Cantidad"};

        TablaReporte tablaDatos = new TablaReporte();
        tablaDatos.setEncabezados(encabezados);
        ArrayList<Object[]> filas = new ArrayList<Object[]>();
        for (int i = 0; i < numeroEmpleados; i++) {
            int cantidadVenta = 0;
            String nombreEmpleado = empleados.obtenerDatos().get(i).getNombre();
        
            for (Venta venta : ventas) {
               
                if ((venta.getEmpleado().getNombre()).equals(nombreEmpleado)) {
                    cantidadVenta++;

                }
            }
            
            Object[] fila = {nombreEmpleado, cantidadVenta};

            tablaDatos.agregarFila(fila);
        }
        reporteEmpleados.setTablaDatos(tablaDatos);

        return reporteEmpleados;
    }

    public Reporte generarReporteVentas() {
        ArrayList<Venta> ventas = (ArrayList<Venta>) administrador.obtenerDatos();
        Reporte reporteVentas = new Reporte("Reporte Ventas");

        String[] encabezados = {"ClaveVenta", "MontoVenta", "Ganancia", "Fecha"};

        TablaReporte tablaDatos = new TablaReporte();
        tablaDatos.setEncabezados(encabezados);
        ArrayList<Object[]> filas = new ArrayList<Object[]>();
        double gananciaPeriodo = 0;        
        for (Venta venta : ventas) {
            System.out.println(venta.getClave());
            Object[] fila = {venta.getClave(), venta.getMontoVenta(), venta.getGanancia(), venta.getFecha()};
            gananciaPeriodo = gananciaPeriodo + venta.getGanancia();
            tablaDatos.agregarFila(fila);
        }
        reporteVentas.setTablaDatos(tablaDatos);
        
        String[] campoAdicional = new String[1];
        campoAdicional[0] =String.valueOf(gananciaPeriodo);
        reporteVentas.setCamposAdicionales(campoAdicional);
        return reporteVentas;
    }

    public Reporte generarReporteArticulosVendidos() {
        ArrayList<Venta> ventas = (ArrayList<Venta>) administrador.obtenerDatos();
        
        Reporte reporteArticulosVendidos = new Reporte("Articulos Vendidos ");

        String[] encabezados = {"ClaveVenta","ClaveArticulo", "Cantidad", "Precio", "Fecha"};

        TablaReporte tablaDatos = new TablaReporte();
        tablaDatos.setEncabezados(encabezados);
        ArrayList<Object[]> filas = new ArrayList<Object[]>();
        
        double gananciaPeriodo = 0;
        for (Venta venta : ventas) {
            ArrayList<Articulo> articulos = venta.getArticulosVendidos();
            for (Articulo articulo : articulos) {
                int cantidadArticulo = articulo.getDetalleArticulo().getCantidad();
                double precioArticulo = articulo.getDetalleArticulo().getPrecioVenta().getPrecio();
                Object[] fila = {venta.getClave(),articulo.getClaveArticulo(),cantidadArticulo,precioArticulo, venta.getFecha()};
                tablaDatos.agregarFila(fila);
                gananciaPeriodo = gananciaPeriodo + (cantidadArticulo*precioArticulo);
            }

        }
        
        reporteArticulosVendidos.setTablaDatos(tablaDatos);
        
        String[] campoAdicional = new String[1];
        campoAdicional[0] =String.valueOf(gananciaPeriodo);
        reporteArticulosVendidos.setCamposAdicionales(campoAdicional);
        return reporteArticulosVendidos;
    }

    public Reporte generarReporteProveedor(String nombreProveedor) {
        ArrayList<Venta> ventas = (ArrayList<Venta>) administrador.obtenerDatos();
        
        Reporte reporteProveedor = new Reporte("Proveedor: " + nombreProveedor);

        String[] encabezados = {"ClaveArticulo", "Cantidad", "Precio", "Fecha"};
    
        TablaReporte tablaDatos = new TablaReporte();
        tablaDatos.setEncabezados(encabezados);
        ArrayList<Object[]> filas = new ArrayList<Object[]>();  
        String claveProveedor = buscarClaveProveedorSolicitado(nombreProveedor);
        for (Venta venta : ventas) {
            ArrayList<Articulo> articulos = venta.getArticulosVendidos();
        
            for (Articulo articulo : articulos) {
          
                if (articulo.getClaveProveedor().equals(claveProveedor)) {
                    Object[] fila = {articulo.getClaveArticulo(),articulo.getDetalleArticulo().getCantidad(), articulo.getDetalleArticulo().getPrecioVenta().getPrecio(), venta.getFecha()};
                    tablaDatos.agregarFila(fila);
                }

            }

        }
        reporteProveedor.setTablaDatos(tablaDatos);
        return reporteProveedor;
    }
    
    private String  buscarClaveProveedorSolicitado(String nombreProveedor){
        AdministradorProveedores administradorProveedor = new AdministradorProveedores();
        ArrayList<Proveedor> proveedores = (ArrayList<Proveedor>) administradorProveedor.obtenerDatos();
        
        for(Proveedor proveedor : proveedores){
            if(proveedor.getNombre().equals(nombreProveedor)){
               return proveedor.getClave();
            }
        }
        return null;
    }

    private Date cambiarStringADate(String fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
        Date fechaNueva = null;
        try {
            fechaNueva = (Date) formatoFecha.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(GeneradorReportesVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaNueva;
    }

    private String cambiarDateAString(Date fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
        return formatoFecha.format(fecha);
    }

}
