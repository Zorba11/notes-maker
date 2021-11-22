package com.zorba11.notemaker.controllers;

import com.zorba11.notemaker.dtos.NoteDTO;
import com.zorba11.notemaker.models.Note;
import com.zorba11.notemaker.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/notes")
public class NotesController {

//    Issues with input validation - empty note creation, might be a UI issue or DB config issue - need to investigate and fix
//    should add UI notifications for server responses for POST & DELETE
//    should add UI notification for duplicate titles

    @Autowired
    public NoteService noteService;


    @GetMapping
    public List<NoteDTO> getAllNotes() {
        System.out.println("hi from getall notes");
        return noteService.getAllNotes();
    }

    @PostMapping
    public String addNote(@Valid @RequestBody NoteDTO noteDTO) {
        return noteService.addNote(noteDTO);
    }

    @DeleteMapping(value = "/{id}")
    public String removeNote(@PathVariable Long id) {
        return noteService.removeNote(id);
    }
}
