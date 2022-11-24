package com.plugatarev.planninganddoing.repositories;

import com.plugatarev.planninganddoing.models.DoneNoteDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface DoneNoteRepository extends NoteRepository<DoneNoteDTO> {
}
