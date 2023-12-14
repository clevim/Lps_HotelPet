/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.clevervitor.hotelpet.view;

import com.clevervitor.hotelpet.connection.loginContexto;
import com.clevervitor.hotelpet.view.dialogs.Cadastros.DlgCadAgendamento;
import com.clevervitor.hotelpet.controller.ProprietarioController;
import com.clevervitor.hotelpet.controller.tableModel.TMAgendamentos;
import com.clevervitor.hotelpet.model.dao.PessoaDAO;
import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Pessoa;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.utils.utils;
import com.clevervitor.hotelpet.view.UI.ShowMessageDialog;
import com.clevervitor.hotelpet.view.dialogs.Cadastros.DlgCadPet;
import com.clevervitor.hotelpet.view.dialogs.Cadastros.DlgCadProprietario;
import com.clevervitor.hotelpet.view.dialogs.DlgContato;
import com.clevervitor.hotelpet.view.dialogs.Infos.DlgInfoAgendamento;
import com.clevervitor.hotelpet.view.dialogs.Infos.DlgInfoPet;
import com.clevervitor.hotelpet.view.dialogs.DlgSobre;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Frame;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JOptionPane;
import org.hibernate.Hibernate;

/**
 *
 * @author clevs
 */
public class FrMainMenuClient extends javax.swing.JDialog {

    loginContexto pessoaLogada = loginContexto.getInstance();
    /**
     * Creates new form mainMenu
     */
    ProprietarioController propController;
    Proprietario proprietarioLogado;
    utils utils;
    byte[] imgProfile = null;
    ImageIcon imgIcon = null;

    public FrMainMenuClient(java.awt.Frame parent, boolean modal, Proprietario proprietario) {
        super(parent, modal);

        initComponents();

        propController = new ProprietarioController();
        utils = new utils();

        propController.atualizarTabelaDePetsInicioFrame(grdPets, proprietario.getLstPetsPossuidos());

        lblNome.setForeground(Color.WHITE);

        scrollPets.getViewport().setBackground(new Color(51, 51, 51));
        scrollAgendamentos.getViewport().setBackground(new Color(250, 250, 250));

        Image iconeTitulo = null;
        try {
            iconeTitulo = ImageIO.read(getClass().getResource("/Imagens/pawprint.png"));
        } catch (IOException ex) {
            Logger.getLogger(FrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIconImage(iconeTitulo);

        this.propController = new ProprietarioController();

        if (pessoaLogada.getPessoaLogada().getNivelAcesso() != 2) {
            this.proprietarioLogado = proprietario;
        } else {
            this.proprietarioLogado = propController.buscarProprietario(pessoaLogada.getPessoaLogada().getId());
        }

        imgProfile = proprietarioLogado.getAvatar();
        if (imgProfile != null) {
            imgIcon = new ImageIcon(new ImageIcon(imgProfile).getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH));
            if (imgIcon != null) {
                lbl_img.setText(null);
            }
        }

        if (pessoaLogada.getPessoaLogada().getNivelAcesso() != 2) {
            mnLogout.setVisible(false);
            mnLogout.setEnabled(false);
        } else {
            mnLogout.setVisible(true);
            mnLogout.setEnabled(true);
        }

        btnAgendar.setToolTipText("Agendar hospedagem");

        preencherLabels();

    }

    public void preencherLabels() {
        lblNomeCliente.setForeground(Color.WHITE);
        lblEnderecoCliente.setForeground(Color.WHITE);
        lblDocCliente.setForeground(Color.WHITE);
        lblContatoCliente.setForeground(Color.WHITE);

        lblNomeCliente.setText(proprietarioLogado.getNome() + "!");
        lblEnderecoCliente.setText("End.: " + proprietarioLogado.getEndereco());
        lblDocCliente.setText("Cpf: " + proprietarioLogado.getCpf());
        lblContatoCliente.setText("Telefone: " + proprietarioLogado.getTel());
        lbl_img.setIcon(imgIcon);

        propController.atualizarTabelaDePetsInicioFrame(grdPets, proprietarioLogado.getLstPetsPossuidos());
        propController.atualizarTabelaDeAgendamentos(grdAgendamentos, proprietarioLogado.getLstAgendamentos());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCliente = new javax.swing.JPanel();
        lblNomeCliente = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        pnlAgendamentos = new javax.swing.JPanel();
        scrollAgendamentos = new javax.swing.JScrollPane();
        grdAgendamentos = new javax.swing.JTable();
        btnAgendar = new com.clevervitor.hotelpet.view.UI.FloatingButton();
        pnlPetsCliente = new javax.swing.JPanel();
        scrollPets = new javax.swing.JScrollPane();
        grdPets = new javax.swing.JTable();
        lbl_img = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblContatoCliente = new javax.swing.JLabel();
        lblDocCliente = new javax.swing.JLabel();
        lblEnderecoCliente = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        menuAdicionarPet = new javax.swing.JMenuItem();
        mnEditarPerfil = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnLogout = new javax.swing.JMenuItem();
        menuContato = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu Principal");
        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        pnlCliente.setBackground(new java.awt.Color(51, 51, 51));

        lblNomeCliente.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        lblNomeCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblNome.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        lblNome.setForeground(new java.awt.Color(242, 242, 242));
        lblNome.setText("Seja bem-vindo novamente,");

        pnlAgendamentos.setBackground(new java.awt.Color(51, 51, 51));
        pnlAgendamentos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seus agendamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ebrima", 0, 24), new java.awt.Color(204, 204, 204))); // NOI18N
        pnlAgendamentos.setForeground(new java.awt.Color(204, 204, 204));

        scrollAgendamentos.setBackground(new java.awt.Color(160, 160, 160));
        scrollAgendamentos.setBorder(null);
        scrollAgendamentos.setForeground(new java.awt.Color(255, 255, 255));

        grdAgendamentos.setBackground(new java.awt.Color(160, 160, 160));
        grdAgendamentos.setForeground(new java.awt.Color(255, 255, 255));
        grdAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        grdAgendamentos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        grdAgendamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdAgendamentosMouseClicked(evt);
            }
        });
        scrollAgendamentos.setViewportView(grdAgendamentos);

        btnAgendar.setBorder(null);
        btnAgendar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/dog-house (2).png"))); // NOI18N
        btnAgendar.setFocusPainted(false);
        btnAgendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgendarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgendarMouseExited(evt);
            }
        });
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAgendamentosLayout = new javax.swing.GroupLayout(pnlAgendamentos);
        pnlAgendamentos.setLayout(pnlAgendamentosLayout);
        pnlAgendamentosLayout.setHorizontalGroup(
            pnlAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgendamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollAgendamentos)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgendamentosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        pnlAgendamentosLayout.setVerticalGroup(
            pnlAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgendamentosLayout.createSequentialGroup()
                .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(scrollAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlPetsCliente.setBackground(new java.awt.Color(51, 51, 51));
        pnlPetsCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seus pets", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ebrima", 1, 24), new java.awt.Color(51, 204, 204))); // NOI18N

        scrollPets.setBorder(null);

        grdPets.setBackground(new java.awt.Color(160, 160, 160));
        grdPets.setForeground(new java.awt.Color(255, 255, 255));
        grdPets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        grdPets.setCellSelectionEnabled(true);
        grdPets.setShowGrid(true);
        grdPets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdPetsMouseClicked(evt);
            }
        });
        scrollPets.setViewportView(grdPets);
        grdPets.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout pnlPetsClienteLayout = new javax.swing.GroupLayout(pnlPetsCliente);
        pnlPetsCliente.setLayout(pnlPetsClienteLayout);
        pnlPetsClienteLayout.setHorizontalGroup(
            pnlPetsClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnlPetsClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPetsClienteLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPets, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlPetsClienteLayout.setVerticalGroup(
            pnlPetsClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 123, Short.MAX_VALUE)
            .addGroup(pnlPetsClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPetsClienteLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPets, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        lbl_img.setBackground(new java.awt.Color(160, 160, 160));
        lbl_img.setForeground(new java.awt.Color(242, 242, 242));
        lbl_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_img.setText("Carregar Imagem");
        lbl_img.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        lbl_img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_imgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_imgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_imgMouseExited(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new java.awt.GridLayout(3, 0, 0, 1));

        lblContatoCliente.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jPanel1.add(lblContatoCliente);

        lblDocCliente.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        jPanel1.add(lblDocCliente);

        lblEnderecoCliente.setBackground(new java.awt.Color(51, 51, 51));
        lblEnderecoCliente.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jPanel1.add(lblEnderecoCliente);

        javax.swing.GroupLayout pnlClienteLayout = new javax.swing.GroupLayout(pnlCliente);
        pnlCliente.setLayout(pnlClienteLayout);
        pnlClienteLayout.setHorizontalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPetsCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addGap(5, 5, 5)
                        .addComponent(lblNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        pnlClienteLayout.setVerticalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(pnlAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPetsCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jMenuBar1.setBackground(new java.awt.Color(40, 40, 40));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setToolTipText("");

        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Menu");

        menuAdicionarPet.setText("Adicionar pet");
        menuAdicionarPet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAdicionarPetMouseClicked(evt);
            }
        });
        menuAdicionarPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAdicionarPetActionPerformed(evt);
            }
        });
        jMenu3.add(menuAdicionarPet);

        mnEditarPerfil.setText("Editar perfil");
        mnEditarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEditarPerfilActionPerformed(evt);
            }
        });
        jMenu3.add(mnEditarPerfil);
        jMenu3.add(jSeparator1);

        mnLogout.setText("Logout");
        mnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnLogoutActionPerformed(evt);
            }
        });
        jMenu3.add(mnLogout);

        jMenuBar1.add(jMenu3);

        menuContato.setForeground(new java.awt.Color(255, 255, 255));
        menuContato.setText("Contato");
        menuContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuContatoMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuContato);

        menuSobre.setForeground(new java.awt.Color(255, 255, 255));
        menuSobre.setText("Sobre");
        menuSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSobreMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuSobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuAdicionarPetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAdicionarPetMouseClicked
        // TODO add your handling code here:
        DlgCadPet telaCadPet = new DlgCadPet(new Frame(), true, proprietarioLogado);
        telaCadPet.setTitle("Cadastro Pet");
        telaCadPet.setVisible(true);
    }//GEN-LAST:event_menuAdicionarPetMouseClicked

    private void menuAdicionarPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAdicionarPetActionPerformed
        // TODO add your handling code here:
        DlgCadPet telaCadPet = new DlgCadPet(new Frame(), true, proprietarioLogado);
        telaCadPet.setTitle("Cadastro Pet");
        telaCadPet.setVisible(true);
        telaCadPet.setAlwaysOnTop(true);

        proprietarioLogado = propController.buscarProprietario(proprietarioLogado.getId());
        propController.atualizarTabelaDePetsInicioFrame(grdPets, proprietarioLogado.getLstPetsPossuidos());


    }//GEN-LAST:event_menuAdicionarPetActionPerformed

    private Object getObjetoSelecionadoNaGridDePets() {
        int rowCliked = grdPets.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grdPets.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }

    private Object getObjetoSelecionadoNaGridDeAgendamentos() {
        int rowCliked = grdAgendamentos.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grdAgendamentos.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }

    private void mnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnLogoutActionPerformed
        FrLogin TLogin = new FrLogin();
        TLogin.setTitle("Login");
        TLogin.setVisible(true);
        this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_mnLogoutActionPerformed

    private void lbl_imgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imgMouseClicked

        String file = utils.uploadAvatar(proprietarioLogado.getId(), imgProfile, imgIcon);

        if (!file.isEmpty()) {

            lbl_img.setText(null);
            imgIcon = new ImageIcon(new ImageIcon(file).getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH));
            lbl_img.setIcon(imgIcon);
            ShowMessageDialog DialMsg = new ShowMessageDialog("Sucesso", "Avatar atualizado!");
            DialMsg.setVisible(true);
        }
    }//GEN-LAST:event_lbl_imgMouseClicked

    private void menuSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSobreMouseClicked
        // TODO add your handling code here:

        DlgSobre sobre = new DlgSobre(new Frame(), true);
        sobre.setVisible(true);
    }//GEN-LAST:event_menuSobreMouseClicked

    private void menuContatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuContatoMouseClicked
        DlgContato contato = new DlgContato(new Frame(), true);
        contato.setVisible(true);
    }//GEN-LAST:event_menuContatoMouseClicked

    private void grdPetsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdPetsMouseClicked
        // TODO add your handling code here:
        Pet petSelecionado = (Pet) getObjetoSelecionadoNaGridDePets();

        if (evt.getClickCount() == 2) {
            DlgInfoPet telaInfoPet = new DlgInfoPet(new Frame(), true, petSelecionado);
            telaInfoPet.setVisible(true);
        }

        propController.atualizarTabelaDePetsInicioFrame(grdPets, propController.buscarProprietario(proprietarioLogado.getId()).getLstPetsPossuidos());


    }//GEN-LAST:event_grdPetsMouseClicked

    private void grdAgendamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdAgendamentosMouseClicked
        // TODO add your handling code here:
        Agendamento agendamentoSelecionado = (Agendamento) getObjetoSelecionadoNaGridDeAgendamentos();

        if (evt.getClickCount() == 2) {
            DlgInfoAgendamento telaInfoAgendamento = new DlgInfoAgendamento(new Frame(), true, agendamentoSelecionado);
            telaInfoAgendamento.setVisible(true);
        }

        propController.atualizarTabelaDeAgendamentos(grdAgendamentos, propController.buscarProprietario(proprietarioLogado.getId()).getLstAgendamentos());
    }//GEN-LAST:event_grdAgendamentosMouseClicked

    private void btnAgendarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarMouseExited
        // TODO add your handling code here:
        btnAgendar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        btnAgendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/dog-house (2).png")));

    }//GEN-LAST:event_btnAgendarMouseExited

    private void btnAgendarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarMouseEntered
        // TODO add your handling code here:
        btnAgendar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAgendar.setFocusPainted(false);
        btnAgendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ezgif.com-resize_2.gif")));

    }

    private void btnAgendarMouseExited() {
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgendarMouseEntered

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        DlgCadAgendamento telaAgendamento = new DlgCadAgendamento(new Frame(), true, proprietarioLogado);
        telaAgendamento.setVisible(true);

        this.proprietarioLogado = propController.buscarProprietario(proprietarioLogado.getId());
        propController.atualizarTabelaDeAgendamentos(grdAgendamentos, proprietarioLogado.getLstAgendamentos());
    }//GEN-LAST:event_btnAgendarActionPerformed

    private void mnEditarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEditarPerfilActionPerformed
        try {
            // TODO add your handling code here:

            DlgCadProprietario telaEditarPerfil = new DlgCadProprietario(new Frame(), true, proprietarioLogado);
            telaEditarPerfil.setVisible(true);

            preencherLabels();

        } catch (ParseException ex) {
            Logger.getLogger(FrMainMenuClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_mnEditarPerfilActionPerformed

    private void lbl_imgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imgMouseEntered
        // TODO add your handling code here:
        lbl_img.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }//GEN-LAST:event_lbl_imgMouseEntered

    private void lbl_imgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imgMouseExited
        // TODO add your handling code here:
        lbl_img.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_lbl_imgMouseExited

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.clevervitor.hotelpet.view.UI.FloatingButton btnAgendar;
    private javax.swing.JTable grdAgendamentos;
    private javax.swing.JTable grdPets;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblContatoCliente;
    private javax.swing.JLabel lblDocCliente;
    private javax.swing.JLabel lblEnderecoCliente;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JMenuItem menuAdicionarPet;
    private javax.swing.JMenu menuContato;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JMenuItem mnEditarPerfil;
    private javax.swing.JMenuItem mnLogout;
    private javax.swing.JPanel pnlAgendamentos;
    private javax.swing.JPanel pnlCliente;
    private javax.swing.JPanel pnlPetsCliente;
    private javax.swing.JScrollPane scrollAgendamentos;
    private javax.swing.JScrollPane scrollPets;
    // End of variables declaration//GEN-END:variables
}
