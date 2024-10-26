package com.example.arture

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo",
            modifier = Modifier.size(250.dp))

        Text("Masuk", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = "", onValueChange = {}, label = {
              Text("Email")
        })

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = "", onValueChange = {}, label = {
            Text("Password")
        })

        Spacer(modifier = Modifier.height(16.dp))


        Text("Lupa kata sandi?", fontWeight = FontWeight.Bold, modifier = Modifier.clickable {

        })

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { }, modifier = Modifier.width(280.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF8B402)
            )) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text("belum punya akun? Daftar", modifier = Modifier.clickable {  })

        Spacer(modifier = Modifier.height(8.dp))

        Text("atau")

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { }, modifier = Modifier.width(280.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF8B402)
            )
            ) {
            Icon(painter = painterResource(id = R.drawable.google), contentDescription = "google",
                modifier = Modifier.size(18.dp))
            Text("  Masuk dengan Google")
        }






    }

}