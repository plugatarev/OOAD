package com.plugatarev.planninganddoing.services;

import com.plugatarev.planninganddoing.entity.Note;

import java.util.Optional;

public abstract class NoteService<T extends Note> implements CrudService<T> {
    @Override
    public void add(T entity) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public Optional<T> getById(long id) {
        return Optional.empty();
    }
}
