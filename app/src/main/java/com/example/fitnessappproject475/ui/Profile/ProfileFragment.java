package com.example.fitnessappproject475.ui.Profile;

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
import com.example.fitnessappproject475.ui.Pedometer.PedometerFragment;
import com.example.fitnessappproject475.ui.Pedometer.PedometerViewModel;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        View root = inflater.inflate(R.layout.profile_fragment, container, false);

        TextView caloriesTextView = root.findViewById(R.id.dailyCals);

        profileViewModel.getCalorieText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                int calories;
                //calories = PedometerFragment.
                caloriesTextView.setText(s);
            }
        });

        return root;
    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        // TODO: Use the ViewModel
    }

}