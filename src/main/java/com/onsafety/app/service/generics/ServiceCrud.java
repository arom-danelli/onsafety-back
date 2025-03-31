package com.onsafety.app.service.generics;

import java.util.List;
import java.util.Optional;

public interface ServiceCrud<T> {
    T save(T entity);
    Optional<T> findById(Long id);
    List<T> findAll();
    void deleteById(Long id);
}
