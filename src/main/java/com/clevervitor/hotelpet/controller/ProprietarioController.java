/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.controller;

import com.clevervitor.hotelpet.controller.tableModel.TMPet;
import com.clevervitor.hotelpet.exceptions.PetException;
import com.clevervitor.hotelpet.exceptions.ProprietarioException;
import com.clevervitor.hotelpet.model.dao.ProprietarioDAO;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.model.entities.Proprietario;
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

//    public EntityManager getEntityManager() {
//        EntityManagerFactory factory = null;
//        EntityManager entityManager = null;
//
//        try {
//            factory = Persistence.createEntityManagerFactory("hotelPet");
//            entityManager = factory.createEntityManager();
//        } finally {
//            factory.close();
//        }
//        return entityManager;
//    }

    public void atualizarTabelaDePets(JTable grd, List<Pet> lst, Pet pet){
        TMPet tableModel = new TMPet(lst, pet);
        grd.setModel(tableModel);
    }
    
    public void atualizarTabelaDePetsInicioFrame(JTable grd, List<Pet> lst){
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
            repositorio.save(novoProprietario);
        } catch (ProprietarioException e) {
            throw new ProprietarioException("Error - já existe um proprietario com este 'id'.");
        }

    }

    public Proprietario buscarProprietario(Integer id) {
        return (Proprietario) this.repositorio.find(id);
    }

    

    public void excluirPet(Proprietario proprietario) {
        if (proprietario.getId() != null) {
            repositorio.delete(proprietario);
        } else {
            throw new ProprietarioException("Error - Pet inexistente.");
        }
    }
/*
    public void atualizarTabela(JTable grd) {
        List<Object> lst = repositorio.findAll();

        TMCadPet tmPet = new TMCadPet(lst);
        grd.setModel(tmPet);
    }
    */
}
