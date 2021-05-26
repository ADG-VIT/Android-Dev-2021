package com.example.dogimages.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.dogimages.Repository.Repository;
import com.example.dogimages.Room.Dog;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private final Repository Repository;
    private final LiveData<List<Dog>> allDogs;

    public ViewModel(@NonNull Application application) {
        super(application);
        Repository= new Repository(application);
        allDogs= Repository.getAllDogs();
    }

    public void insert(Dog dog)
    {
        Repository.insert(dog);
    }

    public LiveData<List<Dog>> getAllNotes() {
        return allDogs;
    }
}
