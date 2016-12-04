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

//        String fechaInicialString = cambiarDate();
        Reporte reporteEmpleados = new Reporte("Reporte Ventas Empleados");
        String[] encabezados = {"Nombre", "Cantidad"};

        TablaReporte tablaDatos = new TablaReporte();
        tablaDatos.setEncabezados(encabezados);
        ArrayList<Object[]> filas = new ArrayList<Object[]>();
        for (int i = 0; i < numeroEmpleados; i++) {
            int cantidadVenta = 0;
            String nombreEmpleado = empleados.obtenerDatos().get(i).getNombre();
            Object[] fila = {nombreEmpleado, cantidadVenta};
            for (Venta venta : ventas) {
                if ((venta.getEmpleado().getNombre()).equals(nombreEmpleado)) {
                    cantidadVenta++;

                }
            }

            tablaDatos.agregarFila(fila);
        }
        reporteEmpleados.setTablaDatos(tablaDatos);

        return reporteEmpleados;
    }

    public Reporte generarReporteVentas() {
        ArrayList<Venta> ventas = (ArrayList<Venta>) administrador.obtenerDatos();
        Reporte reporteVentas = new Reporte("Reporte Ventas /n ");

        String[] encabezados = {"ClaveVenta", "MontoVenta", "Ganancia", "Fecha"};

        TablaReporte tablaDatos = new TablaReporte();
        tablaDatos.setEncabezados(encabezados);
        ArrayList<Object[]> filas = new ArrayList<Object[]>();
        for (Venta venta : ventas) {
            Object[] fila = {venta.getClave(), venta.getMontoVenta(), venta.getGanancia(), venta.getFecha()};

            tablaDatos.agregarFila(fila);
        }
        reporteVentas.setTablaDatos(tablaDatos);
        return reporteVentas;
    }

    public Reporte generarReporteArticulosVendidos() {
        ArrayList<Venta> ventas = (ArrayList<Venta>) administrador.obtenerDatos();
        Reporte reporteArticulosVendidos = new Reporte("Articulos Vendidos/n ");

        String[] encabezados = {"ClaveArticulo", "Cantidad", "Precio", "Fecha"};

        TablaReporte tablaDatos = new TablaReporte();
        tablaDatos.setEncabezados(encabezados);
        ArrayList<Object[]> filas = new ArrayList<Object[]>();
        for (Venta venta : ventas) {
            ArrayList<Articulo> articulos = venta.getArticulosVendidos();

            for (Articulo articulo : articulos) {
                Object[] fila = {articulo.getClaveArticulo(), articulo.getDetalleArticulo().getPrecioVenta(), venta.getFecha()};
                tablaDatos.agregarFila(fila);
            }

        }
        
        reporteArticulosVendidos.setTablaDatos(tablaDatos);
        return reporteArticulosVendidos;
    }

    public Reporte generarReporteProveedor(String nombreProveedor) {
        ArrayList<Venta> ventas = (ArrayList<Venta>) administrador.obtenerDatos();
        Reporte reporteProveedor = new Reporte("Proveedor: " + nombreProveedor);

        String[] encabezados = {"ClaveArticulo", "Cantidad", "Precio", "Fecha"};

        TablaReporte tablaDatos = new TablaReporte();
        tablaDatos.setEncabezados(encabezados);
        ArrayList<Object[]> filas = new ArrayList<Object[]>();
        for (Venta venta : ventas) {
            ArrayList<Articulo> articulos = venta.getArticulosVendidos();

            for (Articulo articulo : articulos) {
                if (articulo.getClaveArticulo().equals(nombreProveedor)) {
                    Object[] fila = {articulo.getClaveArticulo(), articulo.getDetalleArticulo().getPrecioVenta(), venta.getFecha()};
                    tablaDatos.agregarFila(fila);
                }

            }

        }
        reporteProveedor.setTablaDatos(tablaDatos);
        return reporteProveedor;
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
