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
public class PanelAgregarEmpleado extends javax.swing.JPanel {

    /**
     * Creates new form PanelAgregarCliente
     */
    public PanelAgregarEmpleado() {
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

        etiquetaAgregar = new javax.swing.JLabel();
        etiquetaClave = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaTel = new javax.swing.JLabel();
        etiquetaDireccion = new javax.swing.JLabel();
        campoTextoClave = new javax.swing.JTextField();
        campoTextoNombre = new javax.swing.JTextField();
        campoTextoTel = new javax.swing.JTextField();
        campoTextoDireccion = new javax.swing.JTextField();
        botonAgregar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        etiquetaAgregar.setText("Agregar Empleado");

        etiquetaClave.setText("Clave:");

        etiquetaNombre.setText("Nombre:");

        etiquetaTel.setText("Teléfono:");

        etiquetaDireccion.setText("Dirección:");

        campoTextoClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoClaveActionPerformed(evt);
            }
        });

        botonAgregar.setText("Agregar");

        botonCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaAgregar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(botonAgregar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                            .addComponent(botonCancelar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(etiquetaClave)
                                .addComponent(etiquetaNombre)
                                .addComponent(etiquetaTel)
                                .addComponent(etiquetaDireccion))
                            .addGap(57, 57, 57)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campoTextoClave)
                                .addComponent(campoTextoNombre)
                                .addComponent(campoTextoTel)
                                .addComponent(campoTextoDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(etiquetaAgregar)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaClave)
                    .addComponent(campoTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(campoTextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaTel)
                    .addComponent(campoTextoTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaDireccion)
                    .addComponent(campoTextoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregar)
                    .addComponent(botonCancelar))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoTextoClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoClaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextField campoTextoClave;
    private javax.swing.JTextField campoTextoDireccion;
    private javax.swing.JTextField campoTextoNombre;
    private javax.swing.JTextField campoTextoTel;
    private javax.swing.JLabel etiquetaAgregar;
    private javax.swing.JLabel etiquetaClave;
    private javax.swing.JLabel etiquetaDireccion;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaTel;
    // End of variables declaration//GEN-END:variables

    public JButton getBotonAgregar() {
        return botonAgregar;
    }

    public void setBotonAgregar(JButton botonAgregar) {
        this.botonAgregar = botonAgregar;
    }

    public JButton getBotonCancelar() {
        return botonCancelar;
    }

    public void setBotonCancelar(JButton botonCancelar) {
        this.botonCancelar = botonCancelar;
    }public JTextField getCampoTextoClave() {
        return campoTextoClave;
    }

    public void setCampoTextoClave(JTextField campoTextoClave) {
        this.campoTextoClave = campoTextoClave;
    }

    public JTextField getCampoTextoDireccion() {
        return campoTextoDireccion;
    }

    public void setCampoTextoDireccion(JTextField campoTextoDireccion) {
        this.campoTextoDireccion = campoTextoDireccion;
    }

    public JTextField getCampoTextoNombre() {
        return campoTextoNombre;
    }

    public void setCampoTextoNombre(JTextField campoTextoNombre) {
        this.campoTextoNombre = campoTextoNombre;
    }

    public JTextField getCampoTextoTel() {
        return campoTextoTel;
    }

    public void setCampoTextoTel(JTextField campoTextoTel) {
        this.campoTextoTel = campoTextoTel;
    }

    public JLabel getEtiquetaAgregar() {
        return etiquetaAgregar;
    }

    public void setEtiquetaAgregar(JLabel etiquetaAgregar) {
        this.etiquetaAgregar = etiquetaAgregar;
    }

    public JLabel getEtiquetaClave() {
        return etiquetaClave;
    }

    public void setEtiquetaClave(JLabel etiquetaClave) {
        this.etiquetaClave = etiquetaClave;
    }

    public JLabel getEtiquetaDireccion() {
        return etiquetaDireccion;
    }

    public void setEtiquetaDireccion(JLabel etiquetaDireccion) {
        this.etiquetaDireccion = etiquetaDireccion;
    }

    public JLabel getEtiquetaNombre() {
        return etiquetaNombre;
    }

    public void setEtiquetaNombre(JLabel etiquetaNombre) {
        this.etiquetaNombre = etiquetaNombre;
    }

    public JLabel getEtiquetaTel() {
        return etiquetaTel;
    }

    public void setEtiquetaTel(JLabel etiquetaTel) {
        this.etiquetaTel = etiquetaTel;
    }
   
    public void vaciarCamposAgregarEmpleado() {
        getCampoTextoClave().setText(null);
        getCampoTextoDireccion().setText(null);
        getCampoTextoNombre().setText(null);
        getCampoTextoTel().setText(null);
    }
    
}
