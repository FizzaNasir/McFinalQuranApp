package com.fizzanasir.mcfinalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.MyVH> {
    private SelectedItem listner;
    //List<Friend> friendsList;
    ArrayList<AyahDetails> ayahdetails;
    public myRecyclerViewAdapter(ArrayList<AyahDetails> ayahdetails) {
        this.ayahdetails = ayahdetails;
    }


    @NonNull
    @Override
    public myRecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.surahlayout, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myRecyclerViewAdapter.MyVH holder, int position) {
        holder.data=ayahdetails.get(position);
        holder.arabicTextview.setText(holder.data.getArabic());
        holder.urduTextview.setText(holder.data.getUrdu());
        holder.englishTextview.setText(holder.data.getEng());
    }

    @Override
    public int getItemCount() {
        return ayahdetails.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {

        TextView arabicTextview;
        TextView urduTextview;
        TextView englishTextview;
        AyahDetails data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            arabicTextview= itemView.findViewById(R.id.arabicText);
            urduTextview = itemView.findViewById(R.id.urduText);
            englishTextview = itemView.findViewById(R.id.englishText);
        }
    }
}
