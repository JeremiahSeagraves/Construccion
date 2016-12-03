/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Proveedores;

import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author rodrigopeniche
 */
public class VentanaProveedores extends JFrame {
    
    private static VentanaProveedores ventanaProveedores = null;
    
    private VentanaProveedores(){
        setTitle("Proveedores");
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
    
    public static VentanaProveedores obtenerVentanaProveedores(){
        if(ventanaProveedores == null){
            ventanaProveedores = new VentanaProveedores();
        }
        return ventanaProveedores;
    }
    
    public static Container obtenerContenedorVentanaProveedores(){
        return ventanaProveedores.getContentPane();
    }
    
}
