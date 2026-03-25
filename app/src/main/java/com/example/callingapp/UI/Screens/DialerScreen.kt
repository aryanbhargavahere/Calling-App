package com.example.callingapp.UI.Screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri


@Composable
fun DialerScreen() {
    val context = LocalContext.current
    var number by remember { mutableStateOf("") }

    val numbers = listOf("1","2","3", "4","5","6", "7","8","9", "*","0","#")

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(number, style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        numbers.chunked(3).forEach { row ->
            Row {
                row.forEach { num ->
                    Button(
                        onClick = { number += num },
                        modifier = Modifier.padding(8.dp).size(80.dp)
                    ) {
                        Text(num)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Button(onClick = {
                if (number.isNotEmpty()) number = number.dropLast(1)
            }) {
                Text("⌫")
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(onClick = {
                val intent = Intent(Intent.ACTION_CALL).apply {
                    data = Uri.parse("tel:$number")
                }
                context.startActivity(intent)
            }) {
                Text("Call")
            }
        }
    }
}