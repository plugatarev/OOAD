package com.plugatarev.planninganddoing.controllers;

import com.plugatarev.planninganddoing.entity.TrashNote;
import com.plugatarev.planninganddoing.mappers.NoteMapper;
import com.plugatarev.planninganddoing.models.TrashNoteDTO;
import com.plugatarev.planninganddoing.services.CrudService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/trash")
public class TrashController extends NoteController<TrashNote, TrashNoteDTO> {
    public TrashController(CrudService<TrashNote> service, NoteMapper<TrashNote, TrashNoteDTO> abstractMapper) {
        super(service, abstractMapper);
    }

    @PostMapping("/{id}/edit")
    public String editTrashNote(@PathVariable("id") long id, @RequestBody TrashNoteDTO body) {
        Optional<TrashNote> optionalTrashNote = getService().getById(id);
        if (optionalTrashNote.isPresent()) {
            TrashNote note = optionalTrashNote.get();
            note.setDeadline(body.getDeadline());
            note.setAnons(body.getAnons());
            note.setFullText(body.getFullText());
            note.setName(body.getName());
            getService().update(note);
            return "redirect:/main";

        }
        return "trash-not-found";
    }
}
