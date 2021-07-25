package com.tekcapsule.core.domain;

import java.util.List;

public interface CrudRepository<T, ID> {

    T findBy(ID tenantId, ID id);

    List<T> findAll(ID tenantId);

    T save(T entity);

    void delete(ID tenantId, ID id);

}
