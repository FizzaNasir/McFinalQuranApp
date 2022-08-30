package com.fizzanasir.mcfinalproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ParahList extends AppCompatActivity {

    ArrayList<String> paranames = new ArrayList<String>();
    ListView listview;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parah_list);
        drawerLayout = findViewById(R.id.my_drawer_layout1);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        for (int i = 1; i <= 30; i++) {
            paranames.add("Para" + i);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paranames) {
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
        listview = findViewById(R.id.ParaList);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(ParahList.this, ParaContent.class);
                String s = String.valueOf(adapterView.getItemIdAtPosition(position));

                intent.putExtra("Parah_number", s);
                startActivity(intent);
                Toast.makeText(ParahList.this, "I clicked: ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}