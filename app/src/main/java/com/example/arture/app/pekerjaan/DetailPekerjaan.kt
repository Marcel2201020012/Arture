package com.example.arture.app.pekerjaan


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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.arture.R
import com.example.arture.app.linearBgBrush
import com.example.arture.data.DummyData
import model.LowonganTerbaruCardModel
import navigation.NavigationRoutes

@Composable
fun DetailPekerjaan(
    navController: NavController,
    lowongansId: Int?
) {
    val newLowonganList = DummyData.lowongancard.filter { lowongan ->
        lowongan.id == lowongansId
    }
    Column {
        DetailPekerjaanContent(
            newLowonganList = newLowonganList,
            navController = navController
        )
    }
}

@Composable
fun DetailPekerjaanContent(
    navController: NavController,
    newLowonganList: List<LowonganTerbaruCardModel>
) {
    var bookmarkIsClicked by remember {
        mutableStateOf(false)
    }

    val bookmarkIcon = if (bookmarkIsClicked) R.drawable.beranda_artikel_bookmark_remove_icon
    else R.drawable.beranda_artikel_bookmark_add_icon

    val colorList = listOf(
        Color(0xFF90A956), Color(0xFFECF39E)
    )
    Box(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Column {
            Column {
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
                                text = "Pekerjaan",
                                style = MaterialTheme.typography.titleLarge
                            )

                            Spacer(modifier = Modifier.width(45.dp))

                        }
                    }
                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(3) { index ->
                    val boxHeight = when (index) {
                        0 -> 698.dp
                        1 -> 224.dp
                        2 -> 375.dp
                        else -> 201.dp
                    }
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth()
                            .height(boxHeight),
                        contentAlignment = Alignment.Center
                    ) {
                        when (index) {
                            0 -> {
                                Box(
                                    modifier = Modifier
                                        .height(608.dp)
                                        .width(372.dp)
                                        .offset(y = 40.dp)
                                        .background(
                                            color = Color.LightGray,
                                            shape = RoundedCornerShape(16.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .height(606.dp)
                                            .width(370.dp)
                                            //.offset(y = 40.dp)
                                            .background(
                                                color = Color.White,
                                                shape = RoundedCornerShape(16.dp)
                                            ),
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .padding(start = 25.dp, end = 25.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.End,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(60.dp)
                                            )
                                            {
                                                Icon(painter = painterResource(id = bookmarkIcon),
                                                    contentDescription = "bookmark",
                                                    tint = Color.Unspecified,
                                                    modifier = Modifier
                                                        .size(32.dp)
                                                        .offset(x = 10.dp, y = 10.dp)
                                                        .clickable {
                                                            bookmarkIsClicked = !bookmarkIsClicked
                                                        })
                                            }
                                            Text(
                                                text = newLowonganList[0].judul,
                                                style = MaterialTheme.typography.bodyLarge,
                                                color = Color(0xFF2D786C),
                                            )
                                            Text(
                                                text = "PT. Sreeya Sewu Indonesia, TBK",
                                                style = MaterialTheme.typography.bodyMedium,
                                                color = Color(0xFF566533)
                                            )
                                            Row {
                                                Text(
                                                    text = "Blitar, Jawa Timur",
                                                    style = MaterialTheme.typography.bodySmall,
                                                    color = Color(0xFF566533)
                                                )
                                            }
                                            Row {
                                                Text(
                                                    text = "Gaji",
                                                    style = MaterialTheme.typography.bodySmall,
                                                    color = Color(0xFF566533)
                                                )
                                            }
                                            Row {
                                                Text(
                                                    text = "Full Time",
                                                    style = MaterialTheme.typography.bodySmall,
                                                    color = Color(0xFF566533)
                                                )
                                            }
                                            Text(
                                                text = "\nKualifikasi",
                                                style = MaterialTheme.typography.bodyLarge,
                                                color = Color(0xFF2D786C),
                                            )
                                            Text(
                                                text = newLowonganList[0].kualifikasi,
                                                style = MaterialTheme.typography.bodyMedium,
                                                color = Color(0xFF566533)
                                            )
                                            Text(
                                                text = "\nPertanyaan dari perusahaan",
                                                style = MaterialTheme.typography.bodyLarge,
                                                color = Color(0xFF2D786C),
                                            )
                                            Text(
                                                text = newLowonganList[0].pertanyaan,
                                                style = MaterialTheme.typography.bodyMedium,
                                                color = Color(0xFF566533)
                                            )

                                        }
                                    }
                                }

                                Box(
                                    modifier = Modifier
                                        .height(130.dp)
                                        .width(106.dp)
                                        .offset(x = -110.dp, y = -280.dp)
                                        .background(
                                            color = Color.LightGray,
                                            shape = RoundedCornerShape(16.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .height(128.dp)
                                            .width(104.dp)
                                            .background(
                                                color = Color.White,
                                                shape = RoundedCornerShape(16.dp)
                                            ),
                                        //contentAlignment = Alignment.BottomEnd
                                    ) {
                                        Image(
                                            painter = painterResource(id = newLowonganList[0].img),
                                            contentDescription = "Logo PT",
                                            modifier = Modifier
                                                .fillMaxSize()
                                        )
                                    }
                                }
                            }


                            1 -> {
                                Box(
                                    modifier = Modifier
                                        .height(219.dp)
                                        .width(372.dp)
                                        .background(
                                            color = Color.LightGray,
                                            shape = RoundedCornerShape(16.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .height(217.dp)
                                            .width(370.dp)
                                            //.offset(y = 40.dp)
                                            .background(
                                                color = Color.White,
                                                shape = RoundedCornerShape(16.dp)
                                            ),
                                    ) {
                                        Column {
                                            Text(
                                                text = "Unggah Dokumen",
                                                style = MaterialTheme.typography.bodyLarge,
                                                color = Color(0xFF2D786C),
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 18.sp,
                                                modifier = Modifier
                                                    .padding(top = 10.dp, start = 12.dp)
                                            )
                                            Spacer(Modifier.height(36.dp))
                                            Column(
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                verticalArrangement = Arrangement.Center
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.detailpekerjaan_upload_icon),
                                                    contentDescription = "Logo PT",
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .height(40.dp)
                                                )
                                                Text(
                                                    text = "click to upload",
                                                    style = MaterialTheme.typography.bodySmall
                                                )
                                                Text(
                                                    text = "Jenis file yang diterima: .doc, .docx, .pdf, .txt, \ndan .rtf (batas 2MB).",
                                                    style = MaterialTheme.typography.bodySmall,
                                                    textAlign = TextAlign.Center
                                                )
                                            }
                                        }

                                    }
                                }
                            }

                            2 -> {
                                Box(
                                    modifier = Modifier
                                        .height(193.dp)
                                        .width(372.dp)
                                        .offset(y = -30.dp)
                                        .background(
                                            color = Color.LightGray,
                                            shape = RoundedCornerShape(16.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .height(191.dp)
                                            .width(370.dp)
                                            .background(
                                                color = Color.White,
                                                shape = RoundedCornerShape(16.dp)
                                            ),
                                    ) {
                                        Column(
//                                            modifier = Modifier
//                                                .width(270.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.End,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(90.dp)
                                            )
                                            {
                                                Text(
                                                    text = "PT. Sreya Sewu Indonesia, \nTBK",
                                                    style = MaterialTheme.typography.bodyLarge,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color(0xFF2D786C),
                                                    modifier = Modifier
                                                        .padding(end = 10.dp, top = 10.dp)
                                                )
                                            }
                                            Text(
                                                text = "Manufacturing, Transport & Logistics" +
                                                        "\n1.001-5.000 karyawan\n",
                                                style = MaterialTheme.typography.bodyMedium
                                                    .copy(color = Color(0xFF566533)),
                                                modifier = Modifier
                                                    .padding(start = 25.dp)
                                            )
                                            Row(
                                                modifier = Modifier
                                                    .padding(bottom = 15.dp),
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = "Lihat Selengkapnya",
                                                    style = MaterialTheme.typography.bodyMedium,
                                                    fontSize = 14.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color(0xFF2D786C),
                                                    modifier = Modifier
                                                        .padding(start = 25.dp)
                                                )
                                                IconButton(onClick = { /*TODO*/ }) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.beranda_lowongan_arrow),
                                                        contentDescription = "logo arrow"
                                                    )
                                                }
                                            }
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .height(130.dp)
                                            .width(106.dp)
                                            .offset(x = -110.dp, y = -90.dp)
                                            .background(
                                                color = Color.LightGray,
                                                shape = RoundedCornerShape(16.dp)
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .height(128.dp)
                                                .width(104.dp)
                                                .background(
                                                    color = Color.White,
                                                    shape = RoundedCornerShape(16.dp)
                                                ),
                                            //contentAlignment = Alignment.BottomEnd
                                        ) {
                                            Image(
                                                painter = painterResource(newLowonganList[0].img),
                                                contentDescription = "Logo PT",
                                                modifier = Modifier
                                                    .fillMaxSize()
                                            )
                                        }
                                    }

                                }

                            }

                            else -> Text("Item lainnya", color = Color.White)
                        }
                    }
                }

            }


        }


    }

}

@Preview
@Composable
private fun PekerjaanView() {
    DetailPekerjaanContent(
        newLowonganList = DummyData.lowongancard,
        navController = rememberNavController()
    )

}