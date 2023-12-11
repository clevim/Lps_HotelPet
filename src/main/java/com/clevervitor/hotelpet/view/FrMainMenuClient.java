/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.clevervitor.hotelpet.view;

import com.clevervitor.hotelpet.view.dialogs.DlgCadAgendamento;
import com.clevervitor.hotelpet.controller.ProprietarioController;
import com.clevervitor.hotelpet.controller.tableModel.TMAgendamentos;
import com.clevervitor.hotelpet.model.dao.PessoaDAO;
import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Pessoa;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.utils.utils;
import com.clevervitor.hotelpet.view.UI.JButtonUI;
import com.clevervitor.hotelpet.view.UI.ShowMessageDialog;
import com.clevervitor.hotelpet.view.UI.TableActionCellRender;
import com.clevervitor.hotelpet.view.dialogs.DlgCadPet;
import com.clevervitor.hotelpet.view.dialogs.DlgContato;
import com.clevervitor.hotelpet.view.dialogs.DlgInfoAgendamento;
import com.clevervitor.hotelpet.view.dialogs.DlgInfoPet;
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

/**
 *
 * @author clevs
 */
public class FrMainMenuClient extends javax.swing.JDialog {

    /**
     * Creates new form mainMenu
     */
    ProprietarioController propController;
    Proprietario proprietarioLogado;
    utils utils;
    byte[] imgProfile = null;
    ImageIcon imgIcon = null;

    public FrMainMenuClient(Proprietario proprietario) {
        initComponents();

        propController = new ProprietarioController();
        utils = new utils();

        propController.atualizarTabelaDePetsInicioFrame(grdPets, proprietario.getLstPetsPossuidos());
        grdPets.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());

        //com.clevervitor.hotelpet.view.UI.TableActionCellRender[Table.cellRenderer,0,0,0x0,invalid,alignmentX=0.0,alignmentY=0.0,border=javax.swing.border.EmptyBorder@61a30083,flags=25165832,maximumSize=,minimumSize=,preferredSize=,defaultIcon=,disabledIcon=,horizontalAlignment=LEADING,horizontalTextPosition=TRAILING,iconTextGap=4,labelFor=,text=,verticalAlignment=CENTER,verticalTextPosition=CENTER]
        lblNome.setForeground(Color.WHITE);
        lblEndereco.setForeground(Color.WHITE);
        lblDocumeto.setForeground(Color.WHITE);
        lblContato.setForeground(Color.WHITE);
        lblAgendar.setForeground(Color.WHITE);

        scrollPets.getViewport().setBackground(new Color(51, 51, 51));
        scrollAgendamentos.getViewport().setBackground(new Color(250, 250, 250));

        Image iconeTitulo = null;
        try {
            iconeTitulo = ImageIO.read(getClass().getResource("/Imagens/pawprint.png"));
        } catch (IOException ex) {
            Logger.getLogger(FrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIconImage(iconeTitulo);

        this.proprietarioLogado = (Proprietario) proprietario;
        this.propController = new ProprietarioController();

        imgProfile = proprietarioLogado.getAvatar();
        if (imgProfile != null) {
            imgIcon = new ImageIcon(new ImageIcon(imgProfile).getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH));
            if (imgIcon != null) {
                lbl_img.setText(null);
            }
        }

        habilitarCampos(true);

    }

    public void habilitarCampos(boolean flag) {
        lblNomeCliente.setText(proprietarioLogado.getNome() + "!");
        lblNomeCliente.setForeground(Color.WHITE);
        lblEnderecoCliente.setText(proprietarioLogado.getEndereco());
        lblEnderecoCliente.setForeground(Color.WHITE);
        lblDocCliente.setText(proprietarioLogado.getCpf());
        lblDocCliente.setForeground(Color.WHITE);
        lblContatoCliente.setText(proprietarioLogado.getTel());
        lblContatoCliente.setForeground(Color.WHITE);
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

        jPanel1 = new javax.swing.JPanel();
        pnlCliente = new javax.swing.JPanel();
        lblNomeCliente = new javax.swing.JLabel();
        lblContatoCliente = new javax.swing.JLabel();
        lblDocCliente = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblDocumeto = new javax.swing.JLabel();
        lblContato = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblEnderecoCliente = new javax.swing.JLabel();
        pnlAgendamentos = new javax.swing.JPanel();
        scrollAgendamentos = new javax.swing.JScrollPane();
        grdAgendamentos = new javax.swing.JTable();
        lblAgendar = new javax.swing.JLabel();
        btnAgendarEstadia = new javax.swing.JButton();
        pnlPetsCliente = new javax.swing.JPanel();
        scrollPets = new javax.swing.JScrollPane();
        grdPets = new javax.swing.JTable();
        lbl_img = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        menuAdicionarPet = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuContato = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenu();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        pnlCliente.setBackground(new java.awt.Color(51, 51, 51));

        lblNomeCliente.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 24)); // NOI18N
        lblNomeCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblContatoCliente.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N

        lblNome.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 24)); // NOI18N
        lblNome.setForeground(new java.awt.Color(242, 242, 242));
        lblNome.setText("Seja bem-vindo novamente,");

        lblDocumeto.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lblDocumeto.setForeground(new java.awt.Color(242, 242, 242));
        lblDocumeto.setText("Doc.:");

        lblContato.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lblContato.setForeground(new java.awt.Color(242, 242, 242));
        lblContato.setText("Contato:");

        lblEndereco.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lblEndereco.setForeground(new java.awt.Color(242, 242, 242));
        lblEndereco.setText("Endereço:");

        lblEnderecoCliente.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N

        pnlAgendamentos.setBackground(new java.awt.Color(51, 51, 51));
        pnlAgendamentos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seus agendamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI", 1, 24), new java.awt.Color(204, 204, 204))); // NOI18N
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

        lblAgendar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        lblAgendar.setForeground(new java.awt.Color(242, 242, 242));
        lblAgendar.setText("Agendar");
        lblAgendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAgendarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAgendarMouseExited(evt);
            }
        });

        btnAgendarEstadia.setBackground(new java.awt.Color(51, 51, 51));
        btnAgendarEstadia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/iconAgendarEstadia32.png"))); // NOI18N
        btnAgendarEstadia.setBorder(null);
        btnAgendarEstadia.setBorderPainted(false);
        btnAgendarEstadia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgendarEstadiaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgendarEstadiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgendarEstadiaMouseExited(evt);
            }
        });
        btnAgendarEstadia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarEstadiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAgendamentosLayout = new javax.swing.GroupLayout(pnlAgendamentos);
        pnlAgendamentos.setLayout(pnlAgendamentosLayout);
        pnlAgendamentosLayout.setHorizontalGroup(
            pnlAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgendamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAgendamentosLayout.createSequentialGroup()
                        .addComponent(scrollAgendamentos)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgendamentosLayout.createSequentialGroup()
                        .addGap(0, 928, Short.MAX_VALUE)
                        .addGroup(pnlAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgendamentosLayout.createSequentialGroup()
                                .addComponent(btnAgendarEstadia)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgendamentosLayout.createSequentialGroup()
                                .addComponent(lblAgendar)
                                .addGap(23, 23, 23))))))
        );
        pnlAgendamentosLayout.setVerticalGroup(
            pnlAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgendamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgendarEstadia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(scrollAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlPetsCliente.setBackground(new java.awt.Color(51, 51, 51));
        pnlPetsCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seus pets", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI", 1, 24), new java.awt.Color(255, 204, 0))); // NOI18N

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
        lbl_img.setText("Update Avatar");
        lbl_img.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        lbl_img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_imgMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlClienteLayout = new javax.swing.GroupLayout(pnlCliente);
        pnlCliente.setLayout(pnlClienteLayout);
        pnlClienteLayout.setHorizontalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPetsCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClienteLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addComponent(lblEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEnderecoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(261, 261, 261))
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addComponent(lblDocumeto)
                        .addGap(5, 5, 5)
                        .addComponent(lblDocCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlClienteLayout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlClienteLayout.createSequentialGroup()
                                .addComponent(lblContato)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblContatoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlClienteLayout.setVerticalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDocumeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDocCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEnderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblContato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblContatoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPetsCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jMenuBar1.setBackground(new java.awt.Color(160, 160, 160));
        jMenuBar1.setBorder(null);
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

        jMenu5.setText("Relatorios");

        jMenuItem2.setText("Hospedagem");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuItem3.setText("Pets");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenu3.add(jMenu5);
        jMenu3.add(jSeparator1);

        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

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

    private void btnAgendarEstadiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarEstadiaMouseEntered
        // TODO add your handling code here:
        btnAgendarEstadia.setCursor(new Cursor(Cursor.HAND_CURSOR));


    }//GEN-LAST:event_btnAgendarEstadiaMouseEntered

    private void btnAgendarEstadiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarEstadiaActionPerformed
        // TODO add your handling code here:
        DlgCadAgendamento telaAgendamento = new DlgCadAgendamento(new Frame(), true, proprietarioLogado);
        telaAgendamento.setVisible(true);

        this.proprietarioLogado = propController.buscarProprietario(proprietarioLogado.getId());
        propController.atualizarTabelaDeAgendamentos(grdAgendamentos, proprietarioLogado.getLstAgendamentos());


    }//GEN-LAST:event_btnAgendarEstadiaActionPerformed

    private void lblAgendarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgendarMouseEntered
        // TODO add your handling code here:
        lblAgendar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblAgendarMouseEntered

    private void lblAgendarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgendarMouseExited
        // TODO add your handling code here:
        lblAgendar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblAgendarMouseExited

    private void btnAgendarEstadiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarEstadiaMouseExited
        // TODO add your handling code here:
        btnAgendarEstadia.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnAgendarEstadiaMouseExited

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FrLogin TLogin = new FrLogin();
        TLogin.setTitle("Login");
        TLogin.setVisible(true);
        this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
        DlgContato contato = new DlgContato(proprietarioLogado.getEmail());
        contato.setVisible(true);
    }//GEN-LAST:event_menuContatoMouseClicked

    private void btnAgendarEstadiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarEstadiaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgendarEstadiaMouseClicked

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

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendarEstadia;
    private javax.swing.JTable grdAgendamentos;
    private javax.swing.JTable grdPets;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblAgendar;
    private javax.swing.JLabel lblContato;
    private javax.swing.JLabel lblContatoCliente;
    private javax.swing.JLabel lblDocCliente;
    private javax.swing.JLabel lblDocumeto;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEnderecoCliente;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JMenuItem menuAdicionarPet;
    private javax.swing.JMenu menuContato;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JPanel pnlAgendamentos;
    private javax.swing.JPanel pnlCliente;
    private javax.swing.JPanel pnlPetsCliente;
    private javax.swing.JScrollPane scrollAgendamentos;
    private javax.swing.JScrollPane scrollPets;
    // End of variables declaration//GEN-END:variables
}
