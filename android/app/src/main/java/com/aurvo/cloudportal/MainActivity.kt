package com.aurvo.cloudportal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowOutward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aurvo.cloudportal.ui.theme.AurvoCloudPortalTheme
import com.aurvo.cloudportal.ui.theme.GalacticBackground
import com.aurvo.cloudportal.ui.theme.HeroGradient
import com.aurvo.cloudportal.ui.theme.orbitron

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AurvoCloudPortalTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    PortalScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun PortalScreen() {
    val scrollState = rememberScrollState()

    Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(GalacticBackground)
                .padding(padding)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .alpha(0.5f)
                    .background(HeroGradient)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(horizontal = 24.dp, vertical = 32.dp),
                verticalArrangement = Arrangement.spacedBy(32.dp)
            ) {
                HeroSection()
                QuickAccessSection()
                EcosystemSection()
                StatusSection()
                CallToActionSection()
                ContactSection()
                FooterSection()
            }
        }
    }
}

@Composable
private fun HeroSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Escritorio centralizado",
            style = MaterialTheme.typography.labelLarge.copy(
                fontFamily = orbitron,
                letterSpacing = 6.sp,
                color = Color(0xFF38BDF8)
            )
        )
        Text(
            text = "Aurvo Cloud Portal",
            style = MaterialTheme.typography.displaySmall.copy(
                fontFamily = orbitron,
                lineHeight = 42.sp
            )
        )
        Text(
            text = "Unifica tus plataformas AURVO en un panel celestial: rápido, seguro y sincronizado en tiempo real.",
            style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
        )
        PrimaryActionRow(
            primary = "Lanzar AurvoOS",
            secondary = "Explorar suite"
        )
        MetricsRow(
            metrics = listOf(
                "Usuarios activos" to "24K",
                "Tiempo de actividad" to "99.982%",
                "Zonas disponibles" to "17"
            )
        )
        PreviewCard()
    }
}

@Composable
private fun PrimaryActionRow(primary: String, secondary: String) {
    androidx.compose.foundation.layout.Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ActionButton(text = primary, elevated = true)
        ActionButton(text = secondary, elevated = false)
    }
}

@Composable
private fun ActionButton(text: String, elevated: Boolean) {
    if (elevated) {
        androidx.compose.material3.Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFACC15),
                contentColor = Color(0xFF0F172A)
            ),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp),
            modifier = Modifier.shadow(12.dp, shape = MaterialTheme.shapes.large)
        ) {
            Text(text = text, style = MaterialTheme.typography.labelLarge)
        }
    } else {
        androidx.compose.material3.OutlinedButton(
            onClick = { },
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f)),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            modifier = Modifier.shadow(0.dp)
        ) {
            Text(text = text, style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Composable
private fun MetricsRow(metrics: List<Pair<String, String>>) {
    androidx.compose.foundation.layout.Row(
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        metrics.forEach { (label, value) ->
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = label.uppercase(),
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontFamily = orbitron,
                        letterSpacing = 4.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
                Text(
                    text = value,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontFamily = orbitron,
                        color = Color(0xFFFACC15)
                    )
                )
            }
        }
    }
}

@Composable
private fun PreviewCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.extraLarge),
        tonalElevation = 12.dp,
        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.6f)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Panel en vivo",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontFamily = orbitron,
                    color = Color(0xFFFACC15)
                )
            )
            listOf(
                "Orquestación distribuida completada ✅",
                "12 nuevas integraciones disponibles",
                "Autenticación cuántica estable"
            ).forEach { item ->
                androidx.compose.foundation.layout.Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(MaterialTheme.shapes.small)
                            .background(Color(0xFF38BDF8))
                    )
                    Text(text = item, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Composable
private fun QuickAccessSection() {
    SectionTitle(title = "Servicios", subtitle = "Accesos rápidos a la suite")
    val cards = listOf(
        Triple("🖥️ AurvoOS", "Sistema operativo cloud con escritorios modulares y aplicaciones compartidas.", "Abrir"),
        Triple("🤖 AurvoAI", "Modelos inteligentes para automatizar flujos y potenciar decisiones.", "Abrir"),
        Triple("🎨 AurvoStudio", "Diseño colaborativo con edición en tiempo real y bibliotecas unificadas.", "Abrir"),
        Triple("💰 AurvoFinance", "Gestión financiera avanzada con analítica predictiva y reportes dinámicos.", "Abrir"),
        Triple("📊 AurvoDashboardPro", "Observabilidad total de KPIs, flujos y automatizaciones en tiempo real.", "Abrir")
    )

    LazyVerticalGrid(
        columns = GridCells.Adaptive(200.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 12.dp)
    ) {
        items(cards) { (title, description, action) ->
            Surface(
                tonalElevation = 6.dp,
                modifier = Modifier.clip(MaterialTheme.shapes.extraLarge)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(title, style = MaterialTheme.typography.titleMedium.copy(fontFamily = orbitron, color = Color(0xFFFACC15)))
                    Text(description, style = MaterialTheme.typography.bodyMedium)
                    SecondaryLink(action)
                }
            }
        }
    }
}

@Composable
private fun SectionTitle(title: String, subtitle: String? = null) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(title, style = MaterialTheme.typography.headlineMedium.copy(fontFamily = orbitron))
        subtitle?.let {
            Text(it, style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant))
        }
    }
}

@Composable
private fun SecondaryLink(label: String) {
    androidx.compose.foundation.layout.Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(label, style = MaterialTheme.typography.labelLarge.copy(color = Color(0xFF38BDF8)))
        Icon(
            painter = rememberVectorPainter(Icons.Default.ArrowOutward),
            contentDescription = null,
            tint = Color(0xFF38BDF8)
        )
    }
}

@Composable
private fun EcosystemSection() {
    SectionTitle("Todo el ecosistema, sincronizado")
    val pillars = listOf(
        Triple("Monitoreo", "Core Metrics", "Dashboards de latencia, rendimiento y energía en una vista unificada."),
        Triple("Identidad", "Quantum ID", "Inicio de sesión multifactor con cifrado dinámico y verificación biométrica."),
        Triple("Automatización", "Workflow Nexus", "Flujos drag & drop, alertas inteligentes y asistentes co-pilotados."),
        Triple("Insights", "DataPulse", "Modelos de aprendizaje continuo para extraer patrones accionables.")
    )

    LazyVerticalGrid(
        columns = GridCells.Adaptive(220.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 12.dp)
    ) {
        items(pillars) { (tag, name, copy) ->
            Surface(
                tonalElevation = 8.dp,
                modifier = Modifier.clip(MaterialTheme.shapes.extraLarge)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        tag.uppercase(),
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontFamily = orbitron,
                            letterSpacing = 4.sp,
                            color = Color(0xFFFACC15)
                        )
                    )
                    Text(name, style = MaterialTheme.typography.titleLarge.copy(fontFamily = orbitron))
                    Text(copy, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Composable
private fun StatusSection() {
    SectionTitle("Estado de la plataforma")
    val services = listOf(
        "AurvoOS" to "✅ Sin incidentes",
        "AurvoAI" to "⚡ Ajustes menores",
        "AurvoStudio" to "✅ Estable",
        "AurvoFinance" to "✅ Estable",
        "DashboardPro" to "🛰️ Despliegue en curso"
    )

    Surface(
        modifier = Modifier.fillMaxWidth(),
        tonalElevation = 8.dp,
        shape = MaterialTheme.shapes.extraLarge
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Operativa",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontFamily = orbitron,
                    color = Color(0xFF4ADE80)
                )
            )
            services.chunked(2).forEach { rowItems ->
                androidx.compose.foundation.layout.Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    rowItems.forEach { (label, value) ->
                        StatusMetric(label, value, Modifier.weight(1f))
                    }
                    if (rowItems.size == 1) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    text = "Novedades recientes",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontFamily = orbitron,
                        color = Color(0xFF38BDF8)
                    )
                )
                listOf(
                    "Integración con redes cuánticas completada.",
                    "Se libera modo \"Dark Nebula\" para AurvoStudio.",
                    "Nuevas políticas de compliance automatizadas."
                ).forEach { update ->
                    Text(update, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Composable
private fun StatusMetric(label: String, value: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        tonalElevation = 6.dp,
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = label.uppercase(),
                style = MaterialTheme.typography.labelSmall.copy(
                    fontFamily = orbitron,
                    letterSpacing = 3.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
            Text(value, style = MaterialTheme.typography.bodyLarge.copy(fontFamily = orbitron, color = Color(0xFFFACC15)))
        }
    }
}

@Composable
private fun CallToActionSection() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        tonalElevation = 10.dp,
        shape = MaterialTheme.shapes.extraLarge
    ) {
        androidx.compose.foundation.layout.Row(
            modifier = Modifier.padding(24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Despliega tu universo AURVO en minutos", style = MaterialTheme.typography.titleLarge.copy(fontFamily = orbitron))
                Text(
                    "Conecta equipos, proyectos y datos en un mismo portal de productividad.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            ActionButton(text = "Ir al panel", elevated = true)
        }
    }
}

@Composable
private fun ContactSection() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        tonalElevation = 8.dp,
        shape = MaterialTheme.shapes.extraLarge
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("¿Necesitas ayuda?", style = MaterialTheme.typography.titleLarge.copy(fontFamily = orbitron))
            Text(
                "Nuestro equipo responde en menos de 5 minutos. Estamos listos para activar nuevas galaxias contigo.",
                style = MaterialTheme.typography.bodyMedium
            )
            Surface(
                tonalElevation = 4.dp,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ContactField("Nombre")
                    ContactField("Correo")
                    ContactField("Mensaje", height = 120.dp)
                    ActionButton("Contactar", elevated = false)
                }
            }
        }
    }
}

@Composable
private fun ContactField(label: String, height: Dp = 52.dp) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(label, style = MaterialTheme.typography.labelLarge.copy(color = MaterialTheme.colorScheme.onSurfaceVariant))
        Surface(
            shape = MaterialTheme.shapes.medium,
            tonalElevation = 2.dp,
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height)
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = when (label) {
                        "Nombre" -> "Tu nombre"
                        "Correo" -> "correo@empresa.com"
                        else -> "¿Cómo podemos ayudarte?"
                    },
                    style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                )
            }
        }
    }
}

@Composable
private fun FooterSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "AURVO",
            style = MaterialTheme.typography.titleLarge.copy(fontFamily = orbitron, color = Color(0xFFFACC15))
        )
        Text(
            "Oro en movimiento — Innovación sin gravedad.",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            "© 2025 AURVO Cloud Portal. Todos los derechos reservados.",
            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
        )
    }
}
