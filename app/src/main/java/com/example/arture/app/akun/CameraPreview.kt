package com.example.arture.app.akun

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Matrix
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture.OnImageCapturedCallback
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cameraswitch
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import com.example.arture.data.DataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

@Composable
fun CameraPreviewScreen(navController: NavController, dataStore: DataStore) {

    val context = LocalContext.current
    val controller = remember {
        LifecycleCameraController(context)
    }

    var foto by remember {
        mutableStateOf<Bitmap?>(null)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black), contentAlignment = Alignment.Center
    ) {
        if (foto == null) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                CameraPreview(
                    controller = controller,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(bottom = 32.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Back Button",
                            tint = Color.White
                        )
                    }

                    IconButton(onClick = {
                        ambilFoto(controller, context) { bitmap ->
                            foto = bitmap
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Circle,
                            contentDescription = "Ambil Foto",
                            tint = Color.White,
                            modifier = Modifier.size(80.dp)
                        )
                    }

                    IconButton(onClick = {
                        controller.cameraSelector =
                            if (controller.cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA) {
                                CameraSelector.DEFAULT_FRONT_CAMERA
                            } else CameraSelector.DEFAULT_BACK_CAMERA
                    }) {
                        Icon(
                            imageVector = Icons.Default.Cameraswitch,
                            contentDescription = "Switch Kamera",
                            tint = Color.White
                        )
                    }
                }
            }
        } else {
            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    bitmap = foto!!.asImageBitmap(),
                    contentDescription = "foto",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(bottom = 32.dp),
                    contentScale = ContentScale.Crop
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    IconButton(onClick = {
                        foto = null
                    }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Cancel Button",
                            tint = Color.White
                        )
                    }

                    IconButton(onClick = {
                        foto?.let {
                            simpanFoto(it, context, dataStore)
                            navController.popBackStack()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Accept Button",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}

fun ambilFoto(
    controller: LifecycleCameraController,
    context: Context,
    onPhotoTaken: (Bitmap) -> Unit
) {
    controller.takePicture(
        ContextCompat.getMainExecutor(context),
        object : OnImageCapturedCallback() {
            override fun onCaptureSuccess(image: ImageProxy) {
                super.onCaptureSuccess(image)
                val bitmap = image.toBitmap()
                val finalImage =
                    if (controller.cameraSelector == CameraSelector.DEFAULT_FRONT_CAMERA) {
                        mirrorSelfie(bitmap)
                    } else {
                        bitmap
                    }
                onPhotoTaken(finalImage)
            }

            override fun onError(exception: ImageCaptureException) {
                super.onError(exception)
                Toast.makeText(context, "Foto Tidak Terekam", Toast.LENGTH_SHORT).show()
            }
        }
    )
}

fun simpanFoto(foto: Bitmap, context: Context, dataStore: DataStore) {
    val file = File(context.cacheDir, "foto_profil.jpg")
    file.outputStream().use { out ->
        foto.compress(Bitmap.CompressFormat.JPEG, 100, out)
    }

    CoroutineScope(Dispatchers.IO).launch {
        dataStore.saveFotoProfil(file.absolutePath)
    }
}

fun mirrorSelfie(bitmap: Bitmap): Bitmap {
    val matrix = Matrix()
    matrix.postScale(-1f, 1f, bitmap.width / 2f, bitmap.height / 2f) // Flip horizontally
    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
}

@Composable
fun CameraPreview(controller: LifecycleCameraController, modifier: Modifier = Modifier) {
    val lifeCycleOwner = LocalLifecycleOwner.current

    AndroidView(
        factory = {
            PreviewView(it).apply {
                this.controller = controller
                controller.bindToLifecycle(lifeCycleOwner)
            }
        }, modifier = modifier
    )
}