package dao;

import models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
*
* @author Lemes
*/
public class UsuarioDao {
    private Connection conexao;
    Connection con = null;
    String sql;
    ResultSet rs;
    PreparedStatement pstm;
    
    public UsuarioDao() throws SQLException {
        this.conexao = CriaConexao.getConexao();
    }
    
    public void adiciona(Usuario usuario) throws SQLException {
        // prepara a conexao com oo banco
        String sql = "INSERT into guarda (matricula, nome, endereco, telefone, email, sexo, situacao )"
        + "values (?,?,?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        // seta os valores
        stmt.setLong(1, usuario.getMatricula());
        stmt.setString(2, usuario.getNome());
        stmt.setString(3, usuario.getEndereco());
        stmt.setString(4, usuario.getTelefone());
        stmt.setString(5, usuario.getEmail());
        stmt.setString(6, usuario.getSexo());
        stmt.setString(7, usuario.getSituacao());
        
        // executa o codigo sql
        stmt.execute();
        stmt.close();
    }
    
    public List<Usuario> getLista(String nome) throws SQLException {
        String sql = "SELECT * from guarda WHERE nome like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        
        List<Usuario> minhaLista = new ArrayList<Usuario>();
        
        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setMatricula(Long.valueOf(rs.getString("matricula")));
            usuario.setNome(rs.getString("nome"));
            usuario.setEndereco(rs.getString("endereco"));
            usuario.setTelefone(rs.getString("telefone"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSexo(rs.getString("sexo"));
            usuario.setSituacao(rs.getString("situacao"));
            minhaLista.add(usuario);
        }
        
        rs.close();
        stmt.close();
        return minhaLista;
    }
    
    public void altera(Usuario usuario) throws SQLException {
        String sql = "UPDATE guarda set nome=?, endereco=?, telefone=?, email=?"
        + ",sexo=?, situacao=? WHERE matricula=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEndereco());
        stmt.setString(3, usuario.getTelefone());
        stmt.setString(4, usuario.getEmail());
        stmt.setString(5, usuario.getSexo());
        stmt.setString(6, usuario.getSituacao());
        stmt.setLong(7, usuario.getMatricula());
        
        stmt.execute();
        stmt.close();
    }
    
    public void remove(Usuario usuario) throws SQLException {
        String sql = "DELETE FROM guarda WHERE matricula=?";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setLong(1, usuario.getMatricula());
        
        stmt.execute();
        stmt.close();
    }
    
    public List<Usuario> listarGuardas() {
        ArrayList<Usuario> listUser = new ArrayList<>();
        
        try {
            con = CriaConexao.getConexao();
            sql = "SELECT id, nome FROM guarda ORDER BY id ASC";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery(sql);
            
            while (rs.next()) {
                Usuario usuario = new Usuario();
                
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                listUser.add(usuario);
            }
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro PSTM " + erro.getMessage());
        }
        
        return listUser;
    }
    
    public Usuario getByMatricula(String matricula) throws SQLException {
        String sql = "SELECT * from guarda WHERE matricula = ?;";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, matricula);
        
        ResultSet rs = stmt.executeQuery();
        
        Usuario usuario = null;
        while (rs.next()) {
            usuario = new Usuario();

            usuario.setId(rs.getInt("id"));
        }
        
        rs.close();
        stmt.close();
        
        return usuario;
    }
}
