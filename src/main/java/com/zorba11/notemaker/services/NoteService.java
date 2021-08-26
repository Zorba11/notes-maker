package com.zorba11.notemaker.services;

import com.zorba11.notemaker.models.Note;
import com.zorba11.notemaker.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public String addNote(Note note) {
        noteRepository.save(note);
        return "Note created succesfully!";
    }

    public String removeNote(Long id) {
        noteRepository.deleteById(id);
        return "Note deleted!";
    }
}
