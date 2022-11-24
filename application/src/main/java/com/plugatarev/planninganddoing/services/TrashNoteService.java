package com.plugatarev.planninganddoing.services;

import com.plugatarev.planninganddoing.entity.TrashNote;
import com.plugatarev.planninganddoing.repositories.TrashNoteRepository;
import org.springframework.stereotype.Service;

@Service
public class TrashNoteService extends NoteService<TrashNote> {
    public TrashNoteService(TrashNoteRepository repository) {
        super(repository);
    }
}
