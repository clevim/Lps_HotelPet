/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.valid;

import com.clevervitor.hotelpet.exceptions.PetException;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.model.entities.Proprietario;

/**
 *
 * @author vitor
 */
public class ValidatePet {

    public Pet validaCamposEntrada(Pet validaPet) {
        Pet pet = new Pet();

        pet.setId(validaPet.getId());

        if (validaPet.getNome().isEmpty()) {
            throw new PetException("Error - Campo vazio: 'nome'.");
        }
        pet.setNome(validaPet.getNome());

        if (validaPet.getEspecie().isEmpty()) {
            throw new PetException("Error - Campo vazio: 'especie'");
        }

        pet.setEspecie(validaPet.getEspecie());

        if (validaPet.getRaca().isEmpty()) {
            throw new PetException("Error - Campo vazio: 'raca'");
        }

        pet.setRaca(validaPet.getRaca());

        if (validaPet.getIdade() < 0) {
            throw new PetException("Error - Campo vazio: 'idade'.");
        }
        pet.setIdade(validaPet.getIdade());

        if (validaPet.getSexo().isEmpty()) {
            throw new PetException("Error - Campo vazio: 'sexo'");
        }

        pet.setSexo(validaPet.getSexo());

        if (validaPet.getPeso() == null) {
            throw new PetException("Error - Campo vazio: 'peso'");
        }

        pet.setPeso(validaPet.getPeso());

        if (validaPet.getObs().isEmpty()) {
            throw new PetException("Error - Campo vazio: 'obs'");
        }

        pet.setObs(validaPet.getObs());

        if (validaPet.getProprietario() == null) {
            throw new PetException("Error - Campo vazio: 'Proprietario'");
        }
        pet.setProprietario(validaPet.getProprietario());

        return pet;
    }
}
