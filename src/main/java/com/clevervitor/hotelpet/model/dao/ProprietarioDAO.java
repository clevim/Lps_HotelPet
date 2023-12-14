/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.dao;

import com.clevervitor.hotelpet.connection.DatabaseJPA;
import com.clevervitor.hotelpet.exceptions.ProprietarioException;
import com.clevervitor.hotelpet.model.entities.Proprietario;

import com.clevervitor.hotelpet.model.dao.contracts.Dao;
import com.clevervitor.hotelpet.model.entities.filtros.FiltroProprietario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author 14892160652
 */
public class ProprietarioDAO extends Dao<Proprietario> {

    public ProprietarioDAO() {

    }

    public Object findByEmail(String email) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT f "
                + "FROM Proprietario f"
                + " WHERE f.email LIKE :email ";
        TypedQuery qry = this.entityManager.createQuery(jpql, Proprietario.class);
        qry.setParameter("email", email);

        List<Proprietario> lst = qry.getResultList();
        this.entityManager.close();

        return lst;

    }

    public List<Proprietario> findAll() {
        try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();

            jpql = " SELECT p "
                    + " FROM Proprietario p";

            qry = super.entityManager.createQuery(jpql, Proprietario.class);

            List lstProprietarios = qry.getResultList();
            return lstProprietarios;
        } catch (ProprietarioException msg) {
            throw new ProprietarioException("Erro ao retornar lista de Proprietarios.");
        } finally {
            super.entityManager.close();
        }
    }

    public List<Proprietario> findAllFilter(FiltroProprietario filter) {
        try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();

            jpql = "SELECT p "
                    + "FROM Proprietario p "
                    + "WHERE 1=1 ";

            if (filter.getNome() != null && !filter.getNome().isEmpty()) {
                jpql += "AND UPPER(p.nome) LIKE UPPER(:nome) ";
            }

            if (filter.getEmail() != null && !filter.getEmail().isEmpty()) {
                jpql += "AND UPPER(p.email) LIKE UPPER(:email) ";
            }

            if (filter.getEndereco() != null && !filter.getEndereco().isEmpty()) {
                jpql += "AND UPPER(p.endereco) LIKE UPPER(:endereco) ";
            }

            qry = super.entityManager.createQuery(jpql, Proprietario.class);
            if (filter.getNome() != null && !filter.getNome().isEmpty()) {
                qry.setParameter("nome", "%" + filter.getNome() + "%");
            }

            if (filter.getEmail() != null && !filter.getEmail().isEmpty()) {
                qry.setParameter("email", "%" + filter.getEmail() + "%");
            }

            if (filter.getEndereco() != null && !filter.getEndereco().isEmpty()) {
                qry.setParameter("endereco", "%" + filter.getEndereco() + "%");
            }

            List lstProprietarios = qry.getResultList();
            return lstProprietarios;
        } catch (ProprietarioException msg) {
            throw new ProprietarioException("Erro ao retornar lista de Proprietarios.");
        } finally {
            super.entityManager.close();
        }
    }

    @Override
    public Proprietario find(int id) {

        if (id < 0) {
            throw new ProprietarioException("Este Proprietario não existe.");
        } else {

            try {
                super.entityManager = DatabaseJPA.getInstance().getEntityManager();

                Proprietario m = entityManager.find(Proprietario.class, id);

                return m;
            } catch (ProprietarioException e) {
                throw new ProprietarioException("Proprietario não encontrado");
            } finally {
                entityManager.close();
            }
        }

    }
}
