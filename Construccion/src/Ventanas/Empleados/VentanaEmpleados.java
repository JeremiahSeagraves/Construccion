/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Empleados;

import javax.swing.JFrame;

/**
 *
 * @author rodrigopeniche
 */
public class VentanaEmpleados extends JFrame {
    
    PanelActualizarEmpleado panelActualizarEmpleado;
    PanelAgregarEmpleado panelAgregarEmpleado;
    PanelBuscarEmpleado panelBuscarEmpleado;
    PanelVerEmpleados panelVerEmpleados;
    PanelEliminarEmpleado panelEliminarEmpleado;
    
    public VentanaEmpleados(){
        panelActualizarEmpleado = new PanelActualizarEmpleado();
        panelAgregarEmpleado = new PanelAgregarEmpleado();
        panelBuscarEmpleado = new PanelBuscarEmpleado();
        panelVerEmpleados = new PanelVerEmpleados();
        panelEliminarEmpleado = new PanelEliminarEmpleado();
        
        setTitle("Empleados");
        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
        getContentPane( ).setLayout( layout );
        layout.setHorizontalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGap( 0, 877, Short.MAX_VALUE )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGap( 0, 500, Short.MAX_VALUE )
        );
        
        pack();
    }
    
    public void mostrarPanelAgregarEmpleado( ){
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAgregarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 492, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAgregarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 208, Short.MAX_VALUE))
        );
     }
    
    public void mostrarPanelVerEmpleados ( ) {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
        getContentPane( ).setLayout( layout );
        layout.setHorizontalGroup(layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup(layout.createSequentialGroup( )
                .addComponent(panelVerEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 280, Short.MAX_VALUE) )
        );
        layout.setVerticalGroup(layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup(layout.createSequentialGroup( )
                .addComponent(panelVerEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 237, Short.MAX_VALUE) )
        );
        
    }
    
    public void mostrarPanelBuscarEmpleado( ){
        panelBuscarEmpleado.setVisible(true);
                
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(566, Short.MAX_VALUE)
                .addComponent(panelBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panelBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );
     }
    
    public void mostrarPanelEliminarEmpleado( ){
        panelEliminarEmpleado.setVisible(true);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
        getContentPane( ).setLayout( layout );
        layout.setHorizontalGroup(layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup(layout.createSequentialGroup( )
                .addGap (26, 26, 26 )
                .addComponent(panelEliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addContainerGap( 282, Short.MAX_VALUE ) )
        );
        layout.setVerticalGroup(layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup( )
                .addContainerGap (342, Short.MAX_VALUE )
                .addComponent(panelEliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                .addGap( 27, 27, 27 ) )
        );
     }
    
    public void mostrarPanelActualizarEmpleado( ){
        panelEliminarEmpleado.setVisible(true);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(456, Short.MAX_VALUE)
                .addComponent(panelActualizarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelActualizarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 202, Short.MAX_VALUE))
        ); 
     }

    public PanelActualizarEmpleado getPanelActualizarEmpleado() {
        return panelActualizarEmpleado;
    }

    public void setPanelActualizarEmpleado(PanelActualizarEmpleado panelActualizarEmpleado) {
        this.panelActualizarEmpleado = panelActualizarEmpleado;
    }

    public PanelAgregarEmpleado getPanelAgregarEmpleado() {
        return panelAgregarEmpleado;
    }

    public void setPanelAgregarEmpleado(PanelAgregarEmpleado panelAgregarEmpleado) {
        this.panelAgregarEmpleado = panelAgregarEmpleado;
    }

    public PanelBuscarEmpleado getPanelBuscarEmpleado() {
        return panelBuscarEmpleado;
    }

    public void setPanelBuscarEmpleado(PanelBuscarEmpleado panelBuscarEmpleado) {
        this.panelBuscarEmpleado = panelBuscarEmpleado;
    }

    public PanelVerEmpleados getPanelVerEmpleados() {
        return panelVerEmpleados;
    }

    public void setPanelVerEmpleados(PanelVerEmpleados panelVerEmpleados) {
        this.panelVerEmpleados = panelVerEmpleados;
    }

    public PanelEliminarEmpleado getPanelEliminarEmpleados() {
        return panelEliminarEmpleado;
    }

    public void setPanelEliminarCliente(PanelEliminarEmpleado panelEliminarEmpleado) {
        this.panelEliminarEmpleado = panelEliminarEmpleado;
    }
    
    
    
}
