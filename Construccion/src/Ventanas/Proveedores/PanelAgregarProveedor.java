/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Proveedores;

/**
 *
 * @author rodrigopeniche
 */
public class PanelAgregarProveedor extends javax.swing.JPanel {

    /**
     * Creates new form PanelAgregarProveedor
     */
    public PanelAgregarProveedor( ) {
        initComponents( );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings( "unchecked" )
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

        etiquetaAgregar.setText("Agregar proveedor");

        etiquetaClave.setText("Clave:");

        etiquetaNombre.setText("Nombre:");

        etiquetaTel.setText("Teléfono:");

        etiquetaDireccion.setText("Dirección:");

        botonAgregar.setText("Agregar");

        botonCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaAgregar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(botonAgregar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                            .addComponent(botonCancelar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(etiquetaClave)
                                .addComponent(etiquetaNombre)
                                .addComponent(etiquetaTel)
                                .addComponent(etiquetaDireccion))
                            .addGap(40, 40, 40)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campoTextoClave)
                                .addComponent(campoTextoNombre)
                                .addComponent(campoTextoTel)
                                .addComponent(campoTextoDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(etiquetaAgregar)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaClave)
                    .addComponent(campoTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(campoTextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaTel)
                    .addComponent(campoTextoTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaDireccion)
                    .addComponent(campoTextoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregar)
                    .addComponent(botonCancelar))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    

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

    /**
     * @return the botonAgregar
     */
    public javax.swing.JButton getBotonAgregar() {
        return botonAgregar;
    }

    /**
     * @param botonAgregar the botonAgregar to set
     */
    public void setBotonAgregar(javax.swing.JButton botonAgregar) {
        this.botonAgregar = botonAgregar;
    }

    /**
     * @return the botonCancelar
     */
    public javax.swing.JButton getBotonCancelar() {
        return botonCancelar;
    }

    /**
     * @param botonCancelar the botonCancelar to set
     */
    public void setBotonCancelar(javax.swing.JButton botonCancelar) {
        this.botonCancelar = botonCancelar;
    }

    /**
     * @return the campoTextoClave
     */
    public javax.swing.JTextField getCampoTextoClave() {
        return campoTextoClave;
    }

    /**
     * @param campoTextoClave the campoTextoClave to set
     */
    public void setCampoTextoClave(javax.swing.JTextField campoTextoClave) {
        this.campoTextoClave = campoTextoClave;
    }

    /**
     * @return the campoTextoDireccion
     */
    public javax.swing.JTextField getCampoTextoDireccion() {
        return campoTextoDireccion;
    }

    /**
     * @param campoTextoDireccion the campoTextoDireccion to set
     */
    public void setCampoTextoDireccion(javax.swing.JTextField campoTextoDireccion) {
        this.campoTextoDireccion = campoTextoDireccion;
    }

    /**
     * @return the campoTextoNombre
     */
    public javax.swing.JTextField getCampoTextoNombre() {
        return campoTextoNombre;
    }

    /**
     * @param campoTextoNombre the campoTextoNombre to set
     */
    public void setCampoTextoNombre(javax.swing.JTextField campoTextoNombre) {
        this.campoTextoNombre = campoTextoNombre;
    }

    /**
     * @return the campoTextoTel
     */
    public javax.swing.JTextField getCampoTextoTel() {
        return campoTextoTel;
    }

    /**
     * @param campoTextoTel the campoTextoTel to set
     */
    public void setCampoTextoTel(javax.swing.JTextField campoTextoTel) {
        this.campoTextoTel = campoTextoTel;
    }

    /**
     * @return the etiquetaAgregarProveedor
     */
    public javax.swing.JLabel getEtiquetaAgregarProveedor() {
        return etiquetaAgregar;
    }

    /**
     * @param etiquetaAgregarProveedor the etiquetaAgregarProveedor to set
     */
    public void setEtiquetaAgregarProveedor(javax.swing.JLabel etiquetaAgregarProveedor) {
        this.etiquetaAgregar = etiquetaAgregarProveedor;
    }

    /**
     * @return the etiquetaClave
     */
    public javax.swing.JLabel getEtiquetaClave() {
        return etiquetaClave;
    }

    /**
     * @param etiquetaClave the etiquetaClave to set
     */
    public void setEtiquetaClave(javax.swing.JLabel etiquetaClave) {
        this.etiquetaClave = etiquetaClave;
    }

    /**
     * @return the etiquetaDireccion
     */
    public javax.swing.JLabel getEtiquetaDireccion() {
        return etiquetaDireccion;
    }

    /**
     * @param etiquetaDireccion the etiquetaDireccion to set
     */
    public void setEtiquetaDireccion(javax.swing.JLabel etiquetaDireccion) {
        this.etiquetaDireccion = etiquetaDireccion;
    }

    /**
     * @return the etiquetaNombre
     */
    public javax.swing.JLabel getEtiquetaNombre() {
        return etiquetaNombre;
    }

    /**
     * @param etiquetaNombre the etiquetaNombre to set
     */
    public void setEtiquetaNombre(javax.swing.JLabel etiquetaNombre) {
        this.etiquetaNombre = etiquetaNombre;
    }

    /**
     * @return the etiquetaTel
     */
    public javax.swing.JLabel getEtiquetaTel() {
        return etiquetaTel;
    }

    /**
     * @param etiquetaTel the etiquetaTel to set
     */
    public void setEtiquetaTel(javax.swing.JLabel etiquetaTel) {
        this.etiquetaTel = etiquetaTel;
    }
}
