package com.example.dogimages.Room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dog_table")
public class Dog {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String dogName;

    public String dogImageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogImageUrl() {
        return dogImageUrl;
    }

    public void setDogImageUrl(String dogImageUrl) {
        this.dogImageUrl = dogImageUrl;
    }

    public Dog(String dogName, String dogImageUrl) {
        this.dogName = dogName;
        this.dogImageUrl = dogImageUrl;
    }
}
