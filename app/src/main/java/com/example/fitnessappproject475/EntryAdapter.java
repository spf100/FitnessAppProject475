package com.example.fitnessappproject475;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.NoteHolder> {
    private List<Entry> notes = new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Entry currentNote = notes.get(position);
        holder.textViewTitle.setText(currentNote.getName()); //12:11
       // holder.textViewId.setText(currentNote.getId());
        holder.textViewGrams.setText(String.valueOf(currentNote.getGrams()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Entry> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
       // private TextView textViewId;
        private TextView textViewGrams;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_name);
           // textViewId = itemView.findViewById(R.id.text_view_id);
            textViewGrams = itemView.findViewById(R.id.text_view_gram);
        }
    }
}
