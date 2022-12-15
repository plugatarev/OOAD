package com.plugatarev.planninganddoing.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity(name="DoneNote")
@Getter
@Setter
public class DoneNote extends Note {
    private Date deadline;

    public DoneNote(@NotEmpty Long id, @NotEmpty String name, @NotEmpty String anons, @NotEmpty String fullText, @NotEmpty Date deadline) {
        super(id, name, anons, fullText);
        this.deadline = deadline;
    }

    public DoneNote() {

    }

    public DoneNote(String name, String anons, String fullText, Date deadline) {
        super(name, anons, fullText);
        this.deadline = deadline;
    }
}
