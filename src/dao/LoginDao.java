package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import dao.CriaConexao;
import interfaces.TelaLogin;
import interfaces.TelaPrincipal;
import interfaces.TelaCadastroLogin;
import models.LoginDTO;
import models.Usuario;

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
        
     public void logar(LoginDTO login) {
        String sql = "SELECT g.* FROM guarda g JOIN login l ON (g.id_login = l.id)"
            + "WHERE l.usuario=? and l.senha=?;";

        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, login.getUsuario());
            pst.setString(2, login.getSenha());
            
            rs = pst.executeQuery();
            if (rs.next()) {
                Usuario armeiro = new Usuario();
                armeiro.setId(rs.getInt("id"));
                armeiro.setMatricula(Long.valueOf(rs.getString("matricula")));
                armeiro.setNome(rs.getString("nome"));
                armeiro.setEndereco(rs.getString("endereco"));
                armeiro.setTelefone(rs.getString("telefone"));
                armeiro.setEmail(rs.getString("email"));
                armeiro.setSexo(rs.getString("sexo"));
                armeiro.setSituacao(rs.getString("situacao"));

                TelaPrincipal tela = new TelaPrincipal(armeiro);
                 tela.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválido!");
            }
           
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o sistema!");
        }
    }
        
    public void CadastrarUsuario(LoginDTO c1){
        String sql = "SELECT * from login WHERE usuario=? and senha=?";
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
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar!");
        }
    }
    
    public void CadastrarUsuarioNovo(LoginDTO c1){
        String sql = "INSERT INTO login (usuario, senha) values (?,?)";
               
         try{
            pst = conexao.prepareStatement(sql);
            pst.setString(1, c1.getUsuario());
            pst.setString(2, c1.getSenha());
            
            int i = pst.executeUpdate();
            if (i == 1) {              
                TelaLogin log = new TelaLogin();
                log.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválido!");
            }
         } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possível salvar!");
        } 
    }
}
