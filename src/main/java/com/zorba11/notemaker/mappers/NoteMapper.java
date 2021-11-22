package com.zorba11.notemaker.mappers;

import com.zorba11.notemaker.dtos.NoteDTO;
import com.zorba11.notemaker.models.Note;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {

    @Autowired
    private ModelMapper modelMapper;

    public NoteDTO convertEntityToDTO(Note note) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        NoteDTO noteDTO = new NoteDTO();

        noteDTO = modelMapper.map(note, NoteDTO.class);

        return noteDTO;
    }

    public Note convertDtoToEntity(NoteDTO noteDTO) {

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        Note note = new Note();
        note = modelMapper.map(noteDTO, Note.class);

        return note;
    }
}
