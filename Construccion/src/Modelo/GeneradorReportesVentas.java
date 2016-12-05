/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import Administradores.AdministradorVentas;
import java.util.ArrayList;

/**
 *
 * @author Noe
 */
public class GeneradorReportesVentas {

    private ArrayList<Venta> ventas;

    public GeneradorReportesVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }


    public Reporte hacerReporteEmpleados(ArrayList<Empleado> empleados) {

        Reporte reporteEmpleados = new Reporte("Reporte Ventas Empleados");
        TablaReporte tablaReporte = crearTablaReporteEmpleados();
        llenarTablaReporteEmpleados(tablaReporte, empleados);
        reporteEmpleados.setTablaDatos(tablaReporte);
        return reporteEmpleados;
    }

    private TablaReporte crearTablaReporteEmpleados() {

        TablaReporte tabla = new TablaReporte();
        String[] encabezados = {"Nombre", "Cantidad"};
        tabla.setEncabezados(encabezados);
        return tabla;

    }

    private void llenarTablaReporteEmpleados(TablaReporte tabla, ArrayList<Empleado> empleados) {
        int tamañoTabla = empleados.size();
        ArrayList<Object[]> filas = new ArrayList<Object[]>();
        for (int i = 0; i < tamañoTabla; i++) {
            int cantidadVenta = 0;
            String nombreEmpleado = empleados.get(i).getNombre();
            for (Venta venta : ventas) {
                if ((venta.getEmpleado().getNombre()).equals(nombreEmpleado)) {
                    cantidadVenta++;
                }
            }
            Object[] fila = {nombreEmpleado, cantidadVenta};
            tabla.agregarFila(fila);
        }
    }

    public Reporte hacerReporteVentas() {
        Reporte reporteVentas = new Reporte("Reporte Ventas");
        TablaReporte tablaReporte = crearTablaReporteVentas();
        llenarTablaReporteVentas(tablaReporte);
        reporteVentas.setTablaDatos(tablaReporte);
        agregarCampoAdicionalReporteVentas(reporteVentas);
        return reporteVentas;
    }

    private TablaReporte crearTablaReporteVentas() {

        TablaReporte tabla = new TablaReporte();
        String[] encabezados = {"ClaveVenta", "MontoVenta", "Ganancia", "Fecha"};
        tabla.setEncabezados(encabezados);
        return tabla;

    }

    private void llenarTablaReporteVentas(TablaReporte tabla) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();
        double gananciaPeriodo = 0;
        for (Venta venta : ventas) {
            System.out.println(venta.getClave());
            Object[] fila = {venta.getClave(), venta.getMontoVenta(), venta.getGanancia(), venta.getFecha()};
            gananciaPeriodo = gananciaPeriodo + venta.getGanancia();
            tabla.agregarFila(fila);
        }
    }

    private void agregarCampoAdicionalReporteVentas(Reporte reporteVentas) {
        String[] campoAdicional = new String[1];
        double gananciaPeriodo = 0;
        for (Venta venta : ventas) {
            gananciaPeriodo = gananciaPeriodo + venta.getGanancia();
        }
        campoAdicional[0] = String.valueOf(gananciaPeriodo);
        reporteVentas.setCamposAdicionales(campoAdicional);
    }

    public Reporte hacerReporteArticulosVendidos() {
        Reporte reporteArticulosVendidos = new Reporte("Articulos Vendidos ");
        TablaReporte tablaReporte = crearTablaReporteArticulosVendidos();
        llenarTablaReporteArticulosVendidos(tablaReporte);
        agregarCampoAdicionalReporteArticulosVendidos(reporteArticulosVendidos);
        reporteArticulosVendidos.setTablaDatos(tablaReporte);
        return reporteArticulosVendidos;
    }

    private TablaReporte crearTablaReporteArticulosVendidos() {
        TablaReporte tabla = new TablaReporte();
        String[] encabezados = {"ClaveVenta", "ClaveArticulo", "Cantidad", "Precio", "Fecha"};
        tabla.setEncabezados(encabezados);
        return tabla;
    }

    private void llenarTablaReporteArticulosVendidos(TablaReporte tabla) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        for (Venta venta : ventas) {
            ArrayList<Articulo> articulos = venta.getArticulosVendidos();
            for (Articulo articulo : articulos) {
                int cantidadArticulo = articulo.getDetalleArticulo().getCantidad();
                double precioArticulo = articulo.getDetalleArticulo().getPrecioVenta().getPrecio();
                Object[] fila = {venta.getClave(), articulo.getClaveArticulo(), cantidadArticulo, precioArticulo, venta.getFecha()};
                tabla.agregarFila(fila);
            }
        }
    }

    private void agregarCampoAdicionalReporteArticulosVendidos(Reporte reporte) {
        double gananciaPeriodo = 0;
        for (Venta venta : ventas) {
            ArrayList<Articulo> articulos = venta.getArticulosVendidos();
            for (Articulo articulo : articulos) {
                int cantidadArticulo = articulo.getDetalleArticulo().getCantidad();
                double precioArticulo = articulo.getDetalleArticulo().getPrecioVenta().getPrecio();
                gananciaPeriodo = gananciaPeriodo + (cantidadArticulo * precioArticulo);
            }

        }
        String[] campoAdicional = new String[1];
        campoAdicional[0] = String.valueOf(gananciaPeriodo);
        reporte.setCamposAdicionales(campoAdicional);
    }

    public Reporte hacerReporteProveedor(Proveedor proveedor) {
        Reporte reporteProveedor = new Reporte("Proveedor: " + proveedor.getNombre());
        TablaReporte tablaReporte = crearTablaReporteProveedor();
        llenarTablaReporteProveedor(tablaReporte, proveedor);
        reporteProveedor.setTablaDatos(tablaReporte);
        return reporteProveedor;
    }

    private TablaReporte crearTablaReporteProveedor() {
        TablaReporte tabla = new TablaReporte();
        String[] encabezados = {"ClaveArticulo", "Cantidad", "Precio", "Fecha"};
        tabla.setEncabezados(encabezados);
        return tabla;
    }

    private void llenarTablaReporteProveedor(TablaReporte tabla, Proveedor proveedor) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();
        for (Venta venta : ventas) {
            ArrayList<Articulo> articulos = venta.getArticulosVendidos();

            for (Articulo articulo : articulos) {

                if (articulo.getClaveProveedor().equals(proveedor.getClave())) {
                    Object[] fila = {articulo.getClaveArticulo(), articulo.getDetalleArticulo().getCantidad(), articulo.getDetalleArticulo().getPrecioVenta().getPrecio(), venta.getFecha()};
                    tabla.agregarFila(fila);
                }

            }

        }
    }

//    private Date cambiarStringADate(String fecha) {
//        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
//        Date fechaNueva = null;
//        try {
//            fechaNueva = (Date) formatoFecha.parse(fecha);
//        } catch (ParseException ex) {
//            Logger.getLogger(GeneradorReportesVentas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return fechaNueva;
//    }
//
//    private String cambiarDateAString(Date fecha) {
//        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
//        return formatoFecha.format(fecha);
//    }
}
