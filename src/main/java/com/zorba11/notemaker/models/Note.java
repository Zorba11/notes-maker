package com.zorba11.notemaker.models;


import lombok.*;

import javax.persistence.*;

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
    private String title;
    private String details;
    private String category;
}
