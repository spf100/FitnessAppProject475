package com.example.fitnessappproject475.ui.Pedometer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.hardware.SensorEvent;

public class PedometerViewModel extends ViewModel {
    boolean activityRunning;
    private MutableLiveData<String> stepText = new MutableLiveData<>();
    private MutableLiveData<String> calorieText = new MutableLiveData<>();
    public String steps;
    public String calories;

    public interface OnSensorChangedListener {
        void onSensorChange(SensorEvent event);
    }

    public void updateStepText(String steps) {
        stepText.setValue(steps);
    }

    public void updateCalorieText(String cals) {
        calorieText.setValue(cals);
    }

    public PedometerViewModel() {
        stepText.setValue(steps);
        calorieText.setValue(calories);
    }

    public LiveData<String> getStepText() {
        return stepText;
    }

    public LiveData<String> getCalorieText() {
        return calorieText;
    }


}