package com.plugatarev.planninganddoing.models;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class DoneMarkDTO extends MarkDTO {
    Date dataExecution;

    public DoneMarkDTO(@NotEmpty String name, @NotEmpty String anons, @NotEmpty String fullText, Date dataExecution) {
        super(name, anons, fullText);
        this.dataExecution = dataExecution;
    }
}
