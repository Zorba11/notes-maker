package com.zorba11.notemaker.controllers;

import com.zorba11.notemaker.models.Category;
import com.zorba11.notemaker.models.Note;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/notes")
public class NotesController {

    @GetMapping
    public List<Note> getAllNotes() {
        List<Note> notes = Arrays.asList(
                new Note(1L,"Note 1", "something 1", Category.FINANCIAL),
                new Note(2L,"Note 2", "something 2", Category.REMINDERS),
                new Note(3L,"Note 3", "something 3", Category.TODOS),
                new Note(4L,"Note 4", "something 4", Category.WORK)
        );

        return notes;
    }

    @PostMapping
    public void addNote(@RequestBody Note note) {
        List<Note> notes = Arrays.asList(note);
    }
}
