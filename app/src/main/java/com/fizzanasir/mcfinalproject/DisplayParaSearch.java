package com.fizzanasir.mcfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class DisplayParaSearch extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_para_search);
        Intent intent= getIntent();
        String s=intent.getStringExtra("Parah_number1");
        int index= Integer.parseInt(s);

        SqlLiteDbHelper dbhelper = new SqlLiteDbHelper(DisplayParaSearch.this);

        ArrayList<AyahDetails> ayahDetails = dbhelper.getDetailsByPara(index);

        recyclerView = findViewById(R.id.recyclerviewPara);

        recyclerView.setHasFixedSize(true);

        //LinearLayoutManager GridLayoutManager
        // layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager = new LinearLayoutManager(DisplayParaSearch.this,
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter(ayahDetails) ;
        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
    }
}