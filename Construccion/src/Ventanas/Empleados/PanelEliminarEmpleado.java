/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Empleados;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author rodrigopeniche
 */
public class PanelEliminarEmpleado extends javax.swing.JPanel {

    /**
     * Creates new form PanelEliminarCliente
     */
    public PanelEliminarEmpleado() {
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

        etiquetaClave = new javax.swing.JLabel();
        campoTextoClave = new javax.swing.JTextField();
        botonEliminar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        etiquetaElimiar = new javax.swing.JLabel();

        etiquetaClave.setText("Clave:");

        botonEliminar.setText("Eliminar");

        botonCancelar.setText("Cancelar");

        etiquetaElimiar.setText("Eliminar empleado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(botonEliminar)
                        .addGap(67, 67, 67)
                        .addComponent(botonCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaElimiar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaClave)
                                .addGap(39, 39, 39)
                                .addComponent(campoTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(etiquetaElimiar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaClave)
                    .addComponent(campoTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEliminar)
                    .addComponent(botonCancelar))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JTextField campoTextoClave;
    private javax.swing.JLabel etiquetaClave;
    private javax.swing.JLabel etiquetaElimiar;
    // End of variables declaration//GEN-END:variables

    public JButton getBotonCancelar() {
        return botonCancelar;
    }

    public void setBotonCancelar(JButton botonCancelar) {
        this.botonCancelar = botonCancelar;
    }

    public JButton getBotonEliminar() {
        return botonEliminar;
    }

    public void setBotonEliminar(JButton botonEliminar) {
        this.botonEliminar = botonEliminar;
    }

    public JTextField getCampoTextoClave() {
        return campoTextoClave;
    }

    public void setCampoTextoClave(JTextField campoTextoClave) {
        this.campoTextoClave = campoTextoClave;
    }

    public JLabel getEtiquetaClave() {
        return etiquetaClave;
    }

    public void setEtiquetaClave(JLabel etiquetaClave) {
        this.etiquetaClave = etiquetaClave;
    }

    public void vaciarCamposPanelEliminarEmpleado() {
        getCampoTextoClave().setText(null);
    }

}
