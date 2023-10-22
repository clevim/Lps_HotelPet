/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.dao;

import java.util.List;
import lombok.Data;
import com.clevervitor.hotelpet.model.IDao;
import com.clevervitor.hotelpet.model.entities.Pet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 14892160652
 */
@Data
public class PetDAO implements IDao {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("hotelPet");
    EntityManager entityManager = factory.createEntityManager();

    public PetDAO() {

    }

    public EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;

        try {
            factory = Persistence.createEntityManagerFactory("hotelPet");
            entityManager = factory.createEntityManager();
        } catch(Exception e){
        System.err.print("Falha ao conectar");
        }
        return entityManager;
    }

    @Override
    public void save(Object obj) {
        Pet pet = (Pet) obj;

        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            if (pet.getId() == null) {

                entityManager.persist(pet);
            } else {
               entityManager.merge(pet);
            }
            entityManager.getTransaction().commit();

        } finally {

            entityManager.close();
        }
    }

    public Object find(Integer id) {
        EntityManager entityManager = getEntityManager();

        Pet pet = entityManager.find(Pet.class, id);

        entityManager.close();
        factory.close();

        return pet;
    }

    @Override
    public List<Object> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Integer id) {
        try {

            EntityManager entityManager = getEntityManager();

            Pet pet = entityManager.find(Pet.class, id);
            
            
            entityManager.getTransaction().begin();
            
            entityManager.remove(pet);
            
            entityManager.getTransaction().commit();
            
            
            entityManager.close();
            factory.close();

            return true;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
