package com.example.fitnessappproject475.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface EntryDao {
 /*   @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Entry entry);

    @Query("DELETE FROM entries")
    void deleteAll();

    @Query("SELECT * FROM entries")
    LiveData<List<Entry>> getEntriesByTime();

  */
}
