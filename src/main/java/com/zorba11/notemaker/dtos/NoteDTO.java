package com.zorba11.notemaker.dtos;

import com.zorba11.notemaker.models.User;
import lombok.Data;

@Data
public class NoteDTO {
    private Long id;
    private String title;
    private String details;
    private String category;
    private User user;
}
