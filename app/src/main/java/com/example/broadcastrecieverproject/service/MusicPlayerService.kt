package com.example.broadcastrecieverproject.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.MediaStore.Audio.Media
import android.util.Log
import com.example.broadcastrecieverproject.R

class MusicPlayerService:Service() {
    lateinit var song :MediaPlayer



    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        song.start()
        Log.d("music ","the music is playing")
        return START_STICKY
    }

    override fun onCreate() {
        Log.d("music ","the music is created")
        song = MediaPlayer.create(this, R.raw.ohayo)!!
        song.isLooping=true
        super.onCreate()

    }
    override fun onDestroy() {
        super.onDestroy()
        song.release()
        Log.d("music ","the music is stopped")
        stopSelf()
    }

}