package com.example.arture.app.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arture.R
import com.example.arture.ui.theme.poppinsFont
import model.StatusPekerjaanCardModel

@Composable
fun StatusPekerjaanCardDesign(item: StatusPekerjaanCardModel) {
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
                .padding(all = 2.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lowongan_img_test),
                    contentDescription = "Logo PT",
                    modifier = Modifier.size(86.dp)
                )

                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text(
                        text = item.judul,
                        fontFamily = poppinsFont,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2D786C),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = item.pt,
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
                            text = "${item.jam} jam yang lalu",
                            fontFamily = poppinsFont,
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 8.sp
                        )
                    }
                    Row {
                        Icon(
                            painter = painterResource(id = item.status.icon),
                            contentDescription = null,
                            tint = item.status.color, // Menggunakan warna status
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = item.status.text,  // Mengambil teks dari JobStatus
                            color = item.status.color,
                            fontFamily = poppinsFont,
                            style = MaterialTheme.typography.bodySmall,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = R.drawable.beranda_lowongan_arrow),
                        contentDescription = "logo arrow"
                    )
                }

            }

        }

    }
}
enum class JobStatus(val text: String, val color: Color, val icon: Int) {
    WAITING_APPROVAL(" Menunggu Persetujuan", Color(0xFF4A90E2),
        R.drawable.statuspekerjaan_menunggu_icon
    ),
    REJECTED(" Lamaran Anda Ditolak", Color.Red, R.drawable.statuspekerjaan_ditolak_icon),
    ACCEPTED(" Lamaran Anda Diterima", Color.Green, R.drawable.statuspekerjaan_diterima_icon)
}

@Composable
fun StatusPekerjaanGenerator(cardItem: List<StatusPekerjaanCardModel>) {
    LazyColumn(
        modifier = Modifier
            .padding(bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(cardItem) { item ->
            StatusPekerjaanCardDesign(item)
        }
    }
    
}

@Preview
@Composable
fun StatusPekerjaanCardView() {
    StatusPekerjaanCardDesign(
        item = StatusPekerjaanCardModel(
            judul = "Technical Sales Feedmill",
            pt = "PT. Sreeya Sewu Indonesia, Tbk",
            jam = 13,
            img =   R.drawable.lowongan_img_test,
            JobStatus.REJECTED
        )
    )
}