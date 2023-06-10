package com.example.mytestapplication.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
// primaryContainer is for FAB
// surfaceVariant is for Card
// tertiary is for iconButton delete
private val DarkColorScheme = darkColorScheme(
    primary =Color(0xFF3B57F1),
    primaryContainer = Color(0xFF3B57F1),
    onPrimaryContainer = Color(0xFF3B57F1),
    onPrimary = Color(0xFFf2fdff),
    inversePrimary = Color(0xFF3B57F1),
     scrim = Color(0xFF3B57F1),

    outlineVariant = Color(0xFF3B57F1),


    // Purple40,    secondary = PurpleGrey80,
    secondary = Color(0xFFA4B0F3),
    secondaryContainer = Color(0xFF3B57F1),
    onSecondaryContainer = Color(0xFF3B57F1),
    onSecondary = Color(0xFFf2fdff),

//PurpleGrey40,
    //    Other default colors to override
    //   background = Color(0xFFFFFBFE),
    surface = Color(0xFFf2fdff),
    surfaceTint = Color(0xFFf2fdff),
    onSurface = Color(0xFFFFFFFF),
    inverseSurface = Color(0xFF6750A4),
    inverseOnSurface =  Color(0xFFf2fdff),
    surfaceVariant = Color(0xFFf2fdff),
    onSurfaceVariant = Color(0xFFf2fdff),

    tertiary = Color(0xFF3B57F1),
    onTertiary = Color(0xFFf2fdff),
    tertiaryContainer = Color(0xFF3B57F1),
    onTertiaryContainer = Color(0xFF3B57F1),

    background = Color(0xFF3B57F1),
    onBackground = Color(0xFF3B57F1),

    )

private val LightColorScheme = lightColorScheme(
    primary =Color(0xFF3B57F1),// Purple40,
    secondary = Color(0xFFf2fdff),//PurpleGrey40,
    tertiary = Color(0xFFf2fdff),
    background = Color(0xFFf2fdff),
 //    Other default colors to override
 //   background = Color(0xFFFFFBFE),
    surface = Color(0xFFf2fdff),
    onPrimary = Color(0xFFf2fdff),
    onSecondary = Color(0xFFf2fdff),
    onTertiary = Color(0xFFf2fdff),
    onBackground = Color(0xFFf2fdff),
    onSurface = Color(0xFFf2fdff),

)

@Composable
fun MyTestApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}