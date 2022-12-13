package com.plugatarev.planninganddoing.controllers;

import com.plugatarev.planninganddoing.entity.DoneNote;
import com.plugatarev.planninganddoing.mappers.DoneNoteMapper;
import com.plugatarev.planninganddoing.models.DoneNoteDTO;
import com.plugatarev.planninganddoing.models.TrashNoteDTO;
import com.plugatarev.planninganddoing.services.DoneNoteService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/done")
public class DoneController extends NoteController<DoneNote, DoneNoteDTO> {
    public DoneController(DoneNoteService service, DoneNoteMapper mapper) {
        super(service, mapper);
    }

    @GetMapping("/add")
    public String addNote(Model model) {
        model.addAttribute("done");
        return "add-note";
    }

    @PostMapping("/{id}/edit")
    public String editExecNote(@PathVariable("id") long id, @RequestBody TrashNoteDTO body) {
        Optional<DoneNote> optionalTrashNote = getService().getById(id);
        if (optionalTrashNote.isPresent()) {
            DoneNote note = optionalTrashNote.get();
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
