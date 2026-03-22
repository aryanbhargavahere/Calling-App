# Calling App

A state driven calling app built using Kotlin and Jetpack Compose , demonstrating lifecycle of a
calling app

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
-  Simulates Incoming Calls  
-  Simulates Outgoing Calls 

---

## 🛠️ Tech Stack

- **Kotlin**
- **Android SDK**
- **JetPack Compose**
---

## 📂 Project Structure

```bash
com.example.callingapp
├── ui
│   ├── screens
│   │   ├── DialerScreen.kt    
│   │   ├── OutgoingScreen.kt   
│   │   ├── IncomingScreen.kt   
│   │   └── ActiveCallScreen.kt 
│   └── components
│       └── CommonUI.kt        
├── CallViewModel.kt            
└── MainActivity.kt             
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
2. User can then enter numbers and call or simulate the **Incoming Call**
3. When user clicks on floating call button theyre taken to **Outgoing Call Screen**
4. When the call is picked user is taken to **Active Call Screen**

---
## ScreenShots
<img width="720" height="1600" alt="image" src="https://github.com/user-attachments/assets/55e4a2d8-ed3f-4c5c-b315-72d37789c0b2" />
<img width="720" height="1600" alt="image" src="https://github.com/user-attachments/assets/ec0b41fa-8a07-42ea-8b47-1a2ed031ed89" />
<img width="720" height="1600" alt="image" src="https://github.com/user-attachments/assets/a483ce5c-be16-4851-9b13-33ef83e4c463" />
<img width="720" height="1600" alt="image" src="https://github.com/user-attachments/assets/a3b353f9-b3a8-4b88-8d7a-6a60cb9e79c4" />

---
## 🔮 Future Enhancements

- **I'll Add Backend**
- **Will Be Connecting It to Contacts**
- **Add Hold Option**
- **Add Video Call Option**
---
## Author
- **Name:** Aryan
---
