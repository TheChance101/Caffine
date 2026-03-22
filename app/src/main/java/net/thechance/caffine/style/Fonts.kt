package net.thechance.caffine.style

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import net.thechance.caffine.R

private val urbanist = FontFamily(
    Font(R.font.urbanist_normal, FontWeight.Normal),
    Font(R.font.urbanist_medium, FontWeight.Medium),
    Font(R.font.urbanist_semibold, FontWeight.SemiBold),
    Font(R.font.urbanist_bold, FontWeight.Bold),
)

val appBarTitle = TextStyle(
    fontFamily = urbanist,
    fontSize = 24.sp,
    fontWeight = FontWeight.Bold,
    letterSpacing = 0.25.sp
)

val amountText = TextStyle(
    fontFamily = urbanist,
    fontSize = 14.sp,
    fontWeight = FontWeight.Medium,
    letterSpacing = 0.25.sp
)

val sizePickerTitles = TextStyle(
    fontFamily = urbanist,
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
    letterSpacing = 0.25.sp
)

val caffinePickerAmount = TextStyle(
    fontFamily = urbanist,
    fontSize = 10.sp,
    fontWeight = FontWeight.Medium,
    letterSpacing = 0.25.sp
)