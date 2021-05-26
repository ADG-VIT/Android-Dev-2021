package com.example.dogimages.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dogimages.R;
import com.example.dogimages.Room.Dog;

import java.util.ArrayList;
import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.Holder> {

    private List<Dog> dogs= new ArrayList<>();

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    private Context context;

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public List<Dog> getDogs(List<Dog> dogList) {
        return dogs;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.dogName.setText(dogs.get(position).dogName);

        try{
            Glide.with(context).load(dogs.get(position).dogImageUrl)
                    .override(750, 1050)
                    .into(holder.dogImage);
        }
        catch (Exception e)
        {
            Toast.makeText(context, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return dogs.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView dogName;
        ImageView dogImage;

        public Holder(View itemView)
        {
            super(itemView);
            dogName= itemView.findViewById(R.id.dog_text_view_name);
            dogImage= itemView.findViewById(R.id.dog_image_view);
        }
    }
}
