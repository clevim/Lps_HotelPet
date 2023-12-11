/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.dao;

import com.clevervitor.hotelpet.connection.DatabaseJPA;
import com.clevervitor.hotelpet.exceptions.ServicosException;
import com.clevervitor.hotelpet.model.dao.contracts.Dao;
import com.clevervitor.hotelpet.model.entities.Servicos;
import com.clevervitor.hotelpet.model.enums.Services;
import java.util.HashSet;

import java.util.List;
import java.util.Set;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author clevs
 */
public class ServicosDAO extends Dao<Servicos> {

    private Query qry;
    private String jpql;

    public ServicosDAO() {
    }

    public Servicos findByName(Services nome) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT s "
                + "FROM Servicos s LEFT JOIN FETCH s.agendamentoMarcadoServices"
                + " WHERE s.nomeServico LIKE :nome ";
        TypedQuery qry = this.entityManager.createQuery(jpql, Servicos.class);
        qry.setParameter("nome", nome);

        List<Servicos> lst = qry.getResultList();
        this.entityManager.close();

        if (lst.isEmpty()) {
            return null;
        } else {
            return lst.get(0);
        }

    }

    @Override
    public Servicos find(int id) {
        if (id < 0) {
            throw new ServicosException("Este Servico não existe.");
        } else {

            try {
                super.entityManager = DatabaseJPA.getInstance().getEntityManager();

                Servicos s = entityManager.find(Servicos.class, id);

                return s;
            } catch (ServicosException e) {
                throw new ServicosException("Servico não encontrado");
            } finally {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Servicos> findAll() {
        try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();

            jpql = " SELECT s "
                    + " FROM Servicos s LEFT JOIN FETCH s.agendamentoMarcadoServices";

            qry = super.entityManager.createQuery(jpql, Servicos.class);

            List lstServicos = qry.getResultList();
            return lstServicos;
        } catch (ServicosException msg) {
            throw new ServicosException("Erro ao retornar lista de Servico.");
        } finally {
            super.entityManager.close();
        }
    }

    public Set<Servicos> findAllSet() {
        try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();

            jpql = " SELECT s "
                    + " FROM Servicos s LEFT JOIN FETCH s.agendamentoMarcadoServices";

            qry = super.entityManager.createQuery(jpql, Servicos.class);

            return new HashSet<>(qry.getResultList());
        } catch (ServicosException msg) {
            throw new ServicosException("Erro ao retornar lista de Servico.");
        } finally {
            super.entityManager.close();
        }
    }

}
