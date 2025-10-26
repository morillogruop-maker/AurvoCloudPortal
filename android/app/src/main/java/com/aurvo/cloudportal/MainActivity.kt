package com.aurvo.cloudportal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.aurvo.cloudportal.ui.theme.AurvoCloudPortalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            AurvoCloudPortalTheme {
                AurvoCloudPortalApp()
            }
        }
    }
}
