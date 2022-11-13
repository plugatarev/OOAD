package com.plugatarev.planninganddoing.mappers;

import com.plugatarev.planninganddoing.entity.ExecutionNote;
import com.plugatarev.planninganddoing.models.ExecutionNoteDTO;

public class ExecutionNoteMapper implements NoteMapper<ExecutionNote, ExecutionNoteDTO> {
    @Override
    public ExecutionNote toEntity(ExecutionNoteDTO dtoNote) {
        return new ExecutionNote(
                dtoNote.getId(),
                dtoNote.getName(),
                dtoNote.getAnons(),
                dtoNote.getFullText(),
                dtoNote.getDeadline()
        );
    }

    @Override
    public ExecutionNoteDTO toDTO(ExecutionNote entityNote) {
        return new ExecutionNoteDTO(
                entityNote.getId(),
                entityNote.getName(),
                entityNote.getAnons(),
                entityNote.getFullText(),
                entityNote.getDeadline()
        );
    }
}
