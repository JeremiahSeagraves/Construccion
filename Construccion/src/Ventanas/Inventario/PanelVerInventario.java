/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Inventario;

import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodrigopeniche
 */
public class PanelVerInventario extends javax.swing.JPanel {

    private DefaultTableModel contenidoTablaArticulos;

    /**
     * Creates new form PanelVerInventario
     * @param ventanaInventario
     */
    public PanelVerInventario(  ) {
        initComponents( );
        
        contenidoTablaArticulos = new DefaultTableModel( );
        String camposTabla[] = new String[]{ "Clave Articulo", "Clave Proveedor","Descripción", "Cantidad",
            "Precio Compra", "Precio Venta" };
        contenidoTablaArticulos.setColumnIdentifiers( camposTabla );
        tablaArticulos.setModel( contenidoTablaArticulos ); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaArticulos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaArticulos = new javax.swing.JTable();
        botonBuscarArticulo = new javax.swing.JButton();
        botonEliminarArticulo = new javax.swing.JButton();
        botonActualizarArticulo = new javax.swing.JButton();

        etiquetaArticulos.setText("Artículos:");

        tablaArticulos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaArticulos);

        botonBuscarArticulo.setText("Buscar artículo");

        botonEliminarArticulo.setText("Eliminar artículo");

        botonActualizarArticulo.setText("Actualizar artículo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(etiquetaArticulos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(botonBuscarArticulo)
                        .addGap(51, 51, 51)
                        .addComponent(botonEliminarArticulo)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(botonActualizarArticulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(etiquetaArticulos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEliminarArticulo)
                    .addComponent(botonBuscarArticulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(botonActualizarArticulo))
        );
    }// </editor-fold>//GEN-END:initComponents
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarArticulo;
    private javax.swing.JButton botonBuscarArticulo;
    private javax.swing.JButton botonEliminarArticulo;
    private javax.swing.JLabel etiquetaArticulos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaArticulos;
    // End of variables declaration//GEN-END:variables

   

    /**
     * @return the contenidoTablaArticulos
     */
    public DefaultTableModel getContenidoTablaArticulos() {
        return contenidoTablaArticulos;
    }

    /**
     * @param contenidoTablaArticulos the contenidoTablaArticulos to set
     */
    public void setContenidoTablaArticulos(DefaultTableModel contenidoTablaArticulos) {
        this.contenidoTablaArticulos = contenidoTablaArticulos;
    }

    /**
     * @return the botonActualizarArticulo
     */
    public javax.swing.JButton getBotonActualizarArticulo() {
        return botonActualizarArticulo;
    }

    /**
     * @param botonActualizarArticulo the botonActualizarArticulo to set
     */
    public void setBotonActualizarArticulo(javax.swing.JButton botonActualizarArticulo) {
        this.botonActualizarArticulo = botonActualizarArticulo;
    }

    /**
     * @return the botonBuscarArticulo
     */
    public javax.swing.JButton getBotonBuscarArticulo() {
        return botonBuscarArticulo;
    }

    /**
     * @param botonBuscarArticulo the botonBuscarArticulo to set
     */
    public void setBotonBuscarArticulo(javax.swing.JButton botonBuscarArticulo) {
        this.botonBuscarArticulo = botonBuscarArticulo;
    }

    /**
     * @return the botonEliminarArticulo
     */
    public javax.swing.JButton getBotonEliminarArticulo() {
        return botonEliminarArticulo;
    }

    /**
     * @param botonEliminarArticulo the botonEliminarArticulo to set
     */
    public void setBotonEliminarArticulo(javax.swing.JButton botonEliminarArticulo) {
        this.botonEliminarArticulo = botonEliminarArticulo;
    }

    /**
     * @return the etiquetaArticulos
     */
    public javax.swing.JLabel getEtiquetaArticulos() {
        return etiquetaArticulos;
    }

    /**
     * @param etiquetaArticulos the etiquetaArticulos to set
     */
    public void setEtiquetaArticulos(javax.swing.JLabel etiquetaArticulos) {
        this.etiquetaArticulos = etiquetaArticulos;
    }

    /**
     * @return the jScrollPane1
     */
    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     * @param jScrollPane1 the jScrollPane1 to set
     */
    public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    /**
     * @return the tablaArticulos
     */
    public javax.swing.JTable getTablaArticulos() {
        return tablaArticulos;
    }

    /**
     * @param tablaArticulos the tablaArticulos to set
     */
    public void setTablaArticulos(javax.swing.JTable tablaArticulos) {
        this.tablaArticulos = tablaArticulos;
    }
   
}