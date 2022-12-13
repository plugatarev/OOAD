package com.plugatarev.planninganddoing.controllers;

import com.plugatarev.planninganddoing.entity.DoneNote;
import com.plugatarev.planninganddoing.entity.ExecutionNote;
import com.plugatarev.planninganddoing.entity.TrashNote;
import com.plugatarev.planninganddoing.repositories.DoneNoteRepository;
import com.plugatarev.planninganddoing.repositories.ExecutionNoteRepository;
import com.plugatarev.planninganddoing.repositories.TrashNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private static final String APPLICATION_NAME = "Planning&Doing";

    private final DoneNoteRepository doneRep;
    private final ExecutionNoteRepository execRep;
    private final TrashNoteRepository trashRep;

    @Autowired
    public MainController(DoneNoteRepository doneRep, ExecutionNoteRepository execRep, TrashNoteRepository trashRep) {
        this.doneRep = doneRep;
        this.execRep = execRep;
        this.trashRep = trashRep;
    }

    @GetMapping("/")
    public String home(Model model) {
        Iterable<DoneNote> doneNotes = doneRep.findAll();
        Iterable<TrashNote> trashNotes = trashRep.findAll();
        Iterable<ExecutionNote> executionNotes = execRep.findAll();

        model.addAttribute("title", APPLICATION_NAME);
        model.addAttribute("doneNotes", doneNotes);
        model.addAttribute("trashNotes", trashNotes);
        model.addAttribute("executionNotes", executionNotes);

        return "main";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About");
        return "about";
    }
}
