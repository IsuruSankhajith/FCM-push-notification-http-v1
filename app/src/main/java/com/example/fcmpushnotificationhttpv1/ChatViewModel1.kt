package com.example.fcmpushnotificationhttpv1

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException

class ChatViewModel : ViewModel() {

    // Initialize the state as a MutableState
    private var _state = mutableStateOf(ChatState())
    val state: ChatState
        get() = _state.value // Provide access to the state

    private val api: FcmApi = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8080")  // For Android emulator
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(FcmApi::class.java)

    // Update the remote token in state
    fun onRemoteTokenChange(newToken: String) {
        _state.value = _state.value.copy(
            remoteToken = newToken
        )
    }

    // Submit the remote token and update the state
    fun onSubmitRemoteToken() {
        _state.value = _state.value.copy(
            isEnteringToken = false
        )
    }

    // Update message text in state
    fun onMessageChange(message: String) {
        _state.value = _state.value.copy(
            messageText = message
        )
    }

    // Send message asynchronously
    fun sendMessage(isBroadcast: Boolean) {
        viewModelScope.launch {
            val messageDto = SendMessageDto(
                to = if (isBroadcast) null else _state.value.remoteToken,
                notification = NotificationBody(
                    title = "New message!",
                    body = _state.value.messageText
                )
            )
            try {
                if (isBroadcast) {
                    api.broadcast(messageDto) // Send broadcast message
                } else {
                    api.sendMessage(messageDto) // Send message to a specific token
                }

                _state.value = _state.value.copy(
                    messageText = "" // Clear message text after sending
                )
            } catch (e: HttpException) {
                // Handle HTTP errors
                e.printStackTrace()
            } catch (e: IOException) {
                // Handle network or I/O errors
                e.printStackTrace()
            }
        }
    }
}
