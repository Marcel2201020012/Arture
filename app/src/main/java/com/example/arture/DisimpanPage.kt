package com.example.arture

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.arture.ui.theme.poppinsFont
import model.ArtikelPopulerCardModel
import navigation.NavigationRoutes

@Composable
fun DisimpanPageScreen(navController: NavController) {
    val colorList = listOf(Color(0xFF90A955), Color(0xFFECF39E))

    //state top button
    var edukasiIsClicked by remember {
        mutableStateOf(true)
    }
    var pekerjaanIsClicked by remember {
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
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = {
                            navController.navigate(NavigationRoutes.beranda) {
                                popUpTo(0) {
                                    inclusive = true
                                }
                                launchSingleTop = true
                            }
                        }) {
                            Icon(
                                tint = Color.Unspecified,
                                painter = painterResource(id = R.drawable.back_arrow),
                                contentDescription = "back arrow"
                            )
                        }

                        //Disimpan Title
                        Text(
                            text = "Disimpan",
                            fontFamily = poppinsFont,
                            style = MaterialTheme.typography.titleLarge
                        )

                        Image(
                            painter = painterResource(id = R.drawable.disimpan_bg_bookmark_icon),
                            contentDescription = "bookmark icon",
                            Modifier.scale(0.8f)
                        )
                    }

                    //Disimpan Top Buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column(
                            modifier = Modifier
                                .width(180.dp)
                                .clickable {
                                    edukasiIsClicked = true
                                    pekerjaanIsClicked = false
                                },
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Edukasi",
                                fontFamily = poppinsFont,
                                style = MaterialTheme.typography.titleSmall,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )

                            AnimatedVisibility(visible = true) {
                                val underlineWidth by animateDpAsState(
                                    targetValue = if (edukasiIsClicked) 180.dp else 0.dp, label = ""
                                )
                                Box(
                                    modifier = Modifier
                                        .width(underlineWidth)
                                        .height(3.dp)
                                        .background(color = Color.White)
                                )
                            }
                        }
                        Column(
                            modifier = Modifier
                                .width(180.dp)
                                .clickable {
                                    pekerjaanIsClicked = true
                                    edukasiIsClicked = false
                                },
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Pekerjaan",
                                fontFamily = poppinsFont,
                                style = MaterialTheme.typography.titleSmall,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )

                            AnimatedVisibility(visible = true) {
                                val underlineWidth by animateDpAsState(
                                    targetValue = if (pekerjaanIsClicked) 180.dp else 0.dp,
                                    label = ""
                                )
                                Box(
                                    modifier = Modifier
                                        .width(underlineWidth)
                                        .height(3.dp)
                                        .background(color = Color.White)
                                )
                            }
                        }
                    }
                }

            }

            //List Artikel
            Column(
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (edukasiIsClicked) DisimpanArtikelView() else lowonganTerbaruView(navController)
            }
        }
    }
}

@Composable
fun DisimpanArtikelView() {
    val artikel = listOf(
        ArtikelPopulerCardModel(
            "Budidaya Tanaman Jagung dengan...",
            "Jagung merupakan salah satu komoditas tanaman pangan...",
            13,
            R.drawable.artikel_img_test
        ),
        ArtikelPopulerCardModel(
            "Budidaya Tanaman Jagung dengan...",
            "Jagung merupakan salah satu komoditas tanaman pangan...",
            13,
            R.drawable.artikel_img_test
        ),
        ArtikelPopulerCardModel(
            "Budidaya Tanaman Jagung dengan...",
            "Jagung merupakan salah satu komoditas tanaman pangan...",
            13,
            R.drawable.artikel_img_test
        ),
        ArtikelPopulerCardModel(
            "Budidaya Tanaman Jagung dengan...",
            "Jagung merupakan salah satu komoditas tanaman pangan...",
            13,
            R.drawable.artikel_img_test
        )
    )
    DisimpanArtikelGenerator(cardItem = artikel)
}

//@Preview
//@Composable
//fun TestDisimpanPageScreen() {
//    Box {
//        DisimpanPageScreen(rememberNavController())
//        footerMenuScreen(modifier = Modifier.align(Alignment.BottomCenter), rememberNavController(), currentRoute = null)
//    }
//}