package com.goit.GoIT2_HW_17.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public List<Note> listAll() {

        return noteRepository.findAll();
    }

    public Note add(Note note) {
        int noteId;
        do {
            noteId = NoteIdGenerator.generateId();
        } while (listAll().stream().map(Note::getId).toList().contains(noteId));

        note.setId(noteId);
        noteRepository.save(note);
        return note;
    }

    public void deleteById(int id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        noteRepository.save(note);
    }

    public Note getById(int id) {
        return noteRepository.findById(id).get();
    }
}
