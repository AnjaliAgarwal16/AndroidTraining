package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class Activity5 extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        //Log.d(TAG, "onCreate: started.");

        //initImageBitmaps();
        recyclerView = findViewById(R.id.rv);
        ArrayList<Model> list = new ArrayList<>();

        list.add(new Model(R.drawable.bangkok, "Bangkok"));
        list.add(new Model(R.drawable.dubai, "Dubai"));
        list.add(new Model(R.drawable.istanbul, "Istanbul"));
        list.add(new Model(R.drawable.london, "London"));
        list.add(new Model(R.drawable.mexico, "Mexico"));
        list.add(new Model(R.drawable.nyc, "Ney York City"));
        list.add(new Model(R.drawable.singapore, "Singapore"));
        list.add(new Model(R.drawable.tokyo, "Tokyo"));
        list.add(new Model(R.drawable.paris, "Paris"));

        RecyclerViewAdapter adapter= new RecyclerViewAdapter(list, this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}




