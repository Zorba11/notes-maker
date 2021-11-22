package com.zorba11.notemaker.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zorba11.notemaker.models.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
@Setter
public class NoteDTO implements Serializable{
    public Long id;
    public String title;
    public String details;
    public String category;
    public User user;
}
