package com.plugatarev.planninganddoing.mappers;

import com.plugatarev.planninganddoing.entity.Note;
import com.plugatarev.planninganddoing.models.NoteDTO;
import org.springframework.stereotype.Component;

@Component
public interface NoteMapper <T extends Note, E extends NoteDTO> {
    T toEntity(E dtoNote);
    E toDTO(T entityNote);
}
