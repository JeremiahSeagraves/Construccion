/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Ventas;

import Administradores.AdministradorVentas;
import Modelo.Venta;
import Ventanas.Ventas.PanelVerVentas;
import Ventanas.Ventas.VentanaVentas;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class ControladorPanelVerVentas {

    private static ControladorPanelVerVentas controladorPanelVerVentas = null;
    private static PanelVerVentas panelVerVentas = null;
    private ArrayList<Venta> ventas;

    private ControladorPanelVerVentas() {

    }

    public static ControladorPanelVerVentas obtenerControladorPanerVerVentas() {
        if (controladorPanelVerVentas == null) {
            controladorPanelVerVentas = new ControladorPanelVerVentas();
            panelVerVentas = new PanelVerVentas();
        }
        return controladorPanelVerVentas;
    }

    public void mostrarPenalVerVentas() {
        ocultarOtrosPaneles();
        configurarPanelVerVentar();
        panelVerVentas.setVisible(true);

    }
    
    private void ocultarOtrosPaneles(){
        ControladorPanelRelizarVenta.obtenerControladorPanelRealizarVenta().ocultarPanelRealizarVenta();
    }

    private void obtenerVentasBD() {
        AdministradorVentas adminVentas = new AdministradorVentas();
        ventas = (ArrayList<Venta>) adminVentas.obtenerDatos();
    }

    public void desplegarPanelVerVentas() throws ClassNotFoundException, SQLException {
        mostrarPenalVerVentas();
        obtenerVentasBD();
        llenarTablaVentas(ventas);
    }

    private void configurarPanelVerVentar(){
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaVentas.obtenerContenedorVentanaVentas());
        VentanaVentas.obtenerContenedorVentanaVentas().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelVerVentas, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(280, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelVerVentas, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(237, Short.MAX_VALUE))
        );
    }
    
    private void llenarTablaVentas(ArrayList<Venta> ventas) throws ClassNotFoundException, SQLException {
//        int articulosVendidos = adminVentas.obtenerTotalArticulosVendidos();
//        
//        for(int i = 0; i<articulosVendidos; i++){
//            panelVerVentas.getContenidoTablaVentas().addRow(new Object[]{ventas.get(i).getClave(),
//                                                            ventas.get(i)});
//        }
    }
    
    public void ocultarPanelVerVentas(){
        panelVerVentas.setVisible(false);
    }
}
