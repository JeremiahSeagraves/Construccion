/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administradores;

/**
 *
 * @author Jeremiah
 */
public interface Administrador {
    
    public void agregar( Object registro );
    public void eliminar( Object registro );
    public Object buscar( Object registro );
    public void actualizar( Object registro );
    public Object obtenerDatos( );
    
}
