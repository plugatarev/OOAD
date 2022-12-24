package com.plugatarev.planninganddoing.controllers;

import com.plugatarev.planninganddoing.entity.ExecutionNote;
import com.plugatarev.planninganddoing.mappers.NoteMapper;
import com.plugatarev.planninganddoing.models.ExecutionNoteDTO;
import com.plugatarev.planninganddoing.services.CrudService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/execution")
public class ExecutionController extends NoteController<ExecutionNote, ExecutionNoteDTO> {
    public ExecutionController(CrudService<ExecutionNote> service, NoteMapper<ExecutionNote, ExecutionNoteDTO> abstractMapper) {
        super(service, abstractMapper);
    }

    @GetMapping("/add")
    public String addNote(Model model) {
        model.addAttribute("table", "execution");
        return "add-execution-note";
    }

    @PostMapping("/add")
    public String postAdd(@RequestParam("name") String name, @RequestParam("anons") String anons,
                          @RequestParam("fullText") String fullText, @RequestParam("deadline") String deadline) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        ExecutionNote entity = new ExecutionNote(name, anons, fullText, formatter.parse(deadline));
        getService().add(entity);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getTrashNote(Model model, @PathVariable("id") long id) {
        Optional<ExecutionNote> note = getService().getById(id);
        if (note.isPresent()) {
            ExecutionNoteDTO dto = getAbstractMapper().toDTO(note.get());
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
        Optional<ExecutionNote> note = getService().getById(id);
        model.addAttribute("note", note.orElseThrow());
        return "edit-note";
    }

    @PostMapping("/edit/{id}")
    public String editTrashNote(@PathVariable("id") long id,
                                @RequestParam("name") String name, @RequestParam("anons") String anons,
                                @RequestParam("fullText") String fullText, @RequestParam("deadline") String deadline) {
        Optional<ExecutionNote> optionalTrashNote = getService().getById(id);
        if (optionalTrashNote.isPresent()) {
            ExecutionNote note = optionalTrashNote.get();
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
