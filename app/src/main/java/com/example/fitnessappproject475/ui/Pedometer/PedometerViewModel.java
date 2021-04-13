package com.example.fitnessappproject475.ui.Pedometer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PedometerViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public PedometerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the pedometer fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}