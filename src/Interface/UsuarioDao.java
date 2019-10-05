/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import ronaldo.bancodados.CriaConexao;
//import ronaldo.logica.Contato;



/**
 *
 * @author Lemes
 */
public class UsuarioDao {
    
     
    private Connection conexao;
    
    public UsuarioDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }
    
    public void adiciona (Usuario c1) throws SQLException{
        // prepara a conexao com oo banco
        String sql = "insert into guardas (matricula, nome, endereco, telefone, email, sexo, situacao )" + "values (?,?,?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        // seta os valores 
        stmt.setLong(1, c1.getMatricula());
        stmt.setString(2, c1.getNome());
        stmt.setString(3, c1.getEndereco());
        stmt.setString(4, c1.getTelefone());
        stmt.setString(5, c1.getEmail());
        stmt.setString(6, c1.getSexo());
        stmt.setString(7, c1.getSituacao());
        
        // executa o codigo sql
        stmt.execute();
        stmt.close();
    }
    
    public List<Usuario> getLista(String nome) throws SQLException{
        System.out.println("chamada do metodo:  public List<Usuario> getLista(String nome) ");
        
        String sql = "select * from guardas where nome like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        
        List<Usuario> minhaLista = new ArrayList<Usuario>();
        
        while(rs.next()){
            Usuario c1 = new Usuario();
            c1.setIdUsuario(rs.getInt("id"));
            c1.setMatricula(Long.valueOf(rs.getString("matricula")));
            c1.setNome(rs.getString("nome"));
            c1.setEndereco(rs.getString("endereco"));
            c1.setTelefone(rs.getString("telefone"));
            c1.setEmail(rs.getString("email"));
            c1.setSexo(rs.getString("sexo"));
            c1.setSituacao(rs.getString("situacao"));
            minhaLista.add(c1);
       }
        rs.close();
        stmt.close();
        return minhaLista;
    }
    
       public void altera (Usuario c1) throws SQLException{
        String sql = "update guardas set nome=?, endereco=?, telefone=?, email=?" +
                ",sexo=?, situacao=? where matricula=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        // seta os valores 
        stmt.setString(1, c1.getNome());
        stmt.setString(2, c1.getEndereco());
        stmt.setString(3, c1.getTelefone());
        stmt.setString(4, c1.getEmail());
        stmt.setString(5, c1.getSexo());
        stmt.setString(6, c1.getSituacao());
        stmt.setLong(7, c1.getMatricula());
        
        // executa o codigo sql
        stmt.execute();
        stmt.close();
        
    }
    
    public void remove(Usuario c1) throws SQLException{
        String sql = "delete from guardas where matricula=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setLong(1, c1.getMatricula());
        stmt.execute();
        stmt.close();
          
    }
}