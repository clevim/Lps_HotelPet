/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.dao;

import com.clevervitor.hotelpet.exceptions.ProprietarioException;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.vcompany.teramusique.connection.DatabaseJPA;
import com.vcompany.teramusique.model.dao.contracts.Dao;
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

            jpql = " SELECT f "
                    + " FROM Proprietario f ";

            qry = super.entityManager.createQuery(jpql, Proprietario.class);

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
