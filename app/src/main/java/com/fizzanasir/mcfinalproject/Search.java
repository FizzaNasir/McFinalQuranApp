package com.fizzanasir.mcfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Search extends AppCompatActivity {
 EditText searchtext;
 Button surah, para;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchtext=findViewById(R.id.SearchSP);

        surah=findViewById(R.id.surahbtn);
        para=findViewById(R.id.parabtn);

        surah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String i=searchtext.getText().toString();
                Intent intent=new Intent(Search.this, DisplaySurahSearch.class);
                intent.putExtra("Surah_number1", i);
                startActivity(intent);
            }
        });

        para.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String i=searchtext.getText().toString();
                Intent intent=new Intent(Search.this, DisplayParaSearch.class);
                intent.putExtra("Parah_number1", i);
                startActivity(intent);
            }
        });

    }
}