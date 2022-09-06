//package com.fizzanasir.mcfinalproject;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
////import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import java.util.List;
//
//class RecyclerViewClickAdaptor extends RecyclerView.Adapter<RecyclerViewClickAdaptor.MyVH> {
//    private SelectedItem listner;
//    //List<Friend> friendsList;
//    ArrayList<String> Selectedcategory;
//    public RecyclerViewClickAdaptor(Context context, ArrayList<String> Selectedcategory, SelectedItem listner) {
//        this.Selectedcategory = Selectedcategory;
//        this.listner=listner;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerViewClickAdaptor.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.surahlayout, parent, false);
//        return new MyVH(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerViewClickAdaptor.MyVH holder, int position) {
//        holder.data=Selectedcategory.get(position);
//        holder.arabicTextview.setText(holder.data.getArabic());
//        holder.urduTextview.setText(holder.data.getUrdu());
//        holder.englishTextview.setText(holder.data.getEng());
//        holder.recyclerviewlist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listner.onItemClicked();
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return ayahdetails.size();
//    }
//
//
//    public class MyVH extends RecyclerView.ViewHolder {
//
//        TextView arabicTextview;
//        TextView urduTextview;
//        TextView englishTextview;
//        AyahDetails data;
//        RecyclerView recyclerviewlist;
//        public MyVH(@NonNull View itemView) {
//            super(itemView);
//            arabicTextview= itemView.findViewById(R.id.arabicText);
//            urduTextview = itemView.findViewById(R.id.urduText);
//            englishTextview = itemView.findViewById(R.id.englishText);
//            recyclerviewlist=itemView.findViewById(R.id.selectCat);
//        }
//    }
//}
