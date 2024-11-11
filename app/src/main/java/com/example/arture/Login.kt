package com.example.arture

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.arture.ui.theme.poppinsFont
import navigation.NavigationRoutes

@Composable
fun LoginScreen(navController: NavController) {
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
                .fillMaxSize()
                .padding(top = 50.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_text), contentDescription = "logo",
                modifier = Modifier
                    .width(126.dp)
            )
            Box(
                modifier = Modifier
                    .scale(0.8f)
                    .clip(shape = RoundedCornerShape(24.dp))
                    .background(Color.White)
                    .width(400.dp)
                    .height(525.dp)
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    //verticalArrangement = Arrangement.Center,
                    //horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var email by rememberSaveable { mutableStateOf("") }
                    var pass by rememberSaveable { mutableStateOf("") }

                    var passVisible by remember { mutableStateOf(false) }
                    val eye = if (passVisible)
                        painterResource(id = R.drawable.eyeinvisible)
                    else
                        painterResource(id = R.drawable.eye)

                    var isDaftarClicked by remember { mutableStateOf(false) }
                    val daftarTextColor = if (isDaftarClicked)
                        Color.Red
                    else
                        Color.Black

                    Text(
                        text = "Masuk", fontFamily = poppinsFont, style = TextStyle(
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFF387B382), Color(0xFF0C0E0C))
                            )
                        ), fontSize = 24.sp, fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Email",
                        fontFamily = poppinsFont,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 15.sp
                    )
                    OutlinedTextField(value = email,
                        onValueChange = { email = it },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.White, unfocusedBorderColor = Color.White
                        ),
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.mail),
                                contentDescription = "gmail_logo",
                                modifier = Modifier.size(28.dp)
                            )
                        })
                    Divider(color = Color.Black)
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Kata Sandi",
                        fontFamily = poppinsFont,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 15.sp
                    )
                    OutlinedTextField(
                        value = pass,
                        onValueChange = { pass = it },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                        ),
                        trailingIcon = {
                            IconButton(onClick = { passVisible = !passVisible }) {
                                Icon(
                                    painter = eye,
                                    contentDescription = "eye_status_1",
                                    modifier = Modifier.size(28.dp)
                                )
                            }
                        },
                        visualTransformation = if (passVisible) PasswordVisualTransformation() else VisualTransformation.None
                    )
                    Divider(color = Color.Black)
                    Spacer(modifier = Modifier.height(8.dp))


                    Text(
                        "Lupa kata sandi?",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {

                        })

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            navController.navigate(NavigationRoutes.beranda) {
                                popUpTo(0) {
                                    inclusive = true
                                }
                                launchSingleTop = true
                            }
                        }, modifier = Modifier
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF8B402)
                        )
                    ) {
                        Text("Login", fontFamily = poppinsFont, color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row {
                            Text(
                                "belum punya akun? ",
                                fontFamily = poppinsFont,
                                fontSize = 12.sp
                            )

                            Text("Daftar",
                                fontFamily = poppinsFont,
                                fontWeight = FontWeight.Bold,
                                style = TextStyle(daftarTextColor),
                                modifier = Modifier.clickable {
                                    isDaftarClicked = !isDaftarClicked
                                })
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            "atau",
                            fontFamily = poppinsFont,
                            fontSize = 12.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            onClick = { }, modifier = Modifier
                                .fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFF8B402)
                            )
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.login_google_icon),
                                contentDescription = "google",
                                modifier = Modifier.size(18.dp),
                                tint = Color.Unspecified
                            )
                            Text(
                                "  Masuk dengan Google",
                                fontFamily = poppinsFont,
                                color = Color.White
                            )
                        }
                    }
                }


            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun Testloginscreen() {
    LoginScreen(navController = rememberNavController())
}