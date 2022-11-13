package com.plugatarev.planninganddoing.models;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
public class DoneNoteDTO extends NoteDTO {
    Date deadline;

    public DoneNoteDTO(@NotEmpty Long id, @NotEmpty String name, @NotEmpty String anons, @NotEmpty String fullText, Date deadline) {
        super(id, name, anons, fullText);
        this.deadline = deadline;
    }
}
