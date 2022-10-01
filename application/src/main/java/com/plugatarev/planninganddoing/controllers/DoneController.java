package com.plugatarev.planninganddoing.controllers;

import com.plugatarev.planninganddoing.entity.DoneNote;
import com.plugatarev.planninganddoing.mappers.DoneNoteMapper;
import com.plugatarev.planninganddoing.models.DoneNoteDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/done")
public class DoneController extends NoteController<DoneNote, DoneNoteDTO> {
    protected DoneController(DoneNoteMapper service, DoneNoteMapper mapper) {
        super(service, mapper);
    }
}
