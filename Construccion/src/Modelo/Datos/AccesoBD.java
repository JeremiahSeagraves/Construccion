/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author rodrigopeniche
 */
class AccesoBD {
    
    protected static Connection conexionBD;
    protected String consultaBD;
    protected Statement sentenciaConsulta;
    
    protected static final String COMANDO_SELECT = "SELECT ";
    protected static final String COMANDO_FROM = " FROM ";
    protected static final String COMANDO_INSERT = "INSERT ";
    protected static final String COMANDO_INTO = " INTO ";
    protected static final String COMANDO_VALUES = " VALUES ";
    protected static final String COMANDO_DELETE = " DELETE ";
    protected static final String COMANDO_WHERE = " WHERE ";
    protected static final String COMANDO_UPDATE = " UPDATE ";
    protected static final String COMANDO_SET = " SET ";
    protected static final String COMANDO_ALL = "*";
    
}
