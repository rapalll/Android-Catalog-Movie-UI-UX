package com.grack.rapalll.catalogmovie.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.GsonBuilder;
import com.grack.rapalll.catalogmovie.API.ApiClient;
import com.grack.rapalll.catalogmovie.Data.ResultsItem;
import com.grack.rapalll.catalogmovie.R;
import com.uncopt.android.widget.text.justify.JustifiedTextView;

public class DetailMovie extends AppCompatActivity {


    int a;
    ResultsItem result;
    Toolbar toolbar;
    ImageView backdrop, poster;
    TextView rate, releasedate;
    JustifiedTextView deskripsi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        toolbar = findViewById(R.id.toolbar);


        backdrop = findViewById(R.id.img_backdrop);
        poster = findViewById(R.id.posterFilm);
        rate = findViewById(R.id.ratingFilm);
        releasedate = findViewById(R.id.releaseDateFilm);
        deskripsi = findViewById(R.id.deskripsiFilm);
        loadData();

    }

    private void loadData() {
        result = new GsonBuilder().create().fromJson(getIntent().getStringExtra("movie"), ResultsItem.class);
        a = result.getId();
        toolbar.setTitle(result.getTitle());
        Glide.with(DetailMovie.this).load(ApiClient.LOAD_GAMBAR + result.getBackdropPath()).into(backdrop);
        Glide.with(DetailMovie.this).load(ApiClient.LOAD_GAMBAR + result.getPosterPath()).into(poster);
        rate.setText(getResources().getString(R.string.rating) + result.getVoteAverage());
        releasedate.setText(getResources().getString(R.string.release_date) + result.getReleaseDate());
        deskripsi.setText(result.getOverview());
    }

}