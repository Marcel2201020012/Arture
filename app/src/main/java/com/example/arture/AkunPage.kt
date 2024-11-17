package com.example.arture

import android.net.Uri
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import navigation.NavigationRoutes

@Composable
fun AkunPageScreen(navController: NavController) {
    //Bg
    Box(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        //Header Box
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                    .background(
                        brush = linearBgBrush(
                            isVerticalGradient = false,
                            colors = listOf(Color(0xFF90A955), Color(0xFFECF39E))
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        Modifier.fillMaxWidth(),
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
                            Icon(
                                painter = painterResource(id = R.drawable.back_arrow),
                                contentDescription = "back icon",
                                tint = Color.Unspecified
                            )
                        }
                        Text(text = "Akun", style = MaterialTheme.typography.titleLarge)
                        Spacer(modifier = Modifier.width(48.dp))
                    }

                    Box(
                        modifier = Modifier
                            .background(Color.White, CircleShape)
                            .size(90.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.akun_profil_image),
                            contentDescription = "profil image",
                            Modifier.size(84.dp)
                        )
                    }

                    Text(
                        text = "Asep Setiawan",
                        style = MaterialTheme.typography.labelLarge.copy(Color.White)
                    )
                    Text(
                        text = "asepseptiawan31@gmail.com",
                        style = MaterialTheme.typography.bodySmall.copy(Color.White)
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            //konten
            Column(
                Modifier
                    .padding(start = 12.dp, end = 12.dp, bottom = 88.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                //Biodata Text
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Biodata",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                    )
                    Row(
                        Modifier.clickable {
                            val page = "biodata"
                            val title = ""
                            val desc = ""

                            val encodedTitle = Uri.encode(title)
                            val encodedDesc = Uri.encode(desc)

                            navController.navigate("EditAkunPage/$page/$encodedTitle/$encodedDesc")
                        },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.akun_edit_icon),
                            contentDescription = "edit icon"
                        )
                        Text(
                            text = "Edit Biodata Saya",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }

                //Biodata konten
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    shadowElevation = 8.dp
                ) {
                    Box(
                        Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column(
                            Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Nama Lengkap",
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Text(
                                    text = "Asep Setiawan",
                                    style = MaterialTheme.typography.bodySmall.copy(Color.Gray)
                                )
                            }
                            Divider(Modifier.fillMaxWidth())
                            Row(
                                Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Email",
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Text(
                                    text = "asepsetiawan31@gmail.com",
                                    style = MaterialTheme.typography.bodySmall.copy(Color.Gray)
                                )
                            }
                            Divider(Modifier.fillMaxWidth())
                            Row(
                                Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Alamat",
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Text(
                                    text = "Cianjur, Jawa Barat",
                                    style = MaterialTheme.typography.bodySmall.copy(Color.Gray)
                                )
                            }
                            Divider(Modifier.fillMaxWidth())
                            Row(
                                Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "No. Telepon",
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Text(
                                    text = "0857-2733-7927",
                                    style = MaterialTheme.typography.bodySmall.copy(Color.Gray)
                                )
                            }
                            Divider(Modifier.fillMaxWidth())
                            Row(
                                Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Pendidikan Terakhir",
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Text(
                                    text = "S1-Pertanian",
                                    style = MaterialTheme.typography.bodySmall.copy(Color.Gray)
                                )
                            }
                            Divider(Modifier.fillMaxWidth())
                            Row(
                                Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Pengalaman Kerja",
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Text(
                                    text = "-",
                                    style = MaterialTheme.typography.bodySmall.copy(Color.Gray)
                                )
                            }
                            Divider(Modifier.fillMaxWidth())
                        }
                    }
                }

                //Biodata Text
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Informasi Tambahan",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(Modifier.height(48.dp))
                }

                //Informasi tambahan konten
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    shadowElevation = 8.dp
                ) {
                    Box(
                        Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column(
                            Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    Modifier
                                        .clickable {
                                            val page = "Tentang Saya"
                                            val desc = "Beritahu tentang dirimu!"

                                            val encodedTitle = Uri.encode(page)
                                            val encodedDesc = Uri.encode(desc)

                                            navController.navigate("EditAkunPage/$page/$encodedTitle/$encodedDesc")
                                        },
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Text(
                                        text = "Tentang Saya",
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                    Icon(
                                        painter = painterResource(id = R.drawable.akun_edit_icon),
                                        contentDescription = "edit icon"
                                    )
                                }
                                Text(text = "")
                            }
                            Divider(Modifier.fillMaxWidth())
                            Text(
                                text =
                                "Nama saya Asep Setiawan, saya berusia 24 tahun dan merupakan lulusan Sarjana Pertanian. Meskipun saya belum memiliki pengalaman kerja formal, saya memiliki pengetahuan akademis yang solid di bidang pertanian dan telah mengembangkan keterampilan kepemimpinan serta kemampuan sebagai seorang supervisor. Saya bersemangat untuk menerapkan keahlian ini dalam lingkungan kerja yang nyata.",
                                style = MaterialTheme.typography.bodySmall.copy(Color.Gray)
                            )
                        }
                    }
                }
                //kemampuan
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    shadowElevation = 8.dp
                ) {
                    Box(
                        Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column(
                            Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    Modifier
                                        .clickable {
                                            val page = "Kemampuan"
                                            val desc = "Beritahu tetang keahlian/kemampuan kamu!"

                                            val encodedTitle = Uri.encode(page)
                                            val encodedDesc = Uri.encode(desc)

                                            navController.navigate("EditAkunPage/$page/$encodedTitle/$encodedDesc")
                                        },
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Text(
                                        text = "Kemampuan",
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                    Icon(
                                        painter = painterResource(id = R.drawable.akun_edit_icon),
                                        contentDescription = "edit icon"
                                    )
                                }
                                Text(text = "")
                            }
                            Divider(Modifier.fillMaxWidth())
                            Text(
                                "Lorem ipsum dolor sit amet consectetur. Etiam habitant tortor proin facilisis non viverra. Suscipit posuere sit fringilla iaculis semper varius. Bibendum turpis urna sed id dignissim elementum scelerisque. Posuere mi auctor eget at.",
                                style = MaterialTheme.typography.bodySmall.copy(Color.Gray)
                            )
                        }
                    }
                }

                //Pengalaman organisasi
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    shadowElevation = 8.dp
                ) {
                    Box(
                        Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column(
                            Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    Modifier
                                        .clickable {
                                            val page = "Pengalaman Organisasi"
                                            val desc = "Pengalaman apa saja yang kau miliki di organisasi?"

                                            val encodedTitle = Uri.encode(page)
                                            val encodedDesc = Uri.encode(desc)

                                            navController.navigate("EditAkunPage/$page/$encodedTitle/$encodedDesc")
                                        },
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Text(
                                        text = "Pegalaman Organisasi",
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                    Icon(
                                        painter = painterResource(id = R.drawable.akun_edit_icon),
                                        contentDescription = "edit icon"
                                    )
                                }
                                Text(text = "")
                            }
                            Divider(Modifier.fillMaxWidth())
                            Text(
                                "Lorem ipsum dolor sit amet consectetur. Etiam habitant tortor proin facilisis non viverra. Suscipit posuere sit fringilla iaculis semper varius. Bibendum turpis urna sed id dignissim elementum scelerisque. Posuere mi auctor eget at.",
                                style = MaterialTheme.typography.bodySmall.copy(Color.Gray)
                            )
                        }
                    }
                }

                //Penghargaan & Sertifikat
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    shadowElevation = 8.dp
                ) {
                    Box(
                        Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column(
                            Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    Modifier
                                        .clickable {
                                            val page = "Penghargaan & Sertifikat"
                                            val desc = "Apa saja penghargaan dan sertifikat yang pernah kamu raih?"

                                            val encodedTitle = Uri.encode(page)
                                            val encodedDesc = Uri.encode(desc)

                                            navController.navigate("EditAkunPage/$page/$encodedTitle/$encodedDesc")
                                        },
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Text(
                                        text = "Penghargaan & Sertifikat",
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                    Icon(
                                        painter = painterResource(id = R.drawable.akun_edit_icon),
                                        contentDescription = "edit icon"
                                    )
                                }
                                Text(text = "")
                            }
                            Divider(Modifier.fillMaxWidth())
                            Text(
                                "Lorem ipsum dolor sit amet consectetur. Etiam habitant tortor proin facilisis non viverra. Suscipit posuere sit fringilla iaculis semper varius. Bibendum turpis urna sed id dignissim elementum scelerisque. Posuere mi auctor eget at.",
                                style = MaterialTheme.typography.bodySmall.copy(Color.Gray)
                            )
                        }
                    }
                }

                //logout
                Box(
                    Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .background(Color(0xFFEF3939))
                        .clickable {/*do something*/ }
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.akun_logout_icon),
                            contentDescription = "logout icon",
                            tint = Color.Unspecified
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.akun_logout_line),
                            contentDescription = "divider",
                            tint = Color.Unspecified
                        )
                        Text(
                            text = "Keluar",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TestAkunPageScreen() {
    Box {
        AkunPageScreen(rememberNavController())
        footerMenuScreen(
            Modifier.align(Alignment.BottomCenter),
            rememberNavController(),
            currentRoute = ""
        )
    }
}