package com.furkansoyleyici.easynoteapi.controller;

import com.furkansoyleyici.easynoteapi.model.Notes;
import com.furkansoyleyici.easynoteapi.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "*")
public class NotesController {

    @Autowired
    private NotesService notesService;

    @GetMapping
    public List<Notes> getAllNotes() {
        return notesService.getAllNotes();
    }

    @GetMapping("/{id}")
    public Notes getNoteById(@PathVariable int id) {
        return notesService.getNoteById(id);
    }

    @PostMapping
    public Notes createNote(@RequestBody Notes note) {
        return notesService.saveNote(note);
    }

    @PutMapping("/{id}")
    public Notes updateNote(@PathVariable int id, @RequestBody Notes note) {
        return notesService.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable int id) {
        notesService.deleteNote(id);
    }

    @GetMapping("/priority-desc")
    public List<Notes> getNotesHighToLow() {
        return notesService.getNotesByPriorityDesc();
    }

    @GetMapping("/priority-asc")
    public List<Notes> getNotesLowToHigh() {
        return notesService.getNotesByPriorityAsc();
    }

    @GetMapping("/favorites")
    public List<Notes> getFavouriteNotes() {
        return notesService.getFavouriteNotes();
    }

    @GetMapping("/search")
    public List<Notes> searchNotes(@RequestParam("q") String query) {
        return notesService.searchNotes(query);
    }
}
