package com.plugatarev.planninganddoing.models;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class DoneNoteDTO extends NoteDTO {
    Date deadline;

    public DoneNoteDTO(@NotEmpty String name, @NotEmpty String anons, @NotEmpty String fullText, Date deadline) {
        super(name, anons, fullText);
        this.deadline = deadline;
    }
}
