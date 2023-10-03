/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import lombok.Data;
import com.clevervitor.hotelpet.model.IDao;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.factory.Persistencia;
/**
 *
 * @author 14892160652
 */

@Data
public class PetDAO implements IDao {
    
    protected Connection connection;
    private PreparedStatement statement;
    private String sql;
    
    public PetDAO(){
        this.sql = "";
    }
    
    @Override
    public void save(Object obj){
        Pet pet = (Pet) obj;
        
        sql = " INSERT INTO "
                + " pet(nome,especie,raca,idade,genero,peso,infoDeSaude,proprietario)"
                + " VALUES(?,?,?,?,?,?,?,?) ";
        try { 
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, pet.getNome());
            statement.setString(2, pet.getEspecie());
            statement.setString(3, pet.getRaca());
            statement.setInt(4, pet.getIdade());
            statement.setString(5, pet.getGenero());
            statement.setDouble(6, pet.getPeso());
            statement.setString(7, pet.getInfoDeSaude());
            statement.setString(8, pet.getProprietario().getNome());
            
            statement.execute();
            statement.close();
        }catch (SQLException u){
            throw new RuntimeException(u);
        }finally{
            Persistencia.closeConnection();
        }
    }

    @Override
    public boolean delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object find(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
