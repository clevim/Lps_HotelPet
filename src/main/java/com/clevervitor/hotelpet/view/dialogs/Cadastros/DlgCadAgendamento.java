/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.clevervitor.hotelpet.view.dialogs.Cadastros;

import com.clevervitor.hotelpet.connection.GEmailSender;
import com.clevervitor.hotelpet.connection.loginContexto;
import com.clevervitor.hotelpet.controller.AgendamentoController;
import com.clevervitor.hotelpet.controller.ProprietarioController;
import com.clevervitor.hotelpet.controller.ServicosController;
import com.clevervitor.hotelpet.model.dao.ServicosDAO;
import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.model.entities.Servicos;
import com.clevervitor.hotelpet.model.enums.Services;
import static com.clevervitor.hotelpet.model.enums.Services.BANHO;
import static com.clevervitor.hotelpet.model.enums.Services.DIARIA;
import static com.clevervitor.hotelpet.model.enums.Services.MASSAGEM;
import static com.clevervitor.hotelpet.model.enums.Services.TOSA;
import com.clevervitor.hotelpet.model.enums.Status;
import com.clevervitor.hotelpet.utils.emailBodys;
import com.clevervitor.hotelpet.utils.utils;
import com.clevervitor.hotelpet.view.UI.ShowMessageDialog;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.ToolTipManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author clevs
 */
public class DlgCadAgendamento extends javax.swing.JDialog {

    ProprietarioController propCont;
    Proprietario proprietarioLogado;
    AgendamentoController AgendamentoController;
    Agendamento agendamentoSendoEditado;
    Pet petSelcionado;
    Pet lstPetsSelecionados;
    List<Servicos> lstServ;
    List<Servicos> lstSelectServi;
    ServicosDAO servicoDAO;
    int agendamentoIsEditando;
    GEmailSender sendertest = new GEmailSender();
    emailBodys emBd = new emailBodys();

    loginContexto pessoaLogada = loginContexto.getInstance();

    public DlgCadAgendamento(java.awt.Frame parent, boolean modal, Proprietario proprietario) {
        super(parent, modal);
        ToolTipManager.sharedInstance().setInitialDelay(0);
        initComponents();
        AgendamentoController = new AgendamentoController();
        agendamentoIsEditando = -1;
        proprietarioLogado = proprietario;

        setTitle("Edição de agendamento de " + proprietarioLogado.getNome());

        propCont = new ProprietarioController();
        petSelcionado = new Pet();
        lstPetsSelecionados = new Pet();
        lstSelectServi = new ArrayList<>();
        servicoDAO = new ServicosDAO();
        setBackground(new Color(51, 51, 51));

        lstServ = new ArrayList<>(servicoDAO.findAllSet());

        Image iconeTitulo = null;
        try {
            iconeTitulo = ImageIO.read(getClass().getResource("/Imagens/pawprint.png"));
        } catch (IOException ex) {
            Logger.getLogger(DlgCadAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIconImage(iconeTitulo);

        this.habilitarCampos(true);
        this.limparCampos();

        Calendar c = Calendar.getInstance();

        Date minCheckIN = c.getTime();
        c.add(Calendar.DAY_OF_YEAR, 1);
        Date minCheckout = c.getTime();
        c.add(Calendar.DAY_OF_YEAR, 29);
        Date maxCheckout = c.getTime();

        dateCheckIn.setMinSelectableDate(minCheckIN);
        dateCheckOut.setMinSelectableDate(minCheckout);
        dateCheckOut.setMaxSelectableDate(maxCheckout);

        dateCheckIn.getDateEditor().setDate(minCheckIN);
        dateCheckOut.getDateEditor().setDate(minCheckout);

    }

    public DlgCadAgendamento(java.awt.Frame parent, boolean modal, Agendamento agendamento) throws ParseException {
        super(parent, modal);
        ToolTipManager.sharedInstance().setInitialDelay(0);
        initComponents();
        agendamentoSendoEditado = agendamento;
        AgendamentoController = new AgendamentoController();
        agendamentoIsEditando = 1;
        proprietarioLogado = agendamento.getProprietarioResp();
        propCont = new ProprietarioController();
        petSelcionado = new Pet();
        lstSelectServi = new ArrayList<>();
        servicoDAO = new ServicosDAO();

        lstServ = new ArrayList<>(servicoDAO.findAllSet());
        setBackground(new Color(51, 51, 51));

        Image iconeTitulo = null;
        try {
            iconeTitulo = ImageIO.read(getClass().getResource("/Imagens/pawprint.png"));
        } catch (IOException ex) {
            Logger.getLogger(DlgCadAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIconImage(iconeTitulo);
        Calendar c = Calendar.getInstance();

        Date minCheckIN = c.getTime();
        c.add(Calendar.DAY_OF_YEAR, 1);
        Date minCheckout = c.getTime();
        c.add(Calendar.DAY_OF_YEAR, 29);
        Date maxCheckout = c.getTime();

        dateCheckIn.setMinSelectableDate(minCheckIN);
        dateCheckOut.setMinSelectableDate(minCheckout);
        dateCheckOut.setMaxSelectableDate(maxCheckout);

        dateCheckIn.getDateEditor().setDate(minCheckIN);
        dateCheckOut.getDateEditor().setDate(minCheckout);
        this.habilitarCampos(true);
        this.preencherCampos();

        switch (pessoaLogada.getPessoaLogada().getNivelAcesso()) {
            case 0:
                desabilitaTudo();
                habilitaAgeAdmin();
                break;
            case 1:
                desabilitaTudo();
                habilitaAgeFuncionario();
                break;
            case 2:
                desabilitaTudo();
                habilitaAgeProprietario();
                break;
            default:
                throw new AssertionError();
        }

    }

    public void desabilitaTudo() {

        dateCheckIn.setEnabled(false);
        dateCheckOut.setEnabled(false);
        CBBanho.setEnabled(false);
        CBTosa.setEnabled(false);
        CBMassagem.setEnabled(false);
        btnAddPet.setEnabled(false);
        btnRemovePet.setEnabled(false);
        scrPets.setEnabled(false);

    }

    public void habilitaAgeAdmin() {
        dateCheckIn.setEnabled(true);
        dateCheckOut.setEnabled(true);
        CBBanho.setEnabled(true);
        CBTosa.setEnabled(true);
        CBMassagem.setEnabled(true);
        btnAddPet.setEnabled(true);
        btnRemovePet.setEnabled(true);
        scrPets.setEnabled(true);
    }

    public void habilitaAgeFuncionario() {
        if (agendamentoSendoEditado.getStatus() == Status.FINALIZADO) {
            dateCheckIn.setEnabled(false);
            dateCheckOut.setEnabled(false);
            CBBanho.setEnabled(false);
            CBTosa.setEnabled(false);
            CBMassagem.setEnabled(false);
            btnAddPet.setEnabled(false);
            btnRemovePet.setEnabled(false);
            scrPets.setEnabled(false);
        }
        if (agendamentoSendoEditado.getStatus() == Status.AGENDADO) {
            dateCheckIn.setEnabled(true);
            dateCheckOut.setEnabled(true);
            CBBanho.setEnabled(true);
            CBTosa.setEnabled(true);
            CBMassagem.setEnabled(true);
            btnAddPet.setEnabled(true);
            btnRemovePet.setEnabled(true);
            scrPets.setEnabled(true);
        }
        if (agendamentoSendoEditado.getStatus() == Status.ATIVO) {
            dateCheckIn.setEnabled(false);
            dateCheckOut.setEnabled(true);
            CBBanho.setEnabled(true);
            CBTosa.setEnabled(true);
            CBMassagem.setEnabled(true);
            btnAddPet.setEnabled(false);
            btnRemovePet.setEnabled(false);
            scrPets.setEnabled(false);
        }
    }

    public void habilitaAgeProprietario() {
        if (agendamentoSendoEditado.getStatus() == Status.FINALIZADO) {
            dateCheckIn.setEnabled(false);
            dateCheckOut.setEnabled(false);
            CBBanho.setEnabled(false);
            CBTosa.setEnabled(false);
            CBMassagem.setEnabled(false);
            btnAddPet.setEnabled(false);
            btnRemovePet.setEnabled(false);
            scrPets.setEnabled(false);
        }
        if (agendamentoSendoEditado.getStatus() == Status.AGENDADO) {
            dateCheckIn.setEnabled(true);
            dateCheckOut.setEnabled(true);
            CBBanho.setEnabled(true);
            CBTosa.setEnabled(true);
            CBMassagem.setEnabled(true);
            btnAddPet.setEnabled(true);
            btnRemovePet.setEnabled(true);
            scrPets.setEnabled(true);
        }
        if (agendamentoSendoEditado.getStatus() == Status.ATIVO) {
            dateCheckIn.setEnabled(false);
            dateCheckOut.setEnabled(true);
            CBBanho.setEnabled(true);
            CBTosa.setEnabled(true);
            CBMassagem.setEnabled(true);
            btnAddPet.setEnabled(false);
            btnRemovePet.setEnabled(false);
            scrPets.setEnabled(false);
        }

    }

    public void preencherCampos() throws ParseException {

        Date dCheckIn = new SimpleDateFormat("dd/MM/yyyy").parse(agendamentoSendoEditado.getDataCheckIn());
        Date dCheckOut = new SimpleDateFormat("dd/MM/yyyy").parse(agendamentoSendoEditado.getDataCheckOut());

        dateCheckIn.setDate(dCheckIn);
        dateCheckOut.setDate(dCheckOut);

        for (Servicos s : agendamentoSendoEditado.getServicosAdicionais()) {

            switch (s.getNomeServico()) {
                case DIARIA:
                    break;
                case BANHO:
                    CBBanho.setSelected(true);
                    break;
                case TOSA:
                    CBTosa.setSelected(true);
                    break;
                case MASSAGEM:
                    CBMassagem.setSelected(true);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        petSelcionado = agendamentoSendoEditado.getPetAgendado();
        lstPetsSelecionados = petSelcionado;

        txtPetsSelecionados.setText(agendamentoSendoEditado.getPetAgendado().toString());
        propCont.atualizarTabelaDePetsInicioFrame(tblPets, proprietarioLogado.getLstPetsPossuidos());

    }

    public Date getMinCheckIn() {
        Calendar c = Calendar.getInstance();

        Date minCheckin = c.getTime();

        return minCheckin;
    }

    public Date getMinCheckOut() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, 1);
        Date minCheckout = c.getTime();

        return minCheckout;
    }

    public Date getMaxCheckOut() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, 30);
        Date maxCheckout = c.getTime();

        return maxCheckout;
    }

    public void habilitarCampos(boolean flag) {
        String valD;
        String valB = null;
        String valT = null;
        String valM = null;
        lblCheckIn.setForeground(new Color(187, 187, 187));
        lblCheckOut.setForeground(new Color(187, 187, 187));
        lblServicos.setForeground(new Color(187, 187, 187));

        propCont.atualizarTabelaDePetsInicioFrame(tblPets, proprietarioLogado.getLstPetsPossuidos());

        for (Servicos s : lstServ) {
            switch (s.getNomeServico()) {
                case DIARIA:
                    valD = s.getValorServico().toString();
                    break;
                case BANHO:
                    valB = s.getValorServico().toString();
                    break;
                case TOSA:
                    valT = s.getValorServico().toString();
                    break;
                case MASSAGEM:
                    valM = s.getValorServico().toString();
                    break;
                default:
                    throw new AssertionError();
            }

        }

        pnlServices.setToolTipText("<html>"
                + "<h4>Valores:</h4>"
                + "Banho: R$" + valB + ""
                + "<br>"
                + "Tosa: R$" + valT + ""
                + "<br>"
                + "Massagem: R$" + valM + ""
                + "</html>");

    }

    public void limparCampos() {
        CBBanho.setSelected(false);
        CBTosa.setSelected(false);
        CBMassagem.setSelected(false);

    }

    public List<Servicos> verifServicos() {
        lstSelectServi.add(servicoDAO.findByName(Services.DIARIA));
        if (CBBanho.isSelected()) {
            lstSelectServi.add(servicoDAO.findByName(Services.BANHO));
        }

        if (CBTosa.isSelected()) {
            lstSelectServi.add(servicoDAO.findByName(Services.TOSA));
        }

        if (CBMassagem.isSelected()) {
            lstSelectServi.add(servicoDAO.findByName(Services.MASSAGEM));
        }

        return lstSelectServi;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jCheckBox1 = new javax.swing.JCheckBox();
        panFormulario = new javax.swing.JPanel();
        lblCheckIn = new javax.swing.JLabel();
        lblCheckOut = new javax.swing.JLabel();
        lblServicos = new javax.swing.JLabel();
        pnlDescricaoPet = new javax.swing.JPanel();
        scrPets = new javax.swing.JScrollPane();
        tblPets = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPetsSelecionados = new javax.swing.JTextArea();
        btnAddPet = new javax.swing.JButton();
        btnRemovePet = new javax.swing.JButton();
        dateCheckIn = new com.toedter.calendar.JDateChooser();
        dateCheckOut = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnlServices = new javax.swing.JPanel();
        CBBanho = new javax.swing.JCheckBox();
        CBTosa = new javax.swing.JCheckBox();
        CBMassagem = new javax.swing.JCheckBox();
        btnSalvar = new com.clevervitor.hotelpet.view.UI.FloatingButton();
        btnCancel = new com.clevervitor.hotelpet.view.UI.FloatingButton();

        jCheckBox1.setText("jCheckBox1");

        setTitle("Agendar");
        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(51, 51, 51));

        panFormulario.setBackground(new java.awt.Color(51, 51, 51));

        lblCheckIn.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblCheckIn.setForeground(new java.awt.Color(242, 242, 242));
        lblCheckIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCheckIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/check-in (1).png"))); // NOI18N
        lblCheckIn.setText("Check-in:");
        lblCheckIn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblCheckIn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblCheckOut.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblCheckOut.setForeground(new java.awt.Color(242, 242, 242));
        lblCheckOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/check-out (1).png"))); // NOI18N
        lblCheckOut.setText("Check-out:");
        lblCheckOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblServicos.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        lblServicos.setForeground(new java.awt.Color(242, 242, 242));
        lblServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/dog.png"))); // NOI18N
        lblServicos.setText("Serviços adicionais");
        lblServicos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblServicos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        pnlDescricaoPet.setBackground(new java.awt.Color(51, 51, 51));
        pnlDescricaoPet.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecione o pet", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI", 1, 24), new java.awt.Color(153, 255, 153))); // NOI18N

        scrPets.setBackground(new java.awt.Color(160, 160, 160));
        scrPets.setForeground(new java.awt.Color(255, 255, 255));

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
        scrPets.setViewportView(tblPets);

        txtPetsSelecionados.setColumns(20);
        txtPetsSelecionados.setLineWrap(true);
        txtPetsSelecionados.setRows(5);
        jScrollPane1.setViewportView(txtPetsSelecionados);

        btnAddPet.setBackground(new java.awt.Color(51, 51, 51));
        btnAddPet.setForeground(new java.awt.Color(51, 51, 51));
        btnAddPet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/addition.png"))); // NOI18N
        btnAddPet.setBorder(null);
        btnAddPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPetActionPerformed(evt);
            }
        });

        btnRemovePet.setBackground(new java.awt.Color(51, 51, 51));
        btnRemovePet.setForeground(new java.awt.Color(51, 51, 51));
        btnRemovePet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/remove.png"))); // NOI18N
        btnRemovePet.setBorder(null);
        btnRemovePet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemovePetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDescricaoPetLayout = new javax.swing.GroupLayout(pnlDescricaoPet);
        pnlDescricaoPet.setLayout(pnlDescricaoPetLayout);
        pnlDescricaoPetLayout.setHorizontalGroup(
            pnlDescricaoPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDescricaoPetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrPets, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlDescricaoPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddPet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemovePet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlDescricaoPetLayout.setVerticalGroup(
            pnlDescricaoPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDescricaoPetLayout.createSequentialGroup()
                .addGroup(pnlDescricaoPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrPets, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(pnlDescricaoPetLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnAddPet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemovePet)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dateCheckIn.setBackground(new java.awt.Color(160, 160, 160));
        dateCheckIn.setForeground(new java.awt.Color(255, 255, 255));
        dateCheckIn.setDate(getMinCheckIn());
        dateCheckIn.setDateFormatString("dd/MM/yyyy");
        dateCheckIn.setMaxSelectableDate(new java.util.Date(253370779270000L));
        dateCheckIn.setMinSelectableDate(getMinCheckIn());
        dateCheckIn.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateCheckInPropertyChange(evt);
            }
        });

        dateCheckOut.setDate(getMinCheckOut());
        dateCheckOut.setDateFormatString("dd/MM/yyyy");
        dateCheckOut.setMaxSelectableDate(getMaxCheckOut());
        dateCheckOut.setMinSelectableDate(getMinCheckOut());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Agendar hospedagem");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlServices.setBackground(new java.awt.Color(51, 51, 51));
        pnlServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlServicesMouseEntered(evt);
            }
        });

        CBBanho.setBackground(new java.awt.Color(51, 51, 51));
        CBBanho.setForeground(new java.awt.Color(255, 255, 255));
        CBBanho.setText("Banho");
        CBBanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBBanhoActionPerformed(evt);
            }
        });

        CBTosa.setBackground(new java.awt.Color(51, 51, 51));
        CBTosa.setForeground(new java.awt.Color(255, 255, 255));
        CBTosa.setText("Tosa");
        CBTosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBTosaActionPerformed(evt);
            }
        });

        CBMassagem.setBackground(new java.awt.Color(51, 51, 51));
        CBMassagem.setForeground(new java.awt.Color(255, 255, 255));
        CBMassagem.setText("Massagem");
        CBMassagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBMassagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlServicesLayout = new javax.swing.GroupLayout(pnlServices);
        pnlServices.setLayout(pnlServicesLayout);
        pnlServicesLayout.setHorizontalGroup(
            pnlServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlServicesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CBBanho)
                    .addComponent(CBTosa)
                    .addComponent(CBMassagem)))
        );
        pnlServicesLayout.setVerticalGroup(
            pnlServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlServicesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CBBanho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBTosa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBMassagem)
                .addGap(0, 0, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout panFormularioLayout = new javax.swing.GroupLayout(panFormulario);
        panFormulario.setLayout(panFormularioLayout);
        panFormularioLayout.setHorizontalGroup(
            panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormularioLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCheckOut)
                    .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dateCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCheckIn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlServices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblServicos))
                .addGap(121, 121, 121))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormularioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormularioLayout.createSequentialGroup()
                        .addComponent(pnlDescricaoPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormularioLayout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(248, 248, 248))))
        );
        panFormularioLayout.setVerticalGroup(
            panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCheckIn)
                    .addComponent(lblServicos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addComponent(dateCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCheckOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlServices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(pnlDescricaoPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panFormulario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panFormulario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private Object getObjetoSelecionadoNaGrid() {
        int rowCliked = tblPets.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = tblPets.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }


    private void btnAddPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPetActionPerformed
        // TODO add your handling code here:
        petSelcionado = (Pet) getObjetoSelecionadoNaGrid();
        if (petSelcionado == null) {
            ShowMessageDialog DialMsg = new ShowMessageDialog("Atenção", "Primeiro, selecione um pet da tabela");
            DialMsg.setVisible(true);

        } else {
            lstPetsSelecionados = petSelcionado;
        }

        txtPetsSelecionados.setText(lstPetsSelecionados.toString().replace("[", "").replace("]", ""));
        scrPets.setEnabled(false);
        btnAddPet.setEnabled(false);
    }//GEN-LAST:event_btnAddPetActionPerformed

    private void btnRemovePetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemovePetActionPerformed
        // TODO add your handling code here:
        if (lstPetsSelecionados == null) {
            ShowMessageDialog DialMsg = new ShowMessageDialog("Atenção", "Nenhum pet para remover");
            DialMsg.setVisible(true);

        } else {
            lstPetsSelecionados = null;
        }
        txtPetsSelecionados.setText(lstPetsSelecionados.toString().replace("[", "").replace("]", ""));
        scrPets.setEnabled(true);
        btnAddPet.setEnabled(true);
    }//GEN-LAST:event_btnRemovePetActionPerformed

    private void CBBanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBBanhoActionPerformed


    }//GEN-LAST:event_CBBanhoActionPerformed

    private void CBTosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBTosaActionPerformed

    }//GEN-LAST:event_CBTosaActionPerformed

    private void CBMassagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBMassagemActionPerformed

    }//GEN-LAST:event_CBMassagemActionPerformed

    private void pnlServicesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlServicesMouseEntered

    }//GEN-LAST:event_pnlServicesMouseEntered

    private void dateCheckInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateCheckInMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dateCheckInMouseClicked

    private void dateCheckInInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dateCheckInInputMethodTextChanged
        Calendar c = Calendar.getInstance();

        c.setTime(dateCheckIn.getDate());
        c.add(Calendar.DAY_OF_YEAR, 1);
        Date minCheckout = c.getTime();
        c.add(Calendar.DAY_OF_YEAR, 29);
        Date maxCheckout = c.getTime();

        dateCheckOut.setMinSelectableDate(minCheckout);
        dateCheckOut.setMaxSelectableDate(maxCheckout);

        dateCheckOut.getDateEditor().setDate(minCheckout);
    }//GEN-LAST:event_dateCheckInInputMethodTextChanged

    private void dateCheckInPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateCheckInPropertyChange
        Calendar c = Calendar.getInstance();

        c.setTime(dateCheckIn.getDate());
        c.add(Calendar.DAY_OF_YEAR, 1);
        Date minCheckout = c.getTime();
        c.add(Calendar.DAY_OF_YEAR, 29);
        Date maxCheckout = c.getTime();

        dateCheckOut.setMinSelectableDate(minCheckout);
        dateCheckOut.setMaxSelectableDate(maxCheckout);

        dateCheckOut.getDateEditor().setDate(minCheckout);        // TODO add your handling code here:
    }//GEN-LAST:event_dateCheckInPropertyChange

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

        String dCheckIn = new SimpleDateFormat("dd/MM/yyyy").format(dateCheckIn.getDate());
        String dCheckOut = new SimpleDateFormat("dd/MM/yyyy").format(dateCheckOut.getDate());
        Status status = utils.checkStatus(dateCheckIn.getDate(), dateCheckOut.getDate());

        Set<Servicos> servs = new HashSet<>(verifServicos());

        if (agendamentoIsEditando > 0) {

            Agendamento agendamentoEdit = new Agendamento(dCheckIn, dCheckOut, servs, proprietarioLogado, lstPetsSelecionados, 0.0, status);
            try {
                agendamentoEdit.setValor(utils.calcTotalAgendamento(agendamentoEdit));
            } catch (ParseException ex) {
                Logger.getLogger(DlgCadAgendamento.class.getName()).log(Level.SEVERE, null, ex);
            }
            agendamentoEdit.setId(agendamentoSendoEditado.getId());

            AgendamentoController.atualizarAgendamento(agendamentoEdit);
            ShowMessageDialog DialMsg = new ShowMessageDialog("Sucesso", "Agendamento Atualizado!!");
            DialMsg.setVisible(true);
            try {
                sendertest.sendEmail(agendamentoEdit.getProprietarioResp().getEmail(), "Comprovante de mudanças no agendamento!", emBd.emailComprovante(agendamentoEdit));
            } catch (ParseException ex) {
                Logger.getLogger(DlgCadAgendamento.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            petSelcionado = (Pet) getObjetoSelecionadoNaGrid();

            if (petSelcionado == null) {
                ShowMessageDialog DialMsg = new ShowMessageDialog("Atenção", "Primeiro, selecione um pet para ser hospedado");
                DialMsg.setVisible(true);

            }

            Agendamento novoAgendamento = new Agendamento(dCheckIn, dCheckOut, servs, proprietarioLogado, lstPetsSelecionados, 0.0, status);
            try {
                novoAgendamento.setValor(utils.calcTotalAgendamento(novoAgendamento));
            } catch (ParseException ex) {
                Logger.getLogger(DlgCadAgendamento.class.getName()).log(Level.SEVERE, null, ex);
            }

            AgendamentoController.cadastrarAgendamento(novoAgendamento);
            ShowMessageDialog DialMsg = new ShowMessageDialog("Sucesso", "Agendamento Feito");
            DialMsg.setVisible(true);

            try {
                sendertest.sendEmail(novoAgendamento.getProprietarioResp().getEmail(), "Comprovante de agendamento!", emBd.emailComprovante(novoAgendamento));
            } catch (ParseException ex) {
                Logger.getLogger(DlgCadAgendamento.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        agendamentoIsEditando = -1;
        dispose();

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        limparCampos();
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CBBanho;
    private javax.swing.JCheckBox CBMassagem;
    private javax.swing.JCheckBox CBTosa;
    private javax.swing.JButton btnAddPet;
    private com.clevervitor.hotelpet.view.UI.FloatingButton btnCancel;
    private javax.swing.JButton btnRemovePet;
    private com.clevervitor.hotelpet.view.UI.FloatingButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dateCheckIn;
    private com.toedter.calendar.JDateChooser dateCheckOut;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCheckIn;
    private javax.swing.JLabel lblCheckOut;
    private javax.swing.JLabel lblServicos;
    private javax.swing.JPanel panFormulario;
    private javax.swing.JPanel pnlDescricaoPet;
    private javax.swing.JPanel pnlServices;
    private javax.swing.JScrollPane scrPets;
    private javax.swing.JTable tblPets;
    private javax.swing.JTextArea txtPetsSelecionados;
    // End of variables declaration//GEN-END:variables
}
