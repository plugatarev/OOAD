package com.plugatarev.planninganddoing.mappers;

import com.plugatarev.planninganddoing.entity.DoneNote;
import com.plugatarev.planninganddoing.models.DoneNoteDTO;

public class DoneNoteMapper implements NoteMapper<DoneNote, DoneNoteDTO> {
    @Override
    public DoneNote toEntity(DoneNoteDTO dtoNote) {
        return null;
    }

    @Override
    public DoneNoteDTO toDTO(DoneNote entityNote) {
        return null;
    }
}
