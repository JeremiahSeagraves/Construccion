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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigopeniche
 */
public class AdministradorEmpleados implements Administrador {
    
    private final AccesoBDEmpleados accesoBDEmpleados;
    
    public AdministradorEmpleados(){
        accesoBDEmpleados = new AccesoBDEmpleados();
    }

    @Override
    public void agregar(Object registro) {
        try{
            accesoBDEmpleados.insertarEmpleado((Empleado) registro);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdministradorEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Object registro) {
        try{
            accesoBDEmpleados.eliminarEmpleado((String) registro);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdministradorEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object buscar(Object registro) {
        Empleado empleado = null;
        try{
            empleado = accesoBDEmpleados.buscarEmpleado((String)registro);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdministradorEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return empleado;
    }

    @Override
    public void actualizar(Object registro) {
        try{
            accesoBDEmpleados.actualizarProveedor((Empleado) registro);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdministradorEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Empleado> obtenerDatos() {
        ArrayList<Empleado> empleados = null;
        
        try{
            empleados = accesoBDEmpleados.obtenerEmpleados();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdministradorEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return empleados;
    }
    
}
