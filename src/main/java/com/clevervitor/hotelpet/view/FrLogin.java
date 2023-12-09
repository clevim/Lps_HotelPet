/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.clevervitor.hotelpet.view;

import com.clevervitor.hotelpet.view.dialogs.DlgCadProprietario;
import com.clevervitor.hotelpet.model.dao.PessoaDAO;
import com.clevervitor.hotelpet.model.entities.Funcionario;
import com.clevervitor.hotelpet.model.entities.Pessoa;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import static com.clevervitor.hotelpet.valid.ValidateUtils.descriptografiaBase64Decode;
import com.clevervitor.hotelpet.view.UI.ShowMessageDialog;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author clevs
 */
public class FrLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrLogin
     */
    public FrLogin() {
        initComponents();

        lblLogin.setForeground(Color.white);
        lblPassword.setForeground(Color.white);
        lblCriarConta.setForeground(Color.white);

        Image iconeTitulo = null;
        try {
            iconeTitulo = ImageIO.read(getClass().getResource("/Imagens/pawprint.png"));
        } catch (IOException ex) {
            Logger.getLogger(FrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIconImage(iconeTitulo);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panLogin = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        edtLogin = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        bntLog = new javax.swing.JButton();
        lblCriarConta = new javax.swing.JButton();
        edtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        panLogin.setBackground(new java.awt.Color(51, 51, 51));

        lblLogin.setForeground(new java.awt.Color(242, 242, 242));
        lblLogin.setText("Usuario:");

        edtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtLoginActionPerformed(evt);
            }
        });

        lblPassword.setForeground(new java.awt.Color(242, 242, 242));
        lblPassword.setText("Senha:");

        bntLog.setText("Entrar");
        bntLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bntLogMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bntLogMouseExited(evt);
            }
        });
        bntLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLogActionPerformed(evt);
            }
        });

        lblCriarConta.setForeground(new java.awt.Color(242, 242, 242));
        lblCriarConta.setText("Criar Conta");
        lblCriarConta.setBorder(new javax.swing.border.MatteBorder(null));
        lblCriarConta.setBorderPainted(false);
        lblCriarConta.setContentAreaFilled(false);
        lblCriarConta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblCriarConta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblCriarConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCriarContaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCriarContaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCriarContaMouseExited(evt);
            }
        });
        lblCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblCriarContaActionPerformed(evt);
            }
        });

        edtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPasswordActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logoBranca.png"))); // NOI18N

        javax.swing.GroupLayout panLoginLayout = new javax.swing.GroupLayout(panLogin);
        panLogin.setLayout(panLoginLayout);
        panLoginLayout.setHorizontalGroup(
            panLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panLoginLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(panLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panLoginLayout.createSequentialGroup()
                        .addComponent(lblLogin)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panLoginLayout.createSequentialGroup()
                        .addGroup(panLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panLoginLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                                .addComponent(bntLog, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(lblCriarConta))
                            .addComponent(edtLogin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panLoginLayout.createSequentialGroup()
                                .addComponent(lblPassword)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(edtPassword))
                        .addGap(122, 122, 122))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(216, 216, 216))
        );
        panLoginLayout.setVerticalGroup(
            panLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panLoginLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(lblLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panLoginLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(bntLog))
                    .addGroup(panLoginLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblCriarConta)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void edtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtLoginActionPerformed

    private void bntLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLogActionPerformed
        String login = edtLogin.getText();
        String password = edtPassword.getText();

        PessoaDAO Pdao = new PessoaDAO();
        try {
            Pessoa p = Pdao.findByEmail(login);
            String senhaBD = descriptografiaBase64Decode(p.getSenha());

            if (p != null) {
                if (p.getEmail().equals(login) && senhaBD.equals(password)) {
                    int nivelAcesso = p.getNivelAcesso();
                    switch (nivelAcesso) {
                        case 0:
                            FrMainMenuFuncioario adminMenu = new FrMainMenuFuncioario((Funcionario) p);
                            adminMenu.setTitle("ADMIN");
                            adminMenu.setVisible(true);
                            dispose();

                            break;

                        case 1:
                            FrMainMenuFuncioario funcionarioMenu = new FrMainMenuFuncioario((Funcionario) p);
                            funcionarioMenu.setTitle("Funcionario");
                            funcionarioMenu.setVisible(true);
                            dispose();

                            break;

                        case 2:
                            FrMainMenuClient clienteMenu = new FrMainMenuClient((Proprietario) p);
                            clienteMenu.setTitle("Cliente");
                            clienteMenu.setVisible(true);
                            dispose();

                            break;
                        default:
                            ShowMessageDialog DialMsg = new ShowMessageDialog( "ERRO", "Nivel de Acesso inexistente");
                            DialMsg.setVisible(true);
                    }

                } else {
                    ShowMessageDialog DialMsg = new ShowMessageDialog( "Incorreto", "Senha incorreta! Tente novamente.");
                    DialMsg.setVisible(true);
                }
            }
        } catch (Exception e) {
            System.out.print(e);
            ShowMessageDialog DialMsg = new ShowMessageDialog( "Incorreto", "Email incorreto! Tente novamente.");
            DialMsg.setVisible(true);
        }
    }//GEN-LAST:event_bntLogActionPerformed

    private void lblCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblCriarContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCriarContaActionPerformed

    private void lblCriarContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCriarContaMouseClicked
        // TODO add your handling code here:
        DlgCadProprietario cadastroProp = new DlgCadProprietario(new Frame("Login"), true);
        cadastroProp.setTitle("Cadastro");
        cadastroProp.setVisible(true);
    }//GEN-LAST:event_lblCriarContaMouseClicked

    private void lblCriarContaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCriarContaMouseEntered
        // TODO add your handling code here:
        lblCriarConta.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblCriarContaMouseEntered

    private void lblCriarContaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCriarContaMouseExited
        // TODO add your handling code here:
        lblCriarConta.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_lblCriarContaMouseExited

    private void bntLogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntLogMouseEntered
        // TODO add your handling code here:
        lblCriarConta.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }//GEN-LAST:event_bntLogMouseEntered

    private void bntLogMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntLogMouseExited
        // TODO add your handling code here:
        lblCriarConta.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_bntLogMouseExited

    private void edtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPasswordActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntLog;
    private javax.swing.JTextField edtLogin;
    private javax.swing.JPasswordField edtPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton lblCriarConta;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JPanel panLogin;
    // End of variables declaration//GEN-END:variables
}
