package com.example.fcmpushnotificationhttpv1

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

@Composable
fun ChatScreen(
    messageText: String,
    onMessageChanging: (String) -> Unit,
    onMessageBroadcast: () -> Unit,  // Broadcast message
    onMessageSend: () -> Unit        // Send message (corrected)
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = messageText,
            onValueChange = onMessageChanging,
            placeholder = {
                Text("Enter a message ")
            },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = onMessageSend  // Send message
            ) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Send"
                )
            }
            Spacer(Modifier.width(16.dp))

            IconButton(
                onClick = onMessageBroadcast  // Broadcast message
            ) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Broadcast"
                )
            }
        }
    }
}
