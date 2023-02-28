package com.example.projecte_maps.Camera.Gallery;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.projecte_maps.R;
import com.example.projecte_maps.Camera.CameraUtils;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {
    ArrayList<String> imagePaths = new ArrayList<>();
    ViewPager viewPager;
    GalleryPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        imagePaths = CameraUtils.getImagePaths(this);
        viewPager = findViewById(R.id.galleryViewPager);
        viewPagerAdapter = new GalleryPagerAdapter(this, imagePaths);
        viewPager.setAdapter(viewPagerAdapter);
        findViewById(R.id.btnBack).setOnClickListener(l -> finish());
    }
}
