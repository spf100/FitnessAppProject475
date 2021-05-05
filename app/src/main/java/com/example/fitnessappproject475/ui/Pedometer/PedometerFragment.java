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


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import android.widget.Toast;


public class PedometerFragment extends Fragment implements PedometerViewModel.OnSensorChangedListener, SensorEventListener  {
    private PedometerViewModel pedometerViewModel;
    private SensorManager sensorManager;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        pedometerViewModel = new ViewModelProvider(this).get(PedometerViewModel.class);


        View root = inflater.inflate(R.layout.pedometer_fragment, container, false);
        final TextView stepTextView = root.findViewById(R.id.displaySteps);
        final TextView calorieTextView = root.findViewById(R.id.displayCals);
        pedometerViewModel.getStepText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                stepTextView.setText(s);
            }
        });
        pedometerViewModel.getCalorieText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) { calorieTextView.setText(s); }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pedometerViewModel = new ViewModelProvider(this).get(PedometerViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onSensorChange(SensorEvent event) {
        onSensorChanged(event);
    }

    @Override
    public void onResume() {
        super.onResume();
        pedometerViewModel = new ViewModelProvider(this).get(PedometerViewModel.class);
        pedometerViewModel.activityRunning = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor!= null){
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(getActivity(), "Step Counter is not Available!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        pedometerViewModel.activityRunning = true;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (pedometerViewModel.activityRunning) {
            String steps = String.valueOf(event.values[0]);
            double calories = event.values[0] * 0.04513;
            pedometerViewModel.updateStepText(steps);
            pedometerViewModel.updateCalorieText(String.format("%.2f", calories));

            if(event.values[0] % 2000 == 0) { //2000 steps in a mile per average
                Toast.makeText(getActivity(), "You have walked " + (event.values[0] / 2000) + " miles!", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}