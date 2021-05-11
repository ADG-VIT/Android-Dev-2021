package com.example.dogimages.Room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Dog.class}, version = 1)
public abstract class DogDatabase extends RoomDatabase {

    private static DogDatabase instance;

    public abstract DogDao noteDao();

    public static synchronized DogDatabase getInstance(Context context)
    {
        if (instance==null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(), DogDatabase.class,
                    "dog_database").fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }
    private static final Callback roomCallback= new Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>
    {
        private final DogDao DogDao;

        private PopulateDbAsyncTask(DogDatabase db)
        {
            DogDao= db.noteDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            /*DogDao.insert(new Dog("affenpinscher",
                    "https:\\/\\/images.dog.ceo\\/breeds\\/affenpinscher\\/n02110627_11263.jpg"));*/
            return null;
        }
    }
}
