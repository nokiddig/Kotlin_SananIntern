package com.example.initapp.ui.theme

import android.icu.text.CaseMap.Title
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class AppTypography(
    val largeTitle: TextStyle = TextStyle.Default,
    val title:TextStyle = TextStyle.Default,
    val subTitle: TextStyle = TextStyle.Default,
    val body: TextStyle = TextStyle.Default,
)

val LocalAppTypography = staticCompositionLocalOf { 
    AppTypography()
}

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val typography = AppTypography(
        largeTitle = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontSize = 32.sp,
            fontWeight =  FontWeight.Bold
        ),
        title = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontSize = 24.sp,
            fontWeight =  FontWeight.Bold
        ),
        subTitle = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontSize = 16.sp,
            fontWeight =  FontWeight.Bold
        ),
        body = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontSize = 18.sp,
            fontWeight =  FontWeight.Normal
        )
    )

    CompositionLocalProvider(LocalAppTypography provides typography) {
        content.invoke()
    }
}

object AppTheme{
    val appTypography: AppTypography

    @Composable
    get() = LocalAppTypography.current
}

data class AppColor(val backgroundColor:Color = Color.Red)