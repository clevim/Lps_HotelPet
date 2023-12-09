/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.dao;

import com.clevervitor.hotelpet.connection.DatabaseJPA;
import com.clevervitor.hotelpet.exceptions.FuncionarioException;
import com.clevervitor.hotelpet.model.entities.Funcionario;

import com.clevervitor.hotelpet.model.dao.contracts.Dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author vitor
 */
public class FuncionarioDAO extends Dao<Funcionario> {

    public FuncionarioDAO() {

    }

    public Object findByEmail(String email) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT f "
                + "FROM Funcionario f"
                + " WHERE f.email LIKE :email ";
        TypedQuery qry = this.entityManager.createQuery(jpql, Funcionario.class);
        qry.setParameter("email", email);

        List<Funcionario> lst = qry.getResultList();
        this.entityManager.close();

        return lst;

    }

    public List<Funcionario> findAll() {
        try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();

            jpql = " SELECT f "
                    + " FROM Funcionario f ";

            qry = super.entityManager.createQuery(jpql, Funcionario.class);

            List lstFuncionarios = qry.getResultList();
            return lstFuncionarios;
        } catch (FuncionarioException msg) {
            throw new FuncionarioException("Erro ao retornar lista de funcionarios.");
        } finally {
            super.entityManager.close();
        }
    }

    public Funcionario find(int id) {

        if (id < 0) {
            throw new FuncionarioException("Este Funcionario não existe.");
        } else {

            try {
                super.entityManager = DatabaseJPA.getInstance().getEntityManager();

                Funcionario m = entityManager.find(Funcionario.class, id);

                return m;
            } catch (FuncionarioException e) {
                throw new FuncionarioException("Funcionarionão encontrado");
            } finally {
                entityManager.close();
            }
        }

    }
}
