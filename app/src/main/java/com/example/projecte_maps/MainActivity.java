package com.example.projecte_maps;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projecte_maps.Camera.CameraActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnCamera).setOnClickListener(l -> startActivity(new Intent(MainActivity.this, CameraActivity.class)));
    }
}