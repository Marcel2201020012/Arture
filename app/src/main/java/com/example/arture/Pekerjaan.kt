@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.arture

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import com.example.arture.ui.theme.poppinsFont
import navigation.NavigationRoutes

@Composable
fun Pekerjaan(navController: NavController) {
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
                            //horizontalArrangement = Arrangement.SpaceBetween,
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

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                //verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Absolute.Center
                            ) {
                                Text(
                                    text = "Pekerjaan",
                                    style = MaterialTheme.typography.titleLarge
                                )
                            }

                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                var text by remember { mutableStateOf("") }
                var active by remember { mutableStateOf(false) }

                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .width(382.dp)
                        .height(203.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .width(380.dp)
                            .height(201.dp),
                        contentAlignment = Alignment.Center,
                    ) {
//                    SearchBar(
//                        modifier = Modifier
//                            .width(343.dp),
//
//                        query = text,
//                        onQueryChange = { text = it},
//                        onSearch = { active = false },
//                        active = active,
//                        onActiveChange = { active = it },
//                        placeholder = {
//                            Text(
//                                text = "Search")
//                            },
//                        leadingIcon = {
//                            Icon(imageVector = Icons.Default.Search, contentDescription = "search")}
//
//                    ) { }
                        Column(
                            modifier = Modifier
                                .width(343.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                //verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.Start
                            ) {
                                Column {
                                    Text(
                                        text = "Cari Pekerjaan Agraris?",
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = Color(0xFF2D786C),
                                        textAlign = TextAlign.Center,
                                        fontSize = 18.sp,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(bottom = 15.dp)
                                    )
                                    OutlinedTextField(
                                        modifier = Modifier
                                            .background(
                                                color = Color.LightGray,
                                                shape = RoundedCornerShape(66.dp)
                                            )

                                            .width(343.dp),
                                        value = "Cari pekerjaan",
                                        onValueChange = { text = it },
                                        colors = OutlinedTextFieldDefaults.colors(
                                            focusedBorderColor = Color.White,
                                            unfocusedBorderColor = Color.White,
                                        ),
                                        leadingIcon = {
                                            Icon(
                                                imageVector = Icons.Default.Search,
                                                contentDescription = "search"
                                            )
                                        }
                                    )
                                }

                                var expanded by remember { mutableStateOf(false) }
                                var selectedOption by remember { mutableStateOf("Sort By") }

//                            ExposedDropdownMenuBox(
//                                expanded = expanded,
//                                onExpandedChange = { expanded = !expanded }
//                            ) {
//                                FilterChip(
//                                    selected = false,
//                                    onClick = { expanded = !expanded },
//                                    label = { Text(selectedOption) }
//                                )
//
//                                ExposedDropdownMenu(
//                                    expanded = expanded,
//                                    onDismissRequest = { expanded = false }
//                                ) {
//                                    DropdownMenuItem(
//                                        text = { Text("Tanggal") },
//                                        onClick = {
//                                            selectedOption = "Tanggal"
//                                            expanded = false
//                                        }
//                                    )
//                                    DropdownMenuItem(
//                                        text = { Text("Gaji") },
//                                        onClick = {
//                                            selectedOption = "Gaji"
//                                            expanded = false
//                                        }
//                                    )
//                                    DropdownMenuItem(
//                                        text = { Text("Lokasi") },
//                                        onClick = {
//                                            selectedOption = "Lokasi"
//                                            expanded = false
//                                        }
//                                    )
//                                }
//                            }
                                var selected by remember { mutableStateOf(false) }

                                LazyRow(
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    items(4) { index ->
                                        FilterChip(
                                            onClick = { selected = !selected },
                                            label = {
                                                Text("Filter chip")
                                            },
                                            selected = selected,
                                            leadingIcon = if (selected) {
                                                {
                                                    Icon(
                                                        imageVector = Icons.Filled.Done,
                                                        contentDescription = "Done icon",
                                                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                                                    )
                                                }
                                            } else {
                                                null
                                            },
                                        )
                                    }
                                }


                            }
                        }


                    }
                }
            }
            Column(
                modifier = Modifier
//                    .padding(
//                        end = 16.dp, start = 16.dp
//                    )
                    .fillMaxWidth()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(12.dp))

                //Lowongan Card
                Column(
                    //modifier = Modifier.padding(bottom = 90.dp)
                    modifier = Modifier
                        .padding(bottom = 80.dp)
                ) {
                    lowonganTerbaruView(navController)
                }
            }
        }
    }


}


@Preview
@Composable
private fun PekerjaanView() {
    Pekerjaan(rememberNavController())

}