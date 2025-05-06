package com.example.modul8_sqlite.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.modul8_sqlite.database.Note;
import com.example.modul8_sqlite.database.NoteDao;
import com.example.modul8_sqlite.database.NoteRoomDB;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository {
    private final NoteDao mNoteDao;
    private final ExecutorService executorService;

    public NoteRepository(Application application) {
        executorService = Executors.newSingleThreadExecutor();
        NoteRoomDB db = NoteRoomDB.getDatabase(application);
        mNoteDao = db.noteDao();
    }

    public LiveData<List<Note>> getAllNotes() {
        return mNoteDao.getAllNotes();
    }

    public void insert(final Note note) {
        executorService.execute(() -> mNoteDao.insert(note));
    }

    public void delete(final Note note) {
        executorService.execute(() -> mNoteDao.delete(note));
    }

    public void update(final Note note) {
        executorService.execute(() -> mNoteDao.update(note));
    }
}