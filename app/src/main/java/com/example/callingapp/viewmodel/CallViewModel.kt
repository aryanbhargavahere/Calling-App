package com.example.callingapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.callingapp.Calllogitem
import com.example.callingapp.Contactsclass
import com.example.callingapp.callrepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CallViewModel : ViewModel() {

    private val repository = callrepo()

    private val _callLogs = MutableStateFlow<List<Calllogitem>>(emptyList())
    val callLogs: StateFlow<List<Calllogitem>> = _callLogs

    private val _contacts = MutableStateFlow<List<Contactsclass>>(emptyList())
    val contacts: StateFlow<List<Contactsclass>> = _contacts

    fun loadCallLogs(context: Context) {
        viewModelScope.launch {
            val logs = withContext(Dispatchers.IO) {
                repository.getcalllogs(context)
            }
            _callLogs.value = logs
        }
    }

    fun loadContacts(context: Context) {
        viewModelScope.launch {
            val list = withContext(Dispatchers.IO) {
                repository.getcontacts(context)
            }
            _contacts.value = list
        }
    }
}