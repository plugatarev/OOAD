package com.plugatarev.planninganddoing.repositories;

import com.plugatarev.planninganddoing.entity.DoneNote;
import org.springframework.stereotype.Repository;

@Repository
public interface DoneNoteRepository extends NoteRepository<DoneNote> {
}
