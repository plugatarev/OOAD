package com.plugatarev.planninganddoing.controllers;

import com.plugatarev.planninganddoing.entity.TrashNote;
import com.plugatarev.planninganddoing.mappers.NoteMapper;
import com.plugatarev.planninganddoing.models.TrashNoteDTO;
import com.plugatarev.planninganddoing.services.CrudService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/trash")
public class TrashController extends NoteController<TrashNote, TrashNoteDTO> {
    public TrashController(CrudService<TrashNote> service, NoteMapper<TrashNote, TrashNoteDTO> abstractMapper) {
        super(service, abstractMapper);
    }

    @GetMapping("/add")
    public String addNote(Model model) {
        model.addAttribute("table", "trash/add");
        return "add-trash-note";
    }

    @PostMapping("/add")
    public String postAdd(@RequestParam("name") String name, @RequestParam("anons") String anons,
                       @RequestParam("fullText") String fullText, @RequestParam("deadline") String deadline) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        TrashNote entity = new TrashNote(name, anons, fullText, formatter.parse(deadline));
        getService().add(entity);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getTrashNote(Model model, @PathVariable("id") long id) {
        Optional<TrashNote> note = getService().getById(id);
        if (note.isPresent()) {
            TrashNoteDTO dto = getAbstractMapper().toDTO(note.get());
            model.addAttribute("name", dto.getName());
            model.addAttribute("anons", dto.getAnons());
            model.addAttribute("text", dto.getFullText());
            model.addAttribute("deadline", dto.getDeadline());
            return "show-note";
        }
        else {
            return "note-not-found";
        }
    }

    @GetMapping("/edit/{id}")
    public String editNote(@PathVariable(value = "id") long id, Model model) {
        Optional<TrashNote> note = getService().getById(id);
        model.addAttribute("note", note.orElseThrow());
        return "edit-note";
    }

    @PostMapping("/edit/{id}")
    public String editTrashNote(@PathVariable("id") long id,
                                @RequestParam("name") String name, @RequestParam("anons") String anons,
                                @RequestParam("fullText") String fullText, @RequestParam("deadline") String deadline) {
        Optional<TrashNote> optionalTrashNote = getService().getById(id);
        if (optionalTrashNote.isPresent()) {
            TrashNote note = optionalTrashNote.get();
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
