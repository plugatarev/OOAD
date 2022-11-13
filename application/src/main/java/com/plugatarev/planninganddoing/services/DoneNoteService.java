package com.plugatarev.planninganddoing.services;

import com.plugatarev.planninganddoing.entity.DoneNote;
import com.plugatarev.planninganddoing.repositories.NoteRepository;
import org.springframework.stereotype.Service;

@Service
public class DoneNoteService extends NoteService<DoneNote> {
    public DoneNoteService(NoteRepository<DoneNote> repository) {
        super(repository);
    }
}
