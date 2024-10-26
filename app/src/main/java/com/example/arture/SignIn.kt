@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.arture

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.arture.ui.theme.fontFamily

@Composable
fun signInScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 50.dp)
        , verticalArrangement = Arrangement.SpaceEvenly
        , horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.logo_text),
            contentDescription = "logo_app"
            , modifier = Modifier
                .width(126.dp))
        Box(modifier = Modifier
            .scale(0.8f)
            .clip(shape = RoundedCornerShape(24.dp))
            .background(Color.White)
            .width(400.dp)
            .height(525.dp)
            ){
            Column(modifier = Modifier.padding(32.dp)) {
                var userName by rememberSaveable { mutableStateOf("") }
                var email by rememberSaveable { mutableStateOf("") }
                var pass by rememberSaveable { mutableStateOf("") }
                var conPass by rememberSaveable { mutableStateOf("")}

                var passVisible by remember { mutableStateOf(false) }
                val eye = if(passVisible)
                    painterResource(id = R.drawable.eyeinvisible)
                else
                    painterResource(id = R.drawable.eye)

                var conPassVisible by remember { mutableStateOf(false) }
                val eyeCon = if(conPassVisible)
                    painterResource(id = R.drawable.eyeinvisible)
                else
                    painterResource(id = R.drawable.eye)

                var isMasukClicked by remember { mutableStateOf(false) }
                val masukTextColor = if (isMasukClicked)
                    Color.Red
                else
                    Color.Black

                Text(text = "Daftar"
                    , fontFamily = fontFamily
                    , style = TextStyle(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFF387B382), Color(0xFF0C0E0C))
                        )
                    )
                    , fontSize = 24.sp
                    , fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))

                Text(text = "Nama Pengguna"
                    , fontFamily = fontFamily
                    , fontSize = 15.sp
                    , style = MaterialTheme.typography.bodyLarge)
                OutlinedTextField(value = userName
                    , modifier = Modifier.fillMaxWidth()
                    , onValueChange = {userName = it}
                    , singleLine = true
                    , colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.White
                        , focusedBorderColor = Color.White)
                    , trailingIcon = {
                        Icon(painter = painterResource(id = R.drawable.user_logo)
                            , contentDescription = "user_logo")
                    })
                Divider(color = Color.Black)
                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Email"
                    , fontFamily = fontFamily
                    , style = MaterialTheme.typography.bodyLarge
                    , fontSize = 15.sp)
                OutlinedTextField(value = email
                    , onValueChange = {email = it}
                    , modifier = Modifier.fillMaxWidth()
                    , singleLine = true
                    , colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.White
                        , focusedBorderColor = Color.White)
                    , trailingIcon = {
                        Icon(painter = painterResource(id = R.drawable.mail)
                            , contentDescription = "gmail_logo"
                            , modifier = Modifier.size(28.dp))
                    })
                Divider(color = Color.Black)
                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Kata Sandi"
                    , fontFamily = fontFamily
                    , style = MaterialTheme.typography.bodyLarge
                    , fontSize = 15.sp)
                OutlinedTextField(value = pass
                    , onValueChange = {pass = it}
                    , modifier = Modifier.fillMaxWidth()
                    , singleLine = true
                    , colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.White
                        , focusedBorderColor = Color.White)
                    , trailingIcon = {
                        IconButton(onClick = {passVisible = !passVisible}) {
                            Icon(painter = eye
                                , contentDescription = "eye_status_1"
                                , modifier = Modifier.size(28.dp))
                        }
                    }
                    , visualTransformation = if(passVisible) PasswordVisualTransformation() else VisualTransformation.None)
                Divider(color = Color.Black)
                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Konfirmasi Kata Sandi"
                    , fontFamily = fontFamily
                    , style = MaterialTheme.typography.bodyLarge
                    , fontSize = 15.sp)
                OutlinedTextField(value = conPass
                    , onValueChange = {conPass = it}
                    , modifier = Modifier.fillMaxWidth()
                    , singleLine = true
                    , colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.White
                        , focusedBorderColor = Color.White)
                    , trailingIcon = {
                        IconButton(onClick = { conPassVisible = !conPassVisible }) {
                            Icon(painter = eyeCon
                                , contentDescription = "eye_status_2"
                                , modifier = Modifier.size(28.dp))
                        }
                    }
                    , visualTransformation = if(conPassVisible) PasswordVisualTransformation() else VisualTransformation.None)
                Divider(color = Color.Black)
                Spacer(modifier = Modifier.height(8.dp))

                Button(onClick = {
                                 navController.navigate("testPage")
                }
                    , modifier = Modifier.fillMaxWidth()
                    , colors = ButtonDefaults.buttonColors(Color(0xFFF8B402))) {
                    Text(text = "Daftar"
                        , fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.Center
                    , modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Sudah punya akun? "
                        , fontFamily = fontFamily
                        , style = MaterialTheme.typography.bodyLarge
                        , fontSize = 12.sp
                    )
                    ClickableText(
                        text = buildAnnotatedString { withStyle(style = androidx.compose.ui.text.SpanStyle(
                                                        fontWeight = FontWeight.Bold,
                                                        fontFamily = fontFamily,
                                                        textDecoration = TextDecoration.Underline,
                                                        color = masukTextColor
                                                    )){
                            append("Masuk")
                        }}
                        , onClick = {isMasukClicked = !isMasukClicked})
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun signInView() {
//    signInScreen()
//}