package com.example.callingapp.UI

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DialButton(
    digit: String,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = CircleShape,
        color = Color(0xFF0F1A1C),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = digit,
                fontSize = 28.sp,
                color = Color.White
            )
        }
    }
}