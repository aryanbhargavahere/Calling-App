package com.example.callingapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import com.example.callingapp.viewmodel.CallViewModel

class CallReceiver : BroadcastReceiver() { // helps to identify if the call is incoming or outgoing and when its ended
    override fun onReceive(context: Context, intent: Intent) {
        val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)

        if (state == TelephonyManager.EXTRA_STATE_IDLE) {

        }
    }
}