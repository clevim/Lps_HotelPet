
package com.clevervitor.hotelpet.model;

import java.util.List;


public interface IDao {
    
    public void save(Object obj);
    
    public boolean delete(Integer id);
                
    public Object find(Integer id);
        
    public List<Object> findAll();
}
