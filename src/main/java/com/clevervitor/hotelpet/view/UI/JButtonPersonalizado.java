/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.view.UI;

import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.view.dialogs.DlgCadPet;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author vitor
 */
public class JButtonPersonalizado extends javax.swing.JButton {

    JButton btnEditarPet = new javax.swing.JButton(new ImageIcon(getClass().getResource("/Imagens/iconEdit.png")));
    private Pet petEditavel;

    public JButtonPersonalizado() {


        //btnEditarPet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconAgendarEstadia32.png"))); // NOI18N
        btnEditarPet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarPetMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarPetMouseExited(evt);
            }

            private void btnEditarPetMouseEntered(MouseEvent evt) {
                btnEditarPet.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            private void btnEditarPetMouseExited(MouseEvent evt) {
                btnEditarPet.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        btnEditarPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPetActionPerformed(evt);
            }

            private void btnEditarPetActionPerformed(ActionEvent evt) {
                DlgCadPet telaEditPet = new DlgCadPet(new Frame(), true, petEditavel, 1);
                telaEditPet.setVisible(true);
            }
        });
    }
    
            public void setPetEditavel(Pet pet){
                this.petEditavel = pet;
            }
}
