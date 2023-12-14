/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.controller;

import com.clevervitor.hotelpet.connection.GEmailSender;
import com.clevervitor.hotelpet.controller.tableModel.TMAgendamentos;
import com.clevervitor.hotelpet.controller.tableModel.TMFuncionario;
import com.clevervitor.hotelpet.controller.tableModel.TMPet;
import com.clevervitor.hotelpet.controller.tableModel.TMProprietario;
import com.clevervitor.hotelpet.exceptions.FuncionarioException;
import com.clevervitor.hotelpet.model.dao.FuncionarioDAO;
import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Funcionario;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.model.entities.filtros.FiltroFuncionario;
import com.clevervitor.hotelpet.utils.emailBodys;
import com.clevervitor.hotelpet.valid.ValidateFuncionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JTable;

/**
 *
 * @author vitor
 */
public class FuncionarioController {

    private FuncionarioDAO repositorio;
    GEmailSender emailConf = new GEmailSender();
    emailBodys emBd = new emailBodys();

    public FuncionarioController() {
        repositorio = new FuncionarioDAO();
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

    public void atualizarTabelaDeFuncionario(JTable grd, List<Funcionario> lst) {
        TMFuncionario tableModel = new TMFuncionario(lst);
        grd.setModel(tableModel);
    }

    public void cadastrarFuncionario(Funcionario cadFuncionario) {

        ValidateFuncionario check = new ValidateFuncionario();
        Funcionario novoFuncionario = check.validaCamposEntrada(cadFuncionario);

        try {
            repositorio.save(novoFuncionario);
            //emailConf.sendEmail(novoFuncionario.getEmail(), "Cadastro Hotel Pet", emBd.emailDog1("Bem vindo ao Hotel Pet"));

        } catch (FuncionarioException e) {
            throw new FuncionarioException("Error - já existe um Funcionario com este 'id'.");
        }
    }

    public List<Funcionario> buscarTodosOsFuncionarios() {
        return (List<Funcionario>) this.repositorio.findAll();
    }

    public List<Funcionario> buscarTodosOsFuncionariosFiltrado(FiltroFuncionario filter) {
        return (List<Funcionario>) this.repositorio.findAllFilter(filter);
    }

    public void atualizarFuncionario(Funcionario editFuncionario) {

        ValidateFuncionario check = new ValidateFuncionario();
        Funcionario novoFuncionario = check.validaCamposEntrada(editFuncionario);

        try {
            repositorio.update(novoFuncionario);
            //emailConf.sendEmail(novoFuncionario.getEmail(), "Atualização Hotel Pet", emBd.emailDog2("Sua conta foi atualizada."));
        } catch (FuncionarioException e) {
            throw new FuncionarioException("Error - já existe um Funcionario com este 'id'.");
        }

    }

    public Funcionario buscarFuncionario(Integer id) {
        return (Funcionario) this.repositorio.find(id);
    }

    public void excluirFuncionario(Funcionario funcionario) {
        if (funcionario.getId() != null) {
            repositorio.delete(funcionario);
            //emailConf.sendEmail(funcionario.getEmail(), "Adeus Hotel Pet", emBd.emailCat("Sua conta foi deletada."));
        } else {
            throw new FuncionarioException("Error - Funcionario inexistente.");
        }
    }

}
