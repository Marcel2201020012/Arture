package com.example.arture.app

import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.arture.R
import com.example.arture.app.home.component.DiskusiGenerator
import com.example.arture.app.home.component.KomentarGenerator
import com.example.arture.ui.theme.poppinsFont
import model.DiskusiCardModel
import model.KomentarCardModel
import navigation.NavigationRoutes

class DiskusiViewModel : ViewModel() {
    var filterText by mutableStateOf("Populer")
}

@Composable
fun DiskusiPageScreen(navController: NavController, showFooterMenu: (Boolean) -> Unit) {
    val viewModel: DiskusiViewModel = remember { DiskusiViewModel() }

    //page state
    var currentPage by remember {
        mutableStateOf("main")
    }
    var bottomPadding by remember {
        mutableStateOf(0.dp)
    }

    when (currentPage) {
        "main" -> {
            showFooterMenu(true)
            bottomPadding = 80.dp
        }

        "pertanyaan", "jawaban" -> {
            showFooterMenu(false)
            bottomPadding = 0.dp
        }
    }

    //backhandler untuk mencegah user back ke homepage kalau bukan di layout main
    BackHandler {
        if (currentPage != "main") {
            currentPage = "main"
        } else {
            navController.popBackStack()
        }
    }

    var selectedItem by remember { mutableStateOf<DiskusiCardModel?>(null) }

    Box(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = bottomPadding)
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
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {
                        if (currentPage == "main") navController.navigate(NavigationRoutes.beranda) {
                            popUpTo(NavigationRoutes.beranda) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        } else currentPage = "main"
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

            when (currentPage) {
                "main" -> MainDiskusiScreen(
                    onAskClick = { currentPage = "pertanyaan" },
                    onAnswerClick = { item ->
                        selectedItem = item
                        currentPage = "jawaban"
                    }, viewModel
                )

                "pertanyaan" -> MasukkanPertanyaanScreen()
                "jawaban" -> selectedItem?.let { item ->
                    JawabanScreen(item)
                }
            }
        }
    }
}

@Composable
fun MainDiskusiScreen(
    onAskClick: () -> Unit,
    onAnswerClick: (DiskusiCardModel) -> Unit,
    viewModel: DiskusiViewModel
) {
    //filter state
    val populerIcon = if (viewModel.filterText == "Populer") {
        R.drawable.diskusi_filter_populer_active
    } else {
        R.drawable.diskusi_filter_populer_non_active
    }

    val terbaruIcon = if (viewModel.filterText == "Terbaru") {
        R.drawable.diskusi_filter_terbaru_active
    } else {
        R.drawable.diskusi_filter_terbaru_non_active
    }

    val relevanIcon = if (viewModel.filterText == "Relevan") {
        R.drawable.diskusi_filter_relevan_active
    } else {
        R.drawable.diskusi_filter_relevan_non_active
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
                    .fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Ajukan Pertanyaan?", style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = "\"Pertanyaan sederhana sekalipun bisa jadi inspirasi. Yuk, tanyakan apapun yang kamu pikirkan.\"",
                    style = MaterialTheme.typography.bodySmall
                )
                Button(
                    onClick = onAskClick,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF8B402)
                    )
                ) {
                    Text(
                        text = "Tanya Sekarang", style = MaterialTheme.typography.bodySmall
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
                    .scale(0.98f), contentAlignment = Alignment.Center
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(tint = Color.Unspecified,
                        painter = painterResource(id = populerIcon),
                        contentDescription = "populer",
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                viewModel.filterText = "Populer"
                            })
                    Text(text = " | ")
                    Icon(tint = Color.Unspecified,
                        painter = painterResource(id = terbaruIcon),
                        contentDescription = "Terbaru",
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                viewModel.filterText = "Terbaru"
                            })
                    Text(text = " | ")
                    Icon(tint = Color.Unspecified,
                        painter = painterResource(id = relevanIcon),
                        contentDescription = "Relevant",
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                viewModel.filterText = "Relevan"
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
            text = "Diskusi ${viewModel.filterText}", style = MaterialTheme.typography.bodyLarge
        )
        Text(text = "")
    }

    //konten Diskusi
    Column {
        DiskusiCardView(onAnswerClick, viewModel.filterText)
    }
}

@Composable
fun MasukkanPertanyaanScreen() {

    //pertanyaan state
    var pertanyaanText by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .size(362.dp, 242.dp)
            .background(Color.LightGray), contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .size(360.dp, 240.dp)
                .background(Color.White), contentAlignment = Alignment.Center
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Masukkan Pertanyaan",
                    style = MaterialTheme.typography.labelLarge.copy(Color.Gray)
                )

                Divider()

                OutlinedTextField(
                    value = pertanyaanText,
                    onValueChange = { pertanyaanText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    textStyle = MaterialTheme.typography.labelSmall.copy(Color.Black),
                    placeholder = {
                        Text(
                            "Masukkan pertanyaan Anda di sini...",
                            style = MaterialTheme.typography.labelSmall.copy(Color.Black)
                        )
                    },
                    maxLines = 10,
                    singleLine = false
                )

                Button(
                    onClick = { pertanyaanText = "" },
                    Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF8B402)
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Kirim", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}

@Composable
fun JawabanScreen(item: DiskusiCardModel) {

    //komentar state
    var komentarText by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
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
                                    ),
                                    contentDescription = "profile_picture",
                                    tint = Color.Unspecified
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
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.beranda_cards_jam_icon),
                            contentDescription = "logo jam"
                        )
                        Text(
                            text = "${item.jam} jam yang lalu",
                            style = MaterialTheme.typography.bodySmall.copy(fontSize = 8.sp)
                        )
                    }
                }
            }
        }

        Text(text = "Komentar (${item.jawaban})", style = MaterialTheme.typography.labelLarge)

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray)
                .size(362.dp, 82.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .size(360.dp, 80.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                ) {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
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
                                    ),
                                    contentDescription = "profile_picture",
                                    tint = Color.Unspecified
                                )
                            }

                        }

                        OutlinedTextField(
                            value = komentarText,
                            onValueChange = { komentarText = it },
                            modifier = Modifier
                                .size(200.dp, 60.dp),
                            textStyle = MaterialTheme.typography.labelSmall.copy(Color.Black),
                            placeholder = {
                                Text(
                                    "Masukkan komentar",
                                    style = MaterialTheme.typography.labelSmall.copy(Color.Gray)
                                )
                            },
                            maxLines = 1,
                            singleLine = true
                        )

                        Button(
                            onClick = { komentarText = "" },
                            Modifier.width(80.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFF8B402)
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(text = "Kirim", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }

        Column {
            KomentarCardView()
        }
    }
}

@Composable
fun DiskusiCardView(onAnswerClick: (DiskusiCardModel) -> Unit, filterText: String) {
    val diskusi = listOf(
        DiskusiCardModel(
            R.drawable.beranda_profile_picture,
            "Muhammad Sumbul",
            "Petani",
            "Halo semua, musim kemarau ini cukup panjang dan saya khawatir dengan irigasi di lahan saya. Ada ya...",
            12,
            10
        ), DiskusiCardModel(
            R.drawable.beranda_profile_picture,
            "Tekad",
            "Petani",
            "Halo semua, musim kemarau ini cukup panjang dan saya khawatir dengan irigasi di lahan saya. Ada ya...",
            1,
            2
        ), DiskusiCardModel(
            R.drawable.beranda_profile_picture,
            "Muhammad Lumba",
            "Petani",
            "Halo semua, musim kemarau ini cukup panjang dan saya khawatir dengan irigasi di lahan saya. Ada ya...",
            2,
            5
        ), DiskusiCardModel(
            R.drawable.beranda_profile_picture,
            "Muhammad Radzi",
            "Petani",
            "Halo semua, musim kemarau ini cukup panjang dan saya khawatir dengan irigasi di lahan saya. Ada ya...",
            12,
            20
        )
    )

    val sortedDiskusiCard = when (filterText) {
        "Populer" -> diskusi.sortedByDescending { it.jawaban }
        "Terbaru" -> diskusi.sortedBy { it.jam }
        else -> diskusi
    }

    DiskusiGenerator(sortedDiskusiCard, onAnswerClick)
}

@Composable
fun KomentarCardView() {
    val komentar = listOf(
        KomentarCardModel(
            R.drawable.beranda_profile_picture,
            "Muhammad Sumbul",
            "Petani",
            "Sama mas tempat saya juga begitu😥"
        ),
        KomentarCardModel(
            R.drawable.beranda_profile_picture,
            "Muhammad Sumbul",
            "Petani",
            "Sama mas tempat saya juga begitu😥"
        ),
        KomentarCardModel(
            R.drawable.beranda_profile_picture,
            "Muhammad Sumbul",
            "Petani",
            "Sama mas tempat saya juga begitu😥"
        ),
    )
    KomentarGenerator(komentar)
}

@Preview
@Composable
fun TestDiskusiPage() {
//    val dummy = DiskusiCardModel(
//        R.drawable.beranda_profile_picture,
//        "Muhammad Tegur",
//        "Petani",
//        "Halo semua, musim kemarau ini cukup panjang dan saya khawatir dengan irigasi di lahan saya. Ada ya...",
//        25,
//        13
//    )

    Box {
        //DiskusiPageScreen(rememberNavController(), showFooterMenu = {})
        MasukkanPertanyaanScreen()
//        JawabanScreen(dummy)
//        footerMenuScreen(
//            modifier = Modifier.align(Alignment.BottomCenter),
//            rememberNavController(),
//            currentRoute = null
//        )
    }
}