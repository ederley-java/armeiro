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

/**
 *
 * @author Lemes
 */
public class ProdutoDao {
    
       
    private Connection conexao;
    
    public ProdutoDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }
    
    public void adiciona (Produto c1) throws SQLException{
        // prepara a conexao com o banco
        String sql = "insert into produto (cod, marca, tipo, numero_serie, descricao, observacao, localizacao, historico )" + "values (?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        // seta os valores 
        stmt.setString(1, c1.getCodigo());
        stmt.setString(2, c1.getMarcaProduto());
        stmt.setString(3, c1.getTipoProduto());
        stmt.setString(4, c1.getNumeroSerieProduto());
        stmt.setString(5, c1.getDescricaoProduto());
        stmt.setString(6, c1.getObservacaoProduto());
        stmt.setString(7, c1.getLocalizacaoProduto());
        stmt.setString(8, c1.getHistoricoManutencaoProduto());
        
        // executa o codigo sql
        stmt.execute();
        stmt.close();
    }
    
    public List<Produto> getLista(String id) throws SQLException{
        System.out.println("chamada do metodo:  public List<Produto> getLista(String id) ");
        
        String sql = "select * from Produto where cod like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        
        List<Produto> minhaLista = new ArrayList<Produto>();
        
        while(rs.next()){
            Produto produto = new Produto();

            produto.setId(rs.getInt("id"));
            produto.setCodigo(rs.getString("cod"));
            produto.setMarcaProduto(rs.getString("marca"));
            produto.setTipoProduto(rs.getString("tipo"));
            produto.setNumeroSerieProduto(rs.getString("numero_serie"));
            produto.setDescricaoProduto(rs.getString("descricao"));
            produto.setObservacaoProduto(rs.getString("observacao"));
            produto.setLocalizacaoProduto(rs.getString("localizacao"));
            produto.setHistoricoManutencaoProduto(rs.getString("historico"));
            
            minhaLista.add(produto);
       }
        rs.close();
        stmt.close();
        return minhaLista;
    }
    
       public void altera (Produto produto) throws SQLException{
        String sql = "update produto set marca=?, tipo=?, numero_serie=?, descricao=?" +
                ",observacao=?, localizacao=?, historico=? where id=?";          // String sql
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        // seta os valores 
        stmt.setString(1, produto.getMarcaProduto());
        stmt.setString(2, produto.getTipoProduto());
        stmt.setString(3, produto.getNumeroSerieProduto());
        stmt.setString(4, produto.getDescricaoProduto());
        stmt.setString(5, produto.getObservacaoProduto());     // A ordem passada tem que ser a mesma da String sql (lá em cima)
        stmt.setString(6, produto.getLocalizacaoProduto());
        stmt.setString(7, produto.getHistoricoManutencaoProduto());
        stmt.setString(8, produto.getCodigo());
        
        // executa o codigo sql
        stmt.execute();
        stmt.close();
    }
    
    public void remove(Produto c1) throws SQLException{
        String sql = "delete from produto where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, c1.getCodigo());
        stmt.execute();
        stmt.close();
          
    }
    
}
