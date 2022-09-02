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

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class SurahList extends AppCompatActivity {
    ArrayList<String> surahnames = new ArrayList<String>();
    ListView listview;
    NavigationView navigationView;
    public String[] englishSurahNames = {"Al-Fatihah",
            "Al-Baqara ",
            "Al-i'Imran ",
            "An-Nisaa ",
            "Al-Maidah ",
            "Al-An'am ",
            "Al-A'raf ",
            "Al-Anfal ",
            "At-Tauba ",
            "Yunus ",
            "Hud ",
            "Yusuf ",
            "Ar-Ra'd ",
            "Ibrahim ",
            "Al-Hijr ",
            "An-Nahl ",
            "Al-Israa ",
            "Al-Kahf ",
            "Maryam ",
            "Ta-ha ",
            "Al-Anbiyaa ",
            "Al-Hajj ",
            "Al-Muminun ",
            "An-Nur ",
            "Al-Furqan ",
            "Ash-Shu'araa ",
            "An-Naml ",
            "Al-Qasas ",
            "Al-Ankabut ",
            "Ar-Rum ",
            "Luqman ",
            "As-Sajda ",
            "Al-Ahzab ",
            "Saba ",
            "Fatir ",
            "Ya-Sin ",
            "As-Saffat ",
            "Sad ",
            "Az-Zumar ",
            "Al-Mu'min ",
            "Ha-Mim ",
            "Ash-Shura ",
            "Az-Zukhruf ",
            "Ad-Dukhan ",
            "Al-Jathiya ",
            "Al-Ahqaf ",
            "Muhammad ",
            "Al-Fat-h ",
            "Al-Hujurat ",
            "Qaf ",
            "Az-Zariyat ",
            "At-Tur ",
            "An-Najm ",
            "Al-Qamar ",
            "Ar-Rahman ",
            "Al-Waqi'a ",
            "Al-Hadid ",
            "Al-Mujadila ",
            "Al-Hashr ",
            "Al-Mumtahana ",
            "As-Saff ",
            "Al-Jumu'a ",
            "Al-Munafiqun ",
            "At-Tagabun ",
            "At-Talaq ",
            "At-Tahrim ",
            "Al-Mulk ",
            "Al-Qalam ",
            "Al-Haqqa ",
            "Al-Ma'arij ",
            "Nuh ",
            "Al-Jinn ",
            "Al-Muzzammil ",
            "Al-Muddathth ",
            "Al-Qiyamat ",
            "Ad-Dahr ",
            "Al-Mursalat ",
            "An-Nabaa ",
            "An-Nazi'at ",
            "Abasa ",
            "At-Takwir ",
            "Al-Infitar ",
            "Al-Mutaffife ",
            "Al-Inshiqaq ",
            "Al-Buruj ",
            "At-Tariq ",
            "Al-A'la ",
            "Al-Gashiya ",
            "Al-Fajr ",
            "Al-Balad ",
            "Ash-Shams ",
            "Al-Lail ",
            "Adh-Dhuha ",
            "Al-Sharh ",
            "At-Tin ",
            "Al-Alaq ",
            "Al-Qadr ",
            "Al-Baiyina ",
            "Al-Zalzalah ",
            "Al-Adiyat ",
            "Al-Qari'a ",
            "At-Takathur ",
            "Al-Asr ",
            "Al-Humaza ",
            "Al-Fil ",
            "Quraish ",
            "Al-Ma'un ",
            "Al-Kauthar ",
            "Al-Kafirun ",
            "An-Nasr ",
            "Al-Lahab ",
            "Al-Ikhlas ",
            "Al-Falaq ",
            "Al-Nas ",
    };

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_list2);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        navigationView=findViewById(R.id.navview);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        for (int i = 0; i < 114; i++) {
            surahnames.add(englishSurahNames[i]);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, surahnames) {
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
        listview = findViewById(R.id.surahlist);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent=new Intent(SurahList.this, SurahContent.class);
                String s= String.valueOf(adapterView.getItemIdAtPosition(position));

                intent.putExtra("Surah_number", s);
                startActivity(intent);
                Toast.makeText(SurahList.this, "I clicked: ", Toast.LENGTH_SHORT).show();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.SearchSP:
                        Toast.makeText(getApplicationContext(),"Retur is Clicked",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SurahList.this, Search.class);
                        startActivity(intent);
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                return true;
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