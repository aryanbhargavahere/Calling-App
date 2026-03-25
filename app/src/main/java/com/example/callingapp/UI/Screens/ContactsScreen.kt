package com.example.callingapp.UI.Screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.callingapp.utills.CallUtils
import com.example.callingapp.viewmodel.CallViewModel
import androidx.core.net.toUri
import androidx.compose.foundation.lazy.items

@Composable
fun ContactsScreen(viewModel: CallViewModel = CallViewModel()) {
    val context = LocalContext.current
    val contacts by viewModel.contacts.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadContacts(context)
    }

    LazyColumn {
        items(contacts) { contact ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        val intent = Intent(Intent.ACTION_CALL).apply {
                            data = "tel:${contact.number}".toUri()
                        }
                        context.startActivity(intent)
                    }
                    .padding(16.dp)
            ) {
                Text(contact.name)
                Text(contact.number)
            }
        }
    }
}