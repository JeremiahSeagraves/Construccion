/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Empleados;

import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author rodrigopeniche
 */
public class VentanaEmpleados extends JFrame {
    
    private static VentanaEmpleados ventanaEmpleados = null;
    
    private VentanaEmpleados(){
        
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
    
    public static VentanaEmpleados obtenerVentanaEmpleados(){
        if(ventanaEmpleados == null){
            ventanaEmpleados = new VentanaEmpleados();
        }
        return ventanaEmpleados;
    }
    
    public static Container obtenerContenedorVentanaEmpleados(){
        return ventanaEmpleados.getContentPane();
    }
}
