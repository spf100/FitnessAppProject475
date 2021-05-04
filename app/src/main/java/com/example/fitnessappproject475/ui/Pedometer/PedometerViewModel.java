package com.example.fitnessappproject475.ui.Pedometer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PedometerViewModel extends ViewModel {
    boolean activityRunning;
    private MutableLiveData<String> mText = new MutableLiveData<>();
    public String steps;

    public interface OnSensorChangedListener {
        void onSensorChange(SensorEvent event);
    }

    public void updateMtext(String steps) {
        mText.setValue(steps);
    }

    public PedometerViewModel() {
        mText.setValue(steps);
    }

    public LiveData<String> getText() {
        return mText;
    }


}