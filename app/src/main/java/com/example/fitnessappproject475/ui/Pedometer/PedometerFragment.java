package com.example.fitnessappproject475.ui.Pedometer;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fitnessappproject475.R;

public class PedometerFragment extends Fragment {

    private PedometerViewModel pedometerViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        pedometerViewModel = new ViewModelProvider(this).get(PedometerViewModel.class);
        View root = inflater.inflate(R.layout.fragment_exercise, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        pedometerViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        pedometerViewModel = new ViewModelProvider(this).get(PedometerViewModel.class);
//        // TODO: Use the ViewModel
//    }

}