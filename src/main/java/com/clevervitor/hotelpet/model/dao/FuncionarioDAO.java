/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.dao;

import com.clevervitor.hotelpet.connection.DatabaseJPA;
import com.clevervitor.hotelpet.exceptions.FuncionarioException;
import com.clevervitor.hotelpet.model.entities.Funcionario;

import com.clevervitor.hotelpet.model.dao.contracts.Dao;
import com.clevervitor.hotelpet.model.entities.filtros.FiltroFuncionario;
import com.clevervitor.hotelpet.model.enums.Sexo;
import com.clevervitor.hotelpet.model.enums.Turno;
import com.clevervitor.hotelpet.utils.utils;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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

    public List<Funcionario> findAllFilter(FiltroFuncionario filter) {
        try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();

            jpql = "SELECT f "
                    + "FROM Funcionario f "
                    + "WHERE 1=1 ";

            if (filter.getNome() != null && !filter.getNome().isEmpty()) {
                jpql += "AND UPPER(f.nome) LIKE UPPER(:nome) ";
            }
            if (filter.getEmail() != null && !filter.getEmail().isEmpty()) {
                jpql += "AND UPPER(f.email) LIKE UPPER(:email) ";
            }
            if (filter.getEndereco() != null && !filter.getEndereco().isEmpty()) {
                jpql += "AND UPPER(f.endereco) LIKE UPPER(:endereco) ";
            }

            if (filter.getSalarioIn() != null && !filter.getSalarioIn().isEmpty()) {
                jpql += "AND f.salario >= :salarioIn ";
            }
            if (filter.getSalarioOut() != null && !filter.getSalarioOut().isEmpty()) {
                jpql += "AND f.salario <= :salarioOut ";
            }

            qry = super.entityManager.createQuery(jpql, Funcionario.class);
            
                    if (filter.getNome() != null && !filter.getNome().isEmpty()) {
            qry.setParameter("nome", "%" + filter.getNome() + "%");
        }

        if (filter.getEmail() != null && !filter.getEmail().isEmpty()) {
            qry.setParameter("email", "%" + filter.getEmail() + "%");
        }

        if (filter.getEndereco() != null && !filter.getEndereco().isEmpty()) {
            qry.setParameter("endereco", "%" + filter.getEndereco() + "%");
        }

        if (filter.getSalarioIn() != null && !filter.getSalarioIn().isEmpty()) {
            qry.setParameter("salarioIn", Double.valueOf(filter.getSalarioIn()));
        }

        if (filter.getSalarioOut() != null && !filter.getSalarioOut().isEmpty()) {
            qry.setParameter("salarioOut", Double.valueOf(filter.getSalarioOut()));
        }


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
