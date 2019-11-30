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
    
    public void adiciona(CargaDiaria cargaDiaria) throws SQLException {
        String sql = "INSERT INTO carga_diaria (\n" +
        "id_armeiro,\n" +
        "id_guarda,\n" +
        "id_produto,\n" +
        "dia,\n" +
        "observacao,\n" +
        "created_at,\n" +
        "cautelado,\n" +
        "dia2,\n" +
        "hora2\n" +
        ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setInt(1, cargaDiaria.getArmeiro().getId());
        stmt.setInt(2, cargaDiaria.getGuarda().getId());
        stmt.setInt(3, cargaDiaria.getProduto().getId());
        stmt.setString(4, cargaDiaria.getDataArmeiroControle());
        stmt.setString(5, cargaDiaria.getObservacao());

        java.util.Date now = new java.util.Date();
        Date createdAt = new Date(now.getTime());
        stmt.setDate(6, createdAt);
        
        stmt.setBoolean(7, cargaDiaria.isCautelado());
        stmt.setString(8, cargaDiaria.getDia2());
        stmt.setString(9, cargaDiaria.getHora2());
     
        stmt.execute();
        stmt.close();
    }
    
    public List<CargaDiaria> getLista(String idArmeiro) throws SQLException{
        String sql = "SELECT carga.id,\n" +

        "armeiro.id   as id_armeiro,\n" +
        "armeiro.nome as nome_armeiro,\n" +

        "carga.dia,\n" +

        "guarda.id   as id_guarda,\n" +
        "guarda.nome as nome_guarda,\n" +

        "prod.id as id_produto,\n" +
        "prod.cod as cod_produto,\n" +
        
        "carga.observacao,\n" +
        "MAX(carga.created_at) as created_at,\n" +
        "carga.dia2,\n" +
        "carga.hora2\n" +

        "from carga_diaria carga\n" +
        "LEFT JOIN carga_diaria devolvido ON (\n" +
        "    devolvido.id_armeiro = carga.id_armeiro AND\n" +
        "    devolvido.id_guarda  = carga.id_guarda  AND\n" +
        "    devolvido.id_produto = carga.id_produto AND\n" +
        "    devolvido.cautelado  = 0\n" +
        ")\n" +
        "JOIN guarda  armeiro on (armeiro.id = carga.id_armeiro)\n" +
        "JOIN guarda  guarda  on (guarda.id  = carga.id_guarda)\n" +
        "JOIN produto prod    on (prod.id    = carga.id_produto)\n" +
        
        "WHERE carga.id_armeiro like ? and carga.cautelado = ? AND devolvido.id IS NULL \n" +
        "GROUP BY 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12 \n" +
        "ORDER BY 4, 10, 3, 6";

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
          
            lista.add(cargaDiaria);
       }

       rs.close();
       stmt.close();

       return lista;
    }
      
    public void altera(CargaDiaria cargaDiaria) throws SQLException {

        String sql = "UPDATE carga_diaria SET \n" +
        "id_armeiro=?,\n" +
        "id_guarda=?,\n" +
        "id_produto=?,\n" +
        "observacao=?,\n" +
        "cautelado=?,\n" +
        "dia=?,\n" +
        "created_at=?,\n" +
        "dia2=?,\n" +
        "hora2=?\n" +
        " WHERE id=?";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setInt(1, cargaDiaria.getArmeiro().getId());
        stmt.setInt(2, cargaDiaria.getGuarda().getId());
        stmt.setInt(3, cargaDiaria.getProduto().getId());
        stmt.setString(4, cargaDiaria.getObservacao());
        stmt.setBoolean(5, cargaDiaria.isCautelado());
        stmt.setString(6, cargaDiaria.getDataArmeiroControle());
        stmt.setDate(7, new Date(cargaDiaria.getCreatedAt().getTime()));
        stmt.setString(8, cargaDiaria.getDia2());
        stmt.setString(9, cargaDiaria.getHora2());

        stmt.execute();
        stmt.close();   
    }

    public void remove(CargaDiaria cargaDiaria) throws SQLException{
        String sql = "DELETE from carga_diaria WHERE id=?";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, cargaDiaria.getId());
        
        stmt.execute();
        stmt.close();
    }

    public void devolveProduto(CargaDiaria cargaDiaria) throws SQLException {
        String sql = "INSERT INTO carga_diaria (\n" +
        "id_armeiro,\n" +
        "id_guarda,\n" +
        "id_produto,\n" +
        "dia,\n" +
        "observacao,\n" +
        "created_at,\n" +
        "cautelado\n" +
        ") VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setInt(1, cargaDiaria.getArmeiro().getId());
        stmt.setInt(2, cargaDiaria.getGuarda().getId());
        stmt.setInt(3, cargaDiaria.getProduto().getId());
        stmt.setString(4, cargaDiaria.getDataArmeiroControle());
        stmt.setString(5, cargaDiaria.getObservacao());
        
        java.util.Date now = new java.util.Date();
        Date createdAt = new Date(now.getTime());
        System.out.println(createdAt);
        stmt.setDate(6, createdAt);

        stmt.setBoolean(7, false);

        stmt.execute();
        stmt.close();
    }
}
