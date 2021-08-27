package com.zorba11.notemaker.controllers;

import com.zorba11.notemaker.models.Note;
import com.zorba11.notemaker.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/notes")
public class NotesController {

    @Autowired
    public NoteService noteService;


    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping
    public String addNote(@RequestBody Note note) {
        return noteService.addNote(note);
    }

    @DeleteMapping(value = "/{id}")
    public String removeNote(@PathVariable Long id) {
        return noteService.removeNote(id);
    }
}
