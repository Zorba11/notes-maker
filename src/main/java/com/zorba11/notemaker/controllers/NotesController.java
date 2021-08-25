package com.zorba11.notemaker.controllers;

import com.zorba11.notemaker.models.Note;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/notes")
public class NotesController {

   private List<Note> notes = Arrays.asList(
            new Note(1L,"Note 1", "something 1", "Financial"),
            new Note(2L,"Note 2", "something 2","Work"),
            new Note(3L,"Note 3", "something 3", "Reminder"),
           new Note(4L,"Note 4", "something 4", "Todos")
    );


    @GetMapping
    public List<Note> getAllNotes() {
        return notes;
    }

    @PostMapping
    public void addNote(@RequestBody Note note) {
        List<Note> newNotes = new ArrayList<>(Arrays.asList(note));
        newNotes.addAll(notes);
        notes = newNotes;
    }

}
