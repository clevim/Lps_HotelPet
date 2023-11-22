/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.dao;

import com.clevervitor.hotelpet.model.IDao;
import com.clevervitor.hotelpet.model.entities.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author clevs
 */
public class PessoaDAO implements IDao{
      private Query qry;
    private String jpql;

    public EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;

        try {
            factory = Persistence.createEntityManagerFactory("hotelPet");
            entityManager = factory.createEntityManager();
        } catch (Exception e) {
            System.err.print("Falha ao conectar");
        }
        return entityManager;
    }

    public Pessoa findByEmail(String email) {
        EntityManager entityManager = getEntityManager();

        String jpql = "SELECT p "
                + "FROM Pessoa p "
                + "WHERE p.email LIKE :email";
        Query qry = entityManager.createQuery(jpql);
        qry.setParameter("email", email);

        List<Pessoa> pessoas = qry.getResultList();

        entityManager.close();

        if (pessoas.isEmpty()) {
            return null;
        } else {
            return pessoas.get(0);
        }
    }

    @Override
    public void save(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
