package com.plugatarev.planninganddoing.services;

import com.plugatarev.planninganddoing.entity.TrashNote;
import com.plugatarev.planninganddoing.repositories.NoteRepository;

public class TrashNoteService extends NoteService<TrashNote> {
    public TrashNoteService(NoteRepository<TrashNote> repository) {
        super(repository);
    }
}
