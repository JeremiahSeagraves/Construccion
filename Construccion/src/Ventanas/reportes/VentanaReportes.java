/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.reportes;

import Ventanas.Inventario.VentanaInventario;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author rodrigopeniche
 */
public class VentanaReportes extends JFrame {
    
  
    private PanelVerReporte panelVerReporte;
    private javax.swing.JComboBox comboBoxReportes;
    private javax.swing.JLabel etiquetaVentanaReporte;
    private javax.swing.JTextField campoCriterio;
    private javax.swing.JButton botonGenerar;
    private static VentanaReportes ventanaReportes = null;
    
    private VentanaReportes(){
        etiquetaVentanaReporte = new javax.swing.JLabel();
        comboBoxReportes = new javax.swing.JComboBox();
        campoCriterio = new javax.swing.JTextField();
        botonGenerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etiquetaVentanaReporte.setText("Reportes");

        comboBoxReportes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Empleados", "Proveedor", "Ventas", "Articulos Vendidos" }));

         botonGenerar.setText("GenerarReporte");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(comboBoxReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(etiquetaVentanaReporte)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(campoCriterio, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent( botonGenerar)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaVentanaReporte)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent( botonGenerar))
                .addContainerGap(220, Short.MAX_VALUE))
        );
        
           pack();
    }
       
    
     public static  VentanaReportes obtenerVentanaReportes (){
        if(ventanaReportes == null){
            ventanaReportes = new VentanaReportes();
        }
        return ventanaReportes;
    }
    
    public static Container obtenerContenedorVentanaReportes(){
        return ventanaReportes.getContentPane();
    }

    /**
     * @return the ComboBoxProveedor
     */
    public javax.swing.JComboBox getComboBoxReportes() {
        return comboBoxReportes;
    }

    /**
     * @param ComboBoxProveedor the ComboBoxProveedor to set
     */
    public void setComboBoxReportes(javax.swing.JComboBox comboBoxReportes) {
        this.comboBoxReportes = comboBoxReportes;
    }

    /**
     * @return the campoCriterio
     */
    public javax.swing.JTextField getCampoCriterio() {
        return campoCriterio;
    }

    /**
     * @param campoCriterio the campoCriterio to set
     */
    public void setCampoCriterio(javax.swing.JTextField campoCriterio) {
        this.campoCriterio = campoCriterio;
    }

    /**
     * @return the botonGenerar
     */
    public javax.swing.JButton getBotonGenerar() {
        return botonGenerar;
    }

    /**
     * @param botonGenerar the botonGenerar to set
     */
    public void setBotonGenerar(javax.swing.JButton botonGenerar) {
        this.botonGenerar = botonGenerar;
    }
   
}
