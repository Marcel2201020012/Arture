package com.example.arture

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arture.ui.theme.fontFamily

@Composable
fun homePageScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 24.dp, start = 16.dp, end = 16.dp
                )
        ) {
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .background(
                                color = Color.White,
                                shape = CircleShape
                            )
                            .size(36.dp)
                            .clickable {
                                //do stuff
                            }) {
                        Icon(
                            painter = painterResource(id = R.drawable.beranda_notif_icon),
                            contentDescription = "notif_icon",
                            tint = Color.Unspecified,
                            modifier = Modifier.scale(0.9f)
                        )
                    }
                    Box(contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .background(
                                color = Color.White,
                                shape = CircleShape
                            )
                            .size(48.dp)
                            .clickable {
                                //do stuff
                            }) {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.beranda_profile_picture
                            ),
                            contentDescription = "profile_picture",
                            tint = Color.Unspecified
                        )
                    }
                }
                Text(
                    text = "Hello,",
                    fontFamily = fontFamily,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Text(
                    text = "Hi Asep",
                    fontFamily = fontFamily,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 28.sp,
                    color = Color.Black
                )
            }
        }

        Box(
            modifier = Modifier
                .background(
                    color = Color.Gray,
                    shape = RoundedCornerShape(
                        topStart = 12.dp,
                        topEnd = 12.dp
                    )
                )
                .fillMaxSize()
        ) {
            Column(verticalArrangement = Arrangement.Bottom) {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun test() {
    homePageScreen()
}