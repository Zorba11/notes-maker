package com.zorba11.notemaker.dtos;

import com.zorba11.notemaker.models.Note;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<NoteDTO> notes;
}
