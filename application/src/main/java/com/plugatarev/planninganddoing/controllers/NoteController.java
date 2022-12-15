package com.plugatarev.planninganddoing.controllers;

import com.plugatarev.planninganddoing.entity.DoneNote;
import com.plugatarev.planninganddoing.entity.ExecutionNote;
import com.plugatarev.planninganddoing.entity.Note;
import com.plugatarev.planninganddoing.entity.TrashNote;
import com.plugatarev.planninganddoing.mappers.NoteMapper;
import com.plugatarev.planninganddoing.models.NoteDTO;
import com.plugatarev.planninganddoing.services.CrudService;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Getter
@Controller
public abstract class NoteController <T extends Note, D extends NoteDTO> {
    private final CrudService<T> service;
    private final NoteMapper<T, D> abstractMapper;

    protected NoteController(CrudService<T> service, NoteMapper<T, D> abstractMapper) {
        this.service = service;
        this.abstractMapper = abstractMapper;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/";
    }

    static Date getNewDate(String deadline, Note note) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            return formatter.parse(deadline);
        }
        catch (ParseException e) {
            if (note instanceof DoneNote) return ((DoneNote) note).getDeadline();
            if (note instanceof TrashNote) return ((TrashNote) note).getDeadline();
            if (note instanceof ExecutionNote) return ((ExecutionNote) note).getDeadline();
            throw new IllegalStateException("Invalid note type");
        }
    }
}
