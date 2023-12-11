/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.clevervitor.hotelpet.view.dialogs;

import com.clevervitor.hotelpet.controller.AgendamentoController;
import com.clevervitor.hotelpet.controller.ProprietarioController;
import com.clevervitor.hotelpet.controller.ServicosController;
import com.clevervitor.hotelpet.model.dao.ServicosDAO;
import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.model.entities.Servicos;
import com.clevervitor.hotelpet.view.UI.ShowMessageDialog;
import java.awt.Color;
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
    int idAgendamentoEditando;
    private String edtSexo;

    public DlgCadAgendamento(java.awt.Frame parent, boolean modal, Proprietario proprietario) {
        super(parent, modal);
        ToolTipManager.sharedInstance().setInitialDelay(0);
        initComponents();
        AgendamentoController = new AgendamentoController();
        idAgendamentoEditando = -1;
        proprietarioLogado = proprietario;
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
        //  AgendamentoControllet.atualizarTabela(grdAgendamentos);
    }

    public DlgCadAgendamento(java.awt.Frame parent, boolean modal, Agendamento agendamento) throws ParseException {
        super(parent, modal);
        ToolTipManager.sharedInstance().setInitialDelay(0);
        initComponents();
        agendamentoSendoEditado = agendamento;
        AgendamentoController = new AgendamentoController();
        idAgendamentoEditando = agendamento.getId();
        proprietarioLogado = agendamento.getProprietarioResp();
        propCont = new ProprietarioController();
        petSelcionado = new Pet();
        lstSelectServi = new ArrayList<>();

        lstServ = new ArrayList<>(servicoDAO.findAllSet());
        setBackground(new Color(51, 51, 51));

        Image iconeTitulo = null;
        try {
            iconeTitulo = ImageIO.read(getClass().getResource("/Images/pawprint.png"));
        } catch (IOException ex) {
            Logger.getLogger(DlgCadAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIconImage(iconeTitulo);

        this.habilitarCampos(true);
        this.preencherCampos();

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

        //AgendamentoControllet.atualizarTabela(grdAgendamentos);
    }

    public void preencherCampos() throws ParseException{
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        Date dCheckIn = formatter.parse(agendamentoSendoEditado.getDataCheckIn());
        Date dCheckOut = formatter.parse(agendamentoSendoEditado.getDataCheckOut());
        
        dateCheckIn.setDate(dCheckIn);
        dateCheckOut.setDate(dCheckOut);
        
        for(Object obj : agendamentoSendoEditado.getServicosAdicionais()){
            
            String servico = (String) obj;
            
            if("Banho".equals(servico)){
             CBBanho.setSelected(true);
            }else if("Massagem".equals(servico)){
            CBMassagem.setSelected(true);
            }else if("Tosa".equals(servico)){
                CBTosa.setSelected(true);
            }
        }
        
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
                case "Diaria":
                    valD = s.getValorServico().toString();
                    break;
                case "Banho":
                    valB = s.getValorServico().toString();
                    break;
                case "Tosa":
                    valT = s.getValorServico().toString();
                    break;
                case "Massagem":
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
//        dateCheckIn.setDate(null);
//        dateCheckOut.setDate(null);
        CBBanho.setSelected(false);
        CBTosa.setSelected(false);
        CBMassagem.setSelected(false);

    }

    public List<Servicos> verifServicos() {

        if (CBBanho.isSelected()) {
            lstSelectServi.add(servicoDAO.findByName(CBBanho.getText()));
        }

        if (CBTosa.isSelected()) {
            lstSelectServi.add(servicoDAO.findByName(CBTosa.getText()));
        }

        if (CBMassagem.isSelected()) {
            lstSelectServi.add(servicoDAO.findByName(CBMassagem.getText()));
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
        btnSalvarPet = new javax.swing.JButton();
        btnCancelarPet = new javax.swing.JButton();
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
        lblValor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

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

        btnSalvarPet.setText("Salvar");
        btnSalvarPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarPetActionPerformed(evt);
            }
        });

        btnCancelarPet.setText("Cancelar");
        btnCancelarPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPetActionPerformed(evt);
            }
        });

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

        lblValor.setText("jLabel2");

        jLabel2.setText("Valor:");

        javax.swing.GroupLayout panFormularioLayout = new javax.swing.GroupLayout(panFormulario);
        panFormulario.setLayout(panFormularioLayout);
        panFormularioLayout.setHorizontalGroup(
            panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFormularioLayout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(btnSalvarPet)
                .addGap(28, 28, 28)
                .addComponent(btnCancelarPet)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormularioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlDescricaoPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
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
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlServices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblServicos))
                .addGap(121, 121, 121))
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
                .addGap(11, 11, 11)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(pnlDescricaoPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarPet)
                    .addComponent(btnCancelarPet))
                .addGap(15, 15, 15))
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

    private void btnSalvarPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPetActionPerformed
        // TODO add your handling code here:

        petSelcionado = (Pet) getObjetoSelecionadoNaGrid();

        if (petSelcionado == null) {
            ShowMessageDialog DialMsg = new ShowMessageDialog("Atenção", "Primeiro, selecione um pet para ser hospedado");
            DialMsg.setVisible(true);

        }

        String dCheckIn = new SimpleDateFormat("dd/MM/yyyy").format(dateCheckIn.getDate());
        String dCheckOut = new SimpleDateFormat("dd/MM/yyyy").format(dateCheckOut.getDate());
        Set<Servicos> servs = new HashSet<>(verifServicos());

        Agendamento novoAgendamento = new Agendamento(dCheckIn, dCheckOut,servs , proprietarioLogado, lstPetsSelecionados, 0.0);

        AgendamentoController.cadastrarAgendamento(novoAgendamento);

        dispose();
    }//GEN-LAST:event_btnSalvarPetActionPerformed

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

        }  else {
            lstPetsSelecionados = petSelcionado;
        }

        txtPetsSelecionados.setText(lstPetsSelecionados.toString().replace("[", "").replace("]", ""));
        scrPets.setEnabled(false);
        btnAddPet.setEnabled(false);
    }//GEN-LAST:event_btnAddPetActionPerformed

    private void btnCancelarPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPetActionPerformed
        // TODO add your handling code here:
        limparCampos();
        dispose();
    }//GEN-LAST:event_btnCancelarPetActionPerformed

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

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CBBanho;
    private javax.swing.JCheckBox CBMassagem;
    private javax.swing.JCheckBox CBTosa;
    private javax.swing.JButton btnAddPet;
    private javax.swing.JButton btnCancelarPet;
    private javax.swing.JButton btnRemovePet;
    private javax.swing.JButton btnSalvarPet;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dateCheckIn;
    private com.toedter.calendar.JDateChooser dateCheckOut;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCheckIn;
    private javax.swing.JLabel lblCheckOut;
    private javax.swing.JLabel lblServicos;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel panFormulario;
    private javax.swing.JPanel pnlDescricaoPet;
    private javax.swing.JPanel pnlServices;
    private javax.swing.JScrollPane scrPets;
    private javax.swing.JTable tblPets;
    private javax.swing.JTextArea txtPetsSelecionados;
    // End of variables declaration//GEN-END:variables
}
