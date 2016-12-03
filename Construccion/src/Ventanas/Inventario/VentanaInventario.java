/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Inventario;

import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author rodrigopeniche
 */
public class VentanaInventario extends JFrame {
    
    private static VentanaInventario ventanaInventario = null;
    
    private VentanaInventario( ){
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
    

    public static  VentanaInventario obtenerVentanaInventario (){
        if(ventanaInventario == null){
            ventanaInventario = new VentanaInventario();
        }
            return ventanaInventario;
    }
    
    public static Container obtenerContenedorVentanaInventario(){
        return ventanaInventario.getContentPane();
    }
    
}
