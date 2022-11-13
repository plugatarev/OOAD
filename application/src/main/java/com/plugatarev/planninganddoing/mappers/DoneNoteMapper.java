package com.plugatarev.planninganddoing.mappers;

import com.plugatarev.planninganddoing.entity.DoneNote;
import com.plugatarev.planninganddoing.models.DoneNoteDTO;

public class DoneNoteMapper implements NoteMapper<DoneNote, DoneNoteDTO> {
    @Override
    public DoneNote toEntity(DoneNoteDTO dtoNote) {
        return new DoneNote(
                dtoNote.getId(),
                dtoNote.getName(),
                dtoNote.getAnons(),
                dtoNote.getFullText(),
                dtoNote.getDeadline()
        );
    }

    @Override
    public DoneNoteDTO toDTO(DoneNote entityNote) {
        return new DoneNoteDTO(
                entityNote.getId(),
                entityNote.getName(),
                entityNote.getAnons(),
                entityNote.getFullText(),
                entityNote.getDeadline()
        );
    }
}
