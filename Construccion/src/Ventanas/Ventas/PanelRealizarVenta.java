/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Ventas;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodrigopeniche
 */
public class PanelRealizarVenta extends javax.swing.JPanel {

    /**
     * Creates new form PanelRealizarVentas
     */
    
    private final DefaultTableModel contenidoTablaCarrito;
    
    public PanelRealizarVenta() {
        initComponents();
        
         contenidoTablaCarrito = new DefaultTableModel( );
        String camposTabla[] = new String[]{ "Clave Articulo", "Clave Proveedor","Descripción", "Cantidad",
            "Precio Compra", "Precio Venta" };
        contenidoTablaCarrito.setColumnIdentifiers( camposTabla );
        tablaCarritoCompras.setModel( contenidoTablaCarrito ); 
    }

    public DefaultTableModel getContenidoTablaCarrito() {
        return contenidoTablaCarrito;
    }

    public JButton getBotonAgregarCarrito() {
        return botonAgregarCarrito;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setBotonAgregarCarrito(JButton botonAgregarCarrito) {
        this.botonAgregarCarrito = botonAgregarCarrito;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public void setTablaCarritoCompras(JTable tablaCarritoCompras) {
        this.tablaCarritoCompras = tablaCarritoCompras;
    }
    
    public JButton getBotonEliminarDelCarrito(){
        return botonEliminarCarrito;
    }

    public void setBotonEliminarCarrito(JButton botonEliminarCarrito) {
        this.botonEliminarCarrito = botonEliminarCarrito;
    }

    public JButton getBotonRealizarVenta() {
        return botonRealizarVenta;
    }

    public void setBotonRealizarVenta(JButton botonRealizarVenta) {
        this.botonRealizarVenta = botonRealizarVenta;
    }
    
    

    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NO modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCarritoCompras = new javax.swing.JTable();
        botonAgregarCarrito = new javax.swing.JButton();
        etiquetaCarritoCompras = new javax.swing.JLabel();
        botonEliminarCarrito = new javax.swing.JButton();
        botonRealizarVenta = new javax.swing.JButton();

        tablaCarritoCompras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaCarritoCompras);

        botonAgregarCarrito.setText("Agregar al carrito");

        etiquetaCarritoCompras.setText("Carrito de Compras");

        botonEliminarCarrito.setText("Eliminar del Carrito");

        botonRealizarVenta.setText("Realizar Venta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(botonAgregarCarrito)
                        .addGap(40, 40, 40)
                        .addComponent(botonEliminarCarrito))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(etiquetaCarritoCompras))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(botonRealizarVenta)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaCarritoCompras)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregarCarrito)
                    .addComponent(botonEliminarCarrito))
                .addGap(18, 18, 18)
                .addComponent(botonRealizarVenta)
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarCarrito;
    private javax.swing.JButton botonEliminarCarrito;
    private javax.swing.JButton botonRealizarVenta;
    private javax.swing.JLabel etiquetaCarritoCompras;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCarritoCompras;
    // End of variables declaration//GEN-END:variables
}
