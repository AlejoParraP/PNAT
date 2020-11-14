package com.api.pnat.idao;

public interface IQueryObject<T>{
    public T findByCode(Integer cod);
}
