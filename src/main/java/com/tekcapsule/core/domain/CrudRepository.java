package com.tekcapsule.core.domain;

import java.util.List;

public interface CrudRepository<T, ID> {

    T findBy( ID id);

    List<T> findAll();

    T save(T entity);

    void delete( ID id);

}
