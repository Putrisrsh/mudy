package com.example.myapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapp.model.activity;

import java.util.ArrayList;


public class CardViewTimelineAdapter extends RecyclerView.Adapter<CardViewTimelineAdapter.CardViewViewHolder>
{

    private ArrayList<activity> listActivity;

    public CardViewTimelineAdapter(ArrayList<activity> list){
        this.listActivity = list;
    }


    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder holder, int position) {
        activity activity = listActivity.get(position);
//        Glide.with(holder.itemView.getContext()) //Glid memuat sebuah gambar yg sudah ada di drawable maupun diserver //with untuk memasukan context
//                .load(activity.()) //load untuk memasukan sumber gambar
//                .apply(new RequestOptions().override(55, 55)) //melakukan manipulasi gambar
//                .into(holder.imgPhoto); //memasukan gambar image view
        holder.tvActivity.setText(activity.getAktivitas());
        holder.tvDetail.setText(activity.getDetailActivity());
    }

    @Override
    public int getItemCount() {
        return listActivity.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvActivity, tvDetail;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_activity);
            tvActivity = itemView.findViewById(R.id.name_activity);
            tvDetail = itemView.findViewById(R.id.detail_activity);

        }
    }
}
