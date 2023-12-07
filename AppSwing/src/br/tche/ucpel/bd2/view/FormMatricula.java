/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.tche.ucpel.bd2.view;

import br.tche.ucpel.bd2.bean.Aluno;
import br.tche.ucpel.bd2.bean.Disciplina;
import br.tche.ucpel.bd2.bean.Matricula;
import br.tche.ucpel.bd2.dao.AlunoDAO;
import br.tche.ucpel.bd2.dao.DisciplinaDAO;
import br.tche.ucpel.bd2.dao.MatriculaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leomarotta
 */
public class FormMatricula extends javax.swing.JInternalFrame {

    private JFrame mdi;    
    private Connection conexao;
    private DisciplinaDAO disciplinaDAO;
    private AlunoDAO alunoDAO;
    
    /**
     * Creates new form FormMatricula
     */
    public FormMatricula(JFrame mdi) {
        this.mdi = mdi;
        initComponents();
        setClosable(true);
        setIconifiable(true);
        this.conexao = conexao;
        this.disciplinaDAO = new DisciplinaDAO(conexao);
        this.alunoDAO = new AlunoDAO(conexao);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNome = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btLimpar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAlunos = new javax.swing.JTable();
        btAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Matricula");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel1.setText("Código");

        jLabel2.setText("Nome:");

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        tbAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Endereço", "Telefone"
            }
        ));
        tbAlunos.setToolTipText("");
        tbAlunos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAlunosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbAlunos);

        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAtualizar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btExcluir)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btSalvar)
                    .addComponent(btLimpar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAtualizar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        this.limpaTela();
    }//GEN-LAST:event_btLimparActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        try {
            MatriculaDAO matriculaDAO = new MatriculaDAO(MDISistema.getConexao());
            int cod = this.intCampoTelas(txtCodigo.getText());
            if (cod > 0) {
                Disciplina disciplinaAssociada = disciplinaDAO.retrieve(new Disciplina(txtCodigo));
                Aluno alunoAssociado = alunoDAO.retrieve(new Aluno(txtCodigo));
                Matricula matricula = new Matricula(cod, txtNome.getText(), disciplinaAssociada, alunoAssociado); 
                matriculaDAO.create(matricula);
            } else {
                Matricula matricula = new Matricula(0, txtNome.getText(), new Disciplina(), new Aluno());
                matriculaDAO.create(matricula);
                txtCodigo.setText(Integer.toString(matricula.getCod()));
            }
            JOptionPane.showMessageDialog(mdi, "Registro Salvo");
            limpaTela();
            atualizaLista();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(mdi, String.format("Erro ao salvar matrícula: %s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FormMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        try {
            int cod = this.intCampoTelas(txtCodigo.getText());
            if (cod > 0) {
                Matricula matricula = new Matricula(cod);
                MatriculaDAO matriculaDAO = new MatriculaDAO(MDISistema.getConexao());
                matriculaDAO.delete(matricula);
                limpaTela();
                atualizaLista();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(mdi, String.format("Erro ao excluir matrícula: %s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FormMatricula.class.getName()).log(Level.WARNING, "Erro ao excluir matrícula", ex);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void tbAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAlunosMouseClicked
        if (evt.getClickCount() > 1) {
            JTable obj = (JTable) evt.getComponent();
            int linha = obj.getSelectedRow();
            Integer cod = (Integer) obj.getModel().getValueAt(linha, 0);
            Matricula matricula = new Matricula(cod);
            preencheTelaMatricula(matricula); // Chame o método para preencher os campos com os dados da matrícula
        }
    }//GEN-LAST:event_tbAlunosMouseClicked

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        this.atualizaLista();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private int intCampoTelas(String valor) {
        int ret = 0;
        try {
            ret = Integer.parseInt(valor);
        } catch (NumberFormatException ex) {
        }
        return ret;
    }
    
    private void limpaTela() {
        txtCodigo.setEnabled(true);
        txtCodigo.setText(null);
        txtNome.setText(null);
        txtEndereco.setText(null);
        txtTelefone.setText(null);
    }   
   
   
    private void atualizaLista() {
        try {
            MatriculaDAO matriculaDAO = new MatriculaDAO(MDISistema.getConexao());
            List<Matricula> lista = matriculaDAO.listaTodos();
            DefaultTableModel dtm = (DefaultTableModel) tbAlunos.getModel();
            dtm.setRowCount(0);
            for (Matricula matricula : lista) {
                // Assuming getDisciplina() and getAluno() methods in Matricula class
                Disciplina disciplina = matricula.getDisciplina();
                Aluno aluno = matricula.getAluno();

                dtm.addRow(new Object[]{matricula.getCod(), matricula.getNome(), aluno.getEndereco(), aluno.getTelefone(), disciplina.getNome(), disciplina.getProfessor()});
            }
            dtm.fireTableDataChanged();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(mdi, String.format("Erro ao ler as Matrículas: %s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FormMatricula.class.getName()).log(Level.WARNING, "Erro ao ler as Matrículas", ex);
        }
    }

    
    private boolean preencheTelaMatricula(Matricula matricula) {
        boolean ret = false;
        try {
            MatriculaDAO matriculaDAO = new MatriculaDAO(MDISistema.getConexao());
            matricula = matriculaDAO.retrieve(matricula);
            if (matricula != null && matricula.getCod() > 0) {
                this.txtCodigo.setText(Integer.toString(matricula.getCod()));
                this.txtCodigo.setEnabled(false);
                this.txtNome.setText(matricula.getNome());

                // Aqui você precisa adaptar conforme a estrutura da classe Matricula
                // Considerando que Matricula tem Disciplina e Aluno
                this.txtEndereco.setText(matricula.getAluno().getEndereco());
                this.txtTelefone.setText(matricula.getAluno().getTelefone().toString());

                ret = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this.mdi, String.format("Não foi possível carregar Matrícula: %s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FormMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbAlunos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
