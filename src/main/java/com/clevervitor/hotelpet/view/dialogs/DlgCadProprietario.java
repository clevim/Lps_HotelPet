/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.clevervitor.hotelpet.view.dialogs;

import com.clevervitor.hotelpet.controller.FuncionarioController;
import com.clevervitor.hotelpet.controller.ProprietarioController;
import com.clevervitor.hotelpet.model.entities.Funcionario;
import com.clevervitor.hotelpet.model.entities.Pessoa;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.utils.utils;
import static com.clevervitor.hotelpet.valid.ValidateUtils.descriptografiaBase64Decode;
import com.clevervitor.hotelpet.view.FrLogin;
import com.clevervitor.hotelpet.view.UI.ShowMessageDialog;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ToolTipManager;
import static javax.swing.text.html.HTML.Attribute.DATA;

/**
 *
 * @author clevs
 */
public class DlgCadProprietario extends javax.swing.JDialog {

    Funcionario funcionarioSendoEditado;

    Proprietario proprietarioSendoEditado;
    ProprietarioController proprietarioCont;
    int proprietarioIsEditando = -1;
    FuncionarioController fucionarioCont;
    int funcionarioIsEditando = -1;
    utils utils;

    public DlgCadProprietario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ToolTipManager.sharedInstance().setInitialDelay(0);
        Image iconeTitulo = null;
        try {
            iconeTitulo = ImageIO.read(getClass().getResource("/Imagens/pawprint.png"));
        } catch (IOException ex) {
            Logger.getLogger(FrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIconImage(iconeTitulo);
        String TName = parent.getTitle();
        boolean ParentWin = false;

        jPanelFunc.setVisible(false);
        jRadioClient.setSelected(true);

        if (!"Login".equals(TName)) {
            JPanelAdmin.setVisible(true);
        } else {
            JPanelAdmin.setVisible(false);
        }
        
        proprietarioCont = new ProprietarioController();
        fucionarioCont = new FuncionarioController();
        utils = new utils();
        edtSenha.setToolTipText("Minimo de 6 caracteres!");

    }

    public DlgCadProprietario(java.awt.Frame parent, boolean modal, Proprietario prop) throws ParseException {
        super(parent, modal);
        initComponents();
        ToolTipManager.sharedInstance().setInitialDelay(0);
        Image iconeTitulo = null;
        try {
            iconeTitulo = ImageIO.read(getClass().getResource("/Imagens/pawprint.png"));
        } catch (IOException ex) {
            Logger.getLogger(FrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIconImage(iconeTitulo);
        String TName = parent.getTitle();
        boolean ParentWin = false;

        jPanelFunc.setVisible(false);
        jRadioClient.setSelected(true);

        if (!"Login".equals(TName)) {
            JPanelAdmin.setVisible(true);
        } else {
            JPanelAdmin.setVisible(false);
        }

        this.proprietarioSendoEditado = prop;
        proprietarioIsEditando = 1;
        proprietarioCont = new ProprietarioController();
        fucionarioCont = new FuncionarioController();
        utils = new utils();
        edtSenha.setToolTipText("Minimo de 6 caracteres!");
        
        
        PreencherCamposProprietario();

    }

    public DlgCadProprietario(java.awt.Frame parent, boolean modal, Funcionario func) throws ParseException {
        super(parent, modal);
        initComponents();
        ToolTipManager.sharedInstance().setInitialDelay(0);
        Image iconeTitulo = null;
        try {
            iconeTitulo = ImageIO.read(getClass().getResource("/Imagens/pawprint.png"));
        } catch (IOException ex) {
            Logger.getLogger(FrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIconImage(iconeTitulo);
        String TName = parent.getTitle();
        boolean ParentWin = false;

        jPanelFunc.setVisible(false);
        jRadioClient.setSelected(true);

        if (!"Login".equals(TName)) {
            JPanelAdmin.setVisible(true);
        } else {
            JPanelAdmin.setVisible(false);
        }

        this.funcionarioSendoEditado = func;
        proprietarioCont = new ProprietarioController();
        fucionarioCont = new FuncionarioController();
        utils = new utils();

        funcionarioIsEditando = 1;
        
        PreencherCamposFuncionario();

    }

    public void PreencherCamposProprietario() throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        Date d = formatter.parse(proprietarioSendoEditado.getDataNasc());

        edtNome.setText(proprietarioSendoEditado.getNome());
        edtCpf.setText(proprietarioSendoEditado.getCpf());
        edtDataNascimento.setDate(d);

        String[] end = proprietarioSendoEditado.getEndereco().split(",");
        edtCidade.setText(end[0]);
        edtEstado.setText(end[1]);

        edtTelefone.setText(proprietarioSendoEditado.getTel());

        if (proprietarioSendoEditado.getSexo().equals("F")) {
            cbxSexo.setSelectedItem("F");
        } else if (proprietarioSendoEditado.getSexo().equals("M")) {
            cbxSexo.setSelectedItem("M");

        } else if (proprietarioSendoEditado.getSexo().equals("Outro")) {
            cbxSexo.setSelectedItem("Outro");

        }

        edtEmail.setText(proprietarioSendoEditado.getEmail());
        String senhaReal = descriptografiaBase64Decode(proprietarioSendoEditado.getSenha());
        edtSenha.setText(senhaReal);

    }

    public void PreencherCamposFuncionario() throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        Date d = formatter.parse(proprietarioSendoEditado.getDataNasc());

        edtNome.setText(proprietarioSendoEditado.getNome());
        edtCpf.setText(proprietarioSendoEditado.getCpf());
        edtCpf.setEnabled(false);
        edtDataNascimento.setDate(d);

        String[] end = proprietarioSendoEditado.getEndereco().split(",");
        edtCidade.setText(end[0]);
        edtEstado.setText(end[1]);

        edtTelefone.setText(proprietarioSendoEditado.getTel());

        if (proprietarioSendoEditado.getSexo().equals("F")) {
            cbxSexo.setSelectedItem("F");
        } else if (proprietarioSendoEditado.getSexo().equals("M")) {
            cbxSexo.setSelectedItem("M");

        } else if (proprietarioSendoEditado.getSexo().equals("Outro")) {
            cbxSexo.setSelectedItem("Outro");

        }

        if (funcionarioSendoEditado.getTurno().equals("Manhã")) {
            cbxTurno.setSelectedItem("Manhã");
        } else if (funcionarioSendoEditado.getTurno().equals("Tarde")) {
            cbxTurno.setSelectedItem("Tarde");
        } else if (funcionarioSendoEditado.getTurno().equals("Noite")) {
            cbxTurno.setSelectedItem("Noite");
        }

        edtSalario.setText(funcionarioSendoEditado.getSalario().toString());
        edtEmail.setText(funcionarioSendoEditado.getEmail());
        
        String senhaReal = descriptografiaBase64Decode(funcionarioSendoEditado.getSenha());
        edtSenha.setText(senhaReal);
        edtSenha.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formCadProprietario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        edtCidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        edtEstado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxSexo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        edtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        edtSenha = new javax.swing.JTextField();
        JPanelAdmin = new javax.swing.JPanel();
        jRadioClient = new javax.swing.JRadioButton();
        jRadioFuncionario = new javax.swing.JRadioButton();
        jPanelFunc = new javax.swing.JPanel();
        edtSalario = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbxTurno = new javax.swing.JComboBox<>();
        edtCpf = new javax.swing.JFormattedTextField();
        edtTelefone = new javax.swing.JFormattedTextField();
        edtDataNascimento = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        formCadProprietario.setBackground(new java.awt.Color(51, 51, 51));
        formCadProprietario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI", 1, 24), new java.awt.Color(242, 242, 242))); // NOI18N
        formCadProprietario.setForeground(new java.awt.Color(242, 242, 242));
        formCadProprietario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Nome:");
        formCadProprietario.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 55, -1, -1));
        formCadProprietario.add(edtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 78, 284, -1));

        jLabel2.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("CPF:");
        formCadProprietario.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 55, -1, -1));

        jLabel3.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Data de Nascimento:");
        formCadProprietario.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 55, 130, -1));

        jLabel4.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Cidade:");
        formCadProprietario.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 107, -1, -1));
        formCadProprietario.add(edtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 130, 128, -1));

        jLabel5.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Estado:");
        formCadProprietario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 107, -1, -1));
        formCadProprietario.add(edtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 130, 138, -1));

        jLabel6.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("Telefone:");
        formCadProprietario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 107, -1, -1));

        jLabel7.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText("Sexo:");
        formCadProprietario.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 107, -1, -1));

        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "M", "Outro" }));
        formCadProprietario.add(cbxSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 242, 242));
        jLabel8.setText("E-Mail");
        formCadProprietario.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));
        formCadProprietario.add(edtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 169, -1));

        jLabel9.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(242, 242, 242));
        jLabel9.setText("Senha");
        formCadProprietario.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        edtSenha.setText("arrumar botao de ver senha");
        edtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtSenhaActionPerformed(evt);
            }
        });
        formCadProprietario.add(edtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 169, -1));

        JPanelAdmin.setBackground(new java.awt.Color(51, 51, 51));
        JPanelAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioClient.setBackground(new java.awt.Color(51, 51, 51));
        jRadioClient.setForeground(new java.awt.Color(242, 242, 242));
        jRadioClient.setText("Cliente");
        jRadioClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioClientActionPerformed(evt);
            }
        });
        JPanelAdmin.add(jRadioClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        jRadioFuncionario.setBackground(new java.awt.Color(51, 51, 51));
        jRadioFuncionario.setForeground(new java.awt.Color(242, 242, 242));
        jRadioFuncionario.setText("Funcioario");
        jRadioFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioFuncionarioActionPerformed(evt);
            }
        });
        JPanelAdmin.add(jRadioFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 27, -1, -1));

        formCadProprietario.add(JPanelAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jPanelFunc.setBackground(new java.awt.Color(51, 51, 51));
        jPanelFunc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelFunc.add(edtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 80, -1));

        jLabel10.setForeground(new java.awt.Color(242, 242, 242));
        jLabel10.setText("Turno:");
        jPanelFunc.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel12.setForeground(new java.awt.Color(242, 242, 242));
        jLabel12.setText("Salario:");
        jPanelFunc.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        cbxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manhã", "Tarde", "Noite" }));
        cbxTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTurnoActionPerformed(evt);
            }
        });
        jPanelFunc.add(cbxTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 90, -1));

        formCadProprietario.add(jPanelFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, -1, 90));

        try {
            edtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formCadProprietario.add(edtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 160, -1));

        try {
            edtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formCadProprietario.add(edtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 160, -1));

        edtDataNascimento.setDateFormatString("dd/MM/yyyy");
        edtDataNascimento.setFont(new java.awt.Font("Fira Sans", 0, 12)); // NOI18N
        edtDataNascimento.setMaxSelectableDate(new java.util.Date(1230778915000L));
        edtDataNascimento.setMinSelectableDate(new java.util.Date(-1483214285000L));
        formCadProprietario.add(edtDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 130, -1));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalvar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(formCadProprietario, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(formCadProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void edtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtSenhaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dataNascimento = formatter.format(edtDataNascimento.getDate());
        
        String endereco = edtCidade.getText() + ", " + edtEstado.getText();
        boolean isValidEmail = utils.isValidEmailAddress(edtEmail.getText());
        boolean isValidCpf = utils.isValidCpf(edtCpf.getText());
        boolean isValidPass = utils.isValidPassword(edtSenha.getText());

        if (isValidCpf && isValidEmail && isValidPass) {

            if (jRadioFuncionario.isSelected()) {
                Double Salario = Double.valueOf(edtSalario.getText());

                Funcionario func = new Funcionario(Salario, cbxTurno.getSelectedItem().toString(), edtNome.getText(), endereco, dataNascimento, cbxSexo.getSelectedItem().toString(), edtTelefone.getText(), edtEmail.getText(), edtCpf.getText(), edtSenha.getText(), 1);
                if (funcionarioIsEditando > 0) {
                    try {
                        
                        func.setId(funcionarioSendoEditado.getId());
                        
                        fucionarioCont.atualizarFuncionario(func);
                        ShowMessageDialog DialMsg = new ShowMessageDialog("Sucesso", "Funcioario Atualizado com sucesso!!");
                        DialMsg.setVisible(true);
                        
                        dispose();
                        
                    } catch (Exception e) {
                        ShowMessageDialog DialMsg = new ShowMessageDialog("Erro", "!!!Falha ao atualizar!!!");
                        DialMsg.setVisible(true);
                    }
                } else {

                    try {
                        fucionarioCont.cadastrarFuncionario(func);
                        ShowMessageDialog DialMsg = new ShowMessageDialog("Sucesso", "Funcioario Cadastrado com sucesso!!");
                        DialMsg.setVisible(true);
                        dispose();
                    } catch (Exception e) {
                        ShowMessageDialog DialMsg = new ShowMessageDialog("Erro", "!!!Falha ao cadastrar!!!");
                        DialMsg.setVisible(true);
                    }
                }

                this.funcionarioIsEditando = -1;

            } else if (jRadioClient.isSelected()) {

                Proprietario prop = new Proprietario(edtNome.getText(), endereco, dataNascimento, cbxSexo.getSelectedItem().toString(), edtTelefone.getText(), edtEmail.getText(), edtCpf.getText(), edtSenha.getText(), 2);

                if (proprietarioIsEditando > 0) {
                    try {
                        
                        prop.setId(proprietarioSendoEditado.getId());
                        proprietarioCont.atualizarProprietario(prop);
                        ShowMessageDialog DialMsg = new ShowMessageDialog("Sucesso", "Proprietario Atualizado com sucesso!!");
                        DialMsg.setVisible(true);
                        dispose();
                    } catch (Exception e) {
                        ShowMessageDialog DialMsg = new ShowMessageDialog("Erro", "!!!Falha ao cadastrar!!!");
                        DialMsg.setVisible(true);
                    }
                } else {
                    try {
                        proprietarioCont.cadastrarProprietario(prop);
                        ShowMessageDialog DialMsg = new ShowMessageDialog("Sucesso", "Proprietario Cadastrado com sucesso!!");
                        DialMsg.setVisible(true);
                        dispose();
                    } catch (Exception e) {
                        ShowMessageDialog DialMsg = new ShowMessageDialog("Erro", "!!!Falha ao cadastrar!!!");
                        DialMsg.setVisible(true);
                    }
                }

                this.proprietarioIsEditando = -1;

            }
        } else if (!isValidEmail) {
            edtEmail.setText(null);
            ShowMessageDialog DialMsg = new ShowMessageDialog("Erro", "Email Invalido");
            DialMsg.setVisible(true);
        } else if (!isValidPass) {
            edtSenha.setText(null);
            ShowMessageDialog DialMsg = new ShowMessageDialog("Erro", "Senha Invalida");
            DialMsg.setVisible(true);
        } else if (!isValidCpf) {
            edtCpf.setText(null);
            ShowMessageDialog DialMsg = new ShowMessageDialog("Erro", "Cpf Invalido");
            DialMsg.setVisible(true);
        }


    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jRadioFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioFuncionarioActionPerformed
        jRadioClient.setSelected(false);
        jPanelFunc.setVisible(true);
    }//GEN-LAST:event_jRadioFuncionarioActionPerformed

    private void jRadioClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioClientActionPerformed
        jRadioFuncionario.setSelected(false);
        jPanelFunc.setVisible(false);
    }//GEN-LAST:event_jRadioClientActionPerformed

    private void cbxTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTurnoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelAdmin;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JComboBox<String> cbxTurno;
    private javax.swing.JTextField edtCidade;
    private javax.swing.JFormattedTextField edtCpf;
    private com.toedter.calendar.JDateChooser edtDataNascimento;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtEstado;
    private javax.swing.JTextField edtNome;
    private javax.swing.JFormattedTextField edtSalario;
    private javax.swing.JTextField edtSenha;
    private javax.swing.JFormattedTextField edtTelefone;
    private javax.swing.JPanel formCadProprietario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelFunc;
    private javax.swing.JRadioButton jRadioClient;
    private javax.swing.JRadioButton jRadioFuncionario;
    // End of variables declaration//GEN-END:variables
}
