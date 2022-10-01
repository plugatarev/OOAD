package com.plugatarev.planninganddoing.mappers;

import com.plugatarev.planninganddoing.entity.Note;
import com.plugatarev.planninganddoing.entity.TrashNote;
import com.plugatarev.planninganddoing.models.NoteDTO;
import com.plugatarev.planninganddoing.models.TrashNoteDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class TrashNoteMapper implements NoteMapper<TrashNote, TrashNoteDTO> {

    @Override
    public TrashNote toEntity(TrashNoteDTO dtoNote) {
        return null;
    }

    @Override
    public TrashNoteDTO toDTO(TrashNote entityNote) {
        return null;
    }
}
