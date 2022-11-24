package com.plugatarev.planninganddoing.services;

import com.plugatarev.planninganddoing.entity.DoneNote;
import com.plugatarev.planninganddoing.repositories.DoneNoteRepository;
import org.springframework.stereotype.Service;

@Service
public class DoneNoteService extends NoteService<DoneNote> {
    public DoneNoteService(DoneNoteRepository repository) {
        super(repository);
    }
}
