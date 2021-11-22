package com.zorba11.notemaker.repositories;

import com.zorba11.notemaker.models.Note;
//import com.zorba11.notemaker.models.User;
import com.zorba11.notemaker.models.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

//@NoRepositoryBean
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("select case when count (n) > 0 then " +
            "true else false end " +
            "from Note n" +
            " where n.title = ?1")
    Boolean isTitleExist(String title);

    List<Note> findAllById(Long userId);

    @Query("select n from Note n")
    List<Note> findSomeStuff();

    @Query(value = "select * from notes n inner join user u on n.user_id = u.user_id where n.details like %:searchStr% "
            , nativeQuery = true)
    List<Note> findNotesWithSearchStr(String searchStr);

    @Query(value = "select n.id, n.category, n.details, n.title, n.user_id from notes n join user u on n.user_id = u.user_id and where n.details not like '%frisbee%'" +
            "and u.user_id=:user_id", nativeQuery = true)
    List<Note> findAllOtherNotesOfUsersWithStr(Long user_id);

    List<Note> findByDetailsContaining(String searchStr);

    @Query("select n from Note n where n.user = :user and n.details not like concat('%',:searchStr, '%')")
    List<Note> findAllNotesOfUserWithoutStr(User user, String searchStr);

}
