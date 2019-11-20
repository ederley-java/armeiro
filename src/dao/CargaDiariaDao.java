package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.CargaDiaria;

/**
 *
 * @author Lemes
 */
public class CargaDiariaDao {
    private Connection conexao;
    
    public CargaDiariaDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }
    
    public void adiciona (CargaDiaria cargaDiaria) throws SQLException{
        String sql = "INSERT INTO carga_diaria (dia, id_armeiro, id_guarda, id_produto, observacao, created_at, cautelado, dia2, hora2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1, cargaDiaria.getDataArmeiroControle());
        stmt.setString(2, cargaDiaria.getArmeiroControle());
        stmt.setString(3, cargaDiaria.getAgenteControle());
        stmt.setString(4, cargaDiaria.getCodproduto());
        stmt.setString(5, cargaDiaria.getObservacao());
        stmt.setDate(6, cargaDiaria.getCreatedAt());
        stmt.setBoolean(8, cargaDiaria.isCautelado());
        stmt.setString(9, cargaDiaria.getDia2());
        stmt.setString(10, cargaDiaria.getHora2());
     
        stmt.execute();
        stmt.close();
    }
    
    public List<CargaDiaria> getLista(String idArmeiro) throws SQLException{
        String sql = "select ca.id,\n" +
        "ar.nome as armeiro,\n" +
        "gu.nome as guarda,\n" +
        "ca.dia,\n" +
        "pr.cod,\n" +
        "ca.observacao,\n" +
        "ca.created_at,\n" +
        "ca.cautelado,\n" +
        "ca.dia2,\n" +
        "ca.hora2\n" +
        "from carga_diaria ca\n" +
        "inner join guarda ar on (ar.id = ca.id_armeiro)\n" +
        "inner join guarda gu on (gu.id = ca.id_guarda)\n" +
        "inner join produto pr on (pr.id = ca.id_produto)\n" +
        "where ca.id_armeiro like  ? and ca.cautelado = ? order by 1";

        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, idArmeiro);
        stmt.setBoolean(2, true);
        ResultSet rs = stmt.executeQuery();
        
        List<CargaDiaria> minhaListaControle = new ArrayList<CargaDiaria>();
        
        while(rs.next()){
            CargaDiaria cargaDiaria = new CargaDiaria();

            cargaDiaria.setId(rs.getInt("Id"));  
            cargaDiaria.setDataArmeiroControle(rs.getString("dia"));
            cargaDiaria.setArmeiroControle(rs.getString("armeiro"));
            cargaDiaria.setAgenteControle(rs.getString("guarda"));
            cargaDiaria.setCodproduto(rs.getString("cod"));
            
            cargaDiaria.setObservacao(rs.getString("observacao"));
            cargaDiaria.setCreatedAt(rs.getDate("created_at"));
            cargaDiaria.setDia2(rs.getString("dia2"));
            cargaDiaria.setHora2(rs.getString("hora2"));
            cargaDiaria.setCautelado(rs.getBoolean("cautelado"));
          
            minhaListaControle.add(cargaDiaria);
       }

       rs.close();
       stmt.close();
       return minhaListaControle;
    }
      
       public void altera (CargaDiaria p1) throws SQLException{
        String sql = "update carga_diaria set nome_armeiro=?, dia=?, nomeGuarda=?, pt58=?, carregador=?, municao=?, spark=?, vtr=?" +
         ",cal12=?, municao12=?, bandoleira=?, tablet=?, impressora=?, guia=?, diversos=?, created_at=?, dia2=?, hora2=? where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        // seta os valores 
        stmt.setString(1, p1.getDataArmeiroControle());
        stmt.setString(2, p1.getArmeiroControle());
        stmt.setString(3, p1.getAgenteControle());     // veificar esse metodo pois deve estar errado, nao pode ser update livro parte...
        stmt.setString(4, p1.getCodproduto());
        stmt.setString(5, p1.getObservacao());
        stmt.setDate(6, p1.getCreatedAt());
        stmt.setBoolean(8, p1.isCautelado());
        stmt.setString(9, p1.getDia2());
        stmt.setString(9, p1.getHora2());
               
        // executa o codigo sql
        stmt.execute();
        stmt.close();   
    }
            
    public void remove(CargaDiaria c1) throws SQLException{
        String sql = "delete from carga_diaria where id=?";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setBoolean(1, c1.isCautelado());                 // remover esse metodo todo por nao ser necessario.
        stmt.execute();
        stmt.close();
    }
    
     public void EntregaProduto(CargaDiaria p1) throws SQLException{
        // prepara a conexao com oo banco
        String sql = "update carga_diaria set cautelado=? where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql); // tem que arruma esse comando SQL
        
        // seta os valores 
        stmt.setBoolean(1, p1.isCautelado());
        stmt.setInt(2, p1.getId());

        // executa o codigo sql
        stmt.execute();
        stmt.close();
    }
         
   
  
    
    
    
}
