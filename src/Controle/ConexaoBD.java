/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Lemes
 */
public class ConexaoBD {
    
    public Statement stm;
    public ResultSet rs;
    private String driver;
    private String caminho;
    private String usuario;
    private String senha;
    public Connection con;
    
}
