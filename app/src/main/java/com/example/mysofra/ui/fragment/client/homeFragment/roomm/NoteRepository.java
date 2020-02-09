package com.example.mysofra.ui.fragment.client.homeFragment.roomm;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.mysofra.data.model.Note;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;
    LiveData<List<Note>> allNotes;

    public NoteRepository(Application application) {
        NoteDatabase noteDatabase = NoteDatabase.getInstance(application);
        noteDao = noteDatabase.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    public void insert(Note note) {
        new insertNoteAsynkTask(noteDao).execute(note);
    }

    public void update(Note note) {
        new updateNoteAsyncTask(noteDao).execute(note);

    }

    public void delete(Note note) {
        new deleteNoteAsyncTask(noteDao).execute(note);

    }

    public void deleteAllNotes() {
        new deleteAllNoteAsyncTask(noteDao).execute();
    }

    public LiveData<List<Note>> getAllNote() {
        return allNotes;
    }

    private static class insertNoteAsynkTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        private insertNoteAsynkTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }

    private static class updateNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        private updateNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }

    private static class deleteNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        private deleteNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }

    private static class deleteAllNoteAsyncTask extends AsyncTask<Void, Void, Void> {
        private NoteDao noteDao;

        private deleteAllNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAll();
            return null;
        }
    }


}
