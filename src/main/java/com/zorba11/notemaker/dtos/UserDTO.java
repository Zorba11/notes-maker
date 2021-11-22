package com.zorba11.notemaker.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zorba11.notemaker.models.Note;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserDTO implements Serializable {

    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public List<NoteDTO> notes;
}
