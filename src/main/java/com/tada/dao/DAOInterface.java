/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tada.dao;

import java.util.List;

/**
 *
 * @author erick
 */
public interface DAOInterface<T> {
    public List<T> findAll();
    public List<T> findById();
    public int insert(T object);
    public int update(T object);
    public int delete(T object);
}
