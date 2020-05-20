package repository;

import java.util.List;

import util.ExceptionUtils;

public interface IGenericRepository<E, K> {
    List<E> findAll();
    E findById(K value);
    int insert(E entity);
    int update(E entity);
    int delete(K value) throws ExceptionUtils;
}