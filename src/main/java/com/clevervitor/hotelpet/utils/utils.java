/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.utils;

import br.com.caelum.stella.validation.CPFValidator;
import com.clevervitor.hotelpet.model.dao.PessoaDAO;
import com.clevervitor.hotelpet.model.dao.ServicosDAO;
import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Pessoa;
import com.clevervitor.hotelpet.model.entities.Servicos;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
//import sun.misc.BASE64Decoder;

/**
 *
 * @author clevs
 */
public class utils {

    public String uploadAvatar(int id, byte[] imgProfile, ImageIcon imgIcon) {
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

    public static Servicos getServico(List<Servicos> lstServ, String nomeServico) {
        Servicos serv = new Servicos("", 0.0);

        for (Servicos s : lstServ) {
            switch (s.getNomeServico()) {
                case "Diaria":
                    if (nomeServico == "Diaria") {
                        serv = s;
                    }

                    break;
                case "Banho":
                    if (nomeServico == "Banho") {
                        serv = s;
                    }
                    break;
                case "Tosa":
                    if (nomeServico == "Tosa") {
                        serv = s;
                    }
                    break;
                case "Massagem":
                    if (nomeServico == "Massagem") {
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
        List<Servicos> servs = (List<Servicos>) agend.getServicosAdicionais();

        String dateCheckIn = agend.getDataCheckIn();
        String dateCheckOut = agend.getDataCheckOut();
        cIn.setTime(formatoDMY.parse(dateCheckIn));
        cOut.setTime(formatoDMY.parse(dateCheckOut));
        int dias = cOut.get(Calendar.DAY_OF_YEAR) - cIn.get(Calendar.DAY_OF_YEAR);

        int qtdBanho = dias < 7 ? 1 : (dias / 7);
        int qtdTosa = dias < 30 ? 1 : (dias / 30);
        int qtdMassagem = dias < 14 ? 1 : (dias / 14);

        Double valDiaria = utils.getServico(servs, "Diaria").getValorServico() * dias;
        Double valBanho = utils.getServico(servs, "Banho").getValorServico() * qtdBanho;
        Double valTosa = utils.getServico(servs, "Tosa").getValorServico() * qtdTosa;
        Double valMassagem = utils.getServico(servs, "Massagem").getValorServico() * qtdMassagem;
        valTotal = (valDiaria + valBanho + valMassagem + valTosa);

        return valTotal;
    }

}
