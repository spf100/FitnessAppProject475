package com.example.fitnessappproject475.ui.Nutrition;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessappproject475.Entry;
import com.example.fitnessappproject475.EntryViewModel;
import com.example.fitnessappproject475.NoteAdapter;
import com.example.fitnessappproject475.R;

import java.util.List;

public class NutritionFragment extends Fragment {
    private EntryViewModel entryViewModel;

    private NutritionViewModel nutritionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        nutritionViewModel =
                new ViewModelProvider(this).get(NutritionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_nutrition, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        NoteAdapter adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);


        final TextView textView = root.findViewById(R.id.recycler_view);
        entryViewModel = ViewModelProviders.of(this).get(EntryViewModel.class);
        EntryViewModel.getAllNotes().observe(getViewLifecycleOwner(), new Observer<List<Entry>>() {
            @Override
            public void onChanged(@Nullable List<Entry> notes) {
                adapter.setNotes(notes);
                //update RecyclerView
                //Toast.makeText(NutritionFragment.this, "onChanged", Toast.LENGTH_SHORT).show();
            }
        });
        nutritionViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}