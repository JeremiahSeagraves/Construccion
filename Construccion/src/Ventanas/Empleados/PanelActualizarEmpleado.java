/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Empleados;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

/**
 *
 * @author rodrigopeniche
 */
public class PanelActualizarEmpleado extends javax.swing.JPanel {

    /**
     * Creates new form PanelActualizarCliente
     */
    public PanelActualizarEmpleado() {
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

        jScrollBar1 = new javax.swing.JScrollBar();
        etiquetaIngresarClave = new javax.swing.JLabel();
        campoTextoClave = new javax.swing.JTextField();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaTelefono = new javax.swing.JLabel();
        etiquetaDireccion = new javax.swing.JLabel();
        campoTextoNombre = new javax.swing.JTextField();
        campoTextoTel = new javax.swing.JTextField();
        campoTextoDireccion = new javax.swing.JTextField();
        botonGuardarCambios = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        etiquetaIngresarClave.setText("Ingrese la clave del empleado a actualizar:");

        etiquetaNombre.setText("Nombre:");

        etiquetaTelefono.setText("Teléfono:");

        etiquetaDireccion.setText("Dirección:");

        botonGuardarCambios.setText("Guardar Cambios");

        botonCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonGuardarCambios)
                        .addGap(49, 49, 49)
                        .addComponent(botonCancelar))
                    .addComponent(etiquetaIngresarClave, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaNombre)
                            .addComponent(etiquetaTelefono)
                            .addComponent(etiquetaDireccion))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoTextoNombre)
                            .addComponent(campoTextoTel)
                            .addComponent(campoTextoDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(etiquetaIngresarClave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(campoTextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaTelefono)
                    .addComponent(campoTextoTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaDireccion)
                    .addComponent(campoTextoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonGuardarCambios))
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardarCambios;
    private javax.swing.JTextField campoTextoClave;
    private javax.swing.JTextField campoTextoDireccion;
    private javax.swing.JTextField campoTextoNombre;
    private javax.swing.JTextField campoTextoTel;
    private javax.swing.JLabel etiquetaDireccion;
    private javax.swing.JLabel etiquetaIngresarClave;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaTelefono;
    private javax.swing.JScrollBar jScrollBar1;
    // End of variables declaration//GEN-END:variables

    public JButton getBotonCancelar() {
        return botonCancelar;
    }

    public JButton getBotonGuardarCambios() {
        return botonGuardarCambios;
    }

    public JTextField getCampoTextoClave() {
        return campoTextoClave;
    }

    public JTextField getCampoTextoDireccion() {
        return campoTextoDireccion;
    }

    public JTextField getCampoTextoNombre() {
        return campoTextoNombre;
    }

    public JTextField getCampoTextoTel() {
        return campoTextoTel;
    }

    public JLabel getEtiquetaDireccion() {
        return etiquetaDireccion;
    }

    public JLabel getEtiquetaIngresarClave() {
        return etiquetaIngresarClave;
    }

    public JLabel getEtiquetaNombre() {
        return etiquetaNombre;
    }

    public JLabel getEtiquetaTelefono() {
        return etiquetaTelefono;
    }

    public JScrollBar getjScrollBar1() {
        return jScrollBar1;
    }

    public void setBotonCancelar(JButton botonCancelar) {
        this.botonCancelar = botonCancelar;
    }

    public void setBotonGuardarCambios(JButton botonGuardarCambios) {
        this.botonGuardarCambios = botonGuardarCambios;
    }

    public void setCampoTextoClave(JTextField campoTextoClave) {
        this.campoTextoClave = campoTextoClave;
    }

    public void setCampoTextoDireccion(JTextField campoTextoDireccion) {
        this.campoTextoDireccion = campoTextoDireccion;
    }

    public void setCampoTextoNombre(JTextField campoTextoNombre) {
        this.campoTextoNombre = campoTextoNombre;
    }

    public void setCampoTextoTel(JTextField campoTextoTel) {
        this.campoTextoTel = campoTextoTel;
    }

    public void setEtiquetaDireccion(JLabel etiquetaDireccion) {
        this.etiquetaDireccion = etiquetaDireccion;
    }

    public void setEtiquetaIngresarClave(JLabel etiquetaIngresarClave) {
        this.etiquetaIngresarClave = etiquetaIngresarClave;
    }

    public void setEtiquetaNombre(JLabel etiquetaNombre) {
        this.etiquetaNombre = etiquetaNombre;
    }

    public void setEtiquetaTelefono(JLabel etiquetaTelefono) {
        this.etiquetaTelefono = etiquetaTelefono;
    }

    public void setjScrollBar1(JScrollBar jScrollBar1) {
        this.jScrollBar1 = jScrollBar1;
    }
    
        public void vaciarCamposActualizarEmpleado(){
        getCampoTextoClave().setText(null);
        getCampoTextoDireccion().setText(null);
        getCampoTextoNombre().setText(null);
        getCampoTextoTel().setText(null);
    }
    
    
}

