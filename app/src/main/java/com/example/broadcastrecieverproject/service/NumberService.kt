package com.example.broadcastrecieverproject.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NumberService : Service() {
    private var number= 0
    lateinit var job: Job

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
        stopSelf()
    }

    override fun onCreate() {
        super.onCreate()
        job = CoroutineScope(Dispatchers.Default).launch {
            while (true) {
                number++
                val intent = Intent("SendNumber")
                intent.putExtra("number", number.toString())
                sendBroadcast(intent)
                Log.d("number", number.toString())
                delay(500)
            }
        }


    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {



        return START_STICKY


    }
}