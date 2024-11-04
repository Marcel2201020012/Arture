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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arture.ui.theme.poppinsFont
import model.ArtikelPopulerCardModel
import model.LowonganTerbaruCardModel

@Composable
fun homePageScreen() {
    val colorList = listOf(
        Color(0xFF90A955), Color(0xFFECF39E)
    )

    //bg
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = linearBgBrush(
                    isVerticalGradient = false, colors = colorList
                )
            )
    ) {
        //bg icon
        Image(
            modifier = Modifier.align(Alignment.TopEnd),
            painter = painterResource(id = R.drawable.beranda_bg_icon),
            contentDescription = "beranda_bg_icon"
        )

        //header
        Column(
            modifier = Modifier.fillMaxSize()
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

                        //notification
                        Box(contentAlignment = Alignment.Center, modifier = Modifier
                            .clip(shape = CircleShape)
                            .background(
                                color = Color.White
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

                        //profil icon
                        Box(contentAlignment = Alignment.Center, modifier = Modifier
                            .clip(shape = CircleShape)
                            .background(
                                color = Color.White
                            )
                            .size(48.dp)
                            .clickable {
                                //do stuff
                            }) {
                            Icon(
                                painter = painterResource(
                                    id = R.drawable.beranda_profile_picture
                                ), contentDescription = "profile_picture", tint = Color.Unspecified
                            )
                        }
                    }

                    //greeting texts
                    Text(
                        text = "Hello,",
                        fontFamily = poppinsFont,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 24.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Hi Asep",
                        fontFamily = poppinsFont,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 28.sp,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .background(
                        color = Color(0xFFFAFFFD), shape = RoundedCornerShape(
                            topStart = 12.dp, topEnd = 12.dp
                        )
                    )
                    .fillMaxSize()
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Column(
                        modifier = Modifier
                            .padding(
                                top = 16.dp, end = 16.dp, start = 16.dp
                            )
                            .fillMaxWidth()
                            .background(Color.White)
                    ) {

                        //beranda top buttons
                        Row(
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {

                            Surface (
                                shadowElevation = 8.dp,
                                shape = RoundedCornerShape(16.dp)
                            ){
                                //disimpan
                                Box(
                                    modifier = Modifier
                                        .size(
                                            width = 106.dp,
                                            height = 82.dp
                                        )
                                        .background(
                                            color = Color.LightGray,
                                            shape = RoundedCornerShape(16.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Box(contentAlignment = Alignment.Center, modifier = Modifier
                                        .size(
                                            width = 104.dp, height = 80.dp
                                        )
                                        .clip(shape = RoundedCornerShape(16.dp))
                                        .background(
                                            color = Color.White
                                        )
                                        .clickable { /*do stuff*/ }) {
                                        Image(
                                            painter = painterResource(id = R.drawable.beranda_disimpan_icon),
                                            contentDescription = "disimpan icon"
                                        )
                                    }
                                }
                            }


                            //status pekerjaan
                            Box(
                                modifier = Modifier
                                    .size(
                                        width = 106.dp,
                                        height = 82.dp
                                    )
                                    .background(
                                        color = Color.LightGray,
                                        shape = RoundedCornerShape(16.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(contentAlignment = Alignment.Center, modifier = Modifier
                                    .size(
                                        width = 104.dp, height = 80.dp
                                    )
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .background(
                                        color = Color.White
                                    )
                                    .clickable { /*do stuff*/ }) {
                                    Image(
                                        painter = painterResource(id = R.drawable.beranda_status_pekerjaan_icon),
                                        contentDescription = "status pekerjaan icon"
                                    )
                                }
                            }

                            //riwayat
                            Box(
                                modifier = Modifier
                                    .size(
                                        width = 106.dp,
                                        height = 82.dp
                                    )
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .background(
                                        color = Color.LightGray
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(contentAlignment = Alignment.Center, modifier = Modifier
                                    .size(
                                        width = 104.dp, height = 80.dp
                                    )
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .background(
                                        color = Color.White
                                    )
                                    .clickable { /*do stuff*/ }) {
                                    Image(
                                        painter = painterResource(id = R.drawable.beranda_riwayat_icon),
                                        contentDescription = "riwayat icon"
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))

                        //artikel
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Artikel Yang Lagi Populer",
                                fontFamily = poppinsFont,
                                fontWeight = FontWeight.Bold
                            )

                            Image(painter = painterResource(id = R.drawable.beranda_lihat_semua_text),
                                contentDescription = "lihat semua",
                                modifier = Modifier.clickable { /*do stuff*/ })
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    //Artikel Populer
                    Row {
                        artikelPopulerView()
                    }

                    //lowongan terbaru
                    Column(
                        modifier = Modifier
                            .padding(
                                end = 16.dp, start = 16.dp
                            )
                            .fillMaxWidth()
                            .background(Color.White)
                    ) {
                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Lowongan Terbaru",
                                fontFamily = poppinsFont,
                                fontWeight = FontWeight.Bold
                            )

                            Image(painter = painterResource(id = R.drawable.beranda_lihat_semua_text),
                                contentDescription = "lihat semua",
                                modifier = Modifier.clickable { /*do stuff*/ })
                        }
                        Spacer(modifier = Modifier.height(12.dp))

                        //Lowongan Card
                        Column(
                            modifier = Modifier
                                .height(128.dp)
                        ) {
                            lowonganTerbaruView()
                        }
                    }
                }
            }
        }
    }
}

//Artikel populer function
@Composable
fun artikelPopulerView() {
    val artikel = listOf(
        ArtikelPopulerCardModel(
            "Tutorial Hidroponik Pemula yang Baik...",
            "Hidroponik adalah cara bercocok tanam dengan menggunakan air sebagai media...",
            13,
            R.drawable.artikel_img_test
        ),
        ArtikelPopulerCardModel(
            "Tutorial Hidroponik Pemula yang Baik...",
            "Hidroponik adalah cara bercocok tanam dengan menggunakan air sebagai media...",
            13,
            R.drawable.artikel_img_test
        )
    )
    artikelPopulerGenerator(artikel)
}

//Lowongan kerja function
@Composable
fun lowonganTerbaruView() {
    val lowongan = listOf(
        LowonganTerbaruCardModel(
            "Technical Sales Feedmill",
            "PT. Sreeya Sewu Indonesia, Tbk",
            "Blitar, Jawa Timur",
            13,
            R.drawable.lowongan_img_test
        ),
        LowonganTerbaruCardModel(
            "Technical Sales Feedmill",
            "PT. Sreeya Sewu Indonesia, Tbk",
            "Blitar, Jawa Timur",
            13,
            R.drawable.lowongan_img_test
        ),
        LowonganTerbaruCardModel(
            "Technical Sales Feedmill",
            "PT. Sreeya Sewu Indonesia, Tbk",
            "Blitar, Jawa Timur",
            13,
            R.drawable.lowongan_img_test
        )
    )

    lowonganTerbaruGenerator(lowongan)
}

@Preview(showBackground = true)
@Composable
fun test() {
    Box {
        homePageScreen()
        footerMenuScreen(modifier = Modifier.align(Alignment.BottomCenter))
    }
}