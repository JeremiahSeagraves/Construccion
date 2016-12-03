/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Inventario;

import javax.swing.JFrame;

/**
 *
 * @author rodrigopeniche
 */
public class VentanaInventario extends JFrame {
    
    PanelEliminarArticulo panelEliminarArticulo; 
    PanelActualizarArticulo panelActualizarArticulo;
    PanelVerInventario panelVerInventario;
    PanelBuscarArticulo panelBuscarArticulo;
    PanelAgregarArticulo panelAgregarArticulo;
    
    public VentanaInventario( ){
        
        panelEliminarArticulo = new PanelEliminarArticulo( );
        panelActualizarArticulo = new PanelActualizarArticulo ( );
        panelVerInventario = new PanelVerInventario ( );
        panelBuscarArticulo = new PanelBuscarArticulo( );
        panelAgregarArticulo = new PanelAgregarArticulo( );
        
        setTitle("Inventario");
        
        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
        getContentPane( ).setLayout( layout );
        layout.setHorizontalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGap( 0, 900, Short.MAX_VALUE )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGap( 0, 500, Short.MAX_VALUE )
        );
        
        pack();
    }
    

    
    public void mostrarPanelAgregarArticulo( ) {
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAgregarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 492, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAgregarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 208, Short.MAX_VALUE))
        );
    }
    
    public void mostrarPanelVerInventario( ){
            
       javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
        getContentPane( ).setLayout( layout );
        layout.setHorizontalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( layout.createSequentialGroup( )
                .addComponent(panelVerInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 280, Short.MAX_VALUE) )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( layout.createSequentialGroup( )
                .addComponent(panelVerInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 237, Short.MAX_VALUE) )
        );

    }
    
    public void mostrarPanelBuscarArticulo( ){
        panelBuscarArticulo.setVisible(true);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(566, Short.MAX_VALUE)
                .addComponent(panelBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panelBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );
     }
    
    public void mostrarPanelEliminarArticulo( ){
        panelEliminarArticulo.setVisible(true);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
        getContentPane( ).setLayout( layout );
        layout.setHorizontalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( layout.createSequentialGroup( )
                .addGap (26, 26, 26 )
                .addComponent( panelEliminarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 282, Short.MAX_VALUE ) )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup( javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup( )
                .addContainerGap (342, Short.MAX_VALUE )
                .addComponent( panelEliminarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addGap( 27, 27, 27 ) )
        );
     }
    
    
    public void mostrarPanelActualizarArticulo(  ){
        panelActualizarArticulo.setVisible(true);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(456, Short.MAX_VALUE)
                .addComponent(panelActualizarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelActualizarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 202, Short.MAX_VALUE))
        );
     }

    public PanelEliminarArticulo getPanelEliminarArticulo() {
        return panelEliminarArticulo;
    }

    public PanelActualizarArticulo getPanelActualizarArticulo() {
        return panelActualizarArticulo;
    }

    public PanelVerInventario getPanelVerInventario() {
        return panelVerInventario;
    }

    public PanelBuscarArticulo getPanelBuscarArticulo() {
        return panelBuscarArticulo;
    }

    public PanelAgregarArticulo getPanelAgregarArticulo() {
        return panelAgregarArticulo;
    }

    public void setPanelEliminarArticulo(PanelEliminarArticulo panelEliminarArticulo) {
        this.panelEliminarArticulo = panelEliminarArticulo;
    }

    public void setPanelActualizarArticulo(PanelActualizarArticulo panelActualizarArticulo) {
        this.panelActualizarArticulo = panelActualizarArticulo;
    }

    public void setPanelVerInventario(PanelVerInventario panelVerInventario) {
        this.panelVerInventario = panelVerInventario;
    }

    public void setPanelBuscarArticulo(PanelBuscarArticulo panelBuscarArticulo) {
        this.panelBuscarArticulo = panelBuscarArticulo;
    }

    public void setPanelAgregarArticulo(PanelAgregarArticulo panelAgregarArticulo) {
        this.panelAgregarArticulo = panelAgregarArticulo;
    }
    
     
    
}
