/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Reportes;

import Administradores.AdministradorEmpleados;
import Administradores.AdministradorProveedores;
import Administradores.AdministradorVentas;
import Modelo.GeneradorReportesVentas;
import Modelo.Proveedor;
import Modelo.Reporte;
import Ventanas.reportes.PanelSeleccionarReporte;
import Ventanas.reportes.VentanaReportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Noe
 */
public class ControladorPanelSeleccionarReporte {

    private static PanelSeleccionarReporte panelSeleccionarReporte;
    private static ControladorPanelSeleccionarReporte controladorPanelSeleccionarReporte = null;
    private final AdministradorEmpleados administradorEmpleados ;
    private final AdministradorProveedores administradorProveedores ;
    private final AdministradorVentas administradorVentas ;
    private final int itemProveedor = 1;

    private ControladorPanelSeleccionarReporte() {
        administradorEmpleados = new AdministradorEmpleados();
        administradorProveedores = new AdministradorProveedores();
        administradorVentas = new AdministradorVentas();
    }

    public static ControladorPanelSeleccionarReporte obtenerControladorPanelSeleccionarReporte() {
        if (controladorPanelSeleccionarReporte == null) {
            controladorPanelSeleccionarReporte = new ControladorPanelSeleccionarReporte();
            panelSeleccionarReporte = new PanelSeleccionarReporte();
        }
        return controladorPanelSeleccionarReporte;
    }

    public void configurarPanelSeleccionarReporte() {
        mostrarPanelSeleccionarReporte();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaReportes.obtenerContenedorVentanaReportes());
        VentanaReportes.obtenerContenedorVentanaReportes().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelSeleccionarReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelSeleccionarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(189, Short.MAX_VALUE))
        );
    }

    public void desplegarPanelSeleccionarReporte() {
        configurarPanelSeleccionarReporte();
        panelSeleccionarReporte.getBotonGenerarReporte().setVisible(true);
    }

//    public void agregarEventoComboBoxReporte() {
//        JComboBox comboBoxReporte = panelSeleccionarReporte.getComboBoxReporte();
//
//        comboBoxReporte.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int numeroItemSeleccionado = comboBoxReporte.getSelectedIndex();
//                if (numeroItemSeleccionado == itemProveedor) {
//                    mostrarCampoCriterio();
//                    return;
//                } else {
//                    ocultarCampoCriterio();
//                }
//            }
//        });
//        panelSeleccionarReporte.setComboBoxReporte(comboBoxReporte);
//    }

    public void agregarEventoBotonGenerar() {
        JButton botonGenerar = panelSeleccionarReporte.getBotonGenerarReporte();

        botonGenerar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accionarBotonGenerarReporte();
                
            }
        });
        panelSeleccionarReporte.setBotonGenerarReporte(botonGenerar);
    }

    private void accionarBotonGenerarReporte() {
        
        
        Date fechaInicial = convertirADate(panelSeleccionarReporte.getCampoFechaInicial().getText());
        Date fechaFinal = convertirADate(panelSeleccionarReporte.getCampoFechaFinal().getText());
        
        ControladorPanelVerReporte controladorPanelVerReporte = ControladorPanelVerReporte.obtenerControladorPanelVerReporte();
        JComboBox comboBox = panelSeleccionarReporte.getComboBoxReporte();
        switch (comboBox.getSelectedItem().toString()) {
            case "Empleados": {
                
                Reporte reporte = administradorVentas.getGeneradorReportes().hacerReporteEmpleados(administradorEmpleados.obtenerDatos(),fechaInicial, fechaFinal);
                controladorPanelVerReporte.desplegarPanelVerReporte(reporte);
            }
            break;
            case "Proveedor": {   
                String nombreProveedor = mostrarVentanaEntradaDatos();
                Proveedor proveedor = buscarProveedor(nombreProveedor);
                Reporte reporte = administradorVentas.getGeneradorReportes().hacerReporteProveedor(proveedor,fechaInicial, fechaFinal);
                controladorPanelVerReporte.desplegarPanelVerReporte(reporte);
            }
            break;
            case "Ventas": {
                Reporte reporte = administradorVentas.getGeneradorReportes().hacerReporteVentas(fechaInicial, fechaFinal);
                controladorPanelVerReporte.desplegarPanelVerReporte(reporte);
            }
            break;
            case "Articulos Vendidos": {
                Reporte reporte = administradorVentas.getGeneradorReportes().hacerReporteArticulosVendidos(fechaInicial, fechaFinal);
                controladorPanelVerReporte.desplegarPanelVerReporte(reporte);
            }
            break;
        }

    }

    private String mostrarVentanaEntradaDatos(){
        String nombreProveedor = null;
        nombreProveedor = JOptionPane.showInputDialog("Ingresa el nombre del proveedor, para generar el reporte");
        return nombreProveedor;
    }
    public PanelSeleccionarReporte getPanelSeleccionarReporte() {
        return panelSeleccionarReporte;
    }

    private void mostrarPanelSeleccionarReporte() {
        panelSeleccionarReporte.setVisible(true);
      
    }

    private void ocultarPanelSeleccionarReporte() {
        panelSeleccionarReporte.setVisible(false);
    }
    
    private Proveedor buscarProveedor(String nombreProveedor){
        for(Proveedor proveedor : administradorProveedores.obtenerDatos()){
            if(proveedor.getNombre().equals(nombreProveedor)){
                return proveedor;
            }
        }
        return null;
    }

    private Date convertirADate(String fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNueva = null;
        try {
            fechaNueva = (Date) formatoFecha.parse(fecha);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error al generar reporte, no ingresó fechas");
        }
        return fechaNueva;
    }
  

}
