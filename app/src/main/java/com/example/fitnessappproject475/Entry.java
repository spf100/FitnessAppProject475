package com.example.fitnessappproject475;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "entries")
public class Entry {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int kilocal;
    private double grams;

    public String getName() { return name; }
    public void setName(String name){ this.name = name;}
    public int getKilocal(){return kilocal;}
    public void setKilocal(int kilocal){this.kilocal = kilocal;}
    public double getGrams(){return grams;}
    public void setGrams(double grams){this.grams = grams;}
    public int getId() { return id; }
    public void setId(int id) {this.id = id;  }



    public Entry(String name, int kilocal, double grams) {
        this.name = name;
        this.kilocal = kilocal;
        this.grams = grams;
    }


    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append("( ")
                .append(getName()).append(' ')
                .append(getKilocal()).append(' ')
                .append(getGrams()).append(' ')
                .append(')');
        return builder.toString();
    }
}