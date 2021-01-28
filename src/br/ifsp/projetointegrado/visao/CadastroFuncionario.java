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
public class CadastroFuncionario extends javax.swing.JDialog {

    /**
     * Creates new form VisaoCadastroCategoria
     */
    
    private FuncionarioDAO controleFuncionario = new CategoriaDAO();
    private List<Categoria> listaFuncionario = new ArrayList();
    private Usuario usuario;
          
    Categoria c = new Categoria();
    
    public CadastroFuncionario(java.awt.Frame parent, boolean modal) {
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

        txtNome = new javax.swing.JTextField();
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
        lNome = new javax.swing.JLabel();
        lNome1 = new javax.swing.JLabel();
        txtNome1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtNome.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N

        panelCabecalho1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cadastrar Funcionario");

        javax.swing.GroupLayout panelCabecalho1Layout = new javax.swing.GroupLayout(panelCabecalho1);
        panelCabecalho1.setLayout(panelCabecalho1Layout);
        panelCabecalho1Layout.setHorizontalGroup(
            panelCabecalho1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabecalho1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
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

        lNome.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        lNome.setText("Nome:");

        lNome1.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        lNome1.setText("Turno:");

        txtNome1.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        txtNome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCabecalho1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lNome)
                        .addGap(8, 8, 8)
                        .addComponent(txtNome))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lNome1)
                        .addGap(8, 8, 8)
                        .addComponent(txtNome1)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCabecalho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome1)
                    .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
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

    private void txtNome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome1ActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlterar;
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bExcluir;
    private javax.swing.JButton bPesquisar;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lNome;
    private javax.swing.JLabel lNome1;
    private javax.swing.JPanel panelCabecalho1;
    private javax.swing.JTable tabelaFuncionario;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNome1;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
