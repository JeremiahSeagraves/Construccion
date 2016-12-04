/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos.Paneles.Reportes;

import Modelo.Reporte;
import Modelo.TablaReporte;
import Modelo.Venta;
import Ventanas.reportes.PanelVerReporte;
import Ventanas.reportes.VentanaReportes;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Noe
 */
public class ControladorPanelVerReporte {
    private static ControladorPanelVerReporte controladorPanelVerReporte = null ;
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
         System.out.println(reporte.getTablaDatos().tamaño());
         llenarTablaReporte(reporte.getTablaDatos());
        
    }
   
   
   private void configurarPanelVerReporte(){
       mostrarPanelVerReporte();
       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaReportes.obtenerContenedorVentanaReportes());
        VentanaReportes.obtenerContenedorVentanaReportes().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelVerReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addComponent(panelVerReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        
   }
   
    
   private void establecerTituloReporte(String titulo){
       panelVerReporte.getTituloReporte().setText(titulo);
   }
   
   private void mostrarPanelVerReporte(){
       panelVerReporte.setVisible(true);
   }
   
   private void llenarTablaReporte(TablaReporte tabla){
       borrarContenidoTablaReporte();
      
       
       DefaultTableModel modeloTabla = new DefaultTableModel();
       modeloTabla.setColumnIdentifiers(tabla.getEncabezados());
       for(int i=0;i<tabla.tamaño();i++){
           modeloTabla.addRow(tabla.getFila(i));
       }
       JTable tablaVentana = panelVerReporte.getTablaReporte();
       tablaVentana.setModel(modeloTabla);
       panelVerReporte.setTablaReporte(tablaVentana);
   }
   
   private void borrarContenidoTablaReporte() {
       DefaultTableModel modeloTabla = new DefaultTableModel();
       modeloTabla.setRowCount(0);
       JTable tabla = new JTable();
       tabla.setModel(modeloTabla);
       panelVerReporte.setTablaReporte(tabla);
    }
}
