package com.fizzanasir.mcfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
    private RadioGroup radioGroupUrdu, radioGroupEng;
    private RadioButton urdutrans, engtrans;
    String selectedUrdutrans, selectedEngtrans;
    Button changesapply;
    String urdutext, engtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        radioGroupUrdu = (RadioGroup) findViewById(R.id.urduTransGrp);
        radioGroupEng  = (RadioGroup) findViewById(R.id.EngTransGrp);
        changesapply = findViewById(R.id.apply);
//        int selectedUrdubtn = radioGroupUrdu.getCheckedRadioButtonId();
//        int selectedEngbtn  = radioGroupEng.getCheckedRadioButtonId();
//        changesapply = findViewById(R.id.apply);
//        urdutrans=findViewById(selectedUrdubtn);
//        engtrans=findViewById(selectedEngbtn);
        //Toast.makeText(Settings.this, urdutrans.getText().toString()+engtrans.getText().toString(), Toast.LENGTH_SHORT).show();
//        changesapply.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(selectedUrdubtn!=-1) {
////                    selectedUrdutrans = urdutrans.getText().toString();
//                   Toast.makeText(Settings.this, "selectedUrdutrans-1", Toast.LENGTH_SHORT).show();
//                }
//                if(selectedEngbtn!=-1) {
////                    selectedEngtrans = engtrans.getText().toString();
//                   Toast.makeText(Settings.this, "selectedEngtrans-1", Toast.LENGTH_SHORT).show();
//                }

//                Global.urdutrans=selectedUrdutrans;
//                Global.engtrans=selectedEngtrans;
//                Toast.makeText(Settings.this, "Changes applied successfully!", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Settings.this, ParahList.class);
//                intent.putExtra("urdutrans",selectedUrdutrans);
//                intent.putExtra("engtrans", selectedEngtrans);
//                startActivity(intent);
//
//
//                Toast.makeText(Settings.this, engtrans.getText().toString(), Toast.LENGTH_SHORT).show();

//            }
//        });
        radioGroupUrdu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedbuttonid) {
                switch(checkedbuttonid) {
                    case R.id.jalandhri:
                        urdutext="Fateh Muhammad Jalandhri";
                        break;
                    case R.id.Hassan:
                        urdutext="Mehmood ul Hassan";
                        break;
                    default:
                        urdutext="Fateh Muhammad Jalandhri";
                        break;
                }
            }
        });

        radioGroupEng.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedbuttonid) {
                switch(checkedbuttonid) {
                    case R.id.Mohsin:
                        engtext="Dr Mohsin Khan";
                        break;
                    case R.id.TaqiUsmani:
                        engtext="Mufti Taqi Usmani";
                        break;
                    default:
                        engtext="Dr Mohsin Khan";
                        break;
                }
            }
        });
        changesapply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Settings.this, "Changes applied successfully!", Toast.LENGTH_SHORT).show();
                Global.urdutrans=urdutext;
                Global.engtrans=engtext;
                Intent intent = new Intent(Settings.this, SurahList.class);
                startActivity(intent);

            }
        });
    }
}