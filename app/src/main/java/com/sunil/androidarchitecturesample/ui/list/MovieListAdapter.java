package com.sunil.androidarchitecturesample.ui.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunil.androidarchitecturesample.base.BaseAdapter;
import com.sunil.androidarchitecturesample.databinding.ItemMovieListBinding;
import com.sunil.androidarchitecturesample.db.entity.MovieEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunil on 16-09-2017.
 */

public class MovieListAdapter extends BaseAdapter<MovieListAdapter.MovieViewHolder, MovieEntity> {

    private List<MovieEntity> movieEntities;

    private final MovieListCallback movieListCallback;

    public MovieListAdapter(@NonNull MovieListCallback movieListCallback) {
        movieEntities = new ArrayList<>();
        this.movieListCallback = movieListCallback;
    }

    @Override
    public void setData(List<MovieEntity> movieEntities) {
        this.movieEntities = movieEntities;
        notifyDataSetChanged();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return MovieViewHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup, movieListCallback);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder viewHolder, int i) {
        viewHolder.onBind(movieEntities.get(i));
    }

    @Override
    public int getItemCount() {
        return movieEntities.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {

        public static MovieViewHolder create(LayoutInflater inflater, ViewGroup parent, MovieListCallback callback) {
            ItemMovieListBinding itemMovieListBinding = ItemMovieListBinding.inflate(inflater, parent, false);
            return new MovieViewHolder(itemMovieListBinding, callback);
        }

        ItemMovieListBinding binding;

        public MovieViewHolder(final ItemMovieListBinding binding,final MovieListCallback callback) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callback.onMovieClicked(binding.getMovie(), binding.imageViewCover);
                }
            });
        }

        public void onBind(MovieEntity movieEntity) {
            binding.setMovie(movieEntity);
            binding.executePendingBindings();
        }
    }
}
