package com.plugatarev.planninganddoing.repositories;

import com.plugatarev.planninganddoing.models.TrashNoteDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface TrashNoteRepository extends NoteRepository<TrashNoteDTO> {
}
