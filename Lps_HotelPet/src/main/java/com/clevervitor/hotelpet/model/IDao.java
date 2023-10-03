
package com.clevervitor.hotelpet.model;

import java.util.List;


public interface IDao {
    
    public void save(Object obj);
    
    public boolean delete(Object obj);
            
    public Object find(Object obj);
        
    public List<Object> findAll();
}
