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

/**
 *
 * @author Lemes
 */
public class ControleMateriaisDao {
         private Connection conexao;
    
    public ControleMateriaisDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }
    
   
    
    public void adiciona (Controle p1) throws SQLException{
        // prepara a conexao com oo banco
        String sql = "INSERT into cargadiaria (dia, nomearmeiro, nomeguarda, codproduto, observacao, dia1, hora1, devolvido, dia2, hora2) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        // seta os valores 
        stmt.setString(1, p1.getDataArmeiroControle());
        stmt.setString(2, p1.getArmeiroControle());
        stmt.setString(3, p1.getAgenteControle());
        stmt.setString(4, p1.getCodproduto());
        stmt.setString(5, p1.getObservacao());
        stmt.setString(6, p1.getDia1());
        stmt.setString(7, p1.getHora1());
        stmt.setBoolean(8, p1.getDevolvido());
        stmt.setString(9, p1.getDia2());
        stmt.setString(10, p1.getHora2());
        
     
        stmt.execute();
        stmt.close();
    }
    
    public List<Controle> getLista(String nomeArmeiro) throws SQLException{
        System.out.println("chamada do metodo:  public List<ControleMateriais> getLista(String nomeArmeiro) ");
        String sql = "select * from cargadiaria where nomeArmeiro like  ? and devolvido = ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nomeArmeiro);
        stmt.setBoolean(2, true);
        ResultSet rs = stmt.executeQuery();
        
        List<Controle> minhaListaControle = new ArrayList<Controle>();
        
        while(rs.next()){
            Controle c1 = new Controle();
            c1.setId(rs.getInt("Id"));  // c1.setId(Integer.toString(rs.getInt("Id")));   conversao de string para int, para enviar ao banco, nao necessario.
            c1.setDataArmeiroControle(rs.getString("dia"));
            
            UsuarioDao usuariodao = new UsuarioDao();
            List<Usuario> usuarios =   usuariodao.pesquisarPorId(rs.getString("nomeArmeiro"));
            c1.setArmeiroControle(usuarios.get(0).getNome());
            
            //c1.setArmeiroControle(rs.getString("nomeArmeiro"));
            
            c1.setAgenteControle(rs.getString("nomeGuarda"));
            c1.setCodproduto(rs.getString("codproduto"));
            c1.setObservacao(rs.getString("observacao"));       //c1.setPistolaControleDv(rs.getBoolean("pt58dv")); <-metodo boolean
            c1.setDia1(rs.getString("dia1"));
            c1.setHora1(rs.getString("hora1"));
            c1.setDevolvido(rs.getBoolean("devolvido"));
            c1.setDia2(rs.getString("dia2"));
            c1.setHora2(rs.getString("hora2"));
          
                   
            minhaListaControle.add(c1);
       }
        rs.close();
        stmt.close();
        return minhaListaControle;
    }
      
       public void altera (Controle p1) throws SQLException{
        String sql = "update cargadiaria set nomeArmeiro=?, dia=?, nomeGuarda=?, pt58=?, carregador=?, municao=?, spark=?, vtr=?" +
         ",cal12=?, municao12=?, bandoleira=?, tablet=?, impressora=?, guia=?, diversos=?, dia1=?, hora1=?, dia2=?, hora2=? where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        // seta os valores 
        stmt.setString(1, p1.getDataArmeiroControle());
        stmt.setString(2, p1.getArmeiroControle());
        stmt.setString(3, p1.getAgenteControle());     // veificar esse metodo pois deve estar errado, nao pode ser update livro parte...
        stmt.setString(4, p1.getCodproduto());
        stmt.setString(5, p1.getObservacao());
        stmt.setString(6, p1.getDia1());
        stmt.setString(7, p1.getHora1());
        stmt.setBoolean(8, p1.getDevolvido());
        stmt.setString(9, p1.getDia2());
        stmt.setString(9, p1.getHora2());
               
        // executa o codigo sql
        stmt.execute();
        stmt.close();   
    }
            
    public void remove(Controle c1) throws SQLException{
        String sql = "delete from cargadiaria where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setBoolean(1, c1.getDevolvido());                 // remover esse metodo todo por nao ser necessario.
        stmt.execute();
        stmt.close();
        
    }
    
     public void EntregaProduto(Controle p1) throws SQLException{
        // prepara a conexao com oo banco
        String sql = "update cargadiaria set devolvido=? where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql); // tem que arruma esse comando SQL
        
        // seta os valores 
        stmt.setBoolean(1, p1.getDevolvido());
        stmt.setInt(2, p1.getId());

        // executa o codigo sql
        stmt.execute();
        stmt.close();
    }
         
   
  
    
    
    
}
