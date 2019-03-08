package com.videoPlayer.filemanager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        String surgas = i.getStringExtra("Joss");
        Uri uri = Uri.parse(surgas);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        getActionBar().hide();

        if(surgas == null){
            Toast.makeText(this, "Maaf, video tidak dapat di putar" + surgas, Toast.LENGTH_SHORT).show();
        }

        VideoView simpleVideoView = (VideoView) findViewById(R.id.videoView); // initiate a video view
        simpleVideoView.setVideoURI(uri);
        simpleVideoView.start();

        MediaController mediaController = new MediaController(this);
        simpleVideoView.setMediaController(mediaController);
    }
}
