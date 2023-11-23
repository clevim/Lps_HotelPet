/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.dao;

import com.clevervitor.hotelpet.exceptions.ProprietarioException;
import com.clevervitor.hotelpet.model.entities.Pessoa;
import com.clevervitor.hotelpet.model.entities.Pessoa;
import com.vcompany.teramusique.connection.DatabaseJPA;
import com.vcompany.teramusique.model.dao.contracts.Dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author clevs
 */
public class PessoaDAO extends Dao<Pessoa>{
      private Query qry;
    private String jpql;

    public Object findByEmail(String email) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT f "
                + "FROM Pessoa f"
                + " WHERE f.email LIKE :email ";
        TypedQuery qry = this.entityManager.createQuery(jpql, Pessoa.class);
        qry.setParameter("email", email);

        List<Pessoa> lst = qry.getResultList();
        this.entityManager.close();

        return lst;

    }

    public List<Pessoa> findAll() {
        try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();

            jpql = " SELECT f "
                    + " FROM Pessoa f ";

            qry = super.entityManager.createQuery(jpql, Pessoa.class);

            List lstPessoas = qry.getResultList();
            return lstPessoas;
        } catch (ProprietarioException msg) {
            throw new ProprietarioException("Erro ao retornar lista de Pessoas.");
        } finally {
            super.entityManager.close();
        }
    }

    @Override
    public Pessoa find(int id) {

        if (id < 0) {
            throw new ProprietarioException("Este Pessoa não existe.");
        } else {

            try {
                super.entityManager = DatabaseJPA.getInstance().getEntityManager();

                Pessoa m = entityManager.find(Pessoa.class, id);

                return m;
            } catch (ProprietarioException e) {
                throw new ProprietarioException("Pessoa não encontrado");
            } finally {
                entityManager.close();
            }
        }

    }

}
