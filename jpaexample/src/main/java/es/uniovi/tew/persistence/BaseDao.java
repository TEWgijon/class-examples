package es.uniovi.tew.persistence;

import java.util.List;

public interface BaseDao<T> {
    void save(T obj);

    void remove(T obj);

    List<T> findAll();
}
