/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.clevervitor.hotelpet.view.dialogs;

import com.clevervitor.hotelpet.controller.PetController;
import com.clevervitor.hotelpet.model.entities.Pet;
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
public class DlgInfoPet extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialog
     */
    Pet pet;
    PetController petController;

    public DlgInfoPet(java.awt.Frame parent, boolean modal, Pet pet) {
        super(parent, modal);
        initComponents();

        this.pet = pet;
        this.petController = new PetController();

        preencherLabels();

        lblPetDe.setForeground(new Color(187, 187, 187));
        lblDono.setForeground(new Color(187, 187, 187));
        lblNasceuEm.setForeground(new Color(187, 187, 187));
        lblRaca.setForeground(new Color(187, 187, 187));
        lblResideEm.setForeground(new Color(187, 187, 187));
        lblEndereco.setForeground(new Color(187, 187, 187));

    }

    public void preencherLabels() {
        lblNomeProp.setText(pet.getNome());
        lblEspecie.setText(pet.getEspecie());
        lblSexo.setText(pet.getSexo());
        lblRaca.setText(pet.getRaca());
        lblDono.setText(pet.getProprietario().toString());
        lblEndereco.setText(pet.getProprietario().getEndereco());
        lblIdade.setText(pet.getIdade() + "anos");
        lblPeso.setText(pet.getPeso() + "kg.");
        
        lblObs.setText(pet.getObs());


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_img = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblPetDe = new javax.swing.JLabel();
        lblNasceuEm = new javax.swing.JLabel();
        lblNomeProp = new javax.swing.JLabel();
        lblDono = new javax.swing.JLabel();
        lblRaca = new javax.swing.JLabel();
        lblResideEm = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblEditar = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblEspecie = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblTem = new javax.swing.JLabel();
        lblIdade = new javax.swing.JLabel();
        lble = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        lblTem1 = new javax.swing.JLabel();
        lblObs = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_img, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        lblPetDe.setText("pet de");

        lblNasceuEm.setText("de raça");

        lblResideEm.setText("e reside em");

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

        lblEspecie.setText("jLabel1");

        lblSexo.setText("jLabel1");

        lblTem.setText("Tem");

        lblIdade.setText("jLabel1");

        lble.setText("e sua massa mede");

        lblPeso.setText("jLabel1");

        lblTem1.setText("Seu dono descreve seu pet como:");

        lblObs.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblObs.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEditar)
                .addGap(19, 19, 19))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblNomeProp, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEspecie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNasceuEm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblRaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator2)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(lblPetDe)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblDono, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblResideEm)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(lblTem)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lble)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblTem1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblObs, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeProp, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNasceuEm, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPetDe)
                                    .addComponent(lblDono, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTem)
                                    .addComponent(lblIdade)
                                    .addComponent(lble)
                                    .addComponent(lblPeso)))
                            .addComponent(lblResideEm)
                            .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEspecie)
                        .addComponent(lblSexo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTem1)
                    .addComponent(lblObs, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMouseClicked
        // TODO add your handling code here:
        DlgCadPet telaEditarPet;
        telaEditarPet = new DlgCadPet(new Frame(), true, pet);
        telaEditarPet.setVisible(true);
    }//GEN-LAST:event_lblEditarMouseClicked

    private void lblEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMouseEntered
        // TODO add your handling code here:
        lblEditar.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }//GEN-LAST:event_lblEditarMouseEntered

    private void lbl_imgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imgMouseClicked
//
//        String file = utils.uploadAvatar(petLogado.getId(), imgProfile, imgIcon);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblDono;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEspecie;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNasceuEm;
    private javax.swing.JLabel lblNomeProp;
    private javax.swing.JLabel lblObs;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblPetDe;
    private javax.swing.JLabel lblRaca;
    private javax.swing.JLabel lblResideEm;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTem;
    private javax.swing.JLabel lblTem1;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JLabel lble;
    // End of variables declaration//GEN-END:variables
}