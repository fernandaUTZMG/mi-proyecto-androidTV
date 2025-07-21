package com.example.nefis

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import android.net.Uri
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView

class PlayActivity : FragmentActivity() {

    companion object{
        const val MOVIE_EXTRA="extra:movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        val videoView = findViewById<VideoView>(R.id.videoView)

        val video: Video? =intent.getParcelableExtra<Video>(PlayActivity.MOVIE_EXTRA)

        var path=""
        if (video != null) {
            path = "android.resource://" + packageName + "/" + video.video
        }

        val uri = Uri.parse(path)


        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()

    }
}