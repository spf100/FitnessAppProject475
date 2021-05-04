package com.example.fitnessappproject475;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EntryViewModel extends AndroidViewModel
{
    private Repository repository;
    private static LiveData<List<Entry>> allNotes;
    public EntryViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        allNotes = repository.getAllNotes();
    }
    public void insert(Entry note) {
        repository.insert(note);
    }
    public void delete(Entry note) {
        repository.delete(note);
    }
    public static LiveData<List<Entry>> getAllNotes() {
        return allNotes;
    }
}
