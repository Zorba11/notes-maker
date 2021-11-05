package com.zorba11.notemaker.models;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue
    private Long note_id;
    @NotNull
    @Column(nullable = false, unique = true)
    private String title;
    @NotNull
    private String details;
    @NotNull
    private String category;

    public Note(String title, String details, String category) {
        this.title = title;
        this.details = details;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
