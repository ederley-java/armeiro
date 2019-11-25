package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.CargaDiaria;
import models.Produto;
import models.Usuario;

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
        // TODO ZECA
        // stmt.setString(2, cargaDiaria.getArmeiro());
        // stmt.setString(3, cargaDiaria.getGuarda());
        // stmt.setString(4, cargaDiaria.getProduto());
        stmt.setString(5, cargaDiaria.getObservacao());
        stmt.setDate(6, new Date(cargaDiaria.getCreatedAt().getTime()));
        stmt.setBoolean(8, cargaDiaria.isCautelado());
        stmt.setString(9, cargaDiaria.getDia2());
        stmt.setString(10, cargaDiaria.getHora2());
     
        stmt.execute();
        stmt.close();
    }
    
    public List<CargaDiaria> getLista(String idArmeiro) throws SQLException{
        String sql = "select carga.id,\n" +
        
        "armeiro.id   as id_armeiro,\n" +
        "armeiro.nome as nome_armeiro,\n" +
        
        "carga.dia,\n" +
        
        "guarda.id   as id_guarda,\n" +
        "guarda.nome as nome_guarda,\n" +
        
        "prod.id as id_produto,\n" +
        "prod.cod as cod_produto,\n" +
        
        "carga.observacao,\n" +
        "carga.created_at,\n" +
        "carga.cautelado,\n" +
        "carga.dia2,\n" +
        "carga.hora2\n" +

        "from carga_diaria carga\n" +
        "inner join guarda  armeiro on (armeiro.id = carga.id_armeiro)\n" +
        "inner join guarda  guarda  on (guarda.id  = carga.id_guarda)\n" +
        "inner join produto prod    on (prod.id    = carga.id_produto)\n" +
        
        "where carga.id_armeiro like ? and carga.cautelado = ? order by 1";

        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, idArmeiro);
        stmt.setBoolean(2, true);
        
        List<CargaDiaria> lista = new ArrayList<CargaDiaria>();
        
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            CargaDiaria cargaDiaria = new CargaDiaria();

            cargaDiaria.setId(rs.getInt("Id"));  

            cargaDiaria.setDataArmeiroControle(rs.getString("dia"));
            
            Usuario armeiro = new Usuario();
            armeiro.setId(rs.getInt("id_armeiro"));
            armeiro.setNome(rs.getString("nome_armeiro"));
            cargaDiaria.setArmeiro(armeiro);

            Usuario guarda = new Usuario();
            guarda.setId(rs.getInt("id_guarda"));
            guarda.setNome(rs.getString("nome_guarda"));
            cargaDiaria.setGuarda(guarda);

            Produto produto = new Produto();
            produto.setId(rs.getInt("id_produto"));
            produto.setCodigo(rs.getString("cod_produto"));
            cargaDiaria.setProduto(produto);

            cargaDiaria.setObservacao(rs.getString("observacao"));

            Date createdAt = new Date(rs.getTimestamp("created_at").getTime());
            cargaDiaria.setCreatedAt(createdAt);

            cargaDiaria.setDia2(rs.getString("dia2"));
            cargaDiaria.setHora2(rs.getString("hora2"));
            cargaDiaria.setCautelado(rs.getBoolean("cautelado"));
          
            lista.add(cargaDiaria);
       }

       rs.close();
       stmt.close();
       return lista;
    }
      
       public void altera (CargaDiaria cargaDiaria) throws SQLException{
        String sql = "update carga_diaria set nome_armeiro=?, dia=?, nomeGuarda=?, pt58=?, carregador=?, municao=?, spark=?, vtr=?" +
         ",cal12=?, municao12=?, bandoleira=?, tablet=?, impressora=?, guia=?, diversos=?, created_at=?, dia2=?, hora2=? where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        // seta os valores 
        stmt.setString(1, cargaDiaria.getDataArmeiroControle());
        // TODO ZECA
        // stmt.setString(2, cargaDiaria.getArmeiro());
        // stmt.setString(3, cargaDiaria.getGuarda());
        // stmt.setString(4, cargaDiaria.getProduto());
        stmt.setString(5, cargaDiaria.getObservacao());
        stmt.setDate(6, new Date(cargaDiaria.getCreatedAt().getTime()));
        stmt.setBoolean(8, cargaDiaria.isCautelado());
        stmt.setString(9, cargaDiaria.getDia2());
        stmt.setString(9, cargaDiaria.getHora2());
               
        // executa o codigo sql
        stmt.execute();
        stmt.close();   
    }
            
    public void remove(CargaDiaria cargaDiaria) throws SQLException{
        String sql = "delete from carga_diaria where id=?";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setBoolean(1, cargaDiaria.isCautelado());                 // remover esse metodo todo por nao ser necessario.
        stmt.execute();
        stmt.close();
    }
    
     public void EntregaProduto(CargaDiaria cargaDiaria) throws SQLException{
        // prepara a conexao com oo banco
        String sql = "update carga_diaria set cautelado=? where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql); // tem que arruma esse comando SQL
        
        // seta os valores 
        stmt.setBoolean(1, cargaDiaria.isCautelado());
        stmt.setInt(2, cargaDiaria.getId());

        // executa o codigo sql
        stmt.execute();
        stmt.close();
    }
}
