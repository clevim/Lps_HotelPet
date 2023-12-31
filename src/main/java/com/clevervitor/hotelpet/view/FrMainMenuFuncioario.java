/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.clevervitor.hotelpet.view;

import com.clevervitor.hotelpet.connection.loginContexto;
import com.clevervitor.hotelpet.controller.AgendamentoController;
import com.clevervitor.hotelpet.controller.FuncionarioController;
import com.clevervitor.hotelpet.controller.PetController;
import com.clevervitor.hotelpet.controller.ProprietarioController;
import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Funcionario;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.model.entities.filtros.FiltroAgendamento;
import com.clevervitor.hotelpet.model.entities.filtros.FiltroFuncionario;
import com.clevervitor.hotelpet.model.entities.filtros.FiltroPet;
import com.clevervitor.hotelpet.model.entities.filtros.FiltroProprietario;
import com.clevervitor.hotelpet.utils.utils;
import com.clevervitor.hotelpet.view.UI.ShowMessageDialog;
import com.clevervitor.hotelpet.view.dialogs.Cadastros.DlgCadProprietario;
import com.clevervitor.hotelpet.view.dialogs.Cadastros.DlgCadServicos;
import com.clevervitor.hotelpet.view.dialogs.Filtros.DlgFilterAgendamento;
import com.clevervitor.hotelpet.view.dialogs.Filtros.DlgFilterFuncionario;
import com.clevervitor.hotelpet.view.dialogs.Filtros.DlgFilterPet;
import com.clevervitor.hotelpet.view.dialogs.Filtros.DlgFilterProprietario;
import com.clevervitor.hotelpet.view.dialogs.Infos.DlgInfoAgendamento;
import com.clevervitor.hotelpet.view.dialogs.Infos.DlgInfoFuncionario;
import com.clevervitor.hotelpet.view.dialogs.Infos.DlgInfoProprietario;
import com.clevervitor.hotelpet.view.dialogs.DlgSobre;
import com.clevervitor.hotelpet.view.dialogs.Infos.DlgInfoPet;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Image;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author clevs
 */
public class FrMainMenuFuncioario extends javax.swing.JDialog {

    loginContexto pessoaLogada = loginContexto.getInstance();
    /**
     * Creates new form mainMenu
     */
    private Funcionario funcionarioLogado;
    private FuncionarioController funcionarioCont;
    private AgendamentoController agendamentoCont;
    private PetController petCont;
    private ProprietarioController proprietarioCont;
    utils utils;
    byte[] imgProfile = null;
    ImageIcon imgIcon = null;

    public FrMainMenuFuncioario(Funcionario funcionario) {
        initComponents();

        setBackground(new Color(51, 51, 51));

        this.funcionarioCont = new FuncionarioController();
        this.funcionarioLogado = funcionarioCont.buscarFuncionario(pessoaLogada.getPessoaLogada().getId());
        this.agendamentoCont = new AgendamentoController();
        this.petCont = new PetController();
        this.proprietarioCont = new ProprietarioController();
        utils = new utils();

        Image iconeTitulo = null;
        try {
            iconeTitulo = ImageIO.read(getClass().getResource("/Imagens/pawprint.png"));
        } catch (IOException ex) {
            Logger.getLogger(FrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIconImage(iconeTitulo);

        imgProfile = funcionarioLogado.getAvatar();
        if (imgProfile != null) {
            imgIcon = new ImageIcon(new ImageIcon(imgProfile).getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH));
            if (imgIcon != null) {
                lbl_img.setText(null);
            }
        }
        habilitarCampos();
        if (pessoaLogada.getPessoaLogada().getNivelAcesso() != 0) {
            menuConfig.setVisible(false);
        }
        lbFilter.setIcon(utils.resizeImgTolb("/Imagens/filter_white.png", lbFilter));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInfo = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblBemVindo = new javax.swing.JLabel();
        lbl_img = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbTurnoFunc = new javax.swing.JLabel();
        lbDocFunc = new javax.swing.JLabel();
        lbEndFunc = new javax.swing.JLabel();
        lbContFunc = new javax.swing.JLabel();
        pnlControleGeral = new javax.swing.JPanel();
        pnlComAbas = new javax.swing.JTabbedPane();
        abaFuncionario = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        abaProprietarios = new javax.swing.JPanel();
        scrProprietarios = new javax.swing.JScrollPane();
        tblProprietarios = new javax.swing.JTable();
        abaPets = new javax.swing.JPanel();
        scrPets = new javax.swing.JScrollPane();
        tblPets = new javax.swing.JTable();
        abaAgendamentos = new javax.swing.JScrollPane();
        tblAgendamentos = new javax.swing.JTable();
        lbFilter = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        floatingButton1 = new com.clevervitor.hotelpet.view.UI.FloatingButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuConfig = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();

        setTitle("Menu Principal");
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        pnlInfo.setBackground(new java.awt.Color(51, 51, 51));
        pnlInfo.setForeground(new java.awt.Color(204, 204, 204));
        pnlInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(242, 242, 242));
        lblNome.setAlignmentY(0.0F);
        pnlInfo.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 270, 25));

        lblBemVindo.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        lblBemVindo.setForeground(new java.awt.Color(242, 242, 242));
        lblBemVindo.setText("Seja bem-vindo novamente,");
        pnlInfo.add(lblBemVindo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        lbl_img.setForeground(new java.awt.Color(242, 242, 242));
        lbl_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_img.setText("Carregar Imagem!");
        lbl_img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        pnlInfo.add(lbl_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 111, 118));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new java.awt.GridLayout(4, 2, 1, 3));

        lbTurnoFunc.setFont(new java.awt.Font("Ebrima", 0, 16)); // NOI18N
        lbTurnoFunc.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbTurnoFunc);

        lbDocFunc.setFont(new java.awt.Font("Ebrima", 0, 16)); // NOI18N
        lbDocFunc.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbDocFunc);

        lbEndFunc.setFont(new java.awt.Font("Ebrima", 0, 16)); // NOI18N
        lbEndFunc.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbEndFunc);

        lbContFunc.setFont(new java.awt.Font("Ebrima", 0, 16)); // NOI18N
        lbContFunc.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbContFunc);

        pnlInfo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 240, 90));

        pnlControleGeral.setBackground(new java.awt.Color(51, 51, 51));
        pnlControleGeral.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ebrima", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N
        pnlControleGeral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlComAbas.setBackground(new java.awt.Color(51, 51, 51));
        pnlComAbas.setForeground(new java.awt.Color(204, 204, 204));
        pnlComAbas.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        pnlComAbas.setMinimumSize(new java.awt.Dimension(451, 50));
        pnlComAbas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlComAbasMouseClicked(evt);
            }
        });

        abaFuncionario.setBackground(new java.awt.Color(51, 51, 51));
        abaFuncionario.setBorder(null);
        abaFuncionario.setForeground(new java.awt.Color(51, 51, 51));

        tblFuncionarios.setBackground(new java.awt.Color(160, 160, 160));
        tblFuncionarios.setForeground(new java.awt.Color(255, 255, 255));
        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncionariosMouseClicked(evt);
            }
        });
        abaFuncionario.setViewportView(tblFuncionarios);

        pnlComAbas.addTab("Funcionarios", abaFuncionario);

        abaProprietarios.setBackground(new java.awt.Color(160, 160, 160));
        abaProprietarios.setForeground(new java.awt.Color(255, 255, 255));
        abaProprietarios.setDoubleBuffered(false);

        scrProprietarios.setBackground(new java.awt.Color(160, 160, 160));
        scrProprietarios.setBorder(null);
        scrProprietarios.setForeground(new java.awt.Color(255, 255, 255));

        tblProprietarios.setBackground(new java.awt.Color(160, 160, 160));
        tblProprietarios.setForeground(new java.awt.Color(255, 255, 255));
        tblProprietarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProprietarios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblProprietarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProprietariosMouseClicked(evt);
            }
        });
        scrProprietarios.setViewportView(tblProprietarios);

        javax.swing.GroupLayout abaProprietariosLayout = new javax.swing.GroupLayout(abaProprietarios);
        abaProprietarios.setLayout(abaProprietariosLayout);
        abaProprietariosLayout.setHorizontalGroup(
            abaProprietariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrProprietarios, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        abaProprietariosLayout.setVerticalGroup(
            abaProprietariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaProprietariosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(scrProprietarios, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pnlComAbas.addTab("Proprietarios", abaProprietarios);

        abaPets.setBackground(new java.awt.Color(51, 51, 51));

        scrPets.setBackground(new java.awt.Color(160, 160, 160));
        scrPets.setBorder(null);
        scrPets.setForeground(new java.awt.Color(255, 255, 255));

        tblPets.setBackground(new java.awt.Color(160, 160, 160));
        tblPets.setForeground(new java.awt.Color(255, 255, 255));
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
        tblPets.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblPets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPetsMouseClicked(evt);
            }
        });
        scrPets.setViewportView(tblPets);

        javax.swing.GroupLayout abaPetsLayout = new javax.swing.GroupLayout(abaPets);
        abaPets.setLayout(abaPetsLayout);
        abaPetsLayout.setHorizontalGroup(
            abaPetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrPets, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        abaPetsLayout.setVerticalGroup(
            abaPetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaPetsLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(scrPets, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
        );

        pnlComAbas.addTab("Pets", abaPets);

        abaAgendamentos.setBackground(new java.awt.Color(51, 51, 51));
        abaAgendamentos.setBorder(null);
        abaAgendamentos.setForeground(new java.awt.Color(204, 204, 204));
        abaAgendamentos.setToolTipText("");

        tblAgendamentos.setBackground(new java.awt.Color(160, 160, 160));
        tblAgendamentos.setForeground(new java.awt.Color(255, 255, 255));
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
        tblAgendamentos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblAgendamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAgendamentosMouseClicked(evt);
            }
        });
        abaAgendamentos.setViewportView(tblAgendamentos);

        pnlComAbas.addTab("Agendamentos", abaAgendamentos);

        pnlControleGeral.add(pnlComAbas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 720, 221));

        lbFilter.setText("jLabel1");
        lbFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFilterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbFilterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbFilterMouseExited(evt);
            }
        });
        pnlControleGeral.add(lbFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 30, 30));

        pnlInfo.add(pnlControleGeral, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 740, 270));

        jSeparator2.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        pnlInfo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 680, 10));

        floatingButton1.setBackground(new java.awt.Color(51, 51, 51));
        floatingButton1.setBorder(null);
        floatingButton1.setForeground(new java.awt.Color(51, 51, 51));
        floatingButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/animatedIcons/veterinary (1).png"))); // NOI18N
        floatingButton1.setBorderColor(new java.awt.Color(51, 51, 51));
        floatingButton1.setColor(new java.awt.Color(51, 51, 51));
        floatingButton1.setFocusPainted(false);
        floatingButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                floatingButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                floatingButton1MouseExited(evt);
            }
        });
        pnlInfo.add(floatingButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 120, 110));

        jMenuBar1.setBackground(new java.awt.Color(40, 40, 40));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(204, 204, 204));

        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Menu");

        jMenuItem2.setText("Cadastro Pessoa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Editar perfil");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);
        jMenu3.add(jSeparator1);

        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        menuConfig.setForeground(new java.awt.Color(255, 255, 255));
        menuConfig.setText("Configurações");

        jMenuItem6.setText("Atualizar Valores");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuConfig.add(jMenuItem6);

        jMenuBar1.add(menuConfig);

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
            .addComponent(pnlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void habilitarCampos() {

        lblBemVindo.setForeground(new Color(187, 187, 187));

        lblNome.setText(funcionarioLogado.getNome() + "!");
        lblNome.setForeground(new Color(187, 187, 187));

        lbEndFunc.setText("Endereço: " + funcionarioLogado.getEndereco());
        lbEndFunc.setForeground(new Color(187, 187, 187));

        lbDocFunc.setText("Cpf: " + funcionarioLogado.getCpf());
        lbDocFunc.setForeground(new Color(187, 187, 187));

        lbContFunc.setText("Tel: " + funcionarioLogado.getTel());
        lbContFunc.setForeground(new Color(187, 187, 187));

        lbTurnoFunc.setText("Turno: " + utils.TurnoToString(funcionarioLogado.getTurno()));
        lbTurnoFunc.setForeground(new Color(187, 187, 187));

        lbl_img.setIcon(imgIcon);

        agendamentoCont.atualizarTabelaDeAgendamentos(tblAgendamentos, agendamentoCont.buscarTodosOsAgendamentos());
        proprietarioCont.atualizarTabelaDeProprietarios(tblProprietarios, proprietarioCont.buscarTodosOsProprietarios());
        petCont.atualizarTabelaDePets(tblPets, petCont.buscarTodosOsPets());
        funcionarioCont.atualizarTabelaDeFuncionario(tblFuncionarios, funcionarioCont.buscarTodosOsFuncionarios());

    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FrLogin TLogin = new FrLogin();
        TLogin.setTitle("Login");
        TLogin.setVisible(true);
        this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        DlgCadProprietario cadastroProp = new DlgCadProprietario(new Frame(), true);
        cadastroProp.setTitle("Cadastro");
        cadastroProp.setVisible(true);        // TODO add your handling code here:

        proprietarioCont.atualizarTabelaDeProprietarios(tblProprietarios, proprietarioCont.buscarTodosOsProprietarios());
        funcionarioCont.atualizarTabelaDeFuncionario(tblFuncionarios, funcionarioCont.buscarTodosOsFuncionarios());

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void lbl_imgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imgMouseClicked

        String file = utils.uploadAvatar(funcionarioLogado.getId(), imgProfile, imgIcon);

        if (!file.isEmpty()) {

            lbl_img.setText(null);
            imgIcon = new ImageIcon(new ImageIcon(file).getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH));
            lbl_img.setIcon(imgIcon);
            ShowMessageDialog DialMsg = new ShowMessageDialog("Sucesso", "Avatar atualizado!");
            DialMsg.setVisible(true);
        }
    }//GEN-LAST:event_lbl_imgMouseClicked

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        DlgCadServicos cadastroServicos = new DlgCadServicos(new Frame(), true);
        cadastroServicos.setTitle("Cadastro");
        cadastroServicos.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void menuSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSobreMouseClicked
        // TODO add your handling code here:

        DlgSobre sobre = new DlgSobre(new Frame(), true);
        sobre.setVisible(true);
    }//GEN-LAST:event_menuSobreMouseClicked

    private void tblAgendamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAgendamentosMouseClicked
        // TODO add your handling code here: 
        Agendamento agendamentoSelecionado = (Agendamento) getObjetoSelecionadoNaGridDeAgendamentos();

        if (evt.getClickCount() == 2) {
            DlgInfoAgendamento telaInfoAgendamento = new DlgInfoAgendamento(new Frame(), true, agendamentoSelecionado);
            telaInfoAgendamento.setVisible(true);
        }

        agendamentoCont.atualizarTabelaDeAgendamentos(tblAgendamentos, agendamentoCont.buscarTodosOsAgendamentos());
    }//GEN-LAST:event_tblAgendamentosMouseClicked

    private void tblProprietariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProprietariosMouseClicked
        // TODO add your handling code here:
        Proprietario proprietarioSelecionado = (Proprietario) getObjetoSelecionadoNaGridDeProprietarios();

        if (evt.getClickCount() == 2) {
            DlgInfoProprietario telaInfoProprietario = new DlgInfoProprietario(new Frame(), true, proprietarioSelecionado);
            telaInfoProprietario.setVisible(true);

        }

        proprietarioCont.atualizarTabelaDeProprietarios(tblProprietarios, proprietarioCont.buscarTodosOsProprietarios());
        petCont.atualizarTabelaDePets(tblPets, petCont.buscarTodosOsPets());
        agendamentoCont.atualizarTabelaDeAgendamentos(tblAgendamentos, agendamentoCont.buscarTodosOsAgendamentos());
    }//GEN-LAST:event_tblProprietariosMouseClicked

    private void tblPetsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPetsMouseClicked
        // TODO add your handling code here:

        Pet petSelecionado = (Pet) getObjetoSelecionadoNaGridDePets();

        if (evt.getClickCount() == 2) {
            DlgInfoPet telaInfoPets = new DlgInfoPet(new Frame(), true, petSelecionado);
            telaInfoPets.setVisible(true);

        }

        petCont.atualizarTabelaDePets(tblPets, petCont.buscarTodosOsPets());

    }//GEN-LAST:event_tblPetsMouseClicked

    private void tblFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionariosMouseClicked
        Funcionario funcSelecionado = (Funcionario) getObjetoSelecionadoNaGridDeFuncionarios();

        if (evt.getClickCount() == 2) {
            DlgInfoFuncionario telaInfoFunc = new DlgInfoFuncionario(new Frame(), true, funcSelecionado);
            telaInfoFunc.setVisible(true);

        }

        funcionarioCont.atualizarTabelaDeFuncionario(tblFuncionarios, funcionarioCont.buscarTodosOsFuncionarios());
    }//GEN-LAST:event_tblFuncionariosMouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:

            DlgCadProprietario telaEditarPerfil = new DlgCadProprietario(new Frame(), true, funcionarioLogado);
            telaEditarPerfil.setVisible(true);

            habilitarCampos();

        } catch (ParseException ex) {
            Logger.getLogger(FrMainMenuClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void lbl_imgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imgMouseEntered
        // TODO add your handling code here:
        lbl_img.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lbl_imgMouseEntered

    private void lbl_imgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imgMouseExited
        // TODO add your handling code here:
        lbl_img.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_lbl_imgMouseExited

    private void floatingButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_floatingButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_floatingButton1MouseEntered

    private void floatingButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_floatingButton1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_floatingButton1MouseExited

    private void pnlComAbasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlComAbasMouseClicked

    }//GEN-LAST:event_pnlComAbasMouseClicked

    private void lbFilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFilterMouseClicked
        switch (pnlComAbas.getSelectedIndex()) {
            case 0:
                DlgFilterFuncionario filFunc = new DlgFilterFuncionario(new Frame(), true);
                FiltroFuncionario filterFunc = filFunc.showDialog();
                funcionarioCont.atualizarTabelaDeFuncionario(tblFuncionarios, funcionarioCont.buscarTodosOsFuncionariosFiltrado(filterFunc));
                break;
            case 1:
                DlgFilterProprietario filProp = new DlgFilterProprietario(new Frame(), true);
                FiltroProprietario filterProp = filProp.showDialog();
                proprietarioCont.atualizarTabelaDeProprietarios(tblProprietarios, proprietarioCont.buscarTodosOsProprietariosFiltrados(filterProp));
                break;
            case 2:
                DlgFilterPet filPet = new DlgFilterPet(new Frame(), true);
                FiltroPet filterPet = filPet.showDialog();
                petCont.atualizarTabelaDePets(tblPets, petCont.buscarTodosOsPetsFiltrado(filterPet));
                break;
            case 3:
                DlgFilterAgendamento filAge = new DlgFilterAgendamento(new Frame(), true);
                FiltroAgendamento filterAge = filAge.showDialog();
                agendamentoCont.atualizarTabelaDeAgendamentos(tblAgendamentos, agendamentoCont.buscarTodosOsAgendamentosFiltrados(filterAge));
                break;
            default:
                throw new AssertionError();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_lbFilterMouseClicked

    private void lbFilterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFilterMouseEntered
        lbFilter.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lbFilterMouseEntered

    private void lbFilterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFilterMouseExited
        lbFilter.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lbFilterMouseExited

    private Object getObjetoSelecionadoNaGridDeAgendamentos() {
        int rowCliked = tblAgendamentos.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = tblAgendamentos.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }

    private Object getObjetoSelecionadoNaGridDeProprietarios() {
        int rowCliked = tblProprietarios.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = tblProprietarios.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }

    private Object getObjetoSelecionadoNaGridDeFuncionarios() {
        int rowCliked = tblFuncionarios.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = tblFuncionarios.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }

    private Object getObjetoSelecionadoNaGridDePets() {
        int rowCliked = tblPets.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = tblPets.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane abaAgendamentos;
    private javax.swing.JScrollPane abaFuncionario;
    private javax.swing.JPanel abaPets;
    private javax.swing.JPanel abaProprietarios;
    private com.clevervitor.hotelpet.view.UI.FloatingButton floatingButton1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbContFunc;
    private javax.swing.JLabel lbDocFunc;
    private javax.swing.JLabel lbEndFunc;
    private javax.swing.JLabel lbFilter;
    private javax.swing.JLabel lbTurnoFunc;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JMenu menuConfig;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JTabbedPane pnlComAbas;
    private javax.swing.JPanel pnlControleGeral;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JScrollPane scrPets;
    private javax.swing.JScrollPane scrProprietarios;
    private javax.swing.JTable tblAgendamentos;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTable tblPets;
    private javax.swing.JTable tblProprietarios;
    // End of variables declaration//GEN-END:variables
}
