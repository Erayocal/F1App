package com.example.mobilprogramlama;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";
    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initializeViews();
        setupVideoPlayer();
    }

    private void initializeViews() {
        youTubePlayerView = findViewById(R.id.youtubePlayerView);
    }

    private void setupVideoPlayer() {
        String videoId = getIntent().getStringExtra("VIDEO_ID");
        
        // Video ID'yi URL'den temizle
        if (videoId != null) {
            videoId = videoId.trim();
            if (videoId.contains("watch?v=")) {
                // URL'den video ID'yi ayıkla
                videoId = videoId.split("watch\\?v=")[1];
                // Ek parametreleri temizle
                if (videoId.contains("&")) {
                    videoId = videoId.split("&")[0];
                }
            }
        }

        Log.d(TAG, "Cleaned Video ID: " + videoId); // Debug için ID'yi logla

        getLifecycle().addObserver(youTubePlayerView);

        final String finalVideoId = videoId;
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                if (finalVideoId != null && !finalVideoId.isEmpty()) {
                    youTubePlayer.loadVideo(finalVideoId, 0);
                } else {
                    Toast.makeText(DetailActivity.this, 
                        "Video ID bulunamadı", 
                        Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onError(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlayerError error) {
                Toast.makeText(DetailActivity.this, 
                    "Video yüklenirken bir hata oluştu", 
                    Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (youTubePlayerView != null) {
            youTubePlayerView.release();
        }
    }
}
