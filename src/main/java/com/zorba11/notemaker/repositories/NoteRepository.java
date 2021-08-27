package com.zorba11.notemaker.repositories;

import com.zorba11.notemaker.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("select case when count (n) > 0 then " +
            "true else false end " +
            "from Note n" +
            " where n.title = ?1")
    Boolean isTitleExist(String title);
}
