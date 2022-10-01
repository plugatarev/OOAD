package com.plugatarev.planninganddoing.controllers;

import com.plugatarev.planninganddoing.entity.Note;
import com.plugatarev.planninganddoing.mappers.NoteMapper;
import com.plugatarev.planninganddoing.models.NoteDTO;
import com.plugatarev.planninganddoing.services.CrudService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Getter
public abstract class NoteController <T extends Note, D extends NoteDTO> {
    private final CrudService<T> service;
    private final NoteMapper<T, D> abstractMapper;

    protected NoteController(CrudService<T> service, NoteMapper<T, D> abstractMapper) {
        this.service = service;
        this.abstractMapper = abstractMapper;
    }

    @PostMapping()
    public @ResponseBody
    ResponseEntity<T> create(@RequestBody D dto) {
        service.add(abstractMapper.toEntity(dto));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> get(@PathVariable("id") int id) {
        T entity = service.getById(id).orElseThrow(() ->
                new IllegalStateException("Note with id: {" + id + "} not found."));
        return new ResponseEntity<>(abstractMapper.toDTO(entity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Note with id: {" + id + "} was deleted.", HttpStatus.OK);
    }
}
