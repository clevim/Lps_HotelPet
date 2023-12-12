/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.clevervitor.hotelpet.view.dialogs;

import com.clevervitor.hotelpet.connection.loginContexto;
import com.clevervitor.hotelpet.controller.ProprietarioController;
import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.utils.utils;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Image;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author vitor
 */
public class DlgInfoAgendamento extends javax.swing.JDialog {

    loginContexto pessoaLogada = loginContexto.getInstance();

    /**
     * Creates new form NewJDialog
     */
    Agendamento agendamento;
    Proprietario proprietario;
    ProprietarioController propController;

    public DlgInfoAgendamento(java.awt.Frame parent, boolean modal, Agendamento agend) {
        super(parent, modal);
        initComponents();

        this.agendamento = agend;
        

        preencherLabels();



    }

    public void preencherLabels() {
//lblAgendamentoMarcado.setForeground(new Color(187, 187, 187));
//        lblPet.setForeground(new Color(187, 187, 187));
//        lblPet.setText(agendamento.getPetAgendado().toString());
//        lblAgendamentoMarcado1.setForeground(new Color(187, 187, 187));
//        lblDeDono.setForeground(new Color(187, 187, 187));
//        lblDono.setText(agendamento.getProprietarioResp().toString());
//        lblDataCheckIn.setForeground(new Color(187, 187, 187));
//        lblDataCheckIn.setText(agendamento.getDataCheckIn());
//        lblDataCheckOut.setForeground(new Color(187, 187, 187));
//        lblDataCheckOut.setText(agendamento.getDataCheckOut() + ".");
//        
//        lblServicos.setText(utils.ToStringServiceName(agendamento.getServicosAdicionais()));
//        lblValor.setText(Double.toString(agendamento.getValor()));
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
        lblEditar = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_img = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        lblEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/edit (2).png"))); // NOI18N
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

        lbl_img.setBackground(new java.awt.Color(160, 160, 160));
        lbl_img.setForeground(new java.awt.Color(242, 242, 242));
        lbl_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_img.setText("Update Avatar");
        lbl_img.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        lbl_img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_imgMouseClicked(evt);
            }
        });

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEditar))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEditar)
                    .addComponent(lbl_img, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMouseClicked
        // TODO add your handling code here:
        DlgCadAgendamento telaEditarAgendamento;
        try {
            telaEditarAgendamento = new DlgCadAgendamento(new Frame(), true, agendamento);
            telaEditarAgendamento.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(DlgInfoAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblEditarMouseClicked

    private void lblEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMouseEntered
        // TODO add your handling code here:
        lblEditar.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }//GEN-LAST:event_lblEditarMouseEntered

    private void lbl_imgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imgMouseClicked
//
//        String file = utils.uploadAvatar(proprietarioLogado.getId(), imgProfile, imgIcon);
//
//        if (!file.isEmpty()) {
//
//            lbl_img.setText(null);
//            imgIcon = new ImageIcon(new ImageIcon(file).getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH));
//            lbl_img.setIcon(imgIcon);
//            ShowMessageDialog DialMsg = new ShowMessageDialog("Sucesso", "Avatar atualizado!");
//            DialMsg.setVisible(true);
//        }
    }//GEN-LAST:event_lbl_imgMouseClicked

    private void lblEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMouseExited
        // TODO add your handling code here:
        lblEditar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_lblEditarMouseExited

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lbl_img;
    // End of variables declaration//GEN-END:variables
}
