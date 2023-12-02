/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.clevervitor.hotelPet.view.dialogs;

import com.clevervitor.hotelpet.controller.AgendamentoController;
import com.clevervitor.hotelpet.controller.ProprietarioController;
import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author clevs
 */
public class DlgCadAgendamento extends javax.swing.JDialog {

    ProprietarioController propCont;
    Proprietario proprietarioLogado;
    AgendamentoController AgendamentoController;
    Agendamento AgendamentoSendoEditado;
    Pet petSelcionado;
    List<Pet> lstPetsSelecionados;
    int idAgendamentoEditando;
    private String edtSexo;

    public DlgCadAgendamento(java.awt.Frame parent, boolean modal, Proprietario proprietario) {
        super(parent, modal);

        AgendamentoController = new AgendamentoController();
        idAgendamentoEditando = -1;
        proprietarioLogado = proprietario;
        propCont = new ProprietarioController();
        petSelcionado = new Pet();
        lstPetsSelecionados = new ArrayList<>();
        initComponents();
        setBackground(new Color(51,51,51));

        Image iconeTitulo = null;
        try {
            iconeTitulo = ImageIO.read(getClass().getResource("/Imagens/pawprint.png"));
        } catch (IOException ex) {
            Logger.getLogger(DlgCadAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIconImage(iconeTitulo);

        this.habilitarCampos(true);
        this.limparCampos();

        //  AgendamentoControllet.atualizarTabela(grdAgendamentos);
    }

    public DlgCadAgendamento(java.awt.Frame parent, boolean modal, Agendamento agendamento) {
        super(parent, modal);

        AgendamentoController = new AgendamentoController();
        idAgendamentoEditando = agendamento.getId();
        proprietarioLogado = agendamento.getProprietarioResp();
        propCont = new ProprietarioController();
        petSelcionado = new Pet();

        initComponents();

        setBackground(new Color(51,51,51));
        
        Image iconeTitulo = null;
        try {
            iconeTitulo = ImageIO.read(getClass().getResource("/Images/pawprint.png"));
        } catch (IOException ex) {
            Logger.getLogger(DlgCadAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIconImage(iconeTitulo);

        this.habilitarCampos(true);
        this.limparCampos();
        this.preencherCampos();

        //  AgendamentoControllet.atualizarTabela(grdAgendamentos);
    }

    public void preencherCampos() {

    }

    public void habilitarCampos(boolean flag) {
        lblCheckIn.setForeground(new Color(187, 187, 187));
        lblCheckOut.setForeground(new Color(187, 187, 187));
        lblServicos.setForeground(new Color(187, 187, 187));

        propCont.atualizarTabelaDePetsInicioFrame(tblPets, proprietarioLogado.getLstPetsPossuidos());

    }

    public void limparCampos() {
        dateCheckIn.setDate(null);
        dateCheckOut.setDate(null);
        cbxServicos.setSelectedIndex(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panFormulario = new javax.swing.JPanel();
        lblCheckIn = new javax.swing.JLabel();
        lblCheckOut = new javax.swing.JLabel();
        lblServicos = new javax.swing.JLabel();
        btnSalvarPet = new javax.swing.JButton();
        btnCancelarPet = new javax.swing.JButton();
        pnlDescricaoPet = new javax.swing.JPanel();
        scrPets = new javax.swing.JScrollPane();
        tblPets = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPetsSelecionados = new javax.swing.JTextArea();
        btnAddPet = new javax.swing.JButton();
        btnRemovePet = new javax.swing.JButton();
        dateCheckIn = new com.toedter.calendar.JDateChooser();
        dateCheckOut = new com.toedter.calendar.JDateChooser();
        cbxServicos = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(51, 51, 51));

        panFormulario.setBackground(new java.awt.Color(51, 51, 51));

        lblCheckIn.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblCheckIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCheckIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/check-in (1).png"))); // NOI18N
        lblCheckIn.setText("Check-in:");
        lblCheckIn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblCheckIn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblCheckOut.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblCheckOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/check-out (1).png"))); // NOI18N
        lblCheckOut.setText("Check-out:");
        lblCheckOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblServicos.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/dog.png"))); // NOI18N
        lblServicos.setText("Serviços adicionais");
        lblServicos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblServicos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnSalvarPet.setText("Salvar");
        btnSalvarPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarPetActionPerformed(evt);
            }
        });

        btnCancelarPet.setText("Cancelar");
        btnCancelarPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPetActionPerformed(evt);
            }
        });

        pnlDescricaoPet.setBackground(new java.awt.Color(51, 51, 51));
        pnlDescricaoPet.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecione o pet", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI", 1, 24), new java.awt.Color(153, 255, 153))); // NOI18N

        tblPets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrPets.setViewportView(tblPets);

        txtPetsSelecionados.setColumns(20);
        txtPetsSelecionados.setRows(5);
        jScrollPane1.setViewportView(txtPetsSelecionados);

        btnAddPet.setBackground(new java.awt.Color(51, 51, 51));
        btnAddPet.setForeground(new java.awt.Color(51, 51, 51));
        btnAddPet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/addition.png"))); // NOI18N
        btnAddPet.setBorder(null);
        btnAddPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPetActionPerformed(evt);
            }
        });

        btnRemovePet.setBackground(new java.awt.Color(51, 51, 51));
        btnRemovePet.setForeground(new java.awt.Color(51, 51, 51));
        btnRemovePet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/remove.png"))); // NOI18N
        btnRemovePet.setBorder(null);
        btnRemovePet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemovePetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDescricaoPetLayout = new javax.swing.GroupLayout(pnlDescricaoPet);
        pnlDescricaoPet.setLayout(pnlDescricaoPetLayout);
        pnlDescricaoPetLayout.setHorizontalGroup(
            pnlDescricaoPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDescricaoPetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrPets, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlDescricaoPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddPet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemovePet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlDescricaoPetLayout.setVerticalGroup(
            pnlDescricaoPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDescricaoPetLayout.createSequentialGroup()
                .addGroup(pnlDescricaoPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrPets, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(pnlDescricaoPetLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnAddPet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemovePet)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbxServicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Nenhum --", "Banho", "Tosa", "Massagem", "Banho + Tosa", "Banho + Massagem", "Tosa + Massagem", "Todos" }));
        cbxServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxServicosActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 36)); // NOI18N
        jLabel1.setText("Agendar hospedagem");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panFormularioLayout = new javax.swing.GroupLayout(panFormulario);
        panFormulario.setLayout(panFormularioLayout);
        panFormularioLayout.setHorizontalGroup(
            panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFormularioLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addComponent(lblCheckOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dateCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCheckIn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblServicos)
                    .addComponent(cbxServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormularioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlDescricaoPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(panFormularioLayout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(btnSalvarPet)
                .addGap(28, 28, 28)
                .addComponent(btnCancelarPet)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panFormularioLayout.setVerticalGroup(
            panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCheckIn)
                    .addComponent(lblServicos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblCheckOut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlDescricaoPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarPet)
                    .addComponent(btnCancelarPet))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panFormulario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panFormulario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPetActionPerformed
        // TODO add your handling code here:

        petSelcionado = (Pet) getObjetoSelecionadoNaGrid();

        if (petSelcionado == null) {
            JOptionPane.showMessageDialog(null, "Primeiro, selecione um pet para ser hospedado");
        }

        Agendamento novoAgendamento = new Agendamento(dateCheckIn.getDate().toString(), dateCheckOut.getDate().toString(), cbxServicos.getSelectedItem().toString(), proprietarioLogado, lstPetsSelecionados);

        AgendamentoController.cadastrarAgendamento(novoAgendamento);

        dispose();
    }//GEN-LAST:event_btnSalvarPetActionPerformed

    private Object getObjetoSelecionadoNaGrid() {
        int rowCliked = tblPets.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = tblPets.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }

    private void cbxServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxServicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxServicosActionPerformed

    private void btnAddPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPetActionPerformed
        // TODO add your handling code here:
        petSelcionado = (Pet) getObjetoSelecionadoNaGrid();
        if (petSelcionado == null) {
            JOptionPane.showMessageDialog(null, "Primeiro, selecione um pet da tabela");
        } else if (lstPetsSelecionados.contains(petSelcionado)) {
            JOptionPane.showMessageDialog(null, "Este pet já foi selecionado.");
        } else {
            lstPetsSelecionados.add(petSelcionado);
        }

        txtPetsSelecionados.setText(lstPetsSelecionados.toString());
    }//GEN-LAST:event_btnAddPetActionPerformed

    private void btnCancelarPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPetActionPerformed
        // TODO add your handling code here:
        limparCampos();
        dispose();
    }//GEN-LAST:event_btnCancelarPetActionPerformed

    private void btnRemovePetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemovePetActionPerformed
        // TODO add your handling code here:
        if (lstPetsSelecionados.size() <= 0) {
            JOptionPane.showMessageDialog(null, "Nenhum pet para remover");
        } else {
            lstPetsSelecionados.remove(lstPetsSelecionados.size() - 1);
        }
        txtPetsSelecionados.setText(lstPetsSelecionados.toString());
    }//GEN-LAST:event_btnRemovePetActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPet;
    private javax.swing.JButton btnCancelarPet;
    private javax.swing.JButton btnRemovePet;
    private javax.swing.JButton btnSalvarPet;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxServicos;
    private com.toedter.calendar.JDateChooser dateCheckIn;
    private com.toedter.calendar.JDateChooser dateCheckOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCheckIn;
    private javax.swing.JLabel lblCheckOut;
    private javax.swing.JLabel lblServicos;
    private javax.swing.JPanel panFormulario;
    private javax.swing.JPanel pnlDescricaoPet;
    private javax.swing.JScrollPane scrPets;
    private javax.swing.JTable tblPets;
    private javax.swing.JTextArea txtPetsSelecionados;
    // End of variables declaration//GEN-END:variables
}
