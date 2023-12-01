/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.valid;

import com.clevervitor.hotelpet.exceptions.AgendamentoException;
import com.clevervitor.hotelpet.model.entities.Agendamento;
import static com.clevervitor.hotelpet.valid.ValidateUtils.criptografiaBase64Encoder;

/**
 *
 * @author vitor
 */
public class ValidateAgendamento {
    
    public Agendamento validaCamposEntrada(Agendamento validaAgendamento){
    Agendamento agendamento = new Agendamento();
    //CPFValidator validator = new CPFValidator(); //CPF VALIDATOR
    
    agendamento.setId(validaAgendamento.getId());

        if (validaAgendamento.getDataCheckIn().isEmpty()) {
            throw new AgendamentoException("Error - Campo vazio: 'Data check-in'.");
        }
        agendamento.setDataCheckIn(validaAgendamento.getDataCheckIn());
        
        
        if (validaAgendamento.getDataCheckOut().isEmpty()) {
            throw new AgendamentoException("Error - Campo vazio: 'Data check-Out'.");
        }
        agendamento.setDataCheckOut(validaAgendamento.getDataCheckOut());
        

        if (validaAgendamento.getServicosAdicionais().isEmpty()) {
            throw new AgendamentoException("Error - Campo vazio: 'serviços adicionais'");
        }

        agendamento.setServicosAdicionais(validaAgendamento.getServicosAdicionais());
        
        if (validaAgendamento.getProprietarioResp() == null) {
            throw new AgendamentoException("Error - Sem responsável pelo agendamento");
        }

        agendamento.setProprietarioResp(validaAgendamento.getProprietarioResp());
        
        if (validaAgendamento.getPetAgendado() == null) {
            throw new AgendamentoException("Error - Nenhum animal agendado");
        }

        agendamento.setPetAgendado(validaAgendamento.getPetAgendado());

        
        
        return agendamento;
    }
}  

