/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.dao;

import com.clevervitor.hotelpet.connection.DatabaseJPA;
import com.clevervitor.hotelpet.exceptions.AgendamentoException;
import com.clevervitor.hotelpet.model.dao.contracts.Dao;
import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.model.entities.filtros.FiltroAgendamento;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Hibernate;

/**
 *
 * @author vitor
 */
public class AgendamentoDAO extends Dao<Agendamento> {

    public AgendamentoDAO() {
    }

    public Object findByProprietario(Proprietario proprietarioResp) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT f "
                + "FROM Agendamento f"
                + " WHERE f.proprietarioresp LIKE :proprietarioresp";
        TypedQuery qry = this.entityManager.createQuery(jpql, Agendamento.class);
        qry.setParameter("proprietarioresp", proprietarioResp);

        List<Agendamento> lst = qry.getResultList();
        this.entityManager.close();

        return lst;

    }

    public Object findByPet(Pet pet) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT f "
                + "FROM Agendamento f"
                + " WHERE f.Pet LIKE :Pet";
        TypedQuery qry = this.entityManager.createQuery(jpql, Pet.class);
        qry.setParameter("Pet", pet);

        List<Agendamento> lst = qry.getResultList();
        this.entityManager.close();

        return lst;

    }

    public List<Agendamento> findAllFilter(FiltroAgendamento filter) {
        try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();

            jpql = "SELECT DISTINCT a "
                    + "FROM Agendamento a LEFT JOIN FETCH a.servicosAdicionais "
                    + "WHERE 1=1 ";

            if (filter.getDataCheckIn() != null && !filter.getDataCheckIn().isEmpty()) {
                jpql += "AND CONVERT(DATE,a.dataCheckIn) >= CONVERT(DATE,:dataCheckIn) ";
            }

            if (filter.getDataCheckOut() != null && !filter.getDataCheckOut().isEmpty()) {
                jpql += "AND CONVERT(DATE,a.dataCheckOut) <= CONVERT(DATE,:dataCheckOut) ";
            }

            if (filter.getPetAgendado_id() != null && filter.getPetAgendado_id() != -1) {
                jpql += "AND a.pet_id == :petAgendado ";
            }

            if (filter.getPropAgendado_id() != null && filter.getPropAgendado_id() != -1) {
                jpql += "AND a.proprietarioResp_id == :propAgendado ";
            }

            qry = super.entityManager.createQuery(jpql, Agendamento.class);

            if (filter.getDataCheckIn() != null && !filter.getDataCheckIn().isEmpty()) {
                qry.setParameter("dataCheckIn", filter.getDataCheckIn());
            }

            if (filter.getDataCheckOut() != null && !filter.getDataCheckOut().isEmpty()) {
                qry.setParameter("dataCheckOut", filter.getDataCheckOut());
            }

            if (filter.getPetAgendado_id() != null && filter.getPetAgendado_id() != -1) {
                qry.setParameter("petAgendado", "%" + filter.getPetAgendado_id() + "%");
            }

            if (filter.getPropAgendado_id() != null && filter.getPropAgendado_id() != -1) {
                qry.setParameter("propAgendado", "%" + filter.getPropAgendado_id() + "%");
            }

            List lstAgendamentos = qry.getResultList();
            return lstAgendamentos;
        } catch (AgendamentoException msg) {
            throw new AgendamentoException("Erro ao retornar lista de Agendamentos.");
        } finally {
            super.entityManager.close();
        }
    }

    public List<Agendamento> findAll() {
        try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();

            jpql = " SELECT DISTINCT f "
                    + " FROM Agendamento f LEFT JOIN FETCH f.servicosAdicionais  ";

            qry = super.entityManager.createQuery(jpql, Agendamento.class);

            List lstAgendamentos = qry.getResultList();
            return lstAgendamentos;
        } catch (AgendamentoException msg) {
            throw new AgendamentoException("Erro ao retornar lista de Agendamentos.");
        } finally {
            super.entityManager.close();
        }
    }

    public Agendamento find(int id) {

        if (id < 0) {
            throw new AgendamentoException("Este Agendamento não existe.");
        } else {

            try {
                super.entityManager = DatabaseJPA.getInstance().getEntityManager();

                Agendamento m = entityManager.find(Agendamento.class, id);
                Hibernate.initialize(m.getServicosAdicionais());
                return m;
            } catch (AgendamentoException e) {
                throw new AgendamentoException("Agendamento não encontrado");
            } finally {
                entityManager.close();
            }
        }

    }
}
