/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lemes
 */
public class CriaConexao {
    
    
    public static Connection getConexao() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectando com o banco");
            return DriverManager.getConnection("jdbc:mysql://localhost/armeirobd4", "root", "1704");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Erro na conexao com o banco de dados");
            throw new SQLException(e.getMessage());
             
        }

    }
    
}
