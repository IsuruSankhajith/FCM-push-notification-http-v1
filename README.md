
---

# FCM Push Notification HTTP v1

This project demonstrates a basic implementation of Firebase Cloud Messaging (FCM) to send and receive push notifications using HTTP in an Android application. The app is built using **Kotlin**, **Jetpack Compose**, and integrates with **Firebase** for push notifications.

## Features

- **Send Direct Messages**: Send notifications to a specific device using a unique FCM token.
- **Broadcast Messages**: Broadcast a notification to all subscribed devices.
- **Token Management**: Retrieve and manage FCM tokens for targeted messaging.
- **Firebase Integration**: Uses Firebase Messaging Service for handling push notifications.
- **Compose UI**: Modern Android UI using Jetpack Compose.
  
## Project Structure

- **MainActivity**: Manages the UI and user interactions, including sending messages and requesting notification permissions.
- **ChatViewModel**: Handles business logic, sending requests to the server, and managing state.
- **PushNotificationService**: Handles the reception of push notifications and token generation.
- **Retrofit API**: Communicates with the backend to send messages or broadcasts via HTTP requests.
  
## How to Set Up

### Prerequisites

- Android Studio installed
- Firebase account with FCM enabled
- An Android device or emulator for testing

### Steps to Run

1. **Clone the Repository**:
   ```
   git clone https://github.com/IsuruSankhajith/fcmpushnotificationhttpv1.git
   
   ```
   
2. **Set Up Firebase**:
   - Create a new Firebase project and enable Firebase Cloud Messaging (FCM).
   - Download the `google-services.json` file from Firebase and place it in the `app/` directory of the project.

3. **Configure Backend URL**:
   - Update the `baseUrl` in `ChatViewModel.kt` with your backend server's URL if it's different from `http://10.0.2.2:8080`.

4. **Run the App**:
   - Open the project in Android Studio and sync Gradle.
   - Connect a device or emulator, then click the "Run" button.

### API Endpoints

- `POST /send`: Sends a message to a specific device based on its FCM token.
- `POST /broadcast`: Broadcasts a message to all devices.

### Permissions

Ensure the app has the following permissions in `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
```

For Android 13 (Tiramisu) and above, notification permissions are requested at runtime.

## Built With

- **Kotlin** - Programming language
- **Jetpack Compose** - Modern Android UI toolkit
- **Firebase Cloud Messaging** - Push notification service
- **Retrofit** - HTTP client for sending requests

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---
