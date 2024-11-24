package com.example.arture.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.arture.app.akun.AkunPageScreen
import com.example.arture.app.akun.CameraPreviewScreen
import com.example.arture.app.akun.EditAkunPageScreen
import com.example.arture.app.home.DisimpanPageScreen
import com.example.arture.app.home.FirstLogin
import com.example.arture.app.home.LoginCheckScreen
import com.example.arture.app.home.LoginScreen
import com.example.arture.app.home.StatusPekerjaan
import com.example.arture.app.home.homePageScreen
import com.example.arture.app.home.signInScreen
import com.example.arture.data.DataStore
import com.example.arture.app.pekerjaan.DetailPekerjaan
import com.example.arture.app.pekerjaan.Pekerjaan
import com.example.arture.ui.theme.ArtureTheme
import navigation.NavigationRoutes

@Composable
fun ArtureScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val context = LocalContext.current

        val dataStore = DataStore(context)

        val navController = rememberNavController()
        val currentBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = currentBackStackEntry?.destination?.route
        var showFooterMenu by remember {
            mutableStateOf(false)
        }

        NavHost(
            navController = navController,
            startDestination = NavigationRoutes.loginCheck,
            builder = {
                composable(NavigationRoutes.loginCheck) {
                    LoginCheckScreen(navController, dataStore)
                    showFooterMenu = false
                }
                composable(NavigationRoutes.flogIn) {
                    FirstLogin(navController)
                    showFooterMenu = false
                }
                composable(NavigationRoutes.signIn) {
                    signInScreen(navController)
                    showFooterMenu = false
                }
                composable(NavigationRoutes.logIn) {
                    LoginScreen(navController, context, dataStore)
                    showFooterMenu = false
                }
                composable(NavigationRoutes.beranda) {
                    homePageScreen(navController, dataStore)
                    showFooterMenu = true
                }
                composable(NavigationRoutes.disimpanPage) {
                    DisimpanPageScreen(navController)
                    showFooterMenu = false
                }
                composable(NavigationRoutes.statusPekerjaan) {
                    StatusPekerjaan(navController)
                    showFooterMenu = false
                }
                composable(NavigationRoutes.pekerjaan) {
                    Pekerjaan(navController)
                    LaunchedEffect(Unit) {
                        showFooterMenu = true
                    }
                }
                composable(
                    NavigationRoutes.detailPekerjaan + "/{lowonganId}",
                    arguments = listOf(navArgument("lowonganId")
                    { type = NavType.IntType })
                ) { navBackStackEntry ->
                    DetailPekerjaan(
                        navController,
                        lowongansId = navBackStackEntry.arguments?.getInt("lowonganId")
                    )
                    showFooterMenu = false
                }
                composable(NavigationRoutes.diskusi) {
                    DiskusiPageScreen(navController, showFooterMenu = { isVisible ->
                        showFooterMenu = isVisible
                    })
                }
                composable(NavigationRoutes.akun) {
                    AkunPageScreen(navController, dataStore)
                    showFooterMenu = true
                }
                composable(
                    route = "EditAkunPage/{page}/{title}/{desc}",
                    arguments = listOf(
                        navArgument("page") { type = NavType.StringType },
                        navArgument("title") { type = NavType.StringType },
                        navArgument("desc") { type = NavType.StringType }
                    )
                ) { backStackEntry ->
                    val page = backStackEntry.arguments?.getString("page") ?: ""
                    val title = backStackEntry.arguments?.getString("title")
                    val desc = backStackEntry.arguments?.getString("desc")

                    EditAkunPageScreen(
                        page = page,
                        title = title,
                        desc = desc,
                        navController = navController,
                        dataStore = dataStore,
                        context = context
                    )
                    showFooterMenu = false
                }
                composable(NavigationRoutes.camera){
                    CameraPreviewScreen(navController, dataStore)
                    showFooterMenu = false
                }
            })

        if (showFooterMenu)
            footerMenuScreen(
                modifier = Modifier.align(Alignment.BottomCenter),
                navController,
                currentRoute
            )
    }
}

@Composable
fun linearBgBrush(isVerticalGradient: Boolean, colors: List<Color>): Brush {
    val endOffset = if (isVerticalGradient) {
        Offset(0f, Float.POSITIVE_INFINITY)
    } else {
        Offset(Float.POSITIVE_INFINITY, 0f)
    }

    return Brush.linearGradient(
        colors = colors,
        start = Offset.Zero,
        end = endOffset
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtureTheme {
        //LoginScreen(navController = rememberNavController())
    }
}