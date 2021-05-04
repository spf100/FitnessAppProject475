package com.example.fitnessappproject475;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {
    private EntryDAO noteDao;
    private LiveData<List<Entry>> allNotes;
    public Repository(Application application) {
        RoomDB database = RoomDB.getDatabase(application);
        noteDao = database.entryDAO();
        allNotes = noteDao.getEntries();
    }
    public void insert(Entry note) {
        new InsertNoteAsyncTask(noteDao).execute(note);
    }
    public void delete(Entry note) {
        new DeleteNoteAsyncTask(noteDao).execute(note);
    }

    public LiveData<List<Entry>> getAllNotes() {
        return allNotes;
    }
    private static class InsertNoteAsyncTask extends AsyncTask<Entry, Void, Void> {
        private EntryDAO noteDao;
        private InsertNoteAsyncTask(EntryDAO noteDao) {
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Entry... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }
    private static class DeleteNoteAsyncTask extends AsyncTask<Entry, Void, Void> {
        private EntryDAO noteDao;
        private DeleteNoteAsyncTask(EntryDAO noteDao) {
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Entry... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }

}
