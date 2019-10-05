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
public class LivroParteDao {
     private Connection conexao;
    
    public LivroParteDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }
    
    public void adiciona (LivroParte c1) throws SQLException{
        // prepara a conexao com oo banco
        String sql = "insert into livroparte (nomeArmeiro, dia_entrada, hora_entrada, historico, dia_saida, hora_saida )" + "values (?,?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        // seta os valores 
        stmt.setString(1, c1.getNomeArmeiro());
        stmt.setString(2, c1.getDiaEntrada());
        stmt.setString(3, c1.getHoraEntrada());
        stmt.setString(4, c1.getHistorico());
        stmt.setString(5, c1.getDiaSaida());
        stmt.setString(6, c1.getHoraSaida());
        
        // executa o codigo sql
        stmt.execute();
        stmt.close();
    }
    
    public List<LivroParte> getLista(String nomeArmeiro) throws SQLException{
        System.out.println("chamada do metodo:  public List<LivroParte> getLista(String nomeArmeiro) ");
                        //"select * from livroparte where nomeArmeiro like ? or historico like ?"
        String sql = "select * from livroparte where nomeArmeiro like  ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nomeArmeiro);
        ResultSet rs = stmt.executeQuery();
        
        List<LivroParte> minhaListaLivro = new ArrayList<LivroParte>();
        
        while(rs.next()){
            LivroParte c1 = new LivroParte();
          //  c1.setId(Integer.toString(rs.getInt("Id")));  //conversao de string para int, para enviar ao banco
            c1.setId(rs.getInt("Id"));
            c1.setNomeArmeiro(rs.getString("nomeArmeiro"));
            c1.setDiaEntrada(rs.getString("dia_entrada"));
            c1.setHoraEntrada(rs.getString("hora_entrada"));
            c1.setHistorico(rs.getString("historico"));
            c1.setDiaSaida(rs.getString("dia_saida"));
            c1.setHoraSaida(rs.getString("hora_saida"));
            minhaListaLivro.add(c1);
       }
        rs.close();
        stmt.close();
        return minhaListaLivro;
    }
    
       public void altera (LivroParte c1) throws SQLException{
        String sql = "update livroparte set nomeArmeiro=?, dia_entrada=?, hora_entrada=?, historico=?" +
                ",dia_saida=?, hora_saida=? where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        // seta os valores 
        stmt.setString(1, c1.getNomeArmeiro());
        stmt.setString(2, c1.getDiaEntrada());
        stmt.setString(3, c1.getHoraEntrada());
        stmt.setString(4, c1.getHistorico());
        stmt.setString(5, c1.getDiaSaida());
        stmt.setString(6, c1.getHoraSaida());
        stmt.setInt(7, c1.getId());
        
        // executa o codigo sql
        stmt.execute();
        stmt.close();   
    }
            
    public void remove(LivroParte c1) throws SQLException{
        String sql = "delete from livroparte where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, c1.getId());
        stmt.execute();
        stmt.close();
        
    }
    
}
