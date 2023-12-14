/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.clevervitor.hotelpet.view.dialogs.Cadastros;

import com.clevervitor.hotelpet.connection.GEmailSender;
import com.clevervitor.hotelpet.connection.loginContexto;
import com.clevervitor.hotelpet.controller.FuncionarioController;
import com.clevervitor.hotelpet.controller.ProprietarioController;
import com.clevervitor.hotelpet.model.entities.Funcionario;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.model.enums.Sexo;
import com.clevervitor.hotelpet.model.enums.Turno;
import com.clevervitor.hotelpet.utils.emailBodys;
import com.clevervitor.hotelpet.utils.utils;
import com.clevervitor.hotelpet.valid.ValidatePessoa;
import static com.clevervitor.hotelpet.valid.ValidateUtils.descriptografiaBase64Decode;
import com.clevervitor.hotelpet.view.FrLogin;
import com.clevervitor.hotelpet.view.UI.ShowMessageDialog;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.ToolTipManager;

/**
 *
 * @author clevs
 */
public class DlgCadProprietario extends javax.swing.JDialog {

    Funcionario funcionarioSendoEditado;
    loginContexto pessoaLogada = loginContexto.getInstance();
    Proprietario proprietarioSendoEditado;
    ProprietarioController proprietarioCont;
    int proprietarioIsEditando = -1;
    FuncionarioController fucionarioCont;
    int funcionarioIsEditando = -1;
    utils utils;
    int Show_Hide = 0;
    GEmailSender sendertest = new GEmailSender();
    emailBodys emBd = new emailBodys();

    public DlgCadProprietario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setBackground(new Color(51, 51, 51));

        setTitle("Cadastro de Proprietário");

        initializeComboBox();
        edtSenha.setEchoChar('\u25cf');
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

        if (pessoaLogada.getPessoaLogada() != null && pessoaLogada.getPessoaLogada().getNivelAcesso().equals(0)) {
            JPanelAdmin.setVisible(true);
        } else {
            JPanelAdmin.setVisible(false);
        }

        proprietarioCont = new ProprietarioController();
        fucionarioCont = new FuncionarioController();
        utils = new utils();
        edtSenha.setToolTipText("Minimo de 6 caracteres!");
        img_eye.setText(null);
        img_eye.setIcon(utils.resizeImgTolb("/Imagens/hide_white.png", img_eye));

    }

    public DlgCadProprietario(java.awt.Frame parent, boolean modal, Proprietario prop) throws ParseException {
        super(parent, modal);
        initComponents();
        setBackground(new Color(51, 51, 51));

        initializeComboBox();
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
        jRadioFuncionario.setSelected(false);

        JPanelAdmin.setVisible(false);

        this.proprietarioSendoEditado = prop;

        setTitle("Edição de cadastro de " + prop.getNome());

        proprietarioIsEditando = 1;
        proprietarioCont = new ProprietarioController();
        fucionarioCont = new FuncionarioController();
        utils = new utils();
        edtSenha.setToolTipText("Minimo de 6 caracteres!");
        img_eye.setText(null);
        img_eye.setIcon(utils.resizeImgTolb("/Imagens/hide_white.png", img_eye));
        PreencherCamposProprietario();

        switch (pessoaLogada.getPessoaLogada().getNivelAcesso()) {
            case 0:
                desabilitaTudo();
                habilitaPropAdmin();
                break;
            case 1:
                desabilitaTudo();
                habilitaPropFuncionario();
                break;
            case 2:
                desabilitaTudo();
                habilitaPropProprietario();
                break;
            default:
                throw new AssertionError();
        }

    }

    public DlgCadProprietario(java.awt.Frame parent, boolean modal, Funcionario func) throws ParseException {
        super(parent, modal);
        initComponents();
        setBackground(new Color(51, 51, 51));

        initializeComboBox();
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

        jPanelFunc.setVisible(true);
        jRadioFuncionario.setSelected(true);
        jRadioClient.setSelected(false);
        JPanelAdmin.setVisible(false);

        this.funcionarioSendoEditado = func;

        setTitle("Edição de cadastro de " + func.getNome());

        proprietarioCont = new ProprietarioController();
        fucionarioCont = new FuncionarioController();
        utils = new utils();

        funcionarioIsEditando = 1;
        edtSenha.setToolTipText("Minimo de 6 caracteres!");
        img_eye.setText(null);
        img_eye.setIcon(utils.resizeImgTolb("/Imagens/hide_white.png", img_eye));
        PreencherCamposFuncionario();

        switch (pessoaLogada.getPessoaLogada().getNivelAcesso()) {
            case 0:
                desabilitaTudo();
                habilitaFuncAdmin();
                break;
            case 1:
                desabilitaTudo();
                habilitaFuncFuncionario();
                break;
            case 2:
                desabilitaTudo();
                break;
            default:
                throw new AssertionError();
        }

    }

    public void initializeComboBox() {
        cbxTurno.addItem(utils.TurnoToString(Turno.MANHA));
        cbxTurno.addItem(utils.TurnoToString(Turno.TARDE));
        cbxTurno.addItem(utils.TurnoToString(Turno.NOITE));
        cbxSexo.addItem(utils.SexoToString(Sexo.F));
        cbxSexo.addItem(utils.SexoToString(Sexo.M));
        cbxSexo.addItem(utils.SexoToString(Sexo.NAOIDENT));

    }

    public void desabilitaTudo() {
        edtCidade.setEnabled(false);
        edtCpf.setEnabled(false);
        edtDataNascimento.setEnabled(false);
        edtEmail.setEnabled(false);
        edtEstado.setEnabled(false);
        edtNome.setEnabled(false);
        edtSalario.setEnabled(false);
        edtSenha.setEnabled(false);
        edtTelefone.setEnabled(false);
        cbxSexo.setEnabled(false);
        cbxTurno.setEnabled(false);

    }

    public void habilitaPropAdmin() {
        edtCidade.setEnabled(true);
        edtCpf.setEnabled(true);
        edtDataNascimento.setEnabled(true);
        edtEmail.setEnabled(true);
        edtEstado.setEnabled(true);
        edtNome.setEnabled(true);
        edtSalario.setEnabled(true);
        edtSenha.setEnabled(true);
        edtTelefone.setEnabled(true);
        cbxSexo.setEnabled(true);
        cbxTurno.setEnabled(true);
    }

    public void habilitaPropFuncionario() {
        edtCidade.setEnabled(true);
        edtCpf.setEnabled(false);
        edtDataNascimento.setEnabled(false);
        edtEmail.setEnabled(false);
        edtEstado.setEnabled(true);
        edtNome.setEnabled(true);
        edtSalario.setEnabled(false);
        edtSenha.setEnabled(false);
        edtTelefone.setEnabled(true);
        cbxSexo.setEnabled(false);
        cbxTurno.setEnabled(true);
    }

    public void habilitaPropProprietario() {
        edtCidade.setEnabled(true);
        edtCpf.setEnabled(false);
        edtDataNascimento.setEnabled(true);
        edtEmail.setEnabled(true);
        edtEstado.setEnabled(true);
        edtNome.setEnabled(true);
        edtSalario.setEnabled(false);
        edtSenha.setEnabled(true);
        edtTelefone.setEnabled(true);
        cbxSexo.setEnabled(true);
        cbxTurno.setEnabled(true);
    }

    public void habilitaFuncAdmin() {
        edtCidade.setEnabled(true);
        edtCpf.setEnabled(true);
        edtDataNascimento.setEnabled(true);
        edtEmail.setEnabled(true);
        edtEstado.setEnabled(true);
        edtNome.setEnabled(true);
        edtSalario.setEnabled(true);
        edtSenha.setEnabled(true);
        edtTelefone.setEnabled(true);
        cbxSexo.setEnabled(true);
        cbxTurno.setEnabled(true);
    }

    public void habilitaFuncFuncionario() {
        edtCidade.setEnabled(true);
        edtCpf.setEnabled(false);
        edtDataNascimento.setEnabled(true);
        edtEmail.setEnabled(true);
        edtEstado.setEnabled(true);
        edtNome.setEnabled(true);
        edtSalario.setEnabled(false);
        edtSenha.setEnabled(true);
        edtTelefone.setEnabled(true);
        cbxSexo.setEnabled(true);
        cbxTurno.setEnabled(true);
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

        cbxSexo.setSelectedItem(utils.SexoToString(proprietarioSendoEditado.getSexo()));
        edtEmail.setText(proprietarioSendoEditado.getEmail());
        String senhaReal = descriptografiaBase64Decode(proprietarioSendoEditado.getSenha());
        edtSenha.setText(senhaReal);

    }

    public void PreencherCamposFuncionario() throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        Date d = formatter.parse(funcionarioSendoEditado.getDataNasc());

        edtNome.setText(funcionarioSendoEditado.getNome());
        edtCpf.setText(funcionarioSendoEditado.getCpf());
        edtCpf.setEnabled(false);
        edtDataNascimento.setDate(d);

        String[] end = funcionarioSendoEditado.getEndereco().split(",");
        edtCidade.setText(end[0]);
        edtEstado.setText(end[1]);

        edtTelefone.setText(funcionarioSendoEditado.getTel());

        cbxSexo.setSelectedItem(utils.SexoToString(funcionarioSendoEditado.getSexo()));

        cbxTurno.setSelectedItem(utils.TurnoToString(funcionarioSendoEditado.getTurno()));

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
        JPanelAdmin = new javax.swing.JPanel();
        jPanelFunc = new javax.swing.JPanel();
        edtSalario = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbxTurno = new javax.swing.JComboBox<>();
        edtCpf = new javax.swing.JFormattedTextField();
        edtTelefone = new javax.swing.JFormattedTextField();
        edtDataNascimento = new com.toedter.calendar.JDateChooser();
        img_eye = new javax.swing.JLabel();
        edtSenha = new javax.swing.JPasswordField();
        btnCancel = new com.clevervitor.hotelpet.view.UI.FloatingButton();
        btnSalvar = new com.clevervitor.hotelpet.view.UI.FloatingButton();
        jRadioClient = new javax.swing.JRadioButton();
        jRadioFuncionario = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Pessoa");
        setBackground(new java.awt.Color(51, 51, 51));

        formCadProprietario.setBackground(new java.awt.Color(51, 51, 51));
        formCadProprietario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI", 1, 24), new java.awt.Color(242, 242, 242))); // NOI18N
        formCadProprietario.setForeground(new java.awt.Color(242, 242, 242));
        formCadProprietario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Nome:");
        formCadProprietario.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        formCadProprietario.add(edtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 78, 284, -1));

        jLabel2.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("CPF:");
        formCadProprietario.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Data de Nascimento:");
        formCadProprietario.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 150, -1));

        jLabel4.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Cidade:");
        formCadProprietario.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        formCadProprietario.add(edtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 130, 128, -1));

        jLabel5.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Estado:");
        formCadProprietario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));
        formCadProprietario.add(edtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 130, 138, -1));

        jLabel6.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("Telefone:");
        formCadProprietario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText("Sexo:");
        formCadProprietario.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

        formCadProprietario.add(cbxSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 70, -1));

        jLabel8.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 242, 242));
        jLabel8.setText("E-Mail");
        formCadProprietario.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));
        formCadProprietario.add(edtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 169, -1));

        jLabel9.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(242, 242, 242));
        jLabel9.setText("Senha");
        formCadProprietario.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        JPanelAdmin.setBackground(new java.awt.Color(51, 51, 51));
        JPanelAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        formCadProprietario.add(JPanelAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jPanelFunc.setBackground(new java.awt.Color(51, 51, 51));
        jPanelFunc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edtSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jPanelFunc.add(edtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 90, -1));

        jLabel10.setForeground(new java.awt.Color(242, 242, 242));
        jLabel10.setText("Turno:");
        jPanelFunc.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel12.setForeground(new java.awt.Color(242, 242, 242));
        jLabel12.setText("Salario:");
        jPanelFunc.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

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
            edtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtTelefoneActionPerformed(evt);
            }
        });
        formCadProprietario.add(edtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 160, -1));

        edtDataNascimento.setDateFormatString("dd/MM/yyyy");
        edtDataNascimento.setFont(new java.awt.Font("Fira Sans", 0, 12)); // NOI18N
        edtDataNascimento.setMaxSelectableDate(new java.util.Date(1230778915000L));
        edtDataNascimento.setMinSelectableDate(new java.util.Date(-1483214285000L));
        formCadProprietario.add(edtDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 130, -1));

        img_eye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img_eyeMouseClicked(evt);
            }
        });
        formCadProprietario.add(img_eye, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 20, 20));
        formCadProprietario.add(edtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 170, -1));

        btnCancel.setBorder(null);
        btnCancel.setForeground(new java.awt.Color(51, 51, 51));
        btnCancel.setText("Cancelar");
        btnCancel.setColor(new java.awt.Color(153, 153, 153));
        btnCancel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnCancel.setRaio(30);
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelMouseExited(evt);
            }
        });
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        formCadProprietario.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 83, 28));

        btnSalvar.setBorder(null);
        btnSalvar.setForeground(new java.awt.Color(51, 51, 51));
        btnSalvar.setText("Salvar");
        btnSalvar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnSalvar.setRaio(30);
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalvarMouseExited(evt);
            }
        });
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        formCadProprietario.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 82, 28));

        jRadioClient.setBackground(new java.awt.Color(51, 51, 51));
        jRadioClient.setForeground(new java.awt.Color(242, 242, 242));
        jRadioClient.setText("Cliente");
        jRadioClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioClientActionPerformed(evt);
            }
        });
        formCadProprietario.add(jRadioClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jRadioFuncionario.setBackground(new java.awt.Color(51, 51, 51));
        jRadioFuncionario.setForeground(new java.awt.Color(242, 242, 242));
        jRadioFuncionario.setText("Funcioario");
        jRadioFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioFuncionarioActionPerformed(evt);
            }
        });
        formCadProprietario.add(jRadioFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(formCadProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formCadProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void img_eyeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_eyeMouseClicked
        if (Show_Hide == 0) {
            edtSenha.setEchoChar((char) 0);
            img_eye.setIcon(utils.resizeImgTolb("/Imagens/show_white.png", img_eye));
            Show_Hide = 1;
        } else if (Show_Hide == 1) {
            edtSenha.setEchoChar('\u25cf');
            img_eye.setIcon(utils.resizeImgTolb("/Imagens/hide_white.png", img_eye));
            Show_Hide = 0;
        }

    }//GEN-LAST:event_img_eyeMouseClicked

    private void btnSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseEntered
        // TODO add your handling code here:
        btnSalvar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSalvar.setBorderColor(new Color(51, 204, 204));
        btnSalvar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnSalvarMouseEntered

    private void btnSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseExited
        // TODO add your handling code here:
        btnSalvar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        btnSalvar.setBorderColor(new Color(255, 255, 255));
        btnSalvar.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_btnSalvarMouseExited

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dataNascimento = formatter.format(edtDataNascimento.getDate());
        boolean ExistCpf = false;
        boolean ExistEmail = false;

        String endereco = edtCidade.getText() + ", " + edtEstado.getText();
        boolean isValidEmail = utils.isValidEmailAddress(edtEmail.getText());
        boolean isValidCpf = utils.isValidCpf(edtCpf.getText());
        boolean isValidPass = utils.isValidPassword(edtSenha.getText());

        ExistEmail = new ValidatePessoa().ValidaFormPessoaEmail(edtEmail.getText(), -1);
        ExistCpf = new ValidatePessoa().ValidaFormPessoaCpf(edtCpf.getText(), -1);

        if (funcionarioIsEditando > 0) {
            ExistEmail = new ValidatePessoa().ValidaFormPessoaEmail(edtEmail.getText(), funcionarioSendoEditado.getId());
            ExistCpf = new ValidatePessoa().ValidaFormPessoaCpf(edtCpf.getText(), funcionarioSendoEditado.getId());
        }
        if (proprietarioIsEditando > 0) {
            ExistEmail = new ValidatePessoa().ValidaFormPessoaEmail(edtEmail.getText(), proprietarioSendoEditado.getId());
            ExistCpf = new ValidatePessoa().ValidaFormPessoaCpf(edtCpf.getText(), proprietarioSendoEditado.getId());
        }

        if (isValidCpf && isValidEmail && isValidPass && !ExistCpf && !ExistEmail) {

            if (jRadioFuncionario.isSelected()) {
                Double Salario = Double.valueOf(edtSalario.getText().replace(",", "."));

                Funcionario func = new Funcionario(Salario, utils.StringToTurno(cbxTurno.getSelectedItem().toString()), edtNome.getText(), endereco, dataNascimento, utils.StringToSexo(cbxSexo.getSelectedItem().toString()), edtTelefone.getText(), edtEmail.getText(), edtCpf.getText(), edtSenha.getText(), 1);

                if (funcionarioIsEditando > 0) {
                    try {

                        func.setId(funcionarioSendoEditado.getId());

                        fucionarioCont.atualizarFuncionario(func);
                        ShowMessageDialog DialMsg = new ShowMessageDialog("Sucesso", "Funcioario Atualizado com sucesso!!");
                        DialMsg.setVisible(true);
                        try {
                            sendertest.sendEmail(func.getEmail(), "Sua Conta teve mudanças!", emBd.emailCat("Seu perfil foi atualizado!"));
                        } catch (Exception ex) {
                            System.err.println(ex);;
                        }

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
                        try {
                            sendertest.sendEmail(func.getEmail(), "Bem Vindo a familia!", emBd.emailDog2("Seja Bem vindo" + func.getNome() + "!"));
                        } catch (Exception ex) {
                            System.err.println(ex);;
                        }
                        dispose();
                    } catch (Exception e) {
                        ShowMessageDialog DialMsg = new ShowMessageDialog("Erro", "!!!Falha ao cadastrar!!!");
                        DialMsg.setVisible(true);
                    }
                }

                this.funcionarioIsEditando = -1;

            } else if (jRadioClient.isSelected()) {

                Proprietario prop = new Proprietario(edtNome.getText(), endereco, dataNascimento, utils.StringToSexo(cbxSexo.getSelectedItem().toString()), edtTelefone.getText(), edtEmail.getText(), edtCpf.getText(), edtSenha.getText(), 2);

                if (proprietarioIsEditando > 0) {
                    try {

                        prop.setId(proprietarioSendoEditado.getId());
                        proprietarioCont.atualizarProprietario(prop);
                        ShowMessageDialog DialMsg = new ShowMessageDialog("Sucesso", "Proprietario Atualizado com sucesso!!");
                        DialMsg.setVisible(true);
                        try {
                            sendertest.sendEmail(prop.getEmail(), "Sua Conta teve mudanças!", emBd.emailCat("Seu perfil foi atualizado!"));
                        } catch (Exception ex) {
                            System.err.println(ex);;
                        }
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
                        try {
                            sendertest.sendEmail(prop.getEmail(), "Bem Vindo a familia!", emBd.emailDog1("Seja Bem vindo" + prop.getNome() + "!"));
                        } catch (Exception ex) {
                            System.err.println(ex);;
                        }
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
            ShowMessageDialog DialMsg = new ShowMessageDialog("Erro", "Email Invalido!");
            DialMsg.setVisible(true);
        } else if (!isValidPass) {
            edtSenha.setText(null);
            ShowMessageDialog DialMsg = new ShowMessageDialog("Erro", "Senha Invalida!");
            DialMsg.setVisible(true);
        } else if (!isValidCpf) {
            edtCpf.setText(null);
            ShowMessageDialog DialMsg = new ShowMessageDialog("Erro", "Cpf Invalido!");
            DialMsg.setVisible(true);
        } else if (ExistCpf || ExistEmail) {
            if (ExistCpf) {
                edtCpf.setText(null);
                ShowMessageDialog DialMsg = new ShowMessageDialog("Erro", "Cpf já cadastrado!");
                DialMsg.setVisible(true);
            } else if (ExistEmail) {
                edtEmail.setText(null);
                ShowMessageDialog DialMsg = new ShowMessageDialog("Erro", "Email já cadastrado !");
                DialMsg.setVisible(true);
            }
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseEntered
        // TODO add your handling code here:
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancel.setBorderColor(new Color(51, 204, 204));
        btnCancel.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnCancelMouseEntered

    private void btnCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseExited
        // TODO add your handling code here:
        btnCancel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        btnCancel.setBorderColor(new Color(255, 255, 255));
        btnCancel.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_btnCancelMouseExited

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void edtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtTelefoneActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelAdmin;
    private com.clevervitor.hotelpet.view.UI.FloatingButton btnCancel;
    private com.clevervitor.hotelpet.view.UI.FloatingButton btnSalvar;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JComboBox<String> cbxTurno;
    private javax.swing.JTextField edtCidade;
    private javax.swing.JFormattedTextField edtCpf;
    private com.toedter.calendar.JDateChooser edtDataNascimento;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtEstado;
    private javax.swing.JTextField edtNome;
    private javax.swing.JFormattedTextField edtSalario;
    private javax.swing.JPasswordField edtSenha;
    private javax.swing.JFormattedTextField edtTelefone;
    private javax.swing.JPanel formCadProprietario;
    private javax.swing.JLabel img_eye;
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
    private javax.swing.JPanel jPanelFunc;
    private javax.swing.JRadioButton jRadioClient;
    private javax.swing.JRadioButton jRadioFuncionario;
    // End of variables declaration//GEN-END:variables
}
