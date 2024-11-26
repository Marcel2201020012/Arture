package com.example.arture.app.edukasi

import EbookContent
import ExpandableCard
import ExpandableContentList
import TextContent
import VideoContent
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberBasicTooltipState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.arture.R
import com.example.arture.app.linearBgBrush
import com.example.arture.app.pekerjaan.DetailPekerjaanContent
import com.example.arture.data.DummyData
import model.ArtikelPopulerCardModel
import navigation.NavigationRoutes

@Composable
fun DetailEdukasi(
    navController: NavController,
    artikelsId: Int?
) {
    val newArtikelList = DummyData.artikelcard.filter { artikel ->
        artikel.id == artikelsId
    }
    Column {
        DetailEdukasiContent(
            newArtikelList = newArtikelList,
            navController = navController
        )
    }
}

@Composable
fun DetailEdukasiContent(
    newArtikelList: List<ArtikelPopulerCardModel>,
    navController: NavController,
) {
    val colorList = listOf(
        Color(0xFF90A956), Color(0xFFECF39E)
    )
    Box(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Column {
            Box {
                Text(
                    text = "uygsdugsdug",
                    fontSize = 44.sp,
                    color = Color.White
                )
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(266.dp),
                    painter = painterResource(id = newArtikelList[0].img),
                    contentDescription = "artikel_bg_icon",
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .background(
                            brush = linearBgBrush(
                                isVerticalGradient = false, colors = colorList
                            ),
                            shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                        )
                        .fillMaxWidth()
                        .height(80.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier.align(Alignment.TopEnd),
                        painter = painterResource(id = R.drawable.pekerjaan_daun_icon),
                        contentDescription = "beranda_bg_icon"
                    )
                    Column(
                    ) {
                        Row(
                            modifier = Modifier
                                //.background(color = Color.White)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(onClick = {
                                navController.navigateUp()
                            }) {
                                Image(
                                    painter = painterResource(id = R.drawable.statuspekerjaan_arrow_back_icon),
                                    contentDescription = "logo arrow"
                                )
                            }
                            Text(
                                text = "Artikel",
                                style = MaterialTheme.typography.titleLarge
                            )
                            Spacer(modifier = Modifier.width(45.dp))
                        }
                    }
                }
                Text(
                    text = newArtikelList[0].judul,
                   // fontSize = 44.sp,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.titleLarge.copy(
                        shadow = Shadow(
                            color = Color.Gray,              // Warna bayangan
                            offset = Offset(4f, 4f),         // Offset bayangan (horizontal, vertical)
                            blurRadius = 8f                  // Tingkat blur bayangan
                        )
                    ),
                    modifier = Modifier
                        .padding(start = 16.dp, top = 185.dp)
                        .fillMaxWidth()
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(680.dp)
                    .offset(y = (-12).dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    ExpandableCard(
                        title = "Artikel",
                        content = { TextContent(newArtikelList[0].desc) }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ExpandableCard(
                        title = "Video",
                        content = { VideoContent(newArtikelList[0].yt) }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ExpandableCard(
                        title = "E-Book",
                        content = { EbookContent(newArtikelList[0].ebook) }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview
@Composable
private fun DetailEdukasiTest() {
    DetailEdukasiContent(
        newArtikelList = DummyData.artikelcard,
        navController = rememberNavController()
    )
}