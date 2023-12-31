/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.controller;

import com.clevervitor.hotelpet.controller.tableModel.TMPet;
import com.clevervitor.hotelpet.exceptions.PetException;
import com.clevervitor.hotelpet.model.dao.PetDAO;
import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.model.entities.filtros.FiltroPet;
import com.clevervitor.hotelpet.valid.ValidatePet;
import java.util.List;
import javax.swing.JTable;
import static org.hibernate.criterion.Projections.id;

/**
 *
 * @author vitor
 */
public class PetController {

    private PetDAO repositorio;

    public PetController() {
        repositorio = new PetDAO();
    }

    public void cadastrarPet(Pet cadPet) {

        ValidatePet check = new ValidatePet();
        Pet novoPet = check.validaCamposEntrada(cadPet);

        try {
            repositorio.save(novoPet);
        } catch (PetException e) {
            throw new PetException("Error - já existe um pet com este 'id'.");
        }

    }

    public void atualizarPet(Pet editPet) {

        ValidatePet check = new ValidatePet();
        Pet novoPet = check.validaCamposEntrada(editPet);

        try {
            repositorio.update(novoPet);
        } catch (PetException e) {
            throw new PetException("Error - já existe um pet com este 'id'.");
        }

    }

    public void atualizarTabelaDePets(JTable grd, List<Pet> lst) {
        TMPet tableModel = new TMPet(lst);
        grd.setModel(tableModel);
    }

    public Pet buscarPet(Integer id) {
        return (Pet) this.repositorio.find(id);
    }

    public Pet buscarAgendamento(Integer id) {
        return (Pet) this.repositorio.find(id);
    }

    public List<Pet> buscarTodosOsPets() {
        return (List<Pet>) this.repositorio.findAll();
    }

    public List<Pet> buscarTodosOsPetsFiltrado(FiltroPet filter) {
        return (List<Pet>) this.repositorio.findAllFilter(filter);
    }

    public void excluirPet(Pet pet) {
        pet.getProprietario().getLstPetsPossuidos().remove(pet);
        if (pet.getId() != null) {
            repositorio.delete(pet);
        } else {
            throw new PetException("Error - Pet inexistente.");
        }
    }

}
