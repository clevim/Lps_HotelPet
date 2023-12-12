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
import com.clevervitor.hotelpet.utils.utils;
import com.clevervitor.hotelpet.view.UI.ShowMessageDialog;
import com.clevervitor.hotelpet.view.dialogs.DlgCadProprietario;
import com.clevervitor.hotelpet.view.dialogs.DlgCadServicos;
import com.clevervitor.hotelpet.view.dialogs.DlgInfoAgendamento;
import com.clevervitor.hotelpet.view.dialogs.DlgInfoProprietario;
import com.clevervitor.hotelpet.view.dialogs.DlgSobre;
import com.clevervitor.hotelpet.view.dialogs.DlgInfoPet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.io.IOException;
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
        lblTurno = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblDocumeto = new javax.swing.JLabel();
        lblContato1 = new javax.swing.JLabel();
        lbTurnoFunc = new javax.swing.JLabel();
        lbDocFunc = new javax.swing.JLabel();
        lbEndFunc = new javax.swing.JLabel();
        lbContFunc = new javax.swing.JLabel();
        pnlControleGeral = new javax.swing.JPanel();
        pnlComAbas = new javax.swing.JTabbedPane();
        abaAgendamentos = new javax.swing.JScrollPane();
        tblAgendamentos = new javax.swing.JTable();
        abaProprietarios = new javax.swing.JPanel();
        scrProprietarios = new javax.swing.JScrollPane();
        tblProprietarios = new javax.swing.JTable();
        abaPets = new javax.swing.JPanel();
        scrPets = new javax.swing.JScrollPane();
        tblPets = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuConfig = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();

        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        pnlInfo.setBackground(new java.awt.Color(51, 51, 51));
        pnlInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Painel de Funcionário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft PhagsPa", 1, 24), new java.awt.Color(242, 242, 242))); // NOI18N
        pnlInfo.setForeground(new java.awt.Color(51, 153, 255));
        pnlInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(242, 242, 242));
        pnlInfo.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 37, 230, 30));

        lblBemVindo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        lblBemVindo.setForeground(new java.awt.Color(242, 242, 242));
        lblBemVindo.setText("Seja bem-vindo novamente,");
        pnlInfo.add(lblBemVindo, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 37, -1, -1));

        lbl_img.setForeground(new java.awt.Color(242, 242, 242));
        lbl_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_img.setText("Update Avatar");
        lbl_img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_imgMouseClicked(evt);
            }
        });
        pnlInfo.add(lbl_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 37, 111, 118));

        lblTurno.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lblTurno.setForeground(new java.awt.Color(242, 242, 242));
        lblTurno.setText("Turno:");
        pnlInfo.add(lblTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        lblEndereco.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lblEndereco.setForeground(new java.awt.Color(242, 242, 242));
        lblEndereco.setText("Endereço:");
        pnlInfo.add(lblEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        lblDocumeto.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lblDocumeto.setForeground(new java.awt.Color(242, 242, 242));
        lblDocumeto.setText("Doc.:");
        pnlInfo.add(lblDocumeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        lblContato1.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lblContato1.setForeground(new java.awt.Color(242, 242, 242));
        lblContato1.setText("Contato:");
        pnlInfo.add(lblContato1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        lbTurnoFunc.setForeground(new java.awt.Color(255, 255, 255));
        pnlInfo.add(lbTurnoFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 440, 20));

        lbDocFunc.setForeground(new java.awt.Color(255, 255, 255));
        pnlInfo.add(lbDocFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 440, 20));

        lbEndFunc.setForeground(new java.awt.Color(255, 255, 255));
        pnlInfo.add(lbEndFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 440, 20));

        lbContFunc.setForeground(new java.awt.Color(255, 255, 255));
        pnlInfo.add(lbContFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 440, 20));

        pnlControleGeral.setBackground(new java.awt.Color(51, 51, 51));
        pnlControleGeral.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Nuport", 1, 18), new java.awt.Color(242, 242, 242))); // NOI18N
        pnlControleGeral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlComAbas.setBackground(new java.awt.Color(160, 160, 160));
        pnlComAbas.setForeground(new java.awt.Color(255, 255, 255));
        pnlComAbas.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N

        abaAgendamentos.setBackground(new java.awt.Color(160, 160, 160));
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

        abaProprietarios.setBackground(new java.awt.Color(160, 160, 160));
        abaProprietarios.setForeground(new java.awt.Color(255, 255, 255));
        abaProprietarios.setDoubleBuffered(false);

        scrProprietarios.setBackground(new java.awt.Color(160, 160, 160));
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
            .addComponent(scrProprietarios, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
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
            .addComponent(scrPets, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );
        abaPetsLayout.setVerticalGroup(
            abaPetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaPetsLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(scrPets, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
        );

        pnlComAbas.addTab("Pets", abaPets);

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
        jScrollPane1.setViewportView(tblFuncionarios);

        pnlComAbas.addTab("Funcionarios", jScrollPane1);

        pnlControleGeral.add(pnlComAbas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 770, 221));

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu3.setText("Menu");

        jMenuItem2.setText("Cadastro Pessoa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);
        jMenu3.add(jSeparator1);

        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        menuConfig.setText("Configurações");

        jMenuItem6.setText("Atualizar Valores");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuConfig.add(jMenuItem6);

        jMenuBar1.add(menuConfig);

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
            .addComponent(pnlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
            .addComponent(pnlControleGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlControleGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void habilitarCampos() {

        lblBemVindo.setForeground(new Color(187, 187, 187));

        lblNome.setText(funcionarioLogado.getNome()+"!");
        lblNome.setForeground(new Color(187, 187, 187));

        lbEndFunc.setText(funcionarioLogado.getEndereco());
        lbEndFunc.setForeground(new Color(187, 187, 187));

        lbDocFunc.setText(funcionarioLogado.getCpf());
        lbDocFunc.setForeground(new Color(187, 187, 187));

        lbContFunc.setText(funcionarioLogado.getTel());
        lbContFunc.setForeground(new Color(187, 187, 187));
        
        lbTurnoFunc.setText(funcionarioLogado.getTurno());
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
    private javax.swing.JPanel abaPets;
    private javax.swing.JPanel abaProprietarios;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lbContFunc;
    private javax.swing.JLabel lbDocFunc;
    private javax.swing.JLabel lbEndFunc;
    private javax.swing.JLabel lbTurnoFunc;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblContato1;
    private javax.swing.JLabel lblDocumeto;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTurno;
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
