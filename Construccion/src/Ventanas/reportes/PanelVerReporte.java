/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.reportes;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodrigopeniche
 */
public class PanelVerReporte extends javax.swing.JPanel {

    /**
     * Creates new form PanelVerProveedores
     * @param ventanaPrincipal
     */
    public PanelVerReporte( ) {
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

        tituloReporte = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReporte = new javax.swing.JTable();
        etiquetaGanancia = new javax.swing.JLabel();
        campoGanancia = new javax.swing.JTextField();

        tablaReporte.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaReporte);

        etiquetaGanancia.setText("Ganancia:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(etiquetaGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoGanancia))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tituloReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(tituloReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaGanancia)
                    .addComponent(campoGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoGanancia;
    private javax.swing.JLabel etiquetaGanancia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaReporte;
    private javax.swing.JLabel tituloReporte;
    // End of variables declaration//GEN-END:variables


    /**
     * @return the etiquetaProveedores
     */
    public javax.swing.JLabel getTituloReporte() {
        return tituloReporte;
    }

    /**
     * @param etiquetaProveedores the etiquetaProveedores to set
     */
    public void setTituloReporte(javax.swing.JLabel tituloReporte) {
        this.tituloReporte = tituloReporte;
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

    public javax.swing.JTable getTablaReporte() {
        return tablaReporte;
    }

    
    public void setContenidoTabla(javax.swing.table.DefaultTableModel contenidoTablaReporte) {
        tablaReporte.setModel(contenidoTablaReporte);
    }

    /**
     * @return the campoGanancia
     */
    public javax.swing.JTextField getCampoGanancia() {
        return campoGanancia;
    }

    /**
     * @param campoGanancia the campoGanancia to set
     */
    public void setCampoGanancia(javax.swing.JTextField campoGanancia) {
        this.campoGanancia = campoGanancia;
    }

    /**
     * @return the etiquetaGanancia
     */
    public javax.swing.JLabel getEtiquetaGanancia() {
        return etiquetaGanancia;
    }

    /**
     * @param etiquetaGanancia the etiquetaGanancia to set
     */
    public void setEtiquetaGanancia(javax.swing.JLabel etiquetaGanancia) {
        this.etiquetaGanancia = etiquetaGanancia;
    }

   
    
    
}
