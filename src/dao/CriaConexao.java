package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lemes
 */
public class CriaConexao {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String password = "Abc_1234";
    private static String url = "jdbc:mysql://localhost/armeirobd4";
    private static String user = "root";

    public static Connection getConexao() throws SQLException {
        try {
            Class.forName(driver);
            
            System.out.println("Conectando com o banco");
            
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();

            JOptionPane.showMessageDialog(null, "Erro na conexao com o banco de dados");
            
            throw new SQLException(e.getMessage());
        }
    }
}
