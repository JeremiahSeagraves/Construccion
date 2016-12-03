/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;


import Controladores.ControladorVentanaPrincipal;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;


/**
 *
 * @author rodrigopeniche
 */
public class VentanaPrincipal extends JFrame {
    
    private JMenuBar barraMenuPrincipal;
    private JMenu menuInventario;
    private JMenu menuProveedores;
    private JMenu menuVentas;
    private JMenu menuClientes;
    private JMenuItem menuItemVerInventario;
    private JMenuItem menuItemAgregarArticulo;
    private JMenuItem menuItemVerProveedores;
    private JMenuItem menuItemAgregarProveedor;
    private JMenuItem menuItemVerVentas;
    private JMenuItem menuItemRealizarVenta;
    private JMenuItem menuItemAgregarEmpleado;
    private JMenuItem menuItemVerEmpleados;
    private InputStream imagenDeFondo;
    private static ControladorVentanaPrincipal controladorVentanaPrincipal;

    
    public VentanaPrincipal( ){
       
        barraMenuPrincipal = new javax.swing.JMenuBar( );
        menuInventario = new javax.swing.JMenu( );
        menuProveedores = new javax.swing.JMenu( );
        menuVentas = new javax.swing.JMenu( );
        menuClientes = new javax.swing.JMenu( );
        menuItemAgregarArticulo = new javax.swing.JMenuItem( );
        menuItemVerProveedores = new javax.swing.JMenuItem( );
        menuItemAgregarProveedor = new javax.swing.JMenuItem( );
        menuItemVerInventario = new javax.swing.JMenuItem( );
        menuItemVerVentas = new javax.swing.JMenuItem( );
        menuItemRealizarVenta = new javax.swing.JMenuItem( );
        menuItemAgregarEmpleado = new javax.swing.JMenuItem( );
        menuItemVerEmpleados = new javax.swing.JMenuItem( );
        
        cargarImagenDeFondo();
        
        setDefaultCloseOperation( javax.swing.WindowConstants.EXIT_ON_CLOSE );

        crearMenuVentana();
//        agregarReceptoresEventos();
//        

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

        pack( );
        
        
    }
    
    private void crearMenuVentana(){
        getMenuInventario().setText( "Inventario" );
        getMenuItemVerInventario().setText( "Ver" );
        getMenuInventario().add(getMenuItemVerInventario());
        getMenuItemAgregarArticulo().setText( "Agregar" );
        getMenuInventario().add(getMenuItemAgregarArticulo());
        getBarraMenuPrincipal().add(getMenuInventario());
        getMenuProveedores().setText( "Proveedores" );
        getMenuItemVerProveedores().setText( "Ver" );
        getMenuProveedores().add(getMenuItemVerProveedores());
        getMenuItemAgregarProveedor().setText( "Agregar" );
        getMenuProveedores().add(getMenuItemAgregarProveedor());
        getBarraMenuPrincipal().add(getMenuProveedores());
        getMenuVentas().setText( "Ventas" );
        getMenuItemVerVentas().setText( "Ver" );
        getMenuVentas().add(getMenuItemVerVentas());
        getMenuItemRealizarVenta().setText( "Realizar Venta" );
        getMenuVentas().add(getMenuItemRealizarVenta());
        getBarraMenuPrincipal().add(getMenuVentas());
        getMenuEmpleados().setText( "Empleados" );
        getMenuItemEmpleados().setText( "Ver" );
        getMenuEmpleados().add(getMenuItemEmpleados());
        getMenuItemAgregarEmpleado().setText( "Agregar" );
        getMenuEmpleados().add(getMenuItemAgregarEmpleado());
        getBarraMenuPrincipal().add(getMenuEmpleados());
        setJMenuBar(getBarraMenuPrincipal());
    }
    
    public final void cargarImagenDeFondo(){
        imagenDeFondo= VentanaPrincipal.class.getResourceAsStream("/imagenes/imagenDeFondo.jpg");
        BufferedImage imagenDeFondoImg = null;
        try {
            imagenDeFondoImg = ImageIO.read(imagenDeFondo);
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        Image dimensionImagen = imagenDeFondoImg.getScaledInstance(877, 500, Image.SCALE_SMOOTH);
        ImageIcon iconoImagen = new ImageIcon(dimensionImagen);
        setContentPane(new JLabel(iconoImagen));
    }
    
     public static void main(String[] args) {
         controladorVentanaPrincipal = new ControladorVentanaPrincipal();
         controladorVentanaPrincipal.inicializarVentanaPrincipal();

        
     }

    /**
     * @return the barraMenuPrincipal
     */
    public JMenuBar getBarraMenuPrincipal() {
        return barraMenuPrincipal;
    }

    /**
     * @param barraMenuPrincipal the barraMenuPrincipal to set
     */
    public void setBarraMenuPrincipal(JMenuBar barraMenuPrincipal) {
        this.barraMenuPrincipal = barraMenuPrincipal;
    }

    /**
     * @return the menuInventario
     */
    public JMenu getMenuInventario() {
        return menuInventario;
    }

    /**
     * @param menuInventario the menuInventario to set
     */
    public void setMenuInventario(JMenu menuInventario) {
        this.menuInventario = menuInventario;
    }

    /**
     * @return the menuProveedores
     */
    public JMenu getMenuProveedores() {
        return menuProveedores;
    }

    /**
     * @param menuProveedores the menuProveedores to set
     */
    public void setMenuProveedores(JMenu menuProveedores) {
        this.menuProveedores = menuProveedores;
    }

    /**
     * @return the menuVentas
     */
    public JMenu getMenuVentas() {
        return menuVentas;
    }

    /**
     * @param menuVentas the menuVentas to set
     */
    public void setMenuVentas(JMenu menuVentas) {
        this.menuVentas = menuVentas;
    }

    /**
     * @return the menuItemVerInventario
     */
    public JMenuItem getMenuItemVerInventario() {
        return menuItemVerInventario;
    }

    /**
     * @param menuItemVerInventario the menuItemVerInventario to set
     */
    public void setMenuItemVerInventario(JMenuItem menuItemVerArticulo) {
        this.menuItemVerInventario = menuItemVerArticulo;
    }

    /**
     * @return the menuItemAgregarArticulo
     */
    public JMenuItem getMenuItemAgregarArticulo() {
        return menuItemAgregarArticulo;
    }

    /**
     * @param menuItemAgregarInventario the menuItemAgregarArticulo to set
     */
    public void setMenuItemAgregarArticulo(JMenuItem menuItemAgregarArticulo) {
        this.menuItemAgregarArticulo = menuItemAgregarArticulo;
    }

    /**
     * @return the menuItemVerProveedores
     */
    public JMenuItem getMenuItemVerProveedores() {
        return menuItemVerProveedores;
    }

    /**
     * @param menuItemVerProveedores the menuItemVerProveedores to set
     */
    public void setMenuItemVerProveedores(JMenuItem menuItemVerProveedores) {
        this.menuItemVerProveedores = menuItemVerProveedores;
    }

    /**
     * @return the menuItemAgregarProveedor
     */
    public JMenuItem getMenuItemAgregarProveedor() {
        return menuItemAgregarProveedor;
    }

    /**
     * @param menuItemAgregarProveedor the menuItemAgregarProveedor to set
     */
    public void setMenuItemAgregarProveedor(JMenuItem menuItemAgregarProveedor) {
        this.menuItemAgregarProveedor = menuItemAgregarProveedor;
    }

    /**
     * @return the menuItemVerVentas
     */
    public JMenuItem getMenuItemVerVentas() {
        return menuItemVerVentas;
    }

    /**
     * @param menuItemVerVentas the menuItemVerVentas to set
     */
    public void setMenuItemVerVentas(JMenuItem menuItemVerVentas) {
        this.menuItemVerVentas = menuItemVerVentas;
    }

    /**
     * @return the menuItemRealizarVenta
     */
    public JMenuItem getMenuItemRealizarVenta() {
        return menuItemRealizarVenta;
    }

    /**
     * @param menuItemRealizarVenta the menuItemRealizarVenta to set
     */
    public void setMenuItemRealizarVenta(JMenuItem menuItemRealizarVenta) {
        this.menuItemRealizarVenta = menuItemRealizarVenta;
    }

    public JMenuItem getMenuItemAgregarEmpleado() {
        return menuItemAgregarEmpleado;
    }

    public JMenuItem getMenuItemEmpleados() {
        return menuItemVerEmpleados;
    }

    public JMenu getMenuEmpleados() {
        return menuClientes;
    }

    public void setMenuEmpleados(JMenu menuClientes) {
        this.menuClientes = menuClientes;
    }

    public void setMenuItemAgregarEmpleado(JMenuItem menuItemAgregarEmpleado) {
        this.menuItemAgregarEmpleado = menuItemAgregarEmpleado;
    }

    public void setMenuItemVerEmpleados(JMenuItem menuItemVerEmpleado) {
        this.menuItemVerEmpleados = menuItemVerEmpleado;
    }
    
    
     
 }
