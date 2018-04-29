package com.bso.android.realmmovie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bso.android.realmmovie.R;
import com.bso.android.realmmovie.realm.MovieRealmModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Lu'lu' on 05/04/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{
    private List<MovieRealmModel> movieList;
    Context context;

    public MovieAdapter(Context context, List<MovieRealmModel> movieList) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_movie, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MovieRealmModel movieModel = movieList.get(position);
        Picasso.with(context)
                .load(movieModel.getPoster())
                .into(holder.poster);
        holder.judul.setText(movieModel.getJudul());
        holder.tahun.setText(movieModel.getTahun());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView judul, tahun;
        ImageView poster;

        public MyViewHolder(View itemView){

            super(itemView);
            judul = itemView.findViewById(R.id.judul);
            poster = itemView.findViewById(R.id.poster);
            tahun = itemView.findViewById(R.id.tahun);
        }
    }
}

