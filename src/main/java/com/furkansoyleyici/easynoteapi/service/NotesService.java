package com.furkansoyleyici.easynoteapi.service;

import com.furkansoyleyici.easynoteapi.model.Notes;
import com.furkansoyleyici.easynoteapi.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;

    public List<Notes> getAllNotes() {
        return notesRepository.findAll();
    }

    public Notes saveNote(Notes note) {
        return notesRepository.save(note);
    }

    public void deleteNote(int id) {
        notesRepository.deleteById(id);
    }

    public Notes getNoteById(int id) {
        Optional<Notes> optionalNote = notesRepository.findById(id);
        return optionalNote.orElse(null);
    }

    public List<Notes> getNotesByPriorityDesc() {
        return notesRepository.findAllByOrderByPriorityDesc();
    }

    public List<Notes> getNotesByPriorityAsc() {
        return notesRepository.findAllByOrderByPriorityAsc();
    }

    public List<Notes> getFavouriteNotes() {
        return notesRepository.findByIsFavoriteTrue();
    }
}
