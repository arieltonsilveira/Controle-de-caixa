/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import Model.Categoria;
import Model.Recebivel;
import ModuloConexao.Mysql;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ariel
 */
public class CadastroRecebivel extends javax.swing.JFrame {

    Connection conexao;
    private ArrayList<Categoria> categorias;

    public CadastroRecebivel() {
        initComponents();
        this.conexao = Mysql.conector();
        buscarCategorias("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPesCategoria = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCategorias = new javax.swing.JList<>();
        txtData = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel3.setText("Valor do Recebivel:");

        jLabel4.setText("Data do Recebivel:");

        txtValor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel5.setText("Pesquise por nome");

        txtPesCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPesCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesCategoriaKeyPressed(evt);
            }
        });

        listCategorias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listCategorias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listCategorias);

        txtData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("CADASTRO RECEBIVEL");

        btSalvar.setText("Salvar");
        btSalvar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSalvarMouseClicked(evt);
            }
        });
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        jLabel2.setText("Descrição do Recebivel:");

        txtDescricao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPesCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(113, 113, 113))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesCategoriaKeyPressed
        //System.out.println("EVENTO: " + evt.getKeyChar());
        buscarCategorias(txtPesCategoria.getText());
    }//GEN-LAST:event_txtPesCategoriaKeyPressed

    private void listCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCategoriasMouseClicked
        //JOptionPane.showMessageDialog(rootPane, "DATA: " + listCategorias.getSelectedIndex(), "ERRO DE CADASTRO", HEIGHT);
    }//GEN-LAST:event_listCategoriasMouseClicked

    private void btSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSalvarMouseClicked

    }//GEN-LAST:event_btSalvarMouseClicked

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (txtDescricao.getText().isEmpty() || txtValor.getText().isEmpty() || txtData.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "PREENCHA OS DADOS CORRETAMENTE", "ERRO DE CADASTRO", HEIGHT);
            return;
        }

        if (!isDateValid(txtData.getText())) {
            JOptionPane.showMessageDialog(rootPane, "DATA INFORMADA INVALIDA", "ERRO DE CADASTRO", HEIGHT);
            return;
        }

        String[] res = txtData.getText().split("/");
        String data_recebivel = res[2]+"-"+res[1]+"-"+res[0]+" 00:00:00";
        Categoria categoria = categorias.get(listCategorias.getSelectedIndex());
        Recebivel recebivel = new Recebivel(conexao, txtDescricao.getText(),Float.parseFloat(txtValor.getText().replace(",", ".")), data_recebivel, categoria);
        if (recebivel.criar()) {
            JOptionPane.showMessageDialog(rootPane, "RECEBIVEL CADASTRADO COM SUCESSO!", "CADASTRO DE RECEBIVEL", EXIT_ON_CLOSE);
            txtData.setText("");
            txtDescricao.setText("");
            txtValor.setText("");
            txtData.setText("");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Erro inesperado ao cadastrar recebivel", "ERRO DE CADASTRO", HEIGHT);
        }
    }//GEN-LAST:event_btSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroRecebivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroRecebivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroRecebivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroRecebivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroRecebivel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listCategorias;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtPesCategoria;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
    private void buscarCategorias(String nome_categoria) {
        Categoria categoria = new Categoria(conexao, nome_categoria, "RECEBIVEL");
        if (nome_categoria.isEmpty()) {
            this.categorias = categoria.buscarCategoria("RECEBIVEL");
        } else {
            this.categorias = categoria.buscarCategoria("RECEBIVEL", nome_categoria);
        }
        setCategoria();
    }

    private void setCategoria() {
        DefaultListModel model = new DefaultListModel();

        int cont = 0;
        for (Categoria item : this.categorias) {
            model.add(cont, item.getNome_categoria());
            cont++;
        }
        listCategorias.setModel(model);
    }
    
    public static boolean isDateValid(String strDate) {
        String dateFormat = "dd/MM/uuuu";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
        .ofPattern(dateFormat)
        .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
            return true;
        } catch (DateTimeParseException e) {
           return false;
        } 
    }
}
