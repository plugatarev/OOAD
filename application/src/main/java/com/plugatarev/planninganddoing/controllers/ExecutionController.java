package com.plugatarev.planninganddoing.controllers;

import com.plugatarev.planninganddoing.entity.ExecutionNote;
import com.plugatarev.planninganddoing.mappers.NoteMapper;
import com.plugatarev.planninganddoing.models.ExecutionNoteDTO;
import com.plugatarev.planninganddoing.models.TrashNoteDTO;
import com.plugatarev.planninganddoing.services.CrudService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/execution")
public class ExecutionController extends NoteController<ExecutionNote, ExecutionNoteDTO> {
    public ExecutionController(CrudService<ExecutionNote> service, NoteMapper<ExecutionNote, ExecutionNoteDTO> abstractMapper) {
        super(service, abstractMapper);
    }

    @GetMapping("/add")
    public String addNote(Model model) {
        model.addAttribute("execution");
        return "add-note";
    }

    @PostMapping("/{id}/edit")
    public String editExecNote(@PathVariable("id") long id, @RequestBody TrashNoteDTO body) {
        Optional<ExecutionNote> optionalTrashNote = getService().getById(id);
        if (optionalTrashNote.isPresent()) {
            ExecutionNote note = optionalTrashNote.get();
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
