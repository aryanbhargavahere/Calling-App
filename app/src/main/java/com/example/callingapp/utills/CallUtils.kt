package com.example.callingapp.utills

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.net.toUri

object CallUtils {
    fun usercalls(context: Context, number: String) {
        val intent = Intent(Intent.ACTION_CALL).apply {
            data = "tel:$number".toUri()
        }
        context.startActivity(intent)
    }
}