package com.plugatarev.planninganddoing.repositories;

import com.plugatarev.planninganddoing.models.ExecutionNoteDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutionNoteRepository extends NoteRepository<ExecutionNoteDTO> {
}
