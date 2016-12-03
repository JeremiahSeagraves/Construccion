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
       panelVerReporte.setVisible(true);
       javax.swing.JLabel tituloReporte = panelVerReporte.getTituloReporte();
       javax.swing.JTable tablaReporte = panelVerReporte.getTablaReporte();
       javax.swing.JScrollPane scroll = panelVerReporte.getjScrollPane1();
        tablaReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scroll.setViewportView(tablaReporte);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(VentanaReportes.obtenerContenedorVentanaReportes());
        VentanaReportes.obtenerContenedorVentanaReportes().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(tituloReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(tituloReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        panelVerReporte.setVisible(true);
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
