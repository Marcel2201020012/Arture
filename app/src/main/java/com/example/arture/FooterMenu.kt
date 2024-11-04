package com.example.arture

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arture.ui.theme.poppinsFont

@Composable
fun footerMenuScreen(modifier: Modifier = Modifier) {

    //state
    var berandaButtonIsClicked by remember {
        mutableStateOf(true)
    }
    var edukasiButtonIsClicked by remember {
        mutableStateOf(false)
    }
    var pekerjaanButtonIsClicked by remember {
        mutableStateOf(false)
    }
    var diskusiButtonIsClicked by remember {
        mutableStateOf(false)
    }
    var akunButtonIsClicked by remember {
        mutableStateOf(false)
    }

    val (berandaIcon, berandaIconText) = if (berandaButtonIsClicked)
        Pair(R.drawable.footer_home_icon_activated, FontWeight.Bold)
    else
        Pair(R.drawable.footer_home_icon, FontWeight.Normal)
    val (edukasiIcon, edukasiIconText) = if (edukasiButtonIsClicked)
        Pair(R.drawable.footer_edukasi_icon_activated, FontWeight.Bold)
    else
        Pair(R.drawable.footer_edukasi_icon, FontWeight.Normal)
    val (pekerjaanIcon, pekerjaanIconText) = if (pekerjaanButtonIsClicked)
        Pair(R.drawable.footer_pekerjaan_icon_activated, FontWeight.Bold)
    else
        Pair(R.drawable.footer_pekerjaan_icon, FontWeight.Normal)
    val (diskusiIcon, diskusiIconText) = if (diskusiButtonIsClicked)
        Pair(R.drawable.footer_diskusi_icon_activated, FontWeight.Bold)
    else
        Pair(R.drawable.footer_diskusi_icon, FontWeight.Normal)
    val (akunIcon, akunIconText) = if (akunButtonIsClicked)
        Pair(R.drawable.footer_akun_icon_activated, FontWeight.Bold)
    else
        Pair(R.drawable.footer_akun_icon, FontWeight.Normal)

    Box(
        modifier = modifier
            .height(81.dp)
            .background(
                color = Color.LightGray,
                RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            ),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFFEFEFE),
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            ) {
                //Beranda
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.scale(1.5f)
                ) {
                    IconButton(
                        onClick = {
                            berandaButtonIsClicked = true
                            edukasiButtonIsClicked = false
                            pekerjaanButtonIsClicked = false
                            diskusiButtonIsClicked = false
                            akunButtonIsClicked = false
                        },
                        modifier = Modifier.height(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = berandaIcon),
                            contentDescription = "home_icon",
                            tint = Color.Unspecified
                        )
                    }
                    Text(
                        color = Color(0xFF90A955),
                        text = "Beranda",
                        fontFamily = poppinsFont,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 8.sp,
                        fontWeight = berandaIconText
                    )
                }

                //Edukasi
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.scale(1.5f)
                ) {
                    IconButton(
                        onClick = {
                            berandaButtonIsClicked = false
                            edukasiButtonIsClicked = true
                            pekerjaanButtonIsClicked = false
                            diskusiButtonIsClicked = false
                            akunButtonIsClicked = false
                        },
                        modifier = Modifier.height(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = edukasiIcon),
                            contentDescription = "home_icon",
                            tint = Color.Unspecified
                        )
                    }
                    Text(
                        color = Color(0xFF90A955),
                        text = "Edukasi",
                        fontFamily = poppinsFont,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 8.sp,
                        fontWeight = edukasiIconText
                    )
                }

                //Pekerjaan
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.scale(1.5f)
                ) {
                    IconButton(
                        onClick = {
                            berandaButtonIsClicked = false
                            edukasiButtonIsClicked = false
                            pekerjaanButtonIsClicked = true
                            diskusiButtonIsClicked = false
                            akunButtonIsClicked = false
                        },
                        modifier = Modifier.height(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = pekerjaanIcon),
                            contentDescription = "home_icon",
                            tint = Color.Unspecified
                        )
                    }
                    Text(
                        color = Color(0xFF90A955),
                        text = "Pekerjaan",
                        fontFamily = poppinsFont,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 8.sp,
                        fontWeight = pekerjaanIconText
                    )
                }

                //Diskusi
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.scale(1.5f)
                ) {
                    IconButton(
                        onClick = {
                            berandaButtonIsClicked = false
                            edukasiButtonIsClicked = false
                            pekerjaanButtonIsClicked = false
                            diskusiButtonIsClicked = true
                            akunButtonIsClicked = false
                        },
                        modifier = Modifier.height(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = diskusiIcon),
                            contentDescription = "home_icon",
                            tint = Color.Unspecified
                        )
                    }
                    Text(
                        color = Color(0xFF90A955),
                        text = "Diskusi",
                        fontFamily = poppinsFont,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 8.sp,
                        fontWeight = diskusiIconText
                    )
                }

                //Akun
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.scale(1.5f)
                ) {
                    IconButton(
                        onClick = {
                            berandaButtonIsClicked = false
                            edukasiButtonIsClicked = false
                            pekerjaanButtonIsClicked = false
                            diskusiButtonIsClicked = false
                            akunButtonIsClicked = true
                        },
                        modifier = Modifier.height(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = akunIcon),
                            contentDescription = "home_icon",
                            tint = Color.Unspecified
                        )
                    }
                    Text(
                        color = Color(0xFF90A955),
                        text = "Akun",
                        fontFamily = poppinsFont,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 8.sp,
                        fontWeight = akunIconText
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun testFooterMenu() {
    footerMenuScreen()
}