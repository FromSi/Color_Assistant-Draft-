package kz.colorsapp.sgq.colorsapp.application;

import android.app.Application;
import android.arch.persistence.room.Room;

import kz.colorsapp.sgq.colorsapp.room.AppDatabase;

public class App extends Application {
    public static App instance;

    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "local")
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
