package com.example.booqr;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        String path = "android.resource://" + getPackageName() + "/" + R.raw.edited;
        playVideo(path);
    }

    private void playVideo(String videoUrl) {
        VideoView videoView = findViewById(R.id.video_view);

        // Use a MediaController so users can forward, pause and rewind.
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        // Specify the location of the video file
        videoView.setVideoURI(Uri.parse(videoUrl));

        // Attach the MediaController to the VideoView
        videoView.setMediaController(mediaController);

        // Start the VideoView
        videoView.start();
    }
}