/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.controller;

import com.clevervitor.hotelpet.controller.tableModel.TMAgendamentos;
import com.clevervitor.hotelpet.controller.tableModel.TMPet;
import com.clevervitor.hotelpet.controller.tableModel.TMProprietario;
import com.clevervitor.hotelpet.exceptions.PetException;
import com.clevervitor.hotelpet.exceptions.ProprietarioException;
import com.clevervitor.hotelpet.model.dao.ProprietarioDAO;
import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.model.entities.filtros.FiltroProprietario;
import com.clevervitor.hotelpet.valid.ValidateProprietario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JTable;

/**
 *
 * @author vitor
 */
public class ProprietarioController {

    private ProprietarioDAO repositorio;

    public ProprietarioController() {
        repositorio = new ProprietarioDAO();
    }

    public void atualizarTabelaDeProprietarios(JTable grd, List<Proprietario> lst) {
        TMProprietario tableModel = new TMProprietario(lst);
        grd.setModel(tableModel);
    }

    public void atualizarTabelaDeAgendamentos(JTable grd, List<Agendamento> lst) {
        TMAgendamentos tableModel = new TMAgendamentos(lst);
        grd.setModel(tableModel);
    }

    public void atualizarTabelaDePetsInicioFrame(JTable grd, List<Pet> lst) {
        TMPet tableModel = new TMPet(lst);
        grd.setModel(tableModel);
    }

    public void cadastrarProprietario(Proprietario cadProprietario) {

        ValidateProprietario check = new ValidateProprietario();
        Proprietario novoProprietario = check.validaCamposEntrada(cadProprietario);

        try {
            repositorio.save(novoProprietario);
        } catch (ProprietarioException e) {
            throw new ProprietarioException("Error - já existe um proprietario com este 'id'.");
        }
    }

    public void atualizarProprietario(Proprietario editProprietario) {

        ValidateProprietario check = new ValidateProprietario();
        Proprietario novoProprietario = check.validaCamposEntrada(editProprietario);

        try {
            repositorio.update(novoProprietario);
        } catch (ProprietarioException e) {
            throw new ProprietarioException("Error - já existe um proprietario com este 'id'.");
        }

    }

    public Proprietario buscarProprietario(Integer id) {
        return (Proprietario) this.repositorio.find(id);
    }

    public List<Proprietario> buscarTodosOsProprietarios() {
        return (List<Proprietario>) this.repositorio.findAll();
    }

    public List<Proprietario> buscarTodosOsProprietariosFiltrados(FiltroProprietario filter) {
        return (List<Proprietario>) this.repositorio.findAllFilter(filter);
    }

    public void excluirPet(Proprietario proprietario) {
        if (proprietario.getId() != null) {
            repositorio.delete(proprietario);
        } else {
            throw new ProprietarioException("Error - Pet inexistente.");
        }
    }

}
