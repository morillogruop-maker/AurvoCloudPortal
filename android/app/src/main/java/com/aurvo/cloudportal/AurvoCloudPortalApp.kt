package com.aurvo.cloudportal

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalLayoutApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateBottomPadding
import androidx.compose.foundation.layout.calculateTopPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aurvo.cloudportal.ui.theme.AuroraPurple
import com.aurvo.cloudportal.ui.theme.NebulaBlue
import com.aurvo.cloudportal.ui.theme.SolarFlare
import com.aurvo.cloudportal.ui.theme.SolarFlareStrong
import com.aurvo.cloudportal.ui.theme.SpaceNight
import com.aurvo.cloudportal.ui.theme.StarWhite
import com.aurvo.cloudportal.ui.theme.Stardust

private val services = listOf(
    ServiceLink(
        icon = "🖥️",
        title = "AurvoOS",
        description = "Sistema operativo cloud con escritorios modulares y aplicaciones compartidas.",
        url = "https://aurvoos.vercel.app"
    ),
    ServiceLink(
        icon = "🤖",
        title = "AurvoAI",
        description = "Modelos inteligentes para automatizar flujos y potenciar decisiones.",
        url = "https://aurvoai.vercel.app"
    ),
    ServiceLink(
        icon = "🎨",
        title = "AurvoStudio",
        description = "Diseño colaborativo con edición en tiempo real y bibliotecas unificadas.",
        url = "https://aurvostudio.vercel.app"
    ),
    ServiceLink(
        icon = "💰",
        title = "AurvoFinance",
        description = "Gestión financiera avanzada con analítica predictiva y reportes dinámicos.",
        url = "https://aurvofinance.vercel.app"
    ),
    ServiceLink(
        icon = "📊",
        title = "AurvoDashboardPro",
        description = "Observabilidad total de KPIs, flujos y automatizaciones en tiempo real.",
        url = "https://aurvocoredashboardpro.vercel.app"
    )
)

private val ecosystem = listOf(
    EcosystemItem("Monitoreo", "Core Metrics", "Dashboards de latencia, rendimiento y energía en una vista unificada."),
    EcosystemItem("Identidad", "Quantum ID", "Inicio de sesión multifactor con cifrado dinámico y verificación biométrica."),
    EcosystemItem("Automatización", "Workflow Nexus", "Flujos drag & drop, alertas inteligentes y asistentes co-pilotados."),
    EcosystemItem("Insights", "DataPulse", "Modelos de aprendizaje continuo para extraer patrones accionables.")
)

private val statusMetrics = listOf(
    StatusMetric("AurvoOS", "✅ Sin incidentes"),
    StatusMetric("AurvoAI", "⚡ Ajustes menores"),
    StatusMetric("AurvoStudio", "✅ Estable"),
    StatusMetric("AurvoFinance", "✅ Estable"),
    StatusMetric("DashboardPro", "🛰️ Despliegue en curso")
)

private val updates = listOf(
    "Integración con redes cuánticas completada.",
    "Se libera modo \"Dark Nebula\" para AurvoStudio.",
    "Nuevas políticas de compliance automatizadas."
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AurvoCloudPortalApp() {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Surface(color = SpaceNight) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0x33203147), Color(0x33081224), Color(0x22020513))
                    )
                )
        ) {
            DecorativeNebula()
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                containerColor = Color.Transparent,
                topBar = { AurvoTopBar(scrollBehavior) }
            ) { innerPadding ->
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = innerPadding.withOuterPadding(),
                    verticalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    item { HeroSection() }
                    item { ServicesSection() }
                    item { EcosystemSection() }
                    item { StatusSection() }
                    item { CtaBannerSection() }
                    item { ContactSection() }
                    item { FooterSection() }
                }
            }
        }
    }
}

private fun PaddingValues.withOuterPadding(): PaddingValues {
    val horizontal = 24.dp
    val top = calculateTopPadding() + 24.dp
    val bottom = calculateBottomPadding() + 48.dp
    return PaddingValues(start = horizontal, top = top, end = horizontal, bottom = bottom)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AurvoTopBar(scrollBehavior: TopAppBarScrollBehavior) {
    val context = LocalContext.current
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(14.dp)
                        .clip(CircleShape)
                        .background(
                            Brush.radialGradient(
                                colors = listOf(SolarFlare, Color.Transparent)
                            )
                        )
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "AURVO",
                    style = MaterialTheme.typography.titleLarge,
                    color = SolarFlare,
                    letterSpacing = 3.sp
                )
            }
        },
        actions = {
            TextButton(onClick = { context.launchUrl("https://aurvocoredashboardpro.vercel.app") }) {
                Text(text = "Ingresar", color = SolarFlare)
            }
        },
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            scrolledContainerColor = Color(0xCC050816)
        )
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun HeroSection() {
    val context = LocalContext.current
    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(
                text = "Escritorio centralizado",
                style = MaterialTheme.typography.labelLarge,
                color = NebulaBlue,
                letterSpacing = 4.sp
            )
            Text(
                text = "Aurvo Cloud Portal",
                style = MaterialTheme.typography.displayLarge,
                color = StarWhite
            )
            Text(
                text = "Unifica tus plataformas AURVO en un panel celestial: rápido, seguro y sincronizado en tiempo real.",
                style = MaterialTheme.typography.bodyLarge,
                color = Stardust
            )
        }

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            PrimaryButton(text = "Lanzar AurvoOS") {
                context.launchUrl("https://aurvoos.vercel.app")
            }
            SecondaryButton(text = "Explorar suite") {}
        }

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            MetricCard(label = "Usuarios activos", value = "24K")
            MetricCard(label = "Tiempo de actividad", value = "99.982%")
            MetricCard(label = "Zonas disponibles", value = "17")
        }

        HeroPreviewCard()
    }
}

@Composable
private fun PrimaryButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = SolarFlare,
            contentColor = Color(0xFF111827)
        ),
        shape = RoundedCornerShape(50)
    ) {
        Text(text = text, style = MaterialTheme.typography.labelLarge)
    }
}

@Composable
private fun SecondaryButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = Stardust
        ),
        shape = RoundedCornerShape(50),
        border = BorderStroke(width = 1.dp, color = Color(0x668293B5))
    ) {
        Text(text = text, style = MaterialTheme.typography.labelLarge)
    }
}

@Composable
private fun MetricCard(label: String, value: String) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0x33222C47))
            .padding(16.dp)
    ) {
        Text(text = label.uppercase(), color = Stardust, style = MaterialTheme.typography.labelLarge)
        Text(text = value, style = MaterialTheme.typography.headlineLarge, color = SolarFlare)
    }
}

@Composable
private fun HeroPreviewCard() {
    ElevatedCard(shape = RoundedCornerShape(24.dp), modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .background(Color(0x550C122C))
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "Panel en vivo", style = MaterialTheme.typography.titleLarge, color = SolarFlare)
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                PreviewBullet("Orquestación distribuida completada ✅")
                PreviewBullet("12 nuevas integraciones disponibles")
                PreviewBullet("Autenticación cuántica estable")
            }
        }
    }
}

@Composable
private fun PreviewBullet(text: String) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(CircleShape)
                .background(NebulaBlue)
        )
        Text(text = text, style = MaterialTheme.typography.bodyLarge, color = StarWhite)
    }
}

@Composable
private fun ServicesSection() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(text = "Accesos rápidos", style = MaterialTheme.typography.titleMedium, color = NebulaBlue)
        Text(text = "Explora toda la suite AURVO", style = MaterialTheme.typography.headlineMedium, color = StarWhite)
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            services.forEach { service ->
                ServiceCard(service)
            }
        }
    }
}

@Composable
private fun ServiceCard(service: ServiceLink) {
    val context = LocalContext.current
    ElevatedCard(shape = RoundedCornerShape(24.dp), modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .background(Color(0x6612192E))
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "${service.icon} ${service.title}",
                style = MaterialTheme.typography.titleLarge,
                color = SolarFlare
            )
            Text(text = service.description, style = MaterialTheme.typography.bodyMedium, color = Stardust)
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(text = "Abrir", color = NebulaBlue, style = MaterialTheme.typography.labelLarge)
                Icon(imageVector = Icons.Outlined.ArrowForward, contentDescription = null, tint = NebulaBlue, modifier = Modifier.size(18.dp))
            }
        }
    }
    Spacer(modifier = Modifier.height(4.dp))
    TextButton(onClick = { context.launchUrl(service.url) }) {
        Text(text = "Visitar ${service.title}", color = NebulaBlue)
    }
}

@Composable
private fun EcosystemSection() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(text = "Todo el ecosistema, sincronizado", style = MaterialTheme.typography.headlineMedium, color = StarWhite)
        Text(text = "Capas de producto alineadas para rendimiento exponencial.", style = MaterialTheme.typography.bodyLarge, color = Stardust)
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            ecosystem.forEach { item ->
                EcosystemCard(item)
            }
        }
    }
}

@Composable
private fun EcosystemCard(item: EcosystemItem) {
    ElevatedCard(shape = RoundedCornerShape(24.dp), modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .background(Color(0x55203147))
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = item.tag.uppercase(), style = MaterialTheme.typography.labelLarge, color = NebulaBlue)
            Text(text = item.title, style = MaterialTheme.typography.titleLarge, color = StarWhite)
            Text(text = item.description, style = MaterialTheme.typography.bodyLarge, color = Stardust)
        }
    }
}

@Composable
private fun StatusSection() {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        ElevatedCard(shape = RoundedCornerShape(28.dp), modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .background(Color(0x6610152B))
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Estado de la plataforma", style = MaterialTheme.typography.headlineMedium, color = StarWhite)
                    StatusBadge(text = "Operativa")
                }
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    statusMetrics.forEach { metric ->
                        StatusCard(metric)
                    }
                }
            }
        }
        ElevatedCard(shape = RoundedCornerShape(24.dp), modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .background(Color(0x44203244))
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(text = "Novedades recientes", style = MaterialTheme.typography.titleLarge, color = StarWhite)
                updates.forEach { update -> PreviewBullet(update) }
            }
        }
    }
}

@Composable
private fun StatusBadge(text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(Brush.horizontalGradient(listOf(SolarFlare, SolarFlareStrong)))
            .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {
        Text(text = text, color = Color(0xFF0F172A), style = MaterialTheme.typography.labelLarge)
    }
}

@Composable
private fun StatusCard(metric: StatusMetric) {
    ElevatedCard(shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .background(Color(0x33212B3F))
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = metric.label, style = MaterialTheme.typography.labelLarge, color = Stardust)
            Text(text = metric.state, style = MaterialTheme.typography.titleMedium, color = StarWhite)
        }
    }
}

@Composable
private fun CtaBannerSection() {
    val context = LocalContext.current
    ElevatedCard(shape = RoundedCornerShape(28.dp), modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .background(
                    Brush.linearGradient(
                        listOf(AuroraPurple.copy(alpha = 0.45f), SolarFlare.copy(alpha = 0.35f))
                    )
                )
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "Despliega tu universo AURVO en minutos", style = MaterialTheme.typography.headlineMedium, color = StarWhite)
            Text(text = "Conecta equipos, proyectos y datos en un mismo portal de productividad.", style = MaterialTheme.typography.bodyLarge, color = StarWhite.copy(alpha = 0.7f))
            PrimaryButton(text = "Ir al panel") {
                context.launchUrl("https://aurvocoredashboardpro.vercel.app")
            }
        }
    }
}

@Composable
private fun ContactSection() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    val context = LocalContext.current

    ElevatedCard(shape = RoundedCornerShape(28.dp), modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .background(Color(0x5522334F))
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "¿Necesitas ayuda?", style = MaterialTheme.typography.headlineMedium, color = StarWhite)
            Text(text = "Nuestro equipo responde en menos de 5 minutos. Estamos listos para activar nuevas galaxias contigo.", style = MaterialTheme.typography.bodyLarge, color = Stardust)
            androidx.compose.material3.OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nombre") },
                singleLine = true
            )
            androidx.compose.material3.OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo") },
                singleLine = true
            )
            androidx.compose.material3.OutlinedTextField(
                value = message,
                onValueChange = { message = it },
                label = { Text("Mensaje") },
                minLines = 4
            )
            SecondaryButton(text = "Contactar") {
                context.launchUrl("mailto:support@aurvo.com?subject=Contacto%20Aurvo%20Cloud%20Portal")
            }
        }
    }
}

@Composable
private fun FooterSection() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.fillMaxWidth()) {
        Divider(color = Color(0x338293B5))
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = "AURVO", style = MaterialTheme.typography.titleLarge, color = SolarFlare)
            Text(text = "Oro en movimiento — Innovación sin gravedad.", style = MaterialTheme.typography.bodyMedium, color = Stardust)
        }
        Text(
            text = "© 2025 AURVO Cloud Portal. Todos los derechos reservados.",
            style = MaterialTheme.typography.bodySmall,
            color = Stardust,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun DecorativeNebula() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.radialGradient(
                    colors = listOf(Color(0x3320B9FF), Color.Transparent),
                    center = androidx.compose.ui.geometry.Offset(200f, 200f),
                    radius = 700f
                )
            )
    )
}

private fun Context.launchUrl(url: String) {
    runCatching {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}

data class ServiceLink(val icon: String, val title: String, val description: String, val url: String)

data class EcosystemItem(val tag: String, val title: String, val description: String)

data class StatusMetric(val label: String, val state: String)
