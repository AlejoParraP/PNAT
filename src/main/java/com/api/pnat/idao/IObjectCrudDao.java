package com.api.pnat.idao;

import java.util.List;

public interface IObjectCrudDao<T> {
    public List<T> findAll();

    public void save(T o);

    public Object findById(Long id);

    public void delete(Long id);
}
