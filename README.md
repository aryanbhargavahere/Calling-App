# Calling App

A state driven calling app built using Kotlin and Jetpack Compose calling app

---

## 📑 Table of Contents
1. 📝 [Description](#-description)
2. ✨ [Features](#-features)
3. 🛠️ [Tech Stack](#-tech-stack)
4. 📂 [Project Structure](#-project-structure)
6. 🚀 [Getting Started](#-getting-started)
    - 📋 [Prerequisites](#prerequisites)
    - ▶️ [Steps to Run](#steps-to-run)
7. 🧠 [How the App Works](#-how-the-app-works)
8. 🔮 [Future Enhancements](#-future-enhancements)
9. 👤 [Author](#author)

---

## 📖 Description

Calling App is built using **Kotlin** , **JetPack Compose** and modern Android development practices.  
It has proper built lifecycle IDLE , CALLING , RINGING , ACTIVE and ENDED.

---

## ✨ Features

-  Has a Dialer Pad
-  Allows Outgoing Calls  
-  Shows Logs and Contacts
-  One click feature to call someone  

---

## 🛠️ Tech Stack

- **Kotlin**
- **Android SDK**
- **JetPack Compose**
---
## 📂 Project Structure
```bash
Calling_App/
├── app/
│   ├── manifests/
│   │   └── AndroidManifest.xml
│   │
│   ├── kotlin+java/
│   │   └── com/example/callingapp/
│   │       ├── UI/Screens/
│   │       │   ├── CallLogs.kt
│   │       │   ├── ContactsScreen.kt
│   │       │   └── DialerScreen.kt
│   │       │
│   │       ├── ui/theme/
│   │       │   ├── Color.kt
│   │       │   ├── Theme.kt
│   │       │   └── Type.kt
│   │       │
│   │       └── viewmodel/
│   │           ├── CallViewModel.kt
│   │           ├── calldata.kt
│   │           ├── Calllogitem.kt
│   │           ├── callreciever.kt
│   │           ├── Contactsclass.kt
│   │           └── MainActivity.kt
│   │
│   ├── res/
│   │   ├── drawable/
│   │   │   ├── ic_launcher_background.xml
│   │   │   └── ic_launcher_foreground.xml
│   │
│   └── libs/
│       └── versions.toml
│
└── Gradle Scripts/
    ├── build.gradle.kts (Project: Calling_App)
    ├── build.gradle.kts (Module: app)
    ├── proguard-rules.pro
    ├── gradle-wrapper.properties
    └── settings.gradle
```
---
## Getting Started

### Prerequisites
- **Android Studio** (latest version recommended)
- **Android SDK 24** or above

### Steps to Run
1. Download or clone the repository
2. Open the project in **Android Studio**
4. Sync **Gradle**
5. Run the app on an **emulator** or **physical device**

---
## 🧠 How the App Works

1. User enters into a IDLE screen **Dialer Screen**
2. User can enter a number and click on the call button to call.
3. Logs screen is also available which shows the previous call logs **Calllogs**
4. Contact Screen is also available which displays all the contacts user can click on any contact to call them **ContactScreen**

---
## ScreenShots
<img width="720" height="1600" alt="image" src="https://github.com/user-attachments/assets/1b8b69bb-da3d-4dda-85e8-6842c2c9e31b" />

---
## 🔮 Future Enhancements
- Will be adding contacts profile
- Will be adding a new interface to see calls with a user on a separate screen instead of all on Call logs
---
## Author
- **Name:** Aryan
---
