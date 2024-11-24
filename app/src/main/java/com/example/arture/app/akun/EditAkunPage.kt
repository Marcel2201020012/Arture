@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.arture.app.akun

import android.Manifest
import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.arture.data.DataStore
import com.example.arture.R
import com.example.arture.app.linearBgBrush
import com.example.arture.ui.theme.poppinsFont
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import navigation.NavigationRoutes

@Composable
fun EditAkunPageScreen(
    page: String,
    title: String?,
    desc: String?,
    navController: NavController,
    dataStore: DataStore,
    context: Context
) {
    Column(
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
                    navController.navigate(NavigationRoutes.akun) {
                        popUpTo(NavigationRoutes.akun) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }) {
                    Icon(
                        tint = Color.Unspecified,
                        painter = painterResource(id = R.drawable.back_arrow),
                        contentDescription = "logo back"
                    )
                }
                Text(
                    text = "Akun",
                    fontFamily = poppinsFont,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.width(48.dp))
            }
        }

        if (page == "biodata") {
            EditBiodataPage(navController, dataStore, context)
        } else {
            EditInformasiTambahanPage(title = title, desc = desc)
        }
    }
}

@Composable
fun EditBiodataPage(navController: NavController, dataStore: DataStore, context: Context) {

    //data store
    val fotoProfil by dataStore.fotoProil.collectAsState(initial = null)
    val userName by dataStore.getUserName.collectAsState(initial = "")

    //user profil data
    var newUserName by remember {
        mutableStateOf(userName ?: "")
    }

    //load data dari datastore
    LaunchedEffect(userName) {
        newUserName = userName.toString()
    }

    var galleryImage by remember {
        mutableStateOf<Uri?>(null)
    }

    val galleryPhotoLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            galleryImage = uri

            uri?.let {
                CoroutineScope(Dispatchers.IO).launch {
                    dataStore.saveFotoProfil(it.toString())
                }
            }
        })

    //permission
    var isCameraGranted by remember {
        mutableStateOf(false)
    }
    var isGalleryGranted by remember {
        mutableStateOf(false)
    }

    val sheetState = rememberModalBottomSheetState()

    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    val permissionLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            isCameraGranted = permissions[Manifest.permission.CAMERA] ?: false

            isGalleryGranted = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                permissions[Manifest.permission.READ_MEDIA_IMAGES] ?: false
            else
                permissions[Manifest.permission.READ_EXTERNAL_STORAGE] ?: false

            if (isCameraGranted && isGalleryGranted) {
                isSheetOpen = true
            }
        }

//profil image
    Box(
        Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Box(
                modifier = Modifier
                    .background(Color.White, CircleShape)
                    .size(90.dp),
                contentAlignment = Alignment.Center
            ) {
                if (fotoProfil != null) {
                    val bitmap = BitmapFactory.decodeFile(fotoProfil)
                    if (bitmap != null) {
                        Image(
                            bitmap = bitmap.asImageBitmap(),
                            contentDescription = "profil image",
                            Modifier
                                .fillMaxSize()
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.beranda_profile_picture),
                        contentDescription = "profil image",
                        Modifier.size(84.dp)
                    )
                }
            }
        }
        Box(
            Modifier.height(90.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Spacer(Modifier.width(45.dp))
                Box(
                    Modifier
                        .clip(CircleShape)
                        .size(30.dp)
                        .background(
                            brush = linearBgBrush(
                                isVerticalGradient = false,
                                colors = listOf(Color(0xFF90A955), Color(0xFFECF39E))
                            )
                        )
                        .clickable {
                            if (!isCameraGranted || !isGalleryGranted)
                                permissionLauncher.launch(
                                    arrayOf(
                                        Manifest.permission.CAMERA,
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                            Manifest.permission.READ_MEDIA_IMAGES
                                        } else {
                                            Manifest.permission.READ_EXTERNAL_STORAGE
                                        }
                                    )
                                )
                            else
                                isSheetOpen = true
                        }, contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.scale(0.7f),
                        painter = painterResource(id = R.drawable.akun_camera_icon),
                        contentDescription = "edit profil",
                        tint = Color.Unspecified
                    )
                }
            }
        }
    }

//konten
    Column(
        Modifier
            .padding(start = 60.dp, end = 60.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Nama")
            OutlinedTextField(
                value = newUserName,
                onValueChange = { newValue ->
                    newUserName = newValue
                },
                singleLine = true,
                shape = RoundedCornerShape(50),
                textStyle = MaterialTheme.typography.bodySmall
            )


        Text(text = "Email")
        OutlinedTextField(
            value = "asepsetiawan31@gmail.com",
            onValueChange = {},
            shape = RoundedCornerShape(50),
            textStyle = MaterialTheme.typography.bodySmall
        )

        Text(text = "Alamat")
        OutlinedTextField(
            value = "Cianjur, Jawa Barat",
            onValueChange = {},
            shape = RoundedCornerShape(50),
            textStyle = MaterialTheme.typography.bodySmall
        )

        Text(text = "No. Telepon")
        OutlinedTextField(
            value = "0857-2733-7927",
            onValueChange = {},
            shape = RoundedCornerShape(50),
            textStyle = MaterialTheme.typography.bodySmall
        )

        Text(text = "Pendidikan Terakhir")
        OutlinedTextField(
            value = "S1-Pertanian",
            onValueChange = {},
            shape = RoundedCornerShape(50),
            textStyle = MaterialTheme.typography.bodySmall
        )

        Text(text = "Pengalaman Kerja")
        OutlinedTextField(
            value = "",
            onValueChange = {

            },
            shape = RoundedCornerShape(50),
            textStyle = MaterialTheme.typography.bodySmall
        )

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "")

            Button(
                onClick = {
                    if (newUserName.isNotEmpty())
                    {
                        CoroutineScope(Dispatchers.IO).launch {
                            dataStore.saveUserName(newUserName)
                        }
                    }
                    Toast.makeText(context, "Profil Tersimpan", Toast.LENGTH_SHORT).show()
                },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF8B402)
                )
            ) {
                Text(
                    text = "Simpan Biodata", style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }

//bottom menu untuk kamera/galleri
    if (isSheetOpen)
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isSheetOpen = false
            }) {
            Column(
                Modifier
                    .padding(start = 12.dp, end = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {
                        isSheetOpen = false
                    }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "close icon"
                        )
                    }
                    Text(
                        text = "Edit Profil",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "delete icon"
                        )
                    }
                }

                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(40.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(onClick = {
                            isSheetOpen = false
                            navController.navigate(NavigationRoutes.camera)
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.akun_camera_icon),
                                contentDescription = "kamera icon"
                            )
                        }
                        Text(
                            text = "Kamera",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(onClick = {
                            galleryPhotoLauncher.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            )
                            isSheetOpen = false
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.akun_gallery_icon),
                                contentDescription = "gallery icon"
                            )
                        }
                        Text(
                            text = "Galeri",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }

}

@Composable
fun EditInformasiTambahanPage(title: String?, desc: String?) {
    //konten
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, bottom = 88.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        title?.let {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
            )
        }
        desc?.let {
            Text(
                text = desc,
                style = MaterialTheme.typography.bodySmall
            )
        }

        OutlinedTextField(
            value = "",
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            textStyle = MaterialTheme.typography.labelSmall.copy(Color.Black),
            maxLines = 15,
            singleLine = false
        )

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "")
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF8B402)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Simpan", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestEditAkunPage() {
//    Box {
//        EditAkunPageScreen(
//            page = "biodata",
//            title = "",
//            desc = "",
//            navController = rememberNavController(),
//            dataStore = 
//        )
//        //EditBiodataPage()
//        //EditInformasiTambahanPage("Tentang Saya", "Beritahu tentang dirimu!")
//        footerMenuScreen(
//            Modifier.align(Alignment.BottomCenter),
//            rememberNavController(),
//            currentRoute = ""
//        )
//    }
}