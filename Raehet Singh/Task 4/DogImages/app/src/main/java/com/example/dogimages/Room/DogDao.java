package com.example.dogimages.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DogDao {

    @Insert
    void insert(Dog dog);

    @Query("DELETE FROM dog_table")
    void deleteAllDogs();

    @Query("SELECT * FROM dog_table")
    LiveData<List<Dog>> getAllDogs();
}
