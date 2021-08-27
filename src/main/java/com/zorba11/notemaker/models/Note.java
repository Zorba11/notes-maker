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
    private Long id;
    @NotNull
    @Column(nullable = false, unique = true)
    private String title;
    @NotNull
    private String details;
    @NotNull
    private String category;
}
