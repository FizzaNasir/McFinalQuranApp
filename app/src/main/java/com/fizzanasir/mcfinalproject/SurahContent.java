package com.fizzanasir.mcfinalproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

public class SurahContent extends AppCompatActivity {
    ListView listview;
    int Uloc=0, Eloc=0;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_content);
        Intent intent= getIntent();
        String s=intent.getStringExtra("Surah_number");

        String UrduTrans=Global.urdutrans;
        String EngTrans=Global.engtrans;
        int index= Integer.parseInt(s);

        SqlLiteDbHelper dbhelper = new SqlLiteDbHelper(SurahContent.this);

        if(UrduTrans!=null) {
            if (UrduTrans== "Fateh Muhammad Jalandhri") {
                Uloc = 4;
            } else if (Objects.equals(UrduTrans, "Mehmood ul Hassan")) {
                Uloc = 5;
            }
        }
        if(EngTrans!=null)
        { if(Objects.equals(EngTrans, "Dr Mohsin Khan")){
            Eloc=6;
        }
        else if(Objects.equals(EngTrans, "Mufti Taqi Usmani")){
            Eloc=7;
        }}

        listview=findViewById(R.id.SurahContent);
//        ArrayList<AyahDetails> ayahDetails = dbhelper.getDetailsBySurah(index+1);
        if(EngTrans==null && UrduTrans==null)
        {
        ArrayList<AyahDetails> ayahDetails = dbhelper.getDetailsBySurah(index+1);
        MyAdaptor adapter=new MyAdaptor(SurahContent.this,0,ayahDetails)

       {
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                if (position % 2 == 1) {
//                    view.setBackgroundColor(getResources().getColor(android.R.color.system_accent1_400));
                    view.setBackgroundColor(Color.rgb(248, 252, 240));
                } else {
                    view.setBackgroundColor(Color.rgb(251, 252, 245));
                }
                return view;
            }
        };
        listview.setAdapter(adapter);
        }

        else if(EngTrans!=null && UrduTrans!=null){

            ArrayList<AyahDetails> ayahDetails = dbhelper.getSurahDetailsByEngUrdutrans(Uloc, Eloc, index+1);
            MyAdaptor adapter = new MyAdaptor(SurahContent.this, 0, ayahDetails) {
                public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    if (position % 2 == 1) {
                        view.setBackgroundColor(Color.rgb(248, 252, 240));
                    } else {
                        view.setBackgroundColor(Color.rgb(251, 252, 245));
                    }
                    return view;
                }
            };
            listview.setAdapter(adapter);
        }

        else if(EngTrans==null && UrduTrans!=null){
            ArrayList<AyahDetails> ayahDetails = dbhelper.getSuraDetailsByUrdutrans(Uloc, index+1);
            MyAdaptor adapter = new MyAdaptor(SurahContent.this, 0, ayahDetails) {
                public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    if (position % 2 == 1) {
                        view.setBackgroundColor(Color.rgb(248, 252, 240));
                    } else {
                        view.setBackgroundColor(Color.rgb(251, 252, 245));
                    }
                    return view;
                }
            };
            listview.setAdapter(adapter);
        }
        else if(EngTrans!=null && UrduTrans==null){
            ArrayList<AyahDetails> ayahDetails = dbhelper.getSuraDetailsByEngtrans(Eloc, index+1);
            MyAdaptor adapter = new MyAdaptor(SurahContent.this, 0, ayahDetails) {
                public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    if (position % 2 == 1) {
                        view.setBackgroundColor(Color.rgb(248, 252, 240));
                    } else {
                        view.setBackgroundColor(Color.rgb(251, 252, 245));
                    }
                    return view;
                }
            };
            listview.setAdapter(adapter);
        }
    }
}