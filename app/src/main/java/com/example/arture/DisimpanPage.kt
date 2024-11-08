package com.example.arture

import android.icu.text.ListFormatter.Width
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.arture.ui.theme.poppinsFont
import java.security.AllPermission

@Composable
fun DisimpanPageScreen() {
    val colorList = listOf(Color(0xFF90A955), Color(0xFFECF39E))

    //state top button

    var edukasiIsClicked by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .background(
                color = Color.White
            )
            .fillMaxSize()
    ) {
        //TopBar
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                    .background(
                        brush = linearBgBrush(
                            isVerticalGradient = false,
                            colors = colorList
                        )
                    )
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = "")
                    Image(
                        painter = painterResource(id = R.drawable.disimpan_bg_bookmark_icon),
                        contentDescription = "bookmark icon"
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 16.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //Disimpan Title
                    Text(
                        text = "Disimpan",
                        fontFamily = poppinsFont,
                        style = MaterialTheme.typography.titleLarge
                    )

                    //Disimpan Top Buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Column(
                            modifier = Modifier
                                .width(140.dp)
                                .clickable { edukasiIsClicked = !edukasiIsClicked },
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Edukasi",
                                fontFamily = poppinsFont,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )

                            AnimatedVisibility(visible = true) {
                                val underlineWidth by animateDpAsState(
                                    targetValue = if (edukasiIsClicked) 140.dp else 0.dp
                                )
                                Box(
                                    modifier = Modifier
                                        .width(underlineWidth)
                                        .height(1.dp)
                                        .background(color = Color.Black)
                                )
                            }
                        }
                        Column() {
                            Text(
                                text = "Pekerjaan",
                                fontFamily = poppinsFont
                            )
                        }


                    }
                }


            }
        }
    }

    //Konten
}

@Preview
@Composable
fun TestDisimpanPageScreen() {
    DisimpanPageScreen()
}