package com.zorba11.notemaker.services;

import com.zorba11.notemaker.dtos.NoteDTO;
import com.zorba11.notemaker.exceptions.BadRequestException;
import com.zorba11.notemaker.models.Note;
import com.zorba11.notemaker.repositories.NoteRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<NoteDTO> getAllNotes() {
       /* return noteRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
*/
    return null;}


    public String addNote(NoteDTO noteDTO) {
        Boolean titleExist = noteRepository.isTitleExist(noteDTO.getTitle());

        if (titleExist)
            throw new BadRequestException( "Title " + noteDTO.getTitle() + " already in use");

        Note note = null;//convertDtoToEntity(noteDTO);

        noteRepository.save(note);
        return "Note created succesfully!";
    }

    public String removeNote(Long id) {
        noteRepository.deleteById(id);
        return "Note deleted!";
    }

}
