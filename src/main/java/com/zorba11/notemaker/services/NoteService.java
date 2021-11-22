package com.zorba11.notemaker.services;

import com.zorba11.notemaker.dtos.NoteDTO;
import com.zorba11.notemaker.exceptions.BadRequestException;
import com.zorba11.notemaker.mappers.NoteMapper;
import com.zorba11.notemaker.models.Note;
import com.zorba11.notemaker.repositories.NoteRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NoteMapper noteMapper;

    public List<NoteDTO> getAllNotes() {

        List<Note> notes = noteRepository.findAll();

        List<NoteDTO> notesDto = new ArrayList<>();

        notes.forEach(note -> notesDto.add(noteMapper.convertEntityToDTO(note)));

        return notesDto;
    }


    public String addNote(NoteDTO noteDTO) {
        Boolean titleExist = noteRepository.isTitleExist(noteDTO.getTitle());

        if (titleExist)
            throw new BadRequestException( "Title " + noteDTO.getTitle() + " already in use");

        Note note = noteMapper.convertDtoToEntity(noteDTO);

        noteRepository.save(note);
        return "Note created succesfully!";
    }

    public String removeNote(Long id) {
        noteRepository.deleteById(id);
        return "Note deleted!";
    }

}
