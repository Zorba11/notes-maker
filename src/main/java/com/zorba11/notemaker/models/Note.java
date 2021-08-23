package com.zorba11.notemaker.models;


import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    private Long id;
    private String title;
    private String details;
    private String category;
}
