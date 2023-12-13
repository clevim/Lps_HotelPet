/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.clevervitor.hotelpet.view.dialogs;

import com.clevervitor.hotelpet.connection.loginContexto;
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
    loginContexto pessoaLogada = loginContexto.getInstance();

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
            iconeTitulo = ImageIO.read(getClass().getResource("/Imagens/pawprint.png"));
        } catch (IOException ex) {
            Logger.getLogger(FrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIconImage(iconeTitulo);

        this.habilitarCampos(true);
        this.preencherCampos();

        //  petControllet.atualizarTabela(grdPets);
        
      switch (pessoaLogada.getPessoaLogada().getNivelAcesso()) {
            case 0:
                desabilitaTudo();
                habilitaPetAdmin();
                break;
            case 1:
                desabilitaTudo();
                habilitaPetFuncionario();
                break;
            case 2:
                desabilitaTudo();
                habilitaPetProprietario();
                break;
            default:
                throw new AssertionError();
        }

       

    }

    public void desabilitaTudo() {
        edtEspecie.setEnabled(false);
        edtIdade.setEnabled(false);
        edtNome.setEnabled(false);
        edtObs.setEnabled(false);
        edtPeso.setEnabled(false);
        edtRaca.setEnabled(false);
        rbtnMacho.setEnabled(false);
        rbtnFemea.setEnabled(false);


    }

    public void habilitaPetAdmin() {
        edtEspecie.setEnabled(true);
        edtIdade.setEnabled(true);
        edtNome.setEnabled(true);
        edtObs.setEnabled(true);
        edtPeso.setEnabled(true);
        edtRaca.setEnabled(true);
        rbtnMacho.setEnabled(true);
        rbtnFemea.setEnabled(true);
    }

    public void habilitaPetFuncionario() {
       edtEspecie.setEnabled(false);
        edtIdade.setEnabled(true);
        edtNome.setEnabled(false);
        edtObs.setEnabled(true);
        edtPeso.setEnabled(true);
        edtRaca.setEnabled(false);
        rbtnMacho.setEnabled(false);
        rbtnFemea.setEnabled(false);
    }

    public void habilitaPetProprietario() {
    edtEspecie.setEnabled(false);
        edtIdade.setEnabled(true);
        edtNome.setEnabled(true);
        edtObs.setEnabled(true);
        edtPeso.setEnabled(true);
        edtRaca.setEnabled(false);
        rbtnMacho.setEnabled(false);
        rbtnFemea.setEnabled(false);
    }

    public void preencherCampos() {

        petController.buscarPet(petSendoEditado.getId());

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
        edtPeso = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setTitle("Cadastro Pet");
        setBackground(new java.awt.Color(51, 51, 51));

        panFormulario.setBackground(new java.awt.Color(51, 51, 51));
        panFormulario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblNome.setForeground(new java.awt.Color(242, 242, 242));
        lblNome.setText("Nome:");
        panFormulario.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 19, -1, -1));

        edtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtNomeActionPerformed(evt);
            }
        });
        panFormulario.add(edtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 16, 207, -1));

        lblIdade.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblIdade.setForeground(new java.awt.Color(242, 242, 242));
        lblIdade.setText("Idade:");
        panFormulario.add(lblIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 19, -1, -1));

        edtIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtIdadeActionPerformed(evt);
            }
        });
        panFormulario.add(edtIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 16, 60, -1));

        lblEspecie.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblEspecie.setForeground(new java.awt.Color(242, 242, 242));
        lblEspecie.setText("Especie:");
        panFormulario.add(lblEspecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 60, -1, -1));
        panFormulario.add(edtEspecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 57, 207, -1));

        lblPeso.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblPeso.setForeground(new java.awt.Color(242, 242, 242));
        lblPeso.setText("Peso:");
        panFormulario.add(lblPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 102, -1, -1));

        rbtnMacho.setBackground(new java.awt.Color(51, 51, 51));
        rbtnMacho.setForeground(new java.awt.Color(242, 242, 242));
        rbtnMacho.setText("Macho");
        rbtnMacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMachoActionPerformed(evt);
            }
        });
        panFormulario.add(rbtnMacho, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 39, -1, -1));

        rbtnFemea.setBackground(new java.awt.Color(51, 51, 51));
        rbtnFemea.setForeground(new java.awt.Color(242, 242, 242));
        rbtnFemea.setText("Femea");
        rbtnFemea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFemeaActionPerformed(evt);
            }
        });
        panFormulario.add(rbtnFemea, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 66, -1, -1));

        lblRaca.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblRaca.setForeground(new java.awt.Color(242, 242, 242));
        lblRaca.setText("Raça:");
        panFormulario.add(lblRaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 60, -1, -1));
        panFormulario.add(edtRaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 57, 104, -1));

        lblSexo.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblSexo.setForeground(new java.awt.Color(242, 242, 242));
        lblSexo.setText("Sexo:");
        panFormulario.add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 16, -1, -1));

        btnSalvarPet.setText("Salvar");
        btnSalvarPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarPetActionPerformed(evt);
            }
        });
        panFormulario.add(btnSalvarPet, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 347, -1, -1));

        btnCancelarPet.setText("Cancelar");
        btnCancelarPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPetActionPerformed(evt);
            }
        });
        panFormulario.add(btnCancelarPet, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 347, -1, -1));

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

        panFormulario.add(pnlDescricaoPet, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        edtPeso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        panFormulario.add(edtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 140, -1));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
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
                .addComponent(panFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPetActionPerformed
        // TODO add your handling code here:

        String sexo = null;
        proprietarioLogado = propCont.buscarProprietario(proprietarioLogado.getId());

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

        if (PetEditando > 0) {

            Pet petEditado = new Pet(edtNome.getText(), edtEspecie.getText(), edtRaca.getText(), Integer.parseInt(edtIdade.getText()), sexo, Double.parseDouble(edtPeso.getText().replace(",", ".")), edtObs.getText(), proprietarioLogado);
            
            petEditado.setId(petSendoEditado.getId());
            petEditado.setAvatarPet(petSendoEditado.getAvatarPet());
            
            petController.atualizarPet(petEditado);

            ShowMessageDialog DialMsg = new ShowMessageDialog("Sucesso.", "Pet atualizado!");
            DialMsg.setVisible(true);

        } else {
            try {
                Pet novoPet = new Pet(edtNome.getText(), edtEspecie.getText(), edtRaca.getText(), Integer.parseInt(edtIdade.getText()), sexo, Double.parseDouble(edtPeso.getText().replace(",", ".")), edtObs.getText(), proprietarioLogado);

                petController.cadastrarPet(novoPet);

                ShowMessageDialog DialMsg = new ShowMessageDialog("Oba,", " Pet salvo com sucesso!");
                DialMsg.setVisible(true);
            } catch (PetException e) {
                ShowMessageDialog DialMsg = new ShowMessageDialog("Erro: ", "Não foi possível salvar o pet.");
                DialMsg.setVisible(true);
            }

        }
            PetEditando = -1;
            dispose();
    }//GEN-LAST:event_btnSalvarPetActionPerformed

    private void rbtnMachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMachoActionPerformed
        // TODO add your handling code here:
        rbtnFemea.setSelected(false);
    }//GEN-LAST:event_rbtnMachoActionPerformed

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
    private javax.swing.JFormattedTextField edtPeso;
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
