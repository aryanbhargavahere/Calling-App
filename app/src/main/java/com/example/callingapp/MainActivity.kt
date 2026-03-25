package com.example.callingapp

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.core.app.ActivityCompat
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.callingapp.UI.Screens.CallLogsScreen
import com.example.callingapp.UI.Screens.ContactsScreen
import com.example.callingapp.UI.Screens.DialerScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.READ_CALL_LOG,
                Manifest.permission.READ_PHONE_STATE
            ),
            1
        )

        setContent {
            CallingApp()
        }
    }
}

@Composable
fun CallingApp() {

    var selectedTab by remember { mutableStateOf(0) }

    val tabs = listOf("Dialer", "Logs", "Contacts")

    Scaffold(
        topBar = {
            TabRow(selectedTabIndex = selectedTab) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = { Text(title) }
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            when (selectedTab) {
                0 -> DialerScreen()
                1 -> CallLogsScreen()
                2 -> ContactsScreen()
            }
        }
    }
}