☁️ AURVO Cloud Portal

Ecosistema oficial de Hiperorquestación Cognitiva (HOC)
Desarrollado por Sygmare Holding — Fabricado en Chile. Diseñado para el futuro.




---

🚀 Visión general

AURVO Cloud Portal es el centro de mando del ecosistema digital AURVO®, una plataforma de hiperorquestación inteligente donde convergen infraestructura, IA, diseño y operaciones en tiempo real.

Cada subsistema está anclado en el marco HOC (Hiperorquestación Cognitiva) de Sygmare Holding, unificando software, marcas, y automatización empresarial bajo un mismo eje de control.


---

🧠 Arquitectura del ecosistema

Módulo	Descripción	Subsistema

AURVO Core	Núcleo de identidad, datos y licencias.	Maestro OS
Sygmare Cloud Engine	Motor IA distribuido para automatización inteligente.	HOC Framework
Aurvo Design Hub	Espacio creativo y gestión de branding digital.	Aurvo Creativo
Maestro OS Suite	Panel de productividad y automatización personal.	Maestro Intelligence
AhorraYa IA	Sistema de optimización de consumo y predicción económica.	Aurvo Econ
Aurvo AutoCloud	Control remoto y telemetría de autos AURVO.	Aurvo Mobility



---

⚙️ Instalación y despliegue

🔧 Requisitos previos

Node.js ≥ 18

Git

Vercel CLI (opcional)

PostgreSQL / NeonDB

Cuenta en GitHub y Vercel vinculada a Sygmare Holding



---

🧩 Instalación local

# Clona el repositorio
git clone https://github.com/morillogruop/aurvo-cloud-portal.git
cd aurvo-cloud-portal

# Instala dependencias
npm install

# Configura variables de entorno
cp .env.example .env

Configura las siguientes variables dentro de .env:

DATABASE_URL="postgresql://usuario:password@localhost:5432/aurvocloud"
NEXTAUTH_SECRET="tu_clave_secreta"
AURVO_API_KEY="tu_api_key_hoc"
VERCEL_PROJECT_ID="tu_project_id"


---

🚀 Despliegue automático (Vercel + GitHub Actions)

# Despliega directamente con Vercel
vercel deploy --prod

El workflow de CI/CD está preconfigurado para:

Ejecutar tests y build en cada push a main.

Validar la AURVO License y tokens HOC antes del despliegue.

Publicar automáticamente en aurvo.syghmareholding.com


Archivo del flujo: .github/workflows/deploy.yml


---

💡 Conexión con HOC API

El portal se comunica con el motor de Hiperorquestación Cognitiva (HOC) a través de https://api.sygmareholding.com/hoc/v1.

Ejemplo de integración:

import axios from "axios";

const response = await axios.post("https://api.sygmareholding.com/hoc/v1/auth", {
  aurvo_id: "USER_ID",
  api_key: process.env.AURVO_API_KEY,
});

console.log("Sesión HOC activa:", response.data.status);


---

🧠 Tecnologías base

Frontend: Next.js + React + Tailwind + Framer Motion

Backend: Node.js + Express + Prisma + PostgreSQL

IA Engine: Python + FastAPI + LangChain

Infraestructura: Vercel + Cloudflare + Docker

DevOps: GitHub Actions + CI/CD + Nginx

Seguridad: JWT, OAuth2, CORS Hardened Layer



---

🧭 Rutas principales

Endpoint	Descripción

/dashboard	Vista general de todo el ecosistema.
/auth	Gestión de identidad AURVO ID.
/hoc	Control del motor de Hiperorquestación Cognitiva.
/branding	Panel creativo y gestión de activos visuales.
/mobility	Conexión con los vehículos AURVO.
/ai	Centro de IA generativa empresarial.



---

🪙 Licencia

Este software está protegido bajo la AURVO LICENSE v1.0
© 2025 Sygmare Holding — Todos los derechos reservados.
Consulta el archivo LICENSE-AURVO.md para detalles legales.


---

🌍 Contribuciones

Las contribuciones están restringidas a equipos oficiales del ecosistema HOC / AURVO / SYGMARE.
Solicitudes externas deben pasar por contrato HOC DevLink™.

📧 dev@sygmareholding.com
🌐 https://sygmareholding.com


---

🏁 Tagline corporativo

> AURVO Cloud Portal — “El oro también habita en la nube.” ☁️💛


