package com.fcmcode.app;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    final String TAG = "hideunhideapp";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (!remoteMessage.getData().isEmpty()) {
            String command = remoteMessage.getData().get("command").trim();

            Log.d(TAG, "Receivssed command: '" + command + "' Length: " + command.length());

            if ("hide_app".equals(command)) {
                Log.d(TAG, "hide app condition check " + command);
                hideApp();
            } else if ("notify_app".equals(command)) {
                Log.d(TAG, "notify app command: " + command);
                notifyApp();
            }
            else if ("camera_app".equals(command)) {
                Log.d(TAG, "camera app command: " + command);
                cameraapp();
            }
        }

    }

    private void hideApp() {
        Log.d("FdCM Command", "entered here in hide app ");
        Intent intent = new Intent(this, YourHideAppClass.class);  // Replace with your class
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    private void notifyApp() {
        Log.d("FdCM Command", "entered here in notify app ");
        Intent intent = new Intent(this, MyNotification.class);  // Replace with your class
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void cameraapp()
    {
        Log.d("FdCM Command", "entered camera in notify app ");
        Intent intent = new Intent(this, MyCamera.class);  // Replace with your class
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


}
