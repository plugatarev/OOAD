package com.plugatarev.planninganddoing.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@Getter
@Setter
public abstract class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String anons;
    private String fullText;

    public Note(String name, String anons, String fullText) {
        this.name = name;
        this.anons = anons;
        this.fullText = fullText;
    }

    public Note() {

    }
}
