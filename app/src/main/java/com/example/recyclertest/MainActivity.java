package com.example.recyclertest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycler = findViewById(R.id.main_recycler);

        List<String> postAdapterData = Arrays.asList("https://funnymemes.funnyjunk.com/movies/Meme_042a09_6211432.mp4",
                "https://memeworld.funnyjunk.com/pictures/Avaricious+preparatory+mitigated+kingfisher_c80ce6_7780034.jpg",
                                                     "https://funnymemes.funnyjunk.com/movies/Meme_7a7f88_6211432.mp4",
                "https://memeworld.funnyjunk.com/pictures/There_f2613e_7779353.jpg",
                                                    "https://funnymemes.funnyjunk.com/movies/Meme_01d9a7_6211432.mp4",
                                                    "https://funnymemes.funnyjunk.com/movies/Meme_ef27c0_6211432.mp4",
                "https://memeworld.funnyjunk.com/pictures/Brave+tasteless+encased+fly_a45338_7776052.jpg",
                                                    "https://funnymemes.funnyjunk.com/movies/Meme_53b21f_6211432.mp4",
                "https://memeworld.funnyjunk.com/pictures/Long+side_938e77_7774096.jpg",
                "https://memeworld.funnyjunk.com/pictures/Lies_afde4e_7779071.jpg");


        PostViewAdapter postAdapter = new PostViewAdapter(this,postAdapterData);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(postAdapter);
    }

}
