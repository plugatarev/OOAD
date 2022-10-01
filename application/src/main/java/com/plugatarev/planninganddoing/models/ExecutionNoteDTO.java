package com.plugatarev.planninganddoing.models;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class ExecutionNoteDTO extends NoteDTO {
    private Date deadline;

    public ExecutionNoteDTO(@NotEmpty String name, @NotEmpty String anons, @NotEmpty String fullText, Date deadline) {
        super(name, anons, fullText);
        this.deadline = deadline;
    }
}