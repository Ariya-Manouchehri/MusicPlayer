package com.example.musicplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_REQ_CODE = 100;
    private String[] permission = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chekforpermission();
    }

    private void chekforpermission() {
        if (ActivityCompat.checkSelfPermission(this, permission[0]) == getPackageManager().PERMISSION_GRANTED) {
            setFragment();
        } else {
            ActivityCompat.requestPermissions(this, permission, PERMISSION_REQ_CODE);
        }
    }

    private void setFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.my_container, new PlayerFragment()).commit();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQ_CODE) {
            if (grantResults[0] == getPackageManager().PERMISSION_GRANTED) {
                setFragment();
            } else {
                ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQ_CODE);
            }
        }
    }
}