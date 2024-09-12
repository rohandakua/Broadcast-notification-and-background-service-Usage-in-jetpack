package com.example.broadcastrecieverproject.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.compose.runtime.DisposableEffect
import com.example.broadcastrecieverproject.service.NumberService

@Preview
@Composable
fun NumberScreen(modifier: Modifier = Modifier, context: Context = LocalContext.current) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        var text: MutableState<Int?> = remember { mutableStateOf(0) }
        var broadcastReceiver = remember {
            object : BroadcastReceiver() {
                override fun onReceive(p0: Context?, p1: Intent?) {
                    text.value= p1?.getStringExtra("number")?.toInt()
                }


            }
        }

        DisposableEffect(Unit) {
            val intentFilter = IntentFilter("SendNumber")
            context.registerReceiver(broadcastReceiver,intentFilter)
            onDispose {
                context.unregisterReceiver(broadcastReceiver)
            }
            
        }


        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = text.value.toString(),
                fontSize = 32.sp
            )
            Button(onClick = { context.startService(Intent(context, NumberService::class.java))}) {
                Text(text = "Start")
            }
            Button(onClick = { context.stopService(Intent(context, NumberService::class.java)) }) {
                Text(text = "End")
            }
        }


    }

}