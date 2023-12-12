/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.utils;

import br.com.caelum.stella.validation.CPFValidator;
import com.clevervitor.hotelpet.connection.GEmailSender;
import com.clevervitor.hotelpet.controller.AgendamentoController;
import com.clevervitor.hotelpet.model.dao.PessoaDAO;
import com.clevervitor.hotelpet.model.dao.ServicosDAO;
import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Pessoa;
import com.clevervitor.hotelpet.model.entities.Servicos;
import com.clevervitor.hotelpet.model.enums.Services;
import static com.clevervitor.hotelpet.model.enums.Services.BANHO;
import static com.clevervitor.hotelpet.model.enums.Services.DIARIA;
import static com.clevervitor.hotelpet.model.enums.Services.MASSAGEM;
import static com.clevervitor.hotelpet.model.enums.Services.NULL;
import static com.clevervitor.hotelpet.model.enums.Services.TOSA;
import com.clevervitor.hotelpet.model.enums.Status;
import static com.clevervitor.hotelpet.model.enums.Status.AGENDADO;
import static com.clevervitor.hotelpet.model.enums.Status.ATIVO;
import static com.clevervitor.hotelpet.model.enums.Status.FINALIZADO;
import static com.clevervitor.hotelpet.model.enums.Status.NULL;
import com.clevervitor.hotelpet.view.UI.FloatingButton;
import com.clevervitor.hotelpet.view.UI.ShowMessageDialog;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import sun.misc.BASE64Decoder;

/**
 *
 * @author clevs
 */
public class utils {

    public static String uploadAvatar(int id, byte[] imgProfile, ImageIcon imgIcon) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        try {
            File img = new File(filename);
            FileInputStream fis = new FileInputStream(img);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            imgProfile = bos.toByteArray();

            PessoaDAO p = new PessoaDAO();

            p.updateAvatar(id, imgProfile);

        } catch (Exception e) {
        }
        return filename;
    }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public static boolean isValidCpf(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(cpf);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isValidPassword(String password) {

        // Regex to check valid password.
        String regex = "(?=\\S+$).{5,20}$";

        Pattern p = Pattern.compile(regex);

        if (password == null) {
            return false;
        }

        Matcher m = p.matcher(password);

        return m.matches();
    }

    public static Servicos getServico(List<Servicos> lstServ, Services nomeServico) {
        Servicos serv = new Servicos(Services.NULL, 0.0);

        for (Servicos s : lstServ) {
            switch (s.getNomeServico()) {
                case DIARIA:
                    if (nomeServico == Services.DIARIA) {
                        serv = s;
                    }
                    break;
                case BANHO:
                    if (nomeServico == Services.BANHO) {
                        serv = s;
                    }
                    break;
                case TOSA:
                    if (nomeServico == Services.TOSA) {
                        serv = s;
                    }
                    break;
                case MASSAGEM:
                    if (nomeServico == Services.MASSAGEM) {
                        serv = s;
                    }
                    break;
                default:
                    throw new AssertionError();
            }

        }

        return serv;
    }

    public static Double calcTotalAgendamento(Agendamento agend) throws ParseException {
        Double valTotal = 0.0;
        SimpleDateFormat formatoDMY = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cIn = Calendar.getInstance();
        Calendar cOut = Calendar.getInstance();
        List<Servicos> servs = new ArrayList<Servicos>(agend.getServicosAdicionais());

        String dateCheckIn = agend.getDataCheckIn();
        String dateCheckOut = agend.getDataCheckOut();
        cIn.setTime(formatoDMY.parse(dateCheckIn));
        cOut.setTime(formatoDMY.parse(dateCheckOut));
        int dias = cOut.get(Calendar.DAY_OF_YEAR) - cIn.get(Calendar.DAY_OF_YEAR);

        int qtdBanho = dias < 7 ? 1 : (dias / 7);
        int qtdTosa = dias < 30 ? 1 : (dias / 30);
        int qtdMassagem = dias < 14 ? 1 : (dias / 14);

        Double valDiaria = utils.getServico(servs, Services.DIARIA).getValorServico() * dias;
        Double valBanho = utils.getServico(servs, Services.BANHO).getValorServico() * qtdBanho;
        Double valTosa = utils.getServico(servs, Services.TOSA).getValorServico() * qtdTosa;
        Double valMassagem = utils.getServico(servs, Services.MASSAGEM).getValorServico() * qtdMassagem;
        valTotal = (valDiaria + valBanho + valMassagem + valTosa);

        return valTotal;
    }

    public static Status checkStatus(Date ckIn, Date ckOut) {
        Date d = new Date();

        if (d.before(ckIn)) {
            return Status.AGENDADO;
        }

        if (d.after(ckOut)) {
            return Status.FINALIZADO;
        }

        if (d.after(ckIn) && d.before(ckOut)) {
            return Status.ATIVO;
        }

        return Status.NULL;

    }

    public static String ToStringServiceName(Set<Servicos> lstServ) {
        StringBuilder result = new StringBuilder();
        for (Servicos s : lstServ) {
            result.append(utils.ServicesToString(s.getNomeServico())).append(",");
        }

        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }

    
    public static String StatusToString(Status s) {

        switch (s) {
            case NULL:
                return "";
            case AGENDADO:
                return "Agendado";
            case ATIVO:
                return "Ativo";
            case FINALIZADO:
                return "Finalizado";

            default:
                throw new AssertionError();
        }

    }

    public static String ServicesToString(Services s) {

        switch (s) {
            case NULL:
                return "";
            case DIARIA:
                return "Diaria";
            case BANHO:
                return "Banho";
            case TOSA:
                return "Tosa";
            case MASSAGEM:
                return "Massagem";

            default:
                throw new AssertionError();
        }

    }

    public static void updateStatusAgendamento() throws ParseException {
        Date d = new Date();
        SimpleDateFormat formatoDMY = new SimpleDateFormat("dd/MM/yyyy");
        List<Agendamento> lstAgendamentos = new AgendamentoController().buscarTodosOsAgendamentos();

        for (Agendamento a : lstAgendamentos) {
            Date chkIn = formatoDMY.parse(a.getDataCheckIn());
            Date chkOut = formatoDMY.parse(a.getDataCheckOut());
            a.setStatus(checkStatus(chkIn, chkOut));

        }

    }

    public static void VerificaAniversario() {
        SimpleDateFormat formatoDMY = new SimpleDateFormat("dd/MM/yyyy");
        Date d = new Date();
        GEmailSender sendertest = new GEmailSender();
        String dataAtual = formatoDMY.format(d);

        List<Pessoa> lstPessoas = new PessoaDAO().findAll();

        for (Pessoa p : lstPessoas) {
            if (dataAtual.equals(p.getDataNasc())) {
                sendertest.sendEmail(p.getEmail(), "Feliz Aniversario!!", new emailBodys().emailCat("Feliz Aniversario!! Te desejamos tudo de bom nesse dia especial!!"));

            }

        }

    }
    
    public ImageIcon resizeImgTolb(String imgPath,JLabel lb){   
    return new ImageIcon(new ImageIcon(getClass().getResource(imgPath)).getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_SMOOTH));
      
    }
    
    public ImageIcon resizeImgToFloatingBtn(String imgPath,FloatingButton Flbtn){   
    return new ImageIcon(new ImageIcon(getClass().getResource(imgPath)).getImage().getScaledInstance(Flbtn.getWidth(), Flbtn.getHeight(), Image.SCALE_SMOOTH));
      
    }
}
