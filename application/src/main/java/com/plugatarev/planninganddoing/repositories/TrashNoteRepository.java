package com.plugatarev.planninganddoing.repositories;

import com.plugatarev.planninganddoing.entity.TrashNote;
import org.springframework.stereotype.Repository;

@Repository
public interface TrashNoteRepository extends NoteRepository<TrashNote> {
}
