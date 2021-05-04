package com.example.fitnessappproject475;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = Entry.class, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    public abstract EntryDAO entryDAO();
    private static volatile RoomDB INSTANCE;
    private static final int NumberOfThreads = 4;
    static final ExecutorService databaseWriter = Executors.newFixedThreadPool(NumberOfThreads);

    public static RoomDB getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (RoomDB.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDB.class, "database")
                            .fallbackToDestructiveMigration()
                            .addCallback(roomCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private EntryDAO entryDao;
        private PopulateDbAsyncTask(RoomDB db) {
            entryDao = db.entryDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            entryDao.insert(new Entry("Food 1", 100, 1));
            entryDao.insert(new Entry("Food 2", 200, 2));
            entryDao.insert(new Entry("Food 3", 300, 3));
            return null;
        }
    }
    public static ExecutorService getDatabaseWriter(){return databaseWriter;}
}
