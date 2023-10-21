/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.dao;

import com.clevervitor.hotelpet.model.IDao;
import com.clevervitor.hotelpet.model.entities.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vitor
 */
public class FuncionarioDAO implements IDao{
    
EntityManagerFactory factory = Persistence.createEntityManagerFactory("hotelPet");
    EntityManager entityManager = factory.createEntityManager();

    public FuncionarioDAO() {

    }

    public EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;

        try {
            factory = Persistence.createEntityManagerFactory("hotelPet");
            entityManager = factory.createEntityManager();
        } finally {
            factory.close();
        }
        return entityManager;
    }

    @Override
    public void save(Object obj) {
        Funcionario funcionario = (Funcionario) obj;

        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            if (funcionario.getId() == null) {

                entityManager.persist(funcionario);
            } else {
                funcionario = entityManager.merge(funcionario);
            }
            entityManager.getTransaction().commit();

        } finally {

            entityManager.close();
        }
    }

    public Object find(Integer id) {
        EntityManager entityManager = getEntityManager();

        Funcionario funcionario = entityManager.find(Funcionario.class, id);

        entityManager.close();
        factory.close();

        return funcionario;
    }

    @Override
    public List<Object> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Integer id) {
        try {

            EntityManager entityManager = getEntityManager();

            Funcionario funcionario = entityManager.find(Funcionario.class, id);
            
            
            entityManager.getTransaction().begin();
            
            entityManager.remove(funcionario);
            
            entityManager.getTransaction().commit();
            
            
            entityManager.close();
            factory.close();

            return true;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
