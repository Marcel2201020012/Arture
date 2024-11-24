package com.example.arture.app.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.arture.R
import com.example.arture.data.DummyData
import com.example.arture.ui.theme.poppinsFont
import model.ArtikelPopulerCardModel
import model.DiskusiCardModel
import model.KomentarCardModel
import model.LowonganTerbaruCardModel
import navigation.NavigationRoutes

@Composable
fun BerandaArtikelCardDesign(item: ArtikelPopulerCardModel) {

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
                .clip(shape = RoundedCornerShape(16.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFFFFFFF), Color(0xFFA1F7AE)
                        )
                    )
                )
                .clickable { /*do stuff*/ }
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
                                fontFamily = poppinsFont,
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
                                    painter = painterResource(id = R.drawable.beranda_cards_jam_icon),
                                    contentDescription = "logo jam"
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(text = "${item.jam} jam yang lalu", fontSize = 8.sp)
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
                            fontFamily = poppinsFont,
                            fontSize = 12.sp,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.width(240.dp)
                        )
                        Icon(painter = painterResource(id = bookmarkIcon),
                            contentDescription = "bookmark",
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .size(32.dp)
                                .clickable {
                                    bookmarkIsClicked = !bookmarkIsClicked
                                })
                    }
                }
            }
        }
    }
}

@Composable
fun BerandaLowonganCardDesign(lowongan: LowonganTerbaruCardModel,
                              navController: NavController,
                              onItemClicked: (Int) -> Unit) {
    Box(
        modifier = Modifier
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(16.dp)
            )
            .size(width = 382.dp, height = 122.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                )
                .size(width = 380.dp, height = 120.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(lowongan.img),
                    contentDescription = "Logo PT",
                    modifier = Modifier
                        .size(86.dp)
                        .padding(5.dp)
                )

                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxHeight()
                        .width(200.dp)
                ) {
                    Text(
                        text = lowongan.judul,
                        fontFamily = poppinsFont,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2D786C),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = lowongan.pt,
                        fontFamily = poppinsFont,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = lowongan.alamat,
                        fontFamily = poppinsFont,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.beranda_cards_jam_icon),
                            contentDescription = "logo jam"
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "${lowongan.jam} jam yang lalu",
                            fontFamily = poppinsFont,
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 8.sp
                        )
                    }
                }

                IconButton(onClick = {onItemClicked(lowongan.id)}) {
                    Image(
                        painter = painterResource(id = R.drawable.beranda_lowongan_arrow),
                        contentDescription = "logo arrow"
                    )
                }
            }
        }
    }
}

@Composable
fun DisimpanArtikelDesign(item: ArtikelPopulerCardModel) {
    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .size(width = 362.dp, height = 162.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFDADE91),
                            Color.LightGray
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color(0xFFF2F7A1), Color.White)
                        )
                    )
                    .size(width = 360.dp, height = 160.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(120.dp),
                        painter = painterResource(id = R.drawable.disimapan_artikel_img_test),
                        contentDescription = "gambar artikel"
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item.judul,
                            fontFamily = poppinsFont,
                            style = TextStyle(Color(0xFF2D786C)),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.width(160.dp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = item.desc,
                            fontFamily = poppinsFont,
                            fontSize = 12.sp,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.width(240.dp)
                        )
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.beranda_cards_jam_icon),
                                    contentDescription = "logo jam"
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(text = "${item.jam} jam yang lalu", fontSize = 8.sp)
                            }

                            Icon(
                                tint = Color.Unspecified,
                                painter = painterResource(id = R.drawable.beranda_artikel_bookmark_remove_icon),
                                contentDescription = "logo bookmark"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DiskusiCardDesign(item: DiskusiCardModel, onAnswerClick: (DiskusiCardModel) -> Unit) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color.LightGray)
            .size(362.dp, 162.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .size(360.dp, 160.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Box(
                        contentAlignment = Alignment.Center, modifier = Modifier
                            .clip(shape = CircleShape)
                            .background(
                                color = Color.Gray
                            )
                            .size(34.dp)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center, modifier = Modifier
                                .clip(shape = CircleShape)
                                .background(
                                    color = Color.White
                                )
                                .size(32.dp)
                        ) {
                            Icon(
                                painter = painterResource(
                                    id = R.drawable.beranda_profile_picture
                                ), contentDescription = "profile_picture", tint = Color.Unspecified
                            )
                        }

                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item.nama,
                            style = MaterialTheme.typography.labelMedium
                        )
                        Text(
                            text = item.status,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }

                Text(
                    text = item.pertanyaan,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        onClick = { onAnswerClick(item) },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF8B402)
                        )
                    ) {
                        Text(
                            text = "Lihat Selengkapnya",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.diskusi_jawaban_counter_icon),
                            contentDescription = "jawaban icon",
                            tint = Color.Unspecified
                        )
                        Text(
                            text = "${item.jawaban} Jawaban",
                            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun KomentarCardDesign(item: KomentarCardModel) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color.LightGray)
            .size(362.dp, 102.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .size(360.dp, 100.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row {
                    Box(
                        contentAlignment = Alignment.Center, modifier = Modifier
                            .clip(shape = CircleShape)
                            .background(
                                color = Color.Gray
                            )
                            .size(34.dp)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center, modifier = Modifier
                                .clip(shape = CircleShape)
                                .background(
                                    color = Color.White
                                )
                                .size(32.dp)
                        ) {
                            Icon(
                                painter = painterResource(
                                    id = R.drawable.beranda_profile_picture
                                ), contentDescription = "profile_picture", tint = Color.Unspecified
                            )
                        }

                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item.nama,
                            style = MaterialTheme.typography.labelMedium
                        )
                        Text(
                            text = item.status,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }

                Text(
                    text = item.komentar,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
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
            BerandaArtikelCardDesign(item)
        }
    }
}

@Composable
fun lowonganTerbaruGenerator(
    cardItem: List<LowonganTerbaruCardModel>,
    navController: NavController) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(cardItem, key = { it.id }) {
            BerandaLowonganCardDesign(lowongan = it, navController)
            { lowonganId -> navController.navigate(
                    NavigationRoutes.detailPekerjaan + "/$lowonganId"
                )
            }
        }
    }
}

@Composable
fun DisimpanArtikelGenerator(cardItem: List<ArtikelPopulerCardModel>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(cardItem) { item ->
            DisimpanArtikelDesign(item)
        }
    }
}

@Composable
fun DiskusiGenerator(cardItem: List<DiskusiCardModel>, onAnswerClick: (DiskusiCardModel) -> Unit) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(cardItem) { item ->
            DiskusiCardDesign(item, onAnswerClick)
        }
    }
}

@Composable
fun KomentarGenerator(cardItem: List<KomentarCardModel>){
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(cardItem) { item ->
            KomentarCardDesign(item)
        }
    }
}

@Preview
@Composable
fun testBerandaCardDesign() {
//    BerandaArtikelCardDesign(
//        item = ArtikelPopulerCardModel(
//            "Tutorial Hidroponik Pemula yang Baik...",
//            "Hidroponik adalah cara bercocok tanam dengan menggunakan air sebagai media...",
//            13,
//            R.drawable.artikel_img_test
//        )
//    )
    Column {
        BerandaLowonganCardDesign(
            lowongan = LowonganTerbaruCardModel(
                id = 1,
                judul = "Technical Sales Feedmill",
                pt = "PT. Sreeya Sewu Indonesia, Tbk",
                alamat = "Blitar, Jawa Timur",
                jam = 13,
                img = R.drawable.lowongan_img_test,
                kualifikasi = " ",
                pertanyaan = " "
            ),
            navController = rememberNavController(),
            onItemClicked = {}
        )
        BerandaLowonganCardDesign(
            lowongan = LowonganTerbaruCardModel(
                id = 2,
                judul = "Field Officer",
                pt = "PT Berindo Jaya",
                alamat = "Bandar Lampung, Lampung",
                jam = 13,
                img = R.drawable.lowongan_img_barindojaya,
                kualifikasi = " ",
                pertanyaan = " "
            ),
            navController = rememberNavController(),
            onItemClicked = {}
        )
    }
//    DisimpanArtikelDesign(
//        item = ArtikelPopulerCardModel(
//            "Budidaya Tanaman Jagung dengan...",
//            "Jagung merupakan salah satu komoditas tanaman pangan...",
//            13,
//            R.drawable.artikel_img_test
//        )
//    )
//    DiskusiCardDesign(
//        item = DiskusiCardModel(
//            R.drawable.beranda_profile_picture,
//            "Muhammad Sumbul",
//            "Petani",
//            "Halo semua, musim kemarau ini cukup panjang dan saya khawatir dengan irigasi di lahan saya. Ada ya...",
//            25,
//            13
//        ),
//        onAnswerClick = {}
//    )
//    KomentarCardDesign(
//        item =
//        KomentarCardModel(
//            R.drawable.beranda_profile_picture,
//            "Muhammad Sumbul",
//            "Petani",
//            "Sama mas tempat saya juga begitu😥"
//        )
//    )
}