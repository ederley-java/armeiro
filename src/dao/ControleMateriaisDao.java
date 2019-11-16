package dao;

import models.Controle;
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
        String sql = "INSERT into cargadiaria (dia, codarmeiro, codguarda, codproduto, observacao, dia1, hora1, cautelado, dia2, hora2) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1, p1.getDataArmeiroControle());
        stmt.setString(2, p1.getArmeiroControle());
        stmt.setString(3, p1.getAgenteControle());
        stmt.setString(4, p1.getCodproduto());
        stmt.setString(5, p1.getObservacao());
        stmt.setString(6, p1.getDia1());
        stmt.setString(7, p1.getHora1());
        stmt.setBoolean(8, p1.isCautelado());
        stmt.setString(9, p1.getDia2());
        stmt.setString(10, p1.getHora2());
     
        stmt.execute();
        stmt.close();
    }
    
    public List<Controle> getLista(String codArmeiro) throws SQLException{
        String sql = "select ca.id,\n" +
        "ar.nome,\n" +
        "gu.nome,\n" +
        "ca.dia,\n" +
        "pr.cod,\n" +
        "ca.observacao,\n" +
        "ca.dia1,\n" +
        "ca.hora1,\n" +
        "ca.cautelado,\n" +
        "ca.dia2,\n" +
        "ca.hora2\n" +
        "from cargadiaria ca\n" +
        "inner join guardas ar on (ar.id = ca.codArmeiro)\n" +
        "inner join guardas gu on (gu.id = ca.codGuarda)\n" +
        "inner join produto pr on (pr.id = ca.codProduto)\n" +
        "where ca.codArmeiro like  ? and ca.cautelado = ? order by 1";

        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, codArmeiro);
        stmt.setBoolean(2, true);
        ResultSet rs = stmt.executeQuery();
        
        List<Controle> minhaListaControle = new ArrayList<Controle>();
        
        while(rs.next()){
            Controle controle = new Controle();
            controle.setId(rs.getInt("Id"));  
            controle.setDataArmeiroControle(rs.getString("dia"));
            controle.setArmeiroControle(rs.getString("nome"));
            controle.setAgenteControle(rs.getString("nome"));
            controle.setCodproduto(rs.getString("cod"));
            controle.setObservacao(rs.getString("observacao"));       
            controle.setDia1(rs.getString("dia1"));
            controle.setHora1(rs.getString("hora1"));
            controle.setCautelado(rs.getBoolean("cautelado"));
            controle.setDia2(rs.getString("dia2"));
            controle.setHora2(rs.getString("hora2"));
          
            minhaListaControle.add(controle);
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
        stmt.setBoolean(8, p1.isCautelado());
        stmt.setString(9, p1.getDia2());
        stmt.setString(9, p1.getHora2());
               
        // executa o codigo sql
        stmt.execute();
        stmt.close();   
    }
            
    public void remove(Controle c1) throws SQLException{
        String sql = "delete from cargadiaria where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setBoolean(1, c1.isCautelado());                 // remover esse metodo todo por nao ser necessario.
        stmt.execute();
        stmt.close();
        
    }
    
     public void EntregaProduto(Controle p1) throws SQLException{
        // prepara a conexao com oo banco
        String sql = "update cargadiaria set cautelado=? where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql); // tem que arruma esse comando SQL
        
        // seta os valores 
        stmt.setBoolean(1, p1.isCautelado());
        stmt.setInt(2, p1.getId());

        // executa o codigo sql
        stmt.execute();
        stmt.close();
    }
         
   
  
    
    
    
}
