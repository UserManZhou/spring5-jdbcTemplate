package com.gec.jdbc.service;

import com.gec.jdbc.entity.Note;

import java.util.List;

public interface NoteService {

    void findNote();

    void insertNote(Note note);

    void deleteNote(Note note);

    void updateNote(Note note);

    void findCountNote();

    void findNoteObject(Note note);

    void findNoteList();

    void batchInsertNote(List<Object[]> list);

    void batchUpdateNote(List<Object[]> list);

    void batchDeleteNote(List<Object[]> list);

}
