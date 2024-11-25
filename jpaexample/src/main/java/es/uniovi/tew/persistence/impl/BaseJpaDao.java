package es.uniovi.tew.persistence.impl;

import es.uniovi.tew.persistence.BaseDao;
import es.uniovi.tew.persistence.util.Jpa;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseJpaDao<T> implements BaseDao<T> {
    @Override
    public void save(T obj) {
        Jpa.getManager().persist(obj);
    }

    @Override
    public void remove(T obj) {
        Jpa.getManager().remove(obj);
    }

    @Override
    public List<T> findAll() {
        Class<T> type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        String entity = type.getTypeName();
        String query = "select o from " + entity + " o";

        return Jpa.getManager()
                .createQuery(query, type)
                .getResultList();
    }
}
