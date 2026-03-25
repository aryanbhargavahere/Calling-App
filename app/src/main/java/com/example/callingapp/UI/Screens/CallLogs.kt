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
import androidx.compose.foundation.lazy.items

@Composable
fun CallLogsScreen(viewModel: CallViewModel = CallViewModel()) {
    val context = LocalContext.current
    val logs by viewModel.callLogs.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadCallLogs(context)
    }

    LazyColumn {
        items(logs) { log ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        val intent = Intent(Intent.ACTION_CALL).apply {
                            data = Uri.parse("tel:${log.number}")
                        }
                        context.startActivity(intent)
                    }
                    .padding(16.dp)
            ) {
                Text(log.number)
                Text(log.type)
                Text(log.date)
                Text("Duration: ${log.duration}s")
            }
        }
    }
}