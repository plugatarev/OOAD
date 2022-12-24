package com.plugatarev.planninganddoing.controllers;

import com.plugatarev.planninganddoing.entity.DoneNote;
import com.plugatarev.planninganddoing.mappers.DoneNoteMapper;
import com.plugatarev.planninganddoing.models.DoneNoteDTO;
import com.plugatarev.planninganddoing.services.DoneNoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/done")
public class DoneController extends NoteController<DoneNote, DoneNoteDTO> {
    public DoneController(DoneNoteService service, DoneNoteMapper mapper) {
        super(service, mapper);
    }

    @GetMapping("/{id}")
    public String getTrashNote(Model model, @PathVariable("id") long id) {
        Optional<DoneNote> note = getService().getById(id);
        if (note.isPresent()) {
            DoneNoteDTO dto = getAbstractMapper().toDTO(note.get());
            model.addAttribute("name", dto.getName());
            model.addAttribute("anons", dto.getAnons());
            model.addAttribute("text", dto.getFullText());
            model.addAttribute("deadline", dto.getDeadline());
            return "show-note";
        }
        return "note-not-found";
    }

    @GetMapping("/edit/{id}")
    public String editNote(@PathVariable(value = "id") long id, Model model) {
        Optional<DoneNote> note = getService().getById(id);
        model.addAttribute("note", note.orElseThrow());
        return "edit-note";
    }

    @PostMapping("/edit/{id}")
    public String editTrashNote(@PathVariable("id") long id,
                                @RequestParam("name") String name, @RequestParam("anons") String anons,
                                @RequestParam("fullText") String fullText, @RequestParam("deadline") String deadline) {

        Optional<DoneNote> optionalTrashNote = getService().getById(id);
        if (optionalTrashNote.isPresent()) {
            DoneNote note = optionalTrashNote.get();
            note.setDeadline(getNewDate(deadline, note));
            note.setAnons(anons);
            note.setFullText(fullText);
            note.setName(name);
            getService().update(note);
            return "redirect:/";

        }
        return "trash-not-found";
    }
}
