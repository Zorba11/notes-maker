package com.zorba11.notemaker.repositories;

import com.zorba11.notemaker.models.Note;
//import com.zorba11.notemaker.models.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("select case when count (n) > 0 then " +
            "true else false end " +
            "from Note n" +
            " where n.title = ?1")
    Boolean isTitleExist(String title);

    List<Note> findAllById(Long userId);

//    List<Note> findByUser(User user, Sort sort);

//    void save(Note note, User user);
}
