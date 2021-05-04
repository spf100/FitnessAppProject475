package com.example.fitnessappproject475;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "entries")
public class Entry {

    @PrimaryKey(autoGenerate = true)
    private int id;
    public int getId() { return id; }
    public void setId(int id) {id = this.id;  }

}