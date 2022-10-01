package com.plugatarev.planninganddoing.models;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class ExecutionMarkDTO extends MarkDTO {
    private Date dataExecution;

    public ExecutionMarkDTO(@NotEmpty String name, @NotEmpty String anons, @NotEmpty String fullText, Date dataExecution) {
        super(name, anons, fullText);
        this.dataExecution = dataExecution;
    }
}