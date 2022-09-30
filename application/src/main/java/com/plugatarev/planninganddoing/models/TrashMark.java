package com.plugatarev.planninganddoing.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "TrashMarkTable")
public class TrashMark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String anons;
    private String fullText;
    private Date dataExecution;
}
