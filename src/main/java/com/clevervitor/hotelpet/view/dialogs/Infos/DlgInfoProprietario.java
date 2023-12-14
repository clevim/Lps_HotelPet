/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.clevervitor.hotelpet.view.dialogs.Infos;

import com.clevervitor.hotelpet.view.dialogs.Cadastros.DlgCadProprietario;
import com.clevervitor.hotelpet.connection.loginContexto;
import com.clevervitor.hotelpet.controller.PetController;
import com.clevervitor.hotelpet.controller.ProprietarioController;
import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.utils.utils;
import com.clevervitor.hotelpet.view.FrMainMenuClient;
import com.clevervitor.hotelpet.view.UI.ShowConfirmDialog;
import com.clevervitor.hotelpet.view.UI.ShowMessageDialog;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author vitor
 */
public class DlgInfoProprietario extends javax.swing.JDialog {

    loginContexto pessoaLogada = loginContexto.getInstance();
    byte[] imgProfile = null;
    ImageIcon imgIcon = null;
    /**
     * Creates new form NewJDialog
     */
    Proprietario proprietario;
    ProprietarioController propController;

    public DlgInfoProprietario(java.awt.Frame parent, boolean modal, Proprietario prop) {
        super(parent, modal);
        initComponents();

        this.proprietario = prop;
        setTitle("Informações de " + prop.getNome());

        this.propController = new ProprietarioController();
        imgProfile = proprietario.getAvatar();
        if (imgProfile != null) {
            imgIcon = new ImageIcon(new ImageIcon(imgProfile).getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_DEFAULT));
            if (imgIcon != null) {
                lbl_img.setText(null);
                lbl_img.setIcon(imgIcon);
            }
        }
        utils utils = new utils();
        lblEditar.setIcon(utils.resizeImgTolb("/Imagens/edit_white.png", lblEditar));
        lblDel.setIcon(utils.resizeImgTolb("/Imagens/delete_white.png", lblDel));
        lblAcess.setIcon(utils.resizeImgTolb("/Imagens/accessibility_white.png", lblAcess));

        preencherLabels();

        lblEditar.setVisible(false);
        lblDel.setVisible(false);
        lblAcess.setVisible(false);
        lblEditar.setEnabled(false);
        lblDel.setEnabled(false);
        lblAcess.setEnabled(false);
        visibilityActions(pessoaLogada.getPessoaLogada().getNivelAcesso());

    }

    public void visibilityActions(Integer NivelAcesso) {
        switch (NivelAcesso) {
            case 0:
                lblEditar.setVisible(true);
                lblDel.setVisible(true);
                lblEditar.setEnabled(true);
                lblDel.setEnabled(true);
                lblAcess.setVisible(true);
                lblAcess.setEnabled(true);
                break;
            case 1:
                lblEditar.setVisible(true);
                lblDel.setVisible(false);
                lblEditar.setEnabled(true);
                lblDel.setEnabled(false);
                lblAcess.setVisible(true);
                lblAcess.setEnabled(true);
                break;
            case 2:
                lblEditar.setVisible(true);
                lblDel.setVisible(true);
                lblEditar.setEnabled(true);
                lblDel.setEnabled(true);
                lblAcess.setVisible(false);
                lblAcess.setEnabled(false);
                break;
            default:
                throw new AssertionError();
        }

    }

    public void preencherLabels() {
        String proprietarioInfo = "<html>\n"
                + "<p style=\"text-align: justify;\"><strong>" + proprietario.getNome() + ", "
                + "de genero " + utils.SexoToString(proprietario.getSexo()) + ","
                + " nascido(a) em " + proprietario.getDataNasc() + "."
                + " Seu CPF &eacute; " + proprietario.getCpf() + "."
                + " Com endere&ccedil;o atual em " + proprietario.getEndereco() + ""
                + ".<br /><br /></strong><strong>"
                + "Possui " + proprietario.getLstPetsPossuidos().size() + " Pet(s);<br /><br />"
                + "Pode ser contatado(a) atrav&eacute;s do e-mail " + proprietario.getEmail() + "</em>"
                + " e do telefone " + proprietario.getTel() + ".</strong></p></html>";

        lbPropInfo.setText(proprietarioInfo);

        propController.atualizarTabelaDeAgendamentos(tblAgendamentos, proprietario.getLstAgendamentos());
        propController.atualizarTabelaDePetsInicioFrame(tblPets, proprietario.getLstPetsPossuidos());

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
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPets = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAgendamentos = new javax.swing.JTable();
        lbl_img = new javax.swing.JLabel();
        lbPropInfo = new javax.swing.JLabel();
        lblEditar = new javax.swing.JLabel();
        lblDel = new javax.swing.JLabel();
        lblAcess = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Info Proprietario");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jTabbedPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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
        jScrollPane4.setViewportView(tblPets);

        jTabbedPane2.addTab("Pets", jScrollPane4);

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

        lbPropInfo.setForeground(new java.awt.Color(255, 255, 255));

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

        lblAcess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAcessMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAcessMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAcessMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbPropInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblAcess, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(38, 38, 38))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAcess, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbPropInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblDelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDelMouseClicked
        ShowConfirmDialog DialMsg = new ShowConfirmDialog("Atenção", "Deseja Excluir Proprietario}?");
        var op = DialMsg.showDialog();

        if (op) {
            propController.excluirPet(proprietario);
            this.dispose();
        }
    }//GEN-LAST:event_lblDelMouseClicked

    private void lblDelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDelMouseEntered
        // TODO add your handling code here:
        lblDel.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }//GEN-LAST:event_lblDelMouseEntered

    private void lbl_imgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imgMouseClicked

        String file = utils.uploadAvatar(proprietario.getId(), imgProfile, imgIcon);

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
        DlgCadProprietario telaEditarProp;
        try {
            this.dispose();
            telaEditarProp = new DlgCadProprietario(new Frame(), true, proprietario);
            this.setVisible(false);
            telaEditarProp.setVisible(true);

        } catch (ParseException ex) {
            Logger.getLogger(DlgInfoProprietario.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_lblEditarMouseClicked

    private void lblEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMouseEntered
        // TODO add your handling code here:
        lblEditar.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }//GEN-LAST:event_lblEditarMouseEntered

    private void lblEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMouseExited
        // TODO add your handling code here:
        lblEditar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_lblEditarMouseExited

    private void lblAcessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAcessMouseClicked
        FrMainMenuClient clienteMenu = new FrMainMenuClient(new Frame(), true, (Proprietario) proprietario);
        clienteMenu.setTitle("Cliente");
        clienteMenu.setVisible(true);

        PetController petC = new PetController();

        propController.atualizarTabelaDePetsInicioFrame(tblPets, proprietario.getLstPetsPossuidos());
        propController.atualizarTabelaDeAgendamentos(tblAgendamentos, proprietario.getLstAgendamentos());


    }//GEN-LAST:event_lblAcessMouseClicked

    private void lblAcessMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAcessMouseEntered
        // TODO add your handling code here:
        lblAcess.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }//GEN-LAST:event_lblAcessMouseEntered

    private void lblAcessMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAcessMouseExited
        // TODO add your handling code here:
        lblAcess.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_lblAcessMouseExited

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbPropInfo;
    private javax.swing.JLabel lblAcess;
    private javax.swing.JLabel lblDel;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JTable tblAgendamentos;
    private javax.swing.JTable tblPets;
    // End of variables declaration//GEN-END:variables
}
