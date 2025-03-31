package com.onsafety.app.service.generics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class GenericService<T, ID> implements ServiceCrud<T> {

    private final JpaRepository<T, ID> repository;

    public GenericService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    protected JpaRepository<T, ID> getRepository() {
        return repository;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<T> findById(Long id) {
        return repository.findById((ID) id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById((ID) id);
    }
}
