package com.example.arture.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = com.example.arture.R.array.com_google_android_gms_fonts_certs
)

val poppinsFont = FontFamily(
    Font(
        googleFont = GoogleFont("Poppins"),
        fontProvider = provider
    )
)

val timesNewRomanFont = FontFamily(
    Font(
        googleFont = GoogleFont("Times New Roman"),
        fontProvider = provider
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = poppinsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = poppinsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = poppinsFont,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp,
        color = Color.White,
        lineHeight = 28.sp,
        letterSpacing = 0.5.sp
    ),
    titleSmall = TextStyle(
        fontFamily = poppinsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color.White
    ),
    labelLarge = TextStyle(
        fontFamily = poppinsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color(0xFF2D786C)
    ),
    labelMedium = TextStyle(
        fontFamily = poppinsFont,
        fontSize = 16.sp,
        color = Color(0xFF246056)
    ),
    labelSmall = TextStyle(
        fontFamily = poppinsFont,
        fontSize = 12.sp,
        color = Color(0xFF5B8532)
    ),
    bodySmall = TextStyle(
        fontFamily = poppinsFont,
        fontSize = 12.sp,
        color = Color.Black
    )
)