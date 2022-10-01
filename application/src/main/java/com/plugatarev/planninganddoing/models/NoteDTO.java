package com.plugatarev.planninganddoing.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Getter
public abstract class MarkDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String anons;

    @NotEmpty
    private String fullText;
}
