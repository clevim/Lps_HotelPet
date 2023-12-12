/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.valid;

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
        List<Pessoa> lstPess = pDAO.findAll();
        Pessoa per = pDAO.find(id);
        if (!per.getEmail().equals(email)) {
            for (Pessoa p : lstPess) {
                if (p.getEmail().equals(email)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Boolean ValidaFormPessoaCpf(String cpf, Integer id) {
        List<Pessoa> lstPess = pDAO.findAll();
        Pessoa per = pDAO.find(id);
        if (!per.getCpf().equals(cpf)) {
            for (Pessoa p : lstPess) {
                if (p.getCpf().equals(cpf)) {
                    return false;
                }
            }
        }

        return true;
    }

}
