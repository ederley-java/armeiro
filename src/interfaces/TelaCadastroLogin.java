/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.LoginDTO;
import dao.LoginDao;
import interfaces.TelaLogin;

/**
 *
 * @author Lemes
 */
public class TelaCadastroLogin extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    public TelaCadastroLogin() {
        initComponents();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroLogin().setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonCadastrarUsuarioNovo = new javax.swing.JButton();
        jTextNomeUsuarioNovo = new javax.swing.JTextField();
        jTextSenhaUsuarioNovo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Senha:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 128, 45, 22));

        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 88, 45, 22));

        jButtonCadastrarUsuarioNovo.setText("Cadastrar");
        jButtonCadastrarUsuarioNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarUsuarioNovoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCadastrarUsuarioNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 183, -1, -1));
        getContentPane().add(jTextNomeUsuarioNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 89, 123, -1));
        getContentPane().add(jTextSenhaUsuarioNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 129, 123, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fotoGMSJ05.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 400, 290));

        setSize(new java.awt.Dimension(416, 340));
        setLocationRelativeTo(null);
    }

    private void jButtonCadastrarUsuarioNovoActionPerformed(java.awt.event.ActionEvent evt) {
         try {
            LoginDTO c1 = new LoginDTO();
            LoginDao dao = new LoginDao();
            c1.setUsuario(jTextNomeUsuarioNovo.getText());
            c1.setSenha(jTextSenhaUsuarioNovo.getText());
            
            dao.CadastrarUsuarioNovo(c1);
            dispose();
        } catch (SQLException ex) {
           // JOptionPane.showMessageDialog(rootPane, "Usuário ou Senha Inválido!");
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private javax.swing.JButton jButtonCadastrarUsuarioNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextNomeUsuarioNovo;
    private javax.swing.JTextField jTextSenhaUsuarioNovo;
}
