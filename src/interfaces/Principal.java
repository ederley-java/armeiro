package interfaces;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.CargaDiariaDao;
import dao.LivroParteDao;
import dao.ProdutoDao;
import dao.UsuarioDao;
import java.text.ParseException;
import models.CargaDiaria;
import models.LivroParte;
import models.Produto;
import models.Usuario;
import utils.Converter;
import utils.Formatter;

/**
 *
 * @author Lemes
 */
public class Principal extends javax.swing.JFrame {
    DefaultTableModel tmUsuario = new DefaultTableModel(null, new String[]{"ID", "Maticula", "Nome", "Endereço", "Telefone", "Email", "Sexo", "Situação"});   // modelo que a tabela pegará para criar as culunas (tem que inserir tmusuarios nas 
    List<Usuario> usuarios;                                                                                                                              // propriedades da tabela "model".         
    ListSelectionModel lsmUsuario;

    DefaultTableModel tmLivroParte = new DefaultTableModel(null, new String[]{"ID", "Armeiro", "Data Entrada", "Hora Entrada", "Histórico", "Data Saída", "Hora Saída"});
    List<LivroParte> livroParte;
    ListSelectionModel lsmLivroParte;

    DefaultTableModel tmProduto = new DefaultTableModel(null, new String[]{"ID", "Cod.", "Marca", "Tipo", "Numero de Serie", "Descrição", "Observação", "Localização", "Historico de Manutenção"});
    List<Produto> produto;
    ListSelectionModel lsmProduto;

    DefaultTableModel tmControle = new DefaultTableModel(null, new String[]{"ID", "Data", "Armeiro", "Guarda", "Item", "Observação", "Data", "Cautelado", "Data 2", "Hora 2"});
    List<CargaDiaria> cargaDiaria;
    ListSelectionModel lsmControle;

    /**
     * Creates new form Principal
     */
    public Principal() throws SQLException {
        initComponents();
        preencherComboGuarda();
        desabilitaDados();
        desabilitaDadosLivroParte();//chama o metodo no inicio.
        desabilitaDadosProduto();

        // jTDataControle.setText(dataSistema());  retirado para ser colocado no botao
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jTabbedUsuarios = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jTDataControle = new javax.swing.JTextField();
        jTPesquisaControle = new javax.swing.JTextField();
        jBPesquisarControle = new javax.swing.JButton();
        jTextId = new javax.swing.JTextField();
        jComboArmeiro = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextArmeiroControle = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableControle = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jBFinalizarTurno = new javax.swing.JButton();
        jTHoraSaidaAgente = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTDataSaidaAgente = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTHoraEntradaAgente = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTDataEntradaAgente = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jBSalvarControle = new javax.swing.JButton();
        jBExcluirControle = new javax.swing.JButton();
        jBAlterarControle = new javax.swing.JButton();
        jBNovoControle = new javax.swing.JButton();
        jTObservacao = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTCodProduto = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTAgente = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTabela = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jBNovo = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jBSalvar = new javax.swing.JButton();
        jBPesquisar = new javax.swing.JButton();
        jTPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jTMatricula = new javax.swing.JTextField();
        jTNome = new javax.swing.JTextField();
        jTEndereco = new javax.swing.JTextField();
        jTTelefone = new javax.swing.JTextField();
        jLabelMatricula = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelEndereco = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jTEmail = new javax.swing.JTextField();
        jTSexo = new javax.swing.JTextField();
        jTSituacao = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jLabelSexo = new javax.swing.JLabel();
        jLabelSituacao = new javax.swing.JLabel();
        jTIdUsuario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jTextCodProduto = new javax.swing.JTextField();
        jTextMarcaProduto = new javax.swing.JTextField();
        jTextNumeroSerieProduto = new javax.swing.JTextField();
        jTextTipoProduto = new javax.swing.JTextField();
        jTextDescricaoProduto = new javax.swing.JTextField();
        jTextLocalizacaoProduto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextHistoricoProduto = new javax.swing.JTextArea();
        jTextObservacaoProduto = new javax.swing.JTextField();
        jTextIdProduto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jTextPesquisaProduto = new javax.swing.JTextField();
        jBPesquisarProduto = new javax.swing.JButton();
        jBNovoProduto = new javax.swing.JButton();
        jBAlterarProduto = new javax.swing.JButton();
        jBExcluirProduto = new javax.swing.JButton();
        jBSalvarProduto = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableProduto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jTextNomeArmeiro = new javax.swing.JTextField();
        jFormattedTextDataEntrada = new javax.swing.JFormattedTextField();
        jFormattedTextHoraEntrada = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextHistorico = new javax.swing.JTextArea();
        jFormattedTextDataSaida = new javax.swing.JFormattedTextField();
        jFormattedTextHoraSaida = new javax.swing.JFormattedTextField();
        jTextPesquisaParte = new javax.swing.JTextField();
        jBPesquisaParte = new javax.swing.JButton();
        jBNovoParte = new javax.swing.JButton();
        jBAlterarParte = new javax.swing.JButton();
        jBExcluirParte = new javax.swing.JButton();
        jBSalvarParte = new javax.swing.JButton();
        jTextIDLivro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTTabelaLivro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(102, 102, 255));
        getContentPane().setLayout(null);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jTDataControle, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 87, -1));
        jPanel6.add(jTPesquisaControle, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 390, -1));

        jBPesquisarControle.setText("Pesquisar");
        jBPesquisarControle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarControleActionPerformed(evt);
            }
        });
        jPanel6.add(jBPesquisarControle, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 20, -1, -1));

        jTextId.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel6.add(jTextId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 20, 20));

        jComboArmeiro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        jPanel6.add(jComboArmeiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 100, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel20.setText("Armeiro:");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 20));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel22.setText("ID:");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel24.setText("Pesquisar:");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 60, 20));
        jPanel6.add(jTextArmeiroControle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 150, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel30.setText("Data:");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, 20));

        jTableControle.setModel(tmControle);
        jTableControle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lsmControle = jTableControle.getSelectionModel();
        lsmControle.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    jTTabelaLinhaSelecionadaControle(jTableControle);
                }
            }
        });
        jScrollPane6.setViewportView(jTableControle);

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBFinalizarTurno.setText("Devolver Material");
        jBFinalizarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFinalizarTurnoActionPerformed(evt);
            }
        });
        jPanel11.add(jBFinalizarTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 20, 150, 50));
        jPanel11.add(jTHoraSaidaAgente, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 80, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel23.setText("Hora Saída:");
        jPanel11.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 50, -1, -1));
        jPanel11.add(jTDataSaidaAgente, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 20, 80, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel28.setText("Data Saída:");
        jPanel11.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, -1, -1));

        jTHoraEntradaAgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTHoraEntradaAgenteActionPerformed(evt);
            }
        });
        jPanel11.add(jTHoraEntradaAgente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 80, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel27.setText("Hora Entrada:");
        jPanel11.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, 10));
        jPanel11.add(jTDataEntradaAgente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 80, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel26.setText("Data Entrada:");
        jPanel11.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, 10));

        jBSalvarControle.setText("Salvar");
        jBSalvarControle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarControleActionPerformed(evt);
            }
        });
        jPanel11.add(jBSalvarControle, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 93, -1));

        jBExcluirControle.setText("Excluir");
        jPanel11.add(jBExcluirControle, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 93, -1));

        jBAlterarControle.setText("Aletar");
        jBAlterarControle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarControleActionPerformed(evt);
            }
        });
        jPanel11.add(jBAlterarControle, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 93, -1));

        jBNovoControle.setText("Novo");
        jBNovoControle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoControleActionPerformed(evt);
            }
        });
        jPanel11.add(jBNovoControle, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 93, -1));
        jPanel11.add(jTObservacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 520, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel25.setText("Observação:");
        jPanel11.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, 10));
        jPanel11.add(jTCodProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 150, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel29.setText("Item:");
        jPanel11.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 10));

        jTAgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTAgenteActionPerformed(evt);
            }
        });
        jPanel11.add(jTAgente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel21.setText("Guarda:");
        jPanel11.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 10));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1325, Short.MAX_VALUE)
                    .addComponent(jScrollPane6)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        jTabbedUsuarios.addTab("Controle de Materiais", jPanel5);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario"));

        jTTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lsmUsuario = jTTabela.getSelectionModel();
        lsmUsuario.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    jTTabelaLinhaSelecionada(jTTabela);
                }
            }
        });
        jTTabela.setModel(tmUsuario);
        jScrollPane1.setViewportView(jTTabela);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBNovo.setText("Novo");
        jBNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoActionPerformed(evt);
            }
        });
        jPanel3.add(jBNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 32, 82, -1));

        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });
        jPanel3.add(jBAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 32, 82, -1));

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });
        jPanel3.add(jBExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 32, 82, -1));

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });
        jPanel3.add(jBSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 82, -1));

        jBPesquisar.setText("PESQUISAR");
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });
        jPanel3.add(jBPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 30, -1, -1));
        jPanel3.add(jTPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 470, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("Pesquisar");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 13, -1, 20));

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel10.add(jTMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 180, -1));
        jPanel10.add(jTNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 280, -1));
        jPanel10.add(jTEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 280, -1));
        jPanel10.add(jTTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 280, -1));

        jLabelMatricula.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabelMatricula.setText("Matricula:");
        jPanel10.add(jLabelMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabelNome.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabelNome.setText("Nome:");
        jPanel10.add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 52, -1));

        jLabelEndereco.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabelEndereco.setText("Endereço:");
        jPanel10.add(jLabelEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jLabelTelefone.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabelTelefone.setText("Telefone:");
        jPanel10.add(jLabelTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));
        jPanel10.add(jTEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 280, -1));
        jPanel10.add(jTSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 230, -1));
        jPanel10.add(jTSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 230, -1));

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabelEmail.setText("Email:");
        jPanel10.add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        jLabelSexo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabelSexo.setText("Sexo:");
        jPanel10.add(jLabelSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

        jLabelSituacao.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabelSituacao.setText("Função:");
        jPanel10.add(jLabelSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, -1, -1));

        jTIdUsuario.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel10.add(jTIdUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 25, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel10.setText("ID:");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedUsuarios.addTab("Cadastro Usuarios", jPanel1);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(jTextCodProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 79, -1));
        jPanel8.add(jTextMarcaProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 240, -1));
        jPanel8.add(jTextNumeroSerieProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 240, -1));

        jTextTipoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTipoProdutoActionPerformed(evt);
            }
        });
        jPanel8.add(jTextTipoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 240, -1));
        jPanel8.add(jTextDescricaoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 199, -1));
        jPanel8.add(jTextLocalizacaoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 200, -1));

        jTextHistoricoProduto.setColumns(20);
        jTextHistoricoProduto.setRows(5);
        jScrollPane3.setViewportView(jTextHistoricoProduto);

        jPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 760, 170));
        jPanel8.add(jTextObservacaoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 200, -1));
        jPanel8.add(jTextIdProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 34, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel11.setText("Id:");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 3, 22, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel12.setText("Código:");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 43, -1, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel13.setText("Marca:");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, -1, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setText("Tipo:");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, -1, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel15.setText("S/N:");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 163, -1, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel16.setText("Descrição:");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 83, -1, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel17.setText("Observação:");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 123, -1, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel18.setText("Localização:");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 163, -1, 20));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel19.setText("Histórico:");
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 13, -1, 20));

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(jTextPesquisaProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 490, -1));

        jBPesquisarProduto.setText("Pesquisar");
        jBPesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarProdutoActionPerformed(evt);
            }
        });
        jPanel9.add(jBPesquisarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 20, 110, -1));

        jBNovoProduto.setText("Novo");
        jBNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoProdutoActionPerformed(evt);
            }
        });
        jPanel9.add(jBNovoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 92, -1));

        jBAlterarProduto.setText("Alterar");
        jBAlterarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarProdutoActionPerformed(evt);
            }
        });
        jPanel9.add(jBAlterarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 92, -1));

        jBExcluirProduto.setText("Excluir");
        jBExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirProdutoActionPerformed(evt);
            }
        });
        jPanel9.add(jBExcluirProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 92, -1));

        jBSalvarProduto.setText("Salvar");
        jBSalvarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarProdutoActionPerformed(evt);
            }
        });
        jPanel9.add(jBSalvarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 92, -1));

        jTableProduto.setModel(tmProduto);
        jTableProduto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lsmProduto = jTableProduto.getSelectionModel();
        lsmProduto.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    jTTabelaLinhaSelecionadaProduto(jTableProduto);
                }
            }
        });
        jScrollPane5.setViewportView(jTableProduto);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1317, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jTabbedUsuarios.addTab("Cadastro de Materiais", jPanel4);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel7.add(jTextNomeArmeiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 189, -1));

        jFormattedTextDataEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        jPanel7.add(jFormattedTextDataEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 90, -1));

        jFormattedTextHoraEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jPanel7.add(jFormattedTextHoraEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 90, -1));

        jTextHistorico.setColumns(20);
        jTextHistorico.setRows(5);
        jTextHistorico.setBorder(null);
        jScrollPane2.setViewportView(jTextHistorico);

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 72, 1290, 120));
        jPanel7.add(jFormattedTextDataSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 90, -1));
        jPanel7.add(jFormattedTextHoraSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 90, -1));
        jPanel7.add(jTextPesquisaParte, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, 459, -1));

        jBPesquisaParte.setText("Pesquisa");
        jBPesquisaParte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisaParteActionPerformed(evt);
            }
        });
        jPanel7.add(jBPesquisaParte, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 30, 86, -1));

        jBNovoParte.setText("Novo");
        jBNovoParte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoParteActionPerformed(evt);
            }
        });
        jPanel7.add(jBNovoParte, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 77, -1));

        jBAlterarParte.setText("Alterar");
        jBAlterarParte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarParteActionPerformed(evt);
            }
        });
        jPanel7.add(jBAlterarParte, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 77, -1));

        jBExcluirParte.setText("Excluir");
        jBExcluirParte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirParteActionPerformed(evt);
            }
        });
        jPanel7.add(jBExcluirParte, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, 77, -1));

        jBSalvarParte.setText("Salvar");
        jBSalvarParte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarParteActionPerformed(evt);
            }
        });
        jPanel7.add(jBSalvarParte, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, 77, -1));
        jPanel7.add(jTextIDLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 45, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("Nome:");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("Data Entrada:");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 13, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setText("Data Saída:");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 13, 65, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("Hora Entrada:");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 13, -1, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setText("Hora Saída");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 13, -1, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel7.setText("Pesquisar:");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, -1, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel8.setText("Relatório de Serviço:");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 53, -1, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel9.setText("ID:");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 193, 27, 20));

        jTTabelaLivro.setModel(tmLivroParte);
        jTTabelaLivro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lsmLivroParte = jTTabelaLivro.getSelectionModel();
        lsmLivroParte.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    jTTabelaLinhaSelecionadaLivro(jTTabelaLivro);
                }
            }
        });
        jScrollPane4.setViewportView(jTTabelaLivro);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1325, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedUsuarios.addTab("Livro Parte", jPanel2);

        getContentPane().add(jTabbedUsuarios);
        jTabbedUsuarios.setBounds(0, 0, 1350, 630);

        setBounds(0, 0, 1370, 704);
    }// </editor-fold>                        

    public static String dataSistema() {
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yy");
        String dataFormatada = formatar.format(data);

        return formatar.format(data);
    }

    public static String horaSistema() {
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("HH:mm");
        String dataFormatada = formatar.format(data);

        return formatar.format(data);
    }

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        //limpa os campos
        habilitaDados();

        jTIdUsuario.setText("");
        jTNome.setText("");
        jTMatricula.setText("");
        jTEndereco.setText("");
        jTEmail.setText("");
        jTSexo.setText("");
        jTSituacao.setText("");
        jTTelefone.setText("");
        jTIdUsuario.setEditable(true);

    }//GEN-LAST:event_jBNovoActionPerformed

    public void desabilitaDadosLivroParte() {   //desabilita campos que nao queremos que sejam editadoos
        jTextNomeArmeiro.setEditable(false);
        jFormattedTextDataEntrada.setEditable(false);
        jFormattedTextHoraEntrada.setEditable(false);
        jFormattedTextDataSaida.setEditable(false);
        jFormattedTextHoraSaida.setEditable(false);
        jTextHistorico.setEditable(false);
    }

    public void habilitaDadosLivroParte() {   //desabilita campos que nao queremos que sejam editadoos
        jTextIDLivro.setEditable(false);
        jTextNomeArmeiro.setEditable(true);
        jFormattedTextDataEntrada.setEditable(true);
        jFormattedTextHoraEntrada.setEditable(true);
        jFormattedTextDataSaida.setEditable(true);
        jFormattedTextHoraSaida.setEditable(true);
        jTextHistorico.setEditable(true);
    }

    public void desabilitaDados() {   //desabilita campos que nao queremos que sejam editadoos
        jTIdUsuario.setEditable(false);
        jTMatricula.setEditable(false);
        jTNome.setEditable(false);
        jTEndereco.setEditable(false);
        jTEmail.setEditable(false);
        jTSexo.setEditable(false);
        jTTelefone.setEditable(false);
        jTSituacao.setEditable(false);
    }

    public void habilitaDados() {   //habilita campos que queremos que sejam editadoos
        jTIdUsuario.setEditable(false);
        jTMatricula.setEditable(true);
        jTNome.setEditable(true);
        jTEndereco.setEditable(true);
        jTEmail.setEditable(true);
        jTSexo.setEditable(true);
        jTTelefone.setEditable(true);
        jTSituacao.setEditable(true);
    }

    public void desabilitaDadosProduto() {   //desabilita campos que nao queremos que sejam editadoos
        jTextIdProduto.setEditable(false);
        jTextCodProduto.setEditable(false);
        jTextMarcaProduto.setEditable(false);
        jTextTipoProduto.setEditable(false);
        jTextNumeroSerieProduto.setEditable(false);
        jTextDescricaoProduto.setEditable(false);
        jTextObservacaoProduto.setEditable(false);
        jTextLocalizacaoProduto.setEditable(false);
        jTextHistoricoProduto.setEditable(false);

    }

    public void habilitaDadosProduto() {   //habilita campos que nao queremos que sejam editadoos
        jTextIdProduto.setEditable(false);
        jTextCodProduto.setEditable(true);
        jTextMarcaProduto.setEditable(true);
        jTextTipoProduto.setEditable(true);
        jTextNumeroSerieProduto.setEditable(true);
        jTextDescricaoProduto.setEditable(true);
        jTextObservacaoProduto.setEditable(true);
        jTextLocalizacaoProduto.setEditable(true);
        jTextHistoricoProduto.setEditable(true);

    }

    public void habilitaDadosControle() {   //habilita campos que nao queremos que sejam editadoos
        // jTArmeiroControle.setEditable(true);
        jTDataControle.setEditable(true);
        jTAgente.setEditable(true);
        jTCodProduto.setEditable(true);
        jTDataEntradaAgente.setEditable(true);
        jTHoraEntradaAgente.setEditable(true);
        jTDataSaidaAgente.setEditable(true);
        jTHoraSaidaAgente.setEditable(true);
    }

    public void desabilitaDadosControle() {   //desabilita campos que nao queremos que sejam editadoos

        jTDataControle.setEditable(false);
        jTAgente.setEditable(false);
        jTCodProduto.setEditable(false);
        jTDataEntradaAgente.setEditable(false);
        jTHoraEntradaAgente.setEditable(false);
        jTDataSaidaAgente.setEditable(false);
        jTHoraSaidaAgente.setEditable(false);
    }

    public boolean verificaDados() {    // verifica se os campos nao estao vazios
        if (!jTNome.getText().equals("") && !jTEndereco.getText().equals("")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, " Campo nome ou endereço não preenchidos!");
            return false;
        }
    }

    public boolean verificaDadosLivroParte() {    // verifica se os campos nao estao vazios
        if (!jTextNomeArmeiro.getText().equals("") && !jFormattedTextDataEntrada.getText().equals("")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, " Campo Nome ou Data não podem ficar em branco!");
            return false;
        }
    }

    public boolean verificaDadosProduto() {    // verifica se os campos nao estao vazios
        if (!jTextCodProduto.getText().equals("") && !jTextMarcaProduto.getText().equals("")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, " Campo ID ou Marca não preenchidos!");
            return false;
        }
    }

    public boolean verificaDadosControle() {    // verifica se os campos nao estao vazios
        if (!jTextArmeiroControle.getText().equals("") && !jTDataControle.getText().equals("")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, " Campo ID ou Marca não preenchidos!");
            return false;
        }
    }

    private void jTTabelaLinhaSelecionada(JTable tabela) {     //metodo que pega os valores que estao sendo exibidos
        if (jTTabela.getSelectedRow() != -1) {   //se a linha selecionada da tabela for diferente de -1, entao...
            habilitaDados();
            // faz o parse de long para string
            jTIdUsuario.setText(String.valueOf(usuarios.get(tabela.getSelectedRow()).getIdUsuario()));
            jTMatricula.setText(String.valueOf(usuarios.get(tabela.getSelectedRow()).getMatricula())); // na tabela e coloca-os nos campos para serem editados
            jTNome.setText(usuarios.get(tabela.getSelectedRow()).getNome());
            jTTelefone.setText(usuarios.get(tabela.getSelectedRow()).getTelefone());
            jTEmail.setText(usuarios.get(tabela.getSelectedRow()).getEmail());
            jTEndereco.setText(usuarios.get(tabela.getSelectedRow()).getEndereco());
            jTSexo.setText(usuarios.get(tabela.getSelectedRow()).getSexo());           // tambem tem que adicionar codigo de pos inicializacao nas propriedades da tabela
            jTSituacao.setText(usuarios.get(tabela.getSelectedRow()).getSituacao());
        } else {
            jTMatricula.setText("");
            jTNome.setText("");
            jTTelefone.setText("");
            jTEndereco.setText("");
            jTEmail.setText("");
            jTSexo.setText("");
            jTSituacao.setText("");
        }
    }

    private void jTTabelaLinhaSelecionadaLivro(JTable tabela) {     //metodo que pega os valores que estao sendo exibidos
        if (jTTabelaLivro.getSelectedRow() != -1) {   //se a linha selecionada da tabela for diferente de -1, entao...
            habilitaDadosLivroParte();
            // faz o parse de long para string
            jTextIDLivro.setText(String.valueOf(livroParte.get(tabela.getSelectedRow()).getId())); // na tabela e coloca-os nos campos para serem editados
            jTextNomeArmeiro.setText(livroParte.get(tabela.getSelectedRow()).getNomeArmeiro());
            jFormattedTextDataEntrada.setText(livroParte.get(tabela.getSelectedRow()).getDiaEntrada());
            jFormattedTextHoraEntrada.setText(livroParte.get(tabela.getSelectedRow()).getHoraEntrada());
            jFormattedTextDataSaida.setText(livroParte.get(tabela.getSelectedRow()).getDiaSaida());
            jFormattedTextHoraSaida.setText(livroParte.get(tabela.getSelectedRow()).getHoraSaida());           // tambem tem que adicionar codigo de pos inicializacao nas propriedades da tabela
            jTextHistorico.setText(livroParte.get(tabela.getSelectedRow()).getHistorico());
        } else {
            jTextIDLivro.setText("");
            jTextNomeArmeiro.setText("");
            jFormattedTextDataEntrada.setText("");
            jFormattedTextHoraEntrada.setText("");
            jFormattedTextDataSaida.setText("");
            jFormattedTextHoraSaida.setText("");
            jTextHistorico.setText("");
        }
    }

    private void jTTabelaLinhaSelecionadaProduto(JTable tabela) {     //metodo que pega os valores que estao sendo exibidos
        if (jTableProduto.getSelectedRow() != -1) {   //se a linha selecionada da tabela for diferente de -1, entao...

            habilitaDadosProduto();
            jTextIdProduto.setText(String.valueOf(produto.get(tabela.getSelectedRow()).getIdProduto()));
            jTextCodProduto.setText(produto.get(tabela.getSelectedRow()).getCod());
            jTextMarcaProduto.setText(produto.get(tabela.getSelectedRow()).getMarcaProduto()); // na tabela e coloca-os nos campos para serem editados
            jTextTipoProduto.setText(produto.get(tabela.getSelectedRow()).getTipoProduto());
            jTextNumeroSerieProduto.setText(produto.get(tabela.getSelectedRow()).getNumeroSerieProduto());
            jTextDescricaoProduto.setText(produto.get(tabela.getSelectedRow()).getDescricaoProduto());
            jTextObservacaoProduto.setText(produto.get(tabela.getSelectedRow()).getObservacaoProduto());
            jTextLocalizacaoProduto.setText(produto.get(tabela.getSelectedRow()).getLocalizacaoProduto());
            jTextHistoricoProduto.setText(produto.get(tabela.getSelectedRow()).getHistoricoManutencaoProduto());// tambem tem que adicionar codigo de pos inicializacao nas propriedades da tabela

        } else {
            jTextCodProduto.setText("");
            jTextMarcaProduto.setText("");
            jTextTipoProduto.setText("");
            jTextNumeroSerieProduto.setText("");
            jTextDescricaoProduto.setText("");
            jTextObservacaoProduto.setText("");
            jTextLocalizacaoProduto.setText("");
            jTextHistoricoProduto.setText("");
        }
    }

    private void jTTabelaLinhaSelecionadaControle(JTable tabela) {     //metodo que pega os valores que estao sendo exibidos
        if (jTableControle.getSelectedRow() != -1) {                  //se a linha selecionada da tabela for diferente de -1, entao...

            habilitaDadosControle();
            jTextId.setText(String.valueOf(controle.get(tabela.getSelectedRow()).getId()));
           // jTArmeiroControle.setText(String.valueOf(controle.get(tabela.getSelectedRow()).getArmeiroControle() ));
            jTDataControle.setText(controle.get(tabela.getSelectedRow()).getDataArmeiroControle()); // na tabela e coloca-os nos campos para serem editados
            jTAgente.setText(String.valueOf(controle.get(tabela.getSelectedRow()).getAgenteControle()));
            jTCodProduto.setText(String.valueOf(controle.get(tabela.getSelectedRow()).getCodproduto()));
            String createdAt = Converter.dateToString(controle.get(tabela.getSelectedRow()).getCreatedAt());
            jTDataEntradaAgente.setText(createdAt);
            jTDataSaidaAgente.setText(controle.get(tabela.getSelectedRow()).getDia2());
            jTHoraSaidaAgente.setText(controle.get(tabela.getSelectedRow()).getHora2());

            verificaDevulocao();
        } else {
            jTDataControle.setText("");
            jTAgente.setText("");
            jTCodProduto.setText("");
            jTDataEntradaAgente.setText("");
            jTHoraEntradaAgente.setText("");
            jTDataSaidaAgente.setText("");
            jTHoraSaidaAgente.setText("");
        }
    }

    private void verificaDevulocao() {
        CargaDiaria p1 = new CargaDiaria();
        if (!p1.isCautelado()) {
            jTCodProduto.setVisible(true);         //    metodo em teste <<<<<<<<<<<

        }
    }

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if (verificaDados()) {
            cadastro();
            try {
                listarContatos();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        try {
            System.out.println("chamada do metodo: listarContatos() ");
            listarContatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " problemas no campo pesquisar!");
        }
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        // TODO add your handling code here:
        try {
            excluirContato();
            mostraPesquisa(usuarios);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no botao jBExluir");
        }
        try {
            // System.out.println("chamada do metodo: listarContatos() ");
            listarContatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " problemas no metodo pesquisar da opcao excluir!");
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        try {
            alteraContato();
            listarContatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema no jBAlterar!");
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBNovoParteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoParteActionPerformed
        habilitaDadosLivroParte();
        jTextIDLivro.setText("");
        jTextNomeArmeiro.setText("");
        jFormattedTextDataEntrada.setText(dataSistema());
        jFormattedTextHoraEntrada.setText(horaSistema());
        jFormattedTextDataSaida.setText(dataSistema());
        jFormattedTextHoraSaida.setText(horaSistema());
        jTextPesquisaParte.setText("");
        jTextHistorico.setText("");


    }//GEN-LAST:event_jBNovoParteActionPerformed

    private void jBSalvarParteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarParteActionPerformed
        if (verificaDadosLivroParte()) {
            cadastroLivroParte();
            desabilitaDadosLivroParte();
        }

    }//GEN-LAST:event_jBSalvarParteActionPerformed

    private void jBPesquisaParteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisaParteActionPerformed
        //  jTextPesquisaParte.setText("");  //LImpa o campo antes de fazer qualquer coisa
        System.out.println("chamada do metodo: listarLivroParte() ");
        try {
            listarLivroParte();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " problemas no campo pesquisar!");
        }
    }//GEN-LAST:event_jBPesquisaParteActionPerformed

    private void jBExcluirParteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirParteActionPerformed
        try {
            excluirContatoLivro();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no botao jBExluir");
        }
        try {
            // System.out.println("chamada do metodo: listarContatos() ");
            listarLivroParte();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " problemas no metodo pesquisar da opcao excluir!");
        }
    }//GEN-LAST:event_jBExcluirParteActionPerformed

    private void jBAlterarParteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarParteActionPerformed
        try {
            alteraContatoLivro();
            listarLivroParte();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema no jBAlterar!");
        }
    }//GEN-LAST:event_jBAlterarParteActionPerformed

    private void jBNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoProdutoActionPerformed
        habilitaDadosProduto();
        
        jTextIdProduto.setText("");
        jTextCodProduto.setText("");
        jTextMarcaProduto.setText("");
        jTextTipoProduto.setText("");
        jTextNumeroSerieProduto.setText("");
        jTextDescricaoProduto.setText("");
        jTextObservacaoProduto.setText("");
        jTextLocalizacaoProduto.setText("");
        jTextHistoricoProduto.setText("");
    }//GEN-LAST:event_jBNovoProdutoActionPerformed

    private void jBSalvarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarProdutoActionPerformed
        if (verificaDadosProduto()) {
            cadastroProduto();
            try {
                listarProduto();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            desabilitaDadosProduto();
        }
    }//GEN-LAST:event_jBSalvarProdutoActionPerformed

    private void jBPesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarProdutoActionPerformed
        try {
            //  jTextPesquisaProduto.setText("");  //Limpa o campo antes de fazer qualquer coisa (descartado por nao se aplicar a situação).
            listarProduto();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBPesquisarProdutoActionPerformed

    private void jBExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirProdutoActionPerformed
        try {
            excluirProduto();
            // mostraPesquisaProduto(produto);
            listarProduto();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no botao jBExluir");
        }
        try {
            // System.out.println("chamada do metodo: listarContatos() ");
            listarProduto();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " problemas no metodo listar da opcao excluir!");
        }
    }//GEN-LAST:event_jBExcluirProdutoActionPerformed

    private void jBAlterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarProdutoActionPerformed
        try {
            alteraProduto();
            listarProduto();  // nome do metodo certo é "listarProduto".
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBAlterarProdutoActionPerformed

    private void jBSalvarControleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarControleActionPerformed
        if (verificaDadosControle()) {
            cadastroControle();
            try {
                listarControle();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            //desabilitaDadosProduto();
        }

    }//GEN-LAST:event_jBSalvarControleActionPerformed

    private void jBNovoControleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoControleActionPerformed
        habilitaDadosControle();
        jTDataSaidaAgente.setText(dataSistema());   //pega a data do sistema
        jTHoraEntradaAgente.setText(horaSistema());

        // jComboArmeiro.(String.valueOf(setSelectedIndex("")));
        jTextId.setText("");
        jTDataControle.setText(dataSistema());
        jTAgente.setText("");
        jTCodProduto.setText("");
        jTDataEntradaAgente.setText(dataSistema());
        jTHoraEntradaAgente.setText(horaSistema());
        jTDataSaidaAgente.setText("");
        jTHoraSaidaAgente.setText("");
    }//GEN-LAST:event_jBNovoControleActionPerformed

    private void jTAgenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTAgenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAgenteActionPerformed

    private void jBFinalizarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFinalizarTurnoActionPerformed
        CargaDiaria c1 = new CargaDiaria();
        c1.setCautelado(false);
         //  Finalizar turno
    }//GEN-LAST:event_jBFinalizarTurnoActionPerformed

    private void jBPesquisarControleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarControleActionPerformed
        try {
            jTextPesquisaProduto.setText("");  //Limpa o campo antes de fazer qualquer coisa (descartado por nao se aplicar a situação).
            listarControle();

        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBPesquisarControleActionPerformed

    private void jBAlterarControleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarControleActionPerformed
        try {
            alteraControle();
            listarProduto();  // nome do metodo certo é "listarProduto".
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBAlterarControleActionPerformed

    private void jTextTipoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTipoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTipoProdutoActionPerformed

    private void jTHoraEntradaAgenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTHoraEntradaAgenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTHoraEntradaAgenteActionPerformed

    private void alteraContato() throws SQLException {
        if (jTTabela.getSelectedRow() != -1) {    // se a tabela nao for negativa...
            if (verificaDados()) {                // e se passar por esse metodo...

                Usuario c1 = new Usuario();
                UsuarioDao dao = new UsuarioDao();
                c1.setIdUsuario(Integer.parseInt(jTIdUsuario.getText()));
                c1.setMatricula(Long.valueOf(jTMatricula.getText()));
                c1.setNome(jTNome.getText());
                c1.setEndereco(jTEndereco.getText());
                c1.setEmail(jTEmail.getText());
                c1.setSexo(jTSexo.getText());
                c1.setSituacao(jTSituacao.getText());
                c1.setTelefone(jTTelefone.getText());

                dao.altera(c1);
                JOptionPane.showMessageDialog(null, "Contato Alterado com Sucesso!!");
            }
        }
    }

    private void alteraContatoLivro() throws SQLException {
        if (jTTabelaLivro.getSelectedRow() != -1) {    // se a tabela nao for negativa...
            if (verificaDadosLivroParte()) {                // e se passar por esse metodo...

                LivroParte c1 = new LivroParte();
                LivroParteDao dao = new LivroParteDao();
                c1.setId(Integer.parseInt(jTextIDLivro.getText()));
                c1.setNomeArmeiro(jTextNomeArmeiro.getText());
                c1.setDiaEntrada(jFormattedTextDataEntrada.getText());
                c1.setHoraEntrada(jFormattedTextHoraEntrada.getText());
                c1.setHistorico(jTextHistorico.getText());
                c1.setDiaSaida(jFormattedTextDataSaida.getText());
                c1.setHoraSaida(jFormattedTextHoraSaida.getText());

                dao.altera(c1);
                JOptionPane.showMessageDialog(null, "Contato Alterado com Sucesso!!");
            }
        }
    }

    private void alteraProduto() throws SQLException {
        if (jTableProduto.getSelectedRow() != -1) {    // se a tabela nao for negativa...
            if (verificaDadosProduto()) {                // e se passar por esse metodo...

                Produto c1 = new Produto();
                ProdutoDao dao = new ProdutoDao();
                c1.setIdProduto(Integer.parseInt(jTextIdProduto.getText()));
                c1.setCod(jTextCodProduto.getText());
                c1.setMarcaProduto(jTextMarcaProduto.getText());
                c1.setTipoProduto(jTextTipoProduto.getText());
                c1.setNumeroSerieProduto(jTextNumeroSerieProduto.getText());
                c1.setDescricaoProduto(jTextDescricaoProduto.getText());
                c1.setObservacaoProduto(jTextObservacaoProduto.getText());
                c1.setLocalizacaoProduto(jTextLocalizacaoProduto.getText());
                c1.setHistoricoManutencaoProduto(jTextHistoricoProduto.getText());

                dao.altera(c1);
                JOptionPane.showMessageDialog(null, "Produto Alterado com Sucesso!!");
            }
        }
    }

    private void alteraControle() throws SQLException {
        if (jTableProduto.getSelectedRow() != -1) {    // se a tabela nao for negativa...
            if (verificaDadosControle()) {                // e se passar por esse metodo...

                CargaDiaria p1 = new CargaDiaria();
                CargaDiariaDao dao = new CargaDiariaDao();
                p1.setId(Integer.parseInt(jTextId.getText()));
                p1.setDataArmeiroControle(jTDataControle.getText());
                p1.setArmeiroControle(String.valueOf(jComboArmeiro.getSelectedIndex()));
                p1.setAgenteControle(jTAgente.getText());
                p1.setCodproduto(jTCodProduto.getText());

                dao.altera(p1);
                JOptionPane.showMessageDialog(null, "Produto Alterado com Sucesso!!");
            }
        }
    }

    public void excluirContato() throws SQLException {
        int resp = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir esse registro?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_NO_OPTION) {
            UsuarioDao dao = new UsuarioDao();
            dao.remove(usuarios.get(jTTabela.getSelectedRow()));
        }
    }

    public void excluirContatoLivro() throws SQLException {
        int resp = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir esse registro?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_NO_OPTION) {
            LivroParteDao dao = new LivroParteDao();
            dao.remove(livroParte.get(jTTabelaLivro.getSelectedRow()));
        }
    }

    public void excluirProduto() throws SQLException {
        int resp = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir esse registro?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_NO_OPTION) {
            ProdutoDao dao = new ProdutoDao();
            dao.remove(produto.get(jTableProduto.getSelectedRow()));
        }
    }

    public void listarContatos() throws SQLException {
        UsuarioDao dao = new UsuarioDao();
        usuarios = dao.getLista("%" + jTPesquisar.getText() + "%");
        mostraPesquisa(usuarios);
        System.out.println("chamada do metodo: mostraPesquisa(usuarios) ");
    }

    public void listarLivroParte() throws SQLException {
        LivroParteDao dao = new LivroParteDao();
        livroParte = dao.getLista("%" + jTextPesquisaParte.getText() + "%");
        mostraPesquisaLivroParte(livroParte);
        System.out.println("chamada do metodo: mostraPesquisaLivroParte(LivroParte) ");
    }

    public void listarProduto() throws SQLException {
        ProdutoDao dao = new ProdutoDao();
        produto = dao.getLista("%" + jTextPesquisaProduto.getText() + "%");
        mostraPesquisaProduto(produto);
        System.out.println("chamada do metodo: mostraPesquisaProduto(produto) ");
    }

    public void listarControle() throws SQLException {
        CargaDiariaDao dao = new CargaDiariaDao();
        controle = dao.getLista("%" + jTPesquisaControle.getText() + "%");
        mostraPesquisaControle(controle);
        System.out.println("chamada do metodo: mostraPesquisaProduto(produto) ");
    }

    public void cadastroLivroParte() {
        LivroParte p1 = new LivroParte();
        p1.setNomeArmeiro(jTextNomeArmeiro.getText());
        p1.setDiaEntrada(jFormattedTextDataEntrada.getText());
        p1.setHoraEntrada(jFormattedTextHoraEntrada.getText());
        p1.setHistorico(jTextHistorico.getText());
        p1.setDiaSaida(jFormattedTextDataSaida.getText());
        p1.setHoraSaida(jFormattedTextHoraSaida.getText());

        LivroParteDao dao;
        try {
            dao = new LivroParteDao();
            dao.adiciona(p1);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cadastroControle() throws ParseException {
        CargaDiaria controle = new CargaDiaria();
        controle.setArmeiroControle(jTextArmeiroControle.getText());
        controle.setDataArmeiroControle(jTDataControle.getText());
        controle.setAgenteControle(jTAgente.getText());
        controle.setCodproduto(jTCodProduto.getText());
        controle.setObservacao(jTObservacao.getText());
        Date createdAt = Converter.stringToDate(jTDataEntradaAgente.getText());
        controle.setCreatedAt(createdAt);
        controle.setCautelado(true);
        controle.setDia2(jTDataSaidaAgente.getText());
        controle.setHora2(jTHoraSaidaAgente.getText());

        CargaDiariaDao dao;
        try {
            dao = new CargaDiariaDao();
            dao.adiciona(controle);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cadastro() {
        Usuario c1 = new Usuario();
        //  c1.setIdUsuario(Integer.parseInt(jTIdUsuario.getText()));   Nao precisa no cadastro
        c1.setMatricula(Long.valueOf(jTMatricula.getText()));
        c1.setNome(jTNome.getText());
        c1.setEndereco(jTEndereco.getText());
        c1.setEmail(jTEmail.getText());
        c1.setSexo(jTSexo.getText());
        c1.setSituacao(jTSituacao.getText());
        c1.setTelefone(jTTelefone.getText());

        UsuarioDao dao;
        try {
            dao = new UsuarioDao();
            dao.adiciona(c1);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cadastroProduto() {
        Produto c1 = new Produto();
        //  c1.setIdProduto(Integer.parseInt(jTextIdProduto.getText()));   Nao precisa no cadastro
        c1.setCod(jTextCodProduto.getText());
        c1.setMarcaProduto(jTextMarcaProduto.getText());
        c1.setTipoProduto(jTextTipoProduto.getText());
        c1.setNumeroSerieProduto(jTextNumeroSerieProduto.getText());
        c1.setDescricaoProduto(jTextDescricaoProduto.getText());
        c1.setObservacaoProduto(jTextObservacaoProduto.getText());
        c1.setLocalizacaoProduto(jTextLocalizacaoProduto.getText());
        c1.setHistoricoManutencaoProduto(jTextHistoricoProduto.getText());

        ProdutoDao dao;
        try {
            dao = new ProdutoDao();
            dao.adiciona(c1);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBAlterarControle;
    private javax.swing.JButton jBAlterarParte;
    private javax.swing.JButton jBAlterarProduto;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBExcluirControle;
    private javax.swing.JButton jBExcluirParte;
    private javax.swing.JButton jBExcluirProduto;
    private javax.swing.JButton jBFinalizarTurno;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBNovoControle;
    private javax.swing.JButton jBNovoParte;
    private javax.swing.JButton jBNovoProduto;
    private javax.swing.JButton jBPesquisaParte;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JButton jBPesquisarControle;
    private javax.swing.JButton jBPesquisarProduto;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JButton jBSalvarControle;
    private javax.swing.JButton jBSalvarParte;
    private javax.swing.JButton jBSalvarProduto;
    private javax.swing.JComboBox<Object> jComboArmeiro;
    private javax.swing.JFormattedTextField jFormattedTextDataEntrada;
    private javax.swing.JFormattedTextField jFormattedTextDataSaida;
    private javax.swing.JFormattedTextField jFormattedTextHoraEntrada;
    private javax.swing.JFormattedTextField jFormattedTextHoraSaida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelMatricula;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelSituacao;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTAgente;
    private javax.swing.JTextField jTCodProduto;
    private javax.swing.JTextField jTDataControle;
    private javax.swing.JTextField jTDataEntradaAgente;
    private javax.swing.JTextField jTDataSaidaAgente;
    private javax.swing.JTextField jTEmail;
    private javax.swing.JTextField jTEndereco;
    private javax.swing.JTextField jTHoraEntradaAgente;
    private javax.swing.JTextField jTHoraSaidaAgente;
    private javax.swing.JTextField jTIdUsuario;
    private javax.swing.JTextField jTMatricula;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTObservacao;
    private javax.swing.JTextField jTPesquisaControle;
    private javax.swing.JTextField jTPesquisar;
    private javax.swing.JTextField jTSexo;
    private javax.swing.JTextField jTSituacao;
    private javax.swing.JTable jTTabela;
    private javax.swing.JTable jTTabelaLivro;
    private javax.swing.JTextField jTTelefone;
    private javax.swing.JTabbedPane jTabbedUsuarios;
    private javax.swing.JTable jTableControle;
    private javax.swing.JTable jTableProduto;
    private javax.swing.JTextField jTextArmeiroControle;
    private javax.swing.JTextField jTextCodProduto;
    private javax.swing.JTextField jTextDescricaoProduto;
    private javax.swing.JTextArea jTextHistorico;
    private javax.swing.JTextArea jTextHistoricoProduto;
    private javax.swing.JTextField jTextIDLivro;
    private javax.swing.JTextField jTextId;
    private javax.swing.JTextField jTextIdProduto;
    private javax.swing.JTextField jTextLocalizacaoProduto;
    private javax.swing.JTextField jTextMarcaProduto;
    private javax.swing.JTextField jTextNomeArmeiro;
    private javax.swing.JTextField jTextNumeroSerieProduto;
    private javax.swing.JTextField jTextObservacaoProduto;
    private javax.swing.JTextField jTextPesquisaParte;
    private javax.swing.JTextField jTextPesquisaProduto;
    private javax.swing.JTextField jTextTipoProduto;
    // End of variables declaration//GEN-END:variables

    private void mostraPesquisa(List<Usuario> usuarios) {
        while (tmUsuario.getRowCount() > 0) {           // trecho de codigo para que serve para,
            tmUsuario.removeRow(0);               // exibir somente as linhas selecionadas.
        }
        if (usuarios.size() == 0) {                     //if para comparar se a lista esta vazia, dai nem exibirá a lista
            JOptionPane.showMessageDialog(null, "Nenhun usuario cadastrado!");
        } else {
            String[] linha = new String[]{null, null, null, null, null, null, null};    //cria um vetor de string de nome "linha" 
            //para receber os dados da lista que vem do banco. sempre inicia com nulo.
            // o for adiciona os valores na jtable
            for (int i = 0; i < usuarios.size(); i++) {
                tmUsuario.addRow(linha);
                tmUsuario.setValueAt(usuarios.get(i).getIdUsuario(), i, 0);
                tmUsuario.setValueAt(usuarios.get(i).getMatricula(), i, 1);
                tmUsuario.setValueAt(usuarios.get(i).getNome(), i, 2);
                tmUsuario.setValueAt(usuarios.get(i).getEndereco(), i, 3);
                tmUsuario.setValueAt(usuarios.get(i).getTelefone(), i, 4);
                tmUsuario.setValueAt(usuarios.get(i).getEmail(), i, 5);
                tmUsuario.setValueAt(usuarios.get(i).getSexo(), i, 6);
                tmUsuario.setValueAt(usuarios.get(i).getSituacao(), i, 7);
            }
        }
    }

    private void mostraPesquisaLivroParte(List<LivroParte> livroParte) {
        while (tmLivroParte.getRowCount() > 0) {          // trecho de codigo para que serve para,
            tmLivroParte.removeRow(0);                // exibir somente as linhas selecionadas.
        }
        if (livroParte.size() == 0) {   //if para comparar se a lista esta vazia, dai nem exibirá a lista
            JOptionPane.showMessageDialog(null, "Nenhun usuario cadastrado!");
        } else {
            String[] linha = new String[]{null, null, null, null, null, null, null};    //cria um vetor de string de nome "linha" 
            //para receber os dados da lista que vem do banco. sempre inicia com nulo.
            // o for adiciona os valores na jtable
            for (int i = 0; i < livroParte.size(); i++) {
                tmLivroParte.addRow(linha);
                tmLivroParte.setValueAt(livroParte.get(i).getId(), i, 0);
                tmLivroParte.setValueAt(livroParte.get(i).getNomeArmeiro(), i, 1);
                tmLivroParte.setValueAt(livroParte.get(i).getDiaEntrada(), i, 2);
                tmLivroParte.setValueAt(livroParte.get(i).getHoraEntrada(), i, 3);
                tmLivroParte.setValueAt(livroParte.get(i).getHistorico(), i, 4);
                tmLivroParte.setValueAt(livroParte.get(i).getDiaSaida(), i, 5);
                tmLivroParte.setValueAt(livroParte.get(i).getHoraSaida(), i, 6);
            }
        }
    }

    private void mostraPesquisaProduto(List<Produto> produto) {
        while (tmProduto.getRowCount() > 0) {          // trecho de codigo para que serve para,
            tmProduto.removeRow(0);                // exibir somente as linhas selecionadas.
        }
        if (produto.size() == 0) {   //if para comparar se a lista esta vazia, dai nem exibirá a lista
            JOptionPane.showMessageDialog(null, "Nenhun usuario cadastrado!");
        } else {
            String[] linha = new String[]{null, null, null, null, null, null, null, null, null};    //cria um vetor de string de nome "linha" 
            //para receber os dados da lista que vem do banco. sempre inicia com nulo.
            // o for adiciona os valores na jtable
            for (int i = 0; i < produto.size(); i++) {
                tmProduto.addRow(linha);
                tmProduto.setValueAt(produto.get(i).getIdProduto(), i, 0);
                tmProduto.setValueAt(produto.get(i).getCod(), i, 1);
                tmProduto.setValueAt(produto.get(i).getMarcaProduto(), i, 2);
                tmProduto.setValueAt(produto.get(i).getTipoProduto(), i, 3);
                tmProduto.setValueAt(produto.get(i).getNumeroSerieProduto(), i, 4);
                tmProduto.setValueAt(produto.get(i).getDescricaoProduto(), i, 5);
                tmProduto.setValueAt(produto.get(i).getObservacaoProduto(), i, 6);
                tmProduto.setValueAt(produto.get(i).getLocalizacaoProduto(), i, 7);
                tmProduto.setValueAt(produto.get(i).getHistoricoManutencaoProduto(), i, 8);
            }
        }
    }

    private void mostraPesquisaControle(List<CargaDiaria> cargaDiaria) {
        while (tmControle.getRowCount() > 0) {          // trecho de codigo para que serve para,
            tmControle.removeRow(0);                // exibir somente as linhas selecionadas.
        }
        if (cargaDiaria.size() == 0) {   //if para comparar se a lista esta vazia, dai nem exibirá a lista
            JOptionPane.showMessageDialog(null, "Nenhun usuario cadastrado!");
        } else {
            String[] linha = new String[]{null, null, null, null, null, null, null, null, null, null, null};    //cria um vetor de string de nome "linha" 
            // para receber os dados da lista que vem do banco. sempre inicia com nulo.
            // o for adiciona os valores na jtable

            for (int i = 0; i < cargaDiaria.size(); i++) {
                tmControle.addRow(linha);
                tmControle.setValueAt(cargaDiaria.get(i).getId(), i, 0);
                tmControle.setValueAt(cargaDiaria.get(i).getDataArmeiroControle(), i, 1);
                tmControle.setValueAt(cargaDiaria.get(i).getArmeiroControle(), i, 2);
                tmControle.setValueAt(cargaDiaria.get(i).getAgenteControle(), i, 3);
                tmControle.setValueAt(cargaDiaria.get(i).getCodproduto(), i, 4);
                tmControle.setValueAt(cargaDiaria.get(i).getObservacao(), i, 5);
                String createdAt = Converter.dateToString(cargaDiaria.get(i).getCreatedAt());
                tmControle.setValueAt(createdAt, i, 6);
                String labelCautelado = Formatter.getLabelSimOuNao(cargaDiaria.get(i).isCautelado());
                tmControle.setValueAt(labelCautelado, i, 7);
                tmControle.setValueAt(cargaDiaria.get(i).getDia2(), i, 8);
                tmControle.setValueAt(cargaDiaria.get(i).getHora2(), i, 9);
            }
        }
    }

    //AQUI
    public void preencherComboGuarda() throws SQLException {

        jComboArmeiro.removeAllItems();
        UsuarioDao user = new UsuarioDao();

        List<Usuario> listaUser = user.listarGuardas();

        for (Usuario u : listaUser) {

            jComboArmeiro.addItem(u.getNome());

        }

    }

}
