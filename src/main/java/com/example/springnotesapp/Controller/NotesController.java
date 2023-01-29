package com.example.springnotesapp.Controller;

import com.example.springnotesapp.Persistence.Notes;
import com.example.springnotesapp.Persistence.NoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {

    private final NoteRepository noteRepository;

    public NotesController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    @GetMapping("/getNotes")
    public List<Notes> getAllNotes(){
        return noteRepository.readAllNotes();
    }

    @GetMapping("/getNote/{id}")
    public Notes getNoteByID(@PathVariable String id){
        System.out.println(id);
        return noteRepository.readByID(id);
    }

    @PostMapping("/addNote")
    public void addNote(@RequestBody Notes note){
        noteRepository.insertNote(note.getId(), note.getNoteTitle(), note.getNoteDate(), note.getNote());
    }

    @PutMapping("/updateNote")
    public void updateNoteByID(@RequestBody Notes note){
        noteRepository.updateNotes(note.getId(), note.getNoteTitle(), note.getNote());
    }

    @DeleteMapping("/deleteNote/{id}")
    public void deleteNoteByID(@PathVariable String id){
        noteRepository.deleteByID(id);
    }


}
