package com.example.fitnessappproject475.ui.Nutrition;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessappproject475.AddEntryActivity;
import com.example.fitnessappproject475.Entry;
import com.example.fitnessappproject475.EntryViewModel;
import com.example.fitnessappproject475.EntryAdapter;
import com.example.fitnessappproject475.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class NutritionFragment extends Fragment {
    private EntryViewModel entryViewModel;
    public static final int ADD_ENTRY = 1;

    private NutritionViewModel nutritionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        nutritionViewModel =
                new ViewModelProvider(this).get(NutritionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_nutrition, container, false);

        FloatingActionButton buttonAddEntry = root.findViewById(R.id.button_add_entry);
        buttonAddEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddEntryActivity.class);
                startActivityForResult(intent, ADD_ENTRY);
            }
        });

        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        EntryAdapter adapter = new EntryAdapter();
        recyclerView.setAdapter(adapter);


        //final TextView textView = root.findViewById(R.id.recycler_view);
        entryViewModel = ViewModelProviders.of(getActivity()).get(EntryViewModel.class);
        EntryViewModel.getAllNotes().observe(getViewLifecycleOwner(), new Observer<List<Entry>>() {
            @Override
            public void onChanged(@Nullable List<Entry> notes) {
                adapter.setNotes(notes);
                //update RecyclerView
                //Toast.makeText(NutritionFragment.this, "onChanged", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_ENTRY && resultCode == Activity.RESULT_OK) {
            int grams = data.getIntExtra(AddEntryActivity.EXTRA_GRAMS, 1);
            //String id = data.getStringExtra(AddEntryActivity.EXTRA_ID);
            String name = data.getStringExtra(AddEntryActivity.EXTRA_NAME);

            Entry entry = new Entry(name, grams);
            entryViewModel.insert(entry);

            Toast.makeText(getActivity(), "Entry saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Entry not saved", Toast.LENGTH_SHORT).show();
        }
    }
}