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
       setTitle("Reportes");
        
        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
