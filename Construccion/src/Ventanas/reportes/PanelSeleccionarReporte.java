/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.reportes;

/**
 *
 * @author Noe
 */
public class PanelSeleccionarReporte extends javax.swing.JPanel {

    /**
     * Creates new form PanelSeleccionarReporte
     */
    public PanelSeleccionarReporte() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxReporte = new javax.swing.JComboBox();
        campoCriterio = new javax.swing.JTextField();
        botonGenerarReporte = new javax.swing.JButton();

        comboBoxReporte.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Empleados", "Proveedor", "Articulos Vendidos", "Ventas" }));

        botonGenerarReporte.setText("GenerarReporte");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(comboBoxReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(campoCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(botonGenerarReporte)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGenerarReporte))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGenerarReporte;
    private javax.swing.JTextField campoCriterio;
    private javax.swing.JComboBox comboBoxReporte;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the botonGenerarReporte
     */
    public javax.swing.JButton getBotonGenerarReporte() {
        return botonGenerarReporte;
    }

    /**
     * @param botonGenerarReporte the botonGenerarReporte to set
     */
    public void setBotonGenerarReporte(javax.swing.JButton botonGenerarReporte) {
        this.botonGenerarReporte = botonGenerarReporte;
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
     * @return the comboBoxReporte
     */
    public javax.swing.JComboBox getComboBoxReporte() {
        return comboBoxReporte;
    }

    /**
     * @param comboBoxReporte the comboBoxReporte to set
     */
    public void setComboBoxReporte(javax.swing.JComboBox comboBoxReporte) {
        this.comboBoxReporte = comboBoxReporte;
    }
   
}