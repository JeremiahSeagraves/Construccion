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
    private javax.swing.JLabel tituloVentana;
    private javax.swing.JTextField campoCriterio;
    private static VentanaReportes ventanaReportes = null;
    
    private VentanaReportes(){
        
         comboBoxReportes = new javax.swing.JComboBox();
          campoCriterio= new javax.swing.JTextField();
        tituloVentana = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

         comboBoxReportes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tituloVentana.setText("Reportes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(comboBoxReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(campoCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(tituloVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(224, 224, 224))
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
    public void setComboBoxProveedor(javax.swing.JComboBox comboBoxReportes) {
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

  
    
    
    
    
    
}
