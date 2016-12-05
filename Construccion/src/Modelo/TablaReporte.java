/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Noe
 */
public class TablaReporte {
    private String[] encabezados;
    private ArrayList<Object[]> filasDatos;

    public TablaReporte() {
        filasDatos = new ArrayList<Object[]>();
    }

    /**
     * @return the encabezados
     */
    public String[] getEncabezados() {
        return encabezados;
    }

    /**
     * @param encabezados the encabezados to set
     */
    public void setEncabezados(String[] encabezados) {
        this.encabezados = encabezados;
    }

   public void agregarFila(Object[] datos){
       filasDatos.add(datos);
   }
   
   public Object[] getFila(int numFila){
      return filasDatos.get(numFila);
   }
   
   public int tamaño(){
       return filasDatos.size();
   }
   
   public ArrayList<Object> getFilasDatos(){
       return (ArrayList<Object>) filasDatos.clone();
   }

    
    
    
}
