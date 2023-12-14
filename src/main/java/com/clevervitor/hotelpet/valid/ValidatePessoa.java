/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.valid;

import br.com.caelum.stella.validation.CPFValidator;
import com.clevervitor.hotelpet.model.dao.PessoaDAO;
import com.clevervitor.hotelpet.model.entities.Pessoa;
import java.util.List;

/**
 *
 * @author clevs
 */
public class ValidatePessoa {

    PessoaDAO pDAO = new PessoaDAO();

    public Boolean ValidaFormPessoaEmail(String email, Integer id) {
        if (id == -1) {
            List<Pessoa> lstPess = pDAO.findAll();

            for (Pessoa p : lstPess) {
                int i = p.getEmail().compareTo(email);
                if (p.getEmail().compareTo(email) == 0) {
                    return true;
                }

            }
        } else {
            List<Pessoa> lstPess = pDAO.findAll();
            Pessoa per = pDAO.find(id);
            if (per.getEmail().compareTo(email) != 0) {
                for (Pessoa p : lstPess) {
                    if (p.getEmail().compareTo(email) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Boolean ValidaFormPessoaCpf(String cpf, Integer id) {

        if (id == -1) {
            List<Pessoa> lstPess = pDAO.findAll();

            for (Pessoa p : lstPess) {

                int i = p.getCpf().compareTo(cpf);
                if (p.getCpf().compareTo(cpf) == 0) {
                    return true;
                }
            }

        } else {
            List<Pessoa> lstPess = pDAO.findAll();
            Pessoa per = pDAO.find(id);
            if (per.getCpf().compareTo(cpf) != 0) {
                for (Pessoa p : lstPess) {
                    if (p.getCpf().compareTo(cpf) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

}
