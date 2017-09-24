package com.tada;

import java.util.List;

public interface DAOInterface<T> {
    public List<T> findAll();
    public T findById(int id);
    public int insert(T object);
    public int update(T object);
    public int delete(int id);
}
