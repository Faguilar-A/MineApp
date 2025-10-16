
# MineApp 🔦📱

MineApp es una aplicación utilitaria que combina múltiples funcionalidades en una sola interfaz cohesiva. Desarrollada específicamente para demostrar el manejo de Intents, permisos en tiempo de ejecución.


## Informacion Tecnica

- Versión de Android: Android pixel 7 (API 31) ![GPLv3 License](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)

- Versión de AGP: 8.1.2![GPLv3 License](https://img.shields.io/badge/AGP-8.1.2-success?style=for-the-badge)

- Lenguaje de programación: Java ![GPLv3 License](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
## 🛠️ Funcionalidades Principales
Estas son algunas de las Funcionalidades  Principales del proyecto.

**🔦 Linterna Inteligente**
- Control del flash con permisos dinámicos

- Activación/desactivación con un botón

- Apagado automático al salir de la app

**📅 Gestor de Calendario**
- Agregar eventos al calendario nativo

- Selector de fecha y hora integrado

- Configuración automática de recordatorios

**⚙️ Accesos Directos**
- Configuración Wi-Fi del sistema

- Configuración Bluetooth

- Ajustes inalámbricos

**👤 Perfil Estudiante**
- Información académica del estudiante

- Interfaz personalizada con temática Minecraft

- Gestión de datos de contacto

**📞 Comunicación**
- Envío de SMS preconfigurados

- Compartición de texto entre apps

- Envío de correos electrónicos


## 📋 Intents Implementados

#### 🔄 Intents Implícitos (5)


| # | Inten     | Proposito              | Cómo probar |
| :-------- | :------- | :------------------------- | :-------------------|
| `1` | `ACTION_SENDTO` + mailto |    Enviar correo  | Botón "Enviar Correo"  |
| `2` | `ACTION_VIEW` + UML | Abrir navegador     | Botón "Abrir Sitio Web" |
| `3` | `ACTION_SENDTO` + smsto| Enviar SMS     | Botón "Enviar SMS"  |
| `4` | `ACTION_WIFI_SETTINGS` |    Configurar Wi-Fi  | Botón "Configuración Wi-Fi" Correo" |
| `5` | `CameraManager` + Permisos|  Controlar Linterna    |  Botón "Linterna ON/OFF" |



#### 🎯 Intents Explícitos (3)

| # | Navegación | Datos trasferido           
| :-------- | :------- | :------------------------- | 
| `1` | `HomeActivity → ConfiguracionActivity `  |  Simular pantalla de ajustes interna    | 
| `2` | `HomeActivity → AyudaActivity `  | Mostrar guía de uso o comandos de voz    | 
| `3` | `HomeActivity → PerfilActivity` |   Mostrar detalle adicional  | 



## Screenshots

![imagen proyecto 3](https://github.com/user-attachments/assets/812ef89e-bbfc-49bf-a7cf-350c6396a9c6)
![imagen proyecto 2](https://github.com/user-attachments/assets/988adef6-1bf8-43f8-870e-738b0cf50bc5)
![App Screenshot](https://github.com/user-attachments/assets/0a0cfb76-7f20-438e-9604-608b9ef0492a)
![imagen proyecto](https://github.com/user-attachments/assets/faa34f29-7d11-4d9e-a7bf-6815cf05ab4a)


## 🚀 Instalación y Uso

**Descargar la APK**


  **1.** Ve a la carpeta `app/build/outputs/apk/debug/`

  **2.** Descarga `app-debug.apk`

  **3.** Instala en tu dispositivo Android

  **4.** Credenciales de prueba:

  - Email: aguilar@st.cl
  - Contraseña: 123456

    
## 👨‍💻Authors
 
 **Francisco Aguilar**
- [@Faguilar](https://github.com/Faguilar-A)

**Samuel Aguilar**
- [@Saguilar](https://github.com/sam-aguilar143)



# ⭐ ¡No olvides darle una estrella al proyecto si te fue útil!                   ¡Disfruta usando MineApp! 🎉
