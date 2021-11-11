package com.zorba11.notemaker.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

//@ToString
@Getter
@Setter
//@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notes")
public class Note implements Serializable {

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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Note(String title, String details, String category) {
        this.title = title;
        this.details = details;
        this.category = category;
    }

//    @Override
//    public String toString() {
//        return "Note{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", details='" + details + '\'' +
//                ", category='" + category + '\'' +
//                ", user=" + user +
//                '}';
//    }
}
