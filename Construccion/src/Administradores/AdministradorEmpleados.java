/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administradores;

import Modelo.Datos.AccesoBDEmpleados;
import Modelo.Empleado;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author rodrigopeniche
 */
public class AdministradorEmpleados implements Administrador {
    
    private final AccesoBDEmpleados accesoBDEmpleados;
    private final String adminContrasena;
    
    public AdministradorEmpleados(){
        accesoBDEmpleados = new AccesoBDEmpleados();
        adminContrasena = "theironhorse";
    }

    @Override
    public void agregar(Object registro) {
        try{
            accesoBDEmpleados.insertarEmpleado((Empleado) registro);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar el empleado");
        }
    }

    @Override
    public void eliminar(Object registro) {
        try{
            accesoBDEmpleados.eliminarEmpleado((String) registro);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el empleado");
        }
    }

    @Override
    public Object buscar(Object registro) {
        Empleado empleado = null;
        try{
            empleado = accesoBDEmpleados.buscarEmpleado((String)registro);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el empleado");
        }
        
        return empleado;
    }

    @Override
    public void actualizar(Object registro) {
        try{
            accesoBDEmpleados.actualizarProveedor((Empleado) registro);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el empleado");
        }
    }

    @Override
    public ArrayList<Empleado> obtenerDatos() {
        ArrayList<Empleado> empleados = null;
        
        try{
            empleados = accesoBDEmpleados.obtenerEmpleados();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos de los empleados");
        }
        
        return empleados;
    }

    public String getAdminContrasena() {
        return adminContrasena;
    }
    
    
    
}
