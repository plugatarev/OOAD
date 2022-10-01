package com.plugatarev.planninganddoing.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity(name="ExecutionNote")
@Getter
@Setter
public class ExecutionNote extends Note {
    @Column
    private Date deadline;

    public ExecutionNote(@NotEmpty Long id, @NotEmpty String name, @NotEmpty String anons, @NotEmpty String fullText, @NotEmpty Date deadline) {
        super(id, name, anons, fullText);
        this.deadline = deadline;
    }

    public ExecutionNote() {

    }
}
