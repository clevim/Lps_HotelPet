/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.clevervitor.hotelpet.view.dialogs.Infos;

import com.clevervitor.hotelpet.view.dialogs.Cadastros.DlgCadPet;
import com.clevervitor.hotelpet.connection.loginContexto;
import com.clevervitor.hotelpet.controller.PetController;
import com.clevervitor.hotelpet.controller.ProprietarioController;
import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.model.enums.Status;
import com.clevervitor.hotelpet.utils.utils;
import com.clevervitor.hotelpet.view.UI.ShowConfirmDialog;
import com.clevervitor.hotelpet.view.UI.ShowMessageDialog;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Image;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author vitor
 */
public class DlgInfoPet extends javax.swing.JDialog {

    loginContexto pessoaLogada = loginContexto.getInstance();

    /**
     * Creates new form NewJDialog
     */
    Pet pet;
    PetController petController;
    Proprietario proprietario;
    ProprietarioController propController;
    byte[] imgProfile = null;
    ImageIcon imgIcon = null;

    public DlgInfoPet(java.awt.Frame parent, boolean modal, Pet pet) {
        super(parent, modal);
        initComponents();
        this.petController = new PetController();
        this.propController = new ProprietarioController();

        this.pet = petController.buscarPet(pet.getId());

        setTitle("Informações de " + pet.getNome());

        proprietario = propController.buscarProprietario(pet.getProprietario().getId());
        imgProfile = pet.getAvatarPet();
        if (imgProfile != null) {
            imgIcon = new ImageIcon(new ImageIcon(imgProfile).getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_DEFAULT));
            if (imgIcon != null) {
                lbl_img.setText(null);
                lbl_img.setIcon(imgIcon);
            }
        }
        utils utils = new utils();
        lblDel.setIcon(utils.resizeImgTolb("/Imagens/delete_white.png", lblDel));
        lblEditar.setIcon(utils.resizeImgTolb("/Imagens/edit_white.png", lblEditar));

        preencherLabels();

        lblEditar.setVisible(false);
        lblDel.setVisible(false);
        lblEditar.setEnabled(false);
        lblDel.setEnabled(false);
        visibilityActions(pessoaLogada.getPessoaLogada().getNivelAcesso());

    }

    public void visibilityActions(Integer NivelAcesso) {
        switch (NivelAcesso) {
            case 0:
                lblEditar.setVisible(true);
                lblDel.setVisible(true);
                lblEditar.setEnabled(true);
                lblDel.setEnabled(true);
                break;
            case 1:
                lblEditar.setVisible(true);
                lblDel.setVisible(true);
                lblEditar.setEnabled(true);
                lblDel.setEnabled(true);
                break;
            case 2:
                lblEditar.setVisible(true);
                lblDel.setVisible(true);
                lblEditar.setEnabled(true);
                lblDel.setEnabled(true);
                break;
            default:
                throw new AssertionError();
        }

    }

    public void preencherLabels() {
        String petInfo = "<html>"
                + "<p style=\"text-align: justify;\"><strong>O Pet " + pet.getNome() + ","
                + " de " + pet.getIdade() + " ano(s),"
                + " &eacute; " + pet.getSexo() + ""
                + " e pertence &agrave; esp&eacute;cie " + pet.getEspecie() + ","
                + " da ra&ccedil;a " + pet.getRaca() + "."
                + " Possui peso de " + pet.getPeso() + "Kg."
                + "<br /><br /></strong><strong>"
                + "Observa&ccedil;&otilde;es: " + pet.getObs() + " ;"
                + "<br /><br />Seu propriet&aacute;rio &eacute; o(a) " + pet.getProprietario().getNome() + ".<br /></strong></p></html>";

        lbPetInfo.setText(petInfo);

        List<Agendamento> lstAgenFilt = new ArrayList<>();

        for (Agendamento a : proprietario.getLstAgendamentos()) {
            if (a.getPetAgendado().getId() == this.pet.getId()) {
                lstAgenFilt.add(a);
            }
        }
        lstAgenFilt = lstAgenFilt.isEmpty() ? new ArrayList<>() : lstAgenFilt;
        propController.atualizarTabelaDeAgendamentos(tblAgendamentos, lstAgenFilt);

//        propController.atualizarTabelaDePetsInicioFrame(tblPets, proprietario.getLstPetsPossuidos());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAgendamentos = new javax.swing.JTable();
        lbl_img = new javax.swing.JLabel();
        lbPetInfo = new javax.swing.JLabel();
        lblDel = new javax.swing.JLabel();
        lblEditar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Info Pet");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jTabbedPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tblAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblAgendamentos);

        jTabbedPane2.addTab("Agendamentos", jScrollPane3);

        lbl_img.setBackground(new java.awt.Color(160, 160, 160));
        lbl_img.setForeground(new java.awt.Color(242, 242, 242));
        lbl_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_img.setText("Carregar Imagem");
        lbl_img.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        lbl_img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_imgMouseClicked(evt);
            }
        });

        lbPetInfo.setForeground(new java.awt.Color(255, 255, 255));

        lblDel.setEnabled(false);
        lblDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDelMouseExited(evt);
            }
        });

        lblEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEditarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbPetInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(lblEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblDel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lbPetInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblDelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDelMouseClicked
        ShowConfirmDialog DialMsg = new ShowConfirmDialog("Atenção", "Deseja Excluir Pet}?");
        var op = DialMsg.showDialog();

        if (op) {

            if (pet.getAgendamentoMarcado().size() != 0) {

                List<Agendamento> agendamentosAtivos = pet.getAgendamentoMarcado();
                for (Agendamento agendamento : agendamentosAtivos) {
                    if (agendamento.getStatus().equals(Status.AGENDADO)) {
                        ShowConfirmDialog msg = new ShowConfirmDialog("Atenção", "Este pet possui um agendamento marcado. Deseja excluir o pet mesmo assim?");
                        var ops = msg.showDialog();
                        if (ops) {

                            petController.excluirPet(pet);
                            this.dispose();
                        }
                    } else {
                        ShowMessageDialog msgC = new ShowMessageDialog("Erro", "Não é possível excluir este pet, pois precisamos dos seus dados.");
                        msgC.setVisible(true);
                    }

                }

            } else {
                petController.excluirPet(pet);
                this.dispose();
            }
        }


    }//GEN-LAST:event_lblDelMouseClicked

    private void lblDelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDelMouseEntered
        // TODO add your handling code here:
        lblDel.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }//GEN-LAST:event_lblDelMouseEntered

    private void lbl_imgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imgMouseClicked

        String file = utils.uploadAvatarPet(pet.getId(), imgProfile, imgIcon);

        if (!file.isEmpty()) {

            lbl_img.setText(null);
            imgIcon = new ImageIcon(new ImageIcon(file).getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH));
            lbl_img.setIcon(imgIcon);
            ShowMessageDialog DialMsg = new ShowMessageDialog("Sucesso", "Avatar atualizado!");
            DialMsg.setVisible(true);
        }
    }//GEN-LAST:event_lbl_imgMouseClicked

    private void lblDelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDelMouseExited
        // TODO add your handling code here:
        lblDel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_lblDelMouseExited

    private void lblEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMouseClicked
        // TODO add your handling code here:
        Pet petParaEditar = petController.buscarPet(pet.getId());
        this.dispose();
        DlgCadPet telaEditarPet;
        telaEditarPet = new DlgCadPet(new Frame(), true, petParaEditar);
        telaEditarPet.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_lblEditarMouseClicked

    private void lblEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMouseEntered
        // TODO add your handling code here:
        lblEditar.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }//GEN-LAST:event_lblEditarMouseEntered

    private void lblEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMouseExited
        // TODO add your handling code here:
        lblEditar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_lblEditarMouseExited

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbPetInfo;
    private javax.swing.JLabel lblDel;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JTable tblAgendamentos;
    // End of variables declaration//GEN-END:variables
}
