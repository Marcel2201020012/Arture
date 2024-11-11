package com.example.arture

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import model.StatusPekerjaanCardModel

@Composable
fun StatusPekerjaan() {
    val colorList = listOf(
        Color(0xFF90A956), Color(0xFFECF39E)
    )

    Box(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Column(
            //modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .background(
                        brush = linearBgBrush(
                            isVerticalGradient = false, colors = colorList
                        ),
                        shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                    )
                    .fillMaxWidth()
                    .height(145.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.align(Alignment.TopEnd),
                    painter = painterResource(id = R.drawable.statuspekerjaan_koper_icon),
                    contentDescription = "beranda_bg_icon"
                )
                Column(

                ) {
                    Row(
                        modifier = Modifier
                            //.background(color = Color.White)
                            .fillMaxWidth(),
                        //horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Image(
                                painter = painterResource(id = R.drawable.statuspekerjaan_arrow_back_icon),
                                contentDescription = "logo arrow"
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            //verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Absolute.Center
                        ) {
                            Text(
                                text = "Status Pekerjaan",
                                style = MaterialTheme.typography.titleLarge
                            )
                        }

                    }

                    Text(
                        text = "\"Kesuksesan bukan hanya tentang seberapa cepat kamu menemukannya, tetapi seberapa keras kamu bertahan untuk mencapainya.\"",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White

                    )

                }
            }
            Column(
                modifier = Modifier
                    .padding(
                        end = 16.dp, start = 16.dp, top = 16.dp,
                    )
                    .fillMaxWidth()
                    .fillMaxSize()
                //verticalArrangement = Arrangement.Center
            ) {
                StatusPekerjaanView()
            }
        }
    }

}

@Composable
fun StatusPekerjaanView() {
    val lowongan = listOf(
        StatusPekerjaanCardModel(
            judul = "Technical Sales Feedmill",
            pt = "PT. Sreeya Sewu Indonesia, Tbk",
            jam = 13,
            img = R.drawable.lowongan_img_test,
            JobStatus.REJECTED
        ),
        StatusPekerjaanCardModel(
            judul = "Technical Sales Feedmill",
            pt = "PT. Sreeya Sewu Indonesia, Tbk",
            jam = 13,
            img = R.drawable.lowongan_img_test,
            JobStatus.WAITING_APPROVAL
        ),
        StatusPekerjaanCardModel(
            judul = "Technical Sales Feedmill",
            pt = "PT. Sreeya Sewu Indonesia, Tbk",
            jam = 13,
            img = R.drawable.lowongan_img_test,
            JobStatus.ACCEPTED
        )


    )
    StatusPekerjaanGenerator(lowongan)
}


@Preview
@Composable
fun StatusPekerjaanTest() {
    Box {
        StatusPekerjaan()
        footerMenuScreen(modifier = Modifier.align(Alignment.BottomCenter))
    }
}