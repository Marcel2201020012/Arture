package com.example.arture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ArtureTheme {
                val colorList = listOf(
                    Color(0xFFFAF5E4),
                    Color(0xFF90A955)
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = linearBgBrush(
                                isVerticalGradient = true, colors = colorList
                            )
                        )
                ) {
                    val navController = rememberNavController()
                    val currentBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = currentBackStackEntry?.destination?.route

                    NavHost(navController = navController, startDestination = "SignIn", builder = {
                        composable("SignIn") {
                            signInScreen(navController)
                        }
                        composable("homePage") {
                            homePageScreen()
                        }
                    })

                    if (currentRoute != "SignIn")
                        footerMenuScreen(modifier = Modifier.align(Alignment.BottomCenter))
                }
                //signInScreen()
                //Greeting("Marcel")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun linearBgBrush(isVerticalGradient: Boolean, colors: List<Color>): Brush {
    val endOffset = if(isVerticalGradient){
        Offset(0f, Float.POSITIVE_INFINITY)
    }
    else{
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
        //Greeting("Android")
    }
}