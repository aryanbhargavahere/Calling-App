package com.example.callingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.callingapp.UI.Screens.Oncallscreen
import com.example.callingapp.UI.Screens.DialerScreen
import com.example.callingapp.UI.Screens.Incomingscreen
import com.example.callingapp.UI.Screens.Outgoingscreen
import com.example.callingapp.ui.theme.CallingAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CallingAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppMain(viewModel = CallViewModel())
                }
            }
        }
    }
}

@Composable
fun AppMain (viewModel: CallViewModel) {
    val state by viewModel.uiState.collectAsState()
    val number by viewModel.dialedNumber.collectAsState()
    val time by viewModel.timerSeconds.collectAsState()

    Crossfade(targetState = state) { currentState ->
        when (currentState) {
            CallState.IDLE -> DialerScreen(number = number, vm = viewModel)
            CallState.OUTGOING -> Outgoingscreen(number, viewModel::endCall)
            CallState.INCOMING -> Incomingscreen(number, viewModel::changetoactive, viewModel::endCall)
            CallState.ACTIVE -> Oncallscreen(number, formatTime(time), viewModel::endCall)
        }
    }
}

fun formatTime(seconds: Long): String {
    val minutes = seconds / 60
    val remainingSeconds = seconds % 60
    return "%02d:%02d".format(minutes, remainingSeconds)
}