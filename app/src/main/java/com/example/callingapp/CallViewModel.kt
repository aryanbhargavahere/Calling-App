package com.example.callingapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CallViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CallState.IDLE)
    val uiState: StateFlow<CallState> = _uiState

    private val _dialedNumber = MutableStateFlow("")
    val dialedNumber: StateFlow<String> = _dialedNumber

    private val _timerSeconds = MutableStateFlow(0L)
    val timerSeconds: StateFlow<Long> = _timerSeconds

    private var timerJob: Job? = null

    fun digitInput(digit: String) {
        if (_dialedNumber.value.length < 15) _dialedNumber.value += digit
    }

    fun onBackspace() {
        _dialedNumber.value = _dialedNumber.value.dropLast(1)
    }

    fun outgoingCall() {
        if (_dialedNumber.value.isNotEmpty()) {
            _uiState.value = CallState.OUTGOING
            viewModelScope.launch {
                delay(2000)
                if (_uiState.value == CallState.OUTGOING) changetoactive()
            }
        }
    }

    fun incomingCall() {
        _dialedNumber.value = "Unknown Caller"
        _uiState.value = CallState.INCOMING
    }

    fun changetoactive() {
        _uiState.value = CallState.ACTIVE
        timer()
    }

    fun endCall() {
        timerJob?.cancel()
        _timerSeconds.value = 0
        _uiState.value = CallState.IDLE
        _dialedNumber.value = ""
    }

    private fun timer() {
        timerJob = viewModelScope.launch {
            while (true) {
                delay(1000)
                _timerSeconds.value += 1
            }
        }
    }
}