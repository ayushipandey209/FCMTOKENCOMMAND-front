package com.fcmcode.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class MyCamera extends Activity {

    private static final int CAMERA_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if the device has a camera
        PackageManager packageManager = getPackageManager();
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {
            // Intent to open the camera app
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
            } else {
                Toast.makeText(this, "No camera app found", Toast.LENGTH_SHORT).show();
                finish(); // Close the activity if no camera app is found
            }
        } else {
            Toast.makeText(this, "No camera available on this device", Toast.LENGTH_SHORT).show();
            finish(); // Close the activity if no camera is available
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            // Handle the image captured from the camera
            if (data != null && data.getExtras() != null) {
                // Do something with the image, e.g., display it in an ImageView
                Toast.makeText(this, "Image captured successfully!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Failed to capture image", Toast.LENGTH_SHORT).show();
        }

        finish(); // Close the activity after the result is handled
    }
}
