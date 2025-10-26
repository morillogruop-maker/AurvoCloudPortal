package com.aurvo.cloudportal.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val DarkColorPalette = darkColorScheme(
    primary = SolarGold,
    secondary = AuroraCyan,
    background = MidnightBlue,
    surface = Color(0xFF0F172A),
    surfaceVariant = NebulaOverlay,
    onSurface = StarWhite,
    onSurfaceVariant = Slate
)

val LightColorPalette = lightColorScheme(
    primary = SolarGold,
    secondary = AuroraCyan,
    background = StarWhite,
    surface = Color(0xFFF1F5F9),
    surfaceVariant = Color(0xFFE2E8F0),
    onSurface = Color(0xFF0F172A),
    onSurfaceVariant = Color(0xFF475569)
)

val GalacticBackground: Brush
    get() = Brush.radialGradient(
        colors = listOf(Color(0x330C4A6E), Color.Transparent),
        radius = 900f
    )

val HeroGradient: Brush
    get() = Brush.linearGradient(
        colors = listOf(Color(0x33FDE68A), Color(0x1038BDF8))
    )

@Composable
fun AurvoCloudPortalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colorScheme = colorScheme,
        typography = aurvoTypography,
        shapes = aurvoShapes,
        content = content
    )
}
