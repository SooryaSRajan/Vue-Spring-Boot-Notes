package com.example.springnotesapp.Persistence;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Entity
public class Notes {

    @Id
    //16 char uudi
    private String id = UUID.randomUUID().toString().substring(0, 16);

    private String note;
    private String noteTitle;
    private String noteDate;

    public Notes() {
    }

    public Notes(String note, String noteTitle, String noteDate) {
        this.note = note;
        this.noteTitle = noteTitle;
        this.noteDate = noteDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", noteTitle='" + noteTitle + '\'' +
                ", noteDate='" + noteDate + '\'' +
                '}';
    }
}
