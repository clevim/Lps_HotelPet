/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.dao;

import com.clevervitor.hotelpet.connection.DatabaseJPA;
import com.clevervitor.hotelpet.exceptions.PetException;
import java.util.List;
import lombok.Data;
import com.clevervitor.hotelpet.model.entities.Pet;

import com.clevervitor.hotelpet.model.dao.contracts.Dao;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import lombok.EqualsAndHashCode;

/**
 *
 * @author 14892160652
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PetDAO extends Dao<Pet> {

    public PetDAO() {

    }

    public Object findByEmail(String email) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT f "
                + "FROM Pet f"
                + " WHERE f.email LIKE :email ";
        TypedQuery qry = this.entityManager.createQuery(jpql, Pet.class);
        qry.setParameter("email", email);

        List<Pet> lst = qry.getResultList();
        this.entityManager.close();

        return lst;

    }

    public List<Pet> findAll() {
        try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();

            jpql = " SELECT f "
                    + " FROM Pet f ";

            qry = super.entityManager.createQuery(jpql, Pet.class);

            List lstPets = qry.getResultList();
            return lstPets;
        } catch (PetException msg) {
            throw new PetException("Erro ao retornar lista de Pets.");
        } finally {
            super.entityManager.close();
        }
    }

    @Override
    public Pet find(int id) {

        if (id < 0) {
            throw new PetException("Este Pet não existe.");
        } else {

            try {
                super.entityManager = DatabaseJPA.getInstance().getEntityManager();

                Pet m = entityManager.find(Pet.class, id);

                return m;
            } catch (PetException e) {
                throw new PetException("Pet não encontrado");
            } finally {
                entityManager.close();
            }
        }

    }
}
