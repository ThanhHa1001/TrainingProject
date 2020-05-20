package service;

import java.util.List;

public interface IGenericService<E, K> {
    List<E> findAll();
    E findById(K value);
    int insert(E entity);
    int update(E entity);
    int delete(K value);
}