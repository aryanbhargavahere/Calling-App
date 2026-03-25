package com.example.callingapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager

class CallReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)

        if (state == TelephonyManager.EXTRA_STATE_IDLE) {
            // Call ended → logs auto-update next load
        }
    }
}