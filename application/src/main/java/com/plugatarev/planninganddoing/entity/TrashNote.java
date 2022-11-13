package com.plugatarev.planninganddoing.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity(name="TrashNote")
@Getter
@Setter
public class TrashNote extends Note {
    private Date deadline;

    public TrashNote(@NotEmpty Long id, @NotEmpty String name, @NotEmpty String anons, @NotEmpty String fullText, @NotEmpty Date deadline) {
        super(id, name, anons, fullText);
        this.deadline = deadline;
    }

    public TrashNote() {

    }
}
