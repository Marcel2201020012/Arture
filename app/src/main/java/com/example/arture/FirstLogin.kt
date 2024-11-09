package com.example.arture

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import navigation.NavigationRoutes

@Composable
fun FirstLogin(navController: NavController) {
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
        Column(
            modifier = Modifier
                .fillMaxSize(),

            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_text), contentDescription = "logo",
                modifier = Modifier
                    .width(126.dp)
                    .padding(bottom = 130.dp)
            )
            Box(modifier = Modifier
                .scale(0.8f)
                .clip(shape = RoundedCornerShape(24.dp))
                .background(Color.White)
                .width(400.dp)
                .height(200.dp),
                contentAlignment = Alignment.Center
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Button(
                        onClick = {
                            navController.navigate(NavigationRoutes.signIn){
                                popUpTo(0){
                                    inclusive = false
                                }
                                launchSingleTop = true
                            }
                        }, modifier = Modifier
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF8B402)
                        )
                    ) {
                        Text("Daftar")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedButton(
                        onClick = {
                            navController.navigate(NavigationRoutes.logIn){
                            popUpTo(NavigationRoutes.logIn){
                                inclusive = true
                            }
                        }

                        }, modifier = Modifier
                            .fillMaxWidth(),
                        border = BorderStroke(1.dp, Color(0xFFF8B402)),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color(0xFF387B38)
                        )

                    ) {
                        Text("Masuk")
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun FirstLoginView() {
    FirstLogin(navController = rememberNavController())
}