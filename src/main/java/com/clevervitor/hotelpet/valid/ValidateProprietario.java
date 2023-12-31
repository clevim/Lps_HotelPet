/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.valid;

import com.clevervitor.hotelpet.exceptions.ProprietarioException;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.model.enums.Sexo;
import static com.clevervitor.hotelpet.valid.ValidateUtils.criptografiaBase64Encoder;

/**
 *
 * @author vitor
 */
public class ValidateProprietario {

    public Proprietario validaCamposEntrada(Proprietario validaProprietario) {
        Proprietario proprietario = new Proprietario();

        proprietario.setId(validaProprietario.getId());

        if (validaProprietario.getNome().isEmpty()) {
            throw new ProprietarioException("Error - Campo vazio: 'nome'.");
        }
        proprietario.setNome(validaProprietario.getNome());

        if (validaProprietario.getEndereco().isEmpty()) {
            throw new ProprietarioException("Error - Campo vazio: 'endereco'");
        }

        proprietario.setEndereco(validaProprietario.getEndereco());

        if (validaProprietario.getDataNasc().isEmpty()) {
            throw new ProprietarioException("Error - Campo vazio: 'Data Nascimento'");
        }

        proprietario.setDataNasc(validaProprietario.getDataNasc());

        if (validaProprietario.getSexo() == Sexo.NULL) {
            throw new ProprietarioException("Error - Campo vazio: 'sexo'.");
        }

        proprietario.setSexo(validaProprietario.getSexo());

        if (validaProprietario.getTel().isEmpty()) {
            throw new ProprietarioException("Error - Campo vazio: 'telefone'");
        }

        proprietario.setTel(validaProprietario.getTel());

        if (validaProprietario.getEmail() == null) {
            throw new ProprietarioException("Error - Campo vazio: 'e-mail'");
        }

        proprietario.setEmail(validaProprietario.getEmail());

        if (validaProprietario.getCpf().isEmpty()) {
            throw new ProprietarioException("Error - Campo vazio: 'cpf'");
        }

        proprietario.setCpf(validaProprietario.getCpf());

        if (validaProprietario.getSenha().isEmpty()) {
            throw new ProprietarioException("Error - Campo vazio: 'senha'");
        }
        proprietario.setSenha(criptografiaBase64Encoder(validaProprietario.getSenha()));

        proprietario.setLstPetsPossuidos(validaProprietario.getLstPetsPossuidos());

        proprietario.setLstAgendamentos(validaProprietario.getLstAgendamentos());

        proprietario.setNivelAcesso(validaProprietario.getNivelAcesso());

        proprietario.setAvatar(validaProprietario.getAvatar());

        return proprietario;
    }
}
