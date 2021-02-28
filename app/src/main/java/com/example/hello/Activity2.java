package com.example.hello;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    private int loc_permission_code =1;
    private int cam_permission_code =2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button button_loc_req = findViewById(R.id.btn_location);
        button_loc_req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Activity2.this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(Activity2.this, "You have already granted permission for location", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    requestLocationPermission();
                }

            }

        });
        Button button_cam_req = findViewById(R.id.btn_camera);
        button_cam_req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Activity2.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(Activity2.this, "You have already granted permission to use camera", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    requestCameraPermission();
                }

            }

        });
    }
    private void requestCameraPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            new AlertDialog.Builder(this)
                    .setTitle("Permission Needed")
                    .setMessage("This permission is needed for this reason")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(Activity2.this, new String[]{Manifest.permission.CAMERA}, cam_permission_code);

                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, cam_permission_code);
        }
    }

    private void requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            new AlertDialog.Builder(this)
                    .setTitle("Permission Needed")
                    .setMessage("This permission is needed for this reason")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(Activity2.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, loc_permission_code);

                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, loc_permission_code);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == loc_permission_code )
        {
            if(grantResults.length>0 && grantResults [0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this,"Permission Granted for location",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this,"Permission Denied for location",Toast.LENGTH_SHORT).show();
        }
        if(requestCode == cam_permission_code )
        {
            if(grantResults.length>0 && grantResults [0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this,"Permission Granted for camera",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this,"Permission Denied for camera",Toast.LENGTH_SHORT).show();
        }

    }

}