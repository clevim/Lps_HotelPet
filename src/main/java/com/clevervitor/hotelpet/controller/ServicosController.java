/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.controller;

import com.clevervitor.hotelpet.exceptions.ServicosException;
import com.clevervitor.hotelpet.model.dao.ServicosDAO;
import com.clevervitor.hotelpet.model.entities.Servicos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author clevs
 */
public class ServicosController {
    private ServicosDAO repositorio;
    
    public ServicosController() {
        repositorio = new ServicosDAO();
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
     
     public Servicos buscarServico(Integer id){
     return (Servicos) this.repositorio.find(id);
     }
     
    public List<Servicos> buscarTodosbuscarServico() {
        return (List<Servicos>) this.repositorio.findAll();
    }
    
    public void atualizarAgendamento(Servicos editServicos) {
        try {
            repositorio.update(editServicos);
        } catch (ServicosException e) {
            throw new ServicosException("Error - já existe um Agendamento com este 'id'.");
        }

    }
    
    public void initServicos(){
    Servicos Diaria = new Servicos("Diaria", 0.0);
    Servicos Banho = new Servicos("Banho", 0.0);
    Servicos Tosa = new Servicos("Tosa", 0.0);
    Servicos Massagem = new Servicos("Massagem", 0.0);
    
        try {
            repositorio.save(Diaria);
            repositorio.save(Banho);
            repositorio.save(Tosa);
            repositorio.save(Massagem);
        } catch (Exception e) {
        }
    
    
    }
}