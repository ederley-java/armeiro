<<<<<<< master
package dao;

import Interface.CriaConexao;
import Interface.Principal;
import Interface.TelaCadastroLogin;
import Interface.TelaLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import controllers.Principal;
import dao.CriaConexao;
import models.Login;

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
        
     public void logar(Login login) {
        String sql = "select * from login where usuario=? and senha=?;";
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, login.getUsuario());
            pst.setString(2, login.getSenha());
            
            rs = pst.executeQuery();
            if (rs.next()) {
                Principal tela = new Principal();
                tela.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválido!");
            }
           
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Não foi possível acessar o sistema!");
        }
    }
        
    public void CadastrarUsuario(LoginBean c1){
        String sql = "select * from login where usuario=? and senha=?";
        try{
            pst = conexao.prepareStatement(sql);
            pst.setString(1, c1.getUsuario());
            pst.setString(2, c1.getSenha());
            rs = pst.executeQuery();
            if (rs.next()){
                TelaCadastroLogin cadastro = new TelaCadastroLogin();
                cadastro.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Usuário ou Senha Inválido!");
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Não foi possível cadastrar!");
        }
    }
    
    public void CadastrarUsuarioNovo(LoginBean c1){
        String sql = "INSERT INTO login (usuario, senha) values (?,?)";
               
         try{
            pst = conexao.prepareStatement(sql);
            pst.setString(1, c1.getUsuario());
            pst.setString(2, c1.getSenha());
            
            int i = pst.executeUpdate();
            if (i == 1) {
                TelaLogin log = new TelaLogin();
                log.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Usuário ou Senha Inválido!");
            }
         } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Não foi possível salvar!");
        } 
    }
}
=======
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import interfaces.Principal;
import dao.CriaConexao;
import models.LoginDTO;

/**
 *
 * @author Lemes
 */
public class LoginDao {
    private Connection conexao;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    
    public LoginDao() throws SQLException {
        this.conexao = CriaConexao.getConexao();
    }
        
    public void logar(LoginDTO login) {
        String sql = "select * from login where usuario=? and senha=?;";
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, login.getUsuario());
            pst.setString(2, login.getSenha());
            
            rs = pst.executeQuery();
            if (rs.next()) {
                Principal tela = new Principal();
                tela.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválido!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
>>>>>>> Organizando projeto
