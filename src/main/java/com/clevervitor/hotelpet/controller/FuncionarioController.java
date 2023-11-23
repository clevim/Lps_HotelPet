/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.controller;

import com.clevervitor.hotelpet.exceptions.FuncionarioException;
import com.clevervitor.hotelpet.model.dao.FuncionarioDAO;
import com.clevervitor.hotelpet.model.entities.Funcionario;
import com.clevervitor.hotelpet.valid.ValidateFuncionario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vitor
 */
public class FuncionarioController {
    
    private FuncionarioDAO repositorio;

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

    public void cadastrarFuncionario(Funcionario cadFuncionario) {

        ValidateFuncionario check = new ValidateFuncionario();
        Funcionario novoFuncionario = check.validaCamposEntrada(cadFuncionario);

        try {
            repositorio.save(novoFuncionario);
        } catch (FuncionarioException e) {
            throw new FuncionarioException("Error - já existe um Funcionario com este 'id'.");
        }
    }

    public void atualizarFuncionario(Funcionario editFuncionario) {

        ValidateFuncionario check = new ValidateFuncionario();
        Funcionario novoFuncionario = check.validaCamposEntrada(editFuncionario);

        try {
            repositorio.save(novoFuncionario);
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
        } else {
            throw new FuncionarioException("Error - Funcionario inexistente.");
        }
    }
    
}
