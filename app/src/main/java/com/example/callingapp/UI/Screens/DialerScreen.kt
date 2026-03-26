package com.example.callingapp.UI.Screens

import android.R
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri

@Composable
fun DialerScreen() {
    val context = LocalContext.current
    var number by remember { mutableStateOf("") }

    val numbers = listOf("1","2","3", "4","5","6", "7","8","9", "*","0","#")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = number,
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.weight(1f))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            numbers.chunked(3).forEach { row ->
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    row.forEach { num ->
                        Button(
                            onClick = { number += num },
                            modifier = Modifier
                                .padding(8.dp)
                                .size(80.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black,   // black button
                                contentColor = Color.White      // white text
                            )
                        ) {
                            Text(num,
                                style=MaterialTheme.typography.headlineLarge)

                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {

                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,   // black button
                        contentColor = Color.Red     // white text
                    ),
                    onClick = {
                    if (number.isNotEmpty()) number = number.dropLast(1)
                }) {
                    Text("⌫")
                }

                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,   // black button
                        contentColor = Color.Green    // white text
                    ),onClick = {
                    val intent = Intent(Intent.ACTION_CALL).apply {
                        data = "tel:$number".toUri()
                    }
                    context.startActivity(intent)
                }) {
                    Text("Call")
                }
            }
        }
    }
}