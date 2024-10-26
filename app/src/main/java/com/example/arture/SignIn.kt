@file:OptIn(ExperimentalMaterial3Api::class)

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.round

@Composable
fun signInScreen() {
    Column(modifier = Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.logo_text),
            contentDescription = "logo_app"
            , modifier = Modifier
                .width(126.dp)
                .padding(top = 120.dp))
        Box(modifier = Modifier
            .padding(top = 60.dp)
            .clip(shape = RoundedCornerShape(24.dp))
            .background(Color.White)
            .width(346.dp)
            .height(467.dp)
            ){
            Column(modifier = Modifier.padding(32.dp)) {
                Text(text = "Masuk"
                    , fontSize = 24.sp
                    , fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(40.dp))
                Text(text = "Email", fontSize = 15.sp)

                val email = remember { mutableStateOf("") }

                TextField(value = email.value
                    , onValueChange = {email.value = it}
                    , textStyle = TextStyle(fontSize = 12.sp)
                    , colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
                    , modifier = Modifier.height(36.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun signInView() {
    signInScreen()
}