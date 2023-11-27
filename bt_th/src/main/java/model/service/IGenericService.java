package model.service;

import java.util.List;

public interface IGenericService<T,ID> {
    List<T> findAll();
    boolean addOrEdit(T t);
    void delete(ID id);
    T findById(ID id);
}
