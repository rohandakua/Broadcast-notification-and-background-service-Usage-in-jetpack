package com.example.broadcastrecieverproject.screens

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.broadcastrecieverproject.service.MusicPlayerService

@Preview
@Composable
fun Music(modifier: Modifier=Modifier,context: Context= LocalContext.current) {
    var intent = Intent(context, MusicPlayerService::class.java)


//    musicPlayerService.onStartCommand(intent=intent, flags = 0, startId = 0)

    Box(
        modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally


        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        context.startService(intent)
                    },
                    colors = ButtonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Red,
                        disabledContainerColor = Color.DarkGray,
                        disabledContentColor = Color.White
                    )
                ) {
                    Text(text = "Play Music")
                }
                Button(onClick = {
                    context.stopService(intent)
                },
                    colors = ButtonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Red,
                        disabledContainerColor = Color.DarkGray,
                        disabledContentColor = Color.White
                    )) {
                    Text(text = "Stop Music")
                }
            }

        }

    }

}