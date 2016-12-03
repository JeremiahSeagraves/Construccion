/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresPaneles;

import Modelo.Reporte;
import Modelo.TablaReporte;
import Modelo.Venta;
import Ventanas.reportes.PanelVerReporte;
import Ventanas.reportes.VentanaReportes;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Noe
 */
public class ControladorPanelVerReporte {
    private static ControladorPanelVerReporte controladorPanelVerReporte;
    private static PanelVerReporte panelVerReporte;
    private Reporte reporte;
    
    private ControladorPanelVerReporte(){
        
    }
    
    public static ControladorPanelVerReporte obtenerControladorPanelVerReporte() {
        if (controladorPanelVerReporte == null) {
            controladorPanelVerReporte = new ControladorPanelVerReporte();
            panelVerReporte = new PanelVerReporte();
        }
        return controladorPanelVerReporte;
    }
    
    public void desplegarPanelVerReporte(Reporte reporte)  {
        configurarPanelVerReporte();
         establecerTituloReporte(reporte.getEncabezado());
         llenarTablaReporte(reporte.getTablaDatos());
        
    }
   
   
   private void configurarPanelVerReporte(){
       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaReportes.obtenerContenedorVentanaReportes());
        VentanaReportes.obtenerContenedorVentanaReportes().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVerReporte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addComponent(panelVerReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
   }
   
    
   private void establecerTituloReporte(String titulo){
       panelVerReporte.getTituloReporte().setText(titulo);
   }
   
   private void llenarTablaReporte(TablaReporte tabla){
       borrarContenidoTablaReporte();
       DefaultTableModel modeloTabla =panelVerReporte.getContenidoTablaReporte();
       modeloTabla.setColumnIdentifiers(tabla.getEncabezados());
       for(int i=0;i<tabla.tamaño();i++){
           modeloTabla.addRow(tabla.getFila(i));
       }
       panelVerReporte.setContenidoTablaReporte(modeloTabla);
   }
   
   private void borrarContenidoTablaReporte() {
        panelVerReporte.getContenidoTablaReporte().setRowCount(0);
    }
}
