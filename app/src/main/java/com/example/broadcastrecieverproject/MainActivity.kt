package com.example.broadcastrecieverproject

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.broadcastrecieverproject.screens.Music
import com.example.broadcastrecieverproject.screens.NotificationScreen
import com.example.broadcastrecieverproject.screens.NumberScreen
import com.example.broadcastrecieverproject.screens.bottomBar
import com.example.broadcastrecieverproject.service.MusicPlayerService
import com.example.broadcastrecieverproject.ui.theme.BroadcastRecieverProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        enableEdgeToEdge()
        setContent {
            BroadcastRecieverProjectTheme {
                val navController = rememberNavController()
                Scaffold (
                    bottomBar = { bottomBar(Modifier.navigationBarsPadding(), navController = navController) },
                    content = {
                        paddingValues ->
                        Box(modifier = Modifier.padding(paddingValues)) {
                            Navigation(navController = navController)
                        }
                    }
                )

            }
        }
    }
}

@Composable
fun Navigation(modifier: Modifier = Modifier,navController: NavHostController) {
    NavHost(navController = navController, startDestination ="notification"){
        composable("notification"){
            NotificationScreen(modifier,context = LocalContext.current)
        }
        composable("music"){
            Music(modifier,context = LocalContext.current)
        }
        composable("number"){
            NumberScreen(modifier,context = LocalContext.current)
        }

    }


}



