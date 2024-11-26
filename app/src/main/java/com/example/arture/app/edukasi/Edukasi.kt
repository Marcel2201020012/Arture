package com.example.arture.app.edukasi

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.arture.R
import com.example.arture.app.footerMenuScreen
import com.example.arture.app.home.DisimpanArtikelView
import com.example.arture.app.home.artikelPopulerView
import com.example.arture.app.linearBgBrush
import com.example.arture.ui.theme.poppinsFont
import navigation.NavigationRoutes

@Composable
fun Edukasi(
    navController: NavController
) {
    val colorList = listOf(
        Color(0xFF90A956), Color(0xFFECF39E)
    )
    Box(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Column (
            Modifier.padding(bottom = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var text by remember { mutableStateOf("") }
            var active by remember { mutableStateOf(false) }
            Column{
                Box(
                    modifier = Modifier
                        .background(
                            brush = linearBgBrush(
                                isVerticalGradient = false, colors = colorList
                            ),
                            shape = RoundedCornerShape(bottomStart = 36.dp, bottomEnd = 36.dp)
                        )
                        .fillMaxWidth()
                        .height(168.dp),
                       // .padding(top = 10.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        modifier = Modifier.align(Alignment.TopEnd),
                        painter = painterResource(id = R.drawable.edukasi_shape_icon),
                        contentDescription = "edukasi_bg_icon"
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ){
                        Row(
                            modifier = Modifier
                                //.background(color = Color.White)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(onClick = {
                                navController.navigate(NavigationRoutes.beranda) {
                                    popUpTo(NavigationRoutes.beranda) {
                                        inclusive = true
                                    }
                                    launchSingleTop = true
                                }
                            }) {
                                Image(
                                    painter = painterResource(id = R.drawable.statuspekerjaan_arrow_back_icon),
                                    contentDescription = "logo arrow"
                                )
                            }
                            Text(
                                text = "Pekerjaan",
                                style = MaterialTheme.typography.titleLarge
                            )
                            Spacer(modifier = Modifier.width(45.dp))
                        }
                        Text(
                            text = "\"Jangan takut gagal! Belajar dari \n " +
                                    "kegagalan adalah cara terbaik untuk \n meraih kesuksesan.\"" +
                                    "\n" +
                                    "\n ",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            OutlinedTextField(
                modifier = Modifier
                    .offset(y = (-35).dp)
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(66.dp)
                    )
                    .padding(4.dp)
                    .width(355.dp),
                value = "Cari Artikel",
                onValueChange = { text = it },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.Transparent,
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search"
                    )
                }
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .offset(y = -15.dp)
            ) {
                Text(
                    text = "Artikel Yang Lagi Populer",
                    fontFamily = poppinsFont,
                    style = MaterialTheme.typography.bodyLarge
                )

                Image(painter = painterResource(id = R.drawable.beranda_lihat_semua_text),
                    contentDescription = "lihat semua",
                    modifier = Modifier.clickable { /*do stuff*/ })
            }
            Row {
                artikelPopulerView(navController)
            }
            Divider(
                color = Color.LightGray,
                modifier = Modifier
                    .padding(16.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                    .offset(y = (-15).dp)
            ) {
                Text(
                    text = "Artikel Lainnya",
                    fontFamily = poppinsFont,
                    style = MaterialTheme.typography.bodyLarge
                )

                Image(painter = painterResource(id = R.drawable.beranda_lihat_semua_text),
                    contentDescription = "lihat semua",
                    modifier = Modifier.clickable { /*do stuff*/ })
            }

            Column{
                DisimpanArtikelView(navController)
            }

        }
    }
}

@Preview
@Composable
private fun EdukasiTest() {
    Box {
        Edukasi(navController = rememberNavController())
        footerMenuScreen(
            modifier = Modifier.align(Alignment.BottomCenter),
            rememberNavController(),
            currentRoute = null
        )
    }
}
