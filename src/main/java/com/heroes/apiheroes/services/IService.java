package com.heroes.apiheroes.services;

import java.util.List;

public interface IService<T,ID>{
    List<T> findAll();
    T findById(ID id);
    void delete(T entity);
    void deleteById(ID id);
    void save(T entity);
    void update(T entity);
}
