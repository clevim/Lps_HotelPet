/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.clevervitor.hotelpet.view;

import com.clevervitor.hotelpet.model.dao.PessoaDAO;
import com.clevervitor.hotelpet.model.entities.Pessoa;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        
        lblCriarConta.addMouseListener(new MouseAdapter(){
            public void clique(MouseEvent e){
                
                System.out.println("label clicada");
                java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.windowForComponent(FrLogin.this);
                
                DlgCadProprietario frameCadastroProp = new DlgCadProprietario(parentFrame, true);
                frameCadastroProp.setVisible(true);
            }
            
            
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panLogo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panLogin = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        edtLogin = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        edtPassword = new javax.swing.JTextField();
        bntLog = new javax.swing.JButton();
        lblCriarConta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logorzise.png"))); // NOI18N

        javax.swing.GroupLayout panLogoLayout = new javax.swing.GroupLayout(panLogo);
        panLogo.setLayout(panLogoLayout);
        panLogoLayout.setHorizontalGroup(
            panLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panLogoLayout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panLogoLayout.setVerticalGroup(
            panLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panLogoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        lblLogin.setText("Usuario:");

        edtLogin.setText("Login");
        edtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtLoginActionPerformed(evt);
            }
        });

        lblPassword.setText("Senha:");

        edtPassword.setText("Password");

        bntLog.setText("Entrar");
        bntLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLogActionPerformed(evt);
            }
        });

        lblCriarConta.setText("Criar Conta");
        lblCriarConta.setBorder(new javax.swing.border.MatteBorder(null));
        lblCriarConta.setBorderPainted(false);
        lblCriarConta.setContentAreaFilled(false);
        lblCriarConta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblCriarConta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblCriarContaActionPerformed(evt);
            }
        });

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
                                .addGap(195, 195, 195)
                                .addComponent(lblCriarConta))
                            .addComponent(edtPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                            .addComponent(edtLogin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bntLog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panLoginLayout.createSequentialGroup()
                                .addComponent(lblPassword)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(122, 122, 122))))
        );
        panLoginLayout.setVerticalGroup(
            panLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panLoginLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntLog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCriarConta)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
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

            if (p != null) {
                if (p.getEmail().equals(login) && p.getSenha().equals(password)) {
                    int nivelAcesso = p.getNivelAcesso();
                    switch (nivelAcesso) {
                        case 0:
                            FrMainMenuFuncioario adminMenu = new FrMainMenuFuncioario();
                            adminMenu.setVisible(true);
                            dispose();

                            break;

                        case 1:
                            FrMainMenuFuncioario funcionarioMenu = new FrMainMenuFuncioario();
                            funcionarioMenu.setVisible(true);
                            dispose();

                            break;

                        case 2:
                            FrMainMenuClient clienteMenu = new FrMainMenuClient();
                            clienteMenu.setVisible(true);
                            dispose();

                            break;
                        default:
                            throw new AssertionError();
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao validar o login: " + e.getMessage());

        }
    }//GEN-LAST:event_bntLogActionPerformed
    
    private void lblCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblCriarContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCriarContaActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntLog;
    private javax.swing.JTextField edtLogin;
    private javax.swing.JTextField edtPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton lblCriarConta;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JPanel panLogin;
    private javax.swing.JPanel panLogo;
    // End of variables declaration//GEN-END:variables
}
