package com.example.broadcastrecieverproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun bottomBar(modifier: Modifier=Modifier,navController: NavHostController = rememberNavController()) {
    Box(modifier = modifier
        .fillMaxWidth()
        .background(Color.Cyan)) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { navController.navigate("music") }) {
                Text(text = "Music")
                
            }
            Button(onClick = { navController.navigate("number") }) {
                Text(text = "Number")

            }
            Button(onClick = { navController.navigate("notification") }) {
                Text(text = "Notification")

            }


        }
    }


}