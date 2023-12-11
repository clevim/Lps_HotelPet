/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.valid;

import com.clevervitor.hotelpet.model.dao.PessoaDAO;
import com.clevervitor.hotelpet.model.entities.Pessoa;
import java.util.Base64;

/**
 *
 * @author ifmaker
 */
public class ValidateUtils {

    public boolean validateLogin(String email, String senha) throws Exception {
        PessoaDAO Pdao = new PessoaDAO();
        try {
            Pessoa p = Pdao.findByEmail(email);

            String senhaBD = descriptografiaBase64Decode(p.getSenha());

            if (p != null) {
                if (p.getEmail().equals(email) && senhaBD.equals(senha)) {
                    return true;
                }
            }
        } catch (Exception e) {
            // Trate exceções aqui, se necessário
            throw new Exception("Ocorreu um erro ao validar o login.");
        }

        return false;

    }

    /**
     * Criptografando
     *
     * @param pValor
     * @return
     */
    public static String criptografiaBase64Encoder(String pValor) {
        return new String(Base64.getEncoder().encode(pValor.getBytes()));
    }

    /**
     * Realizando o inverso
     *
     * @param pValor
     * @return
     */
    public static String descriptografiaBase64Decode(String pValor) {
        return new String(Base64.getDecoder().decode(pValor.getBytes()));
    }

}
