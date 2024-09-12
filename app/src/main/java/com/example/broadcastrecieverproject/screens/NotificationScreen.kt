package com.example.broadcastrecieverproject.screens

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.graphics.drawable.IconCompat
import com.example.broadcastrecieverproject.R
import com.example.broadcastrecieverproject.service.NumberService

@Preview
@Composable
fun NotificationScreen(modifier: Modifier=Modifier,context: Context= LocalContext.current) {
    val channelId="number"
    val channel =NotificationChannel(channelId,"number", NotificationManager.IMPORTANCE_DEFAULT).apply {
        description="this is just a basic notification"
    }
    val notificationManager = context.getSystemService("notification") as NotificationManager
    notificationManager.createNotificationChannel(channel)

    val notification= NotificationCompat.Builder(context,"number")
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentText("Faltu Hai Bro")
        .setContentText("Kya bhai , ye bhi padne lag gya , kaam dhanda dhund bhai , nahi to chali jayegi wo")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)



    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {


        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {

            }
                NotificationManagerCompat.from(context).notify(1,notification.build())}) {
                Text(text = "Send Notification")
            }

        }


    }

}