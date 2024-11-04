package com.example.arture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.arture.ui.theme.ArtureTheme
import navigation.NavigationRoutes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ArtureTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    val currentBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = currentBackStackEntry?.destination?.route
                    var showFooterMenu by remember{
                        mutableStateOf(false)
                    }

                    NavHost(navController = navController, startDestination = NavigationRoutes.signIn, builder = {
                        composable(NavigationRoutes.signIn) {
                            signInScreen()
                        }
                        composable(NavigationRoutes.beranda) {
                            homePageScreen()
                            LaunchedEffect(Unit){
                                showFooterMenu = true
                            }
                        }
                    })

                    if (showFooterMenu && currentRoute != NavigationRoutes.signIn)
                        footerMenuScreen(modifier = Modifier.align(Alignment.BottomCenter))
                }
                //signInScreen()
                //Greeting("Marcel")
            }
        }
    }
}

@Composable
fun linearBgBrush(isVerticalGradient: Boolean, colors: List<Color>): Brush {
    val endOffset = if (isVerticalGradient) {
        Offset(0f, Float.POSITIVE_INFINITY)
    } else {
        Offset(Float.POSITIVE_INFINITY, 0f)
    }

    return Brush.linearGradient(
        colors = colors,
        start = Offset.Zero,
        end = endOffset
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtureTheme {

    }
}