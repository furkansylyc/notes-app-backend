package com.furkansoyleyici.easynoteapi.service;

import com.furkansoyleyici.easynoteapi.model.Notes;
import com.furkansoyleyici.easynoteapi.repository.NotesRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private NotesRepository notesRepository;

    public List<Notes> getAllNotes() {
        return notesRepository.findAll();
    }

    public Notes saveNote(Notes note) {
        Notes savedNote = notesRepository.save(note);
        String message = "Yeni not eklendi: " + savedNote.getTitle();
        rabbitTemplate.convertAndSend("noteQueue", message);
        return savedNote;
    }

    public Notes updateNote(int id, Notes note) {
        note.setId(id);
        Notes updatedNote = notesRepository.save(note);
        String message = "Not güncellendi: " + updatedNote.getTitle();
        rabbitTemplate.convertAndSend("noteQueue", message);
        return updatedNote;
    }

    public void deleteNote(int id) {
        Optional<Notes> noteOpt = notesRepository.findById(id);
        if (noteOpt.isPresent()) {
            Notes deletedNote = noteOpt.get();
            notesRepository.deleteById(id);
            String message = "Not silindi: " + deletedNote.getTitle();
            rabbitTemplate.convertAndSend("noteQueue", message);
        }
    }

    public Notes getNoteById(int id) {
        Optional<Notes> optionalNote = notesRepository.findById(id);
        return optionalNote.orElse(null);
    }

    public List<Notes> searchNotes(String keyword) {
        return notesRepository.findByTitleContainingIgnoreCase(keyword);
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
