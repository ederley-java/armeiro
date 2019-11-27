/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import models.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Produto;

/**
 *
 * @author Lemes
 */
public class ProdutoDao {
    private Connection conexao;
    Connection con = null;
    String sql;
    ResultSet rs;
    PreparedStatement pstm; 
       
      
    public ProdutoDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }
    
    public void adiciona (Produto c1) throws SQLException{
        // prepara a conexao com o banco
        String sql = "INSERT into produto (cod, marca, tipo, numero_serie, descricao, observacao, localizacao, historico )" + "values (?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        // seta os valores 
        stmt.setString(1, c1.getCodigo());
        stmt.setString(2, c1.getMarca());
        stmt.setString(3, c1.getTipo());
        stmt.setString(4, c1.getNumeroSerie());
        stmt.setString(5, c1.getDescricao());
        stmt.setString(6, c1.getObservacao());
        stmt.setString(7, c1.getLocalizacao());
        stmt.setString(8, c1.getHistoricoManutencao());
        
        // executa o codigo sql
        stmt.execute();
        stmt.close();
    }
    
    public List<Produto> getLista(String id) throws SQLException{
        System.out.println("chamada do metodo:  public List<Produto> getLista(String id) ");
        
        String sql = "SELECT * from Produto WHERE cod like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        
        List<Produto> minhaLista = new ArrayList<Produto>();
        
        while(rs.next()){
            Produto produto = new Produto();

            produto.setId(rs.getInt("id"));
            produto.setCodigo(rs.getString("cod"));
            produto.setMarca(rs.getString("marca"));
            produto.setTipo(rs.getString("tipo"));
            produto.setNumeroSerie(rs.getString("numero_serie"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setObservacao(rs.getString("observacao"));
            produto.setLocalizacao(rs.getString("localizacao"));
            produto.setHistoricoManutencao(rs.getString("historico"));
            
            minhaLista.add(produto);
       }
        rs.close();
        stmt.close();
        return minhaLista;
    }
    
       public void altera (Produto produto) throws SQLException{
        String sql = "UPDATE produto set marca=?, tipo=?, numero_serie=?, descricao=?" +
                ",observacao=?, localizacao=?, historico=? WHERE id=?";          // String sql
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        // seta os valores 
        stmt.setString(1, produto.getMarca());
        stmt.setString(2, produto.getTipo());
        stmt.setString(3, produto.getNumeroSerie());
        stmt.setString(4, produto.getDescricao());
        stmt.setString(5, produto.getObservacao());     // A ordem passada tem que ser a mesma da String sql (lá em cima)
        stmt.setString(6, produto.getLocalizacao());
        stmt.setString(7, produto.getHistoricoManutencao());
        stmt.setString(8, produto.getCodigo());
        
        // executa o codigo sql
        stmt.execute();
        stmt.close();
    }
    
    public void remove(Produto c1) throws SQLException{
        String sql = "DELETE from produto WHERE id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, c1.getCodigo());
        stmt.execute();
        stmt.close();
          
    }
    
    
     public List<Produto> preencherComboItens() {
        ArrayList<Produto> listUser = new ArrayList<>();

        try {
            con = CriaConexao.getConexao();
            sql = "SELECT cod FROM produto GROUP BY id ORDER BY id ASC";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery(sql);

            while (rs.next()) {
                Produto item = new Produto();

                item.setCodigo(rs.getString("cod"));
                //user.setCatDescricao(rs.getString(2));
                //user.setCatValorDiaria(rs.getDouble(3));           
                listUser.add(item);
            }
     } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro PSTM " + erro.getMessage());
     }

        return listUser;
    }
}
