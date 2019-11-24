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

    public void adiciona(Usuario c1) throws SQLException {
        // prepara a conexao com oo banco
        String sql = "insert into guarda (matricula, nome, endereco, telefone, email, sexo, situacao )" + "values (?,?,?,?,?,?,?)";
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

    public List<Usuario> getLista(String nome) throws SQLException {
        String sql = "select * from guarda where nome like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        List<Usuario> minhaLista = new ArrayList<Usuario>();

        while (rs.next()) {
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

    public void altera(Usuario c1) throws SQLException {
        String sql = "update guarda set nome=?, endereco=?, telefone=?, email=?"
                + ",sexo=?, situacao=? where matricula=?";
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

    public void remove(Usuario c1) throws SQLException {
        String sql = "DELETE FROM guarda WHERE matricula=?";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setLong(1, c1.getMatricula());
        
        stmt.execute();
        stmt.close();
    }

    public List<Usuario> listarGuardas() {
        ArrayList<Usuario> listUser = new ArrayList<>();

        try {
            con = CriaConexao.getConexao();
            sql = "SELECT nome FROM guarda GROUP BY id ORDER BY id ASC";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery(sql);

            while (rs.next()) {
                Usuario user = new Usuario();

                user.setNome(rs.getString("nome"));
                //user.setCatDescricao(rs.getString(2));
                //user.setCatValorDiaria(rs.getDouble(3));           
                listUser.add(user);
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro PSTM " + erro.getMessage());
        }

        return listUser;
    }
}
