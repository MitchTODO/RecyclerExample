package com.example.recyclertest;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.VideoView;

import androidx.annotation.NonNull;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PostViewAdapter extends RecyclerView.Adapter<PostViewAdapter.ViewHolder> {

    private List<String> mediaUrls;
    private LayoutInflater mInflater;


    // data is passed into the constructor
    public PostViewAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mediaUrls = data;
    }


    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.post_card, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final CardView cd = holder.card;
        final LinearLayout postCard = holder.postCard;
        final ImageView imageView = holder.imageTime;
        final VideoView videoView = holder.videoTime;

        // Hide both views
        imageView.setVisibility(View.GONE);
        videoView.setVisibility(View.GONE);

        videoView.stopPlayback(); // stop play back for a reused view

        /*
        Demo media Urls contains mp4 and jpg
        List<String> mediaUrls = Arrays.asList("https://funnymemes.funnyjunk.com/movies/Meme_042a09_6211432.mp4",
                                         "https://memeworld.funnyjunk.com/pictures/Avaricious+preparatory+mitigated+kingfisher_c80ce6_7780034.jpg",
                                         "https://funnymemes.funnyjunk.com/movies/Meme_7a7f88_6211432.mp4");
         */


        // returns string used to distinguish the type of media (mp4,jpg)
        String mediaType = mediaUrls.get(position).substring(mediaUrls.get(position).length() - 3); // just return last three chars


        switch (mediaType) {
            case "mp4":
                videoView.setVisibility(View.VISIBLE);
                Uri video = Uri.parse(mediaUrls.get(position));
                videoView.setVideoURI(video);
                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                        videoView.start();
                    }
                });
                break;
            case "jpg":
                imageView.setVisibility(View.VISIBLE);
                // use picasso for async request for images
                Picasso.get()
                        .load(mediaUrls.get(position))
                        .error(R.drawable.ic_image)
                        .into(imageView);
                break;
            default:
                Log.e("Unknown Media Type ",mediaType);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mediaUrls.size();
    }

    // recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder  {

         CardView card;
         LinearLayout postCard;
         ImageView imageTime;
         VideoView videoTime;

        ViewHolder(View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.cvManana);
            postCard = itemView.findViewById(R.id.post);
            imageTime = itemView.findViewById(R.id.image_timeline);
            videoTime = itemView.findViewById(R.id.video_timeline);

        }

    }

}

