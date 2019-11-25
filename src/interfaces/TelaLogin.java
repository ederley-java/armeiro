package interfaces;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.LoginDTO;
import dao.LoginDao;

/**
 *
 * @author Lemes
 */
public class TelaLogin extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    public TelaLogin() {
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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    private void initComponents() {
        jButtonAcessar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabelSenha = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jTextUsuario = new javax.swing.JTextField();
        jPasswordSenha = new javax.swing.JPasswordField();
        jButtonNovoUsuario = new javax.swing.JButton();
        jLabelFundoLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jButtonAcessar.setText("Acessar");
        jButtonAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcessarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAcessar);
        jButtonAcessar.setBounds(260, 170, 90, 30);

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair);
        jButtonSair.setBounds(280, 250, 120, 30);

        jLabelSenha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelSenha.setText("Senha:");
        getContentPane().add(jLabelSenha);
        jLabelSenha.setBounds(200, 130, 50, 20);

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelUsuario.setText("Usuário:");
        getContentPane().add(jLabelUsuario);
        jLabelUsuario.setBounds(200, 90, 50, 20);
        getContentPane().add(jTextUsuario);
        jTextUsuario.setBounds(260, 90, 180, 30);
        getContentPane().add(jPasswordSenha);
        jPasswordSenha.setBounds(260, 130, 180, 30);

        jButtonNovoUsuario.setText("Cadastrar");
        jButtonNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNovoUsuario);
        jButtonNovoUsuario.setBounds(350, 170, 90, 30);

        jLabelFundoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arquivos/imagens/fotoGMSJ01.jpg")));
        getContentPane().add(jLabelFundoLogin);
        jLabelFundoLogin.setBounds(10, 0, 720, 327);

        setSize(new java.awt.Dimension(746, 366));
        setLocationRelativeTo(null);
    }

    private void jButtonAcessarActionPerformed(java.awt.event.ActionEvent evt) {                                               
        try {
            LoginDTO login = new LoginDTO();
            login.setUsuario(jTextUsuario.getText());
            login.setSenha(jPasswordSenha.getText());

            LoginDao dao = new LoginDao();
            dao.logar(login);
            dispose();
        } catch (SQLException ex) {
           // JOptionPane.showMessageDialog(rootPane, "Usuário ou Senha Inválido!");
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void jButtonNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            LoginDTO c1 = new LoginDTO();
            LoginDao dao = new LoginDao();
            c1.setUsuario(jTextUsuario.getText());
            c1.setSenha(jPasswordSenha.getText());
            
            dao.CadastrarUsuario(c1);
            dispose();
        } catch (SQLException ex) {
           // JOptionPane.showMessageDialog(rootPane, "Usuário ou Senha Inválido!");
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private javax.swing.JButton jButtonAcessar;
    private javax.swing.JButton jButtonNovoUsuario;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelFundoLogin;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordSenha;
    private javax.swing.JTextField jTextUsuario;
}
