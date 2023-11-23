/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.model.dao.contracts;

import java.util.List;

/**
 *
 * @author vitor
 */
public interface IDao<T> {
    void save(T obj);
    void update(T obj);
    boolean delete(T obj);
    T find (int id);
    List<T> findAll();
}
