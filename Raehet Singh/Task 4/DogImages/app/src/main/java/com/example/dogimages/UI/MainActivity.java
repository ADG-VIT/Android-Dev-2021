package com.example.dogimages.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.dogimages.Adapter.DogAdapter;
import com.example.dogimages.Network.API;
import com.example.dogimages.Network.Credentials;
import com.example.dogimages.Network.ImgUrl;
import com.example.dogimages.Network.DogRetrofit;
import com.example.dogimages.Network.Root;
import com.example.dogimages.R;
import com.example.dogimages.Repository.Repository;
import com.example.dogimages.Room.Dog;
import com.example.dogimages.SharedPreference.SaveSharedPreference;
import com.example.dogimages.ViewModel.ViewModel;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ViewModel viewModel;
    List<Dog> dogList;
    DogAdapter adapter;
    Repository repository;
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Dog Images- Raehat Singh Nanda");
        recyclerView= findViewById(R.id.recycler_view);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        // checks if the data already exists
        if (!SaveSharedPreference.getLoggedStatus(getApplicationContext()))
        {
            networkRequest();
            SaveSharedPreference.setLoggedIn(getApplicationContext(), true);
        }
        repository= new Repository(getApplication());
        dogList= new ArrayList<>();
        adapter= new DogAdapter();
        adapter.setContext(getApplicationContext());
        recyclerView.setAdapter(adapter);

        // View Model
        viewModel= new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(ViewModel.class);
        viewModel.getAllNotes().observe(this, new Observer<List<Dog>>() {
            @Override
            public void onChanged(List<Dog> dogs) {
                Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_SHORT).show();
                recyclerView.setAdapter(adapter);
                adapter.setDogs(dogs);
            }
        });

    }

    // Requests data from the API
    private void networkRequest() {
        DogRetrofit retrofit= new DogRetrofit();
        Call<Root> call= retrofit.api.getRoot();
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (!response.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Root root= response.body();
                HashMap<String, Object> yourHashMap = new Gson().fromJson(root.getMessage().toString(), HashMap.class);
                for (String url: yourHashMap.keySet())
                {
                    networkRequestImage(url);
                    //Dog dog= new Dog(url, networkRequestImage(url));
                    //repository.insert(dog);
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Requests Image from API
    public void networkRequestImage(String url)
    {
        DogRetrofit retrofit= new DogRetrofit();
        Call<ImgUrl> call= retrofit.api.getUrl(url);
        call.enqueue(new Callback<ImgUrl>() {
            @Override
            public void onResponse(Call<ImgUrl> call, Response<ImgUrl> response) {
                if (response.isSuccessful()) {
                    temp= response.body().getMessage();
                    dataInsert(url,temp);
                }
                else {
                    Toast.makeText(MainActivity.this, "" + response.code(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ImgUrl> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Inserts data into Local Database
    private void dataInsert(String url, String temp) {
        try {
            viewModel.insert(new Dog(url, temp));
        }catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}