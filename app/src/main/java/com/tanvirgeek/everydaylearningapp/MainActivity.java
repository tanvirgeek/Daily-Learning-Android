package com.tanvirgeek.everydaylearningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        //Create Integer Array
        Integer[] LangLogo = {R.drawable.crystal,R.drawable.csharp,R.drawable.go,R.drawable.html,R.drawable.python};

        //Create String Array
        String[] LangName = {"Crystal","Csharp","Go","Html","Python"};

        //initialize ArrayList
        mainModels = new ArrayList<>();
        for(int i=0;i<LangLogo.length;i++){
            MainModel model = new MainModel(LangLogo[i], LangName[i]);
            mainModels.add(model);
        }
        //Design Horizontal Layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //initialize main Adapter
        mainAdapter = new MainAdapter(MainActivity.this, mainModels);
        //Set Main adapter to recyclerView
        recyclerView.setAdapter(mainAdapter);
    }
}
