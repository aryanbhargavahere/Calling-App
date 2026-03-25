package com.example.callingapp

import android.content.Context
import android.provider.CallLog
import android.provider.ContactsContract
import java.text.SimpleDateFormat
import java.util.*

class CallRepository {

    fun getCallLogs(context: Context): List<Calllogitem> {
        val list = mutableListOf<Calllogitem>()

        val cursor = context.contentResolver.query(
            CallLog.Calls.CONTENT_URI,
            null, null, null,
            CallLog.Calls.DATE + " DESC"
        )

        cursor?.use {
            val numberIndex = it.getColumnIndexOrThrow(CallLog.Calls.NUMBER)
            val typeIndex = it.getColumnIndexOrThrow(CallLog.Calls.TYPE)
            val dateIndex = it.getColumnIndexOrThrow(CallLog.Calls.DATE)
            val durationIndex = it.getColumnIndexOrThrow(CallLog.Calls.DURATION)

            while (it.moveToNext()) {
                val number = it.getString(numberIndex)
                val typeInt = it.getInt(typeIndex)
                val dateLong = it.getLong(dateIndex)
                val duration = it.getString(durationIndex)

                val type = when (typeInt) {
                    CallLog.Calls.INCOMING_TYPE -> "Incoming"
                    CallLog.Calls.OUTGOING_TYPE -> "Outgoing"
                    CallLog.Calls.MISSED_TYPE -> "Missed"
                    else -> "Unknown"
                }

                val date = SimpleDateFormat(
                    "dd MMM yyyy, hh:mm a",
                    Locale.getDefault()
                ).format(Date(dateLong))

                list.add(Calllogitem(number, type, date, duration))
            }
        }

        return list
    }

    fun getContacts(context: Context): List<Contactsclass> {
        val list = mutableListOf<Contactsclass>()

        val cursor = context.contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null, null, null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )

        cursor?.use {
            val nameIndex = it.getColumnIndexOrThrow(
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
            )
            val numberIndex = it.getColumnIndexOrThrow(
                ContactsContract.CommonDataKinds.Phone.NUMBER
            )

            while (it.moveToNext()) {
                val name = it.getString(nameIndex)
                val number = it.getString(numberIndex)

                list.add(Contactsclass(name, number))
            }
        }

        return list
    }
}