package com.example.fitnessappproject475.services;

import android.app.Application;
import android.os.Build;
import android.util.Log;

import androidx.lifecycle.LiveData;
import com.example.fitnessappproject475.model.EntryDao;
import com.example.fitnessappproject475.model.SearchDTO;
import com.example.fitnessappproject475.model.SearchPojo;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.ExecutorService;

import javax.security.auth.callback.Callback;

import retrofit2.Call;
import retrofit2.Response;
/*
public class Repository {
    private final EntryDao mEntryDao;
    private final LiveData<List<Entry>> mAllEntries;
    private final ExecutorService DBwriter = RoomDB.getDatabaseWriter();

    public Repository(Application application){
        RoomDB DB = RoomDB.getDatabase(application);
        this.mEntryDao = DB.entryDAO();
        this.mAllEntries = mEntryDao.getEntriesByTime();
    }

    public LiveData<List<Entry>> getmAllEntries(){return mAllEntries;}
    public void deleteAllEntries(){ DBwriter.submit(mEntryDao::deleteAll);}
    public void insert(Entry entry){ DBwriter.execute(() -> mEntryDao.insert(entry)); }
   /* public static void searchFood(String food, FoodItemAdapter adapter){
        /*FDCService.searchFood(food).enqueue(new Callback<SearchPojo>() {
            @Override
            public void onResponse(@NotNull Call<SearchPojo> call, @NotNull Response<SearchPojo> response) {
                Log.d("search", "Success");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    adapter.setItems(SearchDTO.parsePojo(response.body()));
                }
            }

            @Override
            public void OnFailure(@NotNull Call<SearchPojo> call, @NotNull Throwable t) {
                Log.d("search", "failure");
                Log.d("search", call.request().toString());
            }
        });


    }

}
   */
