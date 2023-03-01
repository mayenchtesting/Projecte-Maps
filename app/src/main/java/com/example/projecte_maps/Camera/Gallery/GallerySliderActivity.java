package com.example.projecte_maps.Camera.Gallery;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.projecte_maps.Objects.AppImage;
import com.example.projecte_maps.R;
import com.example.projecte_maps.Camera.CameraUtils;

import java.util.ArrayList;

public class GallerySliderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_slider);
        ArrayList<AppImage> images = new ArrayList<>();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            images = (ArrayList<AppImage>) extras.get("images");
        }
        ViewPager viewPager = findViewById(R.id.galleryViewPager);
        GalleryPagerAdapter viewPagerAdapter = new GalleryPagerAdapter(this, images);
        viewPager.setAdapter(viewPagerAdapter);
        findViewById(R.id.btnBack).setOnClickListener(l -> finish());
    }
}
