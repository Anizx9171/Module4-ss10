package model.service;

import model.entity.Category;

import java.util.List;

public interface IGenericService<T, ID> {
    List<T> findAll();

    boolean saveOrUpdate(T t, ID id);

    T findById(ID id);

    void delete(ID id);
    List<T> findByName(String name);

}
