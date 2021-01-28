/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.projetointegrado.visao;

import br.com.tranoticia.dao.CategoriaDAO;
import br.com.tranoticia.modelo.Categoria;
import br.com.tranoticia.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Programar
 */
public class CadastroEscala extends javax.swing.JDialog {

    /**
     * Creates new form VisaoCadastroCategoria
     */
    
    private FuncionarioDAO controleFuncionario = new CategoriaDAO();
    private List<Categoria> listaFuncionario = new ArrayList();
    private Usuario usuario;
          
    Categoria c = new Categoria();
    
    public CadastroEscala(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregarLista();
        atualizaTabela();
       // trataEdicao(false);
    }
    
 
    
     public void atualizaTabela() {
        DefaultTableModel dtm = (DefaultTableModel) tabelaFuncionario.getModel(); // manipulador de tabela DefaultTableModel
        dtm.setNumRows(0);//apagando todas as linhas / o zero serva para apagar as linhas "é muito rapido"
        for (Categoria cat : listaFuncionario) {
            //String.format("%.2f",f.getPrecoUnitario()) -> mostra com duas casa apos a virgula
            dtm.addRow(new Object[]{cat.getId(),cat.getDescricao()}); // Object é um vetor ou coleção com ele não pecisa converter
        }
    }
     /// recebe dados que principal mandou
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        if (this.usuario.getTipo().equals("padrao"))
        {
            bCadastrar.setEnabled(false);
        }
    }
     
     public void limparCampos() {
        txtNome.setText("");
        txtPesquisa.setText("");
    }
     
    public void carregarLista() {
        listaFuncionario = controleFuncionario.buscar();
    }

    public void pesquisar() {
        String str = "from Categoria cat ";
        String atributo = "cat.descricao";

        String filtro = txtPesquisa.getText();

        if (filtro.length() > 0 && filtro != null) {
            str += "where upper (" + atributo + ") like '%" + filtro.toUpperCase() + "%' ";
        }

        str += "order by " + atributo;
        pesquisarDinamico(str);//ATUALIZA A LISTA COM OS DADOS DESTA PESQUISA DINAMICA
        atualizaTabela();//PREENCHE COM OS NOVOS DADOS
    }

    public void pesquisarDinamico(String comando) {
        this.listaFuncionario = controleFuncionario.buscarPorColsulta(comando);
    }
    
     public void vincularCampos() {
        Categoria b = listaFuncionario.get(tabelaFuncionario.getSelectedRow());// pega a linha da tabela
        txtNome.setText(b.getDescricao());
    }
    
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCabecalho1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        bPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFuncionario = new javax.swing.JTable();
        txtPesquisa = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        bCadastrar = new javax.swing.JButton();
        bAlterar = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();
        lNome27 = new javax.swing.JLabel();
        jComboBox26 = new javax.swing.JComboBox<>();
        lNome28 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lNome1 = new javax.swing.JLabel();
        txtNome1 = new javax.swing.JTextField();
        lNome29 = new javax.swing.JLabel();
        txtNome2 = new javax.swing.JTextField();
        lNome30 = new javax.swing.JLabel();
        txtNome3 = new javax.swing.JTextField();
        lNome31 = new javax.swing.JLabel();
        txtNome4 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jComboBox10 = new javax.swing.JComboBox<>();
        lNome16 = new javax.swing.JLabel();
        lNome19 = new javax.swing.JLabel();
        jComboBox20 = new javax.swing.JComboBox<>();
        jComboBox17 = new javax.swing.JComboBox<>();
        jComboBox12 = new javax.swing.JComboBox<>();
        lNome21 = new javax.swing.JLabel();
        lNome17 = new javax.swing.JLabel();
        lNome11 = new javax.swing.JLabel();
        jComboBox15 = new javax.swing.JComboBox<>();
        jComboBox16 = new javax.swing.JComboBox<>();
        lNome15 = new javax.swing.JLabel();
        jComboBox14 = new javax.swing.JComboBox<>();
        lNome20 = new javax.swing.JLabel();
        lNome13 = new javax.swing.JLabel();
        lNome12 = new javax.swing.JLabel();
        lNome18 = new javax.swing.JLabel();
        jComboBox11 = new javax.swing.JComboBox<>();
        jComboBox18 = new javax.swing.JComboBox<>();
        jComboBox19 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        lNome = new javax.swing.JLabel();
        lNome2 = new javax.swing.JLabel();
        jcbDiretorNucleo = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox28 = new javax.swing.JComboBox<>();
        lNome32 = new javax.swing.JLabel();
        jComboBox29 = new javax.swing.JComboBox<>();
        lNome33 = new javax.swing.JLabel();
        jComboBox30 = new javax.swing.JComboBox<>();
        lNome34 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox31 = new javax.swing.JComboBox<>();
        lNome35 = new javax.swing.JLabel();
        lNome36 = new javax.swing.JLabel();
        jComboBox32 = new javax.swing.JComboBox<>();
        jComboBox33 = new javax.swing.JComboBox<>();
        lNome37 = new javax.swing.JLabel();
        lNome38 = new javax.swing.JLabel();
        jComboBox34 = new javax.swing.JComboBox<>();
        jComboBox35 = new javax.swing.JComboBox<>();
        lNome39 = new javax.swing.JLabel();
        jComboBox36 = new javax.swing.JComboBox<>();
        lNome40 = new javax.swing.JLabel();
        lNome41 = new javax.swing.JLabel();
        jComboBox37 = new javax.swing.JComboBox<>();
        lNome42 = new javax.swing.JLabel();
        jComboBox38 = new javax.swing.JComboBox<>();
        jComboBox39 = new javax.swing.JComboBox<>();
        lNome43 = new javax.swing.JLabel();
        jComboBox40 = new javax.swing.JComboBox<>();
        lNome44 = new javax.swing.JLabel();
        jComboBox41 = new javax.swing.JComboBox<>();
        lNome45 = new javax.swing.JLabel();
        jComboBox42 = new javax.swing.JComboBox<>();
        lNome46 = new javax.swing.JLabel();
        jComboBox43 = new javax.swing.JComboBox<>();
        lNome47 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelCabecalho1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cadastrar Escalas de Serviços");

        javax.swing.GroupLayout panelCabecalho1Layout = new javax.swing.GroupLayout(panelCabecalho1);
        panelCabecalho1.setLayout(panelCabecalho1Layout);
        panelCabecalho1Layout.setHorizontalGroup(
            panelCabecalho1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabecalho1Layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCabecalho1Layout.setVerticalGroup(
            panelCabecalho1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabecalho1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bPesquisar.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        bPesquisar.setText("Pesquisa:");
        bPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesquisarActionPerformed(evt);
            }
        });

        tabelaFuncionario.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tabelaFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Turno"
            }
        ));
        tabelaFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFuncionario);

        txtPesquisa.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bCadastrar.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        bCadastrar.setText("Cadastrar");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });

        bAlterar.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        bAlterar.setText("Alterar");
        bAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlterarActionPerformed(evt);
            }
        });

        bExcluir.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        bExcluir.setText("Excluir");
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bCadastrar)
                .addGap(18, 18, 18)
                .addComponent(bAlterar)
                .addGap(18, 18, 18)
                .addComponent(bExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCadastrar)
                    .addComponent(bAlterar)
                    .addComponent(bExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lNome27.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome27.setText("Eletricista/Motorista:");

        jComboBox26.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox26.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox26ActionPerformed(evt);
            }
        });

        lNome28.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome28.setText("ASP em Serviço externo");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Unicode MS", 1, 18), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(204, 0, 0));

        lNome1.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome1.setText("Convocação DEGEP:");

        txtNome1.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        txtNome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome1ActionPerformed(evt);
            }
        });

        lNome29.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome29.setText("Convocação Horas");

        txtNome2.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        txtNome2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome2ActionPerformed(evt);
            }
        });

        lNome30.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome30.setText("Convocação Pantrão:");

        txtNome3.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        txtNome3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome3ActionPerformed(evt);
            }
        });

        lNome31.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome31.setText("Permutas:");

        txtNome4.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        txtNome4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lNome1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lNome30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lNome29)
                    .addComponent(lNome31))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome1)
                    .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNome29)
                    .addComponent(txtNome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome31)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lNome30)
                        .addComponent(txtNome3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNome4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gaiolas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Unicode MS", 1, 18))); // NOI18N

        jComboBox10.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lNome16.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome16.setText("Zelador do 3º Raio");

        lNome19.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome19.setText("Auxiliar do 3º Raio");

        jComboBox20.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox20.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox17.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox12.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lNome21.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome21.setText("Auxiliar do 4º Raio");

        lNome17.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome17.setText("Zelador do 4º Raio");

        lNome11.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome11.setText("Zelador do 1º Raio");

        jComboBox15.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox16.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lNome15.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome15.setText("Zelador do 2º Raio");

        jComboBox14.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lNome20.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome20.setText("Auxiliar do 2º Raio");

        lNome13.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome13.setText("3º Gaiola");

        lNome12.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome12.setText("1º Gaiola");

        lNome18.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome18.setText("Auxiliar do 1º Raio");

        jComboBox11.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox18.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox19.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox19.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lNome11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lNome12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(lNome15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lNome18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox17, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lNome20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox19, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(147, 147, 147)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(lNome17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox16, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lNome13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lNome16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lNome19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lNome21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox20, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(277, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome12)
                    .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNome13)
                    .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome11)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNome16)
                    .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lNome19)
                            .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lNome15)
                            .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lNome17)
                            .addComponent(jComboBox16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lNome20)
                            .addComponent(jComboBox19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lNome21)
                            .addComponent(jComboBox20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lNome18)
                            .addComponent(jComboBox17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Postos de Trabalho", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Unicode MS", 1, 18))); // NOI18N

        lNome.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome.setText("Diretor de Nucleo:");

        lNome2.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome2.setText("Diretor de Nucleo Substituto:");

        jcbDiretorNucleo.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jcbDiretorNucleo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox28.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox28.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lNome32.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome32.setText("Pavilhão Hospitalar");

        jComboBox29.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox29.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lNome33.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome33.setText("Pavilhão Disciplinar");

        jComboBox30.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox30.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lNome34.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome34.setText("Féria:");

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel2.setText("(Após as 04H00 horas.)");

        jComboBox31.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox31.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lNome35.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome35.setText("Pavilhão de Inclusão");

        lNome36.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome36.setText("Faltas");

        jComboBox32.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox32.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox33.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox33.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lNome37.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome37.setText("Ala de Progressão:");

        lNome38.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome38.setText("Folgas");

        jComboBox34.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox34.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox35.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox35.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lNome39.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome39.setText("Abonos");

        jComboBox36.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox36.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lNome40.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome40.setText("Licença Prêmio");

        lNome41.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome41.setText("Eletricista/Motorista:");

        jComboBox37.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox37.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox37ActionPerformed(evt);
            }
        });

        lNome42.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome42.setText("ASP em Serviço externo");

        jComboBox38.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox38.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox38ActionPerformed(evt);
            }
        });

        jComboBox39.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox39.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lNome43.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome43.setText("Licença Saúde");

        jComboBox40.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox40.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lNome44.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome44.setText("Sub_Portaria");

        jComboBox41.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox41.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lNome45.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome45.setText("Portaria");

        jComboBox42.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox42.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lNome46.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome46.setText("Revisora:");

        jComboBox43.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jComboBox43.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lNome47.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lNome47.setText("Cozinha");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbDiretorNucleo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(65, 65, 65)
                        .addComponent(lNome2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lNome38)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox35, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lNome34)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox31, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lNome36)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox33, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(lNome40)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox39, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lNome39)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox36, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lNome43)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox40, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lNome32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox29, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lNome33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox30, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lNome35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox32, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lNome47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox28, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(lNome46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox43, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lNome41)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox37, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lNome44)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox41, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(lNome45)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox42, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lNome37)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox34, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lNome42)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox38, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome)
                    .addComponent(jcbDiretorNucleo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNome2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome34)
                    .addComponent(jComboBox31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNome36)
                    .addComponent(jComboBox33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNome40)
                    .addComponent(jComboBox39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome38)
                    .addComponent(jComboBox35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNome39)
                    .addComponent(jComboBox36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNome43)
                    .addComponent(jComboBox40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome47)
                    .addComponent(jComboBox28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(lNome46)
                    .addComponent(jComboBox43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome32)
                    .addComponent(jComboBox29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNome33)
                    .addComponent(jComboBox30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNome35)
                    .addComponent(jComboBox32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome44)
                    .addComponent(jComboBox41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNome45)
                    .addComponent(jComboBox42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNome37)
                    .addComponent(jComboBox34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome41)
                    .addComponent(jComboBox37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNome42)
                    .addComponent(jComboBox38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCabecalho1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lNome27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox26, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lNome28)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(bPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCabecalho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome27)
                    .addComponent(jComboBox26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNome28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bPesquisarActionPerformed

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
       if (!txtNome.getText().equals("")) {
                    c.setDescricao(txtNome.getText());
                    controleFuncionario.alterar(c);
                    carregarLista();
                    atualizaTabela();
                    limparCampos();
                    //trataEdicao(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Informe A descrição", "Alerta", JOptionPane.WARNING_MESSAGE);
                }
    }//GEN-LAST:event_bCadastrarActionPerformed

    
    
    private void bAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlterarActionPerformed
        if (tabelaFuncionario.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela para alterar", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
           c = listaFuncionario.get(tabelaFuncionario.getSelectedRow());
           txtNome.requestFocus();
        }
        carregarLista();
        atualizaTabela();
    }//GEN-LAST:event_bAlterarActionPerformed
  
    
    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed

//        int linha = tabelaCategoria.getSelectedRow();
//        if (linha != -1) {
//            Categoria b = listaCategorias.get(tabelaCategoria.getSelectedRow());
//            controleCategoria.remover(b);
//            JOptionPane.showMessageDialog(null, "Registro excluído.");
//            carregarLista();
//            atualizaTabela();
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Selecione um registro na tabela.");
//        }

        if (tabelaFuncionario.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela para excluir", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            Categoria b = listaFuncionario.get(tabelaFuncionario.getSelectedRow());
            controleFuncionario.remover(b);
        }
        carregarLista();
        atualizaTabela();
    }//GEN-LAST:event_bExcluirActionPerformed

    private void tabelaFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncionarioMouseClicked
        // TODO add your handling code here:
        vincularCampos();
    }//GEN-LAST:event_tabelaFuncionarioMouseClicked

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        // TODO add your handling code here:
        pesquisar();
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void jComboBox26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox26ActionPerformed

    private void jComboBox37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox37ActionPerformed

    private void jComboBox38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox38ActionPerformed

    private void txtNome4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome4ActionPerformed

    private void txtNome3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome3ActionPerformed

    private void txtNome2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome2ActionPerformed

    private void txtNome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome1ActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlterar;
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bExcluir;
    private javax.swing.JButton bPesquisar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JComboBox<String> jComboBox15;
    private javax.swing.JComboBox<String> jComboBox16;
    private javax.swing.JComboBox<String> jComboBox17;
    private javax.swing.JComboBox<String> jComboBox18;
    private javax.swing.JComboBox<String> jComboBox19;
    private javax.swing.JComboBox<String> jComboBox20;
    private javax.swing.JComboBox<String> jComboBox26;
    private javax.swing.JComboBox<String> jComboBox28;
    private javax.swing.JComboBox<String> jComboBox29;
    private javax.swing.JComboBox<String> jComboBox30;
    private javax.swing.JComboBox<String> jComboBox31;
    private javax.swing.JComboBox<String> jComboBox32;
    private javax.swing.JComboBox<String> jComboBox33;
    private javax.swing.JComboBox<String> jComboBox34;
    private javax.swing.JComboBox<String> jComboBox35;
    private javax.swing.JComboBox<String> jComboBox36;
    private javax.swing.JComboBox<String> jComboBox37;
    private javax.swing.JComboBox<String> jComboBox38;
    private javax.swing.JComboBox<String> jComboBox39;
    private javax.swing.JComboBox<String> jComboBox40;
    private javax.swing.JComboBox<String> jComboBox41;
    private javax.swing.JComboBox<String> jComboBox42;
    private javax.swing.JComboBox<String> jComboBox43;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbDiretorNucleo;
    private javax.swing.JLabel lNome;
    private javax.swing.JLabel lNome1;
    private javax.swing.JLabel lNome11;
    private javax.swing.JLabel lNome12;
    private javax.swing.JLabel lNome13;
    private javax.swing.JLabel lNome15;
    private javax.swing.JLabel lNome16;
    private javax.swing.JLabel lNome17;
    private javax.swing.JLabel lNome18;
    private javax.swing.JLabel lNome19;
    private javax.swing.JLabel lNome2;
    private javax.swing.JLabel lNome20;
    private javax.swing.JLabel lNome21;
    private javax.swing.JLabel lNome27;
    private javax.swing.JLabel lNome28;
    private javax.swing.JLabel lNome29;
    private javax.swing.JLabel lNome30;
    private javax.swing.JLabel lNome31;
    private javax.swing.JLabel lNome32;
    private javax.swing.JLabel lNome33;
    private javax.swing.JLabel lNome34;
    private javax.swing.JLabel lNome35;
    private javax.swing.JLabel lNome36;
    private javax.swing.JLabel lNome37;
    private javax.swing.JLabel lNome38;
    private javax.swing.JLabel lNome39;
    private javax.swing.JLabel lNome40;
    private javax.swing.JLabel lNome41;
    private javax.swing.JLabel lNome42;
    private javax.swing.JLabel lNome43;
    private javax.swing.JLabel lNome44;
    private javax.swing.JLabel lNome45;
    private javax.swing.JLabel lNome46;
    private javax.swing.JLabel lNome47;
    private javax.swing.JPanel panelCabecalho1;
    private javax.swing.JTable tabelaFuncionario;
    private javax.swing.JTextField txtNome1;
    private javax.swing.JTextField txtNome2;
    private javax.swing.JTextField txtNome3;
    private javax.swing.JTextField txtNome4;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
