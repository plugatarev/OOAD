package com.plugatarev.planninganddoing.models;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class TrashNoteDTO extends NoteDTO {
    private Date deadline;

    public TrashNoteDTO(@NotEmpty String name, @NotEmpty String anons, @NotEmpty String fullText, Date deadline) {
        super(name, anons, fullText);
        this.deadline = deadline;
    }
}
