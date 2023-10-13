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

/**
 *
 * @author 14892160652
 */

@Data
public class PetDAO implements IDao {
    
    
  
    private String sql;
    
    public PetDAO(){
        this.sql = "";
    }
    
    @Override
    public void save(Object obj){
        
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
