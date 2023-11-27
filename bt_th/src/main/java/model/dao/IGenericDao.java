package model.dao;

import java.util.List;

public interface IGenericDao<T,ID> {
    List<T> findAll();
    boolean addOrEdit(T t);
    void delete(ID id);
    T findById(ID id);
}
