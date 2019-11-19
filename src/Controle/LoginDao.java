/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Interface.CriaConexao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Lemes
 */
public class LoginDao {
    
     private Connection conexao;
    
    public LoginDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }
    
    
     public void logar(LoginBean c1){
         String sql = "d from guardas where matricula=?";
         
         
     }
    
    
}
