package com.zorba11.notemaker.repositories;

import com.zorba11.notemaker.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
