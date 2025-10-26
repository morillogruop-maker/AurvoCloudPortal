package com.aurvo.cloudportal.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = AuroraBlue,
    secondary = CosmicCyan,
    tertiary = StellarPurple,
    background = GalaxyBlack,
    surface = NebulaGray,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onTertiary = Color.White,
    onBackground = TextPrimary,
    onSurface = TextPrimary
)

private val LightColorScheme = lightColorScheme(
    primary = AuroraBlue,
    secondary = CosmicCyan,
    tertiary = StellarPurple
)

val PremiumAuroraBrush: Brush = Brush.linearGradient(
    listOf(AuroraBlue, StellarPurple, CosmicCyan)
)

@Composable
fun AurvoCloudPortalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AurvoTypography,
        content = content
    )
}
