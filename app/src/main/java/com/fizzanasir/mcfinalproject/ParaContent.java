package com.fizzanasir.mcfinalproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ParaContent extends AppCompatActivity {
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para_content);
        Intent intent= getIntent();
        String s=intent.getStringExtra("Parah_number");
        int index1= Integer.parseInt(s);

        SqlLiteDbHelper dbhelper = new SqlLiteDbHelper(ParaContent.this);

        listview=findViewById(R.id.paracontent);

        ArrayList<AyahDetails> ayahDetails = dbhelper.getDetailsByPara(index1);
        MyAdaptor adapter=new MyAdaptor(ParaContent.this,0,ayahDetails)

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
    }
