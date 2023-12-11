/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.clevervitor.hotelpet.view.dialogs.cadastros;

import com.clevervitor.hotelpet.controller.PetController;
import com.clevervitor.hotelpet.controller.ProprietarioController;
import com.clevervitor.hotelpet.exceptions.PetException;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.view.FrLogin;
import com.clevervitor.hotelpet.view.UI.ShowMessageDialog;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author clevs
 */
public class DlgCadPet extends javax.swing.JDialog {

    ProprietarioController propCont;
    PetController petController;
    int PetEditando;
    private String edtSexo;
    Pet petSendoEditado;
    Proprietario proprietarioLogado;

    public DlgCadPet(java.awt.Frame parent, boolean modal, Proprietario proprietario) {
        super(parent, modal);

        petController = new PetController();
        PetEditando = -1;
        proprietarioLogado = proprietario;
        propCont = new ProprietarioController();
        initComponents();

        Image iconeTitulo = null;
        try {
            iconeTitulo = ImageIO.read(getClass().getResource("/Imagens/pawprint.png"));
        } catch (IOException ex) {
            Logger.getLogger(FrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIconImage(iconeTitulo);

        this.habilitarCampos(true);
        this.limparCampos();

        //  petControllet.atualizarTabela(grdPets);
    }

    public DlgCadPet(java.awt.Frame parent, boolean modal, Pet pet) {
        super(parent, modal);
        initComponents();

        petController = new PetController();
        this.PetEditando = 1;
        proprietarioLogado = pet.getProprietario();
        propCont = new ProprietarioController();
        petSendoEditado = pet;

        Image iconeTitulo = null;
        try {
            iconeTitulo = ImageIO.read(getClass().getResource("/Images/pawprint.png"));
        } catch (IOException ex) {
            Logger.getLogger(FrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIconImage(iconeTitulo);

        this.habilitarCampos(true);
        this.preencherCampos();
        this.limparCampos();

        //  petControllet.atualizarTabela(grdPets);
    }

    public void preencherCampos() {

        edtNome.setText(petSendoEditado.getNome());
        edtEspecie.setText(petSendoEditado.getEspecie());
        edtIdade.setText(petSendoEditado.getIdade().toString());
        edtPeso.setText(petSendoEditado.getPeso().toString());
        edtRaca.setText(petSendoEditado.getRaca());
        if (petSendoEditado.getSexo().equalsIgnoreCase("Macho")) {

            rbtnMacho.setSelected(true);
            rbtnFemea.setSelected(false);

        } else if (petSendoEditado.getSexo().equalsIgnoreCase("Femea")) {

            rbtnMacho.setSelected(false);
            rbtnFemea.setSelected(true);

        }
        edtObs.setText(petSendoEditado.getObs());

    }

    public void habilitarCampos(boolean flag) {
        edtNome.setEnabled(true);
        edtEspecie.setEnabled(true);
        edtIdade.setEnabled(true);
        edtPeso.setEnabled(true);
        edtRaca.setEnabled(true);
        rbtnMacho.setSelected(false);
        rbtnFemea.setSelected(false);
        edtObs.setEnabled(true);

    }

    public void limparCampos() {
        edtNome.setText("");
        edtEspecie.setText("");
        edtIdade.setText("");
        edtPeso.setText("");
        edtRaca.setText("");
        rbtnMacho.setSelected(false);
        rbtnFemea.setSelected(false);
        edtObs.setText("");

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
        lblNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        lblIdade = new javax.swing.JLabel();
        edtIdade = new javax.swing.JTextField();
        lblEspecie = new javax.swing.JLabel();
        edtEspecie = new javax.swing.JTextField();
        edtPeso = new javax.swing.JTextField();
        lblPeso = new javax.swing.JLabel();
        rbtnMacho = new javax.swing.JRadioButton();
        rbtnFemea = new javax.swing.JRadioButton();
        lblRaca = new javax.swing.JLabel();
        edtRaca = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        btnSalvarPet = new javax.swing.JButton();
        btnCancelarPet = new javax.swing.JButton();
        pnlDescricaoPet = new javax.swing.JPanel();
        edtObs = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(51, 51, 51));

        panFormulario.setBackground(new java.awt.Color(51, 51, 51));

        lblNome.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblNome.setForeground(new java.awt.Color(242, 242, 242));
        lblNome.setText("Nome:");

        edtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtNomeActionPerformed(evt);
            }
        });

        lblIdade.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblIdade.setForeground(new java.awt.Color(242, 242, 242));
        lblIdade.setText("Idade:");

        edtIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtIdadeActionPerformed(evt);
            }
        });

        lblEspecie.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblEspecie.setForeground(new java.awt.Color(242, 242, 242));
        lblEspecie.setText("Especie:");

        edtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPesoActionPerformed(evt);
            }
        });

        lblPeso.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblPeso.setForeground(new java.awt.Color(242, 242, 242));
        lblPeso.setText("Peso:");

        rbtnMacho.setBackground(new java.awt.Color(51, 51, 51));
        rbtnMacho.setForeground(new java.awt.Color(242, 242, 242));
        rbtnMacho.setText("Macho");
        rbtnMacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMachoActionPerformed(evt);
            }
        });

        rbtnFemea.setBackground(new java.awt.Color(51, 51, 51));
        rbtnFemea.setForeground(new java.awt.Color(242, 242, 242));
        rbtnFemea.setText("Femea");
        rbtnFemea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFemeaActionPerformed(evt);
            }
        });

        lblRaca.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblRaca.setForeground(new java.awt.Color(242, 242, 242));
        lblRaca.setText("Raça:");

        lblSexo.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblSexo.setForeground(new java.awt.Color(242, 242, 242));
        lblSexo.setText("Sexo:");

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
        pnlDescricaoPet.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descreva seu pet", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI", 1, 24), new java.awt.Color(153, 255, 153))); // NOI18N

        edtObs.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        javax.swing.GroupLayout pnlDescricaoPetLayout = new javax.swing.GroupLayout(pnlDescricaoPet);
        pnlDescricaoPet.setLayout(pnlDescricaoPetLayout);
        pnlDescricaoPetLayout.setHorizontalGroup(
            pnlDescricaoPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDescricaoPetLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(edtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlDescricaoPetLayout.setVerticalGroup(
            pnlDescricaoPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDescricaoPetLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(edtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panFormularioLayout = new javax.swing.GroupLayout(panFormulario);
        panFormulario.setLayout(panFormularioLayout);
        panFormularioLayout.setHorizontalGroup(
            panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblEspecie, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblPeso)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblIdade))
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblRaca)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnMacho)
                    .addComponent(lblSexo)
                    .addComponent(rbtnFemea))
                .addGap(93, 93, 93))
            .addGroup(panFormularioLayout.createSequentialGroup()
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(btnSalvarPet)
                        .addGap(30, 30, 30)
                        .addComponent(btnCancelarPet))
                    .addComponent(pnlDescricaoPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panFormularioLayout.setVerticalGroup(
            panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormularioLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addComponent(lblSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnMacho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnFemea))
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome)
                            .addComponent(lblIdade)
                            .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEspecie)
                            .addComponent(lblRaca)
                            .addComponent(edtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPeso))
                .addGap(18, 18, 18)
                .addComponent(pnlDescricaoPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 24, Short.MAX_VALUE)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarPet)
                    .addComponent(btnCancelarPet))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Cadastro de Pet");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pawprint.png"))); // NOI18N

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
                        .addGap(129, 129, 129)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panFormulario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPetActionPerformed
        // TODO add your handling code here:

        String sexo = null;
        proprietarioLogado = propCont.buscarProprietario(proprietarioLogado.getId());

        if (PetEditando > 0) {

            petController.atualizarPet(petSendoEditado);
        } else {
            try{
            if (rbtnMacho.isSelected()) {
                rbtnFemea.setEnabled(false);
                sexo = "Macho";
            } else if (rbtnFemea.isSelected()) {
                rbtnMacho.setEnabled(false);
                sexo = "Femea";
            } else if (!rbtnFemea.isSelected() && !rbtnMacho.isSelected()) {
                ShowMessageDialog DialMsg = new ShowMessageDialog("Atenção", "Selecione o sexo do pet!");
                DialMsg.setVisible(true);
            }

            Pet novoPet = new Pet(edtNome.getText(), edtEspecie.getText(), edtRaca.getText(), Integer.parseInt(edtIdade.getText()), sexo, Double.parseDouble(edtPeso.getText()), edtObs.getText(), proprietarioLogado);

            petController.cadastrarPet(novoPet);

            ShowMessageDialog DialMsg = new ShowMessageDialog("Sucesso.", "Pet salvo com sucesso!");
            DialMsg.setVisible(true);
            } catch (PetException e){
                ShowMessageDialog DialMsg = new ShowMessageDialog("Erro: ", "Não foi possível salvar o pet.");
            DialMsg.setVisible(true);
            }

            PetEditando = -1;
            dispose();
        }
    }//GEN-LAST:event_btnSalvarPetActionPerformed

    private void rbtnMachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMachoActionPerformed
        // TODO add your handling code here:
        rbtnFemea.setSelected(false);
    }//GEN-LAST:event_rbtnMachoActionPerformed

    private void edtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPesoActionPerformed

    private void edtIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtIdadeActionPerformed

    private void edtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNomeActionPerformed

    private void rbtnFemeaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFemeaActionPerformed
        // TODO add your handling code here:
        rbtnMacho.setSelected(false);
    }//GEN-LAST:event_rbtnFemeaActionPerformed

    private void btnCancelarPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPetActionPerformed
        limparCampos();
        this.dispose();
    }//GEN-LAST:event_btnCancelarPetActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarPet;
    private javax.swing.JButton btnSalvarPet;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField edtEspecie;
    private javax.swing.JTextField edtIdade;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtObs;
    private javax.swing.JTextField edtPeso;
    private javax.swing.JTextField edtRaca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEspecie;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblRaca;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JPanel panFormulario;
    private javax.swing.JPanel pnlDescricaoPet;
    private javax.swing.JRadioButton rbtnFemea;
    private javax.swing.JRadioButton rbtnMacho;
    // End of variables declaration//GEN-END:variables
}
