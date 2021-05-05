package com.example.fitnessappproject475.ui.Profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {
    private MutableLiveData<String> calorieText = new MutableLiveData<>();
    public String calories;

    public void updateCalorieText(String cals) {
        calorieText.setValue(calories);
    }

    public ProfileViewModel() {
        calorieText.setValue(calories);
    }
    public LiveData<String> getCalorieText() { return calorieText; }

}