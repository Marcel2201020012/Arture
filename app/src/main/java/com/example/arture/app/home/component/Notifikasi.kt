package com.example.arture.app.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.arture.R
import com.example.arture.app.linearBgBrush

@Composable
fun NotifikasiScreen(navController: NavController) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
                .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                .background(
                    brush = linearBgBrush(
                        isVerticalGradient = false,
                        colors = listOf(Color(0xFF90A955), Color(0xFFECF39E))
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.back_arrow),
                        contentDescription = "back arrow",
                        tint = Color.Unspecified
                    )
                }
                Text(text = "Notifikasi", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.width(45.dp))
            }
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(end = 12.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = "Tidak Ada Notifikasi Terbaru", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview (showBackground = true)
@Composable
fun TestNotifikasiScreen() {
    NotifikasiScreen(rememberNavController())
}