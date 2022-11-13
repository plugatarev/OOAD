package com.plugatarev.planninganddoing.services;

import com.plugatarev.planninganddoing.entity.ExecutionNote;
import com.plugatarev.planninganddoing.repositories.NoteRepository;
import org.springframework.stereotype.Service;

@Service
public class ExecutionNoteService extends NoteService<ExecutionNote> {
    public ExecutionNoteService(NoteRepository<ExecutionNote> repository) {
        super(repository);
    }
}
