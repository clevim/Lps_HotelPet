/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.dao;

import com.clevervitor.hotelpet.connection.DatabaseJPA;
import com.clevervitor.hotelpet.exceptions.PetException;
import com.clevervitor.hotelpet.exceptions.ProprietarioException;
import java.util.List;
import lombok.Data;
import com.clevervitor.hotelpet.model.entities.Pet;

import com.clevervitor.hotelpet.model.dao.contracts.Dao;
import com.clevervitor.hotelpet.model.entities.Pessoa;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.model.entities.filtros.FiltroPet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Clevs
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

    public List<Pet> findAllFilter(FiltroPet filter) {
        try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();

            jpql = "SELECT p "
                    + "FROM Pet p "
                    + "WHERE 1=1 ";

            if (filter.getNome() != null && !filter.getNome().isEmpty()) {
                jpql += "AND UPPER(p.nome) LIKE UPPER(:nome) ";
            }

            if (filter.getRaca() != null && !filter.getRaca().isEmpty()) {
                jpql += "AND UPPER(p.raca) LIKE UPPER(:raca) ";
            }

            if (filter.getProprietario_id() != null && filter.getProprietario_id() != -1) {
                jpql += "AND p.propietario_id == :proprietario_id ";
            }

            if (filter.getPesoIn() != null && !filter.getPesoIn().isEmpty()) {
                jpql += "AND p.peso >= :pesoIn ";
            }

            if (filter.getPesoOut() != null && !filter.getPesoOut().isEmpty()) {
                jpql += "AND p.peso <= :pesoOut ";
            }

            if (filter.getIdadeIn() != null && !filter.getIdadeIn().isEmpty()) {
                jpql += "AND p.idade >= :idadeIn ";
            }

            if (filter.getIdadeOut() != null && !filter.getIdadeOut().isEmpty()) {
                jpql += "AND p.idade <= :idadeOut ";
            }

            if (filter.getEspecie() != null && !filter.getEspecie().isEmpty()) {
                jpql += "AND UPPER(p.especie) LIKE UPPER(:especie) ";
            }

            qry = super.entityManager.createQuery(jpql, Pet.class);
            if (filter.getNome() != null && !filter.getNome().isEmpty()) {
                qry.setParameter("nome", "%" + filter.getNome() + "%");
            }

            if (filter.getRaca() != null && !filter.getRaca().isEmpty()) {
                qry.setParameter("raca", "%" + filter.getRaca() + "%");
            }

            if (filter.getProprietario_id() != null && filter.getProprietario_id() != -1) {
                qry.setParameter("proprietario_id", filter.getProprietario_id());
            }

            if (filter.getPesoIn() != null && !filter.getPesoIn().isEmpty()) {
                qry.setParameter("pesoIn", Double.valueOf(filter.getPesoIn()));
            }

            if (filter.getPesoOut() != null && !filter.getPesoOut().isEmpty()) {
                qry.setParameter("pesoOut", Double.valueOf(filter.getPesoOut()));
            }

            if (filter.getIdadeIn() != null && !filter.getIdadeIn().isEmpty()) {
                qry.setParameter("idadeIn", Integer.valueOf(filter.getIdadeIn()));
            }

            if (filter.getIdadeOut() != null && !filter.getIdadeOut().isEmpty()) {
                qry.setParameter("idadeOut", Integer.valueOf(filter.getIdadeOut()));
            }

            if (filter.getEspecie() != null && !filter.getEspecie().isEmpty()) {
                qry.setParameter("especie", "%" + filter.getEspecie() + "%");
            }

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

                jpql = " SELECT p "
                        + " FROM Pet p LEFT JOIN FETCH p.agendamentoMarcado WHERE p.id = :id";

                qry = super.entityManager.createQuery(jpql, Pet.class);
                qry.setParameter("id", id);

                Pet m = qry.getResultList().get(0);

                return m;
            } catch (PetException e) {
                throw new PetException("Pet não encontrado");
            } finally {
                entityManager.close();
            }
        }

    }

    public void updateAvatar(int id, byte[] imgProfile) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        if (id < 0) {
            throw new ProprietarioException("Este Pessoa não existe.");
        } else {

            try {
                super.entityManager = DatabaseJPA.getInstance().getEntityManager();

                Pet p = entityManager.find(Pet.class, id);

                p.setAvatarPet(imgProfile);

                this.entityManager.getTransaction().begin();
                this.entityManager.merge(p);
                this.entityManager.getTransaction().commit();
            } catch (ProprietarioException e) {
                throw new ProprietarioException("Pessoa não encontrado");
            } finally {
                entityManager.close();
            }
        }

    }
}
