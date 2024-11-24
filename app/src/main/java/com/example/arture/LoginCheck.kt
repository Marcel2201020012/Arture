package com.example.arture

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.arture.data.DataStore
import kotlinx.coroutines.delay
import navigation.NavigationRoutes

@Composable
fun LoginCheckScreen(navController: NavController, dataStore: DataStore) {
    val statusLogIn = dataStore.getStatusLogin.collectAsState(initial = false)

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center // Center the loading indicator
    ) {
        CircularProgressIndicator(color = Color.Blue) // Loading circle
    }

    LaunchedEffect(
        key1 = true,
        block = {
            delay(1000L)
            if (statusLogIn.value) {
                navController.navigate(NavigationRoutes.beranda) {
                    popUpTo(NavigationRoutes.loginCheck) {
                        inclusive = true
                    }
                }
            } else {
                navController.navigate(NavigationRoutes.flogIn) {
                    popUpTo(NavigationRoutes.loginCheck) {
                        inclusive = true
                    }
                }
            }
        })
}