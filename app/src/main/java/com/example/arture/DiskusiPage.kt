package com.example.arture

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.arture.ui.theme.poppinsFont
import model.DiskusiCardModel
import navigation.NavigationRoutes

@Composable
fun DiskusiPageScreen(navController: NavController) {

    //filter state
    var filterText by remember { mutableStateOf("Populer") }

    var populerIsClicked by remember { mutableStateOf(true) }
    var terbaruIsClicked by remember { mutableStateOf(false) }
    var relevanIsClicked by remember { mutableStateOf(false) }

    val populerIcon = if (populerIsClicked) {
        R.drawable.diskusi_filter_populer_active
    } else {
        R.drawable.diskusi_filter_populer_non_active
    }

    val terbaruIcon = if (terbaruIsClicked) {
        R.drawable.diskusi_filter_terbaru_active
    } else {
        R.drawable.diskusi_filter_terbaru_non_active
    }

    val relevanIcon = if (relevanIsClicked) {
        R.drawable.diskusi_filter_relevan_active
    } else {
        R.drawable.diskusi_filter_relevan_non_active
    }

    Box(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp)
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Header Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                    .background(
                        brush = linearBgBrush(
                            isVerticalGradient = false,
                            colors = listOf(Color(0xFF90A955), Color(0xFFECF39E))
                        )
                    )
            ) {
                //title
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                ) {
                    IconButton(onClick = {
                        navController.navigate(NavigationRoutes.beranda) {
                            popUpTo(NavigationRoutes.beranda) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }) {
                        Icon(
                            tint = Color.Unspecified,
                            painter = painterResource(id = R.drawable.back_arrow),
                            contentDescription = "logo back"
                        )
                    }
                    Text(
                        text = "Diskusi",
                        fontFamily = poppinsFont,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Image(
                        painter = painterResource(id = R.drawable.diskui_logo),
                        contentDescription = "logo diskusi"
                    )
                }
            }

            //Ajukan pertanyaan box
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .size(362.dp, 162.dp)
                    .background(
                        brush = Brush.linearGradient(
                            listOf(
                                Color.LightGray, Color(0xFFD9DE91)
                            )
                        )
                    ), contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .size(width = 360.dp, height = 160.dp)
                        .background(
                            brush = Brush.linearGradient(
                                listOf(
                                    Color.White, Color(0xFFF1F7A1)
                                )
                            )
                        )
                ) {
                    Column(
                        Modifier
                            .padding(20.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = "Ajukan Pertanyaan?", style = MaterialTheme.typography.labelLarge
                        )
                        Text(
                            text = "\"Pertanyaan sederhana sekalipun bisa jadi inspirasi. Yuk, tanyakan apapun yang kamu pikirkan.\"",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Button(
                            onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFF8B402)
                            )
                        ) {
                            Text(
                                text = "Tanya Sekarang",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }

            //filter
            Box(
                Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray)
                    .size(362.dp, 62.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                        .size(360.dp, 60.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFFEFF1F5))
                            .size(340.dp, 40.dp)
                            .scale(0.98f),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                tint = Color.Unspecified,
                                painter = painterResource(id = populerIcon),
                                contentDescription = "populer",
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .clickable {
                                        populerIsClicked = true
                                        terbaruIsClicked = false
                                        relevanIsClicked = false
                                        filterText = "Populer"
                                    }
                            )
                            Text(text = " | ")
                            Icon(
                                tint = Color.Unspecified,
                                painter = painterResource(id = terbaruIcon),
                                contentDescription = "Terbaru",
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .clickable {
                                        populerIsClicked = false
                                        terbaruIsClicked = true
                                        relevanIsClicked = false
                                        filterText = "Terbaru"
                                    }
                            )
                            Text(text = " | ")
                            Icon(
                                tint = Color.Unspecified,
                                painter = painterResource(id = relevanIcon),
                                contentDescription = "Relevant",
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .clickable {
                                        populerIsClicked = false
                                        terbaruIsClicked = false
                                        relevanIsClicked = true
                                        filterText = "Relevan"
                                    }

                            )
                        }
                    }
                }
            }

            //Diskusi Populer
            Row(
                Modifier.width(360.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Diskusi $filterText",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(text = "")
            }

            //konten Diskusi
            Column {
                DiskusiCardView()
            }
        }
    }
}

@Composable
fun DiskusiCardView() {
    val diskusi = listOf(
        DiskusiCardModel(
            R.drawable.beranda_profile_picture,
            "Muhammad Sumbul",
            "Petani",
            "Halo semua, musim kemarau ini cukup panjang dan saya khawatir dengan irigasi di lahan saya. Ada ya...",
            25
        ),
        DiskusiCardModel(
            R.drawable.beranda_profile_picture,
            "Muhammad Sumbul",
            "Petani",
            "Halo semua, musim kemarau ini cukup panjang dan saya khawatir dengan irigasi di lahan saya. Ada ya...",
            25
        ),
        DiskusiCardModel(
            R.drawable.beranda_profile_picture,
            "Muhammad Sumbul",
            "Petani",
            "Halo semua, musim kemarau ini cukup panjang dan saya khawatir dengan irigasi di lahan saya. Ada ya...",
            25
        ),
        DiskusiCardModel(
            R.drawable.beranda_profile_picture,
            "Muhammad Sumbul",
            "Petani",
            "Halo semua, musim kemarau ini cukup panjang dan saya khawatir dengan irigasi di lahan saya. Ada ya...",
            25
        )
    )
    DiskusiGenerator(diskusi)
}

@Preview
@Composable
fun TestDiskusiPage() {
    Box {
        DiskusiPageScreen(rememberNavController())
        footerMenuScreen(
            modifier = Modifier.align(Alignment.BottomCenter),
            rememberNavController(),
            currentRoute = null
        )
    }
}