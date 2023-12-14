/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.controller;

import com.clevervitor.hotelpet.controller.tableModel.TMAgendamentos;
import com.clevervitor.hotelpet.controller.tableModel.TMPet;
import com.clevervitor.hotelpet.controller.tableModel.TMProprietario;
import com.clevervitor.hotelpet.exceptions.AgendamentoException;
import com.clevervitor.hotelpet.model.dao.AgendamentoDAO;
import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.model.entities.filtros.FiltroAgendamento;
import com.clevervitor.hotelpet.valid.ValidateAgendamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JTable;

/**
 *
 * @author vitor
 */
public class AgendamentoController {

    private AgendamentoDAO repositorio;

    public AgendamentoController() {
        repositorio = new AgendamentoDAO();
    }

    public EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;

        try {
            factory = Persistence.createEntityManagerFactory("hotelPet");
            entityManager = factory.createEntityManager();
        } finally {
            factory.close();
        }
        return entityManager;
    }

    public void cadastrarAgendamento(Agendamento cadAgendamento) {

        ValidateAgendamento check = new ValidateAgendamento();
        Agendamento novoAgendamento = check.validaCamposEntrada(cadAgendamento);

        try {
            repositorio.save(novoAgendamento);
        } catch (AgendamentoException e) {
            throw new AgendamentoException("Error - já existe um Agendamento com este 'id'.");
        }
    }

    public void atualizarAgendamento(Agendamento editAgendamento) {

        ValidateAgendamento check = new ValidateAgendamento();
        Agendamento novoAgendamento = check.validaCamposEntrada(editAgendamento);

        try {
            repositorio.update(novoAgendamento);
        } catch (AgendamentoException e) {
            throw new AgendamentoException("Error - já existe um Agendamento com este 'id'.");
        }

    }

    public Agendamento buscarAgendamento(Integer id) {
        return (Agendamento) this.repositorio.find(id);
    }

    public List<Agendamento> buscarTodosOsAgendamentos() {
        return (List<Agendamento>) this.repositorio.findAll();
    }
    
    public List<Agendamento> buscarTodosOsAgendamentosFiltrados(FiltroAgendamento filter) {
        return (List<Agendamento>) this.repositorio.findAllFilter(filter);
    }

    public Agendamento buscarAgendamentoPorProprietario(Proprietario proprietario) {
        return (Agendamento) this.repositorio.findByProprietario(proprietario);
    }

    public Agendamento buscarAgendamentoPorPet(Pet pet) {
        return (Agendamento) this.repositorio.findByPet(pet);
    }

    public void atualizarTabelaDeAgendamentos(JTable grd, List<Agendamento> lst) {
        TMAgendamentos tableModel = new TMAgendamentos(lst);
        grd.setModel(tableModel);
    }

    public void excluirAgendamento(Agendamento Agendamento) {
        if (Agendamento.getId() != null) {
            repositorio.delete(Agendamento);
        } else {
            throw new AgendamentoException("Error - Agendamento inexistente.");
        }
    }

}
