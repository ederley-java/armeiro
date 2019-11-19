/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Interface.CriaConexao;
import Interface.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lemes
 */
public class LoginDao {
    
    private Connection conexao;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public LoginDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }
        
     public void logar(LoginBean c1){
        String sql = "select * from login where usuario=? and senha=?";
        try{
            pst = conexao.prepareStatement(sql);
            pst.setString(1, c1.getUsuario());
            pst.setString(2, c1.getSenha());
            
            rs = pst.executeQuery();
            if (rs.next()){
                Principal tela = new Principal();
                tela.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Usuário ou Senha Inválido!");
            }
           
        }
        catch (Exception e){
            
        }
        
         
     }
    
    
}
