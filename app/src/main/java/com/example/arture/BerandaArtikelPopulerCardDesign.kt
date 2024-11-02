package com.example.arture

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.Icon
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arture.ui.theme.fontFamily
import model.ArtikelPopulerCardModel

@Composable
fun BerandaCardDesign(item: ArtikelPopulerCardModel) {

    var bookmarkIsClicked by remember {
        mutableStateOf(false)
    }

    val bookmarkIcon = if (bookmarkIsClicked) R.drawable.beranda_artikel_bookmark_remove_icon
    else R.drawable.beranda_artikel_bookmark_add_icon

    Box(
        modifier = Modifier
            .size(
                width = 322.dp,
                height = 162.dp
            )
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFE6E6E6), Color(0xFF91DF9D)
                    )
                ), shape = RoundedCornerShape(16.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(
                    width = 320.dp, height = 160.dp
                )
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFFFFFFF), Color(0xFFA1F7AE)
                        )
                    ), shape = RoundedCornerShape(16.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box {
                            //judul
                            Text(
                                text = item.judul,
                                fontFamily = fontFamily,
                                style = TextStyle(Color(0xFF2D786C)),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.width(160.dp)
                            )

                            //jam
                            Row(modifier = Modifier.padding(top = 60.dp)) {
                                Icon(
                                    painter = painterResource(id = R.drawable.beranda_artikel_jam_icon),
                                    contentDescription = "logo jam"
                                )
                                Text(text = "  ${item.jam} jam yang lalu", fontSize = 8.sp)
                            }
                        }

                        //image
                        Box(
                            modifier = Modifier
                                .width(120.dp)
                                .height(80.dp)
                                .background(color, shape = RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = item.img),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    //desc
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = item.desc,
                            fontFamily = fontFamily,
                            fontSize = 12.sp,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.width(240.dp)
                        )
                        Icon(painter = painterResource(id = bookmarkIcon),
                            contentDescription = "bookmark",
                            tint = Color.Unspecified,
                            modifier = Modifier.clickable {
                                bookmarkIsClicked = !bookmarkIsClicked
                            })
                    }
                }
            }
        }
    }
}

@Composable
fun artikelPopulerGenerator(cardItem: List<ArtikelPopulerCardModel>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(cardItem) { item ->
            BerandaCardDesign(item)
        }
    }
}

@Preview
@Composable
fun testBerandaCardDesign() {
    BerandaCardDesign(
        item = ArtikelPopulerCardModel(
            "Tutorial Hidroponik Pemula yang Baik...",
            "Hidroponik adalah cara bercocok tanam dengan menggunakan air sebagai media...",
            13,
            R.drawable.lazy_test
        )
    )
}