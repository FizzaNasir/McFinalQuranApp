package com.fizzanasir.mcfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class DisplaySurahSearch extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_surah_search);
        Intent intent= getIntent();
        String s=intent.getStringExtra("Surah_number1");
        int index= Integer.parseInt(s);

        SqlLiteDbHelper dbhelper = new SqlLiteDbHelper(DisplaySurahSearch.this);

        ArrayList<AyahDetails> ayahDetails = dbhelper.getDetailsBySurah(index);

        recyclerView = findViewById(R.id.recyclerviewSurah);

        recyclerView.setHasFixedSize(true);

        //LinearLayoutManager GridLayoutManager
        // layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager = new LinearLayoutManager(DisplaySurahSearch.this,
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter(ayahDetails) ;
        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
    }
}