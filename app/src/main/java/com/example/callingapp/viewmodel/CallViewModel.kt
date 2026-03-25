package com.example.callingapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.callingapp.CallRepository
import com.example.callingapp.Calllogitem
import com.example.callingapp.Contactsclass
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CallViewModel : ViewModel() {

    private val repository = CallRepository()

    private val _callLogs = MutableStateFlow<List<Calllogitem>>(emptyList())
    val callLogs: StateFlow<List<Calllogitem>> = _callLogs

    private val _contacts = MutableStateFlow<List<Contactsclass>>(emptyList())
    val contacts: StateFlow<List<Contactsclass>> = _contacts

    fun loadCallLogs(context: Context) {
        viewModelScope.launch {
            _callLogs.value = repository.getCallLogs(context)
        }
    }

    fun loadContacts(context: Context) {
        viewModelScope.launch {
            _contacts.value = repository.getContacts(context)
        }
    }

    fun refreshLogs(context: Context) {
        loadCallLogs(context)
    }
}