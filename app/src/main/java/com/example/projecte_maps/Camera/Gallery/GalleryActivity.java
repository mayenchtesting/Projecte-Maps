package com.example.projecte_maps.Camera.Gallery;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projecte_maps.Camera.CameraUtils;
import com.example.projecte_maps.R;

public class GalleryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CameraUtils.getImagePaths(this);
        findViewById(R.id.btnBack).setOnClickListener(l -> finish());
    }
}
