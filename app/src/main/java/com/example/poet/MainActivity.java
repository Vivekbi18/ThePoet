package com.example.poet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

//import Adapters.PoetryAdaptor;
//import Models.PoetryModel;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
//
//        ArrayList<PoetryModel> list = new ArrayList<>();
//
//        list.add(new PoetryModel(R.drawable.gn , "good morning"));
//        list.add(new PoetryModel(R.drawable.gm , "good night"));
//        list.add(new PoetryModel(R.drawable.love , "Love"));
//        list.add(new PoetryModel(R.drawable.romance , "Romance"));
//        list.add(new PoetryModel(R.drawable.gn , "good morning"));
//        list.add(new PoetryModel(R.drawable.gm , "good night"));
//        list.add(new PoetryModel(R.drawable.love , "Love"));
//        list.add(new PoetryModel(R.drawable.romance , "Romance"));
//
//        PoetryAdaptor adaptor = new PoetryAdaptor(list ,  this);
//        recyclerView.setAdapter(adaptor);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}