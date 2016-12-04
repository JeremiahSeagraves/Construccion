/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Ventas;

import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author rodrigopeniche
 */
public class VentanaVentas extends JFrame {

    private static VentanaVentas ventanaVentas = null;

    private VentanaVentas() {

        setTitle("Ventas");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }

    public static VentanaVentas obteneVentanaVentas() {
        if (ventanaVentas == null) {
            ventanaVentas = new VentanaVentas();
        }
        return ventanaVentas;
    }

    public static Container obtenerContenedorVentanaVentas() {
        return ventanaVentas.getContentPane();
    }
}
