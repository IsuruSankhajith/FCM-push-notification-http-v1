package com.example.fcmpushnotificationhttpv1

import android.widget.EditText
import com.squareup.moshi.JsonReader.Token

data class ChatState(
    val isEnteringToken: Boolean = true,
    val remoteToken: String = "",
    val messageText: String = "",
)
