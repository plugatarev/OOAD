package com.plugatarev.planninganddoing.controllers;

import com.plugatarev.planninganddoing.entity.Note;
import com.plugatarev.planninganddoing.mappers.NoteMapper;
import com.plugatarev.planninganddoing.models.NoteDTO;
import com.plugatarev.planninganddoing.services.CrudService;
import lombok.Getter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Getter
public abstract class NoteController <T extends Note, D extends NoteDTO> {
    private final CrudService<T> service;
    private final NoteMapper<T, D> abstractMapper;

    protected NoteController(CrudService<T> service, NoteMapper<T, D> abstractMapper) {
        this.service = service;
        this.abstractMapper = abstractMapper;
    }

    @PostMapping("/add")
    public String addNote(@RequestBody D dto) {
        service.add(abstractMapper.toEntity(dto));
        return "redirect:/main";
    }

    @GetMapping("/{id}")
    public String getNote(Model model, @PathVariable("id") long id) {
        Optional<T> note = service.getById(id);
        if (note.isPresent()) {
            D dto = abstractMapper.toDTO(note.get());
            model.addAttribute("name", dto.getName());
            model.addAttribute("anons", dto.getAnons());
            model.addAttribute("name", dto.getFullText());
            return "show-note";
        }
        else {
            return "note-not-found";
        }
    }

    @GetMapping("/{id}/edit")
    public String editNote(@PathVariable("id") long id) {
        return "edit-note";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/main";
    }
}
