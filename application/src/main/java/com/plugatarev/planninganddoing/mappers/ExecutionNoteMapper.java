package com.plugatarev.planninganddoing.mappers;

import com.plugatarev.planninganddoing.entity.ExecutionNote;
import com.plugatarev.planninganddoing.models.ExecutionNoteDTO;

public class ExecutionNoteMapper implements NoteMapper<ExecutionNote, ExecutionNoteDTO> {
    @Override
    public ExecutionNote toEntity(ExecutionNoteDTO dtoNote) {
        return null;
    }

    @Override
    public ExecutionNoteDTO toDTO(ExecutionNote entityNote) {
        return null;
    }
}
