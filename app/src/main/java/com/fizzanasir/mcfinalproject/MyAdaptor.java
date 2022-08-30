package com.fizzanasir.mcfinalproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyAdaptor extends ArrayAdapter<AyahDetails> {
    public MyAdaptor(@NonNull Context context, int resource, @NonNull List<AyahDetails> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AyahDetails ayahs_list = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.surahlayout, parent, false);
        }
        TextView artext = convertView.findViewById(R.id.arabicText);
        TextView urtext = convertView.findViewById(R.id.urduText);
        TextView engtext = convertView.findViewById(R.id.englishText);
        artext.setText(ayahs_list.getArabic());
        urtext.setText(ayahs_list.getUrdu());
        engtext.setText(ayahs_list.getEng());
//        tv.setOnClickListener(new View.OnClickListener() {
//                                  @Override
//                                  public void onClick(View view) {
////                                                Log.d("Name", students.getName());
////                                                Intent intent=new Intent(this, MainActivity.class); //we are inside a class and not in an activity
//                                      //therefore we cant write this
//                                      Intent intent=new Intent(getContext(), DetailActivity.class);
//                                      intent.putExtra("id", alphabet_list.getId());
//                                      getContext().startActivity(intent);
//                                  }
//                              }
//        );
        return convertView;
//
//    }


    }

}
