package com.example.springnotesapp.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface NoteRepository extends JpaRepository<Notes, String> {

    @Query(value = "INSERT INTO notes VALUES (:id, :title, str_to_date(:date,'%m-%d-%Y'), :note)", nativeQuery = true)
    @Modifying
    void insertNote(@Param("id") String id, @Param("title") String title, @Param("date") String date, @Param("note") String note);

    @Query(value = "SELECT * FROM notes", nativeQuery = true)
    List<Notes> readAllNotes();

    @Query(value = "SELECT * FROM notes WHERE id = :id", nativeQuery = true)
    Notes readByID(@Param("id") String id);

    @Query(value = "UPDATE notes SET note_title = :title, note = :note WHERE id = :id", nativeQuery = true)
    @Modifying
    void updateNotes(@Param("id") String id, @Param("title") String title, @Param("note") String note);

    @Query(value = "DELETE FROM notes WHERE id = :id", nativeQuery = true)
    @Modifying
    void deleteByID(@Param("id") String id);

}
