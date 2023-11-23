/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.model.dao.contracts;

import com.vcompany.teramusique.connection.DatabaseJPA;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author vitor
 */
public abstract class Dao<T> implements IDao<T> {
    
    protected EntityManager entityManager;
    protected TypedQuery<T> qry;
    protected String jpql;
    
    public Dao(){
        
    }
    
    @Override
    public void save (T obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }
    
    @Override
    public void update(T obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        obj = this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }
    
    @Override
    public boolean delete(T obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }
   
}
