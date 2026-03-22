package com.example.callingapp.UI.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.callingapp.CallViewModel
import com.example.callingapp.UI.DialButton

@Composable
fun DialerScreen(number: String, vm: CallViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = number,
            fontSize = 48.sp,
            maxLines = 1,
            modifier = Modifier
                .height(120.dp)
                .padding(top = 40.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        val buttons = listOf("1","2","3","4","5","6","7","8","9","*","0","#")

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.height(400.dp)
        ) {
            items(buttons) { digit ->
                DialButton(digit = digit) {
                    vm.digitInput(digit)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {

            IconButton(onClick = vm::onBackspace) {
                Icon(Icons.Default.Delete, contentDescription = "Delete")
            }

            FloatingActionButton(
                onClick = vm::outgoingCall,
                containerColor = Color(0xFF5DB075),
                shape = CircleShape
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 20.dp)
                ) {
                    Icon(Icons.Default.Call, contentDescription = null, tint = Color.White)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Call", color = Color.White)
                }
            }

            TextButton(onClick = vm::incomingCall) {
                Text("Incoming")
            }
        }
    }
}