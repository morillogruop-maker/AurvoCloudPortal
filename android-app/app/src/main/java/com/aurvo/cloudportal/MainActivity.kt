package com.aurvo.cloudportal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalLayoutApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aurvo.cloudportal.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AurvoCloudPortalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AurvoCloudPortalScreen()
                }
            }
        }
    }
}

@Composable
fun AurvoCloudPortalScreen() {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(listOf(GalaxyBlack, NebulaGray)))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 24.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            HeroSection()
            ServiceGrid()
            EcosystemHighlights()
            PlatformStatus()
            VisionShowcase()
            ContactSection()
        }
    }
}

@Composable
private fun HeroSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(12.dp, shape = RoundedCornerShape(28.dp)),
        colors = CardDefaults.cardColors(containerColor = NebulaGray.copy(alpha = 0.75f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text(
                        text = "Aurvo Cloud Portal",
                        style = MaterialTheme.typography.displayLarge,
                        color = TextPrimary
                    )
                    Text(
                        text = "Infraestructura autosanable, inteligencia predictiva y experiencias impecables en un solo panel.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = TextSecondary
                    )
                }
                AssistChip(
                    onClick = {},
                    label = { Text("Status: Óptimo", color = Color.Black) },
                    leadingIcon = {
                        Icon(Icons.Filled.Bolt, contentDescription = null, tint = Color.Black)
                    },
                    colors = AssistChipDefaults.assistChipColors(containerColor = CosmicCyan)
                )
            }
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                listOf(
                    "Cloud OS cuántico",
                    "Analítica hiperinteligente",
                    "Despliegues sin fricción",
                    "IA conversacional",
                    "Gobernanza autónoma"
                ).forEach { capability ->
                    ElevatedSuggestionChip(
                        onClick = {},
                        label = { Text(capability, color = TextPrimary) },
                        icon = {
                            Icon(Icons.Filled.AutoAwesome, contentDescription = null, tint = CosmicCyan)
                        },
                        colors = SuggestionChipDefaults.elevatedSuggestionChipColors(
                            containerColor = NebulaGray.copy(alpha = 0.85f)
                        )
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = AuroraBlue)
                ) {
                    Icon(Icons.Filled.PlayCircle, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Demo inmersiva")
                }
                OutlinedButton(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = TextPrimary),
                    border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.5.dp, brush = PremiumAuroraBrush)
                ) {
                    Icon(Icons.Filled.Schedule, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Agendar tour ejecutivo")
                }
            }
        }
    }
}

@Composable
private fun ServiceGrid() {
    val services = listOf(
        ServiceCardData(
            title = "Aurvo Nebula",
            description = "Compute elástico multizona, autosanación y optimización energética cuántica.",
            icon = Icons.Filled.CloudQueue,
            accent = AuroraBlue
        ),
        ServiceCardData(
            title = "Aurvo Synapse",
            description = "Modelo cognitivo que anticipa demanda y orquesta la experiencia de tus clientes.",
            icon = Icons.Filled.Psychology,
            accent = StellarPurple
        ),
        ServiceCardData(
            title = "Aurvo Pulse",
            description = "Panel en tiempo real con predicciones de resiliencia y mantenibilidad.",
            icon = Icons.Filled.MonitorHeart,
            accent = CosmicCyan
        ),
        ServiceCardData(
            title = "Aurvo Shield",
            description = "Seguridad autónoma con respuesta coordinada y cumplimiento inteligente.",
            icon = Icons.Filled.Security,
            accent = SolarAmber
        )
    )

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        SectionHeader(
            title = "Ecosistema de servicios",
            subtitle = "Módulos modulares que elevan la operación de nube al estándar Aurvo."
        )
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            services.chunked(2).forEach { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    rowItems.forEach { service ->
                        ServiceCard(service, modifier = Modifier.weight(1f))
                    }
                    if (rowItems.size == 1) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
private fun SectionHeader(title: String, subtitle: String) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(text = title, style = MaterialTheme.typography.titleLarge, color = TextPrimary)
        Text(text = subtitle, style = MaterialTheme.typography.bodyLarge, color = TextSecondary)
    }
}

@Composable
private fun ServiceCard(data: ServiceCardData, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = NebulaGray.copy(alpha = 0.85f))
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(data.accent.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(data.icon, contentDescription = null, tint = data.accent)
            }
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(data.title, style = MaterialTheme.typography.titleMedium, color = TextPrimary)
                Text(data.description, style = MaterialTheme.typography.bodyMedium, color = TextSecondary)
            }
            FilledTonalButton(onClick = {}, colors = ButtonDefaults.filledTonalButtonColors(containerColor = data.accent.copy(alpha = 0.2f))) {
                Text("Explorar", color = data.accent)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(Icons.Filled.ArrowOutward, contentDescription = null, tint = data.accent)
            }
        }
    }
}

data class ServiceCardData(
    val title: String,
    val description: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val accent: Color
)

@Composable
private fun EcosystemHighlights() {
    val highlights = listOf(
        HighlightData(
            title = "Experiencias orquestadas",
            description = "Blueprints de journeys multi-nube diseñados con IA generativa para activar productos en minutos.",
            icon = Icons.Filled.SpatialAudioOff
        ),
        HighlightData(
            title = "Operación autónoma",
            description = "Flujos de trabajo autoajustables, observabilidad predictiva y recomendaciones accionables.",
            icon = Icons.Filled.AutoFixHigh
        ),
        HighlightData(
            title = "Cultura de excelencia",
            description = "Panel de talento digital, certificaciones vivas y playbooks colaborativos.",
            icon = Icons.Filled.Diversity3
        )
    )

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        SectionHeader(
            title = "Ecosistema Aurvo",
            subtitle = "Conecta equipos, productos y datos en un flujo continuo de innovación."
        )
        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(highlights.size) { index ->
                EcosystemHighlightCard(highlights[index])
            }
        }
    }
}

@Composable
private fun EcosystemHighlightCard(data: HighlightData) {
    Card(
        modifier = Modifier.width(260.dp),
        colors = CardDefaults.cardColors(containerColor = NebulaGray.copy(alpha = 0.9f))
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(data.icon, contentDescription = null, tint = CosmicCyan, modifier = Modifier.size(32.dp))
            Text(data.title, style = MaterialTheme.typography.titleMedium, color = TextPrimary)
            Text(data.description, style = MaterialTheme.typography.bodyMedium, color = TextSecondary)
        }
    }
}

data class HighlightData(
    val title: String,
    val description: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

@Composable
private fun PlatformStatus() {
    val statusEntries = listOf(
        StatusEntry("Global Edge", "Latencia media 12ms", Icons.Filled.NetworkCheck, CosmicCyan),
        StatusEntry("Aurvo Synapse", "Aprendizaje reforzado activo", Icons.Filled.Lightbulb, SolarAmber),
        StatusEntry("Compliance", "Certificación QuantumSOC 6 vigente", Icons.Filled.VerifiedUser, AuroraBlue),
        StatusEntry("Trust Center", "0 incidentes críticos en 18 meses", Icons.Filled.Shield, StellarPurple)
    )

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        SectionHeader(
            title = "Estado en vivo",
            subtitle = "Transparencia radical para tus operaciones críticas."
        )
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            statusEntries.forEach { entry ->
                StatusCard(entry)
            }
        }
    }
}

data class StatusEntry(
    val title: String,
    val summary: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val accent: Color
)

@Composable
private fun StatusCard(entry: StatusEntry) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = NebulaGray.copy(alpha = 0.85f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(entry.accent.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(entry.icon, contentDescription = null, tint = entry.accent)
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(entry.title, style = MaterialTheme.typography.titleMedium, color = TextPrimary)
                Text(entry.summary, style = MaterialTheme.typography.bodyMedium, color = TextSecondary)
            }
            Icon(Icons.Filled.ChevronRight, contentDescription = null, tint = TextSecondary)
        }
    }
}

@Composable
private fun VisionShowcase() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = NebulaGray.copy(alpha = 0.85f))
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            SectionHeader(
                title = "Visión 2030",
                subtitle = "Protocolos autónomos, experiencias inmersivas y alianzas estratégicas para liderar la era post-cloud."
            )
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                VisionPillar(
                    title = "IA Amplificada",
                    description = "Gemelos digitales para anticipar decisiones y evolucionar productos en tiempo real."
                )
                VisionPillar(
                    title = "Arquitectura 0-latencia",
                    description = "Edge cuántico y redes opto-fotónicas para habilitar experiencias instantáneas."
                )
                VisionPillar(
                    title = "Impacto Regenerativo",
                    description = "Plataformas carbono-negativas y ecosistemas circulares co-creados con socios."
                )
            }
        }
    }
}

@Composable
private fun VisionPillar(title: String, description: String) {
    Column(
        modifier = Modifier
            .widthIn(min = 220.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(NebulaGray.copy(alpha = 0.75f))
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(title, style = MaterialTheme.typography.titleMedium, color = TextPrimary)
        Text(description, style = MaterialTheme.typography.bodyMedium, color = TextSecondary)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ContactSection() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var selectedInterest by remember { mutableStateOf(InterestOption.SovereignCloud) }
    var interestExpanded by remember { mutableStateOf(false) }
    var consent by remember { mutableStateOf(true) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = NebulaGray.copy(alpha = 0.9f))
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            SectionHeader(
                title = "Hablemos del futuro",
                subtitle = "Conecta con un estratega Aurvo para diseñar tu próxima ventaja competitiva."
            )
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nombre completo") },
                leadingIcon = { Icon(Icons.Filled.Badge, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                colors = textFieldColors()
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo corporativo") },
                leadingIcon = { Icon(Icons.Filled.AlternateEmail, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                colors = textFieldColors()
            )
            ExposedDropdownMenuBox(
                expanded = interestExpanded,
                onExpandedChange = { interestExpanded = !interestExpanded }
            ) {
                OutlinedTextField(
                    value = selectedInterest.label,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Interés principal") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = interestExpanded)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(),
                    colors = textFieldColors()
                )
                ExposedDropdownMenu(
                    expanded = interestExpanded,
                    onDismissRequest = { interestExpanded = false }
                ) {
                    InterestOption.values().forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option.label) },
                            onClick = {
                                selectedInterest = option
                                interestExpanded = false
                            },
                            leadingIcon = {
                                if (option == selectedInterest) {
                                    Icon(Icons.Filled.Check, contentDescription = null)
                                }
                            }
                        )
                    }
                }
            }
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                InterestOption.values().forEach { option ->
                    FilterChip(
                        selected = selectedInterest == option,
                        onClick = { selectedInterest = option },
                        label = { Text(option.label) },
                        leadingIcon = if (selectedInterest == option) {
                            {
                                Icon(Icons.Filled.Check, contentDescription = null)
                            }
                        } else null,
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = AuroraBlue.copy(alpha = 0.3f),
                            selectedLabelColor = TextPrimary,
                            containerColor = NebulaGray,
                            labelColor = TextSecondary
                        )
                    )
                }
            }
            OutlinedTextField(
                value = message,
                onValueChange = { message = it },
                label = { Text("¿Cuál es tu visión?") },
                leadingIcon = { Icon(Icons.Filled.EditNote, contentDescription = null) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                colors = textFieldColors(),
                supportingText = {
                    Text("Sé específico. Nuestro equipo responde en menos de 12 horas.", color = TextSecondary)
                }
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Switch(checked = consent, onCheckedChange = { consent = it })
                Text(
                    "Autorizo recibir experiencias personalizadas, actualizaciones y acceso prioritario a pilotos.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondary,
                    modifier = Modifier.weight(1f)
                )
            }
            Button(
                onClick = {},
                enabled = consent && name.isNotBlank() && email.isNotBlank() && message.isNotBlank(),
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = CosmicCyan)
            ) {
                Icon(Icons.Filled.Send, contentDescription = null, tint = Color.Black)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Programar sesión visionaria", color = Color.Black)
            }
            InterestSummary(selectedInterest)
        }
    }
}

@Composable
private fun textFieldColors() = TextFieldDefaults.outlinedTextFieldColors(
    focusedBorderColor = CosmicCyan,
    unfocusedBorderColor = DividerDark,
    cursorColor = CosmicCyan,
    focusedLabelColor = CosmicCyan,
    unfocusedLabelColor = TextSecondary,
    focusedTextColor = TextPrimary,
    unfocusedTextColor = TextPrimary,
    focusedLeadingIconColor = CosmicCyan,
    unfocusedLeadingIconColor = TextSecondary
)

enum class InterestOption(val label: String, val description: String) {
    SovereignCloud(
        label = "Nube soberana",
        description = "Infraestructura con jurisdicción controlada, resiliencia y cumplimiento reforzado por IA."
    ),
    AutonomousOps(
        label = "Operaciones autónomas",
        description = "Automatizaciones inteligentes, aprendizaje continuo y recomendaciones de alto impacto."
    ),
    ExperienceDesign(
        label = "Experiencias inmersivas",
        description = "Diseño sensorial y journeys conectados para cautivar a tus usuarios premium."
    ),
    QuantumEdge(
        label = "Edge cuántico",
        description = "Procesamiento extremo, latencia ultrabaja y analítica instantánea en cualquier punto de contacto."
    ),
    StrategicAlliances(
        label = "Alianzas estratégicas",
        description = "Programas de co-innovación y modelos de negocio compartidos con líderes globales."
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FlowRow(
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    content: @Composable () -> Unit
) {
    androidx.compose.foundation.layout.FlowRow(
        modifier = modifier,
        horizontalArrangement = horizontalArrangement,
        verticalArrangement = verticalArrangement,
        content = content
    )
}

@Composable
private fun InterestSummary(option: InterestOption) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        shape = RoundedCornerShape(16.dp),
        color = NebulaGray.copy(alpha = 0.8f)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Interés principal", style = MaterialTheme.typography.labelLarge, color = TextSecondary)
            Text(option.label, style = MaterialTheme.typography.titleMedium, color = TextPrimary)
            Text(
                option.description,
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary
            )
        }
    }
}
