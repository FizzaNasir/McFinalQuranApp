package com.fizzanasir.mcfinalproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class ParaContent extends AppCompatActivity {
    ListView listview;
    int Uloc=0, Eloc=0;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para_content);
        Intent intent= getIntent();
        String s=intent.getStringExtra("Parah_number");
//        String UrduTrans=intent.getStringExtra("seturdutrans");
//        String EngTrans=intent.getStringExtra("setengtrans");

        String UrduTrans=Global.urdutrans;
        String EngTrans=Global.engtrans;
        int index1= Integer.parseInt(s);

        SqlLiteDbHelper dbhelper = new SqlLiteDbHelper(ParaContent.this);

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


        listview=findViewById(R.id.paracontent);

        if(EngTrans==null && UrduTrans==null) {

            ArrayList<AyahDetails> ayahDetails = dbhelper.getDetailsByPara(index1);
            MyAdaptor adapter = new MyAdaptor(ParaContent.this, 0, ayahDetails) {
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

        else if(EngTrans!=null && UrduTrans!=null){

            ArrayList<AyahDetails> ayahDetails = dbhelper.getParaDetailsByEngUrdutrans(Uloc, Eloc, index1);
            MyAdaptor adapter = new MyAdaptor(ParaContent.this, 0, ayahDetails) {
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
            ArrayList<AyahDetails> ayahDetails = dbhelper.getParaDetailsByUrdutrans(Uloc, index1);
            MyAdaptor adapter = new MyAdaptor(ParaContent.this, 0, ayahDetails) {
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
            ArrayList<AyahDetails> ayahDetails = dbhelper.getParaDetailsByEngtrans(Eloc, index1);
            MyAdaptor adapter = new MyAdaptor(ParaContent.this, 0, ayahDetails) {
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
